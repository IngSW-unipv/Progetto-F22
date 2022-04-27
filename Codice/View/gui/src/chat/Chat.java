package chat;


import java.util.ArrayList;

import Messaggio.Messaggio;
import chat.enumeration.TipoChat;

public abstract class Chat {

	private String nomeChat;
	private int numeroMessaggi;
	private ArrayList<Messaggio> listaMessaggi;
	
	public Chat(String nomeChat) {
		this.nomeChat = nomeChat;
		this.numeroMessaggi = 0;
		listaMessaggi = new ArrayList<>();
	}

	public String getNomeChat() {
		return nomeChat;
	}

	public void setNomeChat(String nomeChat) {
		this.nomeChat = nomeChat;
	}

	public int getNumeroMessaggi() {
		return numeroMessaggi;
	}

	public void setNumeroMessaggi(int numeroMessaggi) {
		this.numeroMessaggi = numeroMessaggi;
	}

	public ArrayList<Messaggio> getListaMessaggi() {
		return listaMessaggi;
	}

	public void setListaMessaggi(ArrayList<Messaggio> listaMessaggi) {
		this.listaMessaggi = listaMessaggi;
	}

	@Override
	public String toString() {
		return "Chat [nomeChat=" + nomeChat + ", numeroMessaggi=" + numeroMessaggi + ", listaMessaggi=" + listaMessaggi
				+ "]";
	}
	
	public void aggiungiAllaLista(Messaggio m) {
		ArrayList<Messaggio> res = this.getListaMessaggi();
		res.add(m);
		this.setListaMessaggi(res);
	}
	
	public void rimuoviDallaLista(Messaggio m) {
		ArrayList<Messaggio> res = this.getListaMessaggi();
		res.remove(m);
		this.setListaMessaggi(res);
	}
	
	public abstract TipoChat getTipo();
}
