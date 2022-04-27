package post.multimedia.foto;

import java.sql.Date;
import java.sql.Time;

import post.enumeration.TipoPost;
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


	@Override
	public String toString() {
		return super.toString() + ", isHd = " + isHd + "]";
	}

	@Override
	public TipoPost getTipo() {
		return TipoPost.FOTO;
	}

}
