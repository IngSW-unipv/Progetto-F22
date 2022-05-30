package db.post.sondaggio.sondaggioMap1;

import java.util.ArrayList;

public interface ISondaggioMap1Dao {

	public boolean carica(String profilo, String sondaggio);
	public ArrayList<String> cerca(String profilo,String sondaggio);
}
