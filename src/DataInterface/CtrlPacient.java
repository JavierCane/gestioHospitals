/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterface;
import gestiohospitals.domini.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
/**
 *
 * @author William
 */
public class CtrlPacient
{
	public CtrlPacient() 
	{
		
    }
	//String dni, String nom, String nTs, String email
	public Pacient get( String nTS )
	{
				// TODO  ??????
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		Pacient e = (Pacient) session.get(Pacient.class, nTS);
		tx.commit();
               // session.close();
		return e;
	}
}
