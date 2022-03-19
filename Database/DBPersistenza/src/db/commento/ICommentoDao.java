package db.commento;

import java.util.ArrayList;

public interface ICommentoDao {

	public boolean scriviCommento(CommentoDB c);
	public boolean rimuoviCommento(CommentoDB c);
	public ArrayList<CommentoDB> mostraCommentiSottoPost(CommentoDB c);
	public ArrayList<CommentoDB> cercaCommento(String c);
}
