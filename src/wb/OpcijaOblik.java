package wb;

public class OpcijaOblik {

	private static int izabranaOpcija = 0;
	
	final static int crtajTacku		= 1;
	final static int crtajLiniju		= 2;
	final static int crtajKvadrat		= 3;
	final static int crtajPravougaonik = 4;
	final static int crtajKrug 		= 5;
	
	
	public static int getIzabranaOpcija() {
		return izabranaOpcija;
	}
	public static void setIzabranaOpcija(int izabranaOpcija) {
		OpcijaOblik.izabranaOpcija = izabranaOpcija;
	}
	
	public static int getCrtajTacku() {
		return crtajTacku;
	}
	public static int getCrtajLiniju() {
		return crtajLiniju;
	}
	public static int getCrtajKvadrat() {
		return crtajKvadrat;
	}
	public static int getCrtajPravougaonik() {
		return crtajPravougaonik;
	}
	public static int getCrtajKrug() {
		return crtajKrug;
	}
}
