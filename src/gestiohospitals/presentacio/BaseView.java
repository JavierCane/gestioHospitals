package gestiohospitals.presentacio;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

abstract public class BaseView extends javax.swing.JFrame
{

	public BaseView()
	{
		initComponents();
		initButtonListeners();
		this.setLocationRelativeTo( null );
		this.setVisible( true );
	}

	protected JPanel getPanelCentral()
	{
		return jPanelCentral;
	}

	protected JPanel getPanelInfo()
	{
		return jPanelInfo;
	}

	protected JTextField getTextFieldMessageArea()
	{
		return jTextFieldMessageArea;
	}

	protected JButton getOKButton()
	{
		return jButtonOK;
	}

	protected JButton getCancelButton()
	{
		return jButtonCancel;
	}

	public void mostraMissatge( String textMessageArea )
	{
		jTextFieldMessageArea.setText( textMessageArea );
	}

	public void tancar()
	{
		this.setVisible( false );
		this.dispose();
	}

	public void mostraPopUp( String text ) //en baseview o en baseviewCtrl?
	{
		JOptionPane.showMessageDialog( this, text, "Ingressar pacient", JOptionPane.PLAIN_MESSAGE );
	}

	private void initButtonListeners()
	{
		jButtonOK.addActionListener( new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed( java.awt.event.ActionEvent evt )
			{
				jButtonOKActionPerformed( evt );
			}
		} );
		jButtonCancel.addActionListener( new java.awt.event.ActionListener()
		{
			@Override
			public void actionPerformed( java.awt.event.ActionEvent evt )
			{
				jButtonCancelActionPerformed( evt );
			}
		} );
	}

	abstract protected void jButtonOKActionPerformed( java.awt.event.ActionEvent evt );

	abstract protected void jButtonCancelActionPerformed( java.awt.event.ActionEvent evt );

	@SuppressWarnings( "unchecked" )
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents()
    {

        jPanelButtons = new javax.swing.JPanel();
        jButtonOK = new javax.swing.JButton();
        jButtonCancel = new javax.swing.JButton();
        jPanelMessageArea = new javax.swing.JPanel();
        jTextFieldMessageArea = new javax.swing.JTextField();
        jPanelCentral = new javax.swing.JPanel();
        jPanelInfo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(428, 300));
        setMinimumSize(new java.awt.Dimension(428, 300));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);

        jPanelButtons.setPreferredSize(new java.awt.Dimension(100, 300));
        jPanelButtons.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.CENTER, 50, 5));

        jButtonOK.setText("OK");
        jPanelButtons.add(jButtonOK);

        jButtonCancel.setText("Cancel");
        jPanelButtons.add(jButtonCancel);

        jPanelMessageArea.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jPanelMessageArea.setMaximumSize(new java.awt.Dimension(428, 300));
        jPanelMessageArea.setMinimumSize(new java.awt.Dimension(428, 300));
        jPanelMessageArea.setPreferredSize(new java.awt.Dimension(428, 300));
        jPanelMessageArea.setLayout(new java.awt.BorderLayout());

        jTextFieldMessageArea.setEditable(false);
        jTextFieldMessageArea.setPreferredSize(new java.awt.Dimension(428, 25));
        jTextFieldMessageArea.setRequestFocusEnabled(false);
        jPanelMessageArea.add(jTextFieldMessageArea, java.awt.BorderLayout.SOUTH);

        javax.swing.GroupLayout jPanelCentralLayout = new javax.swing.GroupLayout(jPanelCentral);
        jPanelCentral.setLayout(jPanelCentralLayout);
        jPanelCentralLayout.setHorizontalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanelCentralLayout.setVerticalGroup(
            jPanelCentralLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 297, Short.MAX_VALUE)
        );

        jPanelInfo.setBackground(new java.awt.Color(255, 204, 204));
        jPanelInfo.setMaximumSize(new java.awt.Dimension(0, 79));
        jPanelInfo.setMinimumSize(new java.awt.Dimension(0, 79));
        jPanelInfo.setPreferredSize(new java.awt.Dimension(0, 50));
        jPanelInfo.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMessageArea, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelButtons, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanelInfo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanelInfo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanelCentral, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanelButtons, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanelMessageArea, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonCancel;
    private javax.swing.JButton jButtonOK;
    private javax.swing.JPanel jPanelButtons;
    private javax.swing.JPanel jPanelCentral;
    private javax.swing.JPanel jPanelInfo;
    private javax.swing.JPanel jPanelMessageArea;
    private javax.swing.JTextField jTextFieldMessageArea;
    // End of variables declaration//GEN-END:variables
}
