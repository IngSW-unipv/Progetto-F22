package db.testo;

import java.sql.Date;
import java.sql.Time;

import db.Interfacce.IPost;


public class TestoDB implements IPost{

	public TestoDB(String idTesto, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, String font, String titolo) {
		super();
		this.idTesto = idTesto;
		this.dataPubblicazione = dataPubblicazione;
		this.oraPubblicazione = oraPubblicazione;
		this.descrizione = descrizione;
		this.numLike = numLike;
		this.numDislike = numDislike;
		this.visibile = visibile;
		this.condivisibile = condivisibile;
		this.profilo = profilo;
		this.font = font;
		this.titolo = titolo;
	}
	private String idTesto;
	private Date dataPubblicazione;
	private Time oraPubblicazione;
	private String descrizione;
	private int numLike;
	private int numDislike;
	private boolean visibile;
	private boolean condivisibile;
	private String profilo;
	private String font;
	private String titolo;
	public String getIdTesto() {
		return idTesto;
	}
	public void setIdTesto(String idTesto) {
		this.idTesto = idTesto;
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
	public String getFont() {
		return font;
	}
	public void setFont(String font) {
		this.font = font;
	}
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
	@Override
	public String toString() {
		return "TestoDB [idTesto=" + idTesto + ", dataPubblicazione=" + dataPubblicazione + ", oraPubblicazione="
				+ oraPubblicazione + ", descrizione=" + descrizione + ", numLike=" + numLike + ", numDislike="
				+ numDislike + ", visibile=" + visibile + ", condivisibile=" + condivisibile + ", profilo=" + profilo
				+ ", font=" + font + ", titolo=" + titolo + "]";
	}
	
}
