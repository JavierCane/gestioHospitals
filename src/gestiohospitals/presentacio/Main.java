/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.presentacio;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Otal
 */
public class Main {

    public Main() {
    }

    public static void main(String[] args) {
        try {
            // Set cross-platform Java L&F (also called "Metal")
            UIManager.setLookAndFeel(
                    UIManager.getSystemLookAndFeelClassName());
        } catch (UnsupportedLookAndFeelException | ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            // handle exception
        }
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                IngressarPacientIntroduirEspecialitatViewCtrl viewCtrl =
                        new IngressarPacientIntroduirEspecialitatViewCtrl();
            }
        });
    }
}
