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
import db.profilo.ProfiloDB;
import post.Post;
import post.commento.Commento;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.NotLoggedIn;
import profilo.follow.Follow;

public class Profilo implements IProfilo { 

	private static DbFacade dbfacade;
	
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

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



@Override
//Ritorna true se l'account inserito è "seguibile"
public boolean profiloNonSeguito(String emailProfilo) {
	Follow f = new Follow(this.getIdProfilo(),emailProfilo);
	if (dbfacade.profiloNonSeguito(f) == true) {
		return true;
	}
	return false;
}

@Override
//Ritorna true se l'account è esistente
public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist {
	Profilo p = new Profilo(emailProfilo,null);
	if(dbfacade.accountEsistente(p) == false) {
		throw new AccountDoesNotExist(emailProfilo);
	}
	return true;
}

@Override
//Ritorna true se l'account è loggato
public boolean seiLoggato(String emailProfilo) throws AccountDoesNotExist, NotLoggedIn {
	if(dbfacade.seiLoggato(emailProfilo) == true) {
			return true;
		}
		throw new NotLoggedIn(emailProfilo);
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
		Follow f = new Follow(this.getIdProfilo(),profiloSeguito);
		dbfacade.rimuovi(f);
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

@Override
public ArrayList<ProfiloDB> ottieniListaProfilo() throws AccountDoesNotExist, NotLoggedIn {
	if (this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.selectAllProfilo();
	} else {
	return null;
	}
}

@Override
public boolean pubblicaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
		boolean visibile, boolean condivisibile, String profilo, String percorso, boolean isHd)
		throws AccountDoesNotExist, NotLoggedIn {
	      
	       Foto f = new Foto(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo, percorso, isHd);
	       if(this.seiLoggato(this.getIdProfilo() ) == true){
	    	 return dbfacade.carica(f); 
	      } else {
	              return false;
	             }
}

@Override
public boolean pubblicaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
		boolean visibile, boolean condivisibile, String profilo, String percorso, int durataInSecondi)
		throws AccountDoesNotExist, NotLoggedIn {
	
	    Video v = new Video(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo,
	    		             percorso, durataInSecondi);
	    if(this.seiLoggato(this.getIdProfilo()) == true) {
	    	return dbfacade.carica(v);
	    } else {
	            return false;
	           }
}

@Override
public boolean pubblicaSondaggioSceltaMultipla(String idPost, Date dataPubblicazione, Time oraPubblicazione,
		                                       String descrizione, boolean visibile, boolean condivisibile, 
		                                       String profilo, String primaScelta,String secondaScelta, int[] conteggio) 
		                                       throws AccountDoesNotExist, NotLoggedIn {
	
	SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, 
			                                                profilo, primaScelta, secondaScelta, secondaScelta, primaScelta, conteggio);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.carica(s);
	} else {
	       return false;
	       }
}

@Override
public boolean pubblicaSondaggioDoppiaVotazione(String idPost, Date dataPubblicazione, Time oraPubblicazione,String descrizione, 
		                                        boolean visibile, boolean condivisibile, String profilo, String primaScelta,
		                                        String secondaScelta, String terzaScelta, String quartaScelta, int[] conteggio)
		                                        throws AccountDoesNotExist, NotLoggedIn {
	
	SondaggioDoppiaVotazione sdp = new SondaggioDoppiaVotazione(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile,
			                                                    profilo, primaScelta, secondaScelta, conteggio);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.carica(sdp);
	} else {
	        return false;
	       }
}

@Override
public boolean pubblicaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, 
		                     boolean condivisibile, String profilo, String font, String titolo)
		                     throws AccountDoesNotExist, NotLoggedIn {
	
	Testo t = new Testo(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo, font, titolo);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.carica(t);
	} else {
	        return false;
	       }
}

@Override
public boolean rimuoviCommento(String idCommento) throws AccountDoesNotExist, NotLoggedIn {
	
	Commento c = new Commento(idCommento, null, null, null, null);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.rimuovi(c);
	} else {
	        return false;
	       }
}

@Override
public boolean rimuoviFoto(String idPost) throws AccountDoesNotExist, NotLoggedIn {
	
	Foto f = new Foto(idPost, null, null, null, false, false, null, null, false);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.rimuovi(f);
	} else {
	        return false;
	       }
}

@Override
public boolean rimuoviVideo(String idPost) throws AccountDoesNotExist, 
                            NotLoggedIn {
	
	Video v = new Video(idPost, null, null, null, false, false, null, null, 0);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.rimuovi(v);
	} else {
	        return false;
	       }
}

@Override
public boolean rimuoviSondaggioSceltaMultipla(String idPost) throws AccountDoesNotExist, NotLoggedIn {
	
	SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(idPost, null, null, null, false, false, 
			                                                 null, null, null, null, null, null);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.rimuovi(s);
	} else {
	        return false;
	       }
}

@Override
public boolean rimuoviSondaggioDoppiaVotazione(String idPost) throws AccountDoesNotExist, NotLoggedIn {
	
	SondaggioDoppiaVotazione sdp = new SondaggioDoppiaVotazione(idPost, null, null, null, false, false, 
			                                                    null, null, null, null);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.rimuovi(sdp);
	} else {
	        return false;
	       }
}


@Override
public boolean rimuoviTesto(String idPost) throws AccountDoesNotExist, NotLoggedIn {
	
	Testo t = new Testo(idPost, null, null, null, false, false, null, null, null);
	if(this.seiLoggato(this.getIdProfilo()) == true) {
		return dbfacade.rimuovi(t);
	} else {
	        return false;
	       }
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


	



}
