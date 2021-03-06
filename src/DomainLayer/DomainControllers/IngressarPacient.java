package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.CtrlHabitacio;
import DomainLayer.DataInterface.CtrlPacient;
import DomainLayer.DataInterface.CtrlDataFactoria;
import DomainLayer.DomainModel.Ingres;
import DomainLayer.DomainModel.HibernateUtil;
import DomainLayer.DomainModel.Habitacio;
import DomainLayer.DomainModel.Pacient;
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

	/**
	 * Seguint amb el disseny del diagrama de sequencia, es guarda el nom de l'especialitat i s'instancia la classe
	 * ConsultarHospitalsLliuresPerEspecialitat per després cridar l'operacio de getHospitalsLliuresPerEspecialitat
	 *
	 * @param nomEsp
	 *
	 * @return
	 * @throws Exception
	 */
	public List obteHospitalsLliuresPerEspecialitat( String nomEsp ) throws Exception
	{
		nomEspecialitat = nomEsp;
		ConsultarHospitalsLliuresPerEspecialitat c = new ConsultarHospitalsLliuresPerEspecialitat();
		return c.getHospitalsLliuresPerEspecialitat( nomEsp );
	}

	/**
	 * Seguint amb el disseny del diagrama de sequencia, fem una crida de l'instancia de la factoria, on després demanem
	 * tots els controladors necessaries per a demanar els objectes que necessitem per treballar: Pacient, Hospital i
	 * Habitacio. Seguidament fem una crida a la constructua de la classe ingres. Despres de crear l instancia, es fan
	 * crides a hibernate per reflectir els canvis en la BD.
	 *
	 * @param nomHosp
	 * @param numHab
	 * @param nTS
	 *
	 * @throws Exception
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

	/**
	 * Seguint el disseny del diagrama de seqüencia, crea una instancia del controlador de cas d'ús assignar metge
	 * ingres, reutilitzant la funció getMetgesHospitalPerEspecialitat. Guardem l'instancia del controlador de cas d'us
	 * per després utilitzar-lo en la funcio assignarMetgeAIngres
	 *
	 * @return
	 * @throws Exception
	 */
	public List<String[]> mostraMetgesHospitalPerEspecialitat() throws Exception
	{
		AssignarMetgeIngres ami = new AssignarMetgeIngres();
		assignarMetgeIngres = ami;
		List<String[]> result = assignarMetgeIngres.getMetgesHospitalPerEspecialitat( nomHospital, nomEspecialitat );
		return result;
	}

	/**
	 * Seguint el disseny del diagrama de seqüencia, reutilitzem la funció setMetgeAIngres del controlador cas d'ús
	 * assignar metge ingres, instanciat a la funció anterior.
	 *
	 * @param dni
	 *
	 * @throws Exception
	 */
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
