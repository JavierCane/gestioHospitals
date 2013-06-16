/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterface;

import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Metge;
import gestiohospitals.domini.models.Sanitari;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

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
	public Metge get( String dni )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
                
		
                Criteria criteria = session.createCriteria(Sanitari.class);
                criteria.add(Restrictions.eq("dni", dni));
                Sanitari s= (Sanitari)criteria.list().get(0);
		Metge m = (Metge) session.get(Metge.class, s.getCodiEmpleat());
		tx.commit();
                //session.close();
		return m;
	}
}
