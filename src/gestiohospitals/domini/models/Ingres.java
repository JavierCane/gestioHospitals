package gestiohospitals.domini.models;

import java.io.Serializable;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	
	public Ingres( Pacient pacient, Habitacio habitacio) throws Exception
	{
		this.habitacio = habitacio;
		//Ingres no tiene hospital, se encuentra en habitacion l hosp
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
//		System.out.println("utilDate:" + utilDate);
//		System.out.println("sqlDate:" + sqlDate);
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
		return ( dataAlta != null );
	}

    public void setMetgeAIngres(Metge metge, String nomHospital, String nomEspecialitat) throws Exception 
    {
        if(this.getDataAlta()!=null) throw new Exception("altaIngres");
        if(this.getMetge()!=null) throw new Exception("ingresAmbMetge"); 
        if(habitacio.esEspecialitat(nomEspecialitat))
        {
            if(habitacio.getHabitacioId().getHospital().getNom().equals(nomHospital))
            {
                this.metge=metge;
            }
            else
            {
                throw new Exception("noHospitalIngres");
            }
        }
        else
        {
            throw new Exception("noCoincideixenEspecialitats");
        }
    }
}
