package DomainLayer.DomainModel;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table( name = "pacient" )
public class Pacient extends Persona
{

	@Id
	@Column( name = "n_ts" )
	private String nTs;
	
	@Column( name = "email" )
	private String email;
	
	@OneToMany( mappedBy = "ingresId.pacient" )
	private List<Ingres> ingresos = new ArrayList<>();

	public Pacient()
	{
	}

	public Pacient( String dni, String nom, String nTs, String email )
	{
		super( dni, nom );
		this.nTs = nTs;
		this.email = email;
	}

	public String getnTs()
	{
		return nTs;
	}

	public void setnTs( String nTs )
	{
		this.nTs = nTs;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail( String email )
	{
		this.email = email;
	}

	/*
	 * Seguint amb el disseny del diagrama de sequencia, es comprova si el pacient esta o no ingressat.
	 */
	public Boolean estaIngressat()
	{
		boolean ingressat = false;

		Iterator it = ingresos.iterator();
		while ( it.hasNext() && !ingressat )
		{
			Object h = it.next();
			ingressat = !( ( Ingres ) h ).teAlta();
		}

		return ingressat;
	}

	public void addIngresos( Ingres ingres ) throws Exception
	{
		if ( estaIngressat() )
		{
			throw new Exception( "pacientIngressat" );
		}

		ingresos.add( ingres );
	}
}
