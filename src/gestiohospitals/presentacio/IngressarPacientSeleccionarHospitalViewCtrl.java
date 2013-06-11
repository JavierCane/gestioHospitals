package gestiohospitals.presentacio;

import java.util.ArrayList;

public class IngressarPacientSeleccionarHospitalViewCtrl extends IngressarPacientBaseViewCtrl
{

	private class InfoMetge
	{

		public String dni;
		public String nom;
		public String categoria;
	}
	private InfoMetge metges[];

	private class InfoHosp
	{

		public String nomHosp;
		public int habLliures[];
	}
	private InfoHosp llistaHospitals[];
	private IngressarPacientSeleccionarHospitalView view;
	private String nomEsp;

	public IngressarPacientSeleccionarHospitalViewCtrl( InfoHosp llistaHospitals[], String nomEsp )
	{
		view = new IngressarPacientSeleccionarHospitalView();
		view.setCtrl( this );
		this.nomEsp = nomEsp;
		view.setInfoEsp( nomEsp );
		view.mostraHospitals( null );
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
