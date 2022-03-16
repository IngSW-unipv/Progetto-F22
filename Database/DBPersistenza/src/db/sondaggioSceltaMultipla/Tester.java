package db.sondaggioSceltaMultipla;


import post.sondaggio.SondaggioSceltaMultipla;

import java.util.ArrayList;

import convertitore.sondaggioUtility.*;

public class Tester {

	public static void main(String [] args) {
		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla("P01", null, null, null, false, false, null, "Alligatore", "Coniglio", "Lepre", "Mucca", null);
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();

		//System.out.println(sdao.pubblicaSondaggio(SondaggioUtility.convertiASondMulDB(s)));
		
ArrayList<SondaggioSceltaMultiplaDB> res = sdao.selectAll();
	   
     for(SondaggioSceltaMultiplaDB pst : res)
			System.out.println(pst.toString());
	}
}
