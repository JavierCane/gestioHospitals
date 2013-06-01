/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.domini.models;

import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 */
@Entity
@Table( name = "especialitat" )
public class Especialitat {
    @Id
    @GeneratedValue
    @Column(name="nom")
    private String nom;
    
    @OneToMany(mappedBy="especialitat")
    private Set<Habitacio> habitacions;
    
    @OneToMany(mappedBy="especialitat")
    private Set<Metge> metges;
    
    
    public Especialitat(){
        
    }
    
    public Especialitat(String nom){
        this.nom=nom;
    }
    
    public Set<Habitacio> getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(Set<Habitacio> habitacions) {
        this.habitacions = habitacions;
    }

    public Set<Metge> getMetges() {
        return metges;
    }

    public void setMetges(Set<Metge> metges) {
        this.metges = metges;
    }
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
}
