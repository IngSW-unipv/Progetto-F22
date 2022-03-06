package test;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

import chat.Chat;
import chat.chatDiGruppo.ChatDiGruppo;
import chat.chatPrivata.ChatPrivata;
import profilo.Profilo;

class ChatTest {
	
	private Chat c1, c2;
	private Profilo p;
	
	/**
	 * Crea due chat che poi comparer.
	 * Crea inoltre due liste di ruoli per istanziare correttamente i due compiti.
	 * */
	@Before
	public void initTestChat() {
		c1 = new ChatDiGruppo(p);
		c2 = new ChatPrivata(p);
	}
	
	@Test
	public void testChat() {
		
	}
}
