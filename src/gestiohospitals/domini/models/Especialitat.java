package gestiohospitals.domini.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.*;
import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.swing.JOptionPane;
@Entity
@Table(name = "especialitat")
public class Especialitat {
    @Id
    @Column(name = "nom")
    private String nom;
    @OneToMany(mappedBy="especialitat")
    private ArrayList<Metge> metges;
    @OneToMany(mappedBy="especialitat")
    private ArrayList<Habitacio> habitacions;
    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="hospital_especialitat", 
                joinColumns={@JoinColumn(name="nom")}, 
                inverseJoinColumns={@JoinColumn(name="nom")})
    private ArrayList<Hospital> hospitals=new ArrayList<Hospital> ();

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
