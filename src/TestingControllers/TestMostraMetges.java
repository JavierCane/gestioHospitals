package TestingControllers;

import DomainLayer.DomainControllers.IngressarPacient;
import java.util.Iterator;
import java.util.List;

public class TestMostraMetges
{

	public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
		List llista1 = ip.obteHospitalsLliuresPerEspecialitat( "espe_molona" );
		ip.creaIngres( "hospital molon", 1, "1248712" );
		List<String[]> llista = ip.mostraMetgesHospitalPerEspecialitat();

		Iterator<String[]> it = llista.iterator();
		int cont = llista.size();
		while ( cont != 0 )
		{
			String[] a = it.next();
			System.out.println( "Categoria: " + a[0] );
			System.out.println( "DNI: " + a[1] );
			System.out.println( "Nom: " + a[2] );
			System.out.println();
			--cont;
		}
	}
}
