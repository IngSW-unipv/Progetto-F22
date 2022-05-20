package test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Test.*;

import org.junit.After;
import org.junit.Before;
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
		boolean esito = false;
		try {
			esito = sistema.signIn("FavijTv@unipv.it", "Favij", "youtuboanch'io");
		} catch (AccountGiaEsistente e) {
			e.printStackTrace();
		}	
		System.out.println(esito);
		assertTrue(esito);
	}
	
	@Test
	void testLogIn() {
		boolean esito = false;
		try {
		 	esito = sistema.login("paoloruffini@gmail.it	"	, "paoloruffini");
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	} catch (PswOmailErrati e) {
	 		e.printStackTrace();
	 	} 
		assertTrue(esito);
	}
	
	@Test
	void testLogInFallito() {
		boolean esito = false;
		try {
		 	esito = sistema.login("lasabrigamer@unipv.it", "mucca");
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	} catch (PswOmailErrati e) {
	 		e.printStackTrace();
	 		
	 	} 
		assertFalse(esito);
	}
	@Test
	void testCambioPassword() {
		boolean esito = false;
		try {
			esito = sistema.cambiaPassword("lasabrigamer@unipv.it", "lasabri", "cavallo");
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	}
		assertTrue(esito);
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
	


