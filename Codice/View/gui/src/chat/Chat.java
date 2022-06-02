package chat;


import java.util.ArrayList;
import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.enumeration.TipoChat;


public abstract class Chat {

	private String nomeChat;
	private ArrayList<Messaggio> listaMessaggi;
	
	public Chat(String nomeChat) {
		this.nomeChat = nomeChat;
		listaMessaggi = new ArrayList<>();
	}


	@Override
	public String toString() {
		return "Chat [nomeChat=" + nomeChat + ", listaMessaggi=" + listaMessaggi
				+ "]";
	}
	
	public abstract TipoChat getTipo();
	public abstract boolean setLista(String idGruppo, String nuull, TipoMessaggio t);

	
	public String getNomeChat() {
		return nomeChat;
	}

	public void setNomeChat(String nomeChat) {
		this.nomeChat = nomeChat;
	}

	public ArrayList<Messaggio> getListaMessaggi() {
		return listaMessaggi;
	}

	public void setListaMessaggi(ArrayList<Messaggio> listaMessaggi) {
		this.listaMessaggi = listaMessaggi;
	}
	
}
