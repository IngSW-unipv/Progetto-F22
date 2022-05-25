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
		Profilo p = new Profilo("ciccioGamer@unipv.it", "Mucca");
		DbFacade.getIstance().carica(p);
	}

	@Test
	void testSignIn() throws AccountGiaEsistente, ChangeDefaultPassword, AccountDoesNotExist, Exception {
		boolean esito;
		try {
			esito = sistema.signIn("FavijTv@unipv.it", "Favij", "youtuboanch'io");
			assertTrue(esito);
		} catch (AccountGiaEsistente e) {
			e.printStackTrace();
		}	
	}
	
	@Test
	void testLogIn() {
		boolean esito;
		try {
		 	esito = sistema.login("paoloruffini@gmail.it	"	, "paoloruffini");
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
		 	esito = sistema.login("lasabrigamer@unipv.it", "mucca");
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
	void testCambioPassword() {
		boolean esito;
		try {
			esito = sistema.cambiaPassword("lasabrigamer@unipv.it", "lasabri", "cavallo");
			assertTrue(esito);
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	}
		
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			try {
				sistema.rimuoviAccount(new Profilo("FavijTv@unipv.it"));
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			sistema.cambiaPassword("lasabrigamer@unipv.it", "cavallo", "lasabri");
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	}
	}
}
	


