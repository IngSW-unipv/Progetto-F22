package post.testo;

import post.testo.utility.UtilityTesto;


public class TestoTester {
	public static void main(String[] args) {
		Testo t = new Testo("P00", null, null, null, 0, 0, false, false, false, "001", "T00", "Arial", null);
		UtilityTesto u = new UtilityTesto();
		//System.out.println(t.pubblicaTesto(u.convertiToTestoDB(t)));
		System.out.println(t.rimuoviTesto(u.convertiToTestoDB(t)));
	}
}
