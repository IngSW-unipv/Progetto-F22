package chat;

import java.util.ArrayList;

import Messaggio.Messaggio;
import chat.chatDiGruppo.ChatDiGruppo;
import chat.chatDiGruppo.gruppo.Gruppo;
import chat.chatPrivata.ChatPrivata;
import profilo.Profilo;

public class ChatTester {

	public static void main(String[] args) {
		Profilo p1 = new Profilo("Davide99",null);
		Profilo p2 = new Profilo("DV999",null);
		Gruppo g = new Gruppo("G00", null, null, null, null, null, null, null, null);
		Chat c = new ChatPrivata("CavalliPazzi", p1, p2);
		Chat c1 = new ChatDiGruppo("Galline", g);
		
		ArrayList<Messaggio> msg = c.getListaMessaggi();
		for(Messaggio m : msg)
			System.out.println(m.toString());
		
		ArrayList<Messaggio> grp = c1.getListaMessaggi();
		for(Messaggio mess : grp)
			System.out.println(mess.toString());
	}
}
