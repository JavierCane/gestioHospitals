package gestiohospitals.domini.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
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
	@JoinColumn( name = "numero_habitacio" )
	private Habitacio habitacio;
	@ManyToOne
	@JoinColumn( name = "nom_hospital" )
	private Hospital hospital;
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

	public Ingres( IngresId ingresId, Habitacio habitacio, Hospital hospital )
	{
		this.ingresId = ingresId;
		this.habitacio = habitacio;
		this.hospital = hospital;
	}

	public Ingres( IngresId ingresId, Date dataAlta, Habitacio habitacio, Hospital hospital )
	{
		this.ingresId = ingresId;
		this.dataAlta = dataAlta;
		this.habitacio = habitacio;
		this.hospital = hospital;
	}

	public Ingres( IngresId ingresId, Date dataAlta, Habitacio habitacio, Hospital hospital, Metge metge )
	{
		this.ingresId = ingresId;
		this.dataAlta = dataAlta;
		this.habitacio = habitacio;
		this.hospital = hospital;
		this.metge = metge;
	}

	public Ingres( IngresId ingresId, Habitacio habitacio, Hospital hospital, Metge metge )
	{
		this.ingresId = ingresId;
		this.habitacio = habitacio;
		this.hospital = hospital;
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

	public Hospital getHospital()
	{
		return hospital;
	}

	public void setHospital( Hospital hospital )
	{
		this.hospital = hospital;
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
		return ( dataAlta != null );
	}
}
