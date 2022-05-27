package db.post.sondaggio;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;

public abstract class SondaggioDB extends PostDB{

	public SondaggioDB(String idPost, Date dataPubblicazione, Time oraPubblicazione,
			String descrizione,int numLike,int numDislike, boolean visibile, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta) {
		
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo);
		this.primaScelta = primaScelta;
		this.secondaScelta = secondaScelta;
	}
	
	private String primaScelta;
	private String secondaScelta;
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
		return super.toString() + ", primaScelta=" + primaScelta + ", secondaScelta=" + secondaScelta ;
	}
}
