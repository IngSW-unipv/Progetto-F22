package db.post;



public abstract class PostDao implements IPostDao{

	public abstract boolean caricaPost(PostDB p);

    public abstract boolean eliminaPost(PostDB p);
    
    public abstract boolean inserisciChiavi(PostDB p, String [] s, int [] i, boolean [] b);
}
