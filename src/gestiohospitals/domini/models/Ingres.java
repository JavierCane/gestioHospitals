/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.domini.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ingres")
public class Ingres {
    @Id
    @GeneratedValue
    private int id;
    
    @ManyToOne
    @JoinColumn(name="pacient_id")
    private Pacient pacient;
    
    @ManyToOne
    @JoinColumn(name="nom_hospital")
    private Hospital hospital;
    
    @ManyToOne
    @JoinColumn(name="habitacio_id")
    private Habitacio habitacio;
    
    @ManyToOne
    @JoinColumn(name="metge_id")
    
    private Metge metge;

    public Ingres() {
    }
    
    public Ingres(int id, Pacient pacient, Hospital hospital, Habitacio habitacio){
        this.id=id;
        this.pacient=pacient;
        this.hospital=hospital;
        this.habitacio=habitacio;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Pacient getPacient() {
        return pacient;
    }

    public void setPacient(Pacient pacient) {
        this.pacient = pacient;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Habitacio getHabitacio() {
        return habitacio;
    }

    public void setHabitacio(Habitacio habitacio) {
        this.habitacio = habitacio;
    }

    public Metge getMetge() {
        return metge;
    }

    public void setMetge(Metge metge) {
        this.metge = metge;
    }
    
    
    
}

