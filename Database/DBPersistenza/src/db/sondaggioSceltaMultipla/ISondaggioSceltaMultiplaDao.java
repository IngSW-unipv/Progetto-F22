package db.sondaggioSceltaMultipla;

import java.util.ArrayList;


public interface ISondaggioSceltaMultiplaDao {

	public ArrayList<SondaggioSceltaMultiplaDB> selectAll();
	public boolean pubblicaSondaggio(SondaggioSceltaMultiplaDB s);
	public boolean rimuoviSondaggio(SondaggioSceltaMultiplaDB p);
}
