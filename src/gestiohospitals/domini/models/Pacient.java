package gestiohospitals.domini.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
	
//	@OneToMany( mappedBy = "pacient" )
//	private List<Ingres> ingresos = new ArrayList<>();

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
}
