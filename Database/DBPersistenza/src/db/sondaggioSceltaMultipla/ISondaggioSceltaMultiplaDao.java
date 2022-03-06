package db.sondaggioSceltaMultipla;

import java.util.ArrayList;

import post.Post;

public interface ISondaggioSceltaMultiplaDao {

	public ArrayList<Post> selectAll();
	public boolean pubblicaSondaggio(Post s);
	public boolean rimuoviSondaggio(Post p);
	public boolean aggiungiScelte(Post p, String scelta1, String scelta2, String scelta3, String scelta4);
}
