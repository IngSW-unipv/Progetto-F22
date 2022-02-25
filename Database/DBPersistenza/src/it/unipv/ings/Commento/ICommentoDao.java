package it.unipv.ings.Commento;

import java.util.ArrayList;

import post.commento.Commento;

public interface ICommentoDao {

	public boolean scriviCommento(Commento c);
	public boolean rimuoviCommento(Commento c);
	public ArrayList<Commento> mostraCommentiSottoPost(Commento c);
}
