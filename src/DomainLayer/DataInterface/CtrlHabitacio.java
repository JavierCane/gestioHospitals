package DomainLayer.DataInterface;

import DomainLayer.DomainModel.Habitacio;
import DomainLayer.DomainModel.HabitacioId;
import DomainLayer.DomainModel.HibernateUtil;
import DomainLayer.DomainModel.Hospital;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

		Hospital c = ( Hospital ) session.get( Hospital.class, nomHosp );
		HabitacioId hi = new HabitacioId();

		hi.setHospital( c );
		hi.setNumero( numHab );

		Habitacio e = ( Habitacio ) session.get( Habitacio.class, hi );
		tx.commit();
		return e;
	}
}
