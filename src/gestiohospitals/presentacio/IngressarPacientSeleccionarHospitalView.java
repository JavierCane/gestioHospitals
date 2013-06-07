/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiohospitals.presentacio;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 *
 * @author Otal
 */
public class IngressarPacientSeleccionarHospitalView extends BaseView {

    private IngressarPacientSeleccionarHospitalViewCtrl viewCtrl;
    private JLabel jLabelInfoEsp;
    private JButton jButtonCancel;
    private JButton jButtonOK;
    private JPanel jPanelCentral;
    private JPanel jPanelInfo;
    private JLabel jLabelHabLliures;
    private JLabel jLabelHospitals;
    private JLabel jLabelNTS;
    private JScrollPane jScrollPaneList;
    private JScrollPane jScrollPaneTable;
    private JTable jTableHospitals;
    private JList jListHabLliures;
    private JTextField jTextFieldNTS;

    public IngressarPacientSeleccionarHospitalView() {
        initComponents();
    }

    public void setCtrl(IngressarPacientSeleccionarHospitalViewCtrl viewCtrl) {
        this.viewCtrl = viewCtrl;
    }

    public void setInfoEsp(String nomEsp) {
        jLabelInfoEsp.setText("Especialitat: " + nomEsp);
    }

    private void initComponents() {
        jPanelInfo = getPanelInfo();
        jLabelInfoEsp = new JLabel();
        jLabelInfoEsp.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabelInfoEsp.setPreferredSize(new java.awt.Dimension(200, 14));
        jPanelInfo.add(jLabelInfoEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 5, 180, -1));

        jPanelCentral = getPanelCentral();

        jPanelCentral.setLayout(new java.awt.GridBagLayout());

        java.awt.GridBagConstraints gridBagConstraints;

        jLabelNTS = new JLabel("nTS:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(0, 40, 0, 40);
        jPanelCentral.add(jLabelNTS, gridBagConstraints);

        jTextFieldNTS = new JTextField();
        jTextFieldNTS.setMaximumSize(new java.awt.Dimension(150, 24));
        jTextFieldNTS.setMinimumSize(new java.awt.Dimension(150, 24));
        jTextFieldNTS.setPreferredSize(new java.awt.Dimension(150, 24));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        jPanelCentral.add(jTextFieldNTS, gridBagConstraints);

        jLabelHospitals = new JLabel("Hospitals:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        jPanelCentral.add(jLabelHospitals, gridBagConstraints);

        jTableHospitals = new JTable();
        jScrollPaneTable = new JScrollPane();
        jTableHospitals.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
            {null, null, null},
            {null, null, null},
            {null, null, null},
            {null, null, null}
        },
                new String[]{
            "Nom", "Descripció", "Adreça"
        }) {
            boolean[] canEdit = new boolean[]{
                false, false, false
            };

            @Override
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });
        //jTableHospitals.setPreferredSize(new java.awt.Dimension(225, 200));
        jTableHospitals.getTableHeader().setResizingAllowed(false);
        jTableHospitals.getTableHeader().setReorderingAllowed(false);
        jScrollPaneTable.setMinimumSize(new java.awt.Dimension(400, 70));
        jScrollPaneTable.setViewportView(jTableHospitals);
        jTableHospitals.getColumnModel().getColumn(1).setResizable(false);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        jPanelCentral.add(jScrollPaneTable, gridBagConstraints);

        jLabelHabLliures = new JLabel("Habitacions lliures:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        jPanelCentral.add(jLabelHabLliures, gridBagConstraints);
        
        String[] options = {"VERTICAL", "HORIZONTAL_WRAP", "VERTICAL_WRAP"};
        jListHabLliures = new JList(options);
        jScrollPaneList = new JScrollPane();
        jListHabLliures.setModel(new javax.swing.AbstractListModel() {
            String[] strings = {"hab1", "hab2", "hab3"};

            @Override
            public int getSize() {
                return strings.length;
            }

            @Override
            public Object getElementAt(int i) {
                return strings[i];
            }
        });
        jListHabLliures.setVisibleRowCount(1);  
        jListHabLliures.setLayoutOrientation(JList.HORIZONTAL_WRAP);  
        jScrollPaneList.setMinimumSize(new java.awt.Dimension(400, 20));
        jScrollPaneList.setViewportView(jListHabLliures);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        jPanelCentral.add(jScrollPaneList, gridBagConstraints);

        jButtonCancel = getCancelButton();
        jButtonCancel.addActionListener(new java.awt.event.ActionListener() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelActionPerformed(evt);
            }
        });
    }

    private void jButtonCancelActionPerformed(java.awt.event.ActionEvent evt) {
        viewCtrl.prCancel(this);
    }
}
