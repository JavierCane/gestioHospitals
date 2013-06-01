/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.domini.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name="metge")
@PrimaryKeyJoinColumn(name="codi_empleat")
public class Infermera extends Sanitari{
    @Column( name = "torn")
    String torn;
    
     public Infermera(){
        super();
    }
    
    public Infermera(String dni, String nom, String codi_empleat, Hospital hospital, String torn){
        super(dni,nom,codi_empleat,hospital);
        this.torn=torn;
    }

    public String getTorn() {
        return torn;
    }

    public void setTorn(String torn) {
        this.torn = torn;
    }
}
