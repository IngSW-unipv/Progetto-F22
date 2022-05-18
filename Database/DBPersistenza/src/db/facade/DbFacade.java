package db.facade;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.chatDiGruppo.gruppo.Gruppo;
import profilo.Profilo;
import profilo.exception.AccountDoesNotExist;
import profilo.follow.Follow;
import db.commento.CommentoDB;
import db.commento.CommentoDao;
import db.follow.FollowDB;
import db.follow.FollowDao;
import db.gruppo.GruppoDB;
import db.gruppo.GruppoDao;
import db.messaggio.MessaggioDB;
import db.messaggio.MessaggioDao;
import db.post.PostDB;
import db.post.PostDao;
import db.profilo.ProfiloDB;
import db.profilo.ProfiloDao;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import convertitore.ConvertitoreFacade;

public class DbFacade {
	
	private static DbFacade istance;
	
	
	private MessaggioDao mDao;
	private PostDao pstDao;
	
	private CommentoDao cDao;
	
	private GruppoDao gDao;
	private ProfiloDao pDao;
	private FollowDao flDao;
	
	
	private DbFacade() {
		cDao = new CommentoDao();
		gDao = new GruppoDao();
		pDao = new ProfiloDao();
		flDao = new FollowDao();
	}
	
	public static DbFacade getIstance() {
		if(istance == null) {
			istance = new DbFacade();
		}
		return istance;
	}
	
	//Commenti
	
	public boolean carica(Commento c) {
	    return cDao.scriviCommento(ConvertitoreFacade.getIstance().converti(c));
		
	}
	
	public boolean rimuovi(Commento c) {
		return cDao.rimuoviCommento(ConvertitoreFacade.getIstance().converti(c));
	
	}

	public Commento cerca(Commento c) {
		CommentoDB cdb = cDao.cercaCommento(ConvertitoreFacade.getIstance().converti(c));
		return ConvertitoreFacade.getIstance().convertiInverso(cdb);
	}
	
	
	public ArrayList<Commento> selectAllCommenti(Commento c){
		return ConvertitoreFacade.getIstance().convertiListaCommenti(cDao.mostraCommentiSottoPost(ConvertitoreFacade.getIstance().converti(c)));
	}
	

    //Gruppi
	
	public boolean carica(Gruppo g) {
		return gDao.creaGruppo(ConvertitoreFacade.getIstance().converti(g));
	
	}
	
	public boolean rimuovi(Gruppo g) {
		return gDao.cancellaGruppo(ConvertitoreFacade.getIstance().converti(g));
		
	}
	
	public boolean gestisciPartecipanti(Gruppo g) {
		return gDao.inserisciChiavi(ConvertitoreFacade.getIstance().converti(g));
		
	}

	public Gruppo cerca(Gruppo g) {
		GruppoDB gdb = gDao.cercaGruppo(ConvertitoreFacade.getIstance().converti(g));
		return ConvertitoreFacade.getIstance().convertiInverso(gdb);
	}
	
	public ArrayList<Gruppo> selectAllGruppo() {
		return ConvertitoreFacade.getIstance().convertiListaGruppi(gDao.selectall());
	}
	
	
	//Messaggi
	
	
	public boolean carica(Messaggio md) {
		mDao = Utility.convertiTipoMessaggio(md.getTipo());
		boolean b = mDao.scriviMessaggio(ConvertitoreFacade.getIstance().converti(md));
		String s[] = ConvertitoreFacade.getIstance().ritorna(md);
		mDao.inserisciChiavi(ConvertitoreFacade.getIstance().converti(md), s[0], s[1]);
	    return b;
		
	}
	
	
	public boolean rimuovi(Messaggio m) {
		mDao = Utility.convertiTipoMessaggio(m.getTipo());
		return mDao.rimuoviMessaggio(ConvertitoreFacade.getIstance().converti(m));
	}
	
	public Messaggio cerca(Messaggio m){
		mDao = Utility.convertiTipoMessaggio(m.getTipo());
		MessaggioDB mdb = mDao.cercaMessaggio(ConvertitoreFacade.getIstance().converti(m));
		return ConvertitoreFacade.getIstance().convertiInverso(mdb, m.getTipo());
		
	}
	
	public String ottieniTestoMessaggio(String m, TipoMessaggio t) {
		 mDao = Utility.convertiTipoMessaggio(t);
		return mDao.ottieniTestoMessaggio(m);
	}
	
	
	public ArrayList<Messaggio> selezionaMessaggi(String s, TipoMessaggio t){
		mDao = Utility.convertiTipoMessaggio(t);
		return ConvertitoreFacade.getIstance().convertiListaMessaggi(t, mDao.selezionaMessaggi(s));
	}
 	
	
	public ArrayList<String> ottieniTestoListaMessaggi(String m, TipoMessaggio t){
		mDao = Utility.convertiTipoMessaggio(t);
		return  mDao.ottieniTestoListaMessaggi(m);
	}
	
	
	//Post
	
