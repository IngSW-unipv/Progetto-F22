package convertitore;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.chatDiGruppo.gruppo.Gruppo;
import convertitore.commentoChatUtility.CommentoUtility;
import convertitore.followUtility.FollowUtility;
import convertitore.profiloUtility.ProfiloUtility;
import convertitore.gruppoUtility.GruppoUtility;
import convertitore.messaggioUtility.MessaggioUtility;
import convertitore.postUtility.PostUtility;
import db.commento.CommentoDB;
import db.follow.FollowDB;
import db.gruppo.GruppoDB;
import db.messaggio.MessaggioDB;
import db.post.PostDB;
import db.profilo.ProfiloDB;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import profilo.Profilo;
import profilo.follow.Follow;

public class ConvertitoreFacade {
	

	static private ConvertitoreFacade istance;
	
	private PostUtility pstUtility;
	private CommentoUtility cUtility;
	private GruppoUtility gUtility;
	private MessaggioUtility mUtility;
	private ProfiloUtility pUtility;
	private FollowUtility flUtility;
	
	private ConvertitoreFacade() {
		cUtility = new CommentoUtility();
		gUtility = new GruppoUtility();
		mUtility = new MessaggioUtility();
		pUtility = new ProfiloUtility();
		flUtility = new FollowUtility();
		pstUtility = new PostUtility();
	}
	
	public static ConvertitoreFacade getIstance() {
		if(istance == null) {
			istance = new ConvertitoreFacade();
		}
		return istance;
	}

	
	//Messaggi

	public MessaggioDB converti(Messaggio m) {
		return mUtility.converti(m);
	}
	
	public Messaggio convertiInverso(MessaggioDB m, TipoMessaggio t) {
		return mUtility.convertiInverso(m, t);
	}
	
	public String [] ritorna(Messaggio m) {
		return mUtility.ritornaCaratteristiche(m);
	}
	
	public ArrayList<Messaggio> convertiLista(TipoMessaggio t, ArrayList<MessaggioDB> m){
		return mUtility.convertiLista(t, m);
	}
	
	
	//Post
	
	public PostDB converti(Post p) {
		return pstUtility.converti(p);
	}
	
	public Post convertiInverso(PostDB p, TipoPost t) {
		return pstUtility.convertiInverso(p, t);
	}
	
	public String[] ritornaChiaviString(Post p) {
		return pstUtility.ritornaChiaviString(p);
	}
	
	public int ritornaChiaviInt(Post p) {
		return pstUtility.ritornaChiaviInt(p);
	}
	
	public boolean ritornaChiaviBoolean(Post p) {
		return pstUtility.ritornaChiaviBoolean(p);
	}
	
	public ArrayList<Post> convertiLista(TipoPost t, ArrayList<PostDB> p){
		return pstUtility.convertiLista(t, p);
	}
	
	
	//Profilo
	
	public ProfiloDB converti(Profilo p) {
		return pUtility.converti(p);
	}

	public Profilo convertiInverso(ProfiloDB pdb) {
		return pUtility.convertiInverso(pdb);
	}

	public ArrayList<Profilo> convertiLista(ArrayList<ProfiloDB> p){
		return pUtility.convertiLista(p);
	}
	
	//Commenti 
	
	public CommentoDB converti(Commento c) {
		return cUtility.convertiACommentoDB(c);
	}

	public Commento convertiInverso(CommentoDB cdb) {
		return cUtility.convertiACommento(cdb);
	}
	public GruppoDB converti(Gruppo g) {
		return gUtility.convertiAGruppoDB(g);
	}

	public Gruppo convertiInverso(GruppoDB gdb) {
		return gUtility.convertiAGruppo(gdb);
	}
	
	public FollowDB converti(Follow f) {
		return flUtility.convertiAFollowDB(f);
	}
	public Follow convertiinverso(FollowDB f) {
		return flUtility.convertiAFollow(f);
	}
}

