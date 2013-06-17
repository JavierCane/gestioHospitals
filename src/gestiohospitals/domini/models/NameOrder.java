package gestiohospitals.domini.models;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class NameOrder implements OrderStrategy
{

	@Override
	public void ordenar( List<String[]> metges )
	{

		Collections.sort( metges, new Comparator()
		{
			@Override
			public int compare( Object o1, Object o2 )
			{
				String[] a1 = ( String[] ) o1;
				String[] a2 = ( String[] ) o2;
				String nombre1 = a1[1];
				String nombre2 = a2[1];
				return nombre1.compareTo( nombre2 );
			}
		} );
	}
}
