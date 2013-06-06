
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
    @Column(name="nom")
    private String nom;
    @Column(name="adreca")
    private String adreca;
    @Column(name="descripcio")
    private String descripcio;
    @OneToMany(mappedBy="hospital")
    private ArrayList<Ingres> ingresos;

	@OneToMany( mappedBy = "id.hospital", cascade = CascadeType.ALL, fetch = FetchType.LAZY )
	private ArrayList<Habitacio> habitacions;

	//fer hibernate per escepialsts
    private ArrayList<Especialitat> especialitats;

    public Hospital() {
    }
    
	//hay que pasarle por parametro array especialitats
	//public Hospital( String nom, String adreca, String descripcio, Especialitat nomEsp ) {
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
    
    
               
        public Dada getHabitacionsLliures( String nom ) {
            Dada d = new Dada();
            Iterator it = habitacions.iterator();
            while (it.hasNext()) {
                Object h = it.next();
                if ( ((Habitacio)h).esEspecialitat( nom ) ) {
                    if ( ((Habitacio)h).estaLliure() ) { d.getHabLliures().add( ((Habitacio)h).getNumero() ); }
                }
            }
            if ( d.getHabLliures().size() > 0 ) {
                d.setNom(this.nom);
                d.setAdreca(adreca);
                d.setDescripcio(descripcio);
            }
            /*
             dada:TupleType( nom:String, adreca:String, descripcio:String, habLliures:Set( num: Integer ))
             * */
            return d;
        }
}
