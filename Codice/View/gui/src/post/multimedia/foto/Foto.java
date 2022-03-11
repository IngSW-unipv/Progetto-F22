package post.multimedia.foto;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import db.foto.FotoDao;
import post.Post;
import post.multimedia.Multimedia;

public class Foto extends Multimedia{

	public Foto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione,
			String percorso, boolean isStory, boolean isHd) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile, profilo,
				tempoCancellazione, percorso, isStory);
		this.isHd = isHd;
	}


	public boolean isHd;
	
	public boolean isHd() {
		return isHd;
	}

	public void setHd(boolean isHd) {
		this.isHd = isHd;
	}
	
	
	public boolean settaDurataStoria(int time, Post f) {
		this.setStory(true);
		this.setTempoCancellazione(time);
		//this.caricaPost(f);
		try {
		    Thread.sleep(time * 60 * 60 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		//this.rimuoviPost(f);	
		return true;
	}

	@Override
	public ArrayList<Post> selectAll() {
		FotoDao fdao = new FotoDao();
		return fdao.selectAll();
	}
/*
	@Override
	public boolean caricaPost(Post p) {
		FotoDao fdao = new FotoDao();
		boolean b = fdao.pubblicaFoto(p);
		fdao.inserisciCaratteristiche(p, this.getTempoCancellazione(), this.getPercorso(), this.isStory(), this.isHd);
		return b;
	}

	@Override
	public boolean rimuoviPost(Post p) {
		FotoDao fdao = new FotoDao();
		return fdao.rimuoviFoto(p);
	}
*/
	@Override
	public String toString() {
		return super.toString() + ", isHd = " + isHd + "]";
	}

}
