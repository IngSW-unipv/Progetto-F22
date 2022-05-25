package db.commento;

import java.sql.Date;
import java.sql.Time;

public class CommentoDB {

	public CommentoDB(String idCommento, Time oraCommento, Date dataCommento, String testo, String profilo, String idFoto,
			String idVideo,String idSDV,String idSSM, String idTesto) {
		super();
		this.idCommento = idCommento;
		this.oraCommento = oraCommento;
		this.dataCommento = dataCommento;
		this.testo = testo;
		this.profilo = profilo;
		this.idFoto = idFoto;
		this.idVideo = idVideo;
		this.idSDV = idSDV;
		this.idSSM = idSSM;
		this.idTesto = idTesto;
	}
	private String idCommento;
	private Time oraCommento;
	private Date dataCommento;
	private String testo;
	private String profilo;
	private String idFoto;
	private String idVideo;
	private String idSDV;
	private String idSSM;
	private String idTesto;
	
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

	@Override
	public String toString() {
		return "CommentoDB [idCommento=" + idCommento + ", oraCommento=" + oraCommento + ", dataCommento="
				+ dataCommento + ", testo=" + testo + ", profilo=" + profilo + ", idFoto=" + idFoto + ", idVideo="
				+ idVideo + ", idSDV=" + idSDV + ", idSSM=" + idSSM + ", idTesto=" + idTesto + "]";
	}
	public String getProfilo() {
		return profilo;
	}
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}
	public String getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(String idFoto) {
		this.idFoto = idFoto;
	}
	public String getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
	}
	public String getIdSDV() {
		return idSDV;
	}
	public void setIdSDV(String idSDV) {
		this.idSDV = idSDV;
	}
	public String getIdSSM() {
		return idSSM;
	}
	public void setIdSSM(String idSSM) {
		this.idSSM = idSSM;
	}
	public String getIdTesto() {
		return idTesto;
	}
	public void setIdTesto(String idTesto) {
		this.idTesto = idTesto;
	}
}
