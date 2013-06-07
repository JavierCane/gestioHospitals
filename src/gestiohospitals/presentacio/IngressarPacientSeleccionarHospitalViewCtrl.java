package gestiohospitals.presentacio;

import java.util.ArrayList;

public class IngressarPacientSeleccionarHospitalViewCtrl extends IngressarPacientBaseViewCtrl
{

	private class InfoHosp
	{

		private String nomHosp;
		int habLliures[];
	}
	private InfoHosp llistaHospitals[];
	private IngressarPacientSeleccionarHospitalView view;

	public IngressarPacientSeleccionarHospitalViewCtrl( ArrayList llista, String nomEsp )
	{
		view = new IngressarPacientSeleccionarHospitalView();
		view.setCtrl( this );
		view.setInfoEsp( nomEsp );
	}

	public void canviarSeleccionarHospital( String nomHosp )
	{
	}

	public void prOkEnviarInforme( String nomHosp, int numHab, String nTS )
	{
	}
}
