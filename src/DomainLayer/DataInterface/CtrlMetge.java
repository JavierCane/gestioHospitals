package DomainLayer.DataInterface;

import DomainLayer.DomainModel.HibernateUtil;
import DomainLayer.DomainModel.Metge;
import DomainLayer.DomainModel.Sanitari;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

public class CtrlMetge
{

	public CtrlMetge()
	{
	}

	public Metge get( String dni )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();

		Criteria criteria = session.createCriteria( Sanitari.class );
		criteria.add( Restrictions.eq( "dni", dni ) );

		Sanitari s = ( Sanitari ) criteria.list().get( 0 );
		Metge m = ( Metge ) session.get( Metge.class, s.getCodiEmpleat() );
		tx.commit();
		return m;
	}
}
