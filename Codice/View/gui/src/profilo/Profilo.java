package profilo;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Scanner;

import Sistema.Sistema;
import chat.Chat;
import chat.chatDiGruppo.gruppo.Gruppo;
import chat.chatPrivata.ChatPrivata;
import db.facade.DbFacade;
import db.follow.FollowDB;
import db.profilo.ProfiloDB;
import db.profilo.follow.Follow;
import post.Post;
import post.commento.Commento;
import profilo.credenziali.Credenziali;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.NotLoggedIn;

public class Profilo implements IProfilo { 

	private DbFacade dbfacade;
	
	private String idProfilo;
	private String nickname;
	private String descrizione;
	private int numFollower;
	private int numSeguiti;
	private int numPost;
	private EnumProfilo tipo;
	private String password;
	private boolean loggato;
	private boolean accountesistente;
	private boolean isPswCambiata;
	
	//funzione richiamata dal signUP
	public Profilo(String idProfilo, String nickname) {
		super();
		this.dbfacade = dbfacade.getIstance();
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = null;
		this.numFollower = 0;
		this.numSeguiti = 0;
		this.numPost = 0;
		this.tipo = tipo.PUBBLICO;
	}

	//costruttore per la conversione profiloDB
	public 	Profilo(String idProfilo, String nickname, String descrizione, EnumProfilo visibilita) {
		this.dbfacade = dbfacade.getIstance();
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = descrizione;
		this.numFollower = 0;
		this.numSeguiti = 0;
		this.numPost = 0;
		this.tipo = visibilita;
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

@Override
//Ritorna true se l'account inserito è "seguibile"
public boolean profiloNonSeguito(String emailProfilo) {
	ArrayList<FollowDB> search = dbfacade.cercaFollow(this.getIdProfilo(), emailProfilo);
	if (search.isEmpty() == true) {
		return true;
	}
	return false;
}

@Override
//Ritorna true se l'account è esistente
public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist {
	ArrayList<ProfiloDB> res = dbfacade.cercaProfilo(emailProfilo);
	if(res.isEmpty() == true) {
		throw new AccountDoesNotExist(emailProfilo);
	}
	return true;
}

@Override
//Ritorna true se l'account è loggato
public boolean seiLoggato(String emailProfilo) throws AccountDoesNotExist, NotLoggedIn {
	if(this.accountEsistente(emailProfilo) == true) {
		if(dbfacade.vediSeLoggato(emailProfilo) == true) {
			return true;
		}
		throw new NotLoggedIn(emailProfilo);
	}
	return false;
}

@Override
public boolean segui(String profiloSeguito) throws AccountDoesNotExist, NotLoggedIn {
	
	if(this.profiloNonSeguito(profiloSeguito) == true && this.accountEsistente(profiloSeguito) == true && this.seiLoggato(this.getIdProfilo()) == true) {
	Follow f = new Follow(this.idProfilo, profiloSeguito);
	dbfacade.carica(f);
	System.out.println("Hai cominciato a seguire con successo l'account : " + profiloSeguito);
	return true;	
	}
	return false;
}
@Override
public boolean smettiDiSeguire(String profiloSeguito) throws AccountDoesNotExist, NotLoggedIn {
	if(this.seiLoggato(this.getIdProfilo()) == true && this.accountEsistente(profiloSeguito) == true && this.profiloNonSeguito(profiloSeguito) == false) {
		dbfacade.rimuovi(this.getIdProfilo(), profiloSeguito);
		System.out.println("Hai smesso di seguire l'account : " + profiloSeguito);
		return true;
	}
	return false;
}

@Override
public ArrayList<ProfiloDB> mostraInformazioniProfilo() throws AccountDoesNotExist, NotLoggedIn {
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.selectAllProfilo();
	}
	return null;
}

@Override
public boolean pubblicaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String post) throws AccountDoesNotExist, NotLoggedIn {
	Commento c = new Commento(idCommento,oraCommento,dataCommento,testo,post);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.carica(c);
	}
	return false;
}

/*
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
public boolean personalizzaSfondo() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void visualizzaChat(Chat c) {
	// TODO Auto-generated method stub
	
}
@Override
public boolean modificaDatiChat(Chat c) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean cancellaMessaggio() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean scriviMessaggio() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean entraInGruppo(Gruppo g) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean accettaRichiestaDinvito() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void apriChatPrivata(ChatPrivata c) {
	// TODO Auto-generated method stub
	
}
@Override
public boolean invitaUtenteAdIscriversi(Profilo p) {

	Scanner scan = new Scanner(System.in);
	System.out.println("Digita il nome dell'utente da invitare");
	
	String nomeUtente = scan.nextLine();
	// non ho finito
	return false;
}
@Override
public boolean posta(Post p) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean eliminaUnPost(Post p) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean modificaPost(Post p) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public boolean commentaPost(Post p) {
	// TODO Auto-generated method stub
	return false;
}
@Override
public void visualizzaPost(Post p) {
	// TODO Auto-generated method stub
	
}
@Override
public boolean aggiungiSegnaLibro() {
	// TODO Auto-generated method stub
	return false;
}
@Override
public int modificaLike(Post p) {
	// TODO Auto-generated method stub
	return 0;
}


@Override
public Credenziali modificaDatiPersonali(Credenziali c) {

	return c.modificaDatiPersonali();
	}

@Override
public void bloccaProfilo(Profilo p) {
	// TODO Auto-generated method stub
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



//>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
}
