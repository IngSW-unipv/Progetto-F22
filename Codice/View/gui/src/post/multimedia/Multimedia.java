package post.multimedia;

import java.sql.Date;
import java.sql.Time;

import post.Post;

public abstract class Multimedia extends Post implements IMultimedia{

	public Multimedia(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione, String percorso, boolean isStory) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile,
				profilo);
		this.tempoCancellazione = 0;
		this.percorso = percorso;
		this.isStory = false;
	}
	private int tempoCancellazione;
    private String percorso;
    private boolean isStory;
	public String getPercorso() {
		return percorso;
	}
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	public int getTempoCancellazione() {
		return tempoCancellazione;
	}
	public void setTempoCancellazione(int tempoCancellazione) {
		this.tempoCancellazione = tempoCancellazione;
	}
	public boolean isStory() {
		return isStory;
	}
	public void setStory(boolean isStory) {
		this.isStory = isStory;
	}
	
	
}
