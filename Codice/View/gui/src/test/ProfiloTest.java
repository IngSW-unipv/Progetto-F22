package test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull; 
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Utente.Utente;
import Utente.credenziali.Credenziali;
import Utente.exception.AccountDoesNotExist;
import Utente.exception.AccountGiaEsistente;
import Utente.exception.ChangeDefaultPassword;
import Utente.exception.PswOmailErrati;
import profilo.EnumProfilo;
import profilo.Profilo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

class ProfiloTest {
	
	private Profilo p;
	private Utente u;

	@Before
	void initTest() {
		
		Credenziali c = new Credenziali("Davide", "Mascheroni", null, null, null, "davide.mascheroni1234@gmail.com", null);
		u = new Utente(c, false, false, false, "AB10");
		
		p = new Profilo("P01", "MyAccount", "ds", 0, 0, 0, EnumProfilo.PRIVATO, null, null, u, null);
	}
	
	@Test
	void testCreazioneProfilo() throws AccountGiaEsistente {
		assertNotNull(u.creaProfilo("P01", null, null, 0, 0, 0, null, null, null, u, null));
	}
	@Test
	void testLogin() throws ChangeDefaultPassword, AccountDoesNotExist, PswOmailErrati {
		assertTrue(u.login(p, "davide.mascheroni1234@gmail.com", null));
	}
	
	@Test 
	void testEliminazioneAccount() {
		assertTrue(u.rimuoviAccount(p));
	}
	
	@Test
	void testLogout() throws AccountDoesNotExist {
		assertTrue(u.logout(p));
	}
}