package chat;

import Profilo.Profilo;

import java.util.ArrayList;

import Messaggio.Messaggio;

public abstract class Chat {

	private Profilo profiloAttivo;
	ArrayList <Messaggio> messaggi;
	
	public Chat(Profilo profiloAttivo) {
		this.profiloAttivo = profiloAttivo;
		messaggi = new ArrayList<>();
	}

	public Profilo getProfiloAttivo() {
		return profiloAttivo;
	}

	public void setProfiloAttivo(Profilo profiloAttivo) {
		this.profiloAttivo = profiloAttivo;
	}

	public ArrayList<Messaggio> getMessaggi() {
		return messaggi;
	}

	public void setMessaggi(ArrayList<Messaggio> messaggi) {
		this.messaggi = messaggi;
	}
	
	
	
}
