package gestiohospitals.domini.models;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Persona
{
	@Column( name = "dni" )
	protected String dni;
	
	@Column( name = "nom" )
	protected String nom;

	public Persona()
	{
	}

	public Persona( String dni, String nom )
	{
		this.dni = dni;
		this.nom = nom;
	}

	public String getDni()
	{
		return dni;
	}

	public void setDni( String dni )
	{
		this.dni = dni;
	}

	public String getNom()
	{
		return nom;
	}

	public void setNom( String nom )
	{
		this.nom = nom;
	}
}
