package PresentationLayer;

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

	/**
	 * Establece el caso de uso.
	 *
	 * @param ingressarPacient
	 */
	public void setUseCase( DomainLayer.DomainControllers.IngressarPacient ingressarPacient )
	{
		this.ingressarPacient = ingressarPacient;
	}

	/**
	 * Establece las habitaciones libres para el hospital que indica el índice. Se utiliza un índice en lugar del nombre
	 * del hospital, como se había diseñado en el UML, porque da más facilidad programarlo con el índice.
	 *
	 * @param rowIndex Índice que indica qué hospital está seleccionado en la lista de hospitales.
	 */
	public void canviarSeleccionarHospital( int rowIndex )
	{
		List<Integer> habLliures = ( ( DomainLayer.DomainModel.Dada ) llistaHospitals.get( rowIndex ) ).getHabLliures();
		view.actualitzaHabitacionsLliures( habLliures );
	}

	/**
	 * Crea el ingreso y, según el estado del checkbox, envía el informe o bien avanza hacia la pantalla de asignar
	 * médico. Controla todas las excepciones que puedan surgir. El envío del informe se ha pasado a esta clase y se ha
	 * eliminado la clase de la que heredaba, "IngressarPacientBaseViewCtrl", porque al implementarla nos dimos cuenta
	 * que solo tenía una operación de una línea de código y era un tanto absurda su existencia.
	 *
	 * @param nomHosp
	 * @param numHab
	 * @param nTS
	 */
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

	/**
	 * Acaba el caso de uso.
	 */
	public void prCancel()
	{
		System.exit( 0 );
	}
}
