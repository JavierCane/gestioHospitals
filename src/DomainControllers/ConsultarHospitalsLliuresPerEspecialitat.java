   /*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

import DataInterface.*;
import gestiohospitals.domini.models.*;
import java.util.*;

public class ConsultarHospitalsLliuresPerEspecialitat {

    /*
	 * Seguint amb el disseny del diagrama de sequencia, es demana l'instancia del controlador de factoria per desrés demonaar el controladro d'especialitat per més tard aconseguir l'objecte d'especialitat que volem tractar. Un cop el tenim invoquem l'operacion getHabitacionsLliuresHospitals sobre aquest.
	 */
	public List getHospitalsLliuresPerEspecialitat(String nomEsp) throws Exception {
        //Set( TupleType( nom:String, adreça:String, descripció:String, habLliures:Set( núm: Integer )))
        CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
        CtrlEspecialitat ctrlEspecialitat = ctrlDataFactoria.getCtrlEspecialitat();
        Especialitat especialitat = ctrlEspecialitat.get(nomEsp);
		//System.out.println(especialitat.getNom());
        return especialitat.getHabitacionsLliuresHospitals();
    }
}
