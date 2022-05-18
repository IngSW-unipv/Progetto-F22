package convertitore.followUtility;

import java.util.ArrayList;

import db.follow.FollowDB;
import profilo.follow.Follow;

public class FollowUtility {

	public ArrayList<Follow> convertiLista(ArrayList<FollowDB> res){
		ArrayList<Follow> f = new ArrayList<>();
		for(FollowDB fdb : res)
			f.add(this.convertiInverso(fdb));
		return f;
	}
	
	public FollowDB converti(Follow f) {
		FollowDB fdb = new FollowDB(f.getMailProfiloPersonale(), f.getMailProfiloSeguito());
		return fdb;
	}
    public Follow convertiInverso(FollowDB f) {
    	Follow fdb = new Follow(f.getProfiloPersonale(), f.getProfiloSeguito());
    	return fdb;
    }

}

