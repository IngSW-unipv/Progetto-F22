package profilo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

import java.util.Set;

import Messaggio.Messaggio;
import chat.Chat;
import chat.chatPrivata.ChatPrivata;
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
	//private Credenziali c;
	private String password;
	private boolean loggato;
	private boolean accountesistente;
	private boolean isPswCambiata;
	
	//funzione richiamata dal signUP
	public Profilo(String idProfilo, String nickname) {
		super();
		// funzione per prelevare l'id piu alto dal database this.idProfilo = ;
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
		
		invitaUtenteAdIscriversi();
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


@Override
public void visualizzaChat(Chat chat) {
	// TODO Auto-generated method stub
	
}


@Override
public boolean modificaDatiChat(Chat chat) {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean cancellaMessaggio(Messaggio m) {
	
	return false;
}


@Override
public boolean scriviMessaggio(Messaggio m) {
	// TODO Auto-generated method stub
	return false;
}



@Override
public void entraInGruppo() {
	// TODO Auto-generated method stub
	
}


@Override
public boolean accettaRichiestaDinvito() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public void apriChatPrivata(ChatPrivata chat) {
	// TODO Auto-generated method stub
	
}



@Override
public void invitaUtenteAdIscriversi() {
	
	Profilo p = new Profilo(this.getIdProfilo(), this.getNickname());
	@SuppressWarnings("resource")
	Scanner scan = new Scanner(System.in);
	ArrayList<String> utenti = new ArrayList<>();
	System.out.println("Digita il nome dell'utente da invitare sul social");
	String nomeUtente = scan.nextLine();
	if(nomeUtente.equals(p.getNickname())) {
		//utenti.add(p.getNickname());
		System.out.println("Utente gia scritto");
	} else 
		utenti.add(nomeUtente);
		for (String string : utenti) {
			System.out.println(string);
			
		} 
		  // Deve inviare un messaggio al nomeUtente 
	     
	//@SuppressWarnings("rawtypes")
	//Iterator iterator = utenti.iterator();
	//while(utenti.get(0).equals(nomeUtente)) {
		//ArrayList<String> entry = (ArrayList<String>) iterator.next();
		//if(utenti.contains(nomeUtente)) {
			
			//p++;
			
			
	}
	 /*if(p == 0) {
		while(utenti..hasNext()) {
			//Entry<String, ArrayList<String>> ent = iterator.next();
			ArrayList<String> utenteSeguiti = new ArrayList<>();
			utenti.add(nomeUtente);
			utenti.addAll(utenteSeguiti);
			System.out.println("");
			
		}
	}*/
	
	
	



@Override
public Post posta(Post p) {
	// TODO Auto-generated method stub
	return null;
}


@Override
public boolean eliminaUnPost() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean modificaPost() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public String commentaPost() {
	// TODO Auto-generated method stub
	return null;
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
public boolean mettiDislike() {
	// TODO Auto-generated method stub
	return false;
}


@Override
public boolean signUp() {
	// TODO Auto-generated method stub
	return false;
}


//>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
}
