package post.multimedia.video;


import post.Post;
import post.enumeration.TipoPost;
import post.multimedia.Multimedia;

public class Video extends Multimedia{

	public Video(String idPost, String descrizione, boolean visibile, boolean condivisibile, String profilo,
			String percorso, int durataInSecondi) {
		super(idPost, descrizione, visibile, condivisibile,
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

	@Override
	public Post inserisciCaratteristiche(Post p) {
		p = new Video(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.isCondivisibile(), p.getProfilo(), this.getPercorso(), this.getDurataInSecondi());
		return p;
	}	
}
