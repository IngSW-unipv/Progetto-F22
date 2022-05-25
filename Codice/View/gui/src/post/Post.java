package post;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import post.enumeration.TipoPost;


	public abstract class Post {
		
		public Post(String idPost, String descrizione,
		            boolean visibile, boolean condivisibile, String profilo) {
			super();
			this.idPost = idPost;
			this.dataPubblicazione = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
			this.oraPubblicazione = new Time(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());
			this.descrizione = descrizione;
			this.numLike = 0;
			this.numDislike = 0;
			this.visibile = visibile;
			this.condivisibile = condivisibile;
			this.profilo = profilo;
		}
	private String idPost;
	private Date dataPubblicazione;
	private Time oraPubblicazione;
	private String descrizione;
	private int numLike;
	private int numDislike;
	private boolean visibile;
	private boolean condivisibile;
	private String profilo;
	public String getIdPost() {
		return idPost;
	}
	public void setIdPost(String idPost) {
		this.idPost = idPost;
	}
	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}
	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
	public Time getOraPubblicazione() {
		return oraPubblicazione;
	}
	public void setOraPubblicazione(Time oraPubblicazione) {
		this.oraPubblicazione = oraPubblicazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getNumLike() {
		return numLike;
	}
	public void setNumLike(int numLike) {
		this.numLike = numLike;
	}
	public int getNumDislike() {
		return numDislike;
	}
	public void setNumDislike(int numDislike) {
		this.numDislike = numDislike;
	}
	public boolean isVisibile() {
		return visibile;
	}
	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	public boolean isCondivisibile() {
		return condivisibile;
	}
	public void setCondivisibile(boolean condivisibile) {
		this.condivisibile = condivisibile;
	}
	public String getProfilo() {
		return profilo;
	}
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}
	@Override
	public String toString() {
		return "[idPost = " + idPost + ", dataPubblicazione = " + dataPubblicazione + ", oraPubblicazione = "
				+ oraPubblicazione + ", descrizione = " + descrizione + ", numLike = " + numLike + ", numDislike = " + numDislike
				+ ", visibile = " + visibile + ", condivisibile = " + condivisibile + ", profilo = "
				+ profilo;
	}
	
	public abstract TipoPost getTipo();
	public abstract Post inserisciCaratteristiche(Post p);
	}

