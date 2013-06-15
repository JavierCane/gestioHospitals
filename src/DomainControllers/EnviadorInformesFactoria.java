/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainControllers;

/**
 *
 * @author William
 */
public class EnviadorInformesFactoria
{
	private static EnviadorInformesFactoria enviadorInformesFactoria;
	
	    
    public static EnviadorInformesFactoria getInstance() {
        if(enviadorInformesFactoria == null){
            enviadorInformesFactoria = new EnviadorInformesFactoria();
        }
        return enviadorInformesFactoria;
    }
	
	public EnviadorInformes getEnviadorInformes() 
	{
		
		return null;
	}
}
