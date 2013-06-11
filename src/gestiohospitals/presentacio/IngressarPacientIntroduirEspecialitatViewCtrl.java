package gestiohospitals.presentacio;

public class IngressarPacientIntroduirEspecialitatViewCtrl extends BaseViewCtrl
{

	private IngressarPacientIntroduirEspecialitatView view;
	//private ArrayList llista;
	private DomainControllers.IngressarPacient ingressarPacient;

	public IngressarPacientIntroduirEspecialitatViewCtrl()
	{
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
				//ingressarPacient.obteHospitalsLliuresPerEspecialitat(nomEsp);
				view.tancar();
				IngressarPacientSeleccionarHospitalViewCtrl ingresPacientSelecHospViewCtrl = new IngressarPacientSeleccionarHospitalViewCtrl( null, nomEsp );
			}
			catch ( Exception e ) {
			}

		}
	}
}
