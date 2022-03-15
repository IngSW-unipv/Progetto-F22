package post.multimedia.foto;

import java.sql.Date;
import java.sql.Time;
import post.Post;
import post.multimedia.Multimedia;

public class Foto extends Multimedia{

	public Foto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo,
			String percorso, boolean isHd) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione,visibile, condivisibile, profilo, percorso);
		this.isHd = isHd;
	}


	private boolean isHd;
	
	public boolean isHd() {
		return isHd;
	}

	public void setHd(boolean isHd) {
		this.isHd = isHd;
	}
	
	
	public boolean settaDurataStoria(int time, Foto f) {
		
		this.setStory(true);
		this.setTempoCancellazione(time);
		try {
		    Thread.sleep(time * 60 * 60 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		return true;
	}


	@Override
	public String toString() {
		return super.toString() + ", isHd = " + isHd + "]";
	}

	@Override
	public boolean settaDurataStoria(int tempo, Post p) {
		// TODO Auto-generated method stub
		return false;
	}
}
