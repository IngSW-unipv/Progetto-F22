package Messaggio;

import java.sql.Date;
import java.sql.Time;

public class MessaggioDiGruppo extends Messaggio{

	public MessaggioDiGruppo(String idMessaggio, Date dataInvio, Time oraInvio, String testo, String multimedia, String idGruppo) {
		super(idMessaggio, dataInvio, oraInvio, testo, multimedia);
		this.idGruppo = idGruppo;
	}

	private String idGruppo;

	public String getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(String idGruppo) {
		this.idGruppo = idGruppo;
	}

	@Override
	public String toString() {
		return super.toString() + "MessaggioDiGruppo [idGruppo=" + idGruppo + "]";
	}
}
