package gestiohospitals.domini.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

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
	
	@ManyToMany( cascade = { CascadeType.ALL } )
	@JoinTable( name = "hospital_especialitat",
				joinColumns = {
		@JoinColumn( name = "nom_especialitat" ) },
				inverseJoinColumns = {
		@JoinColumn( name = "nom_hospital" ) } )
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
	
//	public List getHabitacionsLliuresHospitals()
//	{
//		ArrayList<Dada> llistaHabitacions = new ArrayList();
//		Iterator it = hospitals.iterator();
//		Dada d;
//		while ( it.hasNext() ) {
//			Object h = it.next();
//			d = ( ( Hospital ) h ).getHabitacionsLliures( nom );
//			if ( d.getHabLliures().size() > 0 ) {
//				llistaHabitacions.add( d );
//			}
//			else {
//				JOptionPane.showMessageDialog( null, "Exc: noHiHaHopstials -> habLliures no es > 0 " + ( ( Hospital ) h ).getNom() );
//			}
//		}
//		return llistaHabitacions;
//	}
}
