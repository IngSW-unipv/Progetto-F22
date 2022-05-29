package db.post.sondaggio;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;

public abstract class SondaggioDB extends PostDB{

	public SondaggioDB(String idPost, Date dataPubblicazione, Time oraPubblicazione,
			String descrizione,int numLike,int numDislike, boolean visibile, String profilo,
			String primaScelta, String secondaScelta, int count1s,int count2s) {
		
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,profilo);
		this.primaScelta = primaScelta;
		this.secondaScelta = secondaScelta;
		this.count1s = count1s;
		this.count2s = count2s;
	}
	
	private String primaScelta;
	private String secondaScelta;
	private int count1s;
	private int count2s;
	public String getPrimaScelta() {
		return primaScelta;
	}
	public void setPrimaScelta(String primaScelta) {
		this.primaScelta = primaScelta;
	}
	public String getSecondaScelta() {
		return secondaScelta;
	}
	public void setSecondaScelta(String secondaScelta) {
		this.secondaScelta = secondaScelta;
	}
	@Override
	public String toString() {
		return super.toString() + ", primaScelta=" + primaScelta + ", secondaScelta=" + secondaScelta + ", count1s=" + count1s + ", count2s=" + count2s ;
	}
	public int getCount1s() {
		return count1s;
	}
	public void setCount1s(int count1s) {
		this.count1s = count1s;
	}
	public int getCount2s() {
		return count2s;
	}
	public void setCount2s(int count2s) {
		this.count2s = count2s;
	}
}
