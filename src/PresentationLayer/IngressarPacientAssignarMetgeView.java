package PresentationLayer;

import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

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
	private DefaultTableModel tableModel;

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
		tableModel = new javax.swing.table.DefaultTableModel(
				new Object[ 0 ][ 3 ],
				new String[]{
			"DNI", "Nom", "Categoria"
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
		};
		jTableMetges.setModel( tableModel );
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
		String dniMetge = jTableMetges.getModel().getValueAt( rowIndex, 0 ).toString();
		viewCtrl.prOkIAssignarMetge( dniMetge );
	}

	@Override
	protected void jButtonCancelActionPerformed( java.awt.event.ActionEvent evt )
	{
		viewCtrl.enviarInforme();
	}

	public void mostraMetges( List<String[]> llistaMetges )
	{
		for ( int i = 0; i < llistaMetges.size(); i++ ) {
			tableModel.addRow( llistaMetges.get( i ) );
		}
		jTableMetges.setRowSelectionInterval(0, 0 );
	}

	public void mostraPantallaEnviat()
	{
		//???? supongo que sobra
	}

	public void mostraPantallaNoEnviat()
	{
		//????
	}
}
