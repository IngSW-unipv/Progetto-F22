package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.gruppo.Gruppo;
import db.facade.DbFacade;
import post.Post;
import post.commento.Commento;
import post.multimedia.foto.Foto;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.*;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.AzioneNonConsentita;
import profilo.exception.GruppoGiaPieno;
import profilo.exception.ProfiloGiaInserito;
import profilo.exception.TastoNonEsistente;
import profilo.follow.Follow;

class TestProfilo {

	static Profilo profiloAttivo;
	Profilo altroProfilo;
	
	/**
	 * inizializzi l'istanza del profilo attuale prima del test
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		profiloAttivo = new Profilo("lqlo", "frank", null, 0, 0, 0, false, false, false, null, null);
		DbFacade.getIstance().carica(profiloAttivo);
	}
	/**
	 * testi la possibilit� di aggiungere like a un post
	 * @throws AzioneNonConsentita
	 */
	@Test
	public void testAggiungiLike() {
		 Post p = new Foto("F666");
		 try {
			assertTrue(profiloAttivo.aggiungiLike(p.getIdPost(), p.getTipo()));
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * testi la possibilit� di aggiungere dislike a un post
	 * @throws AzioneNonConsentita 
	 */
	@Test
	public void testAggiungiDislike() {
		 Post p = new Foto("F777");
		 try {
			assertTrue(profiloAttivo.aggiungiDislike(p.getIdPost(),p.getTipo()));
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * testi la possibilit� di rimuovere like a un post
	 * @throws AzioneNonConsentita
	 */
	@Test
	public void testRimuoviLike() {
		 Post p = new Foto("F888");
		 try {
			assertTrue(profiloAttivo.rimuoviLike(p.getIdPost(),p.getTipo()));
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * testi la possibilit� di rimuovere dislike a un post
	 * @throws AzioneNonConsentita 
	 */
	@Test
	public void testRimuoviDislike() {
		 Post p = new Foto("F999");
		 try {
			assertTrue(profiloAttivo.rimuoviDislike(p.getIdPost(),p.getTipo()));
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * testi la possibilit� di seguire un profilo
	 * @throws AccountDoesNotExist
	 * @throws AzioneNonConsentita
	 */
	@Test
	public void testSegui() throws AccountDoesNotExist, AzioneNonConsentita {
		altroProfilo = new Profilo("cicciogamer89@gmail.com");
		boolean esito;
		try {
			esito = profiloAttivo.segui(altroProfilo);
			assertTrue(esito);
		} catch(AccountDoesNotExist e) {
			e.printStackTrace();
		}
	}
	/**
	 * testi la possibilit� di smettere di seguire un profilo
	 * @throws AccountDoesNotExist
	 * @throws AzioneNonConsentita
	 */
	@Test
	public void testSmettiDiSeguire() throws AzioneNonConsentita {
		altroProfilo = new Profilo("lodovico");
		boolean esito;
		try {
			esito = profiloAttivo.smettiDiSeguire(altroProfilo);
			assertTrue(esito);
		} catch(AccountDoesNotExist e) {
			e.printStackTrace();
		}
	}
	/**
	 * testi la ricerca di un follow
	 */
	@Test
	public void testCercaFollow() {
		Follow f = new Follow("123", profiloAttivo.getIdProfilo());
		assertNotNull(profiloAttivo.cercaFollow(f));
	}
	
	/**
	 * testi la possibilit� di scrivere un messaggio di gruppo
	 */
	@Test
	public void testScriviMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId1");
		assertTrue(profiloAttivo.scriviMessaggio(m));
	}
	/**
	 * testi la possibilit� di scrivere un messaggio privato
	 */
	@Test
	public void testScriviMessaggioPrivato() {
		altroProfilo = new Profilo("pluto");
		Messaggio m = new MessaggioPrivato("messaggioPrivatoId1", "tutto bene grazie", profiloAttivo.getIdProfilo(), altroProfilo.getIdProfilo());
		assertTrue(profiloAttivo.scriviMessaggio(m));
	}
	/**
	 * testi la possibilit� di rimuovere un messaggio di gruppo
	 */
	@Test
	public void testRimuoviMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId2");
		assertTrue(profiloAttivo.rimuoviMessaggio(m));
	}
	/**
	 * testi la possibilit� di rimuovere un messaggio privato
	 */
	@Test
	public void testRimuoviMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioDiGruppoId2");
		assertTrue(profiloAttivo.rimuoviMessaggio(m));
	}
	/**
	 * testi la possibilit� di cercare un messaggio di gruppo
	 */
	@Test
	public void testCercaMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId3");
		assertNotNull(profiloAttivo.cercaMessaggio(m));
	}
	/**
	 * testi la possibilit� di cercare un messaggio privato
	 */
	@Test
	public void testCercaMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioPrivatoId3");
		assertNotNull(profiloAttivo.cercaMessaggio(m));
	}
	
	/**
	 * testi la possibilit� di pubblicare una foto
	 */
	@Test
	public void testPubblicaFoto() {
		assertTrue(profiloAttivo.pubblicaPost(new Foto("F123", null, true, profiloAttivo.getIdProfilo(), "percorso1", true, false)));
	}
	/**
	 * testi la possibilit� di pubblicare un testo
	 */
	@Test
	public void testPubblicaTesto() {
		assertTrue(profiloAttivo.pubblicaPost(new Testo("T456", "ho fame", true, profiloAttivo.getIdProfilo(), null, null)));
	}
	/**
	 * testi la possibilit� di pubblicare un sondaggio con doppia votazione
	 */
	@Test
	public void testPubblicaSondaggioDoppiaVotazione() {
		assertTrue(profiloAttivo.pubblicaPost(new SondaggioDoppiaVotazione("SD123", null, true, profiloAttivo.getIdProfilo(), "prima scelta", "seconda scelta")));
	}
	/**
	 * testi la possibilit� di pubblicare un sondaggio con scelta multipla
	 */
	@Test
	public void testPubblicaSondaggioSceltaMultipla() {
		assertTrue(profiloAttivo.pubblicaPost(new SondaggioSceltaMultipla("SM456", null, true, profiloAttivo.getIdProfilo(), "prima scelta", "seconda scelta", "terza scelta", "quarta scelta")));
	}
	/**
	 * testi la rimozione di una foto
	 */
	@Test
	public void testRimuoviFoto() {
		assertTrue(profiloAttivo.rimuoviPost(new Foto("F123")));
	}
	/**
	 * testi la rimozione di un testo
	 */
	@Test
	public void testRimuoviTesto() {
		assertTrue(profiloAttivo.rimuoviPost(new Testo("T456")));
	}
	/**
	 * testi la possibilit� di rimuovere un sondaggio con doppia scelta
	 */
	@Test
	public void testRimuoviSondaggioDoppiaVotazione() {
		assertTrue(profiloAttivo.rimuoviPost(new SondaggioDoppiaVotazione("SD123")));
	}
	/**
	 * testi la possibilit� di rimuovere un sondaggio con scelta multipla
	 */
	@Test
	public void testRimuoviSondaggioSceltaMultipla() {
		assertTrue(profiloAttivo.rimuoviPost(new SondaggioSceltaMultipla("SM123")));
	}
	/**
	 * testi la pubblicazione di una storia
	 */
	@Test
	public void testPubblicaStoria() {
		assertTrue(profiloAttivo.pubblicaStoria(24, new Foto("F123", null, true, profiloAttivo.getIdProfilo(), "percorso2", true, false)));
	}
	/**
	 * testi la possibilit� di agguingere un voto a un sondaggio con doppia scelta
	 * @throws TastoNonEsistente
	 * @throws AzioneNonConsentita
	 */
	@Test 
	public void testAggiungiVotoSondaggioDoppiaScelta() throws TastoNonEsistente, AzioneNonConsentita {
		
			altroProfilo = new Profilo("piero");
			SondaggioDoppiaVotazione s = new SondaggioDoppiaVotazione("SD111", null, true, altroProfilo.getIdProfilo(), "prima scelta", "seconda scelta");
		try {
			assertTrue(profiloAttivo.aggiungiVotoSondaggio(s.getIdPost(), 1, s.getTipo()));
		} catch(TastoNonEsistente e) {
			e.printStackTrace();
		}
	}
	/**
	 * testi la possibilit� di agguingere un voto a un sondaggio con scelta multipla
	 * @throws TastoNonEsistente
	 * @throws AzioneNonConsentita
	 */
	@Test
	public void testAggiungiVotoSondaggioSceltaMultipla() throws TastoNonEsistente, AzioneNonConsentita {
		
		altroProfilo = new Profilo("giacomino");
		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla("SM222", null, true, altroProfilo.getIdProfilo(), "prima scelta", "seconda scelta", "terza scelta", "quarta scelta");
		try {
			assertTrue(profiloAttivo.aggiungiVotoSondaggio(s.getIdPost(), 3, s.getTipo()));
		} catch(TastoNonEsistente e) {
			e.printStackTrace();
		}
	}
	/**
	 * testi la ricerca a un profilo
	 */
	@Test
	public void testCercaProfilo() {
		altroProfilo = new Profilo("piergeraldo");
		try {
			assertNotNull(profiloAttivo.cercaProfilo(altroProfilo));
		} catch (AccountDoesNotExist e) {
			e.printStackTrace();
		}
	}
	/**
	 * testi la possibilit� di cambiare foto al profilo
	 */
	@Test
	public void testCambiaImmagineProfilo() {
		Foto f = new Foto("F333", null, true, profiloAttivo.getIdProfilo(), "percorso4", true, false);
		assertTrue(profiloAttivo.cambiaImmagineProfilo(f.getIdPost()));
	}
	/**
	 * testi la possibilit� di cambiare nickname
	 */
	@Test
	public void testModificaNickname() {
		assertTrue(profiloAttivo.modificaNickname(profiloAttivo, "nickModificato"));
	}
	/**
	 * testi la possibilit� di cambiare descrizione
	 */
	@Test
	public void testModificaDescrizione() {
		assertTrue(profiloAttivo.modificaDescrizione("nuova descrizione"));
	}
	/**
	 * testi la pubblicazione di un commento
	 */
	@Test
	public void testPubblicaCommento() {
		Foto f = new Foto("F222");
		Commento c = new Commento("C123", profiloAttivo.getIdProfilo(), f.getIdPost(), "bella foto");
		assertTrue(profiloAttivo.pubblicaCommento(profiloAttivo.getIdProfilo(), c.getIdCommento(), c.getIdTesto(), f.getTipo()));
	}
	/**
	 * testi la rimozione di un commento
	 */
	@Test
	public void testRimuoviCommento() {
		Commento c = new Commento("C456");
		assertTrue(profiloAttivo.rimuoviCommento(c.getIdCommento()));
	}
	/**
	 * testi la ricerca di un commento
	 */
	@Test
	public void testCercaCommento() {
		altroProfilo = new Profilo("lodovico");
		Commento c = new Commento("789");
		assertNotNull(profiloAttivo.cercaCommento(c.getIdCommento()));
	}
	/**
	 * testi la possibilit� di creare un gruppo
	 */
	@Test
	public void testCreaGruppo() {
		
		try {
			assertTrue(profiloAttivo.creaGruppo("Mi piace il mare", "I marinai"));
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	/**
	 * testi la possibilit� di rimuovere un gruppo
	 */
	@Test
	public void testRimuoviGruppo() {
		Gruppo g = new Gruppo("G111");
		assertTrue(profiloAttivo.rimuoviGruppo(g));
	}
	/**
	 * testi la ricerca un gruppo
	 */
	@Test
	public void testCercaGruppo() {
		assertNotNull(profiloAttivo.cercaGruppo(new Gruppo("G345")));
	}
	/**
	 * testi la possibilit� di aggiungere un partecipante a un gruppp
	 */
	@Test
	public void testAggiungiPartecipante() {
		Gruppo g = new Gruppo("G123", null, null, null, null, null, null, null,profiloAttivo.getIdProfilo());
		altroProfilo = new Profilo("alfredo");
		try {
			assertTrue(profiloAttivo.aggiungiPartecipante(g.getIdGruppo(), altroProfilo.getIdProfilo()));
		} catch (GruppoGiaPieno e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ProfiloGiaInserito e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * testi la possibilit� di rimuovere un partecipante a un gruppo
	 */
	@Test
	public void testRimuoviPartecipante() {
		Gruppo g = new Gruppo("G345", null, "profilo1", "profilo2", "profilo3", "profilo4", "profilo5", "profilo6",profiloAttivo.getIdProfilo());
		assertTrue(profiloAttivo.rimuoviPartecipante(g.getIdGruppo(), "profilo4"));
	}
}

