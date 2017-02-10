package geometrija;
import java.awt.Color;
import java.awt.Graphics;

public class Tacka extends Oblik implements Pomerljiv{
	private int x;
	private int y;

	public Tacka(){

	}	
	public Tacka(int x, int y){
		this.x = x;
		this.y = y;
	}
	public Tacka(int x, int y, Color boja){
		this(x, y);
		setBoja(boja);
	}

	public void pomeriNa(int x, int y){
		this.x = x;
		setY(y);
	}
	public void pomeriZa(int x, int y){
		this.x = this.x+x;
		setY(getY()+y);
	}
	public double udaljenost(Tacka t2){
		double dx = t2.x-this.x;
		double dy = t2.getY()-this.y;
		double d = Math.sqrt(dx*dx + dy*dy);
		return d;
	}
	// (x,y)
	public String toString(){
		return "("+x+","+y+")";
	}
	public boolean equals(Object obj){
		if(obj instanceof Tacka){
			Tacka pomocna = (Tacka) obj;
			if(x == pomocna.x && y == pomocna.y)
				return true;
			else 
				return false;
		}
		else
			return false;
	}

	public void selektovan(Graphics g){
		g.setColor(Color.BLUE);
		g.drawRect(x-3, y-3, 6, 6);
	}

	public void crtajSe(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(getBoja());
		g.drawLine(x-2, y, x+2, y);
		g.drawLine(x, y-2, x, y+2);

		if(isSelektovan())
			selektovan(g);

	}
	public int compareTo(Object o) {
		if(o instanceof Tacka){
			Tacka pomocna = (Tacka) o;
			return (int)this.udaljenost(new Tacka(0, 0)) - (int)pomocna.udaljenost(new Tacka(0,0));
		}
		else 
			return 0;
	}

	public boolean sadrzi(int x, int y){
		if(this.udaljenost(new Tacka(x, y))<=2)
			return true;
		else 
			return false;
	}

	public void popuni(Graphics g){
		
	}

	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
		this.y = y;
	}

}
