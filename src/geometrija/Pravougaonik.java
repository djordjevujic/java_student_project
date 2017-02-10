package geometrija;

import java.awt.Color;
import java.awt.Graphics;

public class Pravougaonik extends Kvadrat{
	private int visina;
	
	
	public Pravougaonik(){
		
	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina){
		super(goreLevo, sirina);
		this.visina = visina;
	}
	public Pravougaonik(Tacka goreLevo, int sirina, int visina, Color boja){
		this(goreLevo, sirina, visina);
		setBoja(boja);
	}
	
	
	public double povrsina(){
		return stranica * visina;
	}
	public double obim(){
		return 2 * (stranica + visina);
	}
	// Tacka gore levo=(xGoreLevo,yGoreLevo), sirina=sirina, visina=visina
	public String toString(){
		return "Tacka gore levo="+goreLevo+", sirina="+stranica+", visina="+visina;
	}
	public boolean equals(Object obj){
		if(obj instanceof Pravougaonik){
			Pravougaonik pomocni = (Pravougaonik) obj;
			if(goreLevo.equals(pomocni.goreLevo) && stranica == pomocni.stranica && visina == pomocni.visina)
				return true;
			else
				return false;
		}
		else
			return false;
	}
	public void selektovan(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLUE);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX()+getStranica(), getGoreLevo().getY())).selektovan(g);
		new Linija(getGoreLevo(), new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina)).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX()+getStranica(), getGoreLevo().getY()), dijagonala().gettKrajnja()).selektovan(g);
		new Linija(new Tacka(getGoreLevo().getX(), getGoreLevo().getY()+visina), dijagonala().gettKrajnja()).selektovan(g);
	}
	public void crtajSe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getBoja());
		g.drawRect(goreLevo.getX(), goreLevo.getY(), stranica, visina);
		if(isSelektovan())
			selektovan(g);
	}
	public void popuni(Graphics g){
		g.setColor(bojaUnutrasnjosti);
		g.fillRect(goreLevo.getX()+1, goreLevo.getY()+1, stranica-1, visina-1);
	}
	public Linija dijagonala(){
		return new Linija(goreLevo, new Tacka(goreLevo.getX() + stranica,goreLevo.getY() + visina));
	}
	public boolean sadrzi(int x, int y) {
		if(this.getGoreLevo().getX()<=x 
				&& x<=(this.getGoreLevo().getX() + stranica)
				&& this.getGoreLevo().getY()<=y 
				&& y<=(this.getGoreLevo().getY() + visina))
			return true;
		else 
			return false;

	}
	public int getVisina() {
		return visina;
	}
	
	public void setVisina(int visina) {
		this.visina = visina;
	}
	
}
