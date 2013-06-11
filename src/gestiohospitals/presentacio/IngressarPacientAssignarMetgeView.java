package gestiohospitals.presentacio;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class IngressarPacientAssignarMetgeView extends BaseView
{

	private IngressarPacientAssignarMetgeViewCtrl viewCtrl;
	private JPanel jPanelInfo;
	private JPanel jPanelCentral;
	private JLabel jLabelMetges;
	private JLabel jLabelInfoEsp;
	private JLabel jLabelInfoHosp;
	private JLabel jLabelInfoData;
	private JLabel jLabelInfoNTS;
	private JTable jTableMetges;
	private JScrollPane jScrollPaneTable;

	public IngressarPacientAssignarMetgeView()
	{
		initComponents();
	}

	public void setCtrl( IngressarPacientAssignarMetgeViewCtrl viewCtrl )
	{
		this.viewCtrl = viewCtrl;
	}

	public void setInfoEsp( String nomEsp )
	{
		jLabelInfoEsp.setText( "ESPECIALITAT: " + nomEsp.toUpperCase() );
	}

	public void setInfoHosp( String nomHosp )
	{
		jLabelInfoHosp.setText( "HOSPITAL: " + nomHosp.toUpperCase() );
	}

	public void setInfoNTS( String nTS )
	{
		jLabelInfoNTS.setText( "NÚMERO TARJETA SANITARIA: " + nTS.toUpperCase() );
	}

	public void setInfoData( String date )
	{
		jLabelInfoData.setText( "DATA: " + date );
	}

	private void initComponents()
	{
		jPanelInfo = getPanelInfo();

		jLabelInfoEsp = new JLabel();
		jLabelInfoEsp.setHorizontalAlignment( javax.swing.SwingConstants.LEFT );
		jLabelInfoEsp.setPreferredSize( new java.awt.Dimension( 300, 14 ) );
		jPanelInfo.add( jLabelInfoEsp, new org.netbeans.lib.awtextra.AbsoluteConstraints( 40, 5, 400, -1 ) );

		jLabelInfoHosp = new JLabel();
		jLabelInfoHosp.setHorizontalAlignment( javax.swing.SwingConstants.LEFT );
		jLabelInfoHosp.setPreferredSize( new java.awt.Dimension( 300, 14 ) );
		jPanelInfo.add( jLabelInfoHosp, new org.netbeans.lib.awtextra.AbsoluteConstraints( 40, 25, 400, -1 ) );

		jLabelInfoData = new JLabel();
		jLabelInfoData.setHorizontalAlignment( javax.swing.SwingConstants.LEFT );
		jLabelInfoData.setPreferredSize( new java.awt.Dimension( 300, 14 ) );
		jPanelInfo.add( jLabelInfoData, new org.netbeans.lib.awtextra.AbsoluteConstraints( 400, 25, 400, -1 ) );

		jLabelInfoNTS = new JLabel();
		jLabelInfoNTS.setHorizontalAlignment( javax.swing.SwingConstants.LEFT );
		jLabelInfoNTS.setPreferredSize( new java.awt.Dimension( 300, 14 ) );
		jPanelInfo.add( jLabelInfoNTS, new org.netbeans.lib.awtextra.AbsoluteConstraints( 400, 5, 400, -1 ) );

		jPanelCentral = getPanelCentral();

		jPanelCentral.setLayout( new java.awt.GridBagLayout() );

		java.awt.GridBagConstraints gridBagConstraints;

		jLabelMetges = new JLabel( "Metges:" );
		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 0;
		gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
		jPanelCentral.add( jLabelMetges, gridBagConstraints );

		jTableMetges = new JTable();
		jScrollPaneTable = new JScrollPane();
		jTableMetges.setModel( new javax.swing.table.DefaultTableModel(
				new Object[][]{
			{ null, null, null },
			{ null, null, null },
			{ null, null, null },
			{ null, null, null }
		},
				new String[]{
			"Nom", "DNI", "Categoria"
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
		jTableMetges.setRowSelectionAllowed( true );
		jTableMetges.setSelectionMode( ListSelectionModel.SINGLE_SELECTION );
		jTableMetges.getTableHeader().setReorderingAllowed( false );
		jScrollPaneTable.setMinimumSize( new java.awt.Dimension( 600, 340 ) );
		jScrollPaneTable.setViewportView( jTableMetges );

		gridBagConstraints = new java.awt.GridBagConstraints();
		gridBagConstraints.gridx = 0;
		gridBagConstraints.gridy = 1;
		jPanelCentral.add( jScrollPaneTable, gridBagConstraints );
	}

	@Override
	protected void jButtonOKActionPerformed( java.awt.event.ActionEvent evt )
	{
		int rowIndex = jTableMetges.getSelectedRow();
		String dniMetge = jTableMetges.getModel().getValueAt( rowIndex, 1 ).toString();
		viewCtrl.prOkIAssignarMetge( dniMetge );
	}

	@Override
	protected void jButtonCancelActionPerformed( java.awt.event.ActionEvent evt )
	{
		//mostraPopup
	}

	public void mostraMetges()
	{ //le tiene que pasar el set de medicos y llenar la tabla
		jTableMetges.setRowSelectionInterval( 0, 0 );
	}

	public void mostraPantallaEnviat()
	{
		//????
	}

	public void mostraPantallaNoEnviat()
	{
		//????
	}
}
