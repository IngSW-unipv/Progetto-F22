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
	
	Sistema sistema; 
	boolean c;
	
	public static void main(String[] args)   {
		Sistema sistema = new Sistema();
		sistema.rimuoviAccount(new Profilo("ciccioGamer@unipv.it","ciccio"));

		try {
			boolean c;
			c = sistema.signIn("ciccioGamer@unipv.it", "ciccio");
			System.out.println(c);
		} catch (AccountGiaEsistente e) {
			e.printStackTrace();
		}
		
		
		try {
			sistema.cambiaDefaultPassword("ciccioGamer@unipv.it", "Gelato");
		} catch (ChangeDefaultPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountDoesNotExist e) {
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
	}

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
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

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
