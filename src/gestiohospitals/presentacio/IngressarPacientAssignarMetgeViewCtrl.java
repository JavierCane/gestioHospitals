package gestiohospitals.presentacio;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class IngressarPacientAssignarMetgeViewCtrl extends IngressarPacientBaseViewCtrl
{

	private class InfoMetge
	{

		public String dni;
		public String nom;
		public String categoria;
	}
	private IngressarPacientAssignarMetgeView view;

	public IngressarPacientAssignarMetgeViewCtrl( InfoMetge[] metges, String nomEsp, String nomHosp, String nTS )
	{
		view = new IngressarPacientAssignarMetgeView();
		view.setCtrl( this );
		view.setInfoEsp( nomEsp );
		view.setInfoHosp( nomHosp );
		view.setInfoData( getDate() );
		view.setInfoNTS( nTS );
		view.mostraMetges();
	}

	private String getDate()
	{
		String date = new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
		return date;
	}

	public void prCancelEnviarInforme()
	{
	}

	public void prOkIAssignarMetge( String dni )
	{
	}
}
