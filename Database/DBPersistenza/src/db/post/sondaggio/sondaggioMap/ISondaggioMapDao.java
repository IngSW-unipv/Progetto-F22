package db.post.sondaggio.sondaggioMap;

import java.util.ArrayList;

public interface ISondaggioMapDao {

	public boolean carica(String profilo, String sondaggio);
	public ArrayList<String> cerca(String profilo,String sondaggio);
}
