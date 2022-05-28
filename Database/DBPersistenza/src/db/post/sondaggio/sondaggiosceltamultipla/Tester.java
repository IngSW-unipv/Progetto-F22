package db.post.sondaggio.sondaggiosceltamultipla;


import java.util.ArrayList;

import db.post.PostDB;

public class Tester {

	public static void main(String [] args) {
		SondaggioSceltaMultiplaDB s = new SondaggioSceltaMultiplaDB("S00", null, null, null, 0, 0, false, null, null, null, null, null);
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();

		
		System.out.println(sdao.cercaPost(s).toString());
	
		
ArrayList<PostDB> res = sdao.selectAll();
	   
     for(PostDB pst : res)
			System.out.println(pst.toString());
	}
}
