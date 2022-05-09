package db.post.testo;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;

public class TestoDB extends PostDB{
	

		public TestoDB(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
				int numDislike, boolean visibile, boolean condivisibile, String profilo, String font, String titolo) {
			super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo);
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
		
	}
