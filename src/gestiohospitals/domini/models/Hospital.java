package gestiohospitals.domini.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "hospital" )
public class Hospital implements Serializable {

	@Id
        @Column(name="nom")
	private String nom;
	@Column(name="adreca")
	private String adreca;
	@Column(name="descripcio")
	private String descripcio;
	
	@OneToMany( mappedBy = "id.hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private Set<Habitacio> habitacio = new HashSet<>();

	public Hospital() {
	}

	public Hospital( String nom, String adreca, String descripcio ) {
		this.nom = nom;
		this.adreca = adreca;
		this.descripcio = descripcio;
	}
	
	@Override
	public String toString() {
		if ( habitacio == null )
		{
			return "Hospital [nom=" + nom + ", adreca=" + adreca + ", descripcio="
					+ descripcio + "]";
		}
		else
		{
			return "Hospital [nom=" + nom + ", adreca=" + adreca + ", descripcio="
				+ descripcio + ", habitacio=" + habitacio.toString() + "]";
		}
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.nom);
		hash = 67 * hash + Objects.hashCode(this.adreca);
		hash = 67 * hash + Objects.hashCode(this.descripcio);
		hash = 67 * hash + Objects.hashCode(this.habitacio);
		return hash;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		final Hospital other = (Hospital) obj;
		if (!Objects.equals(this.nom, other.nom)) {
			return false;
		}
		return true;
	}

	public String getId() {
		return nom;
	}
	

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdreca() {
		return adreca;
	}

	public void setAdreca(String adreca) {
		this.adreca = adreca;
	}

	public String getDescripcio() {
		return descripcio;
	}

	public void setDescripcio(String descripcio) {
		this.descripcio = descripcio;
	}

	public Set<Habitacio> getHabitacio() {
		return habitacio;
	}

	public void setHabitacio(Set<Habitacio> habitacio) {
		this.habitacio = habitacio;
	}
}

