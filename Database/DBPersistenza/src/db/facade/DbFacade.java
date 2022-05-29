package db.facade;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.chatDiGruppo.gruppo.Gruppo;
import profilo.Profilo;
import profilo.exception.AccountDoesNotExist;
import profilo.follow.Follow;
import db.LikeDislike.LikeMap.LikeMapDao;
import db.LikeDislike.dislikeMap.DislikeMapDao;
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
import db.post.sondaggio.sondaggiodoppiavotazione.SondaggioDoppiaVotazioneDao;
import db.post.sondaggio.sondaggiosceltamultipla.SondaggioSceltaMultiplaDao;
import db.profilo.ProfiloDB;
import db.profilo.ProfiloDao;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.sondaggio.Sondaggio;
import convertitore.ConvertitoreFacade;

public class DbFacade {
	
	private static DbFacade istance;
	
	
	private MessaggioDao mDao;
	private PostDao pstDao;
	private CommentoDao cDao;
	private GruppoDao gDao;
	private ProfiloDao pDao;
	private FollowDao flDao;
	private LikeMapDao lDao;
	private DislikeMapDao dDao;
	private SondaggioDoppiaVotazioneDao sdv;
	private SondaggioSceltaMultiplaDao ssm;
	
	
	private DbFacade() {
		mDao = null;
		pstDao = null;
		cDao = new CommentoDao();
		gDao = new GruppoDao();
		pDao = new ProfiloDao();
		flDao = new FollowDao();
		lDao = new LikeMapDao();
		dDao = new DislikeMapDao();
		sdv = new SondaggioDoppiaVotazioneDao();
		ssm = new SondaggioSceltaMultiplaDao();
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
		if(cdb != null)
			return ConvertitoreFacade.getIstance().convertiInverso(cdb);
		return null;
	}
	

