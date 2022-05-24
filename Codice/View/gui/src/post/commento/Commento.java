package post.commento;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;


public class Commento {
	
	private String idCommento;
	private Time oraCommento;
	private Date dataCommento;
	private String testo;
	private String post;
	private String profilo;

    Date d = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
    Time t = new Time(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());
	
	public Commento(String idCommento, Time oraCommento, Date dataCommento, String testo, String post, String profilo) {
		super();
		this.idCommento = idCommento;
		this.oraCommento = oraCommento;
		this.dataCommento = dataCommento;
		this.testo = testo;
		this.post = post;
		this.profilo = profilo;
	}
	public Commento(String idCommento) {
		super();
		this.idCommento = idCommento;
		this.oraCommento = null;
		this.dataCommento = null;
		this.testo = null;
		this.post = null;
		this.profilo = null;
	}

	
	public Commento(String idCommento, String idPost, String idProfilo, String commento) {
	    Time t = new Time(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());
	    Date d = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
	    
		this.idCommento = idCommento;
		this.oraCommento = t;
		this.dataCommento = d;
		this.testo = commento;
		this.post = idPost;
		this.profilo = idProfilo;
		
	}
	
	public String getIdCommento() {
		return idCommento;
	}
	public void setIdCommento(String idCommento) {
		this.idCommento = idCommento;
	}
	public Time getOraCommento() {
		return oraCommento;
	}
	public void setOraCommento(Time oraCommento) {
		this.oraCommento = oraCommento;
	}
	public Date getDataCommento() {
		return dataCommento;
	}
	public void setDataCommento(Date dataCommento) {
		this.dataCommento = dataCommento;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getPost() {
		return post;
	}
	public void setPost(String post) {
		this.post = post;
	}
	@Override
	public String toString() {
		return "Commento [idCommento=" + idCommento + ", oraCommento=" + oraCommento + ", dataCommento=" + dataCommento
				+ ", testo=" + testo + ", post=" + post + ", profilo=" + profilo + "]";
	}
	public String getProfilo() {
		return profilo;
	}
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}	
}
