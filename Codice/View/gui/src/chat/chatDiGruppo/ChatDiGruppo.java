package chat.chatDiGruppo;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.Chat;
import chat.enumeration.TipoChat;
import db.facade.DbFacade;



public class ChatDiGruppo extends Chat{

	public ChatDiGruppo(String nomeChat) {
		super(nomeChat);
	}

	@Override
	public TipoChat getTipo() {
		return TipoChat.DIGRUPPO;
	}

	public boolean setLista(String idGruppo, String nuull, TipoMessaggio t) {
		ArrayList<Messaggio> res = DbFacade.getIstance().selezionaMessaggi(idGruppo, nuull, t);
		super.setListaMessaggi(res);
		return true;
	}
}
		
	


