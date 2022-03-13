package db.messaggioPrivato;

import java.util.ArrayList;



public interface IMessaggioPrivatoDao {
	public ArrayList<MessaggioPrivatoDB> selectAll();
	public boolean scriviMessaggioPrivato(MessaggioPrivatoDB m);
	public boolean rimuoviMessaggioPrivato(MessaggioPrivatoDB m);
	public ArrayList<MessaggioPrivatoDB> cercaMessaggioPrivato(MessaggioPrivatoDB m);
	public ArrayList<MessaggioPrivatoDB> selectAllNomeProfilo(MessaggioPrivatoDB m);
	public void ottieniMessaggio(MessaggioPrivatoDB m);
}
