package Messaggio;

import java.sql.Date;
import java.sql.Time;

public class MessaggioPrivato extends Messaggio{

	public MessaggioPrivato(String id, Date dataInvio, Time oraInvio, String testo, String multimedia, String idProfiloInviante, String idProfiloRicevente) {
		super(id, dataInvio, oraInvio, testo, multimedia);
		this.idProfiloInviante = idProfiloInviante;
		this.idProfiloRicevente = idProfiloRicevente;
	}
	private String idProfiloInviante;
	private String idProfiloRicevente;
	public String getIdProfiloInviante() {
		return idProfiloInviante;
	}
	public void setIdProfiloInviante(String idProfiloInviante) {
		this.idProfiloInviante = idProfiloInviante;
	}
	public String getIdProfiloRicevente() {
		return idProfiloRicevente;
	}
	public void setIdProfiloRicevente(String idProfiloRicevente) {
		this.idProfiloRicevente = idProfiloRicevente;
	}
	@Override
	public String toString() {
		return super.toString() + ", idProfiloInviante = " + idProfiloInviante + ", idProfiloRicevente = " + idProfiloRicevente
				+ "]";
	}
	
	
}
