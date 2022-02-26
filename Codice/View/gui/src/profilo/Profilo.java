package profilo;

import java.util.Arrays;
import java.util.HashMap;

public class Profilo implements IProfilo{

public Profilo(String idProfilo, String nickname, String descrizione, int numFollower, int numSeguiti, int numPost,
			String tipo, String messaggioDiGruppo, String messaggioPrivato, String utente, String post) {
		super();
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = descrizione;
		this.numFollower = numFollower;
		this.numSeguiti = numSeguiti;
		this.numPost = numPost;
		this.tipo = tipo;
		this.messaggioDiGruppo = messaggioDiGruppo;
		this.messaggioPrivato = messaggioPrivato;
		this.utente = utente;
		this.post = post;
		listaSeguiti = new HashMap<>();
	}
private String idProfilo;
private String nickname;
private String descrizione;
private int numFollower;
private int numSeguiti;
private int numPost;
private String tipo;
private String messaggioDiGruppo;
private String messaggioPrivato;
private String utente;
private String post;
private HashMap <String,String> listaSeguiti;

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
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public String getMessaggioDiGruppo() {
	return messaggioDiGruppo;
}
public void setMessaggioDiGruppo(String messaggioDiGruppo) {
	this.messaggioDiGruppo = messaggioDiGruppo;
}
public String getMessaggioPrivato() {
	return messaggioPrivato;
}
public void setMessaggioPrivato(String messaggioPrivato) {
	this.messaggioPrivato = messaggioPrivato;
}
public String getUtente() {
	return utente;
}
public void setUtente(String utente) {
	this.utente = utente;
}
public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}

public void setListaSeguiti(HashMap<String, String> listaSeguiti) {
	this.listaSeguiti = listaSeguiti;
}

@Override
public HashMap<String,String> modificaFollow(Profilo p) {
    /* if (listaSeguiti.get(this.idProfilo) != p.idProfilo) {
    	    listaSeguiti.put(this.idProfilo, p.idProfilo);
    	    this.setNumSeguiti(this.getNumSeguiti() + 1);
    	    p.setNumFollower(p.getNumFollower() + 1);
     }
     else 
    	 listaSeguiti.remove(p.idProfilo);
     */
	 this.listaSeguiti.put(this.idProfilo, "cavallo");
	 this.listaSeguiti.put(this.idProfilo, "mucca");
	
     return listaSeguiti;
}
@Override
public boolean modificaLike(Profilo p) {
	// TODO Auto-generated method stub
	return false;
}
public HashMap<String, String> getListaSeguiti() {
	return listaSeguiti;
}
}