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
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class TestsHibernate
{

	public static void main( String[] args )
	{
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();

		// Creamos un nuevo hospital
		Hospital hospitalTest1 = new Hospital( "hospital molon", "adreça de l'hospital", "descripció de l'hospital molón" );
		Hospital hospitalTest2 = new Hospital( "hospital molon2", "adreça de l'hospital", "descripció de l'hospital molón" );
		session.saveOrUpdate( hospitalTest1 );
		session.saveOrUpdate( hospitalTest2 );

		// Creamos especialidad
		Especialitat especialitat1 = new Especialitat( "espe_molona" );
		Especialitat especialitat2 = new Especialitat( "espe_molona2" );
		especialitat1.getHospitals().add( hospitalTest1 );
		especialitat1.getHospitals().add( hospitalTest2 );
		especialitat2.getHospitals().add( hospitalTest2 );
		especialitat2.getHospitals().add( hospitalTest1 );
		session.saveOrUpdate( especialitat1 );
		session.saveOrUpdate( especialitat2 );

		// Creamos paciente
		Pacient pacient1 = new Pacient( "42872323K", "persona mundial", "1248712", "javier.mailserio@gmail.com" );
		Pacient pacient2 = new Pacient( "5627831K", "persona mundial2", "4321712", "sjhgw@at.com" );

		session.saveOrUpdate( pacient1 );
		session.saveOrUpdate( pacient2 );


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
		Metge metge2 = new Metge( "categoría p0fesioná", especialitat1, "43212", hospitalTest1, "12321423K", "metge mundial2" );
		Metge metge3 = new Metge( "categoría p0fesioná", especialitat1, "46512", hospitalTest2, "12321423K", "metge mundial2" );

		session.saveOrUpdate( metge1 );
		session.saveOrUpdate( metge2 );

		// Creamos un nuevo id de habitación
		HabitacioId habitacioId1 = new HabitacioId( 1, hospitalTest1 );
		HabitacioId habitacioId2 = new HabitacioId( 2, hospitalTest1 );
		HabitacioId habitacioId3 = new HabitacioId( 3, hospitalTest1 );
		HabitacioId habitacioId4 = new HabitacioId( 1, hospitalTest2 );
		HabitacioId habitacioId5 = new HabitacioId( 2, hospitalTest2 );

		// Creamos un par de habitaciones y las guardamos
		Habitacio habitacioTest1 = new Habitacio( habitacioId1, especialitat1 );
		Habitacio habitacioTest2 = new Habitacio( habitacioId2, especialitat1 );
		Habitacio habitacioTest3 = new Habitacio( habitacioId3, especialitat2 );
		Habitacio habitacioTest4 = new Habitacio( habitacioId4, especialitat2 );
		Habitacio habitacioTest5 = new Habitacio( habitacioId5, especialitat1 );
		session.saveOrUpdate( habitacioTest1 );
		session.saveOrUpdate( habitacioTest2 );
		session.saveOrUpdate( habitacioTest3 );
		session.saveOrUpdate( habitacioTest4 );
		session.saveOrUpdate( habitacioTest5 );

		IngresId ingresid1 = new IngresId( new Date( 3, 4, 2013 ), pacient1 );



		Ingres ingres1 = new Ingres( ingresid1, new Date( 5, 4, 2013 ), habitacioTest1, metge1 );
		session.saveOrUpdate( ingres1 );


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
