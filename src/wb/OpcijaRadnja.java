package wb;

public class OpcijaRadnja {
	private static int izabranaOpcija = 0; //po defaultu nije izabrana ni jedna radnja!
	
	private static final int opcijaCrtanje      = 1;
	private static final int opcijaSelekcija    = 2;
	private static final int opcijaModifikacija = 3;
	private static final int opcijaPomeranje	= 4;
	private static final int opcijaBrisanje		= 5;
	
	
	public static int getIzabranaOpcija() {
		return izabranaOpcija;
	}
	public static void setIzabranaOpcija(int izabranaOpcija) {
		OpcijaRadnja.izabranaOpcija = izabranaOpcija;
	}
	public static int getOpcijaCrtanje() {
		return opcijaCrtanje;
	}
	public static int getOpcijaSelekcija() {
		return opcijaSelekcija;
	}
	public static int getOpcijaModifikacija() {
		return opcijaModifikacija;
	}
	public static int getOpcijaPomeranje() {
		return opcijaPomeranje;
	}
	public static int getOpcijaBrisanje() {
		return opcijaBrisanje;
	}
	
}
