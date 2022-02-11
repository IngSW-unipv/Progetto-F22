package it.unipv.ings.Testo;

import java.util.ArrayList;

public interface ITestoDao {
  
	public ArrayList<Testo> selectAll();
	public boolean pubblicaTesto(Testo t);
	public boolean inserisciChiavi(Testo t);
	public boolean rimuoviTesto(Testo t);
}
