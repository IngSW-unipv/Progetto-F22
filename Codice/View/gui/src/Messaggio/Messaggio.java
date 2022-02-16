package Messaggio;

import java.time.LocalTime;
import java.util.Date;

public abstract class Messaggio {

	public Messaggio(String idMessaggio, Date dataInvio, LocalTime oraInvio, String testo, String percorso) {
		super();
		this.idMessaggio = idMessaggio;
		this.dataInvio = dataInvio;
		this.oraInvio = oraInvio;
		this.testo = testo;
		this.percorso = percorso;
	}
	private String idMessaggio;
	private Date dataInvio;
	private LocalTime oraInvio;
	private String testo;
	private String percorso;
	public String getIdMessaggio() {
		return idMessaggio;
	}
	public void setIdMessaggio(String idMessaggio) {
		this.idMessaggio = idMessaggio;
	}
	public Date getDataInvio() {
		return dataInvio;
	}
	public void setDataInvio(Date dataInvio) {
		this.dataInvio = dataInvio;
	}
	public LocalTime getOraInvio() {
		return oraInvio;
	}
	public void setOraInvio(LocalTime oraInvio) {
		this.oraInvio = oraInvio;
	}
	public String getTesto() {
		return testo;
	}
	public void setTesto(String testo) {
		this.testo = testo;
	}
	public String getPercorso() {
		return percorso;
	}
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	@Override
	public String toString() {
		return "Messaggio [idMessaggio=" + idMessaggio + ", dataInvio=" + dataInvio + ", oraInvio=" + oraInvio
				+ ", testo=" + testo + ", percorso=" + percorso + "]";
	}
}
