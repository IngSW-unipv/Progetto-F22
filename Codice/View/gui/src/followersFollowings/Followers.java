package followersFollowings;

import java.util.ArrayList;

import profilo.Profilo;

public class Followers {
	
	private ArrayList<Profilo> followers;
	
	public Followers() {
		this.setFollowers(new ArrayList<>());
	}
	
	

	public ArrayList<Profilo> getFollowers() {
		return followers;
	}

	public void setFollowers(ArrayList<Profilo> followers) {
		this.followers = followers;
	}

}
