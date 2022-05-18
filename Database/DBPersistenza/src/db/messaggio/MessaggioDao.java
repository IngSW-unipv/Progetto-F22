package db.messaggio;

import java.util.ArrayList;

public abstract class MessaggioDao implements IMessaggioDao{

	@Override
	public abstract boolean scriviMessaggio(MessaggioDB m);
	@Override
	public abstract boolean inserisciChiavi(MessaggioDB m,String s1, String s2);
	@Override
	public abstract boolean rimuoviMessaggio(MessaggioDB m);
	@Override
	public abstract MessaggioDB cercaMessaggio(MessaggioDB m);
	@Override
	public abstract String ottieniTestoMessaggio(String m);
	@Override
	public abstract ArrayList<MessaggioDB> selezionaMessaggi(String s);
	@Override
	public abstract ArrayList<String> ottieniTestoListaMessaggi(String s);
	
}
