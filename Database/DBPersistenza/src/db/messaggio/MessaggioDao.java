package db.messaggio;

import java.util.ArrayList;

public abstract class MessaggioDao implements IMessaggioDao{

	public abstract boolean scriviMessaggio(MessaggioDB m);

	public abstract boolean inserisciChiavi(MessaggioDB m,String s1, String s2);
	
	public abstract boolean rimuoviMessaggio(MessaggioDB m);
	
	public abstract ArrayList<MessaggioDB> cercaMessaggio(String s);
	
	public abstract String ottieniTestoMessaggio(String m);

	public abstract ArrayList<MessaggioDB> selezionaMessaggi(String s);
	
	public abstract ArrayList<String> ottieniTestoListaMessaggi(String s);
	
}
