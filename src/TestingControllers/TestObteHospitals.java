package TestingControllers;

import DomainLayer.DomainModel.Dada;
import DomainLayer.DomainControllers.IngressarPacient;
import java.util.*;

public class TestObteHospitals
{

	public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
		List llista = ip.obteHospitalsLliuresPerEspecialitat( "espe_molona" );

		Iterator it = llista.iterator();
		int cont = llista.size();
		while ( cont != 0 )
		{
			Object a = it.next();
			System.out.println( "Nom: " + ( ( Dada ) a ).getNom() );
			System.out.println( "Adreça Hospital: " + ( ( Dada ) a ).getAdreca() );
			System.out.println( "Descripcio Hospital: " + ( ( Dada ) a ).getDescripcio() );
			System.out.println( "Llistat d'habitacions lliures: " + ( ( Dada ) a ).getHabLliures() );
			System.out.println();
			--cont;
		}
	}
}
