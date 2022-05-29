package db.post.sondaggio.sondaggiosceltamultipla;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;
import db.post.sondaggio.SondaggioDB;


public class SondaggioSceltaMultiplaDB extends SondaggioDB{

	public SondaggioSceltaMultiplaDB(String idPost, Date dataPubblicazione, Time oraPubblicazione,
			String descrizione,int numLike, int numDislike, boolean visibile, String profilo,
			String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta,int count1s,int count2s, int count3s, int count4s) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,profilo,
				primaScelta,secondaScelta,count1s,count2s);
		
		this.terzaScelta = terzaScelta;
		this.quartaScelta = quartaScelta;
	}
	
	private String terzaScelta;
	private String quartaScelta;
	private int coun3s;
	private int count4s;
	
	public String getTerzaScelta() {
		return terzaScelta;
	}
	public void setTerzaScelta(String terzaScelta) {
		this.terzaScelta = terzaScelta;
	}
	public String getQuartaScelta() {
		return quartaScelta;
	}
	public void setQuartaScelta(String quartaScelta) {
		this.quartaScelta = quartaScelta;
	}
	@Override
	public String toString() {
		return super.toString() + " terzaScelta=" + terzaScelta + ", quartaScelta=" + quartaScelta + ", coun3s="
				+ coun3s + ", count4s=" + count4s + "]";
	}
	@Override
	public PostDB inserisciCaratteristiche(PostDB p) {
		SondaggioSceltaMultiplaDB sdb = new SondaggioSceltaMultiplaDB(p.getIdPost(), p.getDataPubblicazione(), p.getOraPubblicazione(), p.getDescrizione(),p.getNumLike(),p.getNumDislike(), p.isVisibile(), p.getProfilo(), this.getPrimaScelta(), this.getPrimaScelta(), this.getTerzaScelta(), this.getQuartaScelta(),this.getCount1s(),this.getCount2s(),this.getCoun3s(),this.getCount4s());
		return sdb;
	}
	public int getCoun3s() {
		return coun3s;
	}
	public void setCoun3s(int coun3s) {
		this.coun3s = coun3s;
	}
	public int getCount4s() {
		return count4s;
	}
	public void setCount4s(int count4s) {
		this.count4s = count4s;
	}
}
