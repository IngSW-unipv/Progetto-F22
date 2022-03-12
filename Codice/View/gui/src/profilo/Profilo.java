package profilo;


import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;

import Utente.Utente;
import Utente.credenziali.Credenziali;
import chat.Chat;
import db.profilo.ProfiloDB;
import db.profilo.ProfiloDao;
import post.Post;
import post.commento.Commento;
import profilo.exception.NotLoggedIn;
import profilo.utility.ProfiloUtility;


public class Profilo implements IProfilo{

public Profilo(String idProfilo, String nickname, String descrizione, int numFollower, int numSeguiti, int numPost,
			EnumProfilo tipo, String messaggioDiGruppo, String messaggioPrivato, Utente utente, String post) {
		super();
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = descrizione;
		this.numFollower = 0;
		this.numSeguiti = 0;
		this.numPost = 0;
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
private EnumProfilo tipo;
private String messaggioDiGruppo;
private String messaggioPrivato;
private Utente utente;
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
public EnumProfilo getTipo() {
	return tipo;
}
public void setTipo(EnumProfilo tipo) {
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
public Utente getUtente() {
	return utente;
}
public void setUtente(Utente utente) {
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


public static ArrayList<ProfiloDB> cercaProfilo(Profilo p) throws NotLoggedIn{
	if(p.getUtente().isLoggato() == false)
		throw new NotLoggedIn(p);
	ProfiloDao pdao = new ProfiloDao();
	ProfiloUtility u = new ProfiloUtility();
	return pdao.cercaProfilo(u.convertiAProfiloDB(p));
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

@Override
public boolean modificaDislike(Profilo profilo) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public void vediStory() {
	// TODO Auto-generated method stub
	
}

@Override
public boolean commentare(Commento c) {
	return c.scriviCommento(c);
}

@Override
public void bloccaUtente(Utente u) {
	// TODO Auto-generated method stub
}


@Override
public void mostraInformazioniProfilo(Profilo p) {
	// TODO Auto-generated method stub
	if(p.getTipo() == EnumProfilo.PRIVATO) {
	p.selectAll();
	
	}
	else {
		
	}
}

@Override
public void mostraInformazioniPost(Post p) {

}

@Override
public boolean modificaDatiPersonali(Credenziali c) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean visualizzaProprioPost(Post p) {
	// TODO Auto-generated method stub
	return false;
}

@Override
public boolean eliminaProfilo(ProfiloDB p) {
	ProfiloDao pDao = new ProfiloDao();
	return pDao.rimuoviProfilo(p);
	
}
//<<<<<<< HEAD
@Override
public String toString() {
	return " [idProfilo=" + idProfilo + ", nickname=" + nickname + ", descrizione=" + descrizione
			+ ", numFollower=" + numFollower + ", numSeguiti=" + numSeguiti + ", numPost=" + numPost + ", tipo=" + tipo
			+ ", messaggioDiGruppo=" + messaggioDiGruppo + ", messaggioPrivato=" + messaggioPrivato + ", utente="
			+ utente + ", post=" + post + ", listaSeguiti=" + listaSeguiti + "]";
}
//=======

@Override
public Chat cercaChatAttiva(Chat chat) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Chat visualizzaChatAttiva(Chat chat) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Post segnaLibro(Post p) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public ArrayList<ProfiloDB> selectAll() {
	ProfiloDao pDao = new ProfiloDao();
	return pDao.selectAll();
}
@Override
public boolean caricaPost(Post p) {
	return true;
}
@Override
public boolean rimuoviPost(Post p) {
	return true;
}		
	
		  	

  


//>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git

	
	
	
	
	
}
