package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Linija extends Oblik{
	private Tacka tPocetna;
	private Tacka tKrajnja;
	public static int brojac;
	
	
	public Linija(){

	}
	public Linija(Tacka tPocetna, Tacka tKrajnja){
		this.tPocetna = tPocetna;
		this.tKrajnja = tKrajnja;
	}
	public Linija(Tacka tPocetna, Tacka tKrajnja, Color boja){
		this(tPocetna, tKrajnja);
		setBoja(boja);
	}
	
	public void pomeriZa(int x, int y){
		tPocetna.setX(tPocetna.getX()+x);
		tPocetna.setY(tPocetna.getY()+y);
		tKrajnja.setX(tKrajnja.getX()+x);
		tKrajnja.setY(tKrajnja.getY()+y);		
	}
	//pocetna se pomera na zadatu poziciju,a  jednako sa njom i krajnja
	public void pomeriNa(int x, int y){
		int deltaX;
		int deltaY;
		deltaX = x - tPocetna.getX();
		deltaY = y - tPocetna.getY();
		tKrajnja.setX(tKrajnja.getX()+deltaX);
		tKrajnja.setY(tKrajnja.getY()+deltaY);
		tPocetna.setX(x);
		tPocetna.setY(y);
	}
	// (xPocetne,yPocetne)-->(xKrajnje,yKrajnje)
	public String toString(){
		return tPocetna+"-->"+tKrajnja;
	}
	public double duzina(){
		return tPocetna.udaljenost(tKrajnja);
	}
	public boolean equals(Object obj){
		if(obj instanceof Linija){
			Linija pomocna = (Linija) obj;
			if(tPocetna.equals(pomocna.tPocetna) && tKrajnja.equals(pomocna.tKrajnja))
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public void selektovan(Graphics g){

		g.setColor(Color.BLUE);
		tPocetna.selektovan(g);
		tKrajnja.selektovan(g);
		sredinaLinije().selektovan(g);

	}
	public void crtajSe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getBoja());
		g.drawLine(tPocetna.getX(), tPocetna.getY(), tKrajnja.getX(), tKrajnja.getY());
		
		if(isSelektovan())
			selektovan(g);
	}
	public Tacka sredinaLinije(){
		int sredinaX = (tPocetna.getX() + tKrajnja.getX()) / 2;
		int sredinaY = (tPocetna.getY() + tKrajnja.getY()) / 2;
		return new Tacka(sredinaX, sredinaY);
	}
	public int compareTo(Object o) {
		if(o instanceof Linija){
			Linija pomocna = (Linija) o;
			return (int)this.duzina()-(int)pomocna.duzina();
		}
		else 
			return 0;
	}
	
	public boolean sadrzi(int x, int y) {
		Tacka prosledjena = new Tacka(x, y);
		if(prosledjena.udaljenost(tPocetna)+prosledjena.udaljenost(tKrajnja)-this.duzina()<=0.5)
			return true;
		 else 
			return false;
		
	}
	public void popuni(Graphics g){
		
	}
	
	public Tacka gettPocetna(){
		return tPocetna;
	}
	public Tacka gettKrajnja(){
		return tKrajnja;
	}
	public void settPocetna(Tacka tPocetna){
		this.tPocetna = tPocetna;
	}
	public void settKrajnja(Tacka tKrajnja){
		this.tKrajnja = tKrajnja;
	}

}
