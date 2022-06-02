package chat.chatPrivata;


import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.Chat;
import chat.enumeration.TipoChat;
import db.facade.DbFacade;


public class ChatPrivata extends Chat {
	
	public ChatPrivata(String nomeChat) {
		super(nomeChat);
	}
	
	public boolean setLista(String profiloInviante, String profiloRicevente, TipoMessaggio t) {
		ArrayList<Messaggio> res = DbFacade.getIstance().selezionaMessaggi(profiloInviante, profiloRicevente, t);
		super.setListaMessaggi(res);
		return true;
	}

	@Override
	public TipoChat getTipo() {
		return TipoChat.PRIVATA;
	}

	

}


	


