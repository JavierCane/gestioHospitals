/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.DataOutputStream;
import java.io.DataInputStream;
import java.sql.Date;
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

		try {
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

			// Construct the POST data.
			String content =
				   "nomEspecialitat=" + URLEncoder.encode( nomEspecialitat )
				   + "&data=" + URLEncoder.encode( dataAvui.toString() )
				   + "&nomHospital=" + URLEncoder.encode( nomHospital )
				   + "&numeroHabitacio=" + URLEncoder.encode( numeroHabitacio.toString() )
				   + "&nTsPacient=" + URLEncoder.encode( nTsPacient )
				   + "&dnisMetges=" + URLEncoder.encode( dnisMetges.get( 0 ) )
				   + "&emailPacient=" + URLEncoder.encode( emailPacient );

			// Send the request data.
			output.writeBytes( content );
			output.flush();
			output.close();

			int status = urlConn.getResponseCode();

			if ( 400 == status ) {
				// TODO: En vez de sacar por consola el urlConn.getResponseMessage(), mostrarlo como error en presentación.
				System.out.println( urlConn.getResponseMessage() );
			}
			else {
				// Get response data.
				String str = null;

				input = new DataInputStream( urlConn.getInputStream() );

				while ( null != ( ( str = input.readLine() ) ) ) {
					System.out.println( str );
				}

				input.close();
			}
		}
		catch ( IOException ex ) {
			Logger.getLogger( ServeiInformesSanitat.class.getName() ).log( Level.SEVERE, null, ex );
		}
	}
}
