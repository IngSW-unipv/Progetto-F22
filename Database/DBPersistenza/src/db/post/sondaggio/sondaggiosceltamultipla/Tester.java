package db.post.sondaggio.sondaggiosceltamultipla;


import java.util.ArrayList;

import db.post.PostDB;

public class Tester {

	public static void main(String [] args) {
		SondaggioSceltaMultiplaDB s = new SondaggioSceltaMultiplaDB("S02", null, null, "desrue", 0, 0, true, "DV999", "cavallo", "paguro", "lepre", "Anguilla", 0, 0, 0, 0);
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
        
		
		System.out.println(sdao.cercaPost(s).toString());
	
		
ArrayList<PostDB> res = sdao.selectAll();
	   
     for(PostDB pst : res)
			System.out.println(pst.toString());
		System.out.println(sdao.caricaPost(s));
	}
}
