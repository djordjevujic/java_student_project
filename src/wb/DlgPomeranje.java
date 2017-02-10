package wb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import geometrija.*;

public class DlgPomeranje extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNovoX;
	private JTextField txtNovoY;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	// 1 - pomeriNa
	private final int opcijaPomeriNa = 1;
	// 2 - pomeriZa
	private final int opcijaPomeriZa = 2;
	private int izabranaOpcija = opcijaPomeriNa;
	private int unesenoX;
	private int unesenoY;
	private boolean dozvolaPomeranja;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgPomeranje dialog = new DlgPomeranje();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgPomeranje() {
		setResizable(false);
		setModal(true);
		setTitle("Pomeranje oblika");
		setBounds(100, 100, 240, 215);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		txtNovoX = new JTextField();
		txtNovoX.setColumns(10);
		txtNovoY = new JTextField();
		txtNovoY.setColumns(10);
		JLabel lblX = new JLabel("X:");
		JLabel lblY = new JLabel("Y:");
		
		JRadioButton rdbtnPomeriZa = new JRadioButton("Pomeri za");
		buttonGroup.add(rdbtnPomeriZa);
		
		JRadioButton rdbtnPomeriNa = new JRadioButton("Pomeri na");
		rdbtnPomeriNa.setSelected(true);
		buttonGroup.add(rdbtnPomeriNa);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(26, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addComponent(lblX)
						.addComponent(lblY))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addComponent(rdbtnPomeriNa)
							.addGap(18)
							.addComponent(rdbtnPomeriZa))
						.addComponent(txtNovoY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNovoX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(22))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_contentPanel.createSequentialGroup()
					.addContainerGap(28, Short.MAX_VALUE)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(rdbtnPomeriNa)
						.addComponent(rdbtnPomeriZa))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNovoX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblX))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(txtNovoY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblY))
					.addGap(23))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dozvolaPomeranja = true;
							try{
								unesenoY = Integer.parseInt(txtNovoY.getText());
							}
							catch(Exception e){
								dozvolaPomeranja = false;
								txtNovoY.requestFocus();
								txtNovoY.setText("");
							}
							try{
								unesenoX = Integer.parseInt(txtNovoX.getText());
							}
							catch(Exception e){
								dozvolaPomeranja = false;
								txtNovoX.requestFocus();
								txtNovoX.setText("");
							}
						if(dozvolaPomeranja == true){
							setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(null,
									" Dozvoljen je unos samo\n pozitivnih celobrojnih vrednosti!", "Neispravan unos!",
									JOptionPane.WARNING_MESSAGE);
						}
						if(rdbtnPomeriNa.isSelected() == true){
							izabranaOpcija = opcijaPomeriNa;
						}
						else{
							izabranaOpcija = opcijaPomeriZa;
						}
							
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Otka\u017Ei");
				cancelButton.addActionListener(new ActionListener() {

	public void actionPerformed(ActionEvent e) {
		dozvolaPomeranja = false;
		setVisible(false);
	}
});cancelButton.setActionCommand("Cancel");buttonPane.add(cancelButton);}}}

	public JTextField getTxtNovoX() {
		return txtNovoX;
	}

	public void setTxtNovoX(JTextField txtNovoX) {
		this.txtNovoX = txtNovoX;
	}

	public JTextField getTxtNovoY() {
		return txtNovoY;
	}

	public void setTxtNovoY(JTextField txtNovoY) {
		this.txtNovoY = txtNovoY;
	}

	public int getIzabranaOpcija() {
		return izabranaOpcija;
	}

	public void setIzabranaOpcija(int izabranaOpcija) {
		this.izabranaOpcija = izabranaOpcija;
	}

	public int getUnesenoX() {
		return unesenoX;
	}

	public void setUnesenoX(int unesenoX) {
		this.unesenoX = unesenoX;
	}

	public int getUnesenoY() {
		return unesenoY;
	}

	public void setUnesenoY(int unesenoY) {
		this.unesenoY = unesenoY;
	}

	public boolean isDozvolaPomeranja() {
		return dozvolaPomeranja;
	}

	public void setDozvolaPomeranja(boolean dozvolaPomeranja) {
		this.dozvolaPomeranja = dozvolaPomeranja;
	}

	public JPanel getContentPanel() {
		return contentPanel;
	}

	public ButtonGroup getButtonGroup() {
		return buttonGroup;
	}

	public int getOpcijaPomeriNa() {
		return opcijaPomeriNa;
	}

	public int getOpcijaPomeriZa() {
		return opcijaPomeriZa;
	}}
