package chat;

import java.util.ArrayList;

import Messaggio.Messaggio;

public interface IChat {

	public boolean scriviMessaggio(Messaggio m);
	public boolean eliminaMessaggio(Messaggio m);
	public ArrayList<Messaggio> cercaMessaggio(Messaggio m);
	public ArrayList<Messaggio> selectAll();
}
