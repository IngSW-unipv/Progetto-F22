package db.post.multimedia;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;

public abstract class MultimediaDB extends PostDB{

	public MultimediaDB(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,visibile,condivisibile,profilo);
		this.tempoCancellazione = 0;
		this.percorso = percorso;
		this.isStory = false;
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
		return super.toString() + ", tempoCancellazione=" + tempoCancellazione + ", percorso=" + percorso + ", isStory="
				+ isStory ;
	}

}
