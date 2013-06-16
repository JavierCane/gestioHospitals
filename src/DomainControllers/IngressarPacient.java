package DomainControllers;

import DataInterface.CtrlDataFactoria;
import gestiohospitals.domini.models.*;
import DataInterface.*;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class IngressarPacient
{

	private String nomEspecialitat;
	private String nomHospital;
	private Integer numeroHabitacio;
	private String nTsPacient;
	private String dniMetge;
	private AssignarMetgeIngres assignarMetgeIngres;

	/*
	 * Seguint amb el disseny del diagrama de sequencia, es guarda el nom de l'especialitat i s'instancia la classe ConsultarHospitalsLliuresPerEspecialitat per després cridar l'operacio de getHospitalsLliuresPerEspecialitat
	 */
	public List obteHospitalsLliuresPerEspecialitat( String nomEsp ) throws Exception
	{
		//: Set( TupleType( nom:String, adreça:String, descripció:String, habLliures:Set( núm: Integer )))
		nomEspecialitat = nomEsp;
		ConsultarHospitalsLliuresPerEspecialitat c = new ConsultarHospitalsLliuresPerEspecialitat();
		return c.getHospitalsLliuresPerEspecialitat( nomEsp );
	}

	/*
	 * Seguint amb el disseny del diagrama de sequencia, fem una crida de l'instancia de la factoria, on després demanem tots els controladors necessaries per a demanar els objectes que necessitem per treballar: Pacient, Hospital i Habitacio. Seguidament fem una crida a la constructua de la classe ingres. Despres de crear l'instancia, es fan crides a hibernate per reflectir els canvis en la BD.
	 */
	public void creaIngres( String nomHosp, Integer numHab, String nTS ) throws Exception
	{
		CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
		CtrlPacient ctrlPacient = ctrlDataFactoria.getCtrlPacient();
		Pacient pacient = ctrlPacient.get( nTS );

		if ( null == pacient )
		{
			throw new Exception( "pacientNoExisteix" );
		}

		CtrlHabitacio ctrlHabitacio = ctrlDataFactoria.getCtrlHabitacio();
		Habitacio habitacio = ctrlHabitacio.get( nomHosp, numHab );

		Ingres ingres = new Ingres( pacient, habitacio );

		nomHospital = nomHosp;
		numeroHabitacio = numHab;
		nTsPacient = nTS;

		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate( ingres );
		session.getTransaction().commit();
	}

	public List<String[]> mostraMetgesHospitalPerEspecialitat() throws Exception
	{
		AssignarMetgeIngres ami = new AssignarMetgeIngres();
		assignarMetgeIngres = ami;
		List<String[]> result = assignarMetgeIngres.getMetgesHospitalPerEspecialitat( nomHospital, nomEspecialitat );
		return result;
	}

	public void assignarMetgeAIngres( String dni ) throws Exception
	{
		AssignarMetgeIngres aMi = new AssignarMetgeIngres();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date( utilDate.getTime() );
		assignarMetgeIngres.setMetgeAIngres( dni, nTsPacient, sqlDate );
		dniMetge = dni;
	}

	public void enviarInformeIngres() throws Exception
	{
		CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
		CtrlPacient ctrlPacient = ctrlDataFactoria.getCtrlPacient();
		Pacient pacient = ctrlPacient.get( nTsPacient );

		EnviadorInformesFactoria enviadorInformesFactoria = EnviadorInformesFactoria.getInstance();
		EnviadorInformesMail enviadorInformesMail = enviadorInformesFactoria.getEnviadorInformes();

		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date( utilDate.getTime() );
		enviadorInformesMail.enviarInformeIngres( nomEspecialitat, sqlDate, nomHospital, numeroHabitacio, nTsPacient, dniMetge, pacient.getEmail() );
	}
}
