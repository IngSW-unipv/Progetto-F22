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
import db.notifica.NotificaDao;
import db.post.PostDB;
import db.post.PostDao;
import db.post.multimedia.foto.FotoDao;
import db.post.multimedia.video.VideoDB;
import db.post.multimedia.video.VideoDao;
import db.post.sondaggio.sondaggiodoppiavotazione.SondaggioDoppiaVotazioneDB;
import db.post.sondaggio.sondaggiodoppiavotazione.SondaggioDoppiaVotazioneDao;
import db.post.sondaggio.sondaggiosceltamultipla.SondaggioSceltaMultiplaDB;
import db.post.sondaggio.sondaggiosceltamultipla.SondaggioSceltaMultiplaDao;
import db.post.testo.TestoDao;
import db.profilo.ProfiloDB;
import db.profilo.ProfiloDao;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
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

	public void stampaCommentiSottoPost(Commento c) {
		ArrayList<CommentoDB> res = cDao.mostraCommentiSottoPost(ConvertitoreFacade.getIstance().converti(c));
		for(CommentoDB cdb : res)
			System.out.println(cdb.toString());
	}
	
	public void stampaCommentoCercato(String c) {
		ArrayList<CommentoDB> res = cDao.cercaCommento(c);
		for(CommentoDB cdb : res)
			System.out.println(cdb.toString());
	}
	public ArrayList<CommentoDB> CommentiSottoPost(Commento c){
		return cDao.mostraCommentiSottoPost(ConvertitoreFacade.getIstance().converti(c));
	}
	public ArrayList<CommentoDB> cercaCommento(Commento c){
		return cDao.cercaCommento(c.getIdCommento());
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

	public ArrayList<GruppoDB> cercaGruppo(String g) {
		return gDao.cercaGruppo(g);
	}
	
	public ArrayList<GruppoDB> selectAllGruppo() {
		return gDao.selectall();
	}
	
	public void stampaGruppoCercato(String g) {
		ArrayList<GruppoDB> res = gDao.cercaGruppo(g);
		for(GruppoDB gdb : res)
			System.out.println(gdb.toString());
	}
	
	public void stampaSelectAllGruppo() {
		ArrayList<GruppoDB> res = gDao.selectall();
		for(GruppoDB gdb : res)
			System.out.println(gdb.toString());
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
	
	public Messaggio cercaMessaggio(Messaggio m){
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
		return ConvertitoreFacade.getIstance().convertiLista(t, mDao.selezionaMessaggi(s));
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
     
     
     public Post cercaPost(Post p){
     	pstDao = Utility.convertiTipoPost(p.getTipo());
     	PostDB pdb = pstDao.cercaPost(ConvertitoreFacade.getIstance().converti(p));
     	return ConvertitoreFacade.getIstance().convertiInverso(pdb, p.getTipo());
     	

     }
     
     public ArrayList<Post> selectAllPost(TipoPost t){
     	pstDao = Utility.convertiTipoPost(t);
     	return ConvertitoreFacade.getIstance().convertiLista(t, pstDao.selectAll());

     }
     
	
	//Profilo
	
	public ArrayList<Profilo> selectAllProfilo() {
		return ConvertitoreFacade.getIstance().convertiLista(pDao.selectAll());
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
	

	public Profilo cercaProfilo(Profilo p) {
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
	
	public ArrayList<FollowDB> selectAllFollow(){
		return flDao.selectAll();
	}
	
	public void stampaSelectAllFollow(){
		ArrayList<FollowDB> res = flDao.selectAll();
		for(FollowDB fdb : res)
			System.out.println(fdb.toString());
	}
	
	public ArrayList<String> cercaProfSeguito(String s){
		return flDao.cercaProfSeguito(s);
	}
	
	public void stampaProfSeguitoCercato(String profiloPersonale){
		ArrayList<String> res = flDao.cercaProfSeguito(profiloPersonale);
		for(String pdb : res)
			System.out.println(pdb.toString());
	}
	public ArrayList<FollowDB> cercaFollow(String profiloPersonale, String profiloSeguito){
		return flDao.cerca(profiloPersonale, profiloSeguito);
	}
	
	public void stampaFollowCercati(String profiloPersonale, String profiloSeguito) {
		ArrayList<FollowDB> res = flDao.cerca(profiloPersonale, profiloSeguito);
		for(FollowDB fdb : res)
			System.out.println(fdb.toString());
	}
	
	
	
	
	
	//Alcuni metodi utility
	
	
	//Ritorna true se l'account inserito � "seguibile"
	public boolean profiloNonSeguito(Follow f) {
		ArrayList<FollowDB> search = this.cercaFollow(f.getMailProfiloPersonale(), f.getMailProfiloSeguito());
		if (search.isEmpty() == true) {
			return true;
		}
		return false;
	}

	//Ritorna true se l'account � esistente
	public boolean accountEsistente(Profilo p) throws AccountDoesNotExist {
		ArrayList<ProfiloDB> res = this.cercaProfilo(p.getIdProfilo());
		if(res.isEmpty() == true) {
			throw new AccountDoesNotExist(p.getIdProfilo());
		}
		return true;
	}

	//Ritorna true se l'account � loggato
	public boolean seiLoggato(String emailProfilo) throws AccountDoesNotExist, NotLoggedIn {
		Profilo p = new Profilo(emailProfilo, null);
		if(this.accountEsistente(p) == true) {
			if(this.vediSeLoggato(emailProfilo) == true) {
				return true;
			}
			throw new NotLoggedIn(emailProfilo);
		}
		return false;
	}
	
}


