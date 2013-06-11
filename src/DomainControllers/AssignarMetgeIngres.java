

package DomainControllers;

import DataInterface.CtrlDataFactoria;
import DataInterface.CtrlEspecialitat;
import DataInterface.CtrlHospital;
import DataInterface.CtrlMetge;
import gestiohospitals.domini.models.Especialitat;
import gestiohospitals.domini.models.Metge;
import java.sql.Date;
import java.util.List;


public class AssignarMetgeIngres {

    private String nomHospital;
    private String nomEspecialitat;
    
    public AssignarMetgeIngres() {
    }
    
     public List<String[]> getMetgesHospitalPerEspecialitat( String nomHosp, String nomEsp ) throws Exception{
     //: Set( TupleType( dni: String, nom: String, categoria: String ) )
         CtrlDataFactoria cdf = CtrlDataFactoria.getInstance();
         CtrlEspecialitat ce=cdf.getCtrlEspecialitat();
         Especialitat e=ce.get(nomEsp);
         CtrlHospital ch = cdf.getCtrlHospital();
         Boolean existeixHospital = ch.exist(nomHosp);
         if( !existeixHospital ) throw new Exception("NoHiHaHospitals");
         if( !e.hospitalConteEspecialitat(nomHosp) ) throw new Exception("noEspecialitatEnHospital");
         List<String[]> metges = e.getMetgesHospital(nomHosp);
         nomHospital=nomHosp;
         nomEspecialitat=nomEsp;
         return metges;
     }

	void setMetgeAIngres( String dni, String nTsPacient, Date sqlDate )
	{
		CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
		CtrlMetge ctrlMetge = ctrlDataFactoria.getCtrlMetge();
        Metge m = ctrlMetge.get( dni );
		if (m == null) System.out.println("dasfas");
		System.out.println("dni "+m.getDni()+"codi emplk "+m.getCodiEmpleat());
	}
}
