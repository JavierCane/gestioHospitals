package DomainControllers;

import java.sql.Date;

public interface IEnviadorInformes
{

	public void enviarInformeIngres( String nomEspecialitat, Date d, String nomHospital, Integer numeroHabitacio, String nTsPacient, String dniMetge, String emailPacient ) throws Exception;
}
