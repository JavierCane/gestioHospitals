package gestiohospitals.presentacio;

import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class IngressarPacientSeleccionarHospitalView extends BaseView
{

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

	public IngressarPacientSeleccionarHospitalView()
	{
		initComponents();
	}

	public void setCtrl( IngressarPacientSeleccionarHospitalViewCtrl viewCtrl )
	{
		this.viewCtrl = viewCtrl;
	}

	public void setInfoEsp( String nomEsp )
	{
		jLabelInfoEsp.setText( "ESPECIALITAT: " + nomEsp.toUpperCase() );
	}

	private void initComponents()
	{
		jPanelInfo = getPanelInfo();
		jLabelInfoEsp = new JLabel();
		jLabelInfoEsp.setHorizontalAlignment( javax.swing.SwingConstants.LEFT );
		jLabelInfoEsp.setPreferredSize( new java.awt.Dimension( 200, 14 ) );
		jPanelInfo.add( jLabelInfoEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints( 40, 20, 180, -1 ) );

		jPanelCentral = getPanelCentral();

		jPanelCentral.setLayout( new java.awt.GridBagLayout() );

		java.awt.GridBagConstraints gridBagConstraints;

		jLabelNTS = new JLabel( "Número tarjeta sanitaria: " );
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanelCentral.add( jLabelNTS, gridBagConstraints );

		jTextFieldNTS = new JTextField();
		jTextFieldNTS.setMinimumSize( new java.awt.Dimension( 150, 24 ) );
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 1;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanelCentral.add( jTextFieldNTS, gridBagConstraints );

		jLabelHospitals = new JLabel( "Hospitals:" );
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanelCentral.add( jLabelHospitals, gridBagConstraints );

		jTableHospitals = new JTable();
		jScrollPaneTable = new JScrollPane();
		jTableHospitals.setModel( new javax.swing.table.DefaultTableModel(
				new Object[][]{
					{ null, null, null },
					{ null, null, null },
					{ null, null, null },
					{ null, null, null }
				},
				new String[]{
					"Nom", "Descripció", "Adreça"
				} )
		{
			boolean[] canEdit = new boolean[]{
				false, false, false
			};

			@Override
			public boolean isCellEditable( int rowIndex, int columnIndex )
			{
				return canEdit[columnIndex];
			}
		} );
		//jTableHospitals.setPreferredSize(new java.awt.Dimension(225, 200));
		jTableHospitals.getTableHeader().setResizingAllowed( false );
		jTableHospitals.getTableHeader().setReorderingAllowed( false );
		jScrollPaneTable.setMinimumSize( new java.awt.Dimension( 500, 380 ) );
		jScrollPaneTable.setViewportView( jTableHospitals );
		jTableHospitals.getColumnModel().getColumn( 1 ).setResizable( false );

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.gridwidth = 2;
		jPanelCentral.add( jScrollPaneTable, gridBagConstraints );

		jLabelHabLliures = new JLabel( "Habitacions lliures:" );
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 1;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets( 0, 10, 0, 0 );
		jPanelCentral.add( jLabelHabLliures, gridBagConstraints );


		jListHabLliures = new JList();
		jScrollPaneList = new JScrollPane();
		jListHabLliures.setModel( new javax.swing.AbstractListModel()
		{
			String[] strings = { "hab1", "hab2", "hab3" };

			@Override
			public int getSize()
			{
				return strings.length;
			}

			@Override
			public Object getElementAt( int i )
			{
				return strings[i];
			}
		} );
		jScrollPaneList.setMinimumSize( new java.awt.Dimension( 100, 380 ) );
		jScrollPaneList.setViewportView( jListHabLliures );

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets( 0, 10, 0, 0 );
		jPanelCentral.add( jScrollPaneList, gridBagConstraints );

		jButtonCancel = getCancelButton();
		jButtonCancel.addActionListener( new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed( java.awt.event.ActionEvent evt )
			{
				jButtonCancelActionPerformed( evt );
			}
		} );
	}

	private void jButtonCancelActionPerformed( java.awt.event.ActionEvent evt )
	{
		viewCtrl.prCancel( this );
	}
}
