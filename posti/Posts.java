package posti;

import java.sql.Date;
import java.sql.Time;

public abstract class Posts implements IPost {
	
	private String postID; //Verificazione dal database
	private int numLike;
	private int numDislike;
	private boolean condivisibile;
	private Date data;
	private Time ora;
	private boolean visibile;
	
	
	// Getters & setters
	public String getPostID() {
		return postID;
	}
	public int getNumLike() {
		return numLike;
	}
	public int getNumDislike() {
		return numDislike;
	}
	public boolean isCondivisibile() {
		return condivisibile;
	}
	public Date getData() {
		return data;
	}
	public Time getOra() {
		return ora;
	}
	public boolean isVisibile() {
		return visibile;
	}
	
	public void setPostID(String posterID) {
		this.postID = posterID;
	}
	public void setNumLike(int countLike) {
		this.numLike = countLike;
	}
	public void setNumDislike(int countDislike) {
		this.numDislike = countDislike;
	}
	public void setCondivisibile(boolean condivisibile) {
		this.condivisibile = condivisibile;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public void setOra(Time ora) {
		this.ora = ora;
	}
	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	public void aggiungiPost(Posts p) {
		// TODO Auto-generated method stub
		
	}
	

}
