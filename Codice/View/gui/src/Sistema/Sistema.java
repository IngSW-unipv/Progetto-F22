package Sistema;

import db.facade.DbFacade;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.Multimedia;
import post.multimedia.foto.Foto;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;

import java.util.ArrayList;


import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.ChatDiGruppo;
import profilo.exception.*;
import profilo.*;

public class Sistema {
	
	private DbFacade dbfacade;
	private Profilo profiloAttivo = null;
	private Profilo profiloCercato,  profiloConCuiSiStaChattando;
	private ChatDiGruppo chatCercata;
	public Sistema()   {
		dbfacade = DbFacade.getIstance();
	}
	
	/**
	 * Permette ad un profilo di iscriversi al social network
	 * @param mail scelta 
	 * @param nickname scelto
	 * @param password scelta
	 * @return true se l'account viene creato con successo
	 * @exception eccezione se non ho cambiato la password di default
	 * @exception Eccezione se l'account che sto creando esiste già
	 */
	public boolean signIn(String mail, String nickName, String password) throws AccountGiaEsistente, ChangeDefaultPassword, AccountDoesNotExist {
		Profilo p =  new Profilo(mail, nickName);
		
	    if(dbfacade.cerca(p) == null) {
	    	System.out.println(p.getIdProfilo() + 1);
	        dbfacade.carica(p);
	        dbfacade.modificaEsiste(mail, true);
            this.getProfiloAttivo().cambiaDefaultPassword(password);
 			this.setProfiloAttivo(p);
            return true;
        }
	  throw new AccountGiaEsistente(mail);  
	}
    
	/**
	 * Permette ad un utente di loggarsi nel proprio profilo inserendo le proprie credenziale
	 * @param email del profilo
	 * @param password del profilo
	 * @return true se l'utente si locca correttamente
	 * @exception eccezione se non ho cambiato la password di default
	 * @exception Eccezione se l'account a cui sto cercando di accedere non esiste
	 *@exception Eccezione se la psw o la mail sono errati
	 */
	public boolean login(String email, String psw) throws ChangeDefaultPassword, AccountDoesNotExist, PswOmailErrati {
			
		if(dbfacade.vediPswCambiata(email) == false)
	 			throw new ChangeDefaultPassword("Cambiami");
	 		else if (dbfacade.vediEsiste(email) == false)
	 			throw new AccountDoesNotExist(email);
	 		else if(dbfacade.vediPsw(email).equals(psw)) {
	 			dbfacade.modificaLoggato(email, true);
	 			Profilo p = dbfacade.cerca(new Profilo(email,null));
	 	
	 			this.setProfiloAttivo(p);
	 			
	 			return true;
	 		}
	 		throw new PswOmailErrati(email,psw);
	 	}

	  
	/**
	 * Permette la ricerca di un oggetto nel database
	 */
	  public void ricerca(String idDaCercare) {
		  setProfiloCercato(dbfacade.cerca(new Profilo(idDaCercare)));
		  //chatCercata = dbfacade.cerca(new chatDiGruppo);
	  }


	  /**
		 * Permette ad un utente di uscire dal proprio account
		 * @param email del profilo
         * @return true se l'utente esegue correttamente il logout
		 *@exception Eccezione se l'account indicato non esiste
		 */
	 public boolean logout(String email) throws AccountDoesNotExist {
	 	
		 Profilo p = new Profilo(email,null);
		 boolean b = dbfacade.vediSeLoggato(email);

	 		if(dbfacade.cerca(p) != null && dbfacade.vediEsiste(email) == true) {
	 			if(b == true) {
	 				dbfacade.modificaLoggato(email, false);
	 				setProfiloAttivo(null);
	 			return true;
	 			}
	 			else 
	 				return false;
	 		}
	 	else
	 	    throw new AccountDoesNotExist(email);
	 }

	 /**
		 * Restituisce tutti i commenti sotto un post
		 * @param id del post a cui voglio vedere i commenti
		 * @return ArrayList con i Commenti di un relativo post
		 *@exception Eccezione se il post non è visibile
		 */
	public ArrayList<String> selectAllCommentiSottoPost(String idPost) throws PostNonVisibile {
		ArrayList<Commento> listaCommenti = new ArrayList<Commento>();
		ArrayList<String> listaTestiCommentiConInviante = new ArrayList<String>();
			
		listaCommenti =  profiloAttivo.selectAllCommentiSottoPost(new Foto(idPost));
			
		
		for(int i=0; i<listaCommenti.size(); i++) {
			listaTestiCommentiConInviante.add(listaCommenti.get(i).getProfilo());
			listaTestiCommentiConInviante.add(listaCommenti.get(i).getTesto());
		}
		return listaTestiCommentiConInviante;
	}
		
	/**
	 * Permette di inviare un messaggio
	 * @param testo del messaggio
	 * @param id del profilo inviante
	 * @param id del profilo che riceverà il messaggio
	 */
	public void scriviMessaggio(String testo, String inviante,String ricevente) {

 		int idMessage = (int)Math.round(Math.random() * 10000);
 		String idMessaggio = Integer.toString(idMessage);

 		if(dbfacade.cerca(new MessaggioPrivato(idMessaggio)) != null) {
 			scriviMessaggio(testo, inviante, ricevente);
 		}
 		profiloAttivo.scriviMessaggio(new MessaggioPrivato(idMessaggio, testo, inviante, ricevente));
	}
		
	public Profilo getProfiloAttivo() {
		return profiloAttivo;
	}

	public void setProfiloAttivo(Profilo profiloAttivo) {
		this.profiloAttivo = profiloAttivo;
	}

	public Profilo getProfiloCercato() {
		return profiloCercato;
	}

	public void setProfiloCercato(Profilo profiloCercato) {
		this.profiloCercato = profiloCercato;
	}

	public ChatDiGruppo getChatCercata() {
		return chatCercata;
	}

	public void setChatCercata(ChatDiGruppo chatCercata) {
		this.chatCercata = chatCercata;
	}

	public Profilo getProfiloConCuiSiStaChattando() {
		return profiloConCuiSiStaChattando;
	}

	public void setProfiloConCuiSiStaChattando(Profilo profiloConCuiSiStaChattando) {
		this.profiloConCuiSiStaChattando = profiloConCuiSiStaChattando;
	}
	
	public void aggiungiPartecipante(String idGruppo, String idProfilo) {
		profiloAttivo.aggiungiPartecipante(idGruppo, idProfilo);
	}

}

