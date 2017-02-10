package geometrija;

import java.awt.Graphics;
import java.awt.Color;

public class Krug extends PovrsinskiOblik implements Pomerljiv{
	private Tacka centar;
	private int r;


	public Krug(){

	}
	public Krug(Tacka centar, int r){
		this.centar = centar;
		this.r = r;

	}
	public Krug(Tacka centar, int r, Color boja){
		this(centar, r);
		setBoja(boja);
	}

	public void pomeriNa(int x, int y){
		centar.setX(x);
		centar.setY(y);
	}
	public void pomeriZa(int x, int y){
		centar.setX(centar.getX()+x);
		centar.setY(centar.getY()+y);
	}
	public double povrsina(){
		return r * r * Math.PI;
	}
	public double obim(){
		return 2 * r * Math.PI;
	}

	// Centar=centar, poluprecnik=r
	public String toString(){
		return "Centar="+centar+", poluprecnik="+r;
	}
	public boolean equals(Object obj){
		if(obj instanceof Krug){
			Krug pomocni = (Krug) obj;
			if(centar.equals(pomocni.centar) && r == pomocni.r)
				return true;
			else
				return false;
		}
		else
			return false;
	}

	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		new Linija(new Tacka(centar.getX(), centar.getY()-r), new Tacka(centar.getX(), centar.getY() + r)).selektovan(g);
		new Linija(new Tacka(centar.getX()-r, centar.getY()), new Tacka(centar.getX()+r, centar.getY())).selektovan(g);
	}
	public void crtajSe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getBoja());
		g.drawOval(centar.getX()-r, centar.getY()-r, 2*r, 2*r);
		if(isSelektovan())
			selektovan(g);

	}
	public void popuni(Graphics g){
		g.setColor(bojaUnutrasnjosti);
		g.fillOval(centar.getX()-r+1, centar.getY()-r+1, 2*r-2, 2*r-2);
	}
	public int compareTo(Object o) {
		if(o instanceof Krug){
			Krug pomocni = (Krug) o;
			return (int) (this.povrsina()-pomocni.povrsina());
		}
		else 
			return 0;
	}
	public boolean sadrzi(int x, int y) {
		if(new Tacka(x, y).udaljenost(getCentar()) <= r)
			return true;
		else
			return false;
	}
	public Tacka getCentar() {
		return centar;
	}
	public int getR() {
		return r;
	}
	public void setCentar(Tacka centar) {
		this.centar = centar;
	}
	public void setR(int r) {
		this.r = r;
	}
}
