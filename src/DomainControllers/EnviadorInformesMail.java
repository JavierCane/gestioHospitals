/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import java.net.URLEncoder;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author William
 */
public class EnviadorInformesMail implements IEnviadorInformes
{

	@Override
	public void enviarInformeIngres( String nomEspecialitat, Date dataAvui, String nomHospital, Integer numeroHabitacio, String nTsPacient, String dniMetge, String emailPacient )
	{
		ServiceLocator sl = ServiceLocator.getInstance();
		ServeiInformesSanitat sis = sl.find( "serveiInformesSanitat" );
		
		List<String> dnisMetges = new ArrayList();
		dnisMetges.add( dniMetge );
		
		sis.enviarInformeIngres( nomEspecialitat, dataAvui, nomHospital, numeroHabitacio, nTsPacient, dnisMetges, emailPacient );
	}
}
