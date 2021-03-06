package PresentationLayer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class IngressarPacientAssignarMetgeViewCtrl
{

	private IngressarPacientAssignarMetgeView view;
	private DomainLayer.DomainControllers.IngressarPacient ingressarPacient;

	public IngressarPacientAssignarMetgeViewCtrl( String nomEsp, String nomHosp, String nTS, List<String[]> llistaMetges )
	{
		view = new IngressarPacientAssignarMetgeView();
		view.setCtrl( this );
		view.setInfoEsp( nomEsp );
		view.setInfoHosp( nomHosp );
		view.setInfoData( getDate() );
		view.setInfoNTS( nTS );
		view.mostraMetges( llistaMetges );
	}

	/**
	 * Obtiene la fecha actual.
	 *
	 * @return fecha actual
	 */
	private String getDate()
	{
		String date = new SimpleDateFormat( "dd/MM/yyyy" ).format( Calendar.getInstance().getTime() );
		return date;
	}

	/**
	 * Establece el caso de uso.
	 *
	 * @param ingressarPacient
	 */
	public void setUseCase( DomainLayer.DomainControllers.IngressarPacient ingressarPacient )
	{
		this.ingressarPacient = ingressarPacient;
	}

	/**
	 * Envia informe y captura sus excepciones en el caso de no hacerlo. El envío del informe se ha pasado a esta clase
	 * y se ha eliminado la clase de la que heredaba, "IngressarPacientBaseViewCtrl", porque al implementarla nos dimos
	 * cuenta que solo tenía una operación de una línea de código y era un tanto absurda su existencia.
	 */
	public void enviarInforme()
	{
		try
		{
			ingressarPacient.enviarInformeIngres();
			view.mostraPopUp( "S'ha ingressat correctament i s'ha notificat al servei de sanitat." );
		}
		catch ( Exception e )
		{
			if ( e.getMessage().equals( "serveiNoDisponible" ) )
			{
				view.mostraPopUp( "S'ha ingressat correctament pero no s'ha pogut notificar al servei de sanitat." );
			}
		}
		System.exit( 0 );
	}

	/**
	 * Asigna el médico dni al ingreso y envía el informe.
	 *
	 * @param dni
	 */
	public void prOkIAssignarMetge( String dni )
	{
		try
		{
			ingressarPacient.assignarMetgeAIngres( dni );
		}
		catch ( Exception e )
		{
			view.mostraMissatge( e.getMessage() );
		}
		enviarInforme();
	}
}
