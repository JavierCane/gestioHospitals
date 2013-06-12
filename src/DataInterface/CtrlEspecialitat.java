package DataInterface;
import gestiohospitals.domini.models.*;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 * @author William
 */
public class CtrlEspecialitat {
    private SessionFactory factory;
	
    public CtrlEspecialitat() {
        AnnotationConfiguration configuration = new AnnotationConfiguration();
		/*
		configuration.addAnnotatedClass(Especialitat.class);
		configuration.addAnnotatedClass(Hospital.class);
		configuration.addAnnotatedClass(Ingres.class);
		configuration.addAnnotatedClass(Habitacio.class);
		configuration.addAnnotatedClass(Pacient.class);
		configuration.addAnnotatedClass(Sanitari.class);
		configuration.addAnnotatedClass(Metge.class);
		*/
		configuration.configure("hibernate.cfg.xml");
		factory = configuration.buildSessionFactory();
    }
	
	public Especialitat get( String nomEsp ) {
		// TODO  ??????
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		
		Especialitat e = (Especialitat) session.get(Especialitat.class, nomEsp);
		
		tx.commit();
                //session.close();
		return e;
		
	}
}
