package it.unipv.ings.Sondaggio;

import java.util.ArrayList;

public interface ISondaggioDao {
	public ArrayList<Sondaggio> selectAll();
	public boolean pubblicaSondaggio(Sondaggio s);
	public boolean inserisciChiavi(Sondaggio s);
	public boolean rimuoviSondaggio(Sondaggio s);
}
