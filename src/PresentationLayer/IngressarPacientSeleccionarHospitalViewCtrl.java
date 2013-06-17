package PresentationLayer;

import java.util.ArrayList;
import java.util.List;

public class IngressarPacientSeleccionarHospitalViewCtrl
{

	private IngressarPacientSeleccionarHospitalView view;
	private String nomEsp;
	private DomainLayer.DomainControllers.IngressarPacient ingressarPacient;
	private List llistaHospitals;

	public IngressarPacientSeleccionarHospitalViewCtrl( List llistaHospitals, String nomEsp )
	{
		view = new IngressarPacientSeleccionarHospitalView();
		view.setCtrl( this );
		this.nomEsp = nomEsp;
		view.setInfoEsp( nomEsp );
		view.setLlistaHospitals( llistaHospitals );
		view.mostraHospitals();
		this.llistaHospitals = llistaHospitals;
		canviarSeleccionarHospital( 0 );

	}

	public void setUseCase( DomainLayer.DomainControllers.IngressarPacient ingressarPacient )
	{
		this.ingressarPacient = ingressarPacient;
	}

	public void canviarSeleccionarHospital( int rowIndex )
	{
		List<Integer> habLliures = ( ( DomainLayer.DomainModel.Dada ) llistaHospitals.get( rowIndex ) ).getHabLliures();
		view.actualitzaHabitacionsLliures( habLliures );
	}

	public void prOkEnviarInforme( String nomHosp, int numHab, String nTS )
	{
		try
		{
			ingressarPacient.creaIngres( nomHosp, numHab, nTS );
			boolean checkBoxAssignarMetge = view.getAssignarMetgeCheckBoxIsChecked();
			
			if ( checkBoxAssignarMetge )
			{
				try
				{
					List<String[]> llistaMetges = ingressarPacient.mostraMetgesHospitalPerEspecialitat();
					view.tancar();
					IngressarPacientAssignarMetgeViewCtrl ingressarPacientAssignarMetgeViewCtrl = new IngressarPacientAssignarMetgeViewCtrl( nomEsp, nomHosp, nTS, llistaMetges );
					ingressarPacientAssignarMetgeViewCtrl.setUseCase( ingressarPacient );
				}
				catch ( Exception e )
				{
					if ( e.getMessage().equals( "noHiHaMetges" ) )
					{
						view.mostraMissatge( "No hi ha metges." );
					}
				}
			}
			else
			{
				try
				{
					ingressarPacient.enviarInformeIngres();
					view.mostraPopUp( "S'ha ingressat correctament i s'ha notificat al servei de sanitat." );
				}
				catch ( Exception e )
				{
					if ( e.getMessage().equals( "serveiNoDisponible" ) )
					{
						view.mostraPopUp( "S'ha ingressat correctament pero no s'ha pogut notificar al servei de sanitat." );
					}

				}
				System.exit( 0 );
			}
		}
		catch ( Exception e )
		{
			if ( e.getMessage().equals( "pacientNoExisteix" ) )
			{
				view.mostraMissatge( "Pacient no existeix." );
			}
			else if ( e.getMessage().equals( "pacientIngressat" ) )
			{
				view.mostraMissatge( "Pacient ja esta ingressat." );
			}
		}
	}

	public void prCancel()
	{
		System.exit( 0 );
	}
}
