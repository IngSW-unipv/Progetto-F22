package Messaggio;

import java.sql.Date;
import java.sql.Time;

import Messaggio.enumeration.TipoMessaggio;

public class MessaggioDiGruppo extends Messaggio{

	public MessaggioDiGruppo(String idMessaggio, Date dataInvio, Time oraInvio, String testo, String multimedia, String profiloInviante,String idGruppo) {
		super(idMessaggio, dataInvio, oraInvio, testo, multimedia,profiloInviante);
		this.idGruppo = idGruppo;
	}

	public MessaggioDiGruppo(String idMessaggio, String testo, String profiloInviante,String idGruppo) {
		super(idMessaggio, testo, profiloInviante);
		this.idGruppo = idGruppo;
	}

	public MessaggioDiGruppo(String idMessaggio) {
		super(idMessaggio);
		this.idGruppo = null;
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
		return super.toString() + ", idGruppo = " + idGruppo + "]";
	}
	

	@Override
	public TipoMessaggio getTipo() {
		return TipoMessaggio.DIGRUPPO;
	}

	@Override
	public Messaggio inserisciCaratteristiche(Messaggio m) {
		m = new MessaggioDiGruppo(m.getIdMessaggio(),m.getDataInvio(),m.getOraInvio(),m.getTesto(),m.getMultimedia(),m.getProfiloInviante(),this.getIdGruppo());
		return m;
		
	}

}
