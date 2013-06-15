package DomainControllers;

import DataInterface.CtrlDataFactoria;
import DataInterface.CtrlEspecialitat;
import gestiohospitals.domini.models.*;
import DataInterface.*;
import java.util.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 * @author William
 */
public class IngressarPacient {
    private String nomEspecialitat;
    private String nomHospital;
    private Integer numeroHabitacio;
    private String nTsPacient;
    private String dniMetge;
    private AssignarMetgeIngres assignarMetgeIngres; 

    
    public List obteHospitalsLliuresPerEspecialitat( String nomEsp ) {
        //: Set( TupleType( nom:String, adreça:String, descripció:String, habLliures:Set( núm: Integer )))
        nomEspecialitat = nomEsp;
        ConsultarHospitalsLliuresPerEspecialitat c = new ConsultarHospitalsLliuresPerEspecialitat();
        return c.getHospitalsLliuresPerEspecialitat( nomEsp );
    }
    
    public void creaIngres( String nomHosp, Integer numHab, String nTS ) throws Exception 
	{	
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlPacient ctrlPacient = ctrlDataFactoria.getCtrlPacient();
        Pacient pacient = ctrlPacient.get( nTS );

		
		CtrlHabitacio ctrlHabitacio = ctrlDataFactoria.getCtrlHabitacio();
        Habitacio habitacio = ctrlHabitacio.get( nomHosp, numHab );
		
		Ingres i = new Ingres( pacient, habitacio );
		
		nomHospital = nomHosp;
		numeroHabitacio = numHab;
		nTsPacient = nTS;
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate( i );
		session.getTransaction().commit();
                //session.close();
    }
    
    public List<String[]> mostraMetgesHospitalPerEspecialitat() throws Exception {
        //: Set( TupleType( dni: String, nom: String, categoria: String )
        AssignarMetgeIngres ami = new AssignarMetgeIngres();
        assignarMetgeIngres=ami;
        List<String[]> result=assignarMetgeIngres.getMetgesHospitalPerEspecialitat(nomHospital, nomEspecialitat);
        return result;
    }
    
    
    public void assignarMetgeAIngres( String dni ) throws Exception {
        AssignarMetgeIngres aMi = new AssignarMetgeIngres();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		assignarMetgeIngres.setMetgeAIngres( dni,nTsPacient,sqlDate );
		dniMetge = dni;
    }
    
    public void enviarInformeIngres() 
	{
		CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlPacient ctrlPacient = ctrlDataFactoria.getCtrlPacient();
        Pacient pacient = ctrlPacient.get( nTsPacient );
		
		EnviadorInformesFactoria enviadorInformesFactoria = EnviadorInformesFactoria.getInstance();
        EnviadorInformesMail enviadorInformesMail = enviadorInformesFactoria.getEnviadorInformes();
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		enviadorInformesMail.enviarInformeIngres( nomEspecialitat, sqlDate, nomHospital, numeroHabitacio, nTsPacient, dniMetge, pacient.getEmail() );
    }

}
