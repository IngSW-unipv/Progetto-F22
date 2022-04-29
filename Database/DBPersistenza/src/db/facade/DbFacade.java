package db.facade;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import Messaggio.enumeration.TipoMessaggio;
import chat.chatDiGruppo.gruppo.Gruppo;
import profilo.Profilo;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.NotLoggedIn;
import profilo.follow.Follow;
import db.commento.CommentoDB;
import db.commento.CommentoDao;
import db.follow.FollowDB;
import db.follow.FollowDao;
import db.foto.FotoDB;
import db.foto.FotoDao;
import db.gruppo.GruppoDB;
import db.gruppo.GruppoDao;
import db.messaggio.MessaggioDB;
import db.messaggio.MessaggioDao;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDao;
import db.messaggio.messaggioPrivato.MessaggioPrivatoDB;
import db.messaggio.messaggioPrivato.MessaggioPrivatoDao;
import db.notifica.NotificaDao;
import db.profilo.ProfiloDB;
import db.profilo.ProfiloDao;
import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDB;
import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDao;
import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDB;
import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDao;
import db.testo.TestoDB;
import db.testo.TestoDao;
import db.video.VideoDB;
import db.video.VideoDao;
import messaggio.IMessaggio;
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
	
	private CommentoDao cDao;
	private FotoDao fDao;
	private GruppoDao gDao;
	
	private MessaggioDao mdao;
	
	private MessaggioDiGruppoDao mdgDao;
	private MessaggioPrivatoDao mpDao;
	private NotificaDao nDao;
	private ProfiloDao pDao;
	private SondaggioDoppiaVotazioneDao sdvDao;
	private SondaggioSceltaMultiplaDao ssmDao;
	private TestoDao tDao;
	private VideoDao vDao;
	private FollowDao flDao;
	
	private DbFacade() {
		cDao = new CommentoDao();
		fDao = new FotoDao();
		gDao = new GruppoDao();
		mdgDao = new MessaggioDiGruppoDao();
		mpDao = new MessaggioPrivatoDao();
		nDao = new NotificaDao();
		pDao = new ProfiloDao();
		sdvDao = new SondaggioDoppiaVotazioneDao();
		ssmDao = new SondaggioSceltaMultiplaDao();
		tDao = new TestoDao();
		vDao = new VideoDao();
		flDao = new FollowDao();
		mdao = new MessaggioDao();
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
	
	public boolean carica(MessaggioDB md) {
		return mdao.scriviMessaggio(md);
	}
	
	public boolean rimuovi(Messaggio m) {
		if(m.getTipo() == TipoMessaggio.PRIVATO) {
			 mpDao.rimuoviMessaggioPrivato((MessaggioPrivatoDB) ConvertitoreFacade.getIstance().conversione(m));
			return true;
			}
			else if(m.getTipo() == TipoMessaggio.DIGRUPPO) {
				mdgDao.rimuoviMessaggioDiGruppo((MessaggioDiGruppoDB) ConvertitoreFacade.getIstance().conversione(m));
			return true;
			}
			return false;
	}
	
	
	public ArrayList<MessaggioDiGruppoDB> cercaMessaggioDiGruppo(String m) {
		return mdgDao.cercaMessaggioDiGruppo(m);
	} 
	
	public ArrayList<MessaggioPrivatoDB> cercaMessaggioPrivato(String m) {
		return mpDao.cercaMessaggioPrivato(m);
	}

    public void stampaMessaggioCercato(String s, TipoMessaggio t) {
    	if(t == TipoMessaggio.PRIVATO) {
    		ArrayList<MessaggioPrivatoDB> res = mpDao.cercaMessaggioPrivato(s);
    		for(MessaggioPrivatoDB pdb : res)
    			System.out.println(pdb.toString());
    	}
    	else if(t == TipoMessaggio.DIGRUPPO) {
    		ArrayList<MessaggioDiGruppoDB> res = mdgDao.cercaMessaggioDiGruppo(s);
    		for(MessaggioDiGruppoDB mdb : res)
    			System.out.println(mdb.toString());
    	}
    }
	
    public void stampaListaMessaggi(Messaggio m) {
    	if(m.getTipo() == TipoMessaggio.PRIVATO) {
    		ArrayList<MessaggioPrivatoDB> res = mpDao.selectAllNomeProfilo((MessaggioPrivatoDB) ConvertitoreFacade.getIstance().conversione(m));
    		for(MessaggioPrivatoDB pdb : res)
    			System.out.println(pdb.toString());
    	}
    	else if(m.getTipo() == TipoMessaggio.DIGRUPPO) {
    		ArrayList<MessaggioDiGruppoDB> res = mdgDao.selectAllIdGruppo((MessaggioDiGruppoDB) ConvertitoreFacade.getIstance().conversione(m));
    		for(MessaggioDiGruppoDB mdb : res)
    			System.out.println(mdb.toString());
    	}
    }
   
    public String ottieniMessaggio(Messaggio m) {
    	if(m.getTipo() == TipoMessaggio.PRIVATO)
    		return mpDao.ottieniMessaggio(m.getIdMessaggio());
    	if(m.getTipo() == TipoMessaggio.DIGRUPPO)
    		return mdgDao.ottieniTesto(m.getIdMessaggio());
    	else 
    		return null;
    }
    

	
	//Post
	
    public boolean carica(Post p) {
    	if(p.getTipo() == TipoPost.FOTO) {
    		fDao.pubblicaFoto(ConvertitoreFacade.getIstance().converti(p))
    	}
    		
    }
    
	public ArrayList<SondaggioDoppiaVotazioneDB> selectAllSDV() {
		return sdvDao.selectAll();
	}

	public void stampaSelectAllSDV() {
		ArrayList<SondaggioDoppiaVotazioneDB> res = sdvDao.selectAll();
		for(SondaggioDoppiaVotazioneDB sdb : res)
			System.out.println(sdb.toString());
	}

	public boolean carica(SondaggioDoppiaVotazione p) {
		 return sdvDao.pubblicaSondaggio(ConvertitoreFacade.getIstance().converti(p));
		
	}

	public ArrayList<SondaggioDoppiaVotazioneDB> cercaSDV(String s){
		return sdvDao.cercaSondaggio(s);
	}
	
	public void stampaSDVcercato(String s) {
		ArrayList<SondaggioDoppiaVotazioneDB> res = sdvDao.cercaSondaggio(s);
		for(SondaggioDoppiaVotazioneDB sdb : res)
			System.out.println(sdb.toString());
	}

	public boolean rimuovi(SondaggioDoppiaVotazione p) {
		return sdvDao.rimuoviSondaggio(ConvertitoreFacade.getIstance().converti(p));
	}
	
	
	
	public ArrayList<SondaggioSceltaMultiplaDB> selectAllSSM() {
		return ssmDao.selectAll();
	}

	public void stampaSelectAllSSM() {
		ArrayList<SondaggioSceltaMultiplaDB> res = ssmDao.selectAll();
		for(SondaggioSceltaMultiplaDB sdb : res)
			System.out.println(sdb.toString());
	}
	
	public boolean carica(SondaggioSceltaMultipla p) {
	    return ssmDao.pubblicaSondaggio(ConvertitoreFacade.getIstance().converti(p));
	}

	public boolean rimuovi(SondaggioSceltaMultipla p) {
		return ssmDao.rimuoviSondaggio(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public ArrayList<SondaggioSceltaMultiplaDB> cercaSSM(String s){
		return ssmDao.cerca(s);
	}
	
	public void stampaSSMcercato(String s) {
		ArrayList<SondaggioSceltaMultiplaDB> res = ssmDao.cerca(s);
		for(SondaggioSceltaMultiplaDB sdb : res)
			System.out.println(sdb.toString());
	}
	
	public ArrayList<TestoDB> selectAllTesto() {
		return tDao.selectAll();
	}
	
	public void stampaSelectAllTesto() {
		ArrayList<TestoDB> res = tDao.selectAll();
		for(TestoDB tdb: res)
			System.out.println(tdb.toString());
	}
	
	public ArrayList<TestoDB> cercaTesto(String s){
		return tDao.cercaTesto(s);
	}
	
	public void stampaTestoCercato(String s) {
		ArrayList<TestoDB> res = tDao.cercaTesto(s);
		for(TestoDB tdb: res)
			System.out.println(tdb.toString());
	}
	
	public boolean carica(Testo p) {
		return tDao.pubblicaTesto(ConvertitoreFacade.getIstance().converti(p));
	    
	}
	public boolean rimuovi(Testo p) {
		return tDao.rimuoviTesto(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public ArrayList<VideoDB> selectAllVideo() {
		return vDao.selectAll();
	}
	
	public void stampaSelectAllVideo() {
		ArrayList<VideoDB> res = vDao.selectAll();
		for(VideoDB vdb : res)
			System.out.println(vdb.toString());
	}
	
	public ArrayList<VideoDB> cercaVideo(String s){
		return vDao.cercaVideo(s);
	}
	
	public void stampaVideoCercato(String s) {
		ArrayList<VideoDB> res = vDao.cercaVideo(s);
		for(VideoDB vdb : res)
			System.out.println(vdb.toString());
	}
	
	public boolean carica(Foto f) {
		return fDao.pubblicaFoto(ConvertitoreFacade.getIstance().converti(f));
	}
	
	public boolean rimuovi(Foto f) {
		return fDao.rimuoviFoto(ConvertitoreFacade.getIstance().converti(f));
	}

	public ArrayList<FotoDB> selectAllFoto() {
		return fDao.selectAll();
	}
	public void stampaSelectAllFoto() {
		ArrayList<FotoDB> res = fDao.selectAll();
		for(FotoDB fdb : res)
			System.out.println(fdb.toString());
	}
	public ArrayList<FotoDB> cercaFoto(String f){
		return fDao.cercaFoto(f);
	}
	public void stampaFotoCercate(String f) {
		ArrayList<FotoDB> res = fDao.cercaFoto(f);
		for(FotoDB fdb : res)
			System.out.println(fdb.toString());
	}
	
	public boolean carica(Video p) {
		return vDao.pubblicaVideo(ConvertitoreFacade.getIstance().converti(p));
	}

	public boolean rimuovi(Video p) {
		return vDao.rimuoviVideo(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public ArrayList<ProfiloDB> selectAllProfilo() {
		return pDao.selectAll();
	}
	
	public void stampaSelectAllProfilo() {
		ArrayList<ProfiloDB> res = pDao.selectAll();
		for(ProfiloDB pdb : res)
			System.out.println(pdb.toString());
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
	
	public ArrayList<ProfiloDB> cercaProfilo(String p) {
		return pDao.cercaProfilo(p);
	}
	public void stampaProfiloCercato(String p) {
		ArrayList<ProfiloDB> res = pDao.cercaProfilo(p);
		for(ProfiloDB pdb : res)
			System.out.println(pdb.toString());
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