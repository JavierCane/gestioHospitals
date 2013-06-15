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
	private EnviadorInformesMail enviadorInformesMail;
	    
    public static EnviadorInformesFactoria getInstance() {
        if(enviadorInformesFactoria == null){
            enviadorInformesFactoria = new EnviadorInformesFactoria();
        }
        return enviadorInformesFactoria;
    }
	
	public EnviadorInformesMail getEnviadorInformes() 
	{
        if (enviadorInformesMail == null) {
            enviadorInformesMail = new EnviadorInformesMail();
        }
        return enviadorInformesMail;
    }
}
