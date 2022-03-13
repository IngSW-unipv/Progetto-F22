package post.multimedia.video;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import db.video.VideoDB;
import db.video.VideoDao;
import post.Post;
import post.multimedia.Multimedia;
import post.multimedia.video.utility.VideoUtility;

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
		this.caricaPost(p);
		try {
		    Thread.sleep(time * 60 * 60 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		this.rimuoviPost(p);
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", durataInSecondi = " + durataInSecondi + "]";
	}

	
	public ArrayList<VideoDB> selectAllVideo() {
		VideoDao vdao = new VideoDao();
		return vdao.selectAll();
	}


	public boolean caricaPost(Video p) {
		VideoDao vdao = new VideoDao();
		VideoUtility u = new VideoUtility();
		boolean b = vdao.pubblicaVideo(u.coverti(p));
		return b;
	}


	public boolean rimuoviPost(Video p) {
		VideoDao vdao = new VideoDao();
		VideoUtility u = new VideoUtility();
		return vdao.rimuoviVideo(u.coverti(p));
	}


	
}
