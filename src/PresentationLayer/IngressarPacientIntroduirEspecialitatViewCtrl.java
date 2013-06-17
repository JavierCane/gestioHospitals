package PresentationLayer;

import DomainLayer.DomainControllers.IngressarPacient;
import DomainLayer.DomainModel.Dada;
import java.util.List;

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

	public void prCancel()
	{
		System.exit( 0 );
	}
}
