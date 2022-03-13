package db.sondaggioSceltaMultipla;

import java.sql.Date;
import java.sql.Time;

public class SondaggioSceltaMultiplaDB {

	public SondaggioSceltaMultiplaDB(String idSondaggio, Date dataPubblicazione, Time oraPubblicazione,
			String descrizione, int numLike, int numDislike, boolean visibile, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta) {
		super();
		this.idSondaggio = idSondaggio;
		this.dataPubblicazione = dataPubblicazione;
		this.oraPubblicazione = oraPubblicazione;
		this.descrizione = descrizione;
		this.numLike = numLike;
		this.numDislike = numDislike;
		this.visibile = visibile;
		this.condivisibile = condivisibile;
		this.profilo = profilo;
		this.primaScelta = primaScelta;
		this.secondaScelta = secondaScelta;
		this.terzaScelta = terzaScelta;
		this.quartaScelta = quartaScelta;
	}
	private String idSondaggio;
	private Date dataPubblicazione;
	private Time oraPubblicazione;
	private String descrizione;
	private int numLike;
	private int numDislike;
	private boolean visibile;
	private boolean condivisibile;
	private String profilo;
	private String primaScelta;
	private String secondaScelta;
	private String terzaScelta;
	private String quartaScelta;
	public String getIdSondaggio() {
		return idSondaggio;
	}
	public void setIdSondaggio(String idSondaggio) {
		this.idSondaggio = idSondaggio;
	}
	public Date getDataPubblicazione() {
		return dataPubblicazione;
	}
	public void setDataPubblicazione(Date dataPubblicazione) {
		this.dataPubblicazione = dataPubblicazione;
	}
	public Time getOraPubblicazione() {
		return oraPubblicazione;
	}
	public void setOraPubblicazione(Time oraPubblicazione) {
		this.oraPubblicazione = oraPubblicazione;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	public int getNumLike() {
		return numLike;
	}
	public void setNumLike(int numLike) {
		this.numLike = numLike;
	}
	public int getNumDislike() {
		return numDislike;
	}
	public void setNumDislike(int numDislike) {
		this.numDislike = numDislike;
	}
	public boolean isVisibile() {
		return visibile;
	}
	public void setVisibile(boolean visibile) {
		this.visibile = visibile;
	}
	public boolean isCondivisibile() {
		return condivisibile;
	}
	public void setCondivisibile(boolean condivisibile) {
		this.condivisibile = condivisibile;
	}
	public String getProfilo() {
		return profilo;
	}
	public void setProfilo(String profilo) {
		this.profilo = profilo;
	}
	public String getPrimaScelta() {
		return primaScelta;
	}
	public void setPrimaScelta(String primaScelta) {
		this.primaScelta = primaScelta;
	}
	public String getSecondaScelta() {
		return secondaScelta;
	}
	public void setSecondaScelta(String secondaScelta) {
		this.secondaScelta = secondaScelta;
	}
	public String getTerzaScelta() {
		return terzaScelta;
	}
	public void setTerzaScelta(String terzaScelta) {
		this.terzaScelta = terzaScelta;
	}
	public String getQuartaScelta() {
		return quartaScelta;
	}
	public void setQuartaScelta(String quartaScelta) {
		this.quartaScelta = quartaScelta;
	}
	@Override
	public String toString() {
		return "SondaggioSceltaMultiplaDB [idSondaggio=" + idSondaggio + ", dataPubblicazione=" + dataPubblicazione
				+ ", oraPubblicazione=" + oraPubblicazione + ", descrizione=" + descrizione + ", numLike=" + numLike
				+ ", numDislike=" + numDislike + ", visibile=" + visibile + ", condivisibile=" + condivisibile
				+ ", profilo=" + profilo + ", primaScelta=" + primaScelta + ", secondaScelta=" + secondaScelta
				+ ", terzaScelta=" + terzaScelta + ", quartaScelta=" + quartaScelta + "]";
	}
}