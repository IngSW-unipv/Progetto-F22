package messaggio;

import java.sql.Date;
import java.sql.Time;

public abstract class MessaggioDB {

	public MessaggioDB(String idMessaggio, Date dataInvio, Time oraInvio, String testo, String multimedia) {
		super();
		this.idMessaggio = idMessaggio;
		this.dataInvio = dataInvio;
		this.oraInvio = oraInvio;
		this.testo = testo;
		this.multimedia = multimedia;
	}
	private String idMessaggio;
	private Date dataInvio;
	private Time oraInvio;
	private String testo;
	private String multimedia;
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
	@Override
	public String toString() {
		return "[idMessaggio = " + idMessaggio + ", dataInvio = " + dataInvio + ", oraInvio = " + oraInvio
				+ ", testo = " + testo + ", multimedia = " + multimedia + "]";
	} 
	
}
