package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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
import profilo.exception.TastoNonEsistente;
import profilo.follow.Follow;

class TestProfilo {

	static Profilo profiloAttivo;
	Profilo altroProfilo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		profiloAttivo = new Profilo("lqlo", "frank", null, 0, 0, 0, false, false, false, null, null);
		DbFacade.getIstance().carica(profiloAttivo);
	}
	@Test
	public void testAggiungiLike() {
		 Post p = new Foto("F666");
		 try {
			assertTrue(profiloAttivo.aggiungiLike(p));
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testAggiungiDislike() {
		 Post p = new Foto("F777");
		 try {
			assertTrue(profiloAttivo.aggiungiDislike(p));
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testRimuoviLike() {
		 Post p = new Foto("F888");
		 try {
			assertTrue(profiloAttivo.rimuoviLike(p));
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@Test
	public void testRimuoviDislike() {
		 Post p = new Foto("F999");
		 try {
			assertTrue(profiloAttivo.rimuoviDislike(p));
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
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
	//controllo se il profilo ha un determinato follow
	@Test
	public void testCercaFollow() {
		Follow f = new Follow("123", profiloAttivo.getIdProfilo());
		assertNotNull(profiloAttivo.cercaFollow(f));
	}
	
	//test sui messaggi
	@Test
	public void testScriviMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId1");
		assertTrue(profiloAttivo.scriviMessaggio(m));
	}
	
	@Test
	public void testScriviMessaggioPrivato() {
		altroProfilo = new Profilo("pluto");
		Messaggio m = new MessaggioPrivato("messaggioPrivatoId1", "tutto bene grazie", profiloAttivo.getIdProfilo(), altroProfilo.getIdProfilo());
		assertTrue(profiloAttivo.scriviMessaggio(m));
	}
	
	@Test
	public void testRimuoviMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId2");
		assertTrue(profiloAttivo.rimuoviMessaggio(m));
	}
	
	@Test
	public void testRimuoviMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioDiGruppoId2");
		assertTrue(profiloAttivo.rimuoviMessaggio(m));
	}
	
	@Test
	public void testCercaMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId3");
		assertNotNull(profiloAttivo.cercaMessaggio(m));
	}
	
	@Test
	public void testCercaMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioPrivatoId3");
		assertNotNull(profiloAttivo.cercaMessaggio(m));
	}
	
	@Test
	public void testOttieniTestoMessaggioDiGruppo() {
		altroProfilo = new Profilo("paperino");
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId4", "ci sentiamo", altroProfilo.getIdProfilo(),"gruppo4");
		assertNotNull(profiloAttivo.ottieniTestoMessaggio(m));
	}
	
	@Test
	public void testOttieniTestoMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioPrivatoId4", "alla prossima", "profiloInviante4", profiloAttivo.getIdProfilo());
		assertNotNull(profiloAttivo.ottieniTestoMessaggio(m));
	}
	
	
	//test sui post
	
	@Test
	public void testPubblicaFoto() {
		assertTrue(profiloAttivo.pubblicaPost(new Foto("F123", null, true, profiloAttivo.getIdProfilo(), "percorso1", true)));
	}
	@Test
	public void testPubblicaTesto() {
		assertTrue(profiloAttivo.pubblicaPost(new Testo("T456", "ho fame", true, profiloAttivo.getIdProfilo(), null, null)));
	}
	@Test
	public void testPubblicaSondaggioDoppiaVotazione() {
		assertTrue(profiloAttivo.pubblicaPost(new SondaggioDoppiaVotazione("SD123", null, true, profiloAttivo.getIdProfilo(), "prima scelta", "seconda scelta")));
	}
	@Test
	public void testPubblicaSondaggioSceltaMultipla() {
		assertTrue(profiloAttivo.pubblicaPost(new SondaggioSceltaMultipla("SM456", null, true, profiloAttivo.getIdProfilo(), "prima scelta", "seconda scelta", "terza scelta", "quarta scelta")));
	}
	
	@Test
	public void testRimuoviFoto() {
		assertTrue(profiloAttivo.rimuoviPost(new Foto("F123")));
	}
	@Test
	public void testRimuoviTesto() {
		assertTrue(profiloAttivo.rimuoviPost(new Testo("T456")));
	}
	@Test
	public void testRimuoviSondaggioDoppiaVotazione() {
		assertTrue(profiloAttivo.rimuoviPost(new SondaggioDoppiaVotazione("SD123")));
	}
	@Test
	public void testRimuoviSondaggioSceltaMultipla() {
		assertTrue(profiloAttivo.rimuoviPost(new SondaggioSceltaMultipla("SM123")));
	}
	@Test
	public void testPubblicaStoria() {
		assertTrue(profiloAttivo.pubblicaStoria(24, new Foto("F123", null, true, profiloAttivo.getIdProfilo(), "percorso2", true)));
	}
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
	//profilo
	
	@Test
	public void testCercaProfilo() {
		altroProfilo = new Profilo("piergeraldo");
		try {
			assertNotNull(profiloAttivo.cercaProfilo(altroProfilo));
		} catch (AccountDoesNotExist e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testCambiaImmagineProfilo() {
		Foto f = new Foto("F333", null, true, profiloAttivo.getIdProfilo(), "percorso4", true);
		assertTrue(profiloAttivo.cambiaImmagineProfilo(f.getIdPost()));
	}
	@Test
	public void testModificaNickname() {
		assertTrue(profiloAttivo.modificaNickname(profiloAttivo, "nickModificato"));
	}
	@Test
	public void testModificaDescrizione() {
		assertTrue(profiloAttivo.modificaDescrizione("nuova descrizione"));
	}
	
	//commenti
	@Test
	public void testPubblicaCommento() {
		Foto f = new Foto("F222");
		Commento c = new Commento("C123", profiloAttivo.getIdProfilo(), f.getIdPost(), "bella foto");
		assertTrue(profiloAttivo.pubblicaCommento(profiloAttivo.getIdProfilo(), c.getIdCommento(), c.getIdTesto()));
	}
	@Test
	public void testRimuoviCommento() {
		Commento c = new Commento("C456");
		assertTrue(profiloAttivo.rimuoviCommento(c.getIdCommento()));
	}
	@Test
	public void testCercaCommento() {
		altroProfilo = new Profilo("lodovico");
		Commento c = new Commento("789");
		assertNotNull(profiloAttivo.cercaCommento(c.getIdCommento()));
	}
	
	//gruppo
	@Test
	public void testCreaGruppo() {
		
		try {
			assertTrue(profiloAttivo.creaGruppo(null, null, null, null, null, null, null, null, profiloAttivo.getIdProfilo()));
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@Test
	public void testRimuoviGruppo() {
		Gruppo g = new Gruppo("G111");
		assertTrue(profiloAttivo.rimuoviGruppo(g));
	}
	@Test
	public void testCercaGruppo() {
		assertNotNull(profiloAttivo.cercaGruppo(new Gruppo("G345")));
	}
	@Test
	public void testModificammagineGruppo() {
		Foto f = new Foto("F444", null, true, profiloAttivo.getIdProfilo(), "percorso5", true);
		Gruppo g = new Gruppo("G678");
		assertTrue(profiloAttivo.modificaFotoGruppo(g, f.getIdPost()));
	}
	@Test
	public void testAggiungiPartecipante() {
		Gruppo g = new Gruppo("G123", null, null, null, null, null, null, null, null,profiloAttivo.getIdProfilo());
		altroProfilo = new Profilo("alfredo");
		assertTrue(profiloAttivo.aggiungiPartecipante(g.getIdGruppo(), altroProfilo.getIdProfilo()));
	}
	@Test
	public void testRimuoviPartecipante() {
		Gruppo g = new Gruppo("G345", null, null, "profilo1", "profilo2", "profilo3", "profilo4", "profilo5", "profilo6",profiloAttivo.getIdProfilo());
		assertTrue(profiloAttivo.aggiungiPartecipante(g.getIdGruppo(), "profilo4"));
	}
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}


}
