package gestiohospitals.domini.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table( name = "ingres" )
public class Ingres implements Serializable
{

	@EmbeddedId
	private IngresId ingresId;
	
	@Column( name = "data_alta" )
	private Date dataAlta;
	
	@ManyToOne
	@JoinColumns( {
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

	/*	public Hospital getHospital()
	 {
	 return hospital;
	 }

	 public void setHospital( Hospital hospital )
	 {
	 this.hospital = hospital;
	 }
	 */
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
		return ( dataAlta != null );
	}
}
