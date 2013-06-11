/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals;

import DomainControllers.IngressarPacient;

/**
 *
 * @author William
 */
public class TestAssignarMetgeIngres
{
	public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
		ip.assignarMetgeAIngres( "42872323K" );
	}	
}
