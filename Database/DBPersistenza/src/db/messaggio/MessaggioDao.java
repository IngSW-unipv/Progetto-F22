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
	public abstract ArrayList<MessaggioDB> selezionaMessaggi(String s1, String s2);
	@Override
	public abstract ArrayList<String> ottieniTestoListaMessaggi(String s1, String s2);
	public ArrayList<String> caricaMessaggiChatConProfiloInviante(String idGruppo) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
