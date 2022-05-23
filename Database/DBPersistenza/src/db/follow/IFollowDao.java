package db.follow;

import java.util.ArrayList;

public interface IFollowDao {

	public boolean carica(FollowDB f);
	public boolean rimuovi(FollowDB f);
	public ArrayList<FollowDB> selectAll();
	
	//Mostra tutti i follower di un profilo personale indicato
	public ArrayList<String> cercaProfSeguito(String profiloPersonale);
	
	public FollowDB cerca(FollowDB fdb);
}
