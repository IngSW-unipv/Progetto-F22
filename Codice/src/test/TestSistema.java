package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Sistema.Sistema;
import db.facade.DbFacade;
import profilo.Profilo;
import profilo.exception.*;

class TestSistema {

	static Sistema sistema = new Sistema();
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Profilo p = new Profilo("lollo", "cortomuso");
		DbFacade.getIstance().carica(p);
	}

	@Test
	void testSignIn() throws AccountGiaEsistente, ChangeDefaultPassword, AccountDoesNotExist, Exception {
		boolean esito;
		try {
			esito = sistema.signIn("ciccioGamer89", "ciccio", "akunaMatata");
			assertTrue(esito);
		} catch (AccountGiaEsistente e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void testLogIn() {
		boolean esito;
		try {
		 	esito = sistema.login("dilo", "dilonudo");
		 	assertTrue(esito);
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	} catch (PswOmailErrati e) {
	 		e.printStackTrace();
	 	} 
	}

	@Test
	void testLogInFallito() {
		boolean esito;
		try {
		 	esito = sistema.login("dilo", "mucca");
		 	assertFalse(esito);
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	} catch (PswOmailErrati e) {
	 		e.printStackTrace();
	 		
	 	} 
	}
	
	@Test
	void testRimuoviProfilo() {
		assertTrue(sistema.getProfiloAttivo().rimuoviQuestoProfilo());
	}
	/*
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			try {
				assertTrue(sistema.getProfiloAttivo().rimuoviQuestoProfilo());
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sistema.getProfiloAttivo().cambiaPassword("cavallo", "lasabri");
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	}
	}*/
}
