/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package DataInterface;

import gestiohospitals.domini.models.HibernateUtil;
import gestiohospitals.domini.models.Hospital;
import gestiohospitals.domini.models.Pacient;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author William
 */
public class CtrlHospital
{
	public CtrlHospital() 
	{
		
    }
	
	public Boolean exist( String nomHosp ) 
	{
		if ( this.get( nomHosp ) == null ) return false;
		return true;
	}
	
	//String dni, String nom, String nTs, String email
	public Hospital get( String nomHosp )
	{
				// TODO  ??????
		SessionFactory factory = HibernateUtil.getSessionFactory();
		Session session = factory.openSession();

		Transaction tx = session.beginTransaction();
		
		Hospital e = (Hospital) session.get(Hospital.class, nomHosp);
		tx.commit();
		return e;
	}
}
