package it.unipv.ings.Commento;

import java.util.ArrayList;

public interface ICommentoDao {

	public boolean scriviCommento(Commento c);
	public boolean rimuoviCommento(Commento c);
	public ArrayList<Commento> cercaProfilo(Commento c);
}
