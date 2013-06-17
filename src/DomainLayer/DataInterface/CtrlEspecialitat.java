package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Especialitat;
import DomainLayer.DomainModel.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

public class CtrlEspecialitat
{

	private SessionFactory factory;

	public CtrlEspecialitat()
	{
		AnnotationConfiguration configuration = new AnnotationConfiguration();
		configuration.configure( "hibernate.cfg.xml" );
		factory = configuration.buildSessionFactory();
	}

	public Especialitat get( String nomEsp )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		Especialitat e = ( Especialitat ) session.get( Especialitat.class, nomEsp );

		tx.commit();
		return e;

	}
}
