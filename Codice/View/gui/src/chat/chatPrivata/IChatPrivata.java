package chat.chatPrivata;

import java.util.ArrayList;

import Messaggio.MessaggioPrivato;


public interface IChatPrivata {
	public boolean scriviMessaggio(MessaggioPrivato m);
	public boolean eliminaMessaggio(MessaggioPrivato m);
	public ArrayList<MessaggioPrivato> cercaMessaggio(MessaggioPrivato m);
	
	//Legge tutti i messaggi una sola volta
	public ArrayList<MessaggioPrivato> selectAll();
	
	//Legge tutti i messaggi di un idProfilo specificato
	public ArrayList<MessaggioPrivato> selectAllNomeProfilo(MessaggioPrivato m);
	
	//Legge tutti i messaggi ogni cinque minuti
	public void selectAllRipetuto();
}