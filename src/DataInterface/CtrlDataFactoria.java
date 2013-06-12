package DataInterface;

/**
 * @author William
 */
public class CtrlDataFactoria {
    private CtrlEspecialitat ctrlEspecialitat;
    private CtrlHabitacio ctrlHabitacio;
	private CtrlPacient ctrlPacient;
	private CtrlHospital ctrlHospital;
	private CtrlMetge ctrlMetge;
    private static CtrlDataFactoria instancia;  
    private CtrlIngres ctrlIngres;
    private CtrlDataFactoria() {  
    
    }
    
    public static CtrlDataFactoria getInstance() {
        if(instancia == null){
            instancia = new CtrlDataFactoria();
        }
        return instancia;
    }
    
    public CtrlEspecialitat getCtrlEspecialitat() {
        if (ctrlEspecialitat == null) {
            ctrlEspecialitat = new CtrlEspecialitat();
        }
        return ctrlEspecialitat;
    }
	
	public CtrlPacient getCtrlPacient() {
        if (ctrlPacient == null) {
            ctrlPacient = new CtrlPacient();
        }
        return ctrlPacient;
    }
	
	public CtrlHabitacio getCtrlHabitacio() {
        if (ctrlHabitacio == null) {
            ctrlHabitacio = new CtrlHabitacio();
        }
        return ctrlHabitacio;
    }
	
	public CtrlHospital getCtrlHospital() {
        if (ctrlHospital == null) {
            ctrlHospital = new CtrlHospital();
        }
        return ctrlHospital;
    }
	
	public CtrlMetge getCtrlMetge() {
        if (ctrlMetge == null) {
            ctrlMetge = new CtrlMetge();
        }
        return ctrlMetge;
    }
        public CtrlIngres getCtrlIngres() {
        if (ctrlIngres == null) {
            ctrlIngres = new CtrlIngres();
        }
        return ctrlIngres;
    }
}
