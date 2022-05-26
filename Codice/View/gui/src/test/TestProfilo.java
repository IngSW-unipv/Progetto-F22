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
import db.facade.DbFacade;
import profilo.*;
import profilo.exception.AccountDoesNotExist;
import profilo.follow.Follow;

class TestProfilo {

	static Profilo profiloAttivo;
	Profilo altroProfilo;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		profiloAttivo = new Profilo("francesco.ardizzoni@gmail.com", "frank", null, EnumProfilo.PUBBLICO,null);
		DbFacade.getIstance().carica(profiloAttivo);
	}
	
	@Test
	public void testSegui() throws AccountDoesNotExist {
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
	public void testSmettiDiSeguire() {
		altroProfilo = new Profilo("ciao");
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
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId1", null, null, "ciao come stai", "percorso1",null, "gruppo1");
		assertTrue(profiloAttivo.scriviMessaggio(m));
	}
	
	@Test
	public void testScriviMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioPrivatoId1", null, null, "tutto bene grazie", "percorso2", "profiloInviante1", profiloAttivo.getIdProfilo());
		assertTrue(profiloAttivo.scriviMessaggio(m));
	}
	
	@Test
	public void testRimuoviMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId2", null, null, "tutto a posto?", "percorso3",null,"gruppo2");
		assertTrue(profiloAttivo.rimuoviMessaggio(m));
	}
	
	@Test
	public void testRimuoviMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioDiGruppoId2", null, null, "ciao come stai", "percorso4", "profiloInviante2", profiloAttivo.getIdProfilo());
		assertTrue(profiloAttivo.rimuoviMessaggio(m));
	}
	
	@Test
	public void testCercaMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId3", null, null, "non lo so", "percorso5",null, "gruppo3");
		assertNotNull(profiloAttivo.cercaMessaggio(m));
	}
	
	@Test
	public void testCercaMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioPrivatoId3", null, null, "boh forse", "percorso6", "profiloInviante3", profiloAttivo.getIdProfilo());
		assertNotNull(profiloAttivo.cercaMessaggio(m));
	}
	
	@Test
	public void testOttieniTestoMessaggioDiGruppo() {
		Messaggio m = new MessaggioDiGruppo("messaggioDiGruppoId4", null, null, "ci sentiamo", "percorso7",null, "gruppo4");
		assertNotNull(profiloAttivo.ottieniTestoMessaggio(m));
	}
	
	@Test
	public void testOttieniTestoMessaggioPrivato() {
		Messaggio m = new MessaggioPrivato("messaggioPrivatoId4", null, null, "alla prossima", "percorso8", "profiloInviante4", profiloAttivo.getIdProfilo());
		assertNotNull(profiloAttivo.ottieniTestoMessaggio(m));
	}
	
	
	//test sui post
	
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
