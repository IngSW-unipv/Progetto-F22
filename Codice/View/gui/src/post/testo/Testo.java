package post.testo;

import java.sql.Date;
import java.sql.Time;

import it.unipv.ings.Testo.TestoDB;
import it.unipv.ings.Testo.TestoDao;
import post.Post;

public class Testo extends Post implements ITesto{
	public Testo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, String idTesto,
			String font, String titolo) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile,
				profilo);
		this.idTesto = idTesto;
		this.font = font;
		this.titolo = titolo;
		
	}
	private String idTesto;
	private String font;
	private String titolo;
	public String getIdTesto() {
		return idTesto;
	}
	public void setIdTesto(String idTesto) {
		this.idTesto = idTesto;
	}
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
	public boolean pubblicaTesto(TestoDB t) {
		boolean b;
		TestoDao tdao = new TestoDao();
		b = tdao.pubblicaTesto(t);
		return b;
	}
	@Override
	public boolean rimuoviTesto(TestoDB t) {
		boolean b;
		TestoDao tdao = new TestoDao();
		b = tdao.rimuoviTesto(t);
		return b;
	}
	
	

}
