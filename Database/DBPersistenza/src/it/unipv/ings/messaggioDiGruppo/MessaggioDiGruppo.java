package it.unipv.ings.messaggioDiGruppo;

import java.sql.Date;
import java.sql.Time;

public class MessaggioDiGruppo {
public MessaggioDiGruppo(String idMsgGrp, Date dataInvio, Time oraInvio, String testo, String multimedia,
			String gruppo) {
		super();
		this.idMsgGrp = idMsgGrp;
		this.dataInvio = dataInvio;
		this.oraInvio = oraInvio;
		this.testo = testo;
		this.multimedia = multimedia;
		this.gruppo = gruppo;
	}
private String idMsgGrp;
private Date dataInvio;
private Time oraInvio;
private String testo;
private String multimedia;
private String gruppo;
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
public String getGruppo() {
	return gruppo;
}
public void setGruppo(String gruppo) {
	this.gruppo = gruppo;
}
@Override
public String toString() {
	return "MessaggioDiGruppo [idMsgGrp=" + idMsgGrp + ", dataInvio=" + dataInvio + ", oraInvio=" + oraInvio
			+ ", testo=" + testo + ", multimedia=" + multimedia + ", gruppo=" + gruppo + "]";
}

}
