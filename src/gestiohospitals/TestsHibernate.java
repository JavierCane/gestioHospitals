package gestiohospitals;

import gestiohospitals.domini.models.Especialitat;
import gestiohospitals.domini.models.Habitacio;
import gestiohospitals.domini.models.HabitacioId;
import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Hospital;
import gestiohospitals.domini.models.Infermera;
import gestiohospitals.domini.models.Ingres;
import gestiohospitals.domini.models.IngresId;
import gestiohospitals.domini.models.Metge;
import gestiohospitals.domini.models.Pacient;
import gestiohospitals.domini.models.Sanitari;
import java.sql.Date;
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
		session.saveOrUpdate( hospitalTest1 );
		
		// Creamos especialidad
		Especialitat especialitat1 = new Especialitat( "espe_molona" );
		especialitat1.getHospitals().add( hospitalTest1 );
		session.saveOrUpdate( especialitat1 );
		
		// Creamos paciente
		Pacient pacient1 = new Pacient( "42872323K", "persona mundial", "1248712", "sjhvwkbgw@at.com" );
		session.saveOrUpdate( pacient1 );

		// Creamos sanitario
		Sanitari sanitari1 = new Sanitari( "1248712", hospitalTest1, "42872323K", "sanitari mundial" );
		session.saveOrUpdate( sanitari1 );
		session.saveOrUpdate( pacient1 );

		// Creamos enfermera
		Infermera infermera1 = new Infermera( "nit", "7962354", hospitalTest1, "42823423K", "infermera mundial" );
		session.saveOrUpdate( infermera1 );
		session.saveOrUpdate( pacient1 );

		// Creamos médico
		Metge metge1 = new Metge( "categoría p0fesioná", especialitat1, "76576", hospitalTest1, "12823423K", "metge mundial" );
		session.saveOrUpdate( metge1 );
		
		// Creamos un nuevo id de habitación
		HabitacioId habitacioId1 = new HabitacioId( 1, hospitalTest1 );
		HabitacioId habitacioId2 = new HabitacioId( 2, hospitalTest1 );
		
		// Creamos un par de habitaciones y las guardamos
		Habitacio habitacioTest1 = new Habitacio( habitacioId1, especialitat1 );
		Habitacio habitacioTest2 = new Habitacio( habitacioId2, especialitat1 );
		session.saveOrUpdate( habitacioTest1 );
		session.saveOrUpdate( habitacioTest2 );
                
		IngresId ingresid1=new IngresId( new Date(3,4,2013), pacient1 );



	   Ingres ingres1=new Ingres(ingresid1,new Date(5,4,2013),habitacioTest1,metge1);
	   session.saveOrUpdate(ingres1);
                

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
