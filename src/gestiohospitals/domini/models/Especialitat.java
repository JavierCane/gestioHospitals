
package gestiohospitals.domini.models;


import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.*;
import javax.swing.JOptionPane;
@Entity
@Table(name = "especialitat")
public class Especialitat {
    @Id
    @GeneratedValue
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy="especialitat")
    private ArrayList<Metge> metges;
    @OneToMany(mappedBy="especialitat")
    private ArrayList<Habitacio> habitacions;

    public Especialitat() {
    }
    
    public Especialitat(String nom) {
        this.nom = nom;
    }

    public ArrayList<Habitacio> getHabitacions() {
        return habitacions;
    }

    public void setHabitacions(ArrayList<Habitacio> habitacions) {
        this.habitacions = habitacions;
    }

  
    public ArrayList<Metge> getMetges() {
        return metges;
    }

    public void setMetges(ArrayList<Metge> metges) {
        this.metges = metges;
    }

   

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
    
    
    public List getHabitacionsLliuresHospitals() {
        ArrayList<Dada> llistaHabitacions = new ArrayList();
        Iterator it = hospitals.iterator();
        Dada d;
        while (it.hasNext()) {
            Object h = it.next();
            d = ((Hospital)h).getHabitacionsLliures( nom );
            if (d.getHabLliures().size() > 0) {
                llistaHabitacions.add(d);
            }
            else { JOptionPane.showMessageDialog(null, "Exc: noHiHaHopstials -> habLliures no es > 0 " + ((Hospital)h).getNom() ); }
        }
        return llistaHabitacions;
    }
    
}
