package post.multimedia.video;

import java.sql.Date;
import java.sql.Time;

import post.enumeration.TipoPost;
import post.multimedia.Multimedia;

public class Video extends Multimedia{

	public Video(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo,
			String percorso, int durataInSecondi) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile,
				profilo, percorso);
		this.durataInSecondi = durataInSecondi;
	}

	private int durataInSecondi;
	
 
	public int getDurataInSecondi() {
		return durataInSecondi;
	}

	public void setDurataInSecondi(int durataInSecondi) {
		this.durataInSecondi = durataInSecondi;
	}

	@Override
	public String toString() {
		return super.toString() + ", durataInSecondi = " + durataInSecondi + "]";
	}

	@Override
	public TipoPost getTipo() {
		return TipoPost.VIDEO;
	}	
}
