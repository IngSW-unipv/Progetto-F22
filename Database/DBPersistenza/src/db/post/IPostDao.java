package db.post;

import java.util.ArrayList;

public interface IPostDao {

	public boolean caricaPost(PostDB p);
	public boolean eliminaPost(PostDB p);
	public abstract boolean inserisciChiavi(PostDB p, String [] s, int i, boolean b);
	public PostDB cercaPost(PostDB p);
	public ArrayList<PostDB> selectAll();
}
