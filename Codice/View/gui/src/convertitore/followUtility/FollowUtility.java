package convertitore.followUtility;

import java.util.ArrayList;

import db.follow.FollowDB;
import profilo.follow.Follow;

public class FollowUtility {

	/**
	 * Converte una lista di FollowDB in una lista di Follow
	 * @param ArrayList di FollowDB, tipo utilizzabile solo nel databse
	 */
	public ArrayList<Follow> convertiLista(ArrayList<FollowDB> res){
		ArrayList<Follow> f = new ArrayList<>();
		for(FollowDB fdb : res)
			f.add(this.convertiInverso(fdb));
		return f;
	}
	
	 /**
		 * Converte un Follow in un FollowDB
		 * @param un oggetto di tipo Follow "reale"
		 */
	public FollowDB converti(Follow f) {
		FollowDB fdb = new FollowDB(f.getMailProfiloPersonale(), f.getMailProfiloSeguito());
		return fdb;
	}
	/**
	 * Converte un FollowDB in un Follow
	 * @param Oggetto di tipo Follow utilizzabile solo per eseguire le query
	 */
    public Follow convertiInverso(FollowDB f) {
    	Follow fdb = new Follow(f.getProfiloPersonale(), f.getProfiloSeguito());
    	return fdb;
    }

}

