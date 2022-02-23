package post;

import java.util.ArrayList;

public interface IPost {

	public ArrayList<Post> selectAll();
	public boolean pubblicaPost(Post p);
	public boolean inserisciChiavi(Post p);
	public boolean rimuoviPost(Post p);
	
}
