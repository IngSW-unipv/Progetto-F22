package db.post.sondaggio.sondaggiosceltamultipla;


import post.sondaggio.SondaggioSceltaMultipla;

import java.util.ArrayList;

import convertitore.ConvertitoreFacade;
import db.post.PostDB;

public class Tester {

	public static void main(String [] args) {
		ConvertitoreFacade f = ConvertitoreFacade.getIstance();
		SondaggioSceltaMultiplaDB s = new SondaggioSceltaMultiplaDB("S00", null, null, null, 0, 0, false, false, null, null, null, null, null);
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();

		
		System.out.println(sdao.cercaPost(s).toString());
		/*System.out.println(sdao.caricaPost(f.converti(s)));
		
ArrayList<PostDB> res = sdao.selectAll();
	   
     for(PostDB pst : res)
			System.out.println(pst.toString());*/
	}
}
