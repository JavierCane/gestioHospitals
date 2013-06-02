
package gestiohospitals.domini.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sanitari")
public class Sanitari extends Persona {
    @Id
    @GeneratedValue
    @Column(name="codi_empleat")
    protected String codiEmpleat;
    @ManyToOne
    @JoinColumn(name="nom_hospital")
    protected Hospital hospital;

    public Sanitari() {
    }



    public Sanitari(String codiEmpleat, Hospital hospital, String dni, String nom) {
        super(dni, nom);
        this.codiEmpleat = codiEmpleat;
        this.hospital = hospital;
    }

    public String getCodiEmpleat() {
        return codiEmpleat;
    }

    public void setCodiEmpleat(String codiEmpleat) {
        this.codiEmpleat = codiEmpleat;
    }
    
    
}
