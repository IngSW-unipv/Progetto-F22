package db.post;

import java.util.ArrayList;

import db.commento.CommentoDB;

public interface IPostDao {

	public boolean caricaPost(PostDB p);
	public boolean eliminaPost(PostDB p);
	public abstract boolean inserisciChiavi(PostDB p, String [] s, int i, boolean b);
	public PostDB cercaPost(PostDB p);
	public ArrayList<PostDB> selectAll();
	public abstract String ottieniPercorso(PostDB m);
	
	//ritorna l'id e il percorso di tutti i post relativi ad un profilo ordinati per dataPubblicazione, oraInvio
	public ArrayList<String> ritornaPostDiUnProfilo(String idProfilo);
	
	//Ritorna un'arrayList con tutte le informazioni relative ad un determinato post
	public ArrayList<CommentoDB> mostraCommentiSottoPost(PostDB c);
	
	//Ritorna un'arrayList di stringhe con tutti i commenti sotto ad un post
    public ArrayList<String> mostraTestoCommentiPost(PostDB c);
    
    public boolean modificaVisibile(PostDB p, boolean b);
    public boolean vediVisibilita(PostDB p);
    
    public int vediNumLike(PostDB p);
    public boolean modificaNumLike(PostDB p, int n);
    
    public int vediNumDislike(PostDB p);
    public boolean modificaNumDislike(PostDB p, int n);
    
    public boolean modificaTempoCancellazione(PostDB m,int tempo);
    public boolean modificaIsStory(PostDB m,boolean b);
	ArrayList<String> caricaPostProfiliSeguiti(String profilo);
	ArrayList<String> caricaStorieProfiliSeguiti(String profilo);
    
}
