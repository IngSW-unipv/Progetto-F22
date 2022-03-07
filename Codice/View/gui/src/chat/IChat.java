package chat;
import java.util.ArrayList;

import Messaggio.Messaggio;
public interface IChat {

	public ArrayList<Messaggio> ottieniListaTuttiMessaggi();
	public ArrayList<Messaggio> cercaMessaggio(Messaggio m);
	public void ottieniMessaggio(Messaggio m);
	public boolean caricaMessaggio(Messaggio m);
	public boolean eliminaMessaggio(Messaggio m);
	
	//Legge tutti i messaggi ricevuti ogni minuto. Dopo 5 minuti smette di farlo e si stoppa
	public void leggiTuttiMessaggi();
	
 }
