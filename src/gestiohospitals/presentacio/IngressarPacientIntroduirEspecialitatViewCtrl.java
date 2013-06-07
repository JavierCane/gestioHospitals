/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.presentacio;

import java.util.ArrayList;

/**
 *
 * @author Otal
 */
public class IngressarPacientIntroduirEspecialitatViewCtrl extends BaseViewCtrl {

    private IngressarPacientIntroduirEspecialitatView view;
    private ArrayList llista;
    //private IngressarPacient domainCtrl;

    public IngressarPacientIntroduirEspecialitatViewCtrl() {
        view = new IngressarPacientIntroduirEspecialitatView();
        view.setCtrl(this);
    }

    public void prOkObteHospitals(String nomEsp) {
        if (nomEsp.isEmpty()) {
            view.mostraMissatge("No hi ha especialitat.");
        } else {
            /*
             * try {
             * domainCtrl.obteHospitalsLliuresPerEspecialitat(nomEsp);
             * }
             * catch() {
             * 
             */
            view.tancar();
            IngressarPacientSeleccionarHospitalViewCtrl ingresPacientSelecHospViewCtrl 
                    = new IngressarPacientSeleccionarHospitalViewCtrl(llista, nomEsp);
        }
    }
}
