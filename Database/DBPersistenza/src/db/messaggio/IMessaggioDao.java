package db.messaggio;

import java.util.ArrayList;

public interface IMessaggioDao {

	public boolean scriviMessaggio(MessaggioDB m);

	public boolean inserisciChiavi(MessaggioDB m,String s1, String s2);
	
	public boolean rimuoviMessaggio(MessaggioDB m);
	
	public ArrayList<MessaggioDB> cercaMessaggio(String s);
	
	public String ottieniTestoMessaggio(String m);
	
	
	//Seleziona tutti i messaggi inviati da un gruppo o una persona specificata
	public ArrayList<MessaggioDB> selezionaMessaggi(String s);
	
	public ArrayList<String> ottieniTestoListaMessaggi(String s);
	
}
