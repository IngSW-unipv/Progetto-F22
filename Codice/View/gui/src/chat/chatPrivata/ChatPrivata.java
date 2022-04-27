package chat.chatPrivata;


import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;
import chat.Chat;
import chat.enumeration.TipoChat;


public class ChatPrivata extends Chat {
	
	public ChatPrivata(String nomeChat) {
		super(nomeChat);
	}
	
	public void aggiungiAllaLista(MessaggioPrivato m) {
		ArrayList<Messaggio> res = super.getListaMessaggi();
		res.add(m);
		super.setListaMessaggi(res);
	}

	@Override
	public TipoChat getTipo() {
		return TipoChat.PRIVATA;
	}

	

}


	


