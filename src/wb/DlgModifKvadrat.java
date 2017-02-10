package wb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import geometrija.*;
import java.awt.Toolkit;

public class DlgModifKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNovoX;
	private JTextField txtNovoY;
	private Color bojaRama;
	private Color bojaPovrsine;
	
	private int stranica;
	private int novoX;
	private int novoY;
	private boolean dozvolaModifikacije;
	private JTextField txtStranica;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifKvadrat dialog = new DlgModifKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifKvadrat() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DlgModifKvadrat.class.getResource("/ikone/Repair-icon 48.png")));
		setTitle("Modifikacija kvadrata");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 260, 291);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel lblNovoX = new JLabel("X koordinata:");
		
		JLabel lblNovoY = new JLabel("Y koordinata:");
		
		JLabel lblTackaGoreLevo = new JLabel("Ta\u010Dka gore levo");
		
		txtNovoX = new JTextField();
		txtNovoX.setColumns(10);
		
		txtNovoY = new JTextField();
		txtNovoY.setColumns(10);
		
		JButton btnBojaRama = new JButton("");
		
		bojaRama = Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()).getBoja();
		
		btnBojaRama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if (bojaRama != null) {
					btnBojaRama.setBackground(bojaRama);
				}
			}
		});
		
		btnBojaRama.setBackground(bojaRama);
		
		JButton btnBojaPovrsine = new JButton("");
		
		Kvadrat pomKv = (Kvadrat) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
		bojaPovrsine = pomKv.getBojaUnutrasnjosti();
		
		btnBojaPovrsine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaPovrsine = JColorChooser.showDialog(null, "Boja površine", bojaPovrsine);
				if (bojaPovrsine != null) {
					btnBojaPovrsine.setBackground(bojaPovrsine);
				}
			}
		});
		
		btnBojaPovrsine.setBackground(bojaPovrsine);
		
		Dimension dimenzijeDugmeta = new Dimension(50, 20);
		
		btnBojaRama.setMinimumSize(dimenzijeDugmeta);
		btnBojaRama.setMaximumSize(dimenzijeDugmeta);
		btnBojaRama.setSize(dimenzijeDugmeta);
		
		btnBojaPovrsine.setMinimumSize(dimenzijeDugmeta);
		btnBojaPovrsine.setMaximumSize(dimenzijeDugmeta);
		btnBojaPovrsine.setSize(dimenzijeDugmeta);
		
		JLabel lblBojaRama = new JLabel("Boja rama");
		
		JLabel lblBojaPovrine = new JLabel("Boja povr\u0161ine");
		
		JLabel lblStranica = new JLabel("Stranica:");
		
		txtStranica = new JTextField();
		txtStranica.setColumns(10);
		
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel.setHorizontalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblNovoX)
									.addGap(18)
									.addComponent(txtNovoX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
								.addComponent(lblTackaGoreLevo)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
										.addComponent(lblStranica)
										.addComponent(lblNovoY))
									.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addPreferredGap(ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
											.addComponent(txtNovoY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_contentPanel.createSequentialGroup()
											.addGap(18)
											.addComponent(txtStranica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))))
							.addGap(65))
						.addGroup(gl_contentPanel.createSequentialGroup()
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(btnBojaRama, GroupLayout.DEFAULT_SIZE, 79, Short.MAX_VALUE)
									.addGap(18))
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblBojaRama)
									.addGap(49)))
							.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING, false)
								.addGroup(gl_contentPanel.createSequentialGroup()
									.addComponent(lblBojaPovrine)
									.addPreferredGap(ComponentPlacement.RELATED, 19, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnBojaPovrsine, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 84, GroupLayout.PREFERRED_SIZE))
							.addGap(53))))
		);
		gl_contentPanel.setVerticalGroup(
			gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblTackaGoreLevo)
					.addGap(12)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNovoX)
						.addComponent(txtNovoX, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNovoY)
						.addComponent(txtNovoY, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblStranica)
						.addComponent(txtStranica, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(28)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblBojaRama)
						.addComponent(lblBojaPovrine))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPanel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnBojaPovrsine, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnBojaRama, GroupLayout.PREFERRED_SIZE, 19, GroupLayout.PREFERRED_SIZE))
					.addGap(46))
		);
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("U redu");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dozvolaModifikacije = true;
						try{
							stranica = Integer.parseInt(txtStranica.getText());
							if(stranica < 0){
								throw new Exception();
							}
						}
						catch(Exception e){
							dozvolaModifikacije = false;
							txtStranica.setText("");
							txtStranica.requestFocus();
						}
						try{
							novoY = Integer.parseInt(txtNovoY.getText());
							if(novoY < 0){
								throw new Exception();
							}
						}
						catch(Exception e){
							dozvolaModifikacije = false;
							txtNovoY.setText("");
							txtNovoY.requestFocus();
						}
						try{
							novoX = Integer.parseInt(txtNovoX.getText());
							if(novoX < 0){
								throw new Exception();
							}
						}
						catch(Exception e){
							dozvolaModifikacije = false;
							txtNovoX.setText("");
							txtNovoX.requestFocus();
						}
						if(dozvolaModifikacije == true){
							setVisible(false);
						}
						else{
							JOptionPane.showMessageDialog(null,
									" Dozvoljen je unos samo\n pozitivnih celobrojnih vrednosti!", "Neispravan unos!",
									JOptionPane.WARNING_MESSAGE);
						}
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Poni\u0161ti");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dozvolaModifikacije = false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

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

	public Color getBojaRama() {
		return bojaRama;
	}

	public void setBojaRama(Color bojaRama) {
		this.bojaRama = bojaRama;
	}

	public Color getBojaPovrsine() {
		return bojaPovrsine;
	}

	public void setBojaPovrsine(Color bojaPovrsine) {
		this.bojaPovrsine = bojaPovrsine;
	}

	public int getStranica() {
		return stranica;
	}

	public void setStranica(int stranica) {
		this.stranica = stranica;
	}

	public int getNovoX() {
		return novoX;
	}

	public void setNovoX(int novoX) {
		this.novoX = novoX;
	}

	public int getNovoY() {
		return novoY;
	}

	public void setNovoY(int novoY) {
		this.novoY = novoY;
	}

	public boolean isDozvolaModifikacije() {
		return dozvolaModifikacije;
	}

	public void setDozvolaModifikacije(boolean dozvolaModifikacije) {
		this.dozvolaModifikacije = dozvolaModifikacije;
	}

	public JTextField getTxtStranica() {
		return txtStranica;
	}

	public void setTxtStranica(JTextField txtStranica) {
		this.txtStranica = txtStranica;
	}
}
