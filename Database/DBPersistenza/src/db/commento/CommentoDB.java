package db.commento;

import java.sql.Date;
import java.sql.Time;

public class CommentoDB {

	public CommentoDB(String idCommento, Time oraCommento, Date dataCommento, String testo, String post) {
		super();
		this.idCommento = idCommento;
		this.oraCommento = oraCommento;
		this.dataCommento = dataCommento;
		this.testo = testo;
		this.post = post;
	}
	private String idCommento;
	private Time oraCommento;
	private Date dataCommento;
	private String testo;
	private String post;
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
		return "CommentoDB [idCommento=" + idCommento + ", oraCommento=" + oraCommento + ", dataCommento="
				+ dataCommento + ", testo=" + testo + ", post=" + post + "]";
	}
}
