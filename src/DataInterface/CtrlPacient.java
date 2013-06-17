package DataInterface;

import gestiohospitals.domini.models.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CtrlPacient
{
	public CtrlPacient() 
	{
		
    }
	public Pacient get( String nTS )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		Pacient e = (Pacient) session.get(Pacient.class, nTS);
		tx.commit();
		return e;
	}
}
