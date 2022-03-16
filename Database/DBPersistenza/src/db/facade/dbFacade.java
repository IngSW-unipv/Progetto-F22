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


public class dbFacade {

	public boolean carica(Commento c) {
		CommentoDao cdao = new CommentoDao();
	    return cdao.scriviCommento(ConvertitoreFacade.converti(c));
		
	}
	
	public boolean rimuovi(Commento c) {
		CommentoDao cdao = new CommentoDao();
		return cdao.rimuoviCommento(ConvertitoreFacade.converti(c));
	
	}

	public ArrayList<CommentoDB> mostraCommentiSottoPost(Commento c) {
		CommentoDao cdao = new CommentoDao();
		return cdao.mostraCommentiSottoPost(ConvertitoreFacade.converti(c));
	}
	
	public ArrayList<FotoDB> selectAllFoto() {
		FotoDao fdao = new FotoDao();
		return fdao.selectAll();
	}

	public boolean carica(Gruppo g) {
		GruppoDao gdao = new GruppoDao();
		return gdao.creaGruppo(ConvertitoreFacade.converti(g));
	
	}
	
	public boolean rimuovi(Gruppo g) {
		GruppoDao gdao = new GruppoDao();

		return gdao.cancellaGruppo(ConvertitoreFacade.converti(g));
		
	}
	
	public boolean gestisciPartecipanti(Gruppo g) {
		GruppoDao gdao = new GruppoDao();
		return gdao.inserisciChiavi(ConvertitoreFacade.converti(g));
		
	}

	public ArrayList<GruppoDB> cercaGruppo(String g) {
		GruppoDao gdao = new GruppoDao();
		return gdao.cercaGruppo(g);
	}
	
	public ArrayList<GruppoDB> selectAlll() {
		GruppoDao gdao = new GruppoDao();
		return gdao.selectall();
	}
	
	public ArrayList<MessaggioDiGruppoDB> cercaMessaggio(String m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.cercaMessaggioDiGruppo(m);
	} 

	
	public void ottieniMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		mdao.ottieniTesto(ConvertitoreFacade.converti(m));
		
	}


	public boolean carica(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return  mdao.scriviMessaggioDiGruppo(ConvertitoreFacade.converti(m));
		
	}

	public boolean rimuovi(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.rimuoviMessaggioDiGruppo(ConvertitoreFacade.converti(m));
		
	}

	public ArrayList<MessaggioDiGruppoDB> listaMessaggiDiUnGruppo(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.selectAllIdGruppo(ConvertitoreFacade.converti(m));
	}

	public ArrayList<MessaggioDiGruppoDB> ottieniListaTuttiMessaggiDiGruppo() {
		MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao();
		return gdao.selectAll();
	}
	
	
	public ArrayList<MessaggioPrivatoDB> selectAllNomeProfilo(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAllNomeProfilo(ConvertitoreFacade.converti(m));
	}
	
	
	public ArrayList <MessaggioPrivatoDB> ottieniListaTuttiMessaggiPrivati() {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAll();
	
	}
	
	
	public ArrayList<MessaggioPrivatoDB> cercaMessaggioPrivato(String m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.cercaMessaggioPrivato(m);
	}

	public void ottieniMessaggio(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		mdao.ottieniMessaggio(MessaggioUtility.convertiAMessPrivDB(m));
	}


	public boolean carica(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		
		return mdao.scriviMessaggioPrivato(MessaggioUtility.convertiAMessPrivDB(m));

	}

	
	public boolean rimuovi(MessaggioPrivato m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();

		return mdao.rimuoviMessaggioPrivato(MessaggioUtility.convertiAMessPrivDB(m));

	}
	
	public ArrayList<SondaggioDoppiaVotazioneDB> selectAllSDV() {
		SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
		return sdao.selectAll();
	}


	public boolean carica(SondaggioDoppiaVotazione p) {
		SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
		 return sdao.pubblicaSondaggio(ConvertitoreFacade.converti(p));
		
	}


	public boolean rimuovi(SondaggioDoppiaVotazione p) {
		SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
		return sdao.rimuoviSondaggio(ConvertitoreFacade.converti(p));
	}
	
	public ArrayList<SondaggioSceltaMultiplaDB> selectAllSSM() {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		return sdao.selectAll();
	}

	
	public boolean carica(SondaggioSceltaMultipla p) {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
	    return sdao.pubblicaSondaggio(ConvertitoreFacade.converti(p));
	}

	public boolean rimuovi(SondaggioSceltaMultipla p) {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		return sdao.rimuoviSondaggio(ConvertitoreFacade.converti(p));
	}
	
	public ArrayList<TestoDB> selectAllTesto() {
		TestoDao tdao = new TestoDao();
		return tdao.selectAll();
	}
	
	public boolean carica(Testo p) {
		TestoDao tdao = new TestoDao();
		return tdao.pubblicaTesto(ConvertitoreFacade.converti(p));
	    
	}
	public boolean rimuovi(Testo p) {
		TestoDao tdao = new TestoDao();
		return tdao.rimuoviTesto(ConvertitoreFacade.converti(p));
	}
	
	public ArrayList<VideoDB> selectAllVideo() {
		VideoDao vdao = new VideoDao();
		return vdao.selectAll();
	}


	public boolean carica(Video p) {
		VideoDao vdao = new VideoDao();
		return vdao.pubblicaVideo(ConvertitoreFacade.converti(p));
	
	}


	public boolean rimuovi(Video p) {
		VideoDao vdao = new VideoDao();
		return vdao.rimuoviVideo(ConvertitoreFacade.converti(p));
	}
	
	public ArrayList<ProfiloDB> selectAllProfilo() {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.selectAll();
	}
	
	public boolean carica(Profilo p) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.inserisciProfilo(ConvertitoreFacade.converti(p));
	}
	
	public boolean inserisciChiaviProfilo(Profilo p, String s1, String s2, String s3) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.inserisciChiavi(ConvertitoreFacade.converti(p),s1,s2,s3);
	}
	
	public boolean rimuovi(Profilo p) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.rimuoviProfilo(ConvertitoreFacade.converti(p));
	}
	
	public ArrayList<ProfiloDB> cercaProfilo(String p) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.cercaProfilo(p);
	}
	
	public boolean vediEsiste(String idProfilo) throws AccountDoesNotExist {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.vediSeEsiste(idProfilo);
	}
	
	public boolean modificaEsiste(String p, Boolean b) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.modificaEsiste(p, b);
	}
	
	public boolean vediPswCambiata(String idProfilo) throws AccountDoesNotExist {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.vediSePswCambiata(idProfilo);
	}
	
	public boolean modificaPswCambiata(String p, Boolean b) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.modificaPswCambiata(p, b);
	}
	
	public boolean vediSeLoggato(String idProfilo) throws AccountDoesNotExist {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.vediSeIsLoggato(idProfilo);
	}
	
	public boolean modificaLoggato(String p, Boolean b) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.modificaIsLoggato(p, b);
	}
	
	public String vediPsw(String idProfilo) throws AccountDoesNotExist {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.ottieniPsw(idProfilo);
	}
	
	public boolean modificaPsw(String p, String b) throws AccountDoesNotExist {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.modificaPsw(p, b);
	}
}