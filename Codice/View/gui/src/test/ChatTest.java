package test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull; 
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.Before;
 
import java.sql.Date;
import java.sql.Time;
 
import chat.Chat;
import chat.chatDiGruppo.ChatDiGruppo;
import chat.chatPrivata.ChatPrivata;
import profilo.Profilo;
import profilo.EnumProfilo;
import chat.chatDiGruppo.gruppo.Gruppo;
import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;

class ChatTest {
	
	private Chat c1, c2;
	private Profilo p;
	private ArrayList<Messaggio> listaMessaggi = new ArrayList<Messaggio>();
	private Messaggio m1, m2;
	
	/**
	 * Crea due chat che poi comparerÃ².
	 * Crea inoltre due liste di ruoli per istanziare correttamente i due compiti.
	 * */
	@Before
	public void initTestChat() {
		
		p = new Profilo("P001", "profiloA", "descrizione del profilo", 235, 384, 21, EnumProfilo.PRIVATO, "002", "001", "francesco.ardizzoni@gmail.com", "postX");
		
		Gruppo g = new Gruppo("g001", "descrizione del gruppo", "TMF-JAVA", p.getNickname(), "profiloB", "profiloC", "profiloD", "profiloE", "profiloF", "profiloB");
		m2 = new MessaggioDiGruppo(p.getMessaggioDiGruppo(), null, null, "Tutto bene grazie", "G01", g.getIdGruppo());
		c2 = new ChatDiGruppo(p, m2);
		
		m1 = new MessaggioPrivato(p.getMessaggioPrivato(), null, null, "Ciao Sara, come va?", "G00", "P001", "P003");
		c1 = new ChatPrivata(p, m1);
		
		listaMessaggi.add(m1);
		listaMessaggi.add(m2);
	}
	
	@Test
	public void testCaricaMessaggio() {
		
		assertTrue(c1.caricaMessaggio(listaMessaggi.get(0)));
		assertTrue(c2.caricaMessaggio(listaMessaggi.get(1)));
	}
	
	@Test
	public void testEliminaMessaggio() {
		
		assertTrue(c1.eliminaMessaggio(listaMessaggi.get(0)));
		assertTrue(c2.eliminaMessaggio(listaMessaggi.get(1)));
	}
}
