package post.testo;

import it.unipv.ings.Testo.TestoDB;

public interface ITesto {

	public boolean pubblicaTesto(TestoDB t);
	public boolean rimuoviTesto(TestoDB t);
}
