package chat.chatDiGruppo;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import profilo.EnumProfilo;
import profilo.Profilo;

public class ChatDiGruppoTester {

	public static void main(String[] args) {
		
		Profilo p = new Profilo("004", null, null, 0, 0, 0, EnumProfilo.PRIVATO, null, null, null, null);
		MessaggioDiGruppo m = new MessaggioDiGruppo("M04", null, null, "Ciao Sara, come va?", null, "G00");
		ChatDiGruppo c = new ChatDiGruppo(p, m);
		
		//System.out.println(c.caricaMessaggio(m));
		
		ArrayList<Messaggio> res = c.ottieniListaTuttiMessaggi();
		for(Messaggio msg : res) { 
				System.out.println(msg.toString());
			}
		
		//c.leggiMessaggiDiGruppo(m);
		
	}
}
