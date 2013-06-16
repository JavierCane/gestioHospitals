package gestiohospitals;

import gestiohospitals.domini.models.*;
import DomainControllers.IngressarPacient;
import java.util.*;

public class TestObteHospitals
{

	public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
		List llista = ip.obteHospitalsLliuresPerEspecialitat( "espe_molona" );
		
		//printo
		Iterator it = llista.iterator();
		int cont = llista.size();
		while ( cont != 0 ) {
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


/*
 String[][]
 for ( UsuariHex usuari_classificat : classificacio )
  {
   if ( usuari_classificat.getTipusJugador() == TipusJugadors.JUGADOR )
   {
    comprovaTempsMinim( usuari_classificat.getTempsMinim(), usuari_classificat.getNom() );
   }
  }

 */