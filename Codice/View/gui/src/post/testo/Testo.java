package post.testo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import db.testo.TestoDao;
import post.Post;

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
	@Override
	public ArrayList<Post> selectAll() {
		TestoDao tdao = new TestoDao();
		return tdao.selectAll();
	}/*
	@Override
	public boolean caricaPost(Post p) {
		TestoDao tdao = new TestoDao();
		boolean b = tdao.pubblicaTesto(p);
		tdao.aggiungiCaratteristiche(p, this.getFont(), this.getTitolo());
	    return b;
	}
	@Override
	public boolean rimuoviPost(Post p) {
		TestoDao tdao = new TestoDao();
		return tdao.rimuoviTesto(p);
	}*/
	@Override
	public String toString() {
		return super.toString() + ", font=" + font + ", titolo=" + titolo + "]";
	}
	
	}
	
	
