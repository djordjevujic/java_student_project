package geometrija;

import java.awt.Color;
import java.awt.Graphics;
public class Kvadrat extends PovrsinskiOblik implements Pomerljiv{
	protected Tacka goreLevo;
	protected int stranica;


	public Kvadrat(){
		
	}
	public Kvadrat(Tacka goreLevo, int stranica){
		this.goreLevo = goreLevo;
		this.stranica = stranica;
	}
	public Kvadrat(Tacka goreLevo, int stranica, Color boja){
		this(goreLevo, stranica);
		setBoja(boja);
	}
	
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+stranica, getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+stranica, getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+stranica), dijagonala().gettKrajnja()).selektovan(g);

	}
	public void crtajSe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), stranica, stranica);
		if(isSelektovan())
			selektovan(g);
	}
	public void pomeriNa(int x, int y){
		goreLevo.setX(x);
		goreLevo.setY(y);
	}
	public void pomeriZa(int x, int y){
		goreLevo.setX(goreLevo.getX()+x);
		goreLevo.setY(goreLevo.getY()+y);
	}
	public double povrsina(){
		return stranica * stranica;
	}
	public double obim(){
		return 4 * stranica;
	}
	public void popuni(Graphics g){
		g.setColor(bojaUnutrasnjosti);
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, stranica-1, stranica-1);
	}

	//Tacka gore levo=(xGoreLevo,yGoreLevo), duzina stranice=stranica
	public String toString(){
		return "Tacka gore levo="+goreLevo+", duzina stranice="+stranica;
	}
	public boolean equals(Object obj){
		if(obj instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) obj;
			if(goreLevo.equals(pomocni.goreLevo) && stranica == pomocni.stranica)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + stranica,goreLevo.getY() + stranica));
	}
	public Tacka centar(){
		return dijagonala().sredinaLinije();
	}
	public int compareTo(Object o) {
		if(o instanceof Kvadrat){
			Kvadrat pomocni = (Kvadrat) o;
			return (int) (this.povrsina()-pomocni.povrsina());
		}
		else 
			return 0;
	}

	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + stranica)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + stranica))
			return true;
		else 
			return false;

	}
	public Tacka getGoreLevo() {
		return goreLevo;
	}
	public int getStranica() {
		return stranica;
	}
	public void setGoreLevo(Tacka goreLevo) {
		this.goreLevo = goreLevo;
	}
	public void setStranica(int stranica) {
		this.stranica = stranica;
	}
}
