package convertitore.followUtility;

import db.follow.FollowDB;
import profilo.follow.Follow;

public class FollowUtility {

	public FollowDB convertiAFollowDB(Follow f) {
		FollowDB fdb = new FollowDB(f.getMailProfiloPersonale(), f.getMailProfiloSeguito());
		return fdb;
	}
    public Follow convertiAFollow(FollowDB f) {
    	Follow fdb = new Follow(f.getProfiloPersonale(), f.getProfiloSeguito());
    	return fdb;
    }

}

