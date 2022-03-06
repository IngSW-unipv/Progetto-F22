package db.video;

import java.util.ArrayList;

import post.Post;

public interface IVideoDao {
	public ArrayList<Post> selectAll();
	public boolean pubblicaVideo(Post v);
	public boolean rimuoviVideo(Post v);
	public boolean inserisciCaratteristiche(Post v, int t, String p, boolean s, int d);
}
