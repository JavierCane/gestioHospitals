/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.domini.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 *
 * @author juanperezpineda
 */
@Entity
@Table( name = "persona" )
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)      
public class Persona {
    @Id
    @Column( name = "dni" )
    private String dni;
    
    @Column( name = "nom" )
    private String nom;
    
    public Persona(){
        
    }
    
    public Persona(String dni, String nom){
        this.dni=dni;
        this.nom=nom;
    }
    
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
}
