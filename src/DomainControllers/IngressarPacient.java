package DomainControllers;

import java.util.*;

/**
 * @author William
 */
public class IngressarPacient {
    private String nomEspecialitat;
    private String nomHospital;
    private Integer numeroHabitacio;
    private String nTsPacient;
    private String dniMetge;

    
//    public List obteHospitalsLliuresPerEspecialitat( String nomEsp ) {
//        //: Set( TupleType( nom:String, adreça:String, descripció:String, habLliures:Set( núm: Integer )))
//        nomEspecialitat = nomEsp;
//        ConsultarHospitalsLliuresPerEspecialitat c = new ConsultarHospitalsLliuresPerEspecialitat();
//        return c.getHospitalsLliuresPerEspecialitat( nomEsp );
//    }
    
    public void creaIngrés( String nomHosp, Integer numHab, String nTS ) {
        
    }
    
    public ArrayList mostraMetgesHospitalPerEspecialitat() {
        //: Set( TupleType( dni: String, nom: String, categoria: String ))
        ArrayList res = new ArrayList();
        return res;
    }
    
    public void assignarMetgeAIngres( String dni ) {
        
    }
    
    public void enviarInformeIngres() {
        
    }
}
