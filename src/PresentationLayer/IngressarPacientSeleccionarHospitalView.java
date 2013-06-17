package PresentationLayer;

import java.awt.Insets;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

public class IngressarPacientSeleccionarHospitalView extends BaseView
{

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
	private DefaultTableModel tableModel;
	private DefaultListModel listModel;
	private List llistaHospitals;

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

	public void setLlistaHospitals( List llistaHospitals )
	{
		this.llistaHospitals = llistaHospitals;
	}

	public boolean getAssignarMetgeCheckBoxIsChecked()
	{
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
		tableModel = new javax.swing.table.DefaultTableModel(
				new Object[ 0 ][ 3 ],
				new String[]
		{
			"Nom", "Descripció", "Adreça"
		} )
		{
			boolean[] canEdit = new boolean[]
			{
				false, false, false
			};

			@Override
			public boolean isCellEditable( int rowIndex, int columnIndex )
			{
				return canEdit[columnIndex];
			}
		};
		jTableHospitals.setModel( tableModel );
		jTableHospitals.setRowSelectionAllowed( true );
		jTableHospitals.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		jTableHospitals.getTableHeader().setReorderingAllowed( false );
		jScrollPaneTable.setMinimumSize( new java.awt.Dimension( 500, 340 ) );
		jScrollPaneTable.setViewportView( jTableHospitals );
		jTableHospitals.addMouseListener( new java.awt.event.MouseAdapter()
		{
			@Override
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
		listModel = new DefaultListModel();
		jListHabLliures.setModel( listModel );
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
		viewCtrl.prCancel();
	}

	@Override
	protected void jButtonOKActionPerformed( java.awt.event.ActionEvent evt )
	{
		nTS = jTextFieldNTS.getText();
		String numHabitacioString = jListHabLliures.getSelectedValue().toString();
		int rowIndex = jTableHospitals.getSelectedRow();
		nomHospital = jTableHospitals.getModel().getValueAt( rowIndex, 0 ).toString();
		numHabitacio = Integer.parseInt( numHabitacioString );
		viewCtrl.prOkEnviarInforme( nomHospital, numHabitacio, nTS );
	}

	/**
	 * Listener para mostrar las habitaciones libres del hospital seleccionado
	 *
	 * @param evt
	 */
	private void jTableHospitalsMouseClicked( java.awt.event.MouseEvent evt )
	{
		int rowIndex = jTableHospitals.getSelectedRow();
		viewCtrl.canviarSeleccionarHospital( rowIndex );
	}

	/**
	 * Rellena la tabla de hospitals con toda su respectiva información.
	 */
	public void mostraHospitals()
	{
		DomainLayer.DomainModel.Dada dada;
		for ( int i = 0; i < llistaHospitals.size(); i++ )
		{
			tableModel.addRow( new Object[ 3 ] );
			for ( int j = 0; j < 3; j++ )
			{
				dada = ( DomainLayer.DomainModel.Dada ) llistaHospitals.get( i );
				if ( j == 0 )
				{
					jTableHospitals.setValueAt( dada.getNom(), i, j );
				}
				else
				{
					if ( j == 1 )
					{
						jTableHospitals.setValueAt( dada.getDescripcio(), i, j );
					}
					else
					{
						if ( j == 2 )
						{
							jTableHospitals.setValueAt( dada.getAdreca(), i, j );
						}
					}
				}
			}
		}
		jTableHospitals.setRowSelectionInterval( 0, 0 );
	}

	/**
	 * Rellena la lista de habitaciones libres.
	 *
	 * @param numHabitacions
	 */
	public void actualitzaHabitacionsLliures( List<Integer> numHabitacions )
	{
		listModel.removeAllElements();
		for ( int i = 0; i < numHabitacions.size(); i++ )
		{
			listModel.addElement( numHabitacions.get( i ) );
		}
		jListHabLliures.setSelectionInterval( 0, 0 );
	}
}
