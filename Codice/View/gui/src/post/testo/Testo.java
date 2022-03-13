package post.testo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import db.testo.TestoDB;
import db.testo.TestoDao;
import post.Post;
import post.testo.utility.TestoUtility;

public class Testo extends Post {
	public Testo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo,
			String font, String titolo) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, condivisibile,
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
	
	public ArrayList<TestoDB> selectAllTesto() {
		TestoDao tdao = new TestoDao();
		return tdao.selectAll();
	}
	
	public boolean caricaPost(Testo p) {
		TestoDao tdao = new TestoDao();
		TestoUtility u = new TestoUtility();
		boolean b = tdao.pubblicaTesto(u.converti(p));
	    return b;
	}
	public boolean rimuoviPost(Testo p) {
		TestoDao tdao = new TestoDao();
		TestoUtility u = new TestoUtility();
		return tdao.rimuoviTesto(u.converti(p));
	}
	@Override
	public String toString() {
		return super.toString() + ", font=" + font + ", titolo=" + titolo + "]";
	}
	
	}
	
	
