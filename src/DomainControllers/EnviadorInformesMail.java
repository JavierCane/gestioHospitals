/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import java.sql.Date;

/**
 *
 * @author William
 */
public class EnviadorInformesMail implements IEnviadorInformes
{
	
	@Override
	public void enviarInformeIngres( String nomEspecialitat, Date d, String nomHospital, Integer numeroHabitacio, String nTsPacient, String dniMetge, String emailPacient )
	{
	ServiceLocator sl = ServiceLocator.getInstance();
	ServeiInformesSanitat sis = sl.find( "serveiInformesSanitat");
	sis.enviarInformeIngres();
	}
	

}
