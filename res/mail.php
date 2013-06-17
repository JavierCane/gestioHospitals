<?php

namespace SistemaSalut;

require_once "Mail.php";

/**
 * Clase para el envío de mails.
 *
 * Class HomeCtrl
 * @package SistemaSalut
 */
class HomeCtrl
{

	/**
	 * Expresión regular para validar el correcto formato de las direcciones de email.
	 */
	const VALID_EMAIL_REGEXP = '/^[A-Z0-9._%\-+]+@(?:[A-Z0-9\-]+\.)+(?:[A-Z]{2}|com|edu|org|net|biz|info|name|aero|biz|info|jobs|travel|museum|name|cat|asia|coop|jobs|mobi|tel|pro|arpa|gov|mil)$/i';

	/**
	 * Parámetros de conexión al servidor de envío de correos.
	 *
	 * @var array
	 */
	private $email_server_config = array(
		'host'     => 'ssl://smtp.gmail.com',
		'port'     => '465',
		'auth'     => true,
		'username' => 'sistema.sanitat@gmail.com',
		'password' => 'lerele123'
	);

	/**
	 * Cabecera del email a enviar.
	 *
	 * @var array
	 */
	private $email_headers = array(
		'From'         => "sistema.sanitat@gmail.com",
		'To'           => null,
		'Reply-To'     => "no-reply@sistema-sanitat.cat",
		'Subject'      => "[Sistema salut] Confirmació nou ingrés",
		'MIME-Version' => "1.0",
		'Content-Type' => "text/html; charset=ISO-8859-1",
	);

	/**
	 * Contenido/Cuerpo del email a enviar.
	 *
	 * @var String
	 */
	private $email_body;

	/**
	 * Campos a recibir por POST para poder enviar el email.
	 * Su existencia y correcto formato serán comprobados.
	 *
	 * @var array
	 */
	private $post_fields = array(
		'email'        => 'emailPacient',
		'especialitat' => 'nomEspecialitat',
		'data'         => 'data',
		'hospital'     => 'nomHospital',
		'habitacio'    => 'numeroHabitacio',
		'n_ts_pacient' => 'nTsPacient',
		'dni_metge'    => 'dnisMetges'
	);

	/**
	 * Valores de los campos recibidos por POST para poder enviar el email.
	 *
	 * @var array
	 */
	private $post_values = array(
		'email'        => null,
		'especialitat' => null,
		'data'         => null,
		'hospital'     => null,
		'habitacio'    => null,
		'n_ts_pacient' => null,
		'dni_metge'    => null
	);

	/**
	 * Obtiene todos los datos recibidos por POST en base a los atributos de clase.
	 * Construye el cuerpo del email en base a todos estos valores.
	 * Envía el email al destinatario.
	 */
	public function constructAndSendEmail()
	{
		$this->getPostData();

		$this->email_headers['To'] = $this->post_values['email'];

		$this->setEmailBody();

		$this->sendEmail();
	}

	/**
	 * Establece el contenido del atributo de clase $post_values en función de los campos $post_fields.
	 * Comprueba que estén establecidos y que su contenido sea válido. En caso que no cumpla, se lanzará un error 400.
	 */
	private function getPostData()
	{
		// Por cada campo a recibir por POST, valido su existencia y su correcto formato
		foreach ( $this->post_fields as $field_name => $field_post_key )
		{
			if ( isset( $_POST[$field_post_key] ) || 'dni_metge' == $field_name )
			{
				// Si es de tipo email, valido explícitamente que cumpla el formato establecido y exista
				if ( 'email' == $field_name )
				{
					if ( false == ( $this->post_values[$field_name] = $this->getPostEmail( $field_post_key ) ) )
					{
						$this->returnInvalidFieldException( $field_post_key, 'not valid' );
					}
				}
				else
				{
					if ( false == ( $this->post_values[$field_name] = $this->getPostString( $field_post_key ) ) && 'dni_metge' != $field_name )
					{
						$this->returnInvalidFieldException( $field_post_key, 'not valid' );
					}
				}
			}
			else // Si no me pasan el campo, lanzo una excepción de campo inválido
			{
				$this->returnInvalidFieldException( $field_post_key, 'not set' );
			}
		}
	}

