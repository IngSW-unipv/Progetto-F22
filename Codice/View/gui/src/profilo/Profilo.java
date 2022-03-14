package profilo;


import java.util.ArrayList;
//import java.util.Arrays;
import java.util.HashMap;

import chat.Chat;
import convertitore.profiloUtility.ProfiloUtility;
import db.profilo.ProfiloDB;
import post.Post;
import post.commento.Commento;
import profilo.credenziali.Credenziali;
import profilo.exception.NotLoggedIn;

public class Profilo implements IProfilo {

	private String idProfilo;
	private String nickname;
	private String descrizione;
	private int numFollower;
	private int numSeguiti;
	private int numPost;
	private EnumProfilo tipo;
	private String messaggioDiGruppo;
	private String messaggioPrivato;
	private String post;
	//private Credenziali c;
	private String password;
	private boolean loggato;
	private boolean accountesistente;
	private boolean isPswCambiata;
	
	//funzione richiamata dal signUP
	public Profilo(String idProfilo, String nickname,  String eMail, String passWord) {
		super();
		// funzione per prelevare l'id piu alto dal database this.idProfilo = ;
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = null;
		this.numFollower = 0;
		this.numSeguiti = 0;
		this.numPost = 0;
		this.tipo = tipo.PUBBLICO;
		this.messaggioDiGruppo = messaggioDiGruppo;
		this.messaggioPrivato = messaggioPrivato;
		this.post = post;
	}

	//costruttore per la conversione profiloDB
	public 	Profilo(String idProfilo, String nickname, String descrizione, EnumProfilo visibilita, String messaggioDiGruppo, String messaggioPrivato, String post) {
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = descrizione;
		this.numFollower = 0;
		this.numSeguiti = 0;
		this.numPost = 0;
		this.tipo = visibilita;
		this.messaggioDiGruppo = messaggioDiGruppo;
		this.messaggioPrivato = messaggioPrivato;
		this.post = post;
		this.loggato = false;
		this.accountesistente = false;
		this.isPswCambiata = false;
		this.password = "Cambiami";
	}


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

public String getPost() {
	return post;
}
public void setPost(String post) {
	this.post = post;
}


public boolean isLoggato() {
	return loggato;
}

public void setLoggato(boolean loggato) {
	this.loggato = loggato;
}

public boolean isAccountesistente() {
	return accountesistente;
}

public void setAccountesistente(boolean accountesistente) {
	this.accountesistente = accountesistente;
}

public boolean isPswCambiata() {
	return isPswCambiata;
}

public void setPswCambiata(boolean isPswCambiata) {
	this.isPswCambiata = isPswCambiata;
}
		  
/*

public static ArrayList<ProfiloDB> cercaProfilo(Profilo p) throws NotLoggedIn, AccountDoesNotExist{
	
	if(p.getUtente().ritornaLoggato(p) == false)
		throw new NotLoggedIn(p);
	else {
	ProfiloDao pdao = new ProfiloDao();
	ProfiloUtility u = new ProfiloUtility();
	return pdao.cercaProfilo(u.convertiAProfiloDB(p));
	}
	}


@Override
public HashMap<String,String> modificaFollow(Profilo p) {
     if (listaSeguiti.get(this.idProfilo) != p.idProfilo) {
    	    listaSeguiti.put(this.idProfilo, p.idProfilo);
    	    this.setNumSeguiti(this.getNumSeguiti() + 1);
    	    p.setNumFollower(p.getNumFollower() + 1);
     }
     else 
    	 listaSeguiti.remove(p.idProfilo);
     
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
*/
@Override
public int personalizzaSfondo() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int visualizzaChat() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int modificaDatiChat() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int cancellaMessaggio() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int scriviMessaggio() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int entraInGruppo() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int accettaRichiestaDinvito() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int apriChatPrivata() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int invitaUtenteAdIscriversi() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int posta() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int eliminaUnPost() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int modificaPost() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int commentaPost() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int visualizzaPost() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int aggiungiSegnaLibro() {
	// TODO Auto-generated method stub
	return 0;
}
@Override
public int mettiDislike() {
	// TODO Auto-generated method stub
	return 0;
}

@Override
public int signUp() {
	// TODO Auto-generated method stub
	return 0;
}

public String getPwd() {
	// TODO Auto-generated method stub
	return null;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}


//>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
}
