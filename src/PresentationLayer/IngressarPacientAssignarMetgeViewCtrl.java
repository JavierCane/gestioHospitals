package PresentationLayer;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class IngressarPacientAssignarMetgeViewCtrl
{

	private IngressarPacientAssignarMetgeView view;
	private DomainLayer.DomainControllers.IngressarPacient ingressarPacient;

	public IngressarPacientAssignarMetgeViewCtrl( String nomEsp, String nomHosp, String nTS, List<String[]> llistaMetges )
	{
		view = new IngressarPacientAssignarMetgeView();
		view.setCtrl( this );
		view.setInfoEsp( nomEsp );
		view.setInfoHosp( nomHosp );
		view.setInfoData( getDate() );
		view.setInfoNTS( nTS );
		view.mostraMetges( llistaMetges );
	}

	private String getDate()
	{
		String date = new SimpleDateFormat( "dd/MM/yyyy" ).format( Calendar.getInstance().getTime() );
		return date;
	}

	public void setUseCase( DomainLayer.DomainControllers.IngressarPacient ingressarPacient )
	{
		this.ingressarPacient = ingressarPacient;
	}

	public void enviarInforme()
	{
		try {
			ingressarPacient.enviarInformeIngres();
			view.mostraPopUp( "S'ha ingressat correctament i s'ha notificat al servei de sanitat." );
		}
		catch ( Exception e ) {
			if ( e.getMessage().equals( "serveiNoDisponible" ) ) {
				view.mostraPopUp( "S'ha ingressat correctament pero no s'ha pogut notificar al servei de sanitat.");
			}
		}
		System.exit( 0 );
	}

	public void prOkIAssignarMetge( String dni )
	{
		try { //el try sobra
			ingressarPacient.assignarMetgeAIngres( dni );
		}
		catch ( Exception e ) {
			view.mostraMissatge( e.getMessage() );
		}
		enviarInforme();
	}
}
