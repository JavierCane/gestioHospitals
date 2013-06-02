
package gestiohospitals.domini.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="hospital")
public class Hospital {
    @Id
    @GeneratedValue
    @Column(name="nom")
    private String nom;
    @Column(name="adreca")
    private String adreca;
    @Column(name="descripcio")
    private String descripcio;
    @OneToMany(mappedBy="hospital")
    private Set<Ingres> ingresos;

    public Hospital() {
    }
    
    public Hospital(String nom, String adreca, String descripcio) {
        this.nom = nom;
        this.adreca = adreca;
        this.descripcio = descripcio;
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
    
    
}
