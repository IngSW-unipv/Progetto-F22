package db.foto;

import java.util.ArrayList;

import post.Post;

public interface IFotoDao {
	public ArrayList<Post> selectAll();
	public boolean pubblicaFoto(Post f);
	public boolean rimuoviFoto(Post f);
	public boolean inserisciCaratteristiche(Post v, int t, String p, boolean s, boolean d);
}
