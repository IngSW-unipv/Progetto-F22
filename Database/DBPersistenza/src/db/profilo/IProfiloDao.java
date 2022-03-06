package db.profilo;

import java.util.ArrayList;

public interface IProfiloDao {
	public ArrayList<ProfiloDB> selectAll();
	public boolean inserisciProfilo(ProfiloDB p);
	public boolean inserisciChiavi(ProfiloDB p);
	public boolean rimuoviProfilo(ProfiloDB p);
	public ArrayList<ProfiloDB> cercaProfilo(ProfiloDB p);
}
