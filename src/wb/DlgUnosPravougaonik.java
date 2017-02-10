package wb;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DlgUnosPravougaonik extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtDuzinaStranice;
	private JTextField txtUnosVisine;
	private int duzinaStranice;
	private int visina;
	private boolean dozvolaCrtanja = false;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DlgUnosPravougaonik dialog = new DlgUnosPravougaonik();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DlgUnosPravougaonik() {
		setModal(true);
		setTitle("Unos stranice i visine");
		setResizable(false);
		setBounds(100, 100, 255, 135);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setToolTipText("");
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new MigLayout("", "[115px][grow]", "[14px][][]"));
		{
			JLabel lblDuzinaStrPrav = new JLabel("Unesite du\u017Einu stranice:");
			contentPanel.add(lblDuzinaStrPrav, "cell 0 0,alignx trailing,aligny top");
		}
		{
			txtDuzinaStranice = new JTextField();
			contentPanel.add(txtDuzinaStranice, "cell 1 0,alignx left");
			txtDuzinaStranice.setColumns(10);
		}
		{
			JLabel lblVisina = new JLabel("Unesite visinu:");
			contentPanel.add(lblVisina, "cell 0 1,alignx left");
		}
		{
			txtUnosVisine = new JTextField();
			contentPanel.add(txtUnosVisine, "cell 1 1,alignx left");
			txtUnosVisine.setColumns(10);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Potvrdi");
				okButton.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {

						dozvolaCrtanja = true;
						try {
							visina = Integer.parseInt(txtUnosVisine.getText());
							if(visina < 0){
								throw new Exception();
							}
						} catch (Exception e) {
							dozvolaCrtanja = false;
							txtUnosVisine.setText("");
							txtUnosVisine.requestFocus();
						}
						try {
							duzinaStranice = Integer.parseInt(txtDuzinaStranice.getText());
							if(duzinaStranice < 0){
								throw new Exception();
							}
						} catch (Exception e) {
							dozvolaCrtanja = false;
							txtDuzinaStranice.setText("");
							txtDuzinaStranice.requestFocus();
						}
						if (dozvolaCrtanja == true) {
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
					public void actionPerformed(ActionEvent arg0) {
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

	public int getVisina() {
		return visina;
	}

	public void setVisina(int visina) {
		this.visina = visina;
	}

	public boolean isDozvolaCrtanja() {
		return dozvolaCrtanja;
	}

	public void setDozvolaCrtanja(boolean dozvolaCrtanja) {
		this.dozvolaCrtanja = dozvolaCrtanja;
	}

}
