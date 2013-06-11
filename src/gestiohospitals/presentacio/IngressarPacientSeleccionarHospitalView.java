package gestiohospitals.presentacio;

import java.awt.Insets;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class IngressarPacientSeleccionarHospitalView extends BaseView
{

	private class InfoHosp
	{

		private String nomHosp;
		int habLliures[];
	}
	private IngressarPacientSeleccionarHospitalViewCtrl viewCtrl;
	private String nomHospital;
	private int numHabitacio;
	private String nTS;
	private JLabel jLabelInfoEsp;
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
	private JCheckBox jCheckBoxAssignarMetge;

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
	
	public boolean getAssignarMetgeCheckBoxIsChecked() {
		return jCheckBoxAssignarMetge.isSelected();
	}

	private void initComponents()
	{
		jPanelInfo = getPanelInfo();
		jLabelInfoEsp = new JLabel();
		jLabelInfoEsp.setHorizontalAlignment( javax.swing.SwingConstants.LEFT );
		jLabelInfoEsp.setPreferredSize( new java.awt.Dimension( 400, 14 ) );
		jPanelInfo.add( jLabelInfoEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints( 40, 20, 400, -1 ) );

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
		jTableHospitals.setRowSelectionAllowed( true );
		jTableHospitals.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		jTableHospitals.getTableHeader().setReorderingAllowed( false );
		jScrollPaneTable.setMinimumSize( new java.awt.Dimension( 500, 340 ) );
		jScrollPaneTable.setViewportView( jTableHospitals );
		jTableHospitals.addMouseListener( new java.awt.event.MouseAdapter()
		{
			public void mouseClicked( java.awt.event.MouseEvent evt )
			{
				jTableHospitalsMouseClicked( evt );
			}
		} );

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
			String[] strings = { "8", "10", "22" };

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
		jScrollPaneList.setMinimumSize( new java.awt.Dimension( 100, 340 ) );
		jScrollPaneList.setViewportView( jListHabLliures );

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 3;
		gridBagConstraints.gridy = 2;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		gridBagConstraints.insets = new Insets( 0, 10, 0, 0 );
		jPanelCentral.add( jScrollPaneList, gridBagConstraints );

		jCheckBoxAssignarMetge = new JCheckBox( "Assignar metge" );
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 4;
		jPanelCentral.add( jCheckBoxAssignarMetge, gridBagConstraints );
	}

	@Override
	protected void jButtonCancelActionPerformed( java.awt.event.ActionEvent evt )
	{
		viewCtrl.prCancel( this );
	}

	@Override
	protected void jButtonOKActionPerformed( java.awt.event.ActionEvent evt )
	{
		nTS = jTextFieldNTS.getText();
		String numHabitacioString =  jListHabLliures.getSelectedValue().toString();
		numHabitacio = Integer.parseInt( numHabitacioString);
		viewCtrl.prOkEnviarInforme( nomHospital, numHabitacio, nTS );
	}

	private void jTableHospitalsMouseClicked( java.awt.event.MouseEvent evt )
	{
		int rowIndex = jTableHospitals.getSelectedRow();
		nomHospital = jTableHospitals.getModel().getValueAt( rowIndex, 0 ).toString();
		viewCtrl.canviarSeleccionarHospital( nomHospital );
	}

	public void mostraHospitals( InfoHosp llistaHospitals[] )
	{
		//codigo de rellenar la tabla
		jTableHospitals.setRowSelectionInterval( 0, 0 );
	}

	public void actualitzaHabitacionsLliures( int numHabitacions[] )
	{
		//codigo para rellenar la lista
		jListHabLliures.setSelectionInterval( 0, 0 );
	}
}
