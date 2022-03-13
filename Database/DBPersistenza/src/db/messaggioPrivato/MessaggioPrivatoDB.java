package db.messaggioPrivato;

import java.sql.Date;
import java.sql.Time;

public class MessaggioPrivatoDB {

	public MessaggioPrivatoDB(String idMsgPvt, Date dataInvio, Time oraInvio, String testo, String multimedia,
			String profiloInviante, String profiloRicevente) {
		super();
		this.idMsgPvt = idMsgPvt;
		this.dataInvio = dataInvio;
		this.oraInvio = oraInvio;
		this.testo = testo;
		this.multimedia = multimedia;
		this.profiloInviante = profiloInviante;
		this.profiloRicevente = profiloRicevente;
	}
	private String idMsgPvt;
	private Date dataInvio;
	private Time oraInvio;
	private String testo;
	private String multimedia;
	private String profiloInviante;
	private String profiloRicevente;
	public String getIdMsgPvt() {
		return idMsgPvt;
	}
	public void setIdMsgPvt(String idMsgPvt) {
		this.idMsgPvt = idMsgPvt;
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
	public String getProfiloInviante() {
		return profiloInviante;
	}
	public void setProfiloInviante(String profiloInviante) {
		this.profiloInviante = profiloInviante;
	}
	public String getProfiloRicevente() {
		return profiloRicevente;
	}
	public void setProfiloRicevente(String profiloRicevente) {
		this.profiloRicevente = profiloRicevente;
	}
	@Override
	public String toString() {
		return "MessaggioPrivatoDB [idMsgPvt=" + idMsgPvt + ", dataInvio=" + dataInvio + ", oraInvio=" + oraInvio
				+ ", testo=" + testo + ", multimedia=" + multimedia + ", profiloInviante=" + profiloInviante
				+ ", profiloRicevente=" + profiloRicevente + "]";
	}
}
