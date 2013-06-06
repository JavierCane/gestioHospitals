/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;
import DataInterface.*;
import gestiohospitals.domini.models.*;

import java.util.*;
/**
 *
 * @author William
 */
public class ConsultarHospitalsLliuresPerEspecialitat {
    public List getHospitalsLliuresPerEspecialitat( String nomEsp ) {
        //Set( TupleType( nom:String, adreça:String, descripció:String, habLliures:Set( núm: Integer )))
        CtrlDataFactoria c = CtrlDataFactoria.getInstance();
        CtrlEspecialitat ctrlEsp = c.getCtrlEspecialitat( nomEsp );
        Especialitat e = ctrlEsp.getEspecialitat( nomEsp );
        return e.getHabitacionsLliuresHospitals();
    }
}