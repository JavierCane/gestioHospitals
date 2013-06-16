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
	
	/*
	 * Seguint amb el disseny del diagrama de sequencia, recorrem tots els hospitals associats a l'especialitat, on per cada hospital li consultem les habitacions lliures que té per despres retornar un conjunt d'informacio (classe Dada) de cada hospitals que ens interessa
	 */
	public List getHabitacionsLliuresHospitals() throws Exception
	{
		ArrayList<Dada> llistaHabitacions = new ArrayList();
		Iterator it = hospitals.iterator();
		Dada d;
		while ( it.hasNext() ) {
			Object h = it.next();
			d = ( ( Hospital ) h ).getHabitacionsLliures( nom );
			if ( d.getHabLliures().size() > 0 ) {
				llistaHabitacions.add( d );
			}
			else {
				throw new Exception("noHiHaHopstials");
			}
		}
		return llistaHabitacions;
	}
	
	public List<String[]> getMetgesHospital(String nomHosp) throws Exception 
	{
        List<String[]> metgesHospital=new ArrayList<String[]>();
        Iterator it=metges.iterator();
        while(it.hasNext()){
            Metge m=(Metge) it.next();
            if(m.getNomHospital().equals( nomHosp )){
                String[] dades=new String[3];
                //dni
                dades[0]=m.obteDadesPersona()[0];
                //Nom
                dades[1]=m.obteDadesPersona()[1];
                //Categoria
                dades[2]=m.getCategoria();
                metgesHospital.add(dades);
            }
        }
        if(metgesHospital.isEmpty()) throw new Exception("noHiHaMetges");
        
        NameOrder no= new NameOrder();
        no.ordenar(metgesHospital);
        
        return metgesHospital;
  
    }

	public boolean hospitalConteEspecialitat(String nomHosp)
	{
		Iterator it = hospitals.iterator();
		while ( it.hasNext() ) {
			Hospital h = (Hospital) it.next();
			if( h.getNom().equals( nomHosp )  ) return true;
		}
		return false;
	}
}
