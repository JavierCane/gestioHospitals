package DataInterface;
import gestiohospitals.domini.models.*;

/**
 * @author William
 */
public class CtrlEspecialitat {
    private Especialitat e;
    
    public CtrlEspecialitat() {
        
    }
    public Especialitat getEspecialitat( String nomEsp ) {
        return e = new Especialitat( nomEsp );
    }
}
