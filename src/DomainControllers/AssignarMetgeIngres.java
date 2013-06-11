

package DomainControllers;

import DataInterface.CtrlDataFactoria;
import DataInterface.CtrlEspecialitat;
import DataInterface.CtrlHospital;
import gestiohospitals.domini.models.Especialitat;
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
}
