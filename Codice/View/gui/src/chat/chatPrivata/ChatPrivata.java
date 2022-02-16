package chat.chatPrivata;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Profilo.Profilo;
import chat.Chat;

public class ChatPrivata extends Chat{

	private Messaggio m;
	private Profilo profiloInviante;
	private Profilo profiloRicevente;
	
	public ChatPrivata(Profilo profiloAttivo, Messaggio m, Profilo profiloInviante, Profilo profiloRicevente) {
		super(profiloAttivo);
		this.m = m;
		this.profiloInviante = profiloAttivo;
		this.profiloRicevente = profiloRicevente;
	}
	
	@Override
	public boolean scriviMessaggio(Messaggio m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean eliminaMessaggio(Messaggio m) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public ArrayList<Messaggio> cercaMessaggio(Messaggio m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Messaggio> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
