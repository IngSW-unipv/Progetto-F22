package db.sondaggioSceltaMultipla;

import java.util.ArrayList;

import post.sondaggio.SondaggioSceltaMultipla;
import post.sondaggio.utility.SondaggioUtility;

public class Tester {

	public static void main(String [] args) {
		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla("P01", null, null, null, 0, 0, false, false, null, "Alligatore", "Coniglio", "Lepre", "Mucca", null);
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		SondaggioUtility u = new SondaggioUtility();
		System.out.println(sdao.rimuoviSondaggio(u.convertiSSM(s)));
		
ArrayList<SondaggioSceltaMultiplaDB> res = sdao.selectAll();
	   
     for(SondaggioSceltaMultiplaDB pst : res)
			System.out.println(pst.toString());
	}
}
