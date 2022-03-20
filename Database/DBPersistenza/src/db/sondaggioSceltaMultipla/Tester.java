package db.sondaggioSceltaMultipla;


import post.sondaggio.SondaggioSceltaMultipla;

import java.util.ArrayList;

import convertitore.ConvertitoreFacade;

public class Tester {

	public static void main(String [] args) {
		ConvertitoreFacade f = ConvertitoreFacade.getIstance();
		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla("P01", null, null, null, false, false, null, "Alligatore", "Coniglio", "Lepre", "Mucca", null);
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();

		System.out.println(sdao.pubblicaSondaggio(f.converti(s)));
		
ArrayList<SondaggioSceltaMultiplaDB> res = sdao.selectAll();
	   
     for(SondaggioSceltaMultiplaDB pst : res)
			System.out.println(pst.toString());
	}
}
