package gestiohospitals.domini.models;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


@Embeddable
public class HabitacioId implements Serializable {

	private Integer numero;

	@ManyToOne(optional = false)    
	private Hospital hospital;
	
	public HabitacioId() {

	}

	public HabitacioId( Integer numero, Hospital hospital ) {
		this.numero = numero;
		this.hospital = hospital;
	}

	@Override
	public int hashCode() {
		int hash = 7;
		hash = 67 * hash + Objects.hashCode(this.hospital);
		hash = 67 * hash + Objects.hashCode(this.numero);
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
		final HabitacioId other = (HabitacioId) obj;
		if (!Objects.equals(this.hospital, other.hospital)) {
			return false;
		}
		if (!Objects.equals(this.numero, other.numero)) {
			return false;
		}
		return true;
	}

	public Hospital getHospital() {
		return hospital;
	}

	public void setHospital(Hospital hospital) {
		this.hospital = hospital;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
}
