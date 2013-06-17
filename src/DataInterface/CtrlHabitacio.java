package DataInterface;

import gestiohospitals.domini.models.Habitacio;
import gestiohospitals.domini.models.HabitacioId;
import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Hospital;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 * @author William
 */
public class CtrlHabitacio 
{
    public CtrlHabitacio() 
	{
		
    }
	public Habitacio get( String nomHosp, Integer numHab )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		Hospital c = (Hospital) session.get(Hospital.class, nomHosp);
		HabitacioId hi = new HabitacioId();
		
		hi.setHospital( c );
		hi.setNumero( numHab );
		
		Habitacio e = (Habitacio) session.get(Habitacio.class, hi);
		tx.commit();
		return e;
	}
}
