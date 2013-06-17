package DomainLayer.DomainControllers;

import DomainLayer.DataInterface.CtrlEspecialitat;
import DomainLayer.DataInterface.CtrlDataFactoria;
import DomainLayer.DomainModel.Especialitat;
import java.util.*;

public class ConsultarHospitalsLliuresPerEspecialitat
{

	/**
	 * Seguint amb el disseny del diagrama de sequencia, es demana l'instancia del controlador de factoria per desrés
	 * demonaar el controlador d'especialitat per més tard aconseguir l'objecte d'especialitat que volem tractar. Un cop
	 * el tenim invoquem l'operacion getHabitacionsLliuresHospitals sobre aquest.
	 *
	 * @param nomEsp
	 *
	 * @return
	 * @throws Exception
	 */
	public List getHospitalsLliuresPerEspecialitat( String nomEsp ) throws Exception
	{
		CtrlDataFactoria ctrlDataFactoria = CtrlDataFactoria.getInstance();
		CtrlEspecialitat ctrlEspecialitat = ctrlDataFactoria.getCtrlEspecialitat();
		Especialitat especialitat = ctrlEspecialitat.get( nomEsp );

		if ( especialitat == null )
		{
			throw new Exception( "noHiHaEspecialitat" );
		}

		return especialitat.getHabitacionsLliuresHospitals();
	}
}
