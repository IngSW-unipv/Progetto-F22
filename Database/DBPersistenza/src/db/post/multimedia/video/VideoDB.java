package db.post.multimedia.video;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;
import db.post.multimedia.MultimediaDB;

public class VideoDB extends MultimediaDB{

	public VideoDB(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo,
			String percorso, int durataInSecondi) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,visibile,condivisibile,
				profilo,percorso);
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
		return super.toString() + ", durataInSecondi=" + durataInSecondi + "]";
	}
	@Override
	public PostDB inserisciCaratteristiche(PostDB p) {
		VideoDB vdb = new VideoDB(p.getIdPost(), p.getDataPubblicazione(), p.getOraPubblicazione(), p.getDescrizione(), p.isVisibile(), p.isCondivisibile(), p.getProfilo(), this.getPercorso(), this.getDurataInSecondi());
		return vdb;
	}
	
}
