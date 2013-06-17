package PresentationLayer;

import DomainLayer.DomainControllers.IngressarPacient;
import java.util.List;

/**
 * Esta clase y los otros dos controladores de vistas no heredan de BaseViewCtrl porque la superclase resultó tener solo
 * una operación de una línea de código, concretamente la operación prCancel(), así que decidimos eliminarla.
 */
public class IngressarPacientIntroduirEspecialitatViewCtrl
{

	private IngressarPacientIntroduirEspecialitatView view;
	private DomainLayer.DomainControllers.IngressarPacient ingressarPacient;

	public IngressarPacientIntroduirEspecialitatViewCtrl()
	{
		ingressarPacient = new IngressarPacient();
		view = new IngressarPacientIntroduirEspecialitatView();
		view.setCtrl( this );
	}

	/**
	 * Obtiene los hospitals de la especialidad nomEsp y controla las excepciones que puedan ocurrir.
	 *
	 * @param nomEsp
	 */
	public void prOkObteHospitals( String nomEsp )
	{
		if ( nomEsp.isEmpty() )
		{
			view.mostraMissatge( "L'especialitat no existeix." );
		}
		else
		{
			try
			{
				List llista = ingressarPacient.obteHospitalsLliuresPerEspecialitat( nomEsp );
				view.tancar();
				IngressarPacientSeleccionarHospitalViewCtrl ingresPacientSelecHospViewCtrl = new IngressarPacientSeleccionarHospitalViewCtrl( llista, nomEsp );
				ingresPacientSelecHospViewCtrl.setUseCase( ingressarPacient );
			}
			catch ( Exception e )
			{
				String cause = e.getMessage();

				if ( cause.equals( "noHiHaEspecialitat" ) )
				{
					view.mostraMissatge( "L'especialitat no existeix." );
				}
				else if ( cause.equals( "noHiHaHospitals" ) )
				{
					view.mostraMissatge( "No hi ha hospitals disponibles amb l'especialitat indicada." );
				}
				else
				{
					view.mostraMissatge( "Error desconegut: " + cause );
				}
			}

		}
	}

	/**
	 * Acaba el caso de uso.
	 */
	public void prCancel()
	{
		System.exit( 0 );
	}
}
