package db.post.multimedia;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;

public abstract class MultimediaDB extends PostDB{

	public MultimediaDB(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,int numLike, int numDislike,
			boolean visibile, boolean condivisibile, String profilo,int tempoCancellazione, String percorso, boolean isStory) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo);
		this.tempoCancellazione = tempoCancellazione;
		this.percorso = percorso;
		this.isStory = isStory;
	}
	private int tempoCancellazione;
    private String percorso;
    private boolean isStory;
	public int getTempoCancellazione() {
		return tempoCancellazione;
	}
	public void setTempoCancellazione(int tempoCancellazione) {
		this.tempoCancellazione = tempoCancellazione;
	}
	public String getPercorso() {
		return percorso;
	}
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	public boolean isStory() {
		return isStory;
	}
	public void setStory(boolean isStory) {
		this.isStory = isStory;
	}
	@Override
	public String toString() {
		return ", tempoCancellazione=" + tempoCancellazione + ", percorso=" + percorso + ", isStory="
				+ isStory ;
	}
}
