package db.follow;

import java.util.ArrayList;

public interface IFollowDao {

	public boolean carica(FollowDB f);
	public boolean rimuovi(String s1, String s2);
	public ArrayList<FollowDB> selectAll();
	public ArrayList<String> cercaProfSeguito(String profiloPersonale);
	public ArrayList<FollowDB> cerca(String profiloPersonale, String profiloSeguito);
}
