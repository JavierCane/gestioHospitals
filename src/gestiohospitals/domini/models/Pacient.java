/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.domini.models;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name="pacient")
@AttributeOverrides({
    @AttributeOverride(name="nom", column=@Column(name="nom"))
})
public class Pacient extends Persona {
    @Id
    @Column( name="n_ts" )
    String n_ts;
    @Column( name="email" )
    String email;
    
    public Pacient(){
        super();
    }
    
    public Pacient(String dni, String nom){
        super(dni,nom);
    }
    public Pacient(String dni, String nom, String n_ts, String email){
        super(dni,nom);
        this.email=email;
        this.n_ts=n_ts;
    }

    public String getN_ts() {
        return n_ts;
    }

    public void setN_ts(String n_ts) {
        this.n_ts = n_ts;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
