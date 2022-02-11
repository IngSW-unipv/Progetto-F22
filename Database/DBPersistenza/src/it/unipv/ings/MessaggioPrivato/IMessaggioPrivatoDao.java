package it.unipv.ings.MessaggioPrivato;

import java.util.ArrayList;

public interface IMessaggioPrivatoDao {
	public ArrayList<MessaggioPrivato> selectAll();
	public boolean scriviMessaggioPrivato(MessaggioPrivato m);
	public boolean inserisciChiavi(MessaggioPrivato m);
	public boolean rimuoviMessaggioPrivato(MessaggioPrivato m);
	public ArrayList<MessaggioPrivato> cercaMessaggioPrivato(MessaggioPrivato m);
}