	/**
	 * Devuelvo un error 400 (HTTP Bad Request) conforme el campo $field incumple la recondición del servicio por el motivo $reason.
	 *
	 * @param $field String
	 * @param $reason String
	 */
	private function returnInvalidFieldException( $field, $reason )
	{
		http_response_code( 400 );
		header( 'HTTP/ 400 ' . $field . ' field ' . $reason . '.' );
		echo 'KO: ' . $field . ' field ' . $reason . '.';
		exit( 0 );
	}

	/**
	 * Establece el contenido del email ($this->email_body) en función de los valores ya establecidos en $this->post_values.
	 */
	private function setEmailBody()
	{
		$this->email_body = "
<h1>Confirmació nou ingrés</h1>
<p>S'ha donat d'alta el teu ingrés amb les seguents dades:</p><dl>";

		foreach ( $this->post_values as $field_name => $field_value )
		{
			$this->email_body .= "<dt>" . ucwords( str_replace( '_', ' ', $field_name ) ) . ":</dt>";
			$this->email_body .= "<dd>" . $field_value . "</dd>";
		}

		$this->email_body .= "</dl>";
	}

	/**
	 * Envía el email con contenido $this->email_body auteticándose por SMTO mediante
	 * los parámetros de configuración establecidos en $this->email_server_config y
	 * las cabeceras $this->email_headers.
	 *
	 * Si todo va bien, imprime por pantalla el mensaje "OK", si no, muestra "KO" seguido del motivo por el cuál no se ha podido enviar el email.
	 */
	private function sendEmail()
	{
		$smtp = \Mail::factory( 'smtp', $this->email_server_config );

		$mail = $smtp->send( $this->email_headers['To'], $this->email_headers, $this->email_body );

		if ( \PEAR::isError( $mail ) )
		{
			echo( "KO: " . $mail->getMessage() );
		}
		else
		{
			echo( "OK" );
		}
	}

	/**
	 * Devuelve el contenido de la variable con nombre $var_name recibida por POST.
	 * Por defecto, "sanitiza" el valor de dicha variable para evitar gañanadas.
	 *
	 * @param $var_name
	 * @param bool $sanitized
	 * @return bool|mixed|string
	 */
	private function getPostString( $var_name, $sanitized = true )
	{
		if ( !isset( $_POST[$var_name] ) )
		{
			return false;
		}

		if ( false === $sanitized )
		{
			return filter_var( $_POST[$var_name], FILTER_DEFAULT );
		}
		else
		{
			return strip_tags( filter_var( $_POST[$var_name], FILTER_SANITIZE_STRING, FILTER_FLAG_ENCODE_LOW ) );
		}
	}

	/**
	 * Devuelve el email recibido por POST en la variable con nombre $var_name.
	 * Valida que tenga una estructura de email correcta.
	 * Por defecto, comprueba los registros DNS para validar que efectivamente se trata de un email válido.
	 *
	 * @param $var_name
	 * @param bool $check_dns
	 * @return bool
	 */
	private function getPostEmail( $var_name, $check_dns = true )
	{
		if ( !isset( $_POST[$var_name] ) )
		{
			return false;
		}

		if ( preg_match( self::VALID_EMAIL_REGEXP, $_POST[$var_name] ) )
		{
			if ( $check_dns )
			{
				$exploded_email = explode( '@', $_POST[$var_name] );
				return ( checkdnsrr( $exploded_email[1], 'MX' ) ? $_POST[$var_name] : false );
			}
			else
			{
				return $_POST[$var_name];
			}
		}

		return false;
	}
}

$home = new HomeCtrl();

$home->constructAndSendEmail();

