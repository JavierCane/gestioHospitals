/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import java.sql.Date;
import java.util.ArrayList;

/**
 *
 * @author William
 */
public class EnviadorInformes
{
	public EnviadorInformes()
	{
		
	}
	
	public void enviarInformeIngres( String nomEspecialitat, Date d, String nomHospital, Integer numeroHabitacio, String nTsPacient, String dniMetge, String emailPacient ) 
	{
		ServiceLocator sl = ServiceLocator.getInstance();
		ServeiInformesSanitat sis = sl.find( "serveiInformesSanitat");
		sis.
				
				
//		
//		The urlParameters is a URL encoded string.
//
//		String urlParameters =
//				"fName=" + URLEncoder.encode("???", "UTF-8") +
//				"&lName=" + URLEncoder.encode("???", "UTF-8")

	}
}
