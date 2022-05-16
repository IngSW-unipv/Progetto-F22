package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;

import Sistema.Sistema;
import profilo.Profilo;
import profilo.exception.*;

class TestSistema {

	static Sistema sistema; 

	public static void main(String[] args) throws AccountGiaEsistente, ChangeDefaultPassword, AccountDoesNotExist   {
		sistema = new Sistema();

		setUpBeforeClass();
		
		testSignIn("ciccioGamer@unipv.it", "ciccioGamer", "Mucca");
		testLogIn("ciccioGamer@unipv.it", "Mucca");
		testCambioPassword("ciccioGamer@unipv.it", "Mucca", "Lucertola");
		testLogInConVecchiaPassWord("ciccioGamer@unipv.it", "Mucca");
		
		tearDownAfterClass();
	}

	@Before
	static void setUpBeforeClass() { 
		
	}

	@After
	static void tearDownAfterClass() {
		sistema.rimuoviAccount(new Profilo("ciccioGamer@unipv.it","ciccio"));
	}

	@Test
	static	void testSignIn(String email, String nickName, String password) throws AccountGiaEsistente, ChangeDefaultPassword, AccountDoesNotExist {
		boolean esito = false;
		try {
			esito = sistema.signIn(email, nickName, password);
		} catch (AccountGiaEsistente e) {
			e.printStackTrace();
		}	
		System.out.println(esito);
		assertTrue(esito);
	}
	
	@Test
	static void testLogIn(String email, String passWord) {
		boolean esito = false;
		try {
		 	esito = sistema.login(email, passWord);
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	} catch (PswOmailErrati e) {
	 		e.printStackTrace();
	 		
	 	} 
		System.out.println(esito);
		assertTrue(esito);
	}
	
	@Test
	static void testCambioPassword(String email, String vecchiaPassword, String nuovaPassword) {
		boolean esito = false;
		try {
			esito = sistema.cambiaPassword(email,vecchiaPassword, nuovaPassword);
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	}
		System.out.println(esito);
		assertTrue(esito);
	}
	@Test
	static void testLogInConVecchiaPassWord(String email, String passWord) {
		boolean esito = true;
		try {
		 	sistema.login(email, passWord);
	 	} catch (ChangeDefaultPassword e) {
		 	e.printStackTrace();
	 	} catch (AccountDoesNotExist e) {
		 	e.printStackTrace();
	 	} catch (PswOmailErrati e) {
	 		esito = false;
	 	} 			
			System.out.println(esito);
	 		assertFalse(esito);
	}
}

