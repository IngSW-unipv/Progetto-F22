package it.unipv.ings.MessaggioPrivato;

import java.util.ArrayList;

import Messaggio.MessaggioPrivato;

public interface IMessaggioPrivatoDao {
	public ArrayList<MessaggioPrivato> selectAll();
	public boolean scriviMessaggioPrivato(MessaggioPrivato m);
	public boolean inserisciChiavi(MessaggioPrivato m);
	public boolean rimuoviMessaggioPrivato(MessaggioPrivato m);
	public ArrayList<MessaggioPrivato> cercaMessaggioPrivato(MessaggioPrivato m);
	public ArrayList<MessaggioPrivato> selectAllNomeProfilo(MessaggioPrivato m);
}
