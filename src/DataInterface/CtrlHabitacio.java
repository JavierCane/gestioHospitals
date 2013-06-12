package DataInterface;

import gestiohospitals.domini.models.Habitacio;
import gestiohospitals.domini.models.HabitacioId;
import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Hospital;
import java.util.Date;
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
	//String dni, String nom, String nTs, String email
	public Habitacio get( String nomHosp, Integer numHab )
	{
				// TODO  ??????
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
//		HabitacioId hi = new HabitacioId
		
		
//		public Viatge get(String dni, Date dataInici) {
//			// TODO  ??????
//			Session session = factory.getCurrentSession();
//			Transaction tx = session.beginTransaction();
//
//			Client c = (Client) session.get(Client.class, dni);
//
//			CmpKeyViatge vk = new CmpKeyViatge();
//			vk.setClient(c);
//			vk.setDataInici(dataInici);
//			Viatge v = (Viatge) session.get(Viatge.class, vk);
//			tx.commit();
//			return v;
//		}
		
		Hospital c = (Hospital) session.get(Hospital.class, nomHosp);
		HabitacioId hi = new HabitacioId();
		
		hi.setHospital( c );
		hi.setNumero( numHab );
		
		Habitacio e = (Habitacio) session.get(Habitacio.class, hi);
		tx.commit();
                //session.close();
		return e;
	}
}
