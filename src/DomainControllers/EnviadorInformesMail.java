package DomainControllers;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class EnviadorInformesMail implements IEnviadorInformes
{

	@Override
	public void enviarInformeIngres( String nomEspecialitat, Date dataAvui, String nomHospital, Integer numeroHabitacio, String nTsPacient, String dniMetge, String emailPacient ) throws Exception
	{
		ServiceLocator sl = ServiceLocator.getInstance();
		ServeiInformesSanitat sis = sl.find( "serveiInformesSanitat" );

		if ( !sis.estaDisponible() )
		{
			throw new Exception( "serveiNoDisponible" );
		}
		else
		{
			List<String> dnisMetges = new ArrayList();

			if ( null != dniMetge )
			{
				dnisMetges.add( dniMetge );
			}

			sis.enviarInformeIngres( nomEspecialitat, dataAvui, nomHospital, numeroHabitacio, nTsPacient, dnisMetges, emailPacient );
		}
	}
}
