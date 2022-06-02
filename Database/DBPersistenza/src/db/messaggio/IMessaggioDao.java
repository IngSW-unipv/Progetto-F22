package db.messaggio;



import java.util.ArrayList;
import db.profilo.ProfiloDB;


public interface IMessaggioDao {

	public boolean scriviMessaggio(MessaggioDB m);

	public boolean inserisciChiavi(MessaggioDB m,String s1, String s2);
	
	public boolean rimuoviMessaggio(MessaggioDB m);
	
	public MessaggioDB cercaMessaggio(MessaggioDB m);
	
	public String ottieniTestoMessaggio(String m);
	
	
	//Seleziona tutti i messaggi inviati da un gruppo o una persona specificata
	public ArrayList<MessaggioDB> selezionaMessaggi(String s1, String s2);
	
	public ArrayList<String> ottieniTestoListaMessaggi(String s1, String s2);
	
	
	//Seleziona tutti i messaggi di un profilo specificato
	public ArrayList<MessaggioDB> selezionaMessaggiProfilo(ProfiloDB p);
	public ArrayList<String> selezionaTestoMessaggiProfilo(ProfiloDB p);

	ArrayList<MessaggioDB> caricaMessaggiChatPrivata(String inviante, String ricevente);
}
