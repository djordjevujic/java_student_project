package geometrija;
import java.awt.Color;
import java.awt.Graphics;

public abstract class PovrsinskiOblik extends Oblik{
	protected Color bojaUnutrasnjosti;
	
	public PovrsinskiOblik(){
		
	}

	public PovrsinskiOblik(Color bojaUnutrasnjosti){
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
	
	public abstract double povrsina();
	public abstract double obim();
	public abstract void popuni(Graphics g);
	
	public Color getBojaUnutrasnjosti() {
		return bojaUnutrasnjosti;
	}

	public void setBojaUnutrasnjosti(Color bojaUnutrasnjosti) {
		this.bojaUnutrasnjosti = bojaUnutrasnjosti;
	}
}