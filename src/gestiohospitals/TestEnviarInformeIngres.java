/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals;

import DomainControllers.IngressarPacient;
import gestiohospitals.domini.models.Dada;
import java.util.Iterator;
import java.util.List;

/**
 *
 * @author William
 */
public class TestEnviarInformeIngres
{
		public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
	
		List llista1 = ip.obteHospitalsLliuresPerEspecialitat( "espe_molona" );
		ip.creaIngres( "hospital molon", 1, "1248712");
		List<String[]> llista= ip.mostraMetgesHospitalPerEspecialitat();
		ip.enviarInformeIngres();
		
	}
}
