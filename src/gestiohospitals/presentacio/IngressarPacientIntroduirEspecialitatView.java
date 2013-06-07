package gestiohospitals.presentacio;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class IngressarPacientIntroduirEspecialitatView extends BaseView
{

	private IngressarPacientIntroduirEspecialitatViewCtrl viewCtrl;
	private JLabel jLabelEspecialitat;
	private JTextField jTextFieldEspecialitat;
	private JPanel jPanelCentral;
	private JButton jButtonCancel;
	private JButton jButtonOK;

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
		jLabelEspecialitat = new JLabel( "Especialitat", JLabel.LEFT );

		jTextFieldEspecialitat = new JTextField();
		jTextFieldEspecialitat.setPreferredSize( new Dimension( 150, 24 ) );

		jPanelCentral = getPanelCentral();
		jPanelCentral.setLayout( new FlowLayout() );
		jPanelCentral.add( jLabelEspecialitat, BorderLayout.CENTER ); //no centra
		jPanelCentral.add( jTextFieldEspecialitat, BorderLayout.CENTER );

		jButtonOK = getOKButton();
		jButtonOK.addActionListener( new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed( java.awt.event.ActionEvent evt )
			{
				jButtonOKActionPerformed( evt );
			}
		} );

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

	private void jButtonOKActionPerformed( java.awt.event.ActionEvent evt )
	{
		viewCtrl.prOkObteHospitals( jTextFieldEspecialitat.getText() );
	}

	private void jButtonCancelActionPerformed( java.awt.event.ActionEvent evt )
	{
		viewCtrl.prCancel( this );
	}
}