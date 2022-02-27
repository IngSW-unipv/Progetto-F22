package profilo;

import java.util.HashMap;

public class ProfiloTester {
	
    public static void main(String [] args) {
	
	Profilo p1 = new Profilo("P00", null, null, 0, 0, 0, null, null, null, null, null);
	Profilo p2 = new Profilo("P01", null, null, 0, 0, 0, null, null, null, null, "myPost");
	Profilo p3 = new Profilo("P02", "nocera", null, 0, 0, 0, null, null, null, null, null);
	HashMap <String, String> res = p1.modificaFollow(p2);
	//HashMap <String, String> res = p1.modificaFollow(p2);
	//res = p1.modificaFollow(p3);
	for (String name: res.keySet()) {
	    String key = name.toString();
	    String value = res.get(name).toString();
	    System.out.println(key + " " + value);
	}

		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p1.cercaProfilo(p3));
		
		p1.mostraInformazioniProfiloPubblico(p2);
		


 }
    
}
