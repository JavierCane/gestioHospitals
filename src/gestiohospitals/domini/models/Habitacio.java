package gestiohospitals.domini.models;

import java.util.Set;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "habitacio" )
public class Habitacio {

    @Id
	@EmbeddedId HabitacioId id;
	
	@ManyToOne
	@JoinColumn(name="nom_especialitat")
	Especialitat especialitat;
	
	@OneToMany
	Set<Ingres> ingressos;
	
	public Habitacio() {
		this.id = new HabitacioId();
	}
	
	public Habitacio( Integer numero, Hospital hospital ) {
		this.id = new HabitacioId( numero, hospital );
	}
	
	public Hospital getHospital() {
		return this.id.getHospital();
	}

	public void setHospital(Hospital hospital) {
		this.id.setHospital( hospital );
	}

	public Integer getNumero() {
		return this.id.getNumero();
	}

	public void setNumero(Integer numero) {
		this.id.setNumero( numero );
	}
	
}