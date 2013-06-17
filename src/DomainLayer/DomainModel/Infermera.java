package DomainLayer.DomainModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table( name = "infermera" )
@PrimaryKeyJoinColumn( name = "codi_empleat" )
public class Infermera extends Sanitari
{

	@Column( name = "torn" )
	private String torn;

	public Infermera()
	{
	}

	public Infermera( String torn, String codiEmpleat, Hospital hospital, String dni, String nom )
	{
		super( codiEmpleat, hospital, dni, nom );
		this.torn = torn;
	}

	public String getTorn()
	{
		return torn;
	}

	public void setTorn( String torn )
	{
		this.torn = torn;
	}
}
