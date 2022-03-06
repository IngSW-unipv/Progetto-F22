package db.testo;

import java.util.ArrayList;

import post.Post;

public interface ITestoDao {
  
	public ArrayList<Post> selectAll();
	public boolean pubblicaTesto(Post p);
	public boolean rimuoviTesto(Post p);
	public boolean aggiungiCaratteristiche(Post p, String s1, String s2);
}
