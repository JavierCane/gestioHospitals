package gestiohospitals.domini.models;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "especialitat" )
public class Especialitat
{

	@Id
	@Column( name = "nom_especialitat", nullable = false, unique = true )
	private String nom;
	
	@OneToMany( mappedBy = "especialitat" )
	private List<Metge> metges = new ArrayList<>();
	
	@OneToMany( mappedBy = "especialitat" )
	private List<Habitacio> habitacions = new ArrayList<>();
	
	@ManyToMany( cascade =
	{
		CascadeType.ALL
	} )
	@JoinTable( name = "hospital_especialitat",
				joinColumns =
	{
		@JoinColumn( name = "nom_especialitat" )
	},
				inverseJoinColumns =
	{
		@JoinColumn( name = "nom_hospital" )
	} )
	private List<Hospital> hospitals = new ArrayList<>();

	public Especialitat()
	{
	}

	public Especialitat( String nom )
	{
		this.nom = nom;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}

	public List<Habitacio> getHabitacions()
	{
		return habitacions;
	}

	public void setHabitacions( List<Habitacio> habitacions )
	{
		this.habitacions = habitacions;
	}

	public List<Metge> getMetges()
	{
		return metges;
	}

	public void setMetges( List<Metge> metges )
	{
		this.metges = metges;
	}

	public List<Hospital> getHospitals()
	{
		return hospitals;
	}

	/**
	 * Seguint amb el disseny del diagrama de sequencia, recorrem tots els hospitals associats a l'especialitat, on		* per cada hospital li consultem les habitacions lliures que té per despres retornar un conjunt d'informacio (	
	 * classe Dada) de cada hospitals que ens interessa
	 * @return
	 * @throws Exception 
	 */
	public List getHabitacionsLliuresHospitals() throws Exception
	{
		ArrayList<Dada> llistaHabitacions = new ArrayList();
		Iterator it = hospitals.iterator();
		Dada d;
		
		while ( it.hasNext() )
		{
			Object h = it.next();
			d = ( ( Hospital ) h ).getHabitacionsLliures( nom );
			
			if ( d.getHabLliures().size() > 0 )
			{
				llistaHabitacions.add( d );
			}
			else
			{
				throw new Exception( "noHiHaHospitals" );
			}
		}
		return llistaHabitacions;
	}
	/**
	 * Seguint el disseny del diagrama de seqüencia, per cada metge m comprobem si és de l'Hospital amb nom nomHosp,
	 * si ho és aleshores obtenim les seves dades i la guardem en una llista. Un cop obtinguts els metges ordenem la	 * llista
	 * per el seu nom, seguint el patró estrategia.
	 * 
	 * @param nomHosp
	 * @return
	 * @throws Exception 
	 */
	public List<String[]> getMetgesHospital( String nomHosp ) throws Exception
	{
		List<String[]> metgesHospital = new ArrayList<String[]>();
		for ( Metge metge : metges )
		{
			if ( metge.getNomHospital().equals( nomHosp ) )
			{
				String[] dades = new String[ 3 ];
				//dni
				dades[0] = metge.obteDadesPersona()[0];
				//Nom
				dades[1] = metge.obteDadesPersona()[1];
				//Categoria
				dades[2] = metge.getCategoria();
				metgesHospital.add( dades );
			}
		}
		if ( metgesHospital.isEmpty() )
		{
			throw new Exception( "noHiHaMetges" );
		}

		NameOrder no = new NameOrder();
		no.ordenar( metgesHospital );

		return metgesHospital;

	}
	/**
	 * Seguint el disseny del diagrama de seqüencia, es comprova que l'hopsital amb nom 'nomHosp' estigui dintre de l
	 * llista d'hospitals de l'especialitat
	 * @param nomHosp
	 * @return 
	 */
	public boolean hospitalConteEspecialitat( String nomHosp )
	{
		for ( Hospital hospital : hospitals )
		{
			if ( hospital.getNom().equals( nomHosp ) )
			{
				return true;
			}
		}
		return false;
	}
}
