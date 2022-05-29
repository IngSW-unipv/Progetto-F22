package db.LikeDislike.LikeMap;

import java.util.ArrayList;

public interface ILikeMapDao {

	public boolean carica(String profilo, String post);
	public boolean rimuovi(String profilo, String post);
	public ArrayList<String> cerca(String profilo, String post);
}
