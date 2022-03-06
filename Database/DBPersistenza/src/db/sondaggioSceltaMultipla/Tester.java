package db.sondaggioSceltaMultipla;

import java.util.ArrayList;

import post.Post;
import post.sondaggio.SondaggioSceltaMultipla;

public class Tester {

	public static void main(String [] args) {
		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla("P01", null, null, null, 0, 0, false, false, null, "Alligatore", "Coniglio", "Lepre", "Mucca", null);
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		
		System.out.println(sdao.rimuoviSondaggio(s));
		
ArrayList<Post> res = sdao.selectAll();
	   
     for(Post pst : res)
			System.out.println(pst.toString());
	}
}
