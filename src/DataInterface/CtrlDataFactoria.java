package DataInterface;

/**
 * @author William
 */
public class CtrlDataFactoria {
    private CtrlEspecialitat ctrlEspecialitat;
    private CtrlHabitacio ctrlHabitacio;
    private static CtrlDataFactoria instancia;  

    private CtrlDataFactoria() {  
    
    }
    
    public static CtrlDataFactoria getInstance() {
        if(instancia == null){
            instancia = new CtrlDataFactoria();
        }
        return instancia;
    }
    
    public CtrlEspecialitat getCtrlEspecialitat( String nomEsp ) {
        if (ctrlEspecialitat == null) {
            ctrlEspecialitat = new CtrlEspecialitat();
        }
        return ctrlEspecialitat;
    }
}
