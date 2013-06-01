
package gestiohospitals.domini.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="metge")
@PrimaryKeyJoinColumn(name="codi_empleat")
public class Metge extends Sanitari {
    
    @Column( name = "categoria")
    String categoria;
    
    @ManyToOne
    @JoinColumn(name="nom_especialitat")
    Especialitat especialitat;
    
    public Metge(){
        super();
    }
    
    public Metge(String dni, String nom, String codi_empleat, Hospital hospital, String categoria, Especialitat especialitat){
        super(dni,nom,codi_empleat,hospital);
        this.categoria=categoria;
        this.especialitat=especialitat;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Especialitat getEspecialitat() {
        return especialitat;
    }

    public void setEspecialitat(Especialitat especialitat) {
        this.especialitat = especialitat;
    }
    
    
}
