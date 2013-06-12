/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterface;

import gestiohospitals.domini.models.Habitacio;
import gestiohospitals.domini.models.HabitacioId;
import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Hospital;
import gestiohospitals.domini.models.Metge;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author William
 */
public class CtrlMetge
{
	public CtrlMetge() 
	{
		
    }
	//String dni, String nom, String nTs, String email
	public Metge get( String codiEmpleat )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		Metge c = (Metge) session.get(Metge.class, codiEmpleat);		
		tx.commit();
                //session.close();
		return c;
	}
}
