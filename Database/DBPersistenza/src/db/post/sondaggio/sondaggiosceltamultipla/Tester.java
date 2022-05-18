package db.post.sondaggio.sondaggiosceltamultipla;


import post.sondaggio.SondaggioSceltaMultipla;

import java.util.ArrayList;

import convertitore.ConvertitoreFacade;
import db.post.PostDB;

public class Tester {

	public static void main(String [] args) {
		ConvertitoreFacade f = ConvertitoreFacade.getIstance();
		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla("P01", null, null, null, false, false, null, "Alligatore", "Coniglio", "Lepre", "Mucca", null);
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();

		System.out.println(sdao.caricaPost(f.converti(s)));
		
ArrayList<PostDB> res = sdao.selectAll();
	   
     for(PostDB pst : res)
			System.out.println(pst.toString());
	}
}
