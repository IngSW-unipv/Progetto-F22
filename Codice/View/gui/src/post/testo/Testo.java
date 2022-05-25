package post.testo;

import java.sql.Date;
import java.sql.Time;
import post.Post;
import post.enumeration.TipoPost;

public class Testo extends Post {
	public Testo(String idPost, String descrizione,
			boolean visibile, boolean condivisibile, String profilo, String font, String titolo) {
		super(idPost, descrizione, visibile, condivisibile,
				profilo);
		this.font = font;
		this.titolo = titolo;
		
	}
	private String font;
	private String titolo;
	
	
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		this.font = font;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Override
	public String toString() {
		return super.toString() + ", font=" + font + ", titolo=" + titolo + "]";
	}
	@Override
	public TipoPost getTipo() {
		return TipoPost.TESTO;
	}
	@Override
	public Post inserisciCaratteristiche(Post p) {
		p = new Testo(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.isCondivisibile(), p.getProfilo(), this.getFont(), this.getTitolo());
		return p;
	}
}
	
	
