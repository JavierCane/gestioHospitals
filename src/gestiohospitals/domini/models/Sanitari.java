/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.domini.models;

import java.io.Serializable;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="sanitari")
@Inheritance(strategy=InheritanceType.JOINED)
//@PrimaryKeyJoinColumn(name="dni")
@AttributeOverrides({
    @AttributeOverride(name="nom", column=@Column(name="nom"))
})
public class Sanitari extends Persona implements Serializable {
	
	@Id
	@Column(name="codi_empleat")
	String codi_empleat;
	@Column(name="nom_hospital")
	Hospital hospital;

    public Sanitari(){
        super();
    }
    
    public Sanitari(String dni, String nom){
        super(dni,nom);
    }
    public Sanitari(String dni, String nom, String codi_empleat, Hospital hospital){
        super(dni,nom);
        this.codi_empleat=codi_empleat;
        this.hospital=hospital;
    }
    
    public String getCodi_empleat() {
        return codi_empleat;
    }

    public void setCodi_empleat(String codi_empleat) {
        this.codi_empleat = codi_empleat;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }
        
}
