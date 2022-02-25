package post.commento;

import java.util.ArrayList;

public interface ICommento {

	public boolean scriviCommento(Commento c);
	public boolean rimuoviCommento(Commento c);
	public ArrayList<Commento> mostraCommentiSottoPost(Commento c);
	
}
