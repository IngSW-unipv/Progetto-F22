package chat.chatDiGruppo;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;

public class ChatDiGruppoTester {

	public static void main(String[] args) {
		ChatDiGruppo c = new ChatDiGruppo(null);
		MessaggioDiGruppo m = new MessaggioDiGruppo("001", null, null, "Ciao Sara, come va?", null, "G00");
		
		ArrayList<Messaggio> res = c.selectAll();
		for(Messaggio msg : res) { 
				System.out.println(msg.toString());
			}
		
		System.out.println(c.caricaMessaggio(m));
		
		c.leggiMessaggiDiGruppo(m);
		
	}
}
