package DomainLayer.DomainModel;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class HabitacioId implements Serializable
{

	@Column( name = "numero" )
	private int numero;
	
	@ManyToOne( fetch = FetchType.LAZY )
	@JoinColumn( name = "nom_hospital" )
	private Hospital hospital;

	public HabitacioId()
	{
	}

	public HabitacioId( int numero, Hospital hospital )
	{
		this.numero = numero;
		this.hospital = hospital;
	}

	public int getNumero()
	{
		return numero;
	}

	public void setNumero( int numero )
	{
		this.numero = numero;
	}

	public Hospital getHospital()
	{
		return hospital;
	}

	public void setHospital( Hospital hospital )
	{
		this.hospital = hospital;
	}
}
