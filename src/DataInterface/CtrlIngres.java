package DataInterface;

import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Ingres;
import gestiohospitals.domini.models.IngresId;
import gestiohospitals.domini.models.Pacient;
import java.sql.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CtrlIngres
{

	public CtrlIngres()
	{
	}

	public Ingres get( String nTs, Date dataInici )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Pacient p = ( Pacient ) session.get( Pacient.class, nTs );

		IngresId ii = new IngresId( dataInici, p );

		Ingres i = ( Ingres ) session.get( Ingres.class, ii );

		tx.commit();
		return i;
	}
}
