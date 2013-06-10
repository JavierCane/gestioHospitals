package gestiohospitals.domini.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table( name = "metge" )
@PrimaryKeyJoinColumn( name = "codi_empleat" )
public class Metge extends Sanitari
{

	@Column( name = "categoria" )
	private String categoria;
	
	@ManyToOne
	@JoinColumn( name = "nom_especialitat", referencedColumnName = "nom_especialitat" )
	private Especialitat especialitat;
	
	//@OneToMany( mappedBy = "metge" )
	//private List<Ingres> ingresos = new ArrayList<>();

	public Especialitat getEspecialitat()
	{
		return especialitat;
	}

	public void setEspecialitat( Especialitat especialitat )
	{
		this.especialitat = especialitat;
	}

//	public Set<Ingres> getIngres()
//	{
//		return ingresos;
//	}
//
//	public void setIngres( Set<Ingres> ingres )
//	{
//		this.ingresos = ingres;
//	}

	public Hospital getHospital()
	{
		return hospital;
	}

	public void setHospital( Hospital hospital )
	{
		this.hospital = hospital;
	}

	public Metge()
	{
		super();
	}

	public Metge( String categoria, Especialitat especialitat, String codiEmpleat, Hospital hospital, String dni, String nom )
	{
		super( codiEmpleat, hospital, dni, nom );
		this.categoria = categoria;
		this.especialitat = especialitat;
	}

	public String getCategoria()
	{
		return categoria;
	}

	public void setCategoria( String categoria )
	{
		this.categoria = categoria;
	}
}
