package chat.chatPrivata;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;
//import chat.Chat;

public class ChatPrivataTester {

	public static void main(String[] args) {
		
		MessaggioPrivato m = new MessaggioPrivato("001", null, null, "Buonasera", null, null, "002");
		ChatPrivata c = new ChatPrivata(null);
		
		ArrayList<Messaggio> sall = c.selectAll();
          for(Messaggio p : sall)
			System.out.println(p.toString());
		

		/*ArrayList<Messaggio> cmess = c.cercaMessaggio(m);
        for(Messaggio msg : cmess)
			System.out.println(msg.toString());*/
        
		//c.ottieniMessaggio(m);
		
		//System.out.println(c.caricaMessaggio(m));
		
		//c.leggiTuttiMessaggi();
		c.leggiMessaggiPrivati(m);
	}	
}
