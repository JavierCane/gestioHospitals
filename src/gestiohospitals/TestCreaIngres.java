/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals;

import gestiohospitals.domini.models.*;
import DomainControllers.IngressarPacient;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestCreaIngres
{
	public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
		ip.creaIngres( "hospital molon", 1, "1248712");
	}
//	ip.creaIngres ( "hospital molon", "1", "65468432" );
}
