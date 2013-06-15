/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

/**
 *
 * @author William
 */
public class ServiceLocator
{
	
	private static ServiceLocator serviceLocator;
	private ServeiInformesSanitat serveiInformesSanitat;
	
    public static ServiceLocator getInstance() {
        if(serviceLocator == null){
            serviceLocator = new ServiceLocator();
        }
        return serviceLocator;
    }
	
	public ServeiInformesSanitat find( String name ) 
	{
		if ( name.equals( "serveiInformesSanitat" ) )
		{
			return serveiInformesSanitat = new ServeiInformesSanitat();
		}
		else
		{
			return null;
		}
	}
}






