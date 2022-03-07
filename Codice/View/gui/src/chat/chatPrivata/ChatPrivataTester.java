package chat.chatPrivata;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;
import db.profilo.ProfiloDB;
import profilo.EnumProfilo;
//import chat.Chat;
import profilo.Profilo;
import profilo.utility.ProfiloUtility;

public class ChatPrivataTester {

	public static void main(String[] args) {
		
		MessaggioPrivato m = new MessaggioPrivato("M011", null, null, "Buonasera", null, "001", "002");
		
		ProfiloUtility u = new ProfiloUtility();
		Profilo p = new Profilo("004", null, null, 0, 0, 0, EnumProfilo.PRIVATO, null, null, null, null);
		ProfiloDB pdb = u.convertiAProfiloDB(p);
		ChatPrivata c = new ChatPrivata(p, m);
		
		System.out.println(pdb.toString());
		
	//	System.out.println(c.caricaMessaggio(m));
		
		ArrayList<Messaggio> sall = c.ottieniListaTuttiMessaggi();
          for(Messaggio msg1 : sall)
			System.out.println(msg1.toString());
		

		/*ArrayList<Messaggio> cmess = c.cercaMessaggio(m);
        for(Messaggio msg : cmess)
			System.out.println(msg.toString());*/
        
		//c.ottieniMessaggio(m);
		
		//c.leggiTuttiMessaggi();
		//c.leggiMessaggiPrivati(m);
	}	
}
