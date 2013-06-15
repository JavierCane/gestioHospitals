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
public interface IEnviadorInformes
{
	public void enviarInformeIngres( String nomEspecialitat, Date d, String nomHospital, Integer numeroHabitacio, String nTsPacient, String dniMetge, String emailPacient ) throws Exception;
}
