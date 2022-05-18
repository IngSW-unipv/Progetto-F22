package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Sistema.Sistema;
import profilo.Profilo;
import profilo.exception.*;

class TestSistema {

	static Sistema sistema; 
	static boolean esitoTestSignIn, esitoRimozione;

	public static void main(String[] args) throws AccountDoesNotExist, AccountGiaEsistente   {
		Sistema sistema = new Sistema();

		esitoRimozione = sistema.rimuoviAccount(new Profilo("ciccioGamer@unipv.it","ciccio"));

		try {
			esitoTestSignIn = sistema.signIn("ciccioGamer@unipv.it", "ciccio");
			System.out.println(esitoRimozione);

		} catch (AccountGiaEsistente e) {
			e.printStackTrace();
		}

		try {
			sistema.cambiaDefaultPassword("ciccioGamer@unipv.it", "Gelato");
		} catch (ChangeDefaultPassword e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	 catch (AccountDoesNotExist e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	 }


	 try {
		 try {
			 sistema.cambiaPassword("ciccioGamer@unipv.it","Mucca", "Lucertola");
		 } catch (ChangePassword e) {
			 // TODO Auto-generated catch block
			 e.printStackTrace();
		 }
	 } catch (ChangeDefaultPassword e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	 } catch (AccountDoesNotExist e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	 }

	 try {
		 sistema.login("ciccioGamer@unipv.it", "Mucca");
	 } catch (ChangeDefaultPassword e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	 } catch (AccountDoesNotExist e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	 } catch (PswOmailErrati e) {
		 // TODO Auto-generated catch block
		 e.printStackTrace();
	 }

	 testSignIn();
		}

		@BeforeAll
		static void setUpBeforeClass() { 
			Sistema sistema = new Sistema();
			esitoRimozione = sistema.rimuoviAccount(new Profilo("ciccioGamer@unipv.it","ciccio"));
		}

		@AfterAll
		static void tearDownAfterClass() throws Exception {
		}

		@BeforeEach
		void setUp() throws AccountGiaEsistente {

		}

		@AfterEach
		void tearDown() throws Exception {
		}

		@Test
		static	void testSignIn() throws AccountGiaEsistente {
			try {
				esitoTestSignIn = sistema.signIn("ciccioGamer@unipv.it", "ciccio");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertTrue(esitoTestSignIn);
	}
}

