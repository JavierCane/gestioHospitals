/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import sun.net.www.http.HttpClient;

/**
 *
 * @author William
 */
public class ServeiInformesSanitat
{
	public ServeiInformesSanitat()
	{
		
	}
	/*
	public static String excutePost(String targetURL, String urlParameters)
	{
		URL url;
		HttpURLConnection connection = null;  
		try {
		  //Create connection
		  url = new URL(targetURL);
		  connection = (HttpURLConnection)url.openConnection();
		  connection.setRequestMethod("POST");
		  connection.setRequestProperty("Content-Type", 
			   "application/x-www-form-urlencoded");

		  connection.setRequestProperty("Content-Length", "" + 
				   Integer.toString(urlParameters.getBytes().length));
		  connection.setRequestProperty("Content-Language", "en-US");  

		  connection.setUseCaches (false);
		  connection.setDoInput(true);
		  connection.setDoOutput(true);

		  //Send request
		  DataOutputStream wr = new DataOutputStream (
					  connection.getOutputStream ());
		  wr.writeBytes (urlParameters);
		  wr.flush ();
		  wr.close ();

		  //Get Response	
		  InputStream is = connection.getInputStream();
		  BufferedReader rd = new BufferedReader(new InputStreamReader(is));
		  String line;
		  StringBuffer response = new StringBuffer(); 
		  while((line = rd.readLine()) != null) {
			response.append(line);
			response.append('\r');
		  }
		  rd.close();
		  return response.toString();

		} catch (Exception e) {

		  e.printStackTrace();
		  return null;

		} finally {
		  if(connection != null) {
			connection.disconnect(); 
		  }
		}
	  }*/
	
	
	public void enviarInformeIngres() 
	{
		HttpClient httpclient = new DefaultH
				DefaultHttpClient();
		HttpPost httppost = new HttpPost("http://www.a-domain.com/foo/");

		// Request parameters and other properties.
		List<NameValuePair> params = new ArrayList<NameValuePair>(2);
		params.add(new BasicNameValuePair("param-1", "12345"));
		params.add(new BasicNameValuePair("param-2", "Hello!"));
		httppost.setEntity(new UrlEncodedFormEntity(params, "UTF-8"));

		//Execute and get the response.
		HttpResponse response = httpclient.execute(httppost);
		HttpEntity entity = response.getEntity();

		if (entity != null) 
		{
			InputStream instream = entity.getContent();
			try 
			{
				// do something useful
			} finally {
				instream.close();
			}
		}
	}
}
