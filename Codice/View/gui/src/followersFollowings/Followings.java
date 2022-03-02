package followersFollowings;

import java.util.ArrayList;

import profilo.Profilo;

public class Followings {

	private ArrayList<Profilo> followings;
	
	
	
	public Followings() {
		this.setFollowings(new ArrayList<>());
	}
	
	

	public ArrayList<Profilo> getFollowings() {
		return followings;
	}

	public void setFollowings(ArrayList<Profilo> followings) {
		this.followings = followings;
	}
}
