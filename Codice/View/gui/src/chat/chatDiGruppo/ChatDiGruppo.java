package chat.chatDiGruppo;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.Chat;
import chat.chatDiGruppo.gruppo.Gruppo;
import chat.enumeration.TipoChat;
import db.facade.DbFacade;



public class ChatDiGruppo extends Chat{

	private Gruppo g;
	public ChatDiGruppo(String nomeChat, Gruppo g) {
		super(nomeChat);
		this.g = g;
		this.setLista(g, null, TipoMessaggio.DIGRUPPO);
	}

	@Override
	public TipoChat getTipo() {
		return TipoChat.DIGRUPPO;
	}

	public boolean setLista(Gruppo g, String s, TipoMessaggio t) {
		ArrayList<Messaggio> res = DbFacade.getIstance().selezionaMessaggi(g.getIdGruppo(), s, t);
		super.setListaMessaggi(res);
		return true;
	}

	public Gruppo getG() {
		return g;
	}

	public void setG(Gruppo g) {
		this.g = g;
	}

	@Override
	public String toString() {
		return super.toString() + " g=" + g + "]";
	}
}
		
	


