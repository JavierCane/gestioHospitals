package gestiohospitals.domini.models;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;

@Entity
@Table( name = "ingres" )
public class Ingres implements Serializable
{

	@EmbeddedId
	private IngresId ingresId;
	
	@Column( name = "data_alta" )
	@Temporal( javax.persistence.TemporalType.DATE )
	private Date dataAlta;
	
	@ManyToOne
	@JoinColumns( 
	{
		@JoinColumn( name = "numero_habitacio", referencedColumnName = "numero" ),
		@JoinColumn( name = "nom_hospital", referencedColumnName = "nom_hospital" )
	} )
	private Habitacio habitacio;
	
	@ManyToOne
	@JoinColumn( name = "codi_empleat_metge" )
	private Metge metge;

	public Ingres()
	{
	}

	/*
	 * Seguint amb el disseny del diagrama de sequencia, s'afageix un pacient (hem utilitzat la classe ingresId d'hibernate, que refelexa a un pacient que ha fet un ingres) i s'afageix l'ingres del pacient a la classe ingresId i a la classe habitacio.
	 */
	public Ingres( Pacient pacient, Habitacio habitacio ) throws Exception
	{
		this.habitacio = habitacio;

		//Ingres no tiene hospital, se encuentra en habitacion l hosp
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date( utilDate.getTime() );

		ingresId = new IngresId( sqlDate, pacient );

		ingresId.getPacient().addIngresos( this );

		habitacio.addIngresos( this );
	}

	public Ingres( IngresId ingresId )
	{
		this.ingresId = ingresId;
	}

	public Ingres( IngresId ingresId, Habitacio habitacio )
	{
		this.ingresId = ingresId;
		this.habitacio = habitacio;
	}

	public Ingres( IngresId ingresId, Date dataAlta, Habitacio habitacio, Metge metge )
	{
		this.ingresId = ingresId;
		this.dataAlta = dataAlta;
		this.habitacio = habitacio;
		this.metge = metge;
	}

	public Date getDataAlta()
	{
		return dataAlta;
	}

	public void setDataAlta( Date dataAlta )
	{
		this.dataAlta = dataAlta;
	}

	public Habitacio getHabitacio()
	{
		return habitacio;
	}

	public void setHabitacio( Habitacio habitacio )
	{
		this.habitacio = habitacio;
	}

	public Metge getMetge()
	{
		return metge;
	}

	public void setMetge( Metge metge )
	{
		this.metge = metge;
	}

	public Boolean teAlta()
	{
		return !( dataAlta == null );
	}

	/**
	 * Seguint el disseny del diagrama de seqüencia, primerament comprobem que no hi hagi cap excepció que podem activar
	 * si és així posem al variable metge del ingrés el metge que pasem per paràmetre.
	 *
	 * @param metge
	 * @param nomHospital
	 * @param nomEspecialitat
	 *
	 * @throws Exception
	 */
	public void setMetgeAIngres( Metge metge, String nomHospital, String nomEspecialitat ) throws Exception
	{
		if ( this.getDataAlta() != null )
		{
			throw new Exception( "altaIngres" );
		}
		if ( this.getMetge() != null )
		{
			throw new Exception( "ingresAmbMetge" );
		}
		if ( habitacio.esEspecialitat( nomEspecialitat ) )
		{
			if ( habitacio.getHabitacioId().getHospital().getNom().equals( nomHospital ) )
			{
				this.metge = metge;
			}
			else
			{
				throw new Exception( "noHospitalIngres" );
			}
		}
		else
		{
			throw new Exception( "noCoincideixenEspecialitats" );
		}
	}
}
