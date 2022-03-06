package post;

import java.util.ArrayList;

import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;

public class PostTester {

	public static void main(String [] args) {
		SondaggioSceltaMultipla smul = new SondaggioSceltaMultipla("P00", null, null, "wow", 0, 0, false, false, "001", "Cane", "Gatto", "Pecora", "Gallina", null);
		SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione("P00", null, null, "Che bello il mare", 0, 0, false, false, "001", "Cane", "Gatto", null);
		Testo t = new Testo("T00", null, null, null, 0, 0, false, false, "001", "Arial", "Il mio primo post");		
		
		ArrayList<Post> lista = new ArrayList<>();
		lista.add(smul);
		lista.add(sdv);
		lista.add(t);
		
		for(Post p : lista) {
			p.selectAll();
			System.out.println(p.toString());
		}
	}
}
