package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import Sistema.Sistema;
import db.facade.DbFacade;
import profilo.Profilo;
import profilo.exception.*;

class TestSistema {

	static Sistema sistema = new Sistema();
	
	/**
	 * inizializziamo il Profilo prima del test
	 * @throws Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		Profilo p = new Profilo("lollo", "cortomuso");
		DbFacade.getIstance().carica(p);
	}
	/** 
	 * esegui il test del SingIn
	 * @throws AccountGiaEsistente
	 * @throws ChangeDefaultPassword
	 * @throws AccountDoesNotExist
	 * @throws Exception
	 */
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
	/** 
	 * esegui il test del SingIn
	 * @throws PswOmailErrati
	 * @throws ChangeDefaultPassword
	 * @throws AccountDoesNotExist
	 * @throws Exception
	 */
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
	/**
	 * controlli se il login fallisce
	 * @throws PswOmailErrati
	 * @throws ChangeDefaultPassword
	 * @throws AccountDoesNotExist
	 * @throws Exception
	 */
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
	/**
	 * testi l'eliminazione del profilo
	 */
	@Test
	void testRimuoviProfilo() {
		assertTrue(sistema.getProfiloAttivo().rimuoviQuestoProfilo());
	}
}
