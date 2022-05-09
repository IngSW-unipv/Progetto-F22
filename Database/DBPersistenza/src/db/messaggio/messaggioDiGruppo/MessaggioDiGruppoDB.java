package db.messaggio.messaggioDiGruppo;

import java.sql.Date;
import java.sql.Time;

import db.messaggio.MessaggioDB;

public class MessaggioDiGruppoDB extends MessaggioDB{

	public MessaggioDiGruppoDB(String idMsgGrp, Date dataInvio, Time oraInvio, String testo, String multimedia,
			String idGruppo) {
		super(idMsgGrp,dataInvio,oraInvio,testo,multimedia);
		this.idGruppo = idGruppo;
	}
	
	private String idGruppo;
	public String getIdGruppo() {
		return idGruppo;
	}
	public void setIdGruppo(String idGruppo) {
		this.idGruppo = idGruppo;
	}
	
	public  MessaggioDB inserisciCaratteristiche(MessaggioDB m) {
		m = new MessaggioDiGruppoDB(m.getIdMessaggio(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), this.getIdGruppo());
		return m;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", idGruppo = " + idGruppo + "]";
	}
	
}