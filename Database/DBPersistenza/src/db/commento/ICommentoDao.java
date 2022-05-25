package db.commento;

import java.util.ArrayList;

import db.profilo.ProfiloDB;

public interface ICommentoDao {

	public boolean scriviCommento(CommentoDB c);
	public boolean rimuoviCommento(CommentoDB c);
	public CommentoDB cercaCommento(CommentoDB c);
	
	//Restituisce una lista con l'idProfilo, il nickname e l'idCommento di un profilo specificato
	public ArrayList<String> ProfiloNickCommento(ProfiloDB p);

}
