package post;

import java.util.ArrayList;

public interface IPost {

	public ArrayList<Post> selectAll();
	public boolean caricaPost(Post p);
	public boolean rimuoviPost(Post p);
	
}
