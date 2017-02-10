package geometrija;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Tacka t1 = new Tacka();
		System.out.println("X koordinata tacke t1: "+t1.getX());
		t1.setX(10);
		System.out.println("X koordinata tacke t1: "+t1.getX());
		t1.pomeriNa(15, 20);
		System.out.println("Y koordinata t1:"+t1.getY());
		t1.pomeriZa(-5, 5);
		System.out.println("X koordinata tacke t1: "+t1.getX());
		System.out.println("Y koordinata tacke t1: "+t1.getY());
		Tacka t2 = new Tacka();
		t2.setX(20);
		t2.setY(30);
		double udaljenost = t1.udaljenost(t2);
		System.out.println("Udaljenost: "+udaljenost);
		Linija l1 = new Linija();
		l1.settPocetna(t1);
		l1.settKrajnja(t2);
		System.out.println("Y krajnje tacke l1: "+l1.gettKrajnja().getY());
		System.out.println("Duzina l1: "+l1.duzina());
		//inicijalizovati x koordinatu pocetne tacke linije l1 na vrednost
		// y koordinate krajnje tacke linije l1
		l1.gettPocetna().setX(l1.gettPocetna().getY());
		System.out.println("X: "+l1.gettPocetna().getX());
		Pravougaonik p1 = new Pravougaonik();
		// postaviti x koordinatu tacke gore levo pravougaonika p1 na vrednost 10
		p1.setGoreLevo(t2);
		p1.getGoreLevo().setX(10);
		System.out.println("X koordinata tacke gore levo p1");
		System.out.println(p1.getGoreLevo().getX());
		p1.setSirina(50);
		p1.setVisina(100);
		//y koordinata tacke gore levo p1 na vrednost zbira obima i povrsine
		p1.getGoreLevo().setY(p1.povrsina() + p1.obim());
		System.out.println("Y gore levo p1: "+p1.getGoreLevo().getY());
		Kvadrat kv1 = new Kvadrat();
		//postaviti tacku gore levo kv1 na krajnju tacku linije l1
		kv1.setGoreLevo(l1.gettKrajnja());
		Krug kr1 = new Krug();
		//postaviti centar kruga na tacku gore levo p1
		kr1.setCentar(p1.getGoreLevo());
		//postaviti x koordinatu centra kruga na vrednost razlike zbira
		//obima i povrsine kvadrata i y koordinate pocetne tacke linije l1
		kr1.getCentar().setX((kv1.obim()+kv1.povrsina())-l1.gettPocetna().getY());
		System.out.println("X centra kr1: "+kr1.getCentar().getX());
		Tacka t3 = new Tacka(55, 44);
		System.out.println("X t3: "+t3.getX());
		Tacka t4 = new Tacka(66, 77, "crna");
		t3 = t4;//referenca na istu lokaciju
		Tacka t5 = new Tacka(t4.getX(), t4.getY(), t4.getBoja());
		System.out.println("Boja t5: "+t5.getBoja());
		Linija l2 = new Linija(new Tacka(30, 40), new Tacka(35, 45, "plava"));
		System.out.println("Duzina l2: "+l2.duzina());
		t1 = l2.gettPocetna();
		System.out.println("X t1: "+t1.getX());
		System.out.println("Boja pocetne tacke l2: "+l2.gettPocetna().getBoja());
		//kreirati pravougaonik p2 sa novom tackom 15, 20 
		//visina 50
		//sirina 40
		//boja = boja l1
		Pravougaonik p2 = new Pravougaonik(new Tacka(15,20),40,50,l1.getBoja());*/
		/*Tacka t1 = new Tacka(10, 10);
		System.out.println(t1);
		Linija l1 = new Linija(t1, new Tacka(20, 20));
		System.out.println(l1);
		Pravougaonik p1 = new Pravougaonik(t1, 100, 50);
		System.out.println(p1);
		Kvadrat kv1 = new Kvadrat(t1, 75);
		System.out.println(kv1);
		Krug kr1 = new Krug(t1, 65);
		System.out.println(kr1);
		
		Tacka t2 = new Tacka(15, 15);
		Tacka t3 = t2;
		Tacka t4 = new Tacka(15, 15);
		
		if(t2 == t3)
			System.out.println("Tacke t2 i t3 su iste!");
		if(t2 == t4)
			System.out.println("Tacke t2 i t4 su iste!");
		if(t2.equals(t3))
			System.out.println("Tacke t2 i t3 su iste! equals");
		if(t2.equals(t4))
			System.out.println("Tacke t2 i t4 su iste! equals");
		
		Linija l2 = new Linija(new Tacka(22, 22), new Tacka(33, 33));
		Linija l3 = new Linija(new Tacka(22, 22), new Tacka(33, 33));
		System.out.println("l2 je ista kao l3? "+l2.equals(l3));
		
		Pravougaonik p2 = new Pravougaonik(new Tacka(100, 100), 10, 20);
		Pravougaonik p3 = new Pravougaonik(new Tacka(100, 100), 45, 54);
		System.out.println("p2 = p3? "+p2.equals(p3));
		Kvadrat kv2 = new Kvadrat(new Tacka(50, 50), 75);
		Kvadrat kv3 = new Kvadrat(new Tacka(50, 50), 75);
		System.out.println("kv2 = kv3? "+kv2.equals(kv3));
		Krug kr2 = new Krug(new Tacka(80, 80),99);
		Krug kr3 = new Krug(new Tacka(80, 80),99);
		System.out.println("kr2 = kr3? "+kr2.equals(kr3));
		
		l2.gettPocetna().setBoja("plava");
		l2.setBoja("crna");
		System.out.println("Boja pocetne tacke l2: "+l2.gettPocetna().getBoja());
		Oblik obl = new Tacka();
		//Tacka tObl = new Oblik(); - ne moze
		obl.setBoja("zelena");
		Tacka oblTacka = (Tacka)obl;
		System.out.println(oblTacka.getX());
		System.out.println("povrsina p2: "+ p2.povrsina());
		
		Pravougaonik p4 = new Pravougaonik(new Tacka(10, 10), 50, 100,"zuta");
		Kvadrat kv4 = new Kvadrat(new Tacka(5, 5), 55,"crvena");
		System.out.println("Gore levo p4: "+p4.getGoreLevo());
		System.out.println("Gore levo kv4: "+kv4.getGoreLevo());
		p4.pomeriZa(10, 10);
		kv4.pomeriZa(20, 20);
		System.out.println("Gore levo p4: "+p4.getGoreLevo());
		System.out.println("Gore levo kv4: "+kv4.getGoreLevo());
		//Oblik o2 = new Oblik(); - ne moze!
		*/	
		/*Tacka t1 = new Tacka(10, 10);
		Tacka t2 = new Tacka(20, 20);
		Tacka t3 = new Tacka(30, 30);
		Tacka t4 = new Tacka(40, 40);
		
		// kreirati niz nizTacaka i dodati tacke po redosledu:
		// t3, t4, t2, t1
		Tacka[] nizTacaka = {t3,t4,t2,t1};
		//nakon toga ispisati niz
		for(int i=0;i<nizTacaka.length;i++)
			System.out.println(nizTacaka[i]);
		
		Arrays.sort(nizTacaka);
		
		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizTacaka.length;i++)
			System.out.println(nizTacaka[i]);
		
		Linija l1 = new Linija(t1, new Tacka(20, 20));
		Linija l2 = new Linija(t1, new Tacka(30, 30));
		Linija l3 = new Linija(t1, new Tacka(40, 40));
		Linija l4 = new Linija(t1, new Tacka(50, 50));
		
		Linija[] nizLinija = {l3,l4,l2,l1};
		
		for(int i=0;i<nizLinija.length;i++)
			System.out.println(nizLinija[i]);
		
		Arrays.sort(nizLinija);
		
		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizLinija.length;i++)
			System.out.println(nizLinija[i]);
		
		Kvadrat kv1 = new Kvadrat(t1, 10);
		Kvadrat kv2 = new Kvadrat(t1, 20);
		Kvadrat kv3 = new Kvadrat(t1, 30);
		Kvadrat kv4 = new Kvadrat(t1, 40);
		
		Kvadrat[] nizKvadrata = {kv3,kv4,kv2,kv1};
		for(int i=0;i<nizKvadrata.length;i++)
			System.out.println(nizKvadrata[i]);
		
		Arrays.sort(nizKvadrata);
		
		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizKvadrata.length;i++)
		
		Pravougaonik p1 = new Pravougaonik(t1,100,10);
		Pravougaonik p2 = new Pravougaonik(t1,100,20);
		Pravougaonik p3 = new Pravougaonik(t1,100,30);
		Pravougaonik p4 = new Pravougaonik(t1,100,40);
		
		Kvadrat[] nizPravougaonika = {p3,p4,p2,p1};
		for(int i=0;i<nizPravougaonika.length;i++)
			System.out.println(nizPravougaonika[i]);
		
		Arrays.sort(nizPravougaonika);
		
		System.out.println("Sortiran niz: ");
		for(int i=0;i<nizPravougaonika.length;i++)
			System.out.println(nizPravougaonika[i]);
		*/
		
		Tacka t1 = new Tacka(10, 10);
		Krug k1 = new Krug(t1, 10);
		Krug k2 = new Krug(t1, 20);
		Krug k3 = new Krug(t1, 30);
		Krug k4 = new Krug(t1, 40);

		Krug[] nizKrugova = {k3,k4,k2,k1};
		try {
			for(int i=0;i<100;i++)
				System.out.println(nizKrugova[i]);
			Integer.parseInt("pet");
		}catch (IndexOutOfBoundsException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Niz nema toliko elemenata!");
		}catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			System.out.println("Nije moguce pretvoriti string u int!");
		}
		
		finally {
			System.out.println("finally");
		}
		
		ArrayList<Krug> listaKrugova = new ArrayList<Krug>();
		listaKrugova.add(k1);
		listaKrugova.add(k2);
		listaKrugova.add(k3);
		listaKrugova.add(1, k4);
		listaKrugova.remove(k2);
		listaKrugova.remove(2);
		
		System.out.println("Ispis liste na konzolu");
		Iterator it = listaKrugova.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		System.out.println(listaKrugova.size());
		
		
		HashMap<String, Oblik> hm = new HashMap();
		hm.put("tacka", t1);
		hm.put("krug", k2);
		hm.remove("krug", k1);
		hm.put("tacka", k1);
		

		System.out.println(hm.get("tacka"));
				
	}

}