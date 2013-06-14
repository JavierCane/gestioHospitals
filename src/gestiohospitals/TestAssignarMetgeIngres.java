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
public class TestAssignarMetgeIngres
{
	public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
		
                List llista1 = ip.obteHospitalsLliuresPerEspecialitat( "espe_molona" );
                
                Iterator it = llista1.iterator();
		int cont = llista1.size();
		while ( cont != 0 ) {
			Object a = it.next();
			System.out.println( "Nom: " + ( ( Dada ) a ).getNom() );
			System.out.println( "Adreça Hospital: " + ( ( Dada ) a ).getAdreca() );
			System.out.println( "Descripcio Hospital: " + ( ( Dada ) a ).getDescripcio() );
			System.out.println( "Llistat d'habitacions lliures: " + ( ( Dada ) a ).getHabLliures() );
			System.out.println();
			--cont;
		}
		
                ip.creaIngres( "hospital molon", 1, "1248712");
                
		
               List<String[]> llista= ip.mostraMetgesHospitalPerEspecialitat();
               
                Iterator<String[]> it1 = llista.iterator();
		int cont1 = llista.size();
		while ( cont1 != 0 ) {
			String[] a = it1.next();
			System.out.println( "CodiEmpleat: " + a[0]);
			System.out.println( "Nom: " + a[1] );
			System.out.println( "Categoria: " + a[2] );
			System.out.println();
			--cont1;
		}
                
                ip.assignarMetgeAIngres( "12823423K" );
                
                
                
	}	
}
