package gestiohospitals.presentacio;

import DomainControllers.IngressarPacient;
import java.util.List;

public class IngressarPacientIntroduirEspecialitatViewCtrl extends BaseViewCtrl
{

	private IngressarPacientIntroduirEspecialitatView view;
	private DomainControllers.IngressarPacient ingressarPacient;

	public IngressarPacientIntroduirEspecialitatViewCtrl()
	{
		ingressarPacient = new IngressarPacient();
		view = new IngressarPacientIntroduirEspecialitatView();
		view.setCtrl( this );
	}

	public void prOkObteHospitals( String nomEsp )
	{
		if ( nomEsp.isEmpty() ) {
			view.mostraMissatge( "No hi ha especialitat." );
		}
		else {
			try {
				List llista = ingressarPacient.obteHospitalsLliuresPerEspecialitat( nomEsp );
				view.tancar();
				IngressarPacientSeleccionarHospitalViewCtrl ingresPacientSelecHospViewCtrl = new IngressarPacientSeleccionarHospitalViewCtrl( llista, nomEsp );
			}
			catch ( Exception e ) {
				String cause = e.getMessage();
				if ( cause.equals( "noHiHaEspecialitat" ) ) {
					view.mostraMissatge( "No hi ha especialitat." );
				}
				else {
					if ( cause.equals( "noHiHaHospitals" ) ) {
						view.mostraMissatge( "No hi ha hospitals." );
					}
					else {
					}
				}
				view.mostraMissatge( cause );
			}

		}
	}
}
