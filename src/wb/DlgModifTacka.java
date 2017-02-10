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

public class DlgModifTacka extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtXKoordinata;
	private JTextField txtYKoordinata;
	private int novoX;
	private int novoY;
	private Color bojaRama;
	private boolean dozvolaModifikacije;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgModifTacka dialog = new DlgModifTacka();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgModifTacka() {
		setTitle("Modifikacija ta\u010Dke");
		setModal(true);
		setResizable(false);
		setBounds(100, 100, 283, 173);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[] { 19, 101, 101, 0, 0, 0 };
		gbl_contentPanel.rowHeights = new int[] { 16, 0, 0, 23, 0 };
		gbl_contentPanel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_contentPanel.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblXKoordinata = new JLabel("X koordinata:");
			GridBagConstraints gbc_lblXKoordinata = new GridBagConstraints();
			gbc_lblXKoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblXKoordinata.gridx = 1;
			gbc_lblXKoordinata.gridy = 0;
			contentPanel.add(lblXKoordinata, gbc_lblXKoordinata);
		}
		{
			txtXKoordinata = new JTextField();
			GridBagConstraints gbc_txtXKoordinata = new GridBagConstraints();
			gbc_txtXKoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtXKoordinata.anchor = GridBagConstraints.NORTH;
			gbc_txtXKoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_txtXKoordinata.gridx = 2;
			gbc_txtXKoordinata.gridy = 0;
			contentPanel.add(txtXKoordinata, gbc_txtXKoordinata);
			txtXKoordinata.setColumns(10);
		}
		{
			JLabel lblYKoordinata = new JLabel("Y koordinata:");
			GridBagConstraints gbc_lblYKoordinata = new GridBagConstraints();
			gbc_lblYKoordinata.anchor = GridBagConstraints.NORTH;
			gbc_lblYKoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_lblYKoordinata.gridx = 1;
			gbc_lblYKoordinata.gridy = 1;
			contentPanel.add(lblYKoordinata, gbc_lblYKoordinata);
		}
		{
			txtYKoordinata = new JTextField();
			GridBagConstraints gbc_txtYKoordinata = new GridBagConstraints();
			gbc_txtYKoordinata.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtYKoordinata.insets = new Insets(0, 0, 5, 5);
			gbc_txtYKoordinata.gridx = 2;
			gbc_txtYKoordinata.gridy = 1;
			contentPanel.add(txtYKoordinata, gbc_txtYKoordinata);
			txtYKoordinata.setColumns(10);
		}
		{
			JLabel lblBojaRama = new JLabel("Boja ta\u010Dke");
			GridBagConstraints gbc_lblBojaRama = new GridBagConstraints();
			gbc_lblBojaRama.anchor = GridBagConstraints.SOUTH;
			gbc_lblBojaRama.insets = new Insets(0, 0, 5, 5);
			gbc_lblBojaRama.gridx = 1;
			gbc_lblBojaRama.gridy = 2;
			contentPanel.add(lblBojaRama, gbc_lblBojaRama);
		}

		Dimension dimenzijeDugmeta = new Dimension(50, 20);
		{
			JButton btnBojaRama = new JButton("");
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
			GridBagConstraints gbc_btnBojaRama = new GridBagConstraints();
			gbc_btnBojaRama.fill = GridBagConstraints.BOTH;
			gbc_btnBojaRama.insets = new Insets(0, 0, 0, 5);
			gbc_btnBojaRama.gridx = 1;
			gbc_btnBojaRama.gridy = 3;
			contentPanel.add(btnBojaRama, gbc_btnBojaRama);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dozvolaModifikacije = true;
						try {
							novoY = Integer.parseInt(txtYKoordinata.getText());
							if (novoY < 0) {
								throw new ZastitaUnosaException();
							}
						} catch (Exception e) {
							dozvolaModifikacije = false;
							JOptionPane.showMessageDialog(null,
									" Dozvoljen je unos samo\n pozitivnih celobrojnih vrednosti!", "Neispravan unos!",
									JOptionPane.WARNING_MESSAGE);
							txtYKoordinata.setText("");
							txtYKoordinata.requestFocus();
						}
						try {
							novoX = Integer.parseInt(txtXKoordinata.getText());
							if (novoY < 0) {
								throw new ZastitaUnosaException();
							}
						} catch (Exception e) {
							dozvolaModifikacije = false;
							txtXKoordinata.setText("");
							txtXKoordinata.requestFocus();
						}
						if (dozvolaModifikacije == true) {
							setVisible(false);
						} else {
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

	public JTextField getTxtXKoordinata() {
		return txtXKoordinata;
	}

	public void setTxtXKoordinata(JTextField txtXKoordinata) {
		this.txtXKoordinata = txtXKoordinata;
	}

	public JTextField getTxtYKoordinata() {
		return txtYKoordinata;
	}

	public void setTxtYKoordinata(JTextField txtYKoordinata) {
		this.txtYKoordinata = txtYKoordinata;
	}

	public Color getBojaRama() {
		return bojaRama;
	}

	public void setBojaRama(Color bojaRama) {
		this.bojaRama = bojaRama;
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

}
