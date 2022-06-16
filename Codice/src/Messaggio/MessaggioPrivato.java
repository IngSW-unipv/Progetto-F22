package Messaggio;

import java.sql.Date;
import java.sql.Time;

import Messaggio.enumeration.TipoMessaggio;

public class MessaggioPrivato extends Messaggio{
	
	private String idProfiloRicevente;

	public MessaggioPrivato(String id, Date dataInvio, Time oraInvio, String testo, String profiloInviante, String idProfiloRicevente) {
		super(id, dataInvio, oraInvio, testo,profiloInviante);
		this.idProfiloRicevente = idProfiloRicevente;
	}
	
	public MessaggioPrivato(String id) {
		super(id);
	}
	
	public MessaggioPrivato(String id, String testo, String profiloInviante, String idProfiloRicevente) {
		super(id, testo,profiloInviante);
		this.idProfiloRicevente = idProfiloRicevente;
	}
	
	@Override
	public String toString() {
		return super.toString() + ", idProfiloRicevente = " + idProfiloRicevente
				+ "]";
	}
	
	@Override
	public TipoMessaggio getTipo() {
		return TipoMessaggio.PRIVATO;
	}
	
	@Override
	public Messaggio inserisciCaratteristiche(Messaggio m) {
		m = new MessaggioPrivato(m.getIdMessaggio(),m.getDataInvio(),m.getOraInvio(),m.getTesto(),m.getProfiloInviante(),this.getIdProfiloRicevente());
		return m;
	}
	

	public String getIdProfiloRicevente() {
		return idProfiloRicevente;
	}
	
	public void setIdProfiloRicevente(String idProfiloRicevente) {
		this.idProfiloRicevente = idProfiloRicevente;
	}	
	
}
