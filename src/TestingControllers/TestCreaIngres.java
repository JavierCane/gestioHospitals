package TestingControllers;

import DomainLayer.DomainControllers.IngressarPacient;

public class TestCreaIngres
{

	public static void main( String[] args ) throws Exception
	{
		IngressarPacient ip = new IngressarPacient();
		ip.creaIngres( "hospital molon", 1, "1248712" );
	}
}
