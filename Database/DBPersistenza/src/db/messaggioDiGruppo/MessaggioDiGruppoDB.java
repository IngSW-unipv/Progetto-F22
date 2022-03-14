package db.messaggioDiGruppo;

import java.sql.Date;
import java.sql.Time;

public class MessaggioDiGruppoDB {

	public MessaggioDiGruppoDB(String idMsgGrp, Date dataInvio, Time oraInvio, String testo, String multimedia,
			String idGruppo) {
		super();
		this.idMsgGrp = idMsgGrp;
		this.dataInvio = dataInvio;
		this.oraInvio = oraInvio;
		this.testo = testo;
		this.multimedia = multimedia;
		this.idGruppo = idGruppo;
	}
	private String idMsgGrp;
	private Date dataInvio;
	private Time oraInvio;
	private String testo;
	private String multimedia;
	private String idGruppo;
	public String getIdMsgGrp() {
		return idMsgGrp;
	}
	public void setIdMsgGrp(String idMsgGrp) {
		this.idMsgGrp = idMsgGrp;
	}
	public Date getDataInvio() {
		return dataInvio;
	}
	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}
	public Time getOraInvio() {
		return oraInvio;
	}
	public void setOraInvio(Time oraInvio) {
		this.oraInvio = oraInvio;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getMultimedia() {
		return multimedia;
	}
	public void setMultimedia(String multimedia) {
		this.multimedia = multimedia;
	}
	public String getIdGruppo() {
		return idGruppo;
	}
	public void setIdGruppo(String idGruppo) {
		this.idGruppo = idGruppo;
	}
	@Override
	public String toString() {
		return "MessaggioDiGruppoDB [idMsgGrp=" + idMsgGrp + ", dataInvio=" + dataInvio + ", oraInvio=" + oraInvio
				+ ", testo=" + testo + ", multimedia=" + multimedia + ", idGruppo=" + idGruppo + "]";
	}
}