     public boolean carica(Post p) {
    	pstDao = Utility.convertiTipoPost(p.getTipo());
    	boolean b = pstDao.caricaPost(ConvertitoreFacade.getIstance().converti(p));
    	String [] s = ConvertitoreFacade.getIstance().ritornaChiaviString(p);
    	int  i = ConvertitoreFacade.getIstance().ritornaChiaviInt(p);
    	boolean a = ConvertitoreFacade.getIstance().ritornaChiaviBoolean(p);
    	pstDao.inserisciChiavi(ConvertitoreFacade.getIstance().converti(p), s, i, a);

    	return b;
    		
    }
    
     public boolean rimuovi(Post p) {
    	 pstDao = Utility.convertiTipoPost(p.getTipo());
    	 return pstDao.eliminaPost(ConvertitoreFacade.getIstance().converti(p));
     }
     
     
     public Post cerca(Post p){
     	pstDao = Utility.convertiTipoPost(p.getTipo());
     	PostDB pdb = pstDao.cercaPost(ConvertitoreFacade.getIstance().converti(p));
     	return ConvertitoreFacade.getIstance().convertiInverso(pdb, p.getTipo());
     	

     }
     
     public ArrayList<Post> selectAllPost(TipoPost t){
     	pstDao = Utility.convertiTipoPost(t);
     	return ConvertitoreFacade.getIstance().convertiListaPost(t, pstDao.selectAll());

     }
     
	
	//Profilo
	
	public ArrayList<Profilo> selectAllProfilo() {
		return ConvertitoreFacade.getIstance().convertiListaProfilo(pDao.selectAll());
	}

	public boolean carica(Profilo p) {
		return pDao.inserisciProfilo(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public boolean inserisciChiaviProfilo(Profilo p, String s1, String s2, String s3) {
		return pDao.inserisciChiavi(ConvertitoreFacade.getIstance().converti(p), s1, s2, s3);
	}
	
	public boolean rimuovi(Profilo p) {
		return pDao.rimuoviProfilo(ConvertitoreFacade.getIstance().converti(p));
	}
	

	public Profilo cerca(Profilo p) {
		ProfiloDB pdb = pDao.cercaProfilo(ConvertitoreFacade.getIstance().converti(p));
		System.out.println("profilo yees: "+ ConvertitoreFacade.getIstance().convertiInverso(pdb).getNickname());
		return ConvertitoreFacade.getIstance().convertiInverso(pdb);
	}
	
	public boolean vediEsiste(String idProfilo) throws AccountDoesNotExist {
		return pDao.vediSeEsiste(idProfilo);
	}
	
	public boolean modificaEsiste(String p, Boolean b) {
		return pDao.modificaEsiste(p, b);
	}
	
	public boolean vediPswCambiata(String idProfilo) throws AccountDoesNotExist {
		return pDao.vediSePswCambiata(idProfilo);
	}
	
	public boolean modificaPswCambiata(String p, Boolean b) {
		return pDao.modificaPswCambiata(p, b);
	}
	
	public boolean vediSeLoggato(String idProfilo) throws AccountDoesNotExist {
		return pDao.vediSeIsLoggato(idProfilo);
	}
	
	public boolean modificaLoggato(String p, Boolean b) {
		return pDao.modificaIsLoggato(p, b);
	}
	
	public String vediPsw(String idProfilo) throws AccountDoesNotExist {
		return pDao.ottieniPsw(idProfilo);
	}
	public String vediTipo(String idProfilo) throws AccountDoesNotExist{
		return pDao.ottieniTipo(idProfilo);
	}
	public boolean modificaPsw(String p, String b) throws AccountDoesNotExist {
		return pDao.modificaPsw(p, b);
	}

	//Follow
	
	public boolean carica(Follow f) {
		return flDao.carica(ConvertitoreFacade.getIstance().converti(f));
	}
	public boolean rimuovi(Follow f) {
		return flDao.rimuovi(ConvertitoreFacade.getIstance().converti(f));
	}
	
	public ArrayList<Follow> selectAllFollow(){
		return ConvertitoreFacade.getIstance().convertiListaFollow(flDao.selectAll());
	}
	
	public Follow cerca(Follow f) {
		FollowDB fdao = flDao.cerca(ConvertitoreFacade.getIstance().converti(f));
		return ConvertitoreFacade.getIstance().convertiInverso(fdao);
	}
	
	public ArrayList<String> cercaProfSeguito(String s){
		return flDao.cercaProfSeguito(s);
	}
	
	
	
	//Alcuni metodi utility
	
	
	//Ritorna true se l'account inserito � "seguibile"
	public boolean profiloNonSeguito(Follow f) {
		Follow search = this.cerca(f);
		if (search == null) {
			return true;
		}
		return false;
	}

	//Ritorna true se l'account � esistente
	public boolean accountEsistente(Profilo p) throws AccountDoesNotExist {
		Profilo search = this.cerca(p);
		if(search == null) {
			throw new AccountDoesNotExist(p.getIdProfilo());
		}
		return true;
}
	
}


