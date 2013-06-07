package gestiohospitals;

import gestiohospitals.domini.models.Especialitat;
import gestiohospitals.domini.models.Habitacio;
import gestiohospitals.domini.models.HabitacioId;
import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Hospital;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestsHibernate
{

	/**
	 * @param args the command line arguments
	 */
	public static void main( String[] args )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		
		// Creamos un nuevo hospital
		Hospital hospitalTest1 = new Hospital( "hospital molon", "adreça de l'hospital", "descripció de l'hospital molón" );
		
		// Creamos especialidad
		Especialitat especialitat1 = new Especialitat( "espe_molona" );
		
		especialitat1.getHospitals().add( hospitalTest1 );
		
		session.save( especialitat1 );

//		// Creamos un nuevo id de habitación
//		HabitacioId habitacioId1 = new HabitacioId( 1, hospitalTest1 );
//		HabitacioId habitacioId2 = new HabitacioId( 2, hospitalTest1 );
//		
//		// Creamos un par de habitaciones y las guardamos
//		Habitacio habitacioTest1 = new Habitacio( habitacioId1, especialitat1 );
//		Habitacio habitacioTest2 = new Habitacio( habitacioId2, especialitat1 );
//		session.save( habitacioTest1 );
//		session.save( habitacioTest2 );

		// Vinculamos las habitaciones al hospital
//		Set<Habitacio> habitacionsHospital = new HashSet<>();
//		habitacionsHospital.add( habitacioTest1 );
//		habitacionsHospital.add( habitacioTest2 );
//		hospitalTest1.setHabitacio( habitacionsHospital );

		// Commiteamos a base de datos los cambios
		session.getTransaction().commit();
        session.close();

		System.out.println( hospitalTest1.toString() );
	}
}
