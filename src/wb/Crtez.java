package wb;

import geometrija.*;
import java.util.Iterator;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class Crtez extends JPanel {

	private boolean dozvolaLinija = false;
	private int pomX;
	private int pomY;
	private static int indeksPoslednjeg=-1;

	static ArrayList<Oblik> listaOblika = new ArrayList<Oblik>();

	public Crtez() {
		setBackground(Color.WHITE);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				if (OpcijaRadnja.getIzabranaOpcija() == OpcijaRadnja.getOpcijaCrtanje()) {
					if (OpcijaOblik.getIzabranaOpcija() == OpcijaOblik.getCrtajTacku()) {
						Oblik o1 = new Tacka(e.getX(), e.getY(), Crtanje.getBojaRama());
						listaOblika.add(o1);
					}

					if (OpcijaOblik.getIzabranaOpcija() == OpcijaOblik.getCrtajLiniju()) {
						if (dozvolaLinija == false) {
							pomX = e.getX();
							pomY = e.getY();
							dozvolaLinija = true;
						} else {
							Oblik o1 = new Linija(new Tacka(pomX, pomY, Crtanje.getBojaRama()), new Tacka(e.getX(), e.getY(), Crtanje.getBojaRama()),Crtanje.getBojaRama());
							listaOblika.add(o1);
							dozvolaLinija = false;
						}
					}
					if (OpcijaOblik.getIzabranaOpcija() == OpcijaOblik.getCrtajKvadrat()) {
						DlgUnosKvadrat dijalogKvadrat = new DlgUnosKvadrat();
						dijalogKvadrat.setVisible(true);
						if (dijalogKvadrat.isDozvolaCrtanja() == true) {
							PovrsinskiOblik o1 = new Kvadrat(new Tacka(e.getX(), e.getY()),
									dijalogKvadrat.getDuzinaStranice(), Crtanje.getBojaRama());
							o1.setBojaUnutrasnjosti(Crtanje.getBojaPovrsine());
							listaOblika.add(o1);
						}
					}
					if (OpcijaOblik.getIzabranaOpcija() == OpcijaOblik.getCrtajPravougaonik()) {
						DlgUnosPravougaonik dijalogPravougaonik = new DlgUnosPravougaonik();
						dijalogPravougaonik.setVisible(true);
						if (dijalogPravougaonik.isDozvolaCrtanja() == true) {
							PovrsinskiOblik o1 = new Pravougaonik(new Tacka(e.getX(), e.getY()),
									dijalogPravougaonik.getDuzinaStranice(), dijalogPravougaonik.getVisina(),
									Crtanje.getBojaRama());
							o1.setBojaUnutrasnjosti(Crtanje.getBojaPovrsine());
							listaOblika.add(o1);
						}
					}
					if (OpcijaOblik.getIzabranaOpcija() == OpcijaOblik.getCrtajKrug()) {
						DlgUnosKrug dijalogKrug = new DlgUnosKrug();
						dijalogKrug.setVisible(true);
						if (dijalogKrug.isDozvolaCrtanja() == true) {
							PovrsinskiOblik o1 = new Krug(new Tacka(e.getX(), e.getY()), dijalogKrug.getPoluprecnik(),
									Crtanje.getBojaRama());
							o1.setBojaUnutrasnjosti(Crtanje.getBojaPovrsine());
							listaOblika.add(o1);
						}
					}
				}
				/*koje god dugme da je stisnuto ponistava se selekcija, kasnije menjati!!!*/
				/*
				listaOblika.forEach((a) -> {	
						a.setSelektovan(false);
				});
				*/
				//indeksPoslednjeg = -1;
				// SELEKCIJA
				if (OpcijaRadnja.getIzabranaOpcija() == OpcijaRadnja.getOpcijaSelekcija()) {
					indeksPoslednjeg = -1;
					listaOblika.forEach((a) -> {
						a.setSelektovan(false);
						if (a.sadrzi(e.getX(), e.getY())) {
							indeksPoslednjeg = listaOblika.indexOf(a);
						}
					});
					if(indeksPoslednjeg > -1)
						listaOblika.get(indeksPoslednjeg).setSelektovan(true);
				}
			}
		});
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 * JFrame prozor = new JFrame(); prozor.setSize(800, 600);
		 * prozor.setVisible(true);
		 * prozor.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); Crtez c = new
		 * Crtez(); prozor.getContentPane().add(c);
		 */
	}

	public void paint(Graphics g) {
		
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		listaOblika.forEach((a) -> {
			a.popuni(g);
			a.crtajSe(g);
		});
		getRootPane().validate();
		getRootPane().repaint();
	}

	public static ArrayList<Oblik> getListaOblika() {
		return listaOblika;
	}
	
	public static void setListaOblika(ArrayList<Oblik> listaOblika) {
		Crtez.listaOblika = listaOblika;
	}
	
	public static int getIndeksPoslednjeg() {
		return indeksPoslednjeg;
	}

	public static void setIndeksPoslednjeg(int indeksPoslednjeg) {
		indeksPoslednjeg = indeksPoslednjeg;
	}

}
