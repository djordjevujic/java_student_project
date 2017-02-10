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
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgUnosKvadrat extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzinaStranice;
	private int duzinaStranice;
	private boolean dozvolaCrtanja = false;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosKvadrat dialog = new DlgUnosKvadrat();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosKvadrat() {
		setModal(true);
		setTitle("Unos stranice");
		setResizable(false);
		setBounds(100, 100, 350, 125);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		GridBagLayout gbl_contentPanel = new GridBagLayout();
		gbl_contentPanel.columnWidths = new int[]{39, 0, 120, 0, 0};
		gbl_contentPanel.rowHeights = new int[]{88, 0};
		gbl_contentPanel.columnWeights = new double[]{0.0, 0.0, 0.0, 1.0, Double.MIN_VALUE};
		gbl_contentPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPanel.setLayout(gbl_contentPanel);
		{
			JLabel lblUnosStranice = new JLabel("Unesite du\u017Einu stranice:");
			GridBagConstraints gbc_lblUnosStranice = new GridBagConstraints();
			gbc_lblUnosStranice.insets = new Insets(0, 0, 0, 5);
			gbc_lblUnosStranice.anchor = GridBagConstraints.EAST;
			gbc_lblUnosStranice.gridx = 1;
			gbc_lblUnosStranice.gridy = 0;
			contentPanel.add(lblUnosStranice, gbc_lblUnosStranice);
		}
		{
			txtDuzinaStranice = new JTextField();
			GridBagConstraints gbc_txtDuzinaStranice = new GridBagConstraints();
			gbc_txtDuzinaStranice.insets = new Insets(0, 0, 0, 5);
			gbc_txtDuzinaStranice.fill = GridBagConstraints.HORIZONTAL;
			gbc_txtDuzinaStranice.gridx = 2;
			gbc_txtDuzinaStranice.gridy = 0;
			contentPanel.add(txtDuzinaStranice, gbc_txtDuzinaStranice);
			txtDuzinaStranice.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try{
							duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());
							if(duzinaStranice < 0){
								throw new ZastitaUnosaException();
							}
							setVisible(false);
							dozvolaCrtanja = true;
						}
						catch(Exception e){
							dozvolaCrtanja = false;
							JOptionPane.showMessageDialog(null, " Dozvoljen je unos samo\n pozitivnih celobrojnih vrednosti!", "Neispravan unos!", JOptionPane.WARNING_MESSAGE);
							txtDuzinaStranice.setText("");
							txtDuzinaStranice.requestFocus();
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
						dozvolaCrtanja = false;
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public int getDuzinaStranice() {
		return duzinaStranice;
	}

	public void setDuzinaStranice(int duzinaStranice) {
		this.duzinaStranice = duzinaStranice;
	}

	public boolean isDozvolaCrtanja() {
		return dozvolaCrtanja;
	}

	public void setDozvolaCrtanja(boolean dozvolaCrtanja) {
		this.dozvolaCrtanja = dozvolaCrtanja;
	}

}
