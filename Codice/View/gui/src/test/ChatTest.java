package test;

import static org.junit.jupiter.api.Assertions.*;

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
	
	/**
	 * Crea due chat che poi comparerò.
	 * Crea inoltre due liste di ruoli per istanziare correttamente i due compiti.
	 * */
	@Before
	public void initTestChat() {
		
		p = new Profilo("P001", "profiloA", "descrizione del profilo", 235, 384, 21, EnumProfilo.PRIVATO, "002", "001", "francesco.ardizzoni@gmail.com", "postX");
		
		Gruppo g = new Gruppo("g001", "descrizione del gruppo", "TMF-JAVA", p.getNickname(), "profiloB", "profiloC", "profiloD", "profiloE", "profiloF", "profiloB");
		Messaggio m2 = new MessaggioDiGruppo(p.getMessaggioDiGruppo(), null, null, "Tutto bene grazie", "G01", g.getIdGruppo());
		c1 = new ChatDiGruppo(p);
		
		Messaggio m1 = new MessaggioPrivato(p.getMessaggioPrivato(), null, null, "Ciao Sara, come va?", "G00", "P001", "P003");
		c2 = new ChatPrivata(p);
		
		listaMessaggi.add(m1);
		listaMessaggi.add(m2);
	}
	
	@Test
	public void testChat() {
		
	}
}
