package DomainLayer.DataInterface;

import DomainLayer.DomainModel.HibernateUtil;
import DomainLayer.DomainModel.Hospital;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class CtrlHospital
{

	public CtrlHospital()
	{
	}

	public Boolean exist( String nomHosp )
	{
		if ( this.get( nomHosp ) == null )
		{
			return false;
		}
		return true;
	}

	public Hospital get( String nomHosp )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		Hospital e = ( Hospital ) session.get( Hospital.class, nomHosp );
		tx.commit();
		return e;
	}
}
