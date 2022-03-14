package post.multimedia.video;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import post.Post;
import post.multimedia.Multimedia;

public class Video extends Multimedia{

	public Video(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione,
			String percorso,boolean isStory, int durataInSecondi) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile,
				profilo, tempoCancellazione, percorso, isStory);
		this.durataInSecondi = durataInSecondi;
	}

	private int durataInSecondi;
	
 
	public int getDurataInSecondi() {
		return durataInSecondi;
	}

	public void setDurataInSecondi(int durataInSecondi) {
		this.durataInSecondi = durataInSecondi;
	}

	
	//L'int passato da tastiera indica il numero di ore in cui vogliamo che la storia rimanga

	public boolean settaDurataStoria(int time, Video p) {
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
		return super.toString() + ", durataInSecondi = " + durataInSecondi + "]";
	}

	@Override
	public boolean settaDurataStoria(int tempo, Post p) {
		// TODO Auto-generated method stub
		return false;
	}


	
}
