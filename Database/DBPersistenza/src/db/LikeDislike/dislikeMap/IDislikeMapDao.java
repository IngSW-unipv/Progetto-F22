package db.LikeDislike.dislikeMap;

import java.util.ArrayList;

public interface IDislikeMapDao {

	public boolean carica(String profilo,String post);
	public boolean rimuovi(String profilo, String post);
	public ArrayList<String> cerca(String profilo, String post);
}
