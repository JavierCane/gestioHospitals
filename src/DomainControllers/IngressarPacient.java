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
		
//		CtrlHospital ctrlHospital = ctrlDataFactoria.getCtrlHospital();
//		Hospital hospital = ctrlHospital.get( nomHosp );
		
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
        session.close();
    }
    
    public List<String[]> mostraMetgesHospitalPerEspecialitat() throws Exception {
        //: Set( TupleType( dni: String, nom: String, categoria: String )
        AssignarMetgeIngres ami = new AssignarMetgeIngres();
        return ami.getMetgesHospitalPerEspecialitat(nomHospital, nomEspecialitat);
    }
    
    
    public void assignarMetgeAIngres( String dni ) {
        
    }
    
    public void enviarInformeIngres() {
        
    }

}
