/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals;

import DomainControllers.IngressarPacient;

public class TestCreaIngres
{
	public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
		ip.creaIngres( "hospital molon", 1, "1248712");
	}
}
