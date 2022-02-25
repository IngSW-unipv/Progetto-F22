package chat.chatPrivata;

import Messaggio.MessaggioPrivato;

public class ChatPrivataTester {

	public static void main(String[] args) {
		
		ChatPrivata p = new ChatPrivata();
		MessaggioPrivato m = new MessaggioPrivato("002", null, null, "Buonasera", null, null, null);
		
		
		p.ottieniTesto(m);
		
		//System.out.println(p.scriviMessaggio(m));
		
		//p.selectAllRipetuto();
	}	
}
