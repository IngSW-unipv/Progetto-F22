package db.sondaggioDoppiaScelta;

import java.util.ArrayList;

import post.Post;

public interface ISondaggioDoppiaVotazioneDao {
	public ArrayList<Post> selectAll();
	public boolean pubblicaSondaggio(Post p);
	public boolean rimuoviSondaggio(Post p);
	public boolean aggiungiScelte(Post p, String scelta1, String scelta2);
}
