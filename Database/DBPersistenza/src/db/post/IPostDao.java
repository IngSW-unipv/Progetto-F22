package db.post;


public interface IPostDao {

	public boolean caricaPost(PostDB p);
	public boolean eliminaPost(PostDB p);
	public boolean inserisciChiavi(PostDB p, String s1, String s2, String s3, String s4, int i1, int i2, boolean b1, boolean b2);
	
}
