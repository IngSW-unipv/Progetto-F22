package Messaggio;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;

import Messaggio.enumeration.TipoMessaggio;


public abstract class Messaggio {
	public Messaggio(String idMessaggio, Date dataInvio, Time oraInvio, String testo, String multimedia,String profiloInviante) {
		super();
		this.idMessaggio = idMessaggio;
		this.dataInvio = dataInvio;
		this.oraInvio = oraInvio;
		this.testo = testo;
		this.multimedia = multimedia;
		this.profiloInviante = profiloInviante;
	}
	
	public Messaggio(String idMessaggio, String testo, String multimedia,String profiloInviante) {
		super();
		this.idMessaggio = idMessaggio;
		this.dataInvio = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
		this.oraInvio = new Time(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());	
		this.testo = testo;
		this.multimedia = multimedia;
		this.profiloInviante = profiloInviante;
	}
	

	public Messaggio(String id) {
		super();
		this.idMessaggio = id;
		this.dataInvio = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
		this.oraInvio = new Time(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());	
		this.testo = null;
		this.multimedia = null;
		this.profiloInviante = null;
	}

	public Messaggio(String idMessaggio, String testo, String profiloInviante) {
		super();
		this.idMessaggio = idMessaggio;
		this.dataInvio = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
		this.oraInvio = new Time(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());	
		this.testo = testo;
		this.multimedia = null;
		this.profiloInviante = profiloInviante;
	}

	private String idMessaggio;
	private Date dataInvio;
	private Time oraInvio;
	private String testo;
	private String multimedia;
	private String profiloInviante;
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
		return "Messaggio [idMessaggio=" + idMessaggio + ", dataInvio=" + dataInvio + ", oraInvio=" + oraInvio
				+ ", testo=" + testo + ", multimedia=" + multimedia + ", profiloInviante=" + profiloInviante + "]";
	}	
	
	public abstract TipoMessaggio getTipo();
	public abstract Messaggio inserisciCaratteristiche(Messaggio m);
	public String getProfiloInviante() {
		return profiloInviante;
	}
	public void setProfiloInviante(String profiloInviante) {
		this.profiloInviante = profiloInviante;
	}
}