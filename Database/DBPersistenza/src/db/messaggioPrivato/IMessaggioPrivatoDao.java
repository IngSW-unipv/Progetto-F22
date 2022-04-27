package db.messaggioPrivato;

import java.util.ArrayList;



public interface IMessaggioPrivatoDao {
	public boolean scriviMessaggioPrivato(MessaggioPrivatoDB m);
	public boolean rimuoviMessaggioPrivato(MessaggioPrivatoDB m);
	public ArrayList<MessaggioPrivatoDB> cercaMessaggioPrivato(String m);
	public ArrayList<MessaggioPrivatoDB> selectAllNomeProfilo(MessaggioPrivatoDB m);
	public String ottieniMessaggio(String m);
}
