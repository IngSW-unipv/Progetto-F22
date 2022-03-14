package db.video;

import java.sql.Date;
import java.sql.Time;

public class VideoDB {

	public VideoDB(String idVideo, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean condivisibile, String profilo, int tempoCancellazione,
			String percorso, boolean isStory, int durataInSecondi) {
		super();
		this.idVideo = idVideo;
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
		this.durataInSecondi = durataInSecondi;
	}
	private String idVideo;
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
    private int durataInSecondi;
	public String getIdVideo() {
		return idVideo;
	}
	public void setIdVideo(String idVideo) {
		this.idVideo = idVideo;
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
	public int getDurataInSecondi() {
		return durataInSecondi;
	}
	public void setDurataInSecondi(int durataInSecondi) {
		this.durataInSecondi = durataInSecondi;
	}
	@Override
	public String toString() {
		return "VideoDB [idVideo=" + idVideo + ", dataPubblicazione=" + dataPubblicazione + ", oraPubblicazione="
				+ oraPubblicazione + ", descrizione=" + descrizione + ", numLike=" + numLike + ", numDislike="
				+ numDislike + ", visibile=" + visibile + ", condivisibile=" + condivisibile + ", profilo=" + profilo
				+ ", tempoCancellazione=" + tempoCancellazione + ", percorso=" + percorso + ", isStory=" + isStory
				+ ", durataInSecondi=" + durataInSecondi + "]";
	}
}
