package test;

import static org.junit.jupiter.api.Assertions.*;
<<<<<<< HEAD

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.Before;

import java.sql.Date;
import java.sql.Time;
=======
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git

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
<<<<<<< HEAD
	private Profilo p;
	private ArrayList<Messaggio> listaMessaggi = new ArrayList<Messaggio>();
=======
	private ArrayList<Messaggio> listaMessaggi;
	private Messaggio m1, m2;
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
	
<<<<<<< HEAD
	/**
	 * Crea due chat che poi comparerò.
	 * Crea inoltre due liste di ruoli per istanziare correttamente i due compiti.
	 * */
=======
	//verifico che posso istanziare correttamente le chat
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
	@Before
	public void initTestChat() {
		
<<<<<<< HEAD
		p = new Profilo("P001", "profiloA", "descrizione del profilo", 235, 384, 21, EnumProfilo.PRIVATO, "002", "001", "francesco.ardizzoni@gmail.com", "postX");
		
		Gruppo g = new Gruppo("g001", "descrizione del gruppo", "TMF-JAVA", p.getNickname(), "profiloB", "profiloC", "profiloD", "profiloE", "profiloF", "profiloB");
		Messaggio m2 = new MessaggioDiGruppo(p.getMessaggioDiGruppo(), null, null, "Tutto bene grazie", "G01", g.getIdGruppo());
		c1 = new ChatDiGruppo(p);
		
		Messaggio m1 = new MessaggioPrivato(p.getMessaggioPrivato(), null, null, "Ciao Sara, come va?", "G00", "P001", "P003");
		c2 = new ChatPrivata(p);
		
		listaMessaggi.add(m1);
		listaMessaggi.add(m2);
=======
		listaMessaggi = new ArrayList<Messaggio>();
		
		Profilo p = new Profilo("P001", "profiloA", "descrizione del profilo", 235, 384, 21, EnumProfilo.PRIVATO, "002", "001", "francesco.ardizzoni@gmail.com", "postX");
		
		Gruppo g = new Gruppo("g001", "descrizione del gruppo", "TMF-JAVA", null, "profiloB", "profiloC", "profiloD", "profiloE", "profiloF", "profiloB");
		m2 = new MessaggioDiGruppo("ciaoo", null, null, "Tutto bene grazie", "G01", null);
		c2 = new ChatDiGruppo(p);
		
		m1 = new MessaggioPrivato("ciao", null, null, "Ciao Sara, come va?", "G00", "P001", "P003");
		c1 = new ChatPrivata(p);
		
		
		
		listaMessaggi.add(m1);
		listaMessaggi.add(m2);		
	}

	@Test
	public void testCaricaMessaggio() {
		
		assertTrue(c1.caricaMessaggio(listaMessaggi.get(0)));
		assertTrue(c2.caricaMessaggio(listaMessaggi.get(1)));
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
	}
	
	@Test
	public void testEliminaMessaggio() {
		
		assertTrue(c1.eliminaMessaggio(listaMessaggi.get(0)));
		assertTrue(c2.eliminaMessaggio(listaMessaggi.get(1)));
	}
}