	public ArrayList<String> ProfiloNickCommento(Profilo p){
		return cDao.ProfiloNickCommento(ConvertitoreFacade.getIstance().converti(p));
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
		if(gdb != null)
		   return ConvertitoreFacade.getIstance().convertiInverso(gdb);
		return null;
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
		if(mdb != null) 
			return ConvertitoreFacade.getIstance().convertiInverso(mdb, m.getTipo());
		return null;
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
	
	public ArrayList<Messaggio> selezionaMessaggiProfilo(Profilo p, TipoMessaggio t){
		mDao = Utility.convertiTipoMessaggio(t);
		return ConvertitoreFacade.getIstance().convertiListaMessaggi(t, mDao.selezionaMessaggiProfilo(ConvertitoreFacade.getIstance().converti(p)));
	}
	
	public ArrayList<String> selezionaTestoMessaggiProfilo(Profilo p, TipoMessaggio t){
		mDao = Utility.convertiTipoMessaggio(t);
		return mDao.selezionaTestoMessaggiProfilo(ConvertitoreFacade.getIstance().converti(p));
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

     	if(pdb != null)
     		return ConvertitoreFacade.getIstance().convertiInverso(pdb, p.getTipo());
     	return null;

     }
     
     public ArrayList<Post> selectAllPost(TipoPost t){
     	pstDao = Utility.convertiTipoPost(t);
     	return ConvertitoreFacade.getIstance().convertiListaPost(t, pstDao.selectAll());

     }
     
     public String ottieniPercorso(Post m) {
    	 pstDao = Utility.convertiTipoPost(m.getTipo());
    	 return pstDao.ottieniPercorso(ConvertitoreFacade.getIstance().converti(m));
     }
     
    //Ottiene gli id e il percorso dei post di un profilo 
	public ArrayList<String> ottieniIdPost(TipoPost p, Profilo pr){
		pstDao = Utility.convertiTipoPost(p);
		return pstDao.ritornaPostDiUnProfilo(pr.getIdProfilo());
	}
     
    public ArrayList<Commento> mostraCommentiPost(Post p){ 
    	pstDao = Utility.convertiTipoPost(p.getTipo());
		return ConvertitoreFacade.getIstance().convertiListaCommenti(pstDao.mostraCommentiSottoPost(ConvertitoreFacade.getIstance().converti(p)));

    }
	
    public ArrayList<String> mostraTestoCommentiPost(Post p){
    	pstDao = Utility.convertiTipoPost(p.getTipo());
        return pstDao.mostraTestoCommentiPost(ConvertitoreFacade.getIstance().converti(p));
    }
    
    public boolean vediVisibilita(Post p) {
    	pstDao = Utility.convertiTipoPost(p.getTipo());
    	return pstDao.vediVisibilita(ConvertitoreFacade.getIstance().converti(p));
    }
    
    public boolean modificaVisibilita(Post p, boolean b) {
    	pstDao = Utility.convertiTipoPost(p.getTipo());
    	return pstDao.modificaVisibile(ConvertitoreFacade.getIstance().converti(p), b);
    }
    
    public int vediNumLike(Post p) {
    	pstDao = Utility.convertiTipoPost(p.getTipo());
        return pstDao.vediNumLike(ConvertitoreFacade.getIstance().converti(p));
    }
    public boolean modificaNumLike(Post p, int n) {
    	pstDao = Utility.convertiTipoPost(p.getTipo());
        return pstDao.modificaNumLike(ConvertitoreFacade.getIstance().converti(p), n);
    }
    
    public int vediNumDislike(Post p) {
    	pstDao = Utility.convertiTipoPost(p.getTipo());
        return pstDao.vediNumDislike(ConvertitoreFacade.getIstance().converti(p));
    }
    public boolean modificaNumDislike(Post p, int n) {
    	pstDao = Utility.convertiTipoPost(p.getTipo());
        return pstDao.modificaNumDislike(ConvertitoreFacade.getIstance().converti(p), n);
    }
    
    //Solo sondaggi
    
    public int vediCount1SDV(Post p) {
         return sdv.vediCount1s(ConvertitoreFacade.getIstance().converti(p));
    }
    public int vediCount2SDV(Post p) {
        return sdv.vediCount2s(ConvertitoreFacade.getIstance().converti(p));
   }
    
    public boolean modificaCount1SDV(Post p, int n) {
    	return sdv.modificaCount1s(ConvertitoreFacade.getIstance().converti(p), n);
    }
    public boolean modificaCount2SDV(Post p, int n) {
    	return sdv.modificaCount2s(ConvertitoreFacade.getIstance().converti(p), n);
    }
    
    
    
    
    
    
    public int vediCount1SSM(Post p) {
        return ssm.vediCount1s(ConvertitoreFacade.getIstance().converti(p));
   } 
    public int vediCount2SSM(Post p) {
       return ssm.vediCount2s(ConvertitoreFacade.getIstance().converti(p));
  } 
    public int vediCount3SSM(Post p) {
      return ssm.vediCount3s(ConvertitoreFacade.getIstance().converti(p));
 } 
    public int vediCount4SSM(Post p) {
     return ssm.vediCount4s(ConvertitoreFacade.getIstance().converti(p));
}
    
   
    public boolean modificaCount1SSM(Post p, int n) {
    	return ssm.modificaCount1s(ConvertitoreFacade.getIstance().converti(p), n);
    }
    public boolean modificaCount2SSM(Post p, int n) {
    	return ssm.modificaCount2s(ConvertitoreFacade.getIstance().converti(p), n);
    }
    public boolean modificaCount3SSM(Post p, int n) {
    	return ssm.modificaCount3s(ConvertitoreFacade.getIstance().converti(p), n);
    }
    public boolean modificaCount4SSM(Post p, int n) {
    	return ssm.modificaCount4s(ConvertitoreFacade.getIstance().converti(p), n);
    }
    
    
	//Profilo
	
	public ArrayList<Profilo> selectAllProfilo() {
		return ConvertitoreFacade.getIstance().convertiListaProfilo(pDao.selectAll());
	}

	public boolean carica(Profilo p) {
    	System.out.println(p.getIdProfilo() + 1);

		return pDao.inserisciProfilo(ConvertitoreFacade.getIstance().converti(p));
	}
	

	
	public boolean rimuovi(Profilo p) {
		return pDao.rimuoviProfilo(ConvertitoreFacade.getIstance().converti(p));
	}
	

	public Profilo cerca(Profilo p) {
		ProfiloDB pdb = pDao.cercaProfilo(ConvertitoreFacade.getIstance().converti(p));
		if(pdb != null)
			return ConvertitoreFacade.getIstance().convertiInverso(pdb);
		return null;
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

	public boolean modificaPsw(String p, String b) throws AccountDoesNotExist {
		return pDao.modificaPsw(p, b);
	}
	
	public boolean modificaImmagineProfilo(Profilo p, String immagine) {
		return pDao.cambiaImmagineProfilo(ConvertitoreFacade.getIstance().converti(p), immagine);
	}

	public String ottieniImmagineProfilo(Profilo p) {
		return pDao.ottieniImmagine(ConvertitoreFacade.getIstance().converti(p));
	}

	public int vediNumSeguiti(Profilo p) {
		return pDao.vediSeguiti(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public boolean modificaNumSeguiti(Profilo p, int n) {
		return pDao.modificaSeguiti(ConvertitoreFacade.getIstance().converti(p), n);
	}
	
	public int vediNumFollower(Profilo p) {
		return pDao.vediFollower(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public boolean modificaNumFollower(Profilo p, int n) {
		return pDao.modificaFollower(ConvertitoreFacade.getIstance().converti(p), n);
	}
	
	public int vediNumPost(Profilo p) {
		return pDao.vediNumPost(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public boolean modificaNumPost(Profilo p, int n) {
		return pDao.modificaNumPost(ConvertitoreFacade.getIstance().converti(p),n);
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
		if(fdao != null)
			return ConvertitoreFacade.getIstance().convertiInverso(fdao);
		return null;
	}
	
	public ArrayList<String> cercaProfSeguito(String s){
		return flDao.cercaProfSeguito(s);
	}
	
	//Like e Dislike
	
	public boolean caricaLikeMap(String profilo, String post) {
	
		return lDao.carica(profilo, post);
	}
	
	public boolean rimuoviLike(String profilo,String post) {
		return lDao.rimuovi(profilo, post);
	}
	
	public ArrayList<String> cercaLikeMap(String s1, String s2){
		return lDao.cerca(s1, s2);
	}
	
	public boolean caricaDislikeMap(String profilo, String post) {
		return dDao.carica(profilo, post);
	}
	public boolean rimuoviDislike(String profilo,String post) {
		return dDao.rimuovi(profilo, post);
	}
	
	public ArrayList<String> cercaDislikeMap(String s1, String s2){
		return dDao.cerca(s1, s2);
	}
	
	//Alcuni metodi utility
	
	public boolean presenteLikeMap(String s1,String s2) {
		ArrayList<String> res = this.cercaLikeMap(s1, s2);
		if(res.isEmpty() == true)
			return false;
		return true;
	}
	
	public boolean presenteDislikeMap(String s1,String s2) {
		ArrayList<String> res = this.cercaDislikeMap(s1, s2);
		if(res.isEmpty() == true)
			return false;
		return true;
	}
	
	
	//Ritorna true se l'account inserito e' "seguibile"
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


