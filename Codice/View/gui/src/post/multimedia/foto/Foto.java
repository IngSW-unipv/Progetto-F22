package post.multimedia.foto;

import post.Post;
import post.enumeration.TipoPost;
import post.multimedia.Multimedia;

public class Foto extends Multimedia{

	public Foto(String idPost, String descrizione, boolean visibile, boolean condivisibile, String profilo,
			String percorso, boolean isHd) {
		super(idPost, descrizione,visibile, condivisibile, profilo, percorso);
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

	@Override
	public Post inserisciCaratteristiche(Post p) {
        p = new Foto(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.isCondivisibile(), p.getProfilo(), this.getPercorso(), this.isHd());
		return p;
	}

}
