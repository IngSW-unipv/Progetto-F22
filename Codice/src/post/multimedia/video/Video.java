package post.multimedia.video;


import post.Post;
import post.enumeration.TipoPost;
import post.multimedia.Multimedia;

public class Video extends Multimedia{
	private int durataInSecondi;
	
	public Video(String idPost, String descrizione, boolean visibile, String profilo, String percorso, int durataInSecondi,boolean isStory) {
		super(idPost, descrizione, visibile, profilo, percorso,isStory);
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
		p = new Video(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.getProfilo(), this.getPercorso(), this.getDurataInSecondi(), this.isStory());
		return p;
	}	
 
	public int getDurataInSecondi() {
		return durataInSecondi;
	}

	public void setDurataInSecondi(int durataInSecondi) {
		this.durataInSecondi = durataInSecondi;
	}
}
