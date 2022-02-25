package post.multimedia.video;

import java.sql.Date;
import java.sql.Time;

import it.unipv.ings.Video.VideoDB;
import it.unipv.ings.Video.VideoDao;
import post.multimedia.Multimedia;

public class Video extends Multimedia{

	public Video(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione,
			String percorso,boolean isStory, String idVideo) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile,
				profilo, tempoCancellazione, percorso, isStory);
		this.idVideo = idVideo;
	}

	private String idVideo;
	private int durata;
	
    public String getIdVideo() {
		return idVideo;
	}

	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}

	public boolean pubblicaVideo(VideoDB v) {
		boolean b;
		VideoDao vdao = new VideoDao();
		b = vdao.pubblicaVideo(v);
		return b;
	}
	
	public boolean rimuoviVideo(VideoDB v) {
		boolean b;
		VideoDao vdao = new VideoDao();
		b = vdao.rimuoviVideo(v);
		return b;
	}

	public int getDurata() {
		return durata;
	}

	public void setDurata(int durata) {
		this.durata = durata;
	}
	
	//L'int passato da tastiera indica il numero di ore in cui vogliamo che la storia rimanga

	public boolean settaDurataStoria(int time, Video v) {
		UtilityVideo u = new UtilityVideo();
		this.setStory(true);
		this.setTempoCancellazione(time);
		this.pubblicaVideo(u.convertiToVideoDB(v));
		try {
		    Thread.sleep(time * 60 * 60 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		this.rimuoviVideo(u.convertiToVideoDB(v));	
		return true;
	}
	
}
