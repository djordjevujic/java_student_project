package wb;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import net.miginfocom.swing.MigLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JToggleButton;
import javax.swing.JEditorPane;
import javax.swing.ButtonGroup;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.awt.Graphics;
import java.awt.Color;

import geometrija.*;
import java.awt.Panel;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class Crtanje extends JFrame {

	private JPanel contentPane;
	private JToggleButton tglbtnTacka;
	private JToggleButton tglbtnLinija;
	private JToggleButton tglbtnKvadrat;
	private JToggleButton tglbtnPravougaonik;
	private JToggleButton tglbtnKrug;
	private JToggleButton tglbtnIscrtavanje;
	private JToggleButton tglbtnModifikacija;
	private JToggleButton tglbtnPomeranje;
	private JToggleButton tglbtnSelekcija;
	private final ButtonGroup btngrpOpcije = new ButtonGroup();
	private JPanel pnlOblici;
	private JPanel pnlRadnje;
	private JPanel pnlRadnaPovrsina;

	ArrayList<Oblik> oblici = new ArrayList<Oblik>();

	private JLabel lblBojaRama;
	private JButton btnBojaRama;
	private JButton btnBojaPovrsine;
	private static Color bojaRama = Color.BLACK;
	private static Color bojaPovrsine = Color.WHITE;
	private JToggleButton tglbtnBrisanje;
	private JLabel lblBojaPovrine;
	private final ButtonGroup buttonOblici = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Crtanje frame = new Crtanje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Crtanje() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(Crtanje.class.getResource("/ikone/Paint-icon 128.png")));
		initComponents();
		createEvents();
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	// Pravljenje akcija
	////////////////////////////////////////////////////////////////////////////////////////////////
	private void createEvents() {
		// TODO Auto-generated method stub

		// event --> Kliknuto na taster TACKA
		tglbtnTacka.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpcijaOblik.setIzabranaOpcija(OpcijaOblik.getCrtajTacku());
			}
		});
		// event --> Kliknuto na taster LINIJA
		tglbtnLinija.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpcijaOblik.setIzabranaOpcija(OpcijaOblik.getCrtajLiniju());
			}
		});
		// event --> Kliknuto na taster KVADRAT
		tglbtnKvadrat.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				OpcijaOblik.setIzabranaOpcija(OpcijaOblik.getCrtajKvadrat());
			}
		});
		// event --> Kliknuto na taster PRAVOUGAONIK
		tglbtnPravougaonik.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				OpcijaOblik.setIzabranaOpcija(OpcijaOblik.getCrtajPravougaonik());
			}
		});
		// event --> Kliknuto na taster KRUG
		tglbtnKrug.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				OpcijaOblik.setIzabranaOpcija(OpcijaOblik.getCrtajKrug());
			}
		});

		// Iscrtavanje - izabrana opcija
		tglbtnIscrtavanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcijaRadnja.setIzabranaOpcija(OpcijaRadnja.getOpcijaCrtanje());
			}
		});

		// Selekcija - izabrana opcija
		tglbtnSelekcija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpcijaRadnja.setIzabranaOpcija(OpcijaRadnja.getOpcijaSelekcija());
			}
		});

		tglbtnModifikacija.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcijaRadnja.setIzabranaOpcija(OpcijaRadnja.getOpcijaModifikacija());
				if (Crtez.getIndeksPoslednjeg() > -1) {
					// MODIFIKACIJA TACKE
					if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Tacka) {
						Tacka pomocnaTacka = (Tacka) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						DlgModifTacka TackaModifDijalog = new DlgModifTacka();
						TackaModifDijalog.getTxtXKoordinata().setText("" + pomocnaTacka.getX());
						TackaModifDijalog.getTxtYKoordinata().setText("" + pomocnaTacka.getY());
						TackaModifDijalog.setBojaRama(pomocnaTacka.getBoja());
						TackaModifDijalog.setVisible(true);
						if (TackaModifDijalog.isDozvolaModifikacije() == true) {
							pomocnaTacka.setBoja(TackaModifDijalog.getBojaRama());
							pomocnaTacka.pomeriNa(TackaModifDijalog.getNovoX(), TackaModifDijalog.getNovoY());
						} else
							pomocnaTacka = null;
					}
					// MODIFIKACIJA LINIJE
					else if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Linija) {
						Linija pomocnaLinija = (Linija) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						DlgModifLinija LinijaModifDijalog = new DlgModifLinija();
						LinijaModifDijalog.getTxtXPoc().setText("" + pomocnaLinija.gettPocetna().getX());
						LinijaModifDijalog.getTxtYPoc().setText("" + pomocnaLinija.gettPocetna().getY());
						LinijaModifDijalog.getTxtXKraj().setText("" + pomocnaLinija.gettKrajnja().getX());
						LinijaModifDijalog.getTxtYKraj().setText("" + pomocnaLinija.gettKrajnja().getY());
						LinijaModifDijalog.setBojaRama(LinijaModifDijalog.getBojaRama());
						LinijaModifDijalog.setVisible(true);
						if (LinijaModifDijalog.isDozvolaModifikacije() == true) {
							pomocnaLinija.gettPocetna().pomeriNa(LinijaModifDijalog.getNovoXPoc(),
									LinijaModifDijalog.getNovoYPoc());
							pomocnaLinija.gettKrajnja().pomeriNa(LinijaModifDijalog.getNovoXKraj(),
									LinijaModifDijalog.getNovoYKraj());
							pomocnaLinija.setBoja(LinijaModifDijalog.getBojaRama());
						} else
							pomocnaLinija = null;
					}
					// MODIFIKACIJA PRAVOUGAONIKA
					else if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Pravougaonik) {
						Pravougaonik pomocniPravougaonik = (Pravougaonik) Crtez.listaOblika
								.get(Crtez.getIndeksPoslednjeg());
						DlgModifPravougaonik PravougaonikModifDijalog = new DlgModifPravougaonik();
						PravougaonikModifDijalog.getTxtNovoX().setText("" + pomocniPravougaonik.getGoreLevo().getX());
						PravougaonikModifDijalog.getTxtNovoY().setText("" + pomocniPravougaonik.getGoreLevo().getY());
						PravougaonikModifDijalog.getTxtStranica().setText("" + pomocniPravougaonik.getStranica());
						PravougaonikModifDijalog.getTxtVisina().setText("" + pomocniPravougaonik.getVisina());
						PravougaonikModifDijalog.setVisible(true);
						if (PravougaonikModifDijalog.isDozvolaModifikacije()) {
							pomocniPravougaonik.getGoreLevo().pomeriNa(PravougaonikModifDijalog.getNovoX(),
									PravougaonikModifDijalog.getNovoY());
							pomocniPravougaonik.setStranica(PravougaonikModifDijalog.getStranica());
							pomocniPravougaonik.setVisina(PravougaonikModifDijalog.getVisina());
							pomocniPravougaonik.setBoja(PravougaonikModifDijalog.getBojaRama());
							pomocniPravougaonik.setBojaUnutrasnjosti(PravougaonikModifDijalog.getBojaPovrsine());
						} else
							pomocniPravougaonik = null;
					}
					// MODIFIKACIJA KVADRATA
					else if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Kvadrat) {
						Kvadrat pomocniKvadrat = (Kvadrat) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						DlgModifKvadrat KvadratModifDijalog = new DlgModifKvadrat();
						KvadratModifDijalog.getTxtNovoX().setText("" + pomocniKvadrat.getGoreLevo().getX());
						KvadratModifDijalog.getTxtNovoY().setText("" + pomocniKvadrat.getGoreLevo().getY());
						KvadratModifDijalog.getTxtStranica().setText("" + pomocniKvadrat.getStranica());
						KvadratModifDijalog.setVisible(true);
						if (KvadratModifDijalog.isDozvolaModifikacije() == true) {
							pomocniKvadrat.getGoreLevo().pomeriNa(KvadratModifDijalog.getNovoX(),
									KvadratModifDijalog.getNovoY());
							pomocniKvadrat.setStranica(KvadratModifDijalog.getStranica());
							pomocniKvadrat.setBoja(KvadratModifDijalog.getBojaRama());
							pomocniKvadrat.setBojaUnutrasnjosti(KvadratModifDijalog.getBojaPovrsine());
						} else
							pomocniKvadrat = null;
					} else if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Krug) {
						Krug pomocniKrug = (Krug) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						DlgModifKrug KrugModifDijalog = new DlgModifKrug();
						KrugModifDijalog.getTxtNovoX().setText("" + pomocniKrug.getCentar().getX());
						KrugModifDijalog.getTxtNovoY().setText("" + pomocniKrug.getCentar().getY());
						KrugModifDijalog.getTxtPoluprecnik().setText("" + pomocniKrug.getR());
						KrugModifDijalog.setVisible(true);
						if (KrugModifDijalog.isDozvolaModifikacije() == true) {
							pomocniKrug.getCentar().pomeriNa(KrugModifDijalog.getNovoX(), KrugModifDijalog.getNovoY());
							pomocniKrug.setR(KrugModifDijalog.getPoluprecnik());
							pomocniKrug.setBoja(KrugModifDijalog.getBojaRama());
							pomocniKrug.setBojaUnutrasnjosti(KrugModifDijalog.getBojaPovrsine());
						} else
							pomocniKrug = null;
					}
				} else {
					JOptionPane.showMessageDialog(null, " Morate prvo selektovati clan!", "Nema selekcije",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		// Pomeranje - izabrana opcija
		tglbtnPomeranje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcijaRadnja.setIzabranaOpcija(OpcijaRadnja.getOpcijaPomeranje());
				if (Crtez.getIndeksPoslednjeg() > -1) {
					DlgPomeranje pomeranje = new DlgPomeranje();
					pomeranje.setVisible(true);
					if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Tacka) {
						Tacka pomocna = (Tacka) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						if (pomeranje.getIzabranaOpcija() == pomeranje.getOpcijaPomeriNa()) {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriNa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						} else {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriZa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						}
					} else if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Linija) {
						Linija pomocna = (Linija) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						if (pomeranje.getIzabranaOpcija() == pomeranje.getOpcijaPomeriNa()) {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriNa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						} else {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriZa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						}
					}

					else if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Pravougaonik) {
						Pravougaonik pomocna = (Pravougaonik) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						if (pomeranje.getIzabranaOpcija() == pomeranje.getOpcijaPomeriNa()) {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriNa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						} else {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriZa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						}
					}

					else if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Kvadrat) {
						Kvadrat pomocna = (Kvadrat) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						if (pomeranje.getIzabranaOpcija() == pomeranje.getOpcijaPomeriNa()) {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriNa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						} else {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriZa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						}
					} else if (Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg()) instanceof Krug) {
						Krug pomocna = (Krug) Crtez.listaOblika.get(Crtez.getIndeksPoslednjeg());
						if (pomeranje.getIzabranaOpcija() == pomeranje.getOpcijaPomeriNa()) {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriNa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						} else {
							if (pomeranje.isDozvolaPomeranja())
								pomocna.pomeriZa(pomeranje.getUnesenoX(), pomeranje.getUnesenoY());
						}
					}
				} else {
					JOptionPane.showMessageDialog(null, " Morate prvo selektovati clan!", "Nema selekcije",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		// BRISANJE - izabrana opcija
		tglbtnBrisanje.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				OpcijaRadnja.setIzabranaOpcija(OpcijaRadnja.getOpcijaBrisanje());
				if (Crtez.getIndeksPoslednjeg() > 0) {
					Crtez.getListaOblika().remove(Crtez.getIndeksPoslednjeg());
				} else {
					JOptionPane.showMessageDialog(null, " Morate prvo selektovati clan!", "Nema selekcije",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});

		// Dugme za izbor boje rama
		btnBojaRama.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaRama = JColorChooser.showDialog(null, "Boja rama", bojaRama);
				if (bojaRama != null) {
					btnBojaRama.setBackground(bojaRama);
				}
			}
		});
		// Dugme za izbor boje unutrasnje povrsine
		btnBojaPovrsine.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				bojaPovrsine = JColorChooser.showDialog(null, "Boja površine", bojaPovrsine);
				if (bojaPovrsine != null) {
					btnBojaPovrsine.setBackground(bojaPovrsine);
				}
			}
		});
	}

	////////////////////////////////////////////////////////////////////////////////////////////////
	// Inicijalizacije
	////////////////////////////////////////////////////////////////////////////////////////////////
	private void initComponents() {
		// TODO Auto-generated method stub
		setTitle("Crtanje");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 779, 534);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		pnlOblici = new JPanel();
		contentPane.add(pnlOblici, BorderLayout.NORTH);
		pnlOblici.setLayout(new MigLayout("", "[105][][][][105][][115][][105]", "[45]"));

		tglbtnTacka = new JToggleButton("Ta\u010Dka");
		buttonOblici.add(tglbtnTacka);

		pnlOblici.add(tglbtnTacka, "cell 0 0,alignx right,aligny top");

		tglbtnTacka.setMinimumSize(new Dimension(115, 45));
		tglbtnTacka.setMaximumSize(new Dimension(115, 45));
		tglbtnTacka.setSize(97, 45);

		tglbtnLinija = new JToggleButton("Linija");
		buttonOblici.add(tglbtnLinija);

		pnlOblici.add(tglbtnLinija, "cell 2 0,grow");
		tglbtnLinija.setMinimumSize(new Dimension(115, 45));
		tglbtnLinija.setMaximumSize(new Dimension(115, 45));

		tglbtnKvadrat = new JToggleButton("Kvadrat");
		buttonOblici.add(tglbtnKvadrat);

		pnlOblici.add(tglbtnKvadrat, "cell 4 0,growx");
		tglbtnKvadrat.setMinimumSize(new Dimension(115, 45));
		tglbtnKvadrat.setMaximumSize(new Dimension(115, 45));

		tglbtnPravougaonik = new JToggleButton("Pravougaonik");
		buttonOblici.add(tglbtnPravougaonik);

		pnlOblici.add(tglbtnPravougaonik, "cell 6 0,grow");
		tglbtnPravougaonik.setMinimumSize(new Dimension(115, 45));
		tglbtnPravougaonik.setMaximumSize(new Dimension(115, 45));

		tglbtnKrug = new JToggleButton("Krug");
		buttonOblici.add(tglbtnKrug);
		tglbtnKrug.setMinimumSize(new Dimension(115, 45));
		tglbtnKrug.setMaximumSize(new Dimension(115, 45));
		pnlOblici.add(tglbtnKrug, "cell 8 0,grow");

		Crtez pnlRadnaPovrsina = new Crtez();

		pnlRadnaPovrsina.setBackground(Color.WHITE);
		contentPane.add(pnlRadnaPovrsina);

		pnlRadnje = new JPanel();
		contentPane.add(pnlRadnje, BorderLayout.EAST);
		pnlRadnje.setLayout(new MigLayout("", "[148.00,right]", "[20][86][40][86][36.00][][][][][86][]"));

		lblBojaRama = new JLabel("Boja rama");
		pnlRadnje.add(lblBojaRama, "cell 0 0,aligny top");
		lblBojaRama.setHorizontalAlignment(SwingConstants.CENTER);

		btnBojaRama = new JButton("");
		pnlRadnje.add(btnBojaRama, "cell 0 1,alignx right,aligny top");
		btnBojaRama.setBackground(bojaRama);
		btnBojaRama.setMinimumSize(new Dimension(115, 45));
		btnBojaRama.setMaximumSize(new Dimension(115, 45));

		lblBojaPovrine = new JLabel("Boja povr\u0161ine");
		pnlRadnje.add(lblBojaPovrine, "cell 0 2,aligny bottom");

		btnBojaPovrsine = new JButton("");
		pnlRadnje.add(btnBojaPovrsine, "cell 0 3,alignx right,aligny top");
		btnBojaPovrsine.setBackground(bojaPovrsine);
		btnBojaPovrsine.setMinimumSize(new Dimension(115, 45));
		btnBojaPovrsine.setMaximumSize(new Dimension(115, 45));

		tglbtnIscrtavanje = new JToggleButton("Iscrtavanje");
		btngrpOpcije.add(tglbtnIscrtavanje);
		tglbtnIscrtavanje.setMinimumSize(new Dimension(115, 45));
		tglbtnIscrtavanje.setMaximumSize(new Dimension(115, 45));
		pnlRadnje.add(tglbtnIscrtavanje, "cell 0 5,alignx right,aligny top");

		tglbtnSelekcija = new JToggleButton("Selekcija");

		btngrpOpcije.add(tglbtnSelekcija);
		tglbtnSelekcija.setMaximumSize(new Dimension(115, 45));
		tglbtnSelekcija.setMinimumSize(new Dimension(115, 45));
		pnlRadnje.add(tglbtnSelekcija, "cell 0 6,alignx right,aligny top");

		tglbtnModifikacija = new JToggleButton("Modifikacija");

		btngrpOpcije.add(tglbtnModifikacija);
		tglbtnModifikacija.setMinimumSize(new Dimension(115, 45));
		tglbtnModifikacija.setMaximumSize(new Dimension(115, 45));
		pnlRadnje.add(tglbtnModifikacija, "cell 0 7,alignx right,aligny top");

		tglbtnPomeranje = new JToggleButton("Pomeranje");

		btngrpOpcije.add(tglbtnPomeranje);
		tglbtnPomeranje.setMinimumSize(new Dimension(115, 45));
		tglbtnPomeranje.setMaximumSize(new Dimension(115, 45));
		pnlRadnje.add(tglbtnPomeranje, "cell 0 8,alignx right,aligny top");

		tglbtnBrisanje = new JToggleButton("Brisanje");

		btngrpOpcije.add(tglbtnBrisanje);
		tglbtnBrisanje.setMinimumSize(new Dimension(115, 45));
		tglbtnBrisanje.setMaximumSize(new Dimension(115, 45));
		pnlRadnje.add(tglbtnBrisanje, "cell 0 9,alignx right,aligny top");
	}

	public static Color getBojaRama() {
		return bojaRama;
	}

	public static void setBojaRama(Color bojaRama) {
		Crtanje.bojaRama = bojaRama;
	}

	public static Color getBojaPovrsine() {
		return bojaPovrsine;
	}

	public static void setBojaPovrsine(Color bojaPovrsine) {
		Crtanje.bojaPovrsine = bojaPovrsine;
	}

}
