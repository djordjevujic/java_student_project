package wb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

public class DlgUnosKrug extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtPoluprecnik;
	private boolean dozvolaCrtanja = false;
	private int poluprecnik;
	private JLabel lblPoluprenik;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosKrug dialog = new DlgUnosKrug();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosKrug() {
		setTitle("Unos polupre\u010Dnika");
		setModal(true);
		setBounds(100, 100, 300, 128);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		{
			lblPoluprenik = new JLabel("Unesite polupre\u010Dnik: ");
		}
		{
			txtPoluprecnik = new JTextField();
			txtPoluprecnik.setColumns(10);
		}
		GroupLayout gl_contentPanel = new GroupLayout(contentPanel);
		gl_contentPanel
				.setHorizontalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
								.addComponent(lblPoluprenik).addGap(5)
								.addComponent(txtPoluprecnik, GroupLayout.PREFERRED_SIZE, 117,
										GroupLayout.PREFERRED_SIZE)
								.addContainerGap(42, Short.MAX_VALUE)));
		gl_contentPanel.setVerticalGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPanel.createSequentialGroup().addContainerGap()
						.addGroup(gl_contentPanel.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_contentPanel.createSequentialGroup().addGap(3).addComponent(lblPoluprenik))
								.addComponent(txtPoluprecnik, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE,
										GroupLayout.PREFERRED_SIZE))
						.addContainerGap(15, Short.MAX_VALUE)));
		contentPanel.setLayout(gl_contentPanel);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
							poluprecnik = Integer.parseInt(txtPoluprecnik.getText());
							if (poluprecnik < 0) {
								throw new ZastitaUnosaException();
							}
							dozvolaCrtanja = true;
							setVisible(false);
						} catch (Exception e) {
							dozvolaCrtanja = false;
							JOptionPane.showMessageDialog(null,
									" Dozvoljen je unos samo\n pozitivnih celobrojnih vrednosti!", "Neispravan unos!",
									JOptionPane.WARNING_MESSAGE);
							txtPoluprecnik.setText("");
							txtPoluprecnik.requestFocus();
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
						dozvolaCrtanja = false;
						setVisible(false);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public boolean isDozvolaCrtanja() {
		return dozvolaCrtanja;
	}

	public void setDozvolaCrtanja(boolean dozvolaCrtanja) {
		this.dozvolaCrtanja = dozvolaCrtanja;
	}

	public int getPoluprecnik() {
		return poluprecnik;
	}

	public void setPoluprecnik(int poluprecnik) {
		this.poluprecnik = poluprecnik;
	}

}
