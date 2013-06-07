package gestiohospitals.domini.models;

import java.io.Serializable;
import java.sql.Date;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class IngresId implements Serializable
{

	@Column( name = "data_inici" )
	private Date dataInici;
	@ManyToOne
	@JoinColumn( name = "n_ts_pacient" )
	private Pacient pacient;

	public IngresId()
	{
	}

	public IngresId( Date dataInici, Pacient pacient )
	{
		this.dataInici = dataInici;
		this.pacient = pacient;
	}

	public Date getDataInici()
	{
		return dataInici;
	}

	public void setDataInici( Date dataInici )
	{
		this.dataInici = dataInici;
	}

	public Pacient getPacient()
	{
		return pacient;
	}

	public void setPacient( Pacient pacient )
	{
		this.pacient = pacient;
	}
}
