package it.unipv.ings.Post;

import java.util.ArrayList;

import post.Post;

public interface IPostDao {
	public ArrayList<Post> selectAll();
	public boolean pubblicaPost(Post p);
	public boolean inserisciChiavi(Post p);
	public boolean rimuoviPost(Post p);
}
