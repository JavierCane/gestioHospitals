package DomainLayer.DomainModel;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "habitacio" )
public class Habitacio implements Serializable
{

	@EmbeddedId
	private HabitacioId habitacioId;
	
	@ManyToOne
	@JoinColumn( name = "nom_especialitat" )
	private Especialitat especialitat;
	
	@OneToMany( mappedBy = "habitacio" )
	private List<Ingres> ingresos = new ArrayList<>();

	public Habitacio()
	{
	}

	public Habitacio( HabitacioId habitacioId, Especialitat especialitat )
	{
		this.habitacioId = habitacioId;
		this.especialitat = especialitat;
	}

	public Habitacio( HabitacioId habitacioId, Especialitat especialitat, List<Ingres> ingresos )
	{
		this.habitacioId = habitacioId;
		this.especialitat = especialitat;
		this.ingresos = ingresos;
	}

	public HabitacioId getHabitacioId()
	{
		return habitacioId;
	}

	public Boolean esEspecialitat( String nom )
	{
		return nom.equals( especialitat.getNom() );
	}

	public Boolean estaLliure()
	{
		Boolean lliure = true;
		Iterator it = ingresos.iterator();

		while ( it.hasNext() && lliure )
		{
			Object i = it.next();
			lliure = ( ( Ingres ) i ).teAlta();
		}

		return lliure;
	}

	public void setHabitacioId( HabitacioId habitacioId )
	{
		this.habitacioId = habitacioId;
	}

	public List<Ingres> getIngresos()
	{
		return ingresos;
	}

	public void setIngresos( List<Ingres> ingresos )
	{
		this.ingresos = ingresos;
	}

	public Especialitat getEspecialitat()
	{
		return especialitat;
	}

	public void setEspecialitat( Especialitat especialitat )
	{
		this.especialitat = especialitat;
	}

	public void addIngresos( Ingres i )
	{
		ingresos.add( i );
	}
}
