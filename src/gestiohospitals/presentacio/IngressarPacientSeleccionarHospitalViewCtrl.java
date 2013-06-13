package gestiohospitals.presentacio;

import java.util.List;

public class IngressarPacientSeleccionarHospitalViewCtrl extends IngressarPacientBaseViewCtrl
{
	private IngressarPacientSeleccionarHospitalView view;
	private String nomEsp;
	private DomainControllers.IngressarPacient ingressarPacient;

	public IngressarPacientSeleccionarHospitalViewCtrl( List llista, String nomEsp )
	{
		view = new IngressarPacientSeleccionarHospitalView();
		view.setCtrl( this );
		this.nomEsp = nomEsp;
		view.setInfoEsp( nomEsp );
		view.setLlistaHospitals(llista);
		view.mostraHospitals();
		view.actualitzaHabitacionsLliures( null );
	}
	
	public void setUseCase(DomainControllers.IngressarPacient ingressarPacient) {
		this.ingressarPacient = ingressarPacient;
	}

	public void canviarSeleccionarHospital( String nomHosp )
	{
	}

	public void prOkEnviarInforme( String nomHosp, int numHab, String nTS )
	{
		boolean checkBoxAssignarMetge = view.getAssignarMetgeCheckBoxIsChecked();
		if ( checkBoxAssignarMetge ) {
			view.tancar();
			IngressarPacientAssignarMetgeViewCtrl ingressarPacientAssignarMetgeViewCtrl = new IngressarPacientAssignarMetgeViewCtrl( null, nomEsp, /*nomHosp*/"clinic", nTS );
		}
		else {
			enviarInformeIngres();
		}
	}
}
