package db.post.multimedia.foto;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;
import db.post.multimedia.MultimediaDB;

public class FotoDB extends MultimediaDB{
	public FotoDB(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,int numLike,int numDislike, boolean visibile, String profilo, int tempoCancellazione,
			String percorso, boolean isStory,boolean isHd) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,profilo,tempoCancellazione,percorso,isStory);
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
	@Override
	public PostDB inserisciCaratteristiche(PostDB p) {
		FotoDB fdb = new FotoDB(p.getIdPost(), p.getDataPubblicazione(), p.getOraPubblicazione(), p.getDescrizione(),p.getNumLike(),p.getNumDislike(), p.isVisibile(), p.getProfilo(),this.getTempoCancellazione(), this.getPercorso(),this.isStory(), this.isHd);
		return fdb;
	}
    
}


