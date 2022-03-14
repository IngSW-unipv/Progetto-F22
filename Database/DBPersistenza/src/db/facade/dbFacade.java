package db.facade;

import java.util.ArrayList;

import Messaggio.MessaggioDiGruppo;
//import Messaggio.utility.MessaggioUtility;
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

public class dbFacade {

	public boolean scriviCommento(CommentoDB c) {
		CommentoDao cdao = new CommentoDao();
		return cdao.scriviCommento(c);
		
	}
	
	public boolean rimuoviCommento(CommentoDB c) {
		CommentoDao cdao = new CommentoDao();
		return cdao.rimuoviCommento(c);
	
	}

	public ArrayList<CommentoDB> mostraCommentiSottoPost(CommentoDB c) {
		CommentoDao cdao = new CommentoDao();
		return cdao.mostraCommentiSottoPost(c);
	}
	
	public ArrayList<FotoDB> selectAllFoto() {
		FotoDao fdao = new FotoDao();
		return fdao.selectAll();
	}


	public boolean caricaPost(FotoDB p) {
		FotoDao fdao = new FotoDao();
		return  fdao.pubblicaFoto(p);
		
	}

	
	public boolean rimuoviPost(FotoDB p) {
		FotoDao fdao = new FotoDao();
		return fdao.rimuoviFoto(p);
	}
	
	public boolean caricaGruppo(GruppoDB g) {
		GruppoDao gdao = new GruppoDao();
		return gdao.creaGruppo(g);
	
	}
	
	public boolean eliminaGruppo(GruppoDB g) {
		GruppoDao gdao = new GruppoDao();

		return gdao.cancellaGruppo(g);
		
	}
	
	public boolean gestisciPartecipanti(GruppoDB g) {
		GruppoDao gdao = new GruppoDao();
		return gdao.inserisciChiavi(g);
		
	}

	public ArrayList<GruppoDB> cercaGruppoo(GruppoDB g) {
		GruppoDao gdao = new GruppoDao();
		return gdao.cercaGruppo(g);
	}
	
	public ArrayList<GruppoDB> selectAlll() {
		GruppoDao gdao = new GruppoDao();
		return gdao.selectall();
	}
	
	/*public ArrayList<MessaggioDiGruppoDB> cercaMessaggio(MessaggioDiGruppo m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.cercaMessaggioDiGruppo(u.convertiMDG(m));
	} */

	
	public void ottieniMessaggio(MessaggioDiGruppoDB m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		mdao.ottieniTesto(m);
		
	}


	public boolean caricaMessaggio(MessaggioDiGruppoDB m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return  mdao.scriviMessaggioDiGruppo(m);
		
	}

	public boolean eliminaMessaggio(MessaggioDiGruppoDB m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.rimuoviMessaggioDiGruppo(m);
		
	}

	public ArrayList<MessaggioDiGruppoDB> listaMessaggiDiUnGruppo(MessaggioDiGruppoDB m) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		return mdao.selectAllIdGruppo(m);
	}

	public ArrayList<MessaggioDiGruppoDB> ottieniListaTuttiMessaggiDiGruppo() {
		MessaggioDiGruppoDao gdao = new MessaggioDiGruppoDao();
		return gdao.selectAll();
	}
	
	
	public ArrayList<MessaggioPrivatoDB> selectAllNomeProfilo(MessaggioPrivatoDB m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAllNomeProfilo(m);
	}
	
	
	public ArrayList <MessaggioPrivatoDB> ottieniListaTuttiMessaggiPrivati() {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.selectAll();
	
	}
	
	
	public ArrayList<MessaggioPrivatoDB> cercaMessaggio(MessaggioPrivatoDB m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		return mdao.cercaMessaggioPrivato(m);
	}

	public void ottieniMessaggio(MessaggioPrivatoDB m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		mdao.ottieniMessaggio(m);
	}


	public boolean caricaMessaggio(MessaggioPrivatoDB m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
		
		return mdao.scriviMessaggioPrivato(m);

	}

	
	public boolean eliminaMessaggio(MessaggioPrivatoDB m) {
		MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();

		return mdao.rimuoviMessaggioPrivato(m);

	}
	
	public ArrayList<SondaggioDoppiaVotazioneDB> selectAllSDV() {
		SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
		return sdao.selectAll();
	}


	public boolean caricaPost(SondaggioDoppiaVotazioneDB p) {
		SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
		 return sdao.pubblicaSondaggio(p);
		
	}


	public boolean rimuoviPost(SondaggioDoppiaVotazioneDB p) {
		SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
		return sdao.rimuoviSondaggio(p);
	}
	
	public ArrayList<SondaggioSceltaMultiplaDB> selectAllSSM() {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		return sdao.selectAll();
	}

	
	public boolean caricaPost(SondaggioSceltaMultiplaDB p) {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
	    return sdao.pubblicaSondaggio(p);
	}

	public boolean rimuoviPost(SondaggioSceltaMultiplaDB p) {
		SondaggioSceltaMultiplaDao sdao = new SondaggioSceltaMultiplaDao();
		return sdao.rimuoviSondaggio(p);
	}
	
	public ArrayList<TestoDB> selectAllTesto() {
		TestoDao tdao = new TestoDao();
		return tdao.selectAll();
	}
	
	public boolean caricaPost(TestoDB p) {
		TestoDao tdao = new TestoDao();
		return tdao.pubblicaTesto(p);
	    
	}
	public boolean rimuoviPost(TestoDB p) {
		TestoDao tdao = new TestoDao();
		return tdao.rimuoviTesto(p);
	}
	
	public ArrayList<VideoDB> selectAllVideo() {
		VideoDao vdao = new VideoDao();
		return vdao.selectAll();
	}


	public boolean caricaPost(VideoDB p) {
		VideoDao vdao = new VideoDao();
		return vdao.pubblicaVideo(p);
	
	}


	public boolean rimuoviPost(VideoDB p) {
		VideoDao vdao = new VideoDao();
		return vdao.rimuoviVideo(p);
	}
	
	public ArrayList<ProfiloDB> selectAllProfilo() {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.selectAll();
	}
	
	public boolean inserisciProfilo(ProfiloDB p) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.inserisciProfilo(p);
	}
	
	public boolean inserisciChiaviProfilo(ProfiloDB p) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.inserisciChiavi(p);
	}
	
	public boolean rimuoviProfilo(ProfiloDB p) {
		ProfiloDao pdao = new ProfiloDao();
		return pdao.rimuoviProfilo(p);
	}
	
	public ArrayList<ProfiloDB> cercaProfilo(ProfiloDB p) {
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



































