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
import java.util.logging.Level;
import java.util.logging.Logger;


public class ServeiInformesSanitat
{
	public ServeiInformesSanitat()
	{
		
	}

	public void enviarInformeIngres() 
	{
		final String server = "localhost";
		URL url = null;
		try {
			url = new URL("http://" + server);
			HttpURLConnection urlConn = null;
			urlConn = (HttpURLConnection) url.openConnection();
			// Let the run-time system (RTS) know that we want input.
			urlConn.setDoInput (true);
			// Let the RTS know that we want to do output.
			urlConn.setDoOutput (true);
			// No caching, we want the real thing.
			urlConn.setUseCaches (false);
			urlConn.setRequestMethod("POST");
			urlConn.connect();
			
			DataOutputStream output = null;
			DataInputStream input = null;
			output = new DataOutputStream(urlConn.getOutputStream());

			// Construct the POST data.
			String content =
			  "firstname=" + URLEncoder.encode("William") +
			  "&secondname=" + URLEncoder.encode("Friede Espinosa");
			// Send the request data.
			output.writeBytes(content);
			output.flush();
			output.close();
			// Get response data.
			String str = null;
			input = new DataInputStream (urlConn.getInputStream());
			while (null != ((str = input.readLine()))) {
				System.out.println(str);
			}
			input.close ();
		} catch (IOException ex) {
			Logger.getLogger(ServeiInformesSanitat.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
