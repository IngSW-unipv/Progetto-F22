package db.post.sondaggio.sondaggiosceltamultipla;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;
import db.post.sondaggio.SondaggioDB;


public class SondaggioSceltaMultiplaDB extends SondaggioDB{

	public SondaggioSceltaMultiplaDB(String idPost, Date dataPubblicazione, Time oraPubblicazione,
			String descrizione,int numLike, int numDislike, boolean visibile, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo,
				primaScelta,secondaScelta);
		
		this.terzaScelta = terzaScelta;
		this.quartaScelta = quartaScelta;
	}
	
	private String terzaScelta;
	private String quartaScelta;
	
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
		return super.toString() + ", quartaScelta=" + quartaScelta + "]";
	}
	@Override
	public PostDB inserisciCaratteristiche(PostDB p) {
		SondaggioSceltaMultiplaDB sdb = new SondaggioSceltaMultiplaDB(p.getIdPost(), p.getDataPubblicazione(), p.getOraPubblicazione(), p.getDescrizione(),p.getNumLike(),p.getNumDislike(), p.isVisibile(), p.isCondivisibile(), p.getProfilo(), this.getPrimaScelta(), this.getPrimaScelta(), this.getTerzaScelta(), this.getQuartaScelta());
		return sdb;
	}
}
