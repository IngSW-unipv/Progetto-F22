
package db.messaggio.messaggioPrivato;

import java.sql.Date;
import java.sql.Time;

import db.messaggio.MessaggioDB;


public class MessaggioPrivatoDB extends MessaggioDB{

	public MessaggioPrivatoDB(String idMsgPvt, Date dataInvio, Time oraInvio, String testo, String multimedia,
			String profiloInviante, String profiloRicevente) {
		super(idMsgPvt,dataInvio,oraInvio,testo,multimedia);
		this.profiloInviante = profiloInviante;
		this.profiloRicevente = profiloRicevente;
	}

	private String profiloInviante;
	private String profiloRicevente;
	
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
	public  MessaggioDB inserisciCaratteristiche(MessaggioDB m) {
		m = new MessaggioPrivatoDB(m.getIdMessaggio(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), this.getProfiloInviante(), this.getProfiloRicevente());
		return m;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", profiloInviante = " + profiloInviante + ", profiloRicevente = " + profiloRicevente
				+ "]";
	}
	
}




