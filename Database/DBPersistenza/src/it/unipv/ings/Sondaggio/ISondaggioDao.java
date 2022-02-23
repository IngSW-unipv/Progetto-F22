package it.unipv.ings.Sondaggio;

import java.util.ArrayList;

public interface ISondaggioDao {
	public ArrayList<SondaggioDB> selectAll();
	public boolean pubblicaSondaggio(SondaggioDB s);
	public boolean rimuoviSondaggio(SondaggioDB s);
}
