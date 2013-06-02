
package gestiohospitals.domini.models;


import java.io.Serializable;
import java.util.Set;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="habitacio")
public class Habitacio implements Serializable {
    @EmbeddedId
    private HabitacioId habitacioId;
    @ManyToOne
    @JoinColumn(name="nom_especialitat")
    private Especialitat especialitat;
    
    @OneToMany(mappedBy="habitacio")
    private Set<Ingres> ingresos;

    public Habitacio() {
    }

    public Habitacio(HabitacioId habitacioId, Especialitat especialitat, Set<Ingres> ingresos) {
        this.habitacioId = habitacioId;
        this.especialitat = especialitat;
        this.ingresos = ingresos;
    }

    public HabitacioId getHabitacioId() {
        return habitacioId;
    }

    public void setHabitacioId(HabitacioId habitacioId) {
        this.habitacioId = habitacioId;
    }

    public Set<Ingres> getIngresos() {
        return ingresos;
    }

    public void setIngresos(Set<Ingres> ingresos) {
        this.ingresos = ingresos;
    }

   



    public Especialitat getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(Especialitat especialitat) {
        this.especialitat = especialitat;
    }


}


