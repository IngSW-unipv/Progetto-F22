package db.messaggio.messaggioPrivato;

import java.util.ArrayList;



public interface IMessaggioPrivatoDao {
	public ArrayList<MessaggioPrivatoDB> selectAllNomeProfilo(MessaggioPrivatoDB m);
	public String ottieniMessaggio(String m);
}
