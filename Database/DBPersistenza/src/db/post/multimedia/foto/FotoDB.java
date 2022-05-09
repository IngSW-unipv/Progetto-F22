package db.post.multimedia.foto;

import java.sql.Date;
import java.sql.Time;

import db.post.multimedia.MultimediaDB;

public class FotoDB extends MultimediaDB{
	public FotoDB(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione,
			String percorso, boolean isStory, boolean isHd) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,
				profilo,tempoCancellazione,percorso, isStory);
		this.isHd = isHd;
	}
	
    public boolean isHd;
	
	public boolean isHd() {
		return isHd;
	}
	public void setHd(boolean isHd) {
		this.isHd = isHd;
	}
	@Override
	public String toString() {
		return super.toString() + ", isHd=" + isHd + "]";
	}
    
}


