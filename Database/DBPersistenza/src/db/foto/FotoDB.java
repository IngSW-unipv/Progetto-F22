package db.foto;

import java.sql.Date;
import java.sql.Time;

public class FotoDB {

	public FotoDB(String idFoto, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione,
			String percorso, boolean isStory, boolean isHd) {
		super();
		this.idFoto = idFoto;
		this.dataPubblicazione = dataPubblicazione;
		this.oraPubblicazione = oraPubblicazione;
		this.descrizione = descrizione;
		this.numLike = numLike;
		this.numDislike = numDislike;
		this.visibile = visibile;
		this.condivisibile = condivisibile;
		this.profilo = profilo;
		this.tempoCancellazione = tempoCancellazione;
		this.percorso = percorso;
		this.isStory = isStory;
		this.isHd = isHd;
	}
	private String idFoto;
	private Date dataPubblicazione;
	private Time oraPubblicazione;
	private String descrizione;
	private int numLike;
	private int numDislike;
	private boolean visibile;
	private boolean condivisibile;
	private String profilo;
	private int tempoCancellazione;
    private String percorso;
    private boolean isStory;
    public boolean isHd;
	public String getIdFoto() {
		return idFoto;
	}
	public void setIdFoto(String idFoto) {
		this.idFoto = idFoto;
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
	public int getTempoCancellazione() {
		return tempoCancellazione;
	}
	public void setTempoCancellazione(int tempoCancellazione) {
		this.tempoCancellazione = tempoCancellazione;
	}
	public String getPercorso() {
		return percorso;
	}
	public void setPercorso(String percorso) {
		this.percorso = percorso;
	}
	public boolean isStory() {
		return isStory;
	}
	public void setStory(boolean isStory) {
		this.isStory = isStory;
	}
	public boolean isHd() {
		return isHd;
	}
	public void setHd(boolean isHd) {
		this.isHd = isHd;
	}
	@Override
	public String toString() {
		return "FotoDB [idFoto=" + idFoto + ", dataPubblicazione=" + dataPubblicazione + ", oraPubblicazione="
				+ oraPubblicazione + ", descrizione=" + descrizione + ", numLike=" + numLike + ", numDislike="
				+ numDislike + ", visibile=" + visibile + ", condivisibile=" + condivisibile + ", profilo=" + profilo
				+ ", tempoCancellazione=" + tempoCancellazione + ", percorso=" + percorso + ", isStory=" + isStory
				+ ", isHd=" + isHd + "]";
	}
    
}
