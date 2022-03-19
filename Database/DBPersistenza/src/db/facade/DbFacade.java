package db.facade;

import java.util.ArrayList;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.gruppo.Gruppo;
import profilo.Profilo;
import profilo.exception.AccountDoesNotExist;
import db.commento.CommentoDB;
import db.commento.CommentoDao;
import db.foto.FotoDB;
import db.foto.FotoDao;
import db.gruppo.GruppoDB;
import db.gruppo.GruppoDao;
import db.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggioDiGruppo.MessaggioDiGruppoDao;
import db.messaggioPrivato.MessaggioPrivatoDB;
import db.messaggioPrivato.MessaggioPrivatoDao;
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
import post.commento.Commento;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import convertitore.ConvertitoreFacade;
import convertitore.messaggioUtility.MessaggioUtility;

public class DbFacade {
	
	private static DbFacade istance;
	
	private CommentoDao cDao;
	private FotoDao fDao;
	private GruppoDao gDao;
	private MessaggioDiGruppoDao mdgDao;
	private MessaggioPrivatoDao mpDao;
	private NotificaDao nDao;
	private ProfiloDao pDao;
	private SondaggioDoppiaVotazioneDao sdvDao;
	private SondaggioSceltaMultiplaDao ssmDao;
	private TestoDao tDao;
	private VideoDao vDao;
	
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
	}
	
	public static DbFacade getIstance() {
		if(istance == null) {
			istance = new DbFacade();
		}
		return istance;
	}
	
	public boolean carica(Commento c) {
	    return cDao.scriviCommento(ConvertitoreFacade.getIstance().converti(c));
		
	}
	
	public boolean rimuovi(Commento c) {
		return cDao.rimuoviCommento(ConvertitoreFacade.getIstance().converti(c));
	
	}

	public ArrayList<CommentoDB> mostraCommentiSottoPost(Commento c) {
		return cDao.mostraCommentiSottoPost(ConvertitoreFacade.getIstance().converti(c));
	}
	
	public ArrayList<FotoDB> selectAllFoto() {
		return fDao.selectAll();
	}

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
	
	public ArrayList<GruppoDB> selectAlll() {
		return gDao.selectall();
	}
	
	public ArrayList<MessaggioDiGruppoDB> cercaMessaggio(String m) {
		return mdgDao.cercaMessaggioDiGruppo(m);
	} 

	
	public void ottieniMessaggio(MessaggioDiGruppo m) {
		mdgDao.ottieniTesto(ConvertitoreFacade.getIstance().converti(m));
	}


	public boolean carica(MessaggioDiGruppo m) {
		return  mdgDao.scriviMessaggioDiGruppo(ConvertitoreFacade.getIstance().converti(m));
		
	}

	public boolean rimuovi(MessaggioDiGruppo m) {
		return mdgDao.rimuoviMessaggioDiGruppo(ConvertitoreFacade.getIstance().converti(m));
		
	}

	public ArrayList<MessaggioDiGruppoDB> listaMessaggiDiUnGruppo(MessaggioDiGruppo m) {
		return mdgDao.selectAllIdGruppo(ConvertitoreFacade.getIstance().converti(m));
	}

	public ArrayList<MessaggioDiGruppoDB> ottieniListaTuttiMessaggiDiGruppo() {
		return mdgDao.selectAll();
	}
	
	public ArrayList<MessaggioPrivatoDB> selectAllNomeProfilo(MessaggioPrivato m) {
		return mpDao.selectAllNomeProfilo(ConvertitoreFacade.getIstance().converti(m));
	}
	
	public ArrayList <MessaggioPrivatoDB> ottieniListaTuttiMessaggiPrivati() {
		return mpDao.selectAll();
	}
	
	public ArrayList<MessaggioPrivatoDB> cercaMessaggioPrivato(String m) {
		return mpDao.cercaMessaggioPrivato(m);
	}

	public void ottieniMessaggio(MessaggioPrivato m) {
		mpDao.ottieniMessaggio(ConvertitoreFacade.getIstance().converti(m));
	}

	public boolean carica(MessaggioPrivato m) {		
		return mpDao.scriviMessaggioPrivato(ConvertitoreFacade.getIstance().converti(m));
	}

	public boolean rimuovi(MessaggioPrivato m) {
		return mpDao.rimuoviMessaggioPrivato(ConvertitoreFacade.getIstance().converti(m));
	}
	
	public ArrayList<SondaggioDoppiaVotazioneDB> selectAllSDV() {
		return sdvDao.selectAll();
	}


	public boolean carica(SondaggioDoppiaVotazione p) {
		 return sdvDao.pubblicaSondaggio(ConvertitoreFacade.getIstance().converti(p));
		
	}


	public boolean rimuovi(SondaggioDoppiaVotazione p) {
		return sdvDao.rimuoviSondaggio(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public ArrayList<SondaggioSceltaMultiplaDB> selectAllSSM() {
		return ssmDao.selectAll();
	}

	
	public boolean carica(SondaggioSceltaMultipla p) {
	    return ssmDao.pubblicaSondaggio(ConvertitoreFacade.getIstance().converti(p));
	}

	public boolean rimuovi(SondaggioSceltaMultipla p) {
		return ssmDao.rimuoviSondaggio(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public ArrayList<TestoDB> selectAllTesto() {
		return tDao.selectAll();
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

	public boolean carica(Video p) {
		return vDao.pubblicaVideo(ConvertitoreFacade.getIstance().converti(p));
	}

	public boolean rimuovi(Video p) {
		return vDao.rimuoviVideo(ConvertitoreFacade.getIstance().converti(p));
	}
	
	public ArrayList<ProfiloDB> selectAllProfilo() {
		return pDao.selectAll();
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
}