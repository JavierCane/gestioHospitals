package gestiohospitals.domini.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "hospital" )
public class Hospital
{

	@Id
	@Column( name = "nom_hospital" )
	private String nom;
	
	@Column( name = "adreca" )
	private String adreca;
	
	@Column( name = "descripcio" )
	private String descripcio;
	
	@OneToMany( mappedBy = "habitacioId.hospital", fetch = FetchType.LAZY )
	private List<Habitacio> habitacions = new ArrayList<>();
	
	@OneToMany( mappedBy = "hospital" )
	private List<Sanitari> sanitaris = new ArrayList<>();
	
	@ManyToMany( mappedBy = "hospitals" )
	private List<Especialitat> especialitats = new ArrayList<>();

	public Hospital()
	{
	}

	public Hospital( String nom, String adreca, String descripcio )
	{
		this.nom = nom;
		this.adreca = adreca;
		this.descripcio = descripcio;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public String getAdreca()
	{
		return adreca;
	}

	public void setAdreca( String adreca )
	{
		this.adreca = adreca;
	}

	public String getDescripcio()
	{
		return descripcio;
	}

	public void setDescripcio( String descripcio )
	{
		this.descripcio = descripcio;
	}

	/*
	 * Seguint amb el disseny del diagrama de sequencia, recorrem les habitacions de l'hopital, on si l'habitacio resulta ser lliure, retornem aquesta habitacio juntamnet amb tota l'informacio que ens interessa de l'hopital.
	 */
	public Dada getHabitacionsLliures( String nom )
	{
		Dada d = new Dada();

		Iterator it = habitacions.iterator();

		while ( it.hasNext() )
		{
			Object h = it.next();
			if ( ( ( Habitacio ) h ).esEspecialitat( nom ) )
			{
				if ( ( ( Habitacio ) h ).estaLliure() )
				{
					d.getHabLliures().add( ( ( Habitacio ) h ).getHabitacioId().getNumero() );
				}
			}
		}


		if ( d.getHabLliures().size() > 0 )
		{
			d.setNom( this.nom );
			d.setAdreca( adreca );
			d.setDescripcio( descripcio );
		}

		/*
		 dada:TupleType( nom:String, adreca:String, descripcio:String, habLliures:Set( num: Integer ))
		 * */
		return d;
	}
}
