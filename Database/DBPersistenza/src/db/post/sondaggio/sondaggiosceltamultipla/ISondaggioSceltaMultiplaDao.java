package db.post.sondaggio.sondaggiosceltamultipla;

import java.util.ArrayList;


public interface ISondaggioSceltaMultiplaDao {

	public ArrayList<SondaggioSceltaMultiplaDB> selectAll();
	public boolean pubblicaSondaggio(SondaggioSceltaMultiplaDB s);
	public boolean rimuoviSondaggio(SondaggioSceltaMultiplaDB p);
	public ArrayList<SondaggioSceltaMultiplaDB> cerca(String s);
}
