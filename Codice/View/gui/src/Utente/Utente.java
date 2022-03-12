package Utente;

import java.util.ArrayList;

import Utente.credenziali.Credenziali;
import Utente.exception.AccountDoesNotExist;
import Utente.exception.AccountGiaEsistente;
import Utente.exception.ChangeDefaultPassword;
import Utente.exception.ChangePassword;
import Utente.exception.PswOmailErrati;
import db.profilo.ProfiloDB;
import db.profilo.ProfiloDao;
import profilo.EnumProfilo;
import profilo.Profilo;
import profilo.utility.ProfiloUtility;

public class Utente {
	private Credenziali c;
	private boolean loggato;
	private boolean accountEsistente;
	private boolean isPswCambiata;
	private String idUtente;
	
	public Utente(Credenziali c, boolean loggato, boolean accountEsistente, boolean isPswCambiata, String idUtente) {
		this.c = c;
		this.loggato = false;
		this.accountEsistente = false;
		this.isPswCambiata = false;
		this.idUtente = idUtente;
	}

	public Credenziali getC() {
		return c;
	}

	public void setC(Credenziali c) {
		this.c = c;
	}

	public boolean isLoggato() {
		return loggato;
	}

	public void setLoggato(boolean loggato) {
		this.loggato = loggato;
	}

	public boolean isAccountEsistente() {
		return accountEsistente;
	}

	public void setAccountEsistente(boolean accountEsistente) {
		this.accountEsistente = accountEsistente;
	}

	public boolean isPswCambiata() {
		return isPswCambiata;
	}

