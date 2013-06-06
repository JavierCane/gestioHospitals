/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.presentacio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Otal
 */
public class IngressarPacientIntroduirEspecialitatView extends BaseView {

    private IngressarPacientIntroduirEspecialitatViewCtrl viewCtrl;
    private JLabel jLabelEspecialitat;
    private JTextField jTextFieldEspecialitat;
    private JPanel jPanel;
    private JButton jButtonCancel;
    private JButton jButtonOK;

    public IngressarPacientIntroduirEspecialitatView() {
        initComponents();
    }

    public void setCtrl(IngressarPacientIntroduirEspecialitatViewCtrl viewCtrl) {
        this.viewCtrl = viewCtrl;
    }

    private void initComponents() {
        jLabelEspecialitat = new JLabel("Especialitat", JLabel.LEFT);
        
        jTextFieldEspecialitat = new JTextField();
        jTextFieldEspecialitat.setPreferredSize(new Dimension(150, 24));
        
        jPanel = getPanelCentral();
        jPanel.setLayout(new FlowLayout());
        jPanel.add(jLabelEspecialitat, BorderLayout.CENTER); //no centra
        jPanel.add(jTextFieldEspecialitat, BorderLayout.CENTER);

        jButtonOK = getOKButton();
        jButtonOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonOKActionPerformed(evt);
            }
        });

        jButtonCancel = getCancelButton();
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
    }

    private void jButtonOKActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
        if (jTextFieldEspecialitat.getText().isEmpty()) {
            getTextFieldMessageArea().setText("No hi ha especialitat.");
        } else {
            getTextFieldMessageArea().setText("Basura de programa.");
        }
    }

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        viewCtrl.prCancel(this);
    }
}