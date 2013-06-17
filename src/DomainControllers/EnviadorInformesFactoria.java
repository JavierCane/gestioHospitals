package DomainControllers;

public class EnviadorInformesFactoria
{

	private static EnviadorInformesFactoria enviadorInformesFactoria;
	private EnviadorInformesMail enviadorInformesMail;

	public static EnviadorInformesFactoria getInstance()
	{
		if ( enviadorInformesFactoria == null )
		{
			enviadorInformesFactoria = new EnviadorInformesFactoria();
		}
		return enviadorInformesFactoria;
	}

	public EnviadorInformesMail getEnviadorInformes()
	{
		if ( enviadorInformesMail == null )
		{
			enviadorInformesMail = new EnviadorInformesMail();
		}
		return enviadorInformesMail;
	}
}