	public void setPswCambiata(boolean isPswCambiata) {
		this.isPswCambiata = isPswCambiata;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	@Override
	public String toString() {
		return "Utente [c=" + c + ", loggato=" + loggato + ", accountEsistente=" + accountEsistente + ", isPswCambiata="
				+ isPswCambiata + ", idUtente=" + idUtente + "]";
	}


	//Crea il profilo e lo carica nel database
		public Profilo creaProfilo(String idProfilo, String nickname, String descrizione, int numFollower, int numSeguiti, int numPost,
				EnumProfilo tipo, String messaggioDiGruppo, String messaggioPrivato, Utente utente, String post) throws AccountGiaEsistente{	
			    ProfiloDao pdao = new ProfiloDao();
			    ProfiloUtility u = new ProfiloUtility();
			    Profilo p = new Profilo(idProfilo, nickname, descrizione, numFollower, numSeguiti, numPost, tipo, messaggioDiGruppo, messaggioPrivato, utente, post);
			    
			    ArrayList<ProfiloDB> r = pdao.cercaProfilo(u.convertiAProfiloDB(p));
			   
			    if(r.isEmpty() == true) {
			        this.caricaProfilo(p);
			        p.getUtente().setAccountEsistente(true);
			        pdao.modificaEsiste(idProfilo, true);
	                System.out.println("Profilo creato con successo");
	                return p;
	            }
			  throw new AccountGiaEsistente(idProfilo);  
		}
	
	
	//Permette di cambiare la password di default
	//E' obbligatorio farlo prima di procedere 
	public boolean cambiaDefaultPassword (Profilo p, String nuovaPsw) throws ChangeDefaultPassword, AccountDoesNotExist {
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility u = new ProfiloUtility();
		
		ArrayList<ProfiloDB> res = pdao.cercaProfilo(u.convertiAProfiloDB(p));
		String s = pdao.ottieniPsw(p.getIdProfilo());
	
		//Se provo a cambiare psw ad un account che non esiste viene lanciata una eccezione
		if(res.isEmpty() == false && pdao.vediSeEsiste(p.getIdProfilo()) == true) {
			 
		     if(this.isPswCambiata() == false && s.equals("Cambiami") && nuovaPsw != "Cambiami") {
			     this.c.setPwd(nuovaPsw);
			     this.setPswCambiata(true);
			     pdao.modificaPsw(p.getIdProfilo(), nuovaPsw);
			     pdao.modificaPswCambiata(p.getIdProfilo(), true);
			     System.out.println("Password di default cambiata successo");
			     return true;
		      }
		
		    throw new ChangeDefaultPassword(this.getC());
		}
		else
		    throw new AccountDoesNotExist(p.getIdProfilo());
	}
	
	
	//Permette di settare una nuova password sostituendo quella scelta in precedenza dall'utente
	public boolean cambiaPassword(Profilo p, String vecchiaPassword, String nuovaPassword) throws ChangeDefaultPassword, ChangePassword, AccountDoesNotExist {
		
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility u = new ProfiloUtility();
		
		ArrayList<ProfiloDB> res = pdao.cercaProfilo(u.convertiAProfiloDB(p));
		String s = pdao.ottieniPsw(p.getIdProfilo());
	
		if(res.isEmpty() == false && pdao.vediSeEsiste(p.getIdProfilo()) == true) {
		
		    if(pdao.vediSePswCambiata(p.getIdProfilo()) == false)
			   throw new ChangeDefaultPassword(this.getC());
		    else if(s.equals(vecchiaPassword)) {
		     	this.c.setPwd(nuovaPassword);
		     	 pdao.modificaPsw(p.getIdProfilo(), nuovaPassword);
			     System.out.println("Password cambiata con successo");
			     return true;
		}
		throw new ChangePassword(this.getC());
	}
		else
		    throw new AccountDoesNotExist(p.getIdProfilo());
	}
	
	
	//Carica il profilo passato nel database 
	public boolean caricaProfilo(Profilo p) {
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility u = new ProfiloUtility();
		boolean b = pdao.inserisciProfilo(u.convertiAProfiloDB(p));
		pdao.inserisciChiavi(u.convertiAProfiloDB(p));
		return b;
	}
	
	
	//Se ho già creato un profilo con quelle caratteristiche verrà restituito true
	public boolean accountEsistente(Profilo p) {
		boolean b = p.getUtente().isAccountEsistente();
		return b;
	}
	
	
	
	public boolean login(Profilo p, String email, String psw) throws ChangeDefaultPassword, AccountDoesNotExist, PswOmailErrati {
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility u = new ProfiloUtility();
		
		ArrayList<ProfiloDB> res = pdao.cercaProfilo(u.convertiAProfiloDB(p));
		String s = pdao.ottieniPsw(p.getIdProfilo());
		
		if(res.isEmpty() == false && pdao.vediSeEsiste(p.getIdProfilo()) == true) {
	
	           if(pdao.vediSePswCambiata(p.getIdProfilo()) == false)
			        throw new ChangeDefaultPassword(this.getC());
		       else if(this.getC().getEMail().equals(email) && s.equals(psw)) {
	 	         	this.setLoggato(true);
			        pdao.modificaIsLoggato(p.getIdProfilo(), true);
			        System.out.println("Hai effettuato con successo il login");
			        return true;
		}
		  throw new PswOmailErrati(email,psw);
		}
		else
		    throw new AccountDoesNotExist(p.getIdProfilo());
	}
	
	
	public boolean rimuoviAccount(Profilo p) {
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility u = new ProfiloUtility();
		return pdao.rimuoviProfilo(u.convertiAProfiloDB(p));
	}

	
	public boolean logout(Profilo p) throws AccountDoesNotExist {
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility u = new ProfiloUtility();
		
		ArrayList<ProfiloDB> res = pdao.cercaProfilo(u.convertiAProfiloDB(p));
		boolean b = pdao.vediSeIsLoggato(p.getIdProfilo());
		
		if(res.isEmpty() == false && pdao.vediSeEsiste(p.getIdProfilo()) == true) {
			if(b == true) {
				this.setLoggato(false);
				pdao.modificaIsLoggato(p.getIdProfilo(), false);
				System.out.println("Hai effettuato il logout con successo");
				return true;
			}
			else 
				System.out.println("Logout non riuscito");
				return false;
		}
	else
	    throw new AccountDoesNotExist(p.getIdProfilo());
	}
	
}