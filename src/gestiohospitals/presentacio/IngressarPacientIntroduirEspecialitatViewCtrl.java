/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.presentacio;

/**
 *
 * @author Otal
 */
public class IngressarPacientIntroduirEspecialitatViewCtrl extends BaseViewCtrl {

    private IngressarPacientIntroduirEspecialitatView view;

    public IngressarPacientIntroduirEspecialitatViewCtrl() {
        view = new IngressarPacientIntroduirEspecialitatView();
        view.setCtrl(this);
    }

    public void prOkObteHospitals(String nomEsp) {
    }
}
