package DomainControllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ServeiInformesSanitat
{

	public ServeiInformesSanitat()
	{
	}

	public void enviarInformeIngres( String nomEspecialitat, Date dataAvui, String nomHospital, Integer numeroHabitacio, String nTsPacient, List<String> dnisMetges, String emailPacient )
	{
		final String server = "http://puntoyaporte.com/tests/sistema-sanitat/mail.php";

		URL url = null;

		try
		{
			url = new URL( server );

			HttpURLConnection urlConn = null;

			urlConn = ( HttpURLConnection ) url.openConnection();

			// Let the run-time system (RTS) know that we want input.
			urlConn.setDoInput( true );

			// Let the RTS know that we want to do output.
			urlConn.setDoOutput( true );

			// No caching, we want the real thing.
			urlConn.setUseCaches( false );
			urlConn.setRequestMethod( "POST" );
			urlConn.connect();

			DataOutputStream output = null;
			DataInputStream input = null;
			output = new DataOutputStream( urlConn.getOutputStream() );

			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			String content;
			
			if ( dnisMetges.size() == 1 )
			{
				// Construct the POST data.
				content =
					   "nomEspecialitat=" + URLEncoder.encode( nomEspecialitat )
					   + "&data=" + URLEncoder.encode( df.format( dataAvui ) )
					   + "&nomHospital=" + URLEncoder.encode( nomHospital )
					   + "&numeroHabitacio=" + URLEncoder.encode( numeroHabitacio.toString() )
					   + "&nTsPacient=" + URLEncoder.encode( nTsPacient )
					   + "&dnisMetges=" + URLEncoder.encode( dnisMetges.get( 0 ) )
					   + "&emailPacient=" + URLEncoder.encode( emailPacient );
			}
			else
			{
				// Construct the POST data.
				content =
					   "nomEspecialitat=" + URLEncoder.encode( nomEspecialitat )
					   + "&data=" + URLEncoder.encode( df.format( dataAvui ) )
					   + "&nomHospital=" + URLEncoder.encode( nomHospital )
					   + "&numeroHabitacio=" + URLEncoder.encode( numeroHabitacio.toString() )
					   + "&nTsPacient=" + URLEncoder.encode( nTsPacient )
					   + "&emailPacient=" + URLEncoder.encode( emailPacient );
			}

			// Send the request data.
			output.writeBytes( content );
			output.flush();
			output.close();

			int status = urlConn.getResponseCode();

			if ( 400 == status )
			{
				System.out.println( urlConn.getResponseMessage() );
			}
			else
			{
				// Get response data.
				String str = null;

				input = new DataInputStream( urlConn.getInputStream() );

				while ( null != ( ( str = input.readLine() ) ) )
				{
					System.out.println( str );
				}

				input.close();
			}
		}
		catch ( IOException ex )
		{
			Logger.getLogger( ServeiInformesSanitat.class.getName() ).log( Level.SEVERE, null, ex );
		}
	}

	boolean estaDisponible()
	{
		final String server = "http://puntoyaporte.com/tests/sistema-sanitat/status.php";

		try
		{
			URL url = new URL( server );

			HttpURLConnection urlConn = ( HttpURLConnection ) url.openConnection();

			// No caching, we want the real thing.
			urlConn.setUseCaches( false );
			urlConn.connect();

			if ( 200 == urlConn.getResponseCode() )
			{
				return true;
			}
			else
			{
				return false;
			}
		}
		catch ( IOException ex )
		{
			Logger.getLogger( ServeiInformesSanitat.class.getName() ).log( Level.SEVERE, null, ex );
		}

		return false;
	}
}
