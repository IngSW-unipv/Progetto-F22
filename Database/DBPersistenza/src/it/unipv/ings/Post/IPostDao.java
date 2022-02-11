package it.unipv.ings.Post;

import java.util.ArrayList;

public interface IPostDao {
	public ArrayList<Post> selectAll();
	public boolean pubblicaPost(Post p);
	public boolean inserisciChiavi(Post p);
	public boolean rimuoviProfilo(Post p);
}
