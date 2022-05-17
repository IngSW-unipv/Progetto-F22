package db.post;

import java.util.ArrayList;

public abstract class PostDao implements IPostDao{

	@Override
	public abstract boolean caricaPost(PostDB p);

	@Override
    public abstract boolean eliminaPost(PostDB p);
    
	@Override
    public abstract boolean inserisciChiavi(PostDB p, String [] s, int i, boolean b);
    
	@Override
    public abstract PostDB cercaPost(PostDB p);
	
	@Override 
	public abstract ArrayList<PostDB> selectAll();
}
