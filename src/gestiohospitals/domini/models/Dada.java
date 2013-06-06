/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.domini.models;

import java.util.ArrayList;

/**
 *
 * @author William
 */
public class Dada {
    private String nom;
    private String adreca;
    private String descripcio;
    private ArrayList<Integer> habLliures;

    public Dada() {
        habLliures = new ArrayList<>();
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setAdreca(String adreca) {
        this.adreca = adreca;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

    public void setHabLliures(ArrayList<Integer> habLliures) {
        this.habLliures = habLliures;
    }
    
    public String getNom() {
        return nom;
    }

    public String getAdreca() {
        return adreca;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public ArrayList<Integer> getHabLliures() {
        return habLliures;
    }
    
    public Dada(String nom, String adreca, String descripcio, ArrayList<Integer> habLliures) {
        this.nom = nom;
        this.adreca = adreca;
        this.descripcio = descripcio;
        this.habLliures = habLliures;
    }
    
    

}
