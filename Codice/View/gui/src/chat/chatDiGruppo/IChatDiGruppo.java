package chat.chatDiGruppo;

import java.util.ArrayList;

import Messaggio.MessaggioDiGruppo;



public interface IChatDiGruppo {

	public boolean scriviMessaggio(MessaggioDiGruppo m);
	public boolean eliminaMessaggio(MessaggioDiGruppo m);
	public ArrayList<MessaggioDiGruppo> cercaMessaggio(MessaggioDiGruppo m);
	
	//Legge tutti i messaggi una sola volta
	public ArrayList<MessaggioDiGruppo> selectAll();
	
	//Legge tutti i messaggi di un idGruppo specificato
	public ArrayList<MessaggioDiGruppo> selectAllIdGruppo(MessaggioDiGruppo m);
	
	//Legge tutti i messaggi ogni cinque minuti
	public void selectAllRipetuto();
	
	public boolean inserisciChiavi(MessaggioDiGruppo m);
	
	public void ottieniTesto(MessaggioDiGruppo m);
}
