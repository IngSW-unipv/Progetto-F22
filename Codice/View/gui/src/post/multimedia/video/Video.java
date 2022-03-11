package post.multimedia.video;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import db.video.VideoDao;
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

	public boolean settaDurataStoria(int time, Post p) {
		this.setStory(true);
		this.setTempoCancellazione(time);
		//this.caricaPost(p);
		try {
		    Thread.sleep(time * 60 * 60 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		//this.rimuoviPost(p);
		return true;
	}

	@Override
	public String toString() {
		return super.toString() + ", durataInSecondi = " + durataInSecondi + "]";
	}

	@Override
	public ArrayList<Post> selectAll() {
		VideoDao vdao = new VideoDao();
		return vdao.selectAll();
	}
/*
	@Override
	public boolean caricaPost(Post p) {
		VideoDao vdao = new VideoDao();
		boolean b = vdao.pubblicaVideo(p);
		vdao.inserisciCaratteristiche(p, this.getTempoCancellazione(), this.getPercorso(), this.isStory(), this.getDurataInSecondi());
		return b;
	}

	@Override
	public boolean rimuoviPost(Post p) {
		VideoDao vdao = new VideoDao();
		return vdao.rimuoviVideo(p);
	}

*/
	
}
