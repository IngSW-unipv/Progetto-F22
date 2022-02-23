package it.unipv.ings.Profilo;

import java.util.ArrayList;

import Profilo.Profilo;

public interface IProfiloDao {
	public ArrayList<Profilo> selectAll();
	public boolean inserisciProfilo(Profilo p);
	public boolean inserisciChiavi(Profilo p);
	public boolean rimuoviProfilo(Profilo p);
	public ArrayList<Profilo> cercaProfilo(Profilo p);
}
