package db.messaggioPrivato;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;

public interface IMessaggioPrivatoDao {
	public ArrayList<Messaggio> selectAll();
	public boolean scriviMessaggioPrivato(Messaggio m);
	public boolean inserisciChiavi(Messaggio m, String pInv, String pRic);
	public boolean rimuoviMessaggioPrivato(Messaggio m);
	public ArrayList<Messaggio> cercaMessaggioPrivato(Messaggio m);
	public ArrayList<MessaggioPrivato> selectAllNomeProfilo(MessaggioPrivato m);
	public void ottieniMessaggio(Messaggio m);
}
