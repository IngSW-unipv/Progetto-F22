package post.multimedia.foto;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import db.foto.FotoDB;
import db.foto.FotoDao;
import post.Post;
import post.multimedia.Multimedia;
import post.multimedia.foto.utility.FotoUtility;

public class Foto extends Multimedia{

	public Foto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione,
			String percorso, boolean isStory, boolean isHd) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile, profilo,
				tempoCancellazione, percorso, isStory);
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
		this.caricaPost(f);
		try {
		    Thread.sleep(time * 60 * 60 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}
		this.rimuoviPost(f);	
		return true;
	}

	
	public ArrayList<FotoDB> selectAllFoto() {
		FotoDao fdao = new FotoDao();
		return fdao.selectAll();
	}


	public boolean caricaPost(Foto p) {
		FotoDao fdao = new FotoDao();
		FotoUtility u = new FotoUtility();
		boolean b = fdao.pubblicaFoto(u.converti(p));
		return b;
	}

	
	public boolean rimuoviPost(Foto p) {
		FotoDao fdao = new FotoDao();
		FotoUtility u = new FotoUtility();
		return fdao.rimuoviFoto(u.converti(p));
	}
	@Override
	public String toString() {
		return super.toString() + ", isHd = " + isHd + "]";
	}

}
