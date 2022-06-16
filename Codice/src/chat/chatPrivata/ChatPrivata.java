package chat.chatPrivata;


import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.Chat;
import chat.enumeration.TipoChat;
import db.facade.DbFacade;
import profilo.Profilo;


public class ChatPrivata extends Chat {
	
	private Profilo profiloInviante;
	private Profilo profiloRicevente;
	
	public ChatPrivata(String nomeChat,Profilo profiloInviante, Profilo profiloRicevente) {
		super(nomeChat);
		this.profiloInviante = profiloInviante;
		this.profiloRicevente = profiloRicevente;
		this.setLista(profiloInviante, profiloRicevente, TipoMessaggio.PRIVATO);
	}
	
	/**
	 * Setta la lista con i messaggi Privati inviati un una chat
	 * @param email del profilo che invia il messaggio
	 * @param email del profilo che riceve il messaggio
	 * @param tipo privato del messaggio
	 */
	public boolean setLista(Profilo Inviante, Profilo profiloRicevente, TipoMessaggio t) {
		ArrayList<Messaggio> res = DbFacade.getIstance().selezionaMessaggi(profiloInviante.getIdProfilo(), profiloRicevente.getIdProfilo(), t);
		super.setListaMessaggi(res);
		return true;
	}

	@Override
	public TipoChat getTipo() {
		return TipoChat.PRIVATA;
	}

	public Profilo getProfiloInviante() {
		return profiloInviante;
	}

	public void setProfiloInviante(Profilo profiloInviante) {
		this.profiloInviante = profiloInviante;
	}

	public Profilo getProfiloRicevente() {
		return profiloRicevente;
	}

	public void setProfiloRicevente(Profilo profiloRicevente) {
		this.profiloRicevente = profiloRicevente;
	}

	@Override
	public String toString() {
		return super.toString() + " profiloInviante=" + profiloInviante + ", profiloRicevente=" + profiloRicevente + "]";
	}
}


	


