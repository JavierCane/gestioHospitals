package gestiohospitals.presentacio;

import java.util.List;

public class IngressarPacientSeleccionarHospitalViewCtrl extends IngressarPacientBaseViewCtrl
{
	private IngressarPacientSeleccionarHospitalView view;
	private String nomEsp;

	public IngressarPacientSeleccionarHospitalViewCtrl( List llista, String nomEsp )
	{
		view = new IngressarPacientSeleccionarHospitalView();
		view.setCtrl( this );
		this.nomEsp = nomEsp;
		view.setInfoEsp( nomEsp );
		view.mostraHospitals( llista );
		view.actualitzaHabitacionsLliures( null );
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
