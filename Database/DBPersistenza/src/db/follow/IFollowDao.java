package db.follow;

import java.util.ArrayList;

public interface IFollowDao {

	public boolean carica(FollowDB f);
	public boolean rimuovi(FollowDB f);
	public ArrayList<FollowDB> selectAll();
	public ArrayList<String> cercaProfSeguito(String profiloPersonale);
	public ArrayList<FollowDB> cerca(String profiloPersonale, String profiloSeguito);
	//public ArrayList<String> vediFollower(String)
}
