package PresentationLayer;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IngressarPacientIntroduirEspecialitatView extends BaseView
{

	private IngressarPacientIntroduirEspecialitatViewCtrl viewCtrl;
	private JLabel jLabelEspecialitat;
	private JTextField jTextFieldEspecialitat;
	private JPanel jPanelCentral;

	public IngressarPacientIntroduirEspecialitatView()
	{
		initComponents();
	}

	public void setCtrl( IngressarPacientIntroduirEspecialitatViewCtrl viewCtrl )
	{
		this.viewCtrl = viewCtrl;
	}

	private void initComponents()
	{
		jLabelEspecialitat = new JLabel( "Especialitat:", JLabel.LEFT );

		jTextFieldEspecialitat = new JTextField();
		jTextFieldEspecialitat.setPreferredSize( new Dimension( 150, 24 ) );

		jPanelCentral = getPanelCentral();
		jPanelCentral.setLayout( new FlowLayout() );
		jPanelCentral.add( jLabelEspecialitat, BorderLayout.CENTER );
		jPanelCentral.add( jTextFieldEspecialitat, BorderLayout.CENTER );
	}

	@Override
	protected void jButtonOKActionPerformed( java.awt.event.ActionEvent evt )
	{
		viewCtrl.prOkObteHospitals( jTextFieldEspecialitat.getText() );
	}

	@Override
	protected void jButtonCancelActionPerformed( java.awt.event.ActionEvent evt )
	{
		viewCtrl.prCancel();
	}
}