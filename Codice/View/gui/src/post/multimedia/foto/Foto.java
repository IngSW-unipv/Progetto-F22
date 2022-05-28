package post.multimedia.foto;

import post.Post;
import post.enumeration.TipoPost;
import post.multimedia.Multimedia;

public class Foto extends Multimedia{

	public Foto(String idPost, String descrizione, boolean visibile, String profilo,
			String percorso, boolean isHd) {
		super(idPost, descrizione,visibile, profilo, percorso);
		this.isHd = isHd;
	}
	public Foto(String idPost) {
		super(idPost, "una descrizione",true, "marge", "bene");
		this.isHd = true;
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
        p = new Foto(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.getProfilo(), this.getPercorso(), this.isHd());
		return p;
	}

}
