package db.post;



public abstract class PostDao implements IPostDao{

	public abstract boolean caricaPost(PostDB p);

    public abstract boolean eliminaPost(PostDB p);
    
    public abstract boolean inserisciChiavi(PostDB p, String s1, String s2, String s3, String s4, int i1, int i2, boolean b1, boolean b2);
}
