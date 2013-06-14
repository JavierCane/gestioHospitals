

package DomainControllers;

import DataInterface.CtrlDataFactoria;
import DataInterface.CtrlEspecialitat;
import DataInterface.CtrlHospital;
import DataInterface.CtrlIngres;
import DataInterface.CtrlMetge;
import gestiohospitals.domini.models.Especialitat;
import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Ingres;
import gestiohospitals.domini.models.Metge;
import java.sql.Date;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class AssignarMetgeIngres {

    private String nomHospital;
    private String nomEspecialitat;
    
    public AssignarMetgeIngres() {
    }
    
     public List<String[]> getMetgesHospitalPerEspecialitat( String nomHosp, String nomEsp ) throws Exception{
     //: Set( TupleType( dni: String, nom: String, categoria: String ) )
         CtrlDataFactoria cdf = CtrlDataFactoria.getInstance();
         CtrlEspecialitat ce=cdf.getCtrlEspecialitat();
         Especialitat e = ce.get(nomEsp);
         CtrlHospital ch = cdf.getCtrlHospital();
         Boolean existeixHospital = ch.exist(nomHosp);
         if( !existeixHospital ) throw new Exception("NoHiHaHospitals");
         if( !e.hospitalConteEspecialitat(nomHosp) ) throw new Exception("noEspecialitatEnHospital");
         List<String[]> metges = e.getMetgesHospital(nomHosp);
         nomHospital=nomHosp;
         nomEspecialitat=nomEsp;
         return metges;
     }

	void setMetgeAIngres( String codiEmpleat, String nTsPacient, Date dataInici ) throws Exception
	{
		CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
		CtrlMetge ctrlMetge = ctrlDataFactoria.getCtrlMetge();
                Metge metge = ctrlMetge.get( codiEmpleat );
                CtrlIngres ctrlIngres = ctrlDataFactoria.getCtrlIngres();
                System.out.println(dataInici.toString());
                Ingres ingres = ctrlIngres.get(nTsPacient, dataInici);
                               System.out.println("nomhosp "+nomHospital +" nom esp " +nomEspecialitat);
 
		ingres.setMetgeAIngres(metge, nomHospital, nomEspecialitat);
                SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();
		session.beginTransaction();
		session.saveOrUpdate( ingres );
                session.getTransaction().commit();
                //session.close();
	}
}
