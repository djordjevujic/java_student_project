package wb;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JColorChooser;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

public class DlgModifLinija extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXPoc;
	private JTextField txtYPoc;
	private int novoXPoc;
	private int novoYPoc;
	private int novoXKraj;
	private int novoYKraj;

	private Color bojaRama;
	private boolean dozvolaModifikacije;
	private JLabel lblXPoc;
	private JLabel lblYPoc;
	private JLabel lblBojaRama;
	private JButton btnBojaRama;
	private JTextField txtXKraj;
	private JTextField txtYKraj;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifLinija dialog = new DlgModifLinija();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifLinija() {
		setTitle("Modifikacija ta\u010Dke");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 255, 298);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblXPoc = new JLabel("X koordinata:");
		}
		{
			txtXPoc = new JTextField();
			txtXPoc.setColumns(10);
		}
		{
			lblYPoc = new JLabel("Y koordinata:");
		}
		{
			txtYPoc = new JTextField();
			txtYPoc.setColumns(10);
		}
		{
			lblBojaRama = new JLabel("Boja rama");
		}

		Dimension dimenzijeDugmeta = new Dimension(50, 20);
		{
			btnBojaRama = new JButton("");
			bojaRama = Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()).getBoja();
			btnBojaRama.setBackground(bojaRama);
			btnBojaRama.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
					if (bojaRama != null) {
						btnBojaRama.setBackground(bojaRama);
					}
				}
			});
			btnBojaRama.setMinimumSize(dimenzijeDugmeta);
			btnBojaRama.setMaximumSize(dimenzijeDugmeta);
			btnBojaRama.setSize(dimenzijeDugmeta);
		}

		JLabel lblPoetnaTaka = new JLabel("Po\u010Detna ta\u010Dka");

		JLabel lblKrajnjaTaka = new JLabel("Krajnja ta\u010Dka");

		JLabel lblXKoordinata = new JLabel("X koordinata:");

		JLabel lblYKoordinata = new JLabel("Y koordinata:");

		txtXKraj = new JTextField();
		txtXKraj.setColumns(10);

		txtYKraj = new JTextField();
		txtYKraj.setColumns(10);
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(
						gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(
										gl_contentPanel
												.createSequentialGroup().addGroup(gl_contentPanel
														.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
																.createSequentialGroup()
																.addGap(22).addGroup(gl_contentPanel
																		.createParallelGroup(Alignment.LEADING)
																		.addGroup(gl_contentPanel
																				.createSequentialGroup()
																				.addComponent(lblXPoc).addGap(
																						18)
																				.addComponent(txtXPoc,
																						GroupLayout.PREFERRED_SIZE, 96,
																						GroupLayout.PREFERRED_SIZE))
																		.addGroup(gl_contentPanel
																				.createSequentialGroup().addGap(48)
																				.addComponent(lblBojaRama))
																		.addGroup(gl_contentPanel
																				.createParallelGroup(Alignment.LEADING,
																						false)
																				.addGroup(gl_contentPanel
																						.createSequentialGroup()
																						.addComponent(lblYKoordinata)
																						.addGap(18)
																						.addComponent(txtYKraj))
																				.addGroup(gl_contentPanel
																						.createSequentialGroup()
																						.addComponent(lblXKoordinata)
																						.addGap(18)
																						.addComponent(txtXKraj))
																				.addGroup(gl_contentPanel
																						.createSequentialGroup()
																						.addComponent(lblYPoc)
																						.addGap(18)
																						.addComponent(txtYPoc,
																								GroupLayout.PREFERRED_SIZE,
																								96,
																								GroupLayout.PREFERRED_SIZE)))))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(70)
																.addComponent(lblPoetnaTaka))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(45)
																.addComponent(btnBojaRama, GroupLayout.PREFERRED_SIZE,
																		96, GroupLayout.PREFERRED_SIZE))
														.addGroup(gl_contentPanel.createSequentialGroup().addGap(67)
																.addComponent(lblKrajnjaTaka)))
												.addContainerGap(15, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPanel
				.createSequentialGroup().addGap(5).addComponent(lblPoetnaTaka)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXPoc).addComponent(
						txtXPoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblYPoc).addComponent(
						txtYPoc, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(lblKrajnjaTaka)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblXKoordinata)
						.addComponent(txtXKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE).addComponent(lblYKoordinata)
						.addComponent(txtYKraj, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
								GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED, 21, Short.MAX_VALUE).addComponent(lblBojaRama)
				.addPreferredGap(ComponentPlacement.RELATED)
				.addComponent(btnBojaRama, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
				.addContainerGap()));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						dozvolaModifikacije = true;
						///////////////////////////////////////////////////////
						////////// Y KRAJNJE
						
						try {
							novoYKraj = Integer.parseInt(txtYKraj.getText());
							if(novoYKraj < 0){
								throw new ZastitaUnosaException();
							}
						} catch (Exception e) {
							dozvolaModifikacije = false;
							txtYKraj.setText("");
							txtYKraj.requestFocus();	
						}

						///////////////////////////////////////////////////////
						////////// X KRAJNJE
						try {
							novoXKraj = Integer.parseInt(txtXKraj.getText());
							if(novoYKraj < 0){
								throw new ZastitaUnosaException();
							}
						} catch (Exception e) {
			
							dozvolaModifikacije = false;
							txtXKraj.setText("");
							txtXKraj.requestFocus();
						}

						/////////////////////////////////////////////////////
						//////////// Y POCETNO////////////////////////////////
						try {
							novoYPoc = Integer.parseInt(txtYPoc.getText());
							if(novoYPoc < 0){
								throw new ZastitaUnosaException();
							}
						} catch (Exception e) {
							dozvolaModifikacije = false;
							txtYPoc.setText("");
							txtYPoc.requestFocus();
						}

						////////////////////////////////////////////////////
						///////////// X POCETNO/////////////////////////////
						try {
							novoXPoc = Integer.parseInt(txtXPoc.getText());
							if(novoXPoc < 0){
								throw new ZastitaUnosaException();
							}
						} catch (Exception e) {
							dozvolaModifikacije = false;
							txtXPoc.setText("");
							txtXPoc.requestFocus();
						}
						/////////////////////////////////////////////////////
						if(dozvolaModifikacije == false){
							JOptionPane.showMessageDialog(null,
									" Dozvoljen je unos samo\n pozitivnih celobrojnih vrednosti!", "Neispravan unos!",
									JOptionPane.WARNING_MESSAGE);
						}
						else{
							setVisible(false);
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
						setVisible(false);
						dozvolaModifikacije = false;
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	

	public Color getBojaRama() {
		return bojaRama;
	}

	public void setBojaRama(Color bojaRama) {
		this.bojaRama = bojaRama;
	}

	public int getNovoXPoc() {
		return novoXPoc;
	}

	public void setNovoXPoc(int novoXPoc) {
		this.novoXPoc = novoXPoc;
	}

	public int getNovoYPoc() {
		return novoYPoc;
	}

	public void setNovoYPoc(int novoYPoc) {
		this.novoYPoc = novoYPoc;
	}

	public boolean isDozvolaModifikacije() {
		return dozvolaModifikacije;
	}

	public void setDozvolaModifikacije(boolean dozvolaModifikacije) {
		this.dozvolaModifikacije = dozvolaModifikacije;
	}

	public int getNovoXKraj() {
		return novoXKraj;
	}

	public void setNovoXKraj(int novoXKraj) {
		this.novoXKraj = novoXKraj;
	}

	public int getNovoYKraj() {
		return novoYKraj;
	}

	public void setNovoYKraj(int novoYKraj) {
		this.novoYKraj = novoYKraj;
	}

	public JTextField getTxtXPoc() {
		return txtXPoc;
	}

	public void setTxtXPoc(JTextField txtXPoc) {
		this.txtXPoc = txtXPoc;
	}

	public JTextField getTxtYPoc() {
		return txtYPoc;
	}

	public void setTxtYPoc(JTextField txtYPoc) {
		this.txtYPoc = txtYPoc;
	}

	public JTextField getTxtXKraj() {
		return txtXKraj;
	}

	public void setTxtXKraj(JTextField txtXKraj) {
		this.txtXKraj = txtXKraj;
	}

	public JTextField getTxtYKraj() {
		return txtYKraj;
	}

	public void setTxtYKraj(JTextField txtYKraj) {
		this.txtYKraj = txtYKraj;
	}
}
