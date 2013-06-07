/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import DataInterface.*;
import gestiohospitals.domini.models.*;
import java.util.*;

public class ConsultarHospitalsLliuresPerEspecialitat {
    
    public List getHospitalsLliuresPerEspecialitat(String nomEsp) {
        //Set( TupleType( nom:String, adreça:String, descripció:String, habLliures:Set( núm: Integer )))
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlEspecialitat ctrlEsp = ctrlDataFactoria.getCtrlEspecialitat(nomEsp);
        Especialitat especialitat = ctrlEsp.getEspecialitat(nomEsp);
        return especialitat.getHabitacionsLliuresHospitals();
    }
}
