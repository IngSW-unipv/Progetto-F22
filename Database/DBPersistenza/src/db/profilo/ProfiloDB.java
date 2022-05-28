package db.profilo;

public class ProfiloDB {

	public ProfiloDB(String idProfilo, String nickname, String descrizione, int numFollower, int numSeguiti, int numPost, boolean esiste, boolean pswDaCambiare, boolean isLoggato, String psw, String immagineProfilo) {
		super();
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = descrizione;
		this.numFollower = numFollower;
		this.numSeguiti = numSeguiti;
		this.numPost = numPost;
		this.esiste = false;
		this.pswCambiata = false;
		this.isLoggato = false;
		this.psw = "Cambiami"; 
		this.immagineProfilo = immagineProfilo;
	}
private String idProfilo;
private String nickname;
private String descrizione;
private int numFollower;
private int numSeguiti;
private int numPost;
private boolean esiste;
private boolean pswCambiata;
private boolean isLoggato;
private String psw;
private String immagineProfilo;

public String getIdProfilo() {
	return idProfilo;
}
public void setIdProfilo(String idProfilo) {
	this.idProfilo = idProfilo;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
public int getNumFollower() {
	return numFollower;
}
public void setNumFollower(int numFollower) {
	this.numFollower = numFollower;
}
public int getNumSeguiti() {
	return numSeguiti;
}
public void setNumSeguiti(int numSeguiti) {
	this.numSeguiti = numSeguiti;
}
public int getNumPost() {
	return numPost;
}
public void setNumPost(int numPost) {
	this.numPost = numPost;
}

public boolean isEsiste() {
	return esiste;
}
public void setEsiste(boolean esiste) {
	this.esiste = esiste;
}
public boolean isPswCambiata() {
	return pswCambiata;
}
public void setPswCambiata(boolean pswCambiata) {
	this.pswCambiata = pswCambiata;
}
public boolean isLoggato() {
	return isLoggato;
}
public void setLoggato(boolean isLoggato) {
	this.isLoggato = isLoggato;
}
@Override
public String toString() {
	return "ProfiloDB [idProfilo=" + idProfilo + ", nickname=" + nickname + ", descrizione=" + descrizione
			+ ", numFollower=" + numFollower + ", numSeguiti=" + numSeguiti + ", numPost=" + numPost + 
			", esiste=" + esiste + ", pswCambiata=" + pswCambiata + ", isLoggato=" + isLoggato + ", psw=" + psw
			+ ", immagineProfilo=" + immagineProfilo + "]";
}
public String getPsw() {
	return psw;
}
public void setPsw(String psw) {
	this.psw = psw;
}
public String getImmagineProfilo() {
	return immagineProfilo;
}
public void setImmagineProfilo(String immagineProfilo) {
	this.immagineProfilo = immagineProfilo;
}

}
