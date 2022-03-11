package Utente;

import Utente.credenziali.Credenziali;
import Utente.exception.AccountDoesNotExist;
import Utente.exception.ChangeDefaultPassword;
import Utente.exception.ChangePassword;
import Utente.exception.PswOmailErrati;
import db.profilo.ProfiloDao;
import profilo.EnumProfilo;
import profilo.Profilo;
import profilo.utility.ProfiloUtility;

public class Utente {
	private Credenziali c;
	private boolean loggato;
	private boolean accountEsistente;
	private boolean pswDaCambiare;
	private String idUtente;
	
	public Utente(Credenziali c, boolean loggato, boolean accountEsistente, boolean pswDaCambiare, String idUtente) {
		this.c = c;
		this.loggato = false;
		this.accountEsistente = false;
		this.pswDaCambiare = true;
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

	public boolean isPswDaCambiare() {
		return pswDaCambiare;
	}

	public void setPswDaCambiare(boolean pswDaCambiare) {
		this.pswDaCambiare = pswDaCambiare;
	}

	public String getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(String idUtente) {
		this.idUtente = idUtente;
	}

	@Override
	public String toString() {
		return " [c=" + c + ", loggato=" + loggato + ", accountEsistente=" + accountEsistente + ", pswDaCambiare="
				+ pswDaCambiare + ", idUtente=" + idUtente + "]";
	}


	//Permette di cambiare la password di default
	//E' obbligatorio farlo prima di procedere 
	public boolean cambiaDefaultPassword (String nuovaPsw) throws ChangeDefaultPassword {
		if(this.isPswDaCambiare() == true && c.getPwd().equals("Cambiami") && nuovaPsw != "Cambiami") {
			this.c.setPwd(nuovaPsw);
			this.setPswDaCambiare(false);
			System.out.println("Password di default cambiata successo");
			return true;
		}
		else
		    throw new ChangeDefaultPassword(this.getC());
	}
	
	
	//Permette di settare una nuova password sostituendo quella scelta in precedenza dall'utente
	public boolean cambiaPassword(String vecchiaPassword, String nuovaPassword) throws ChangeDefaultPassword, ChangePassword {
		if(this.isPswDaCambiare() == true)
			throw new ChangeDefaultPassword(this.getC());
		else if(c.getPwd().equals(vecchiaPassword)) {
			this.c.setPwd(nuovaPassword);
			System.out.println("Password cambiata con successo");
			return true;
		}
		throw new ChangePassword(this.getC());
	}
	
	
	//Carica il profilo passato nel database 
	public boolean caricaProfilo(Profilo p) {
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility u = new ProfiloUtility();
		boolean b = pdao.inserisciProfilo(u.convertiAProfiloDB(p));
		pdao.inserisciChiavi(u.convertiAProfiloDB(p));
		return b;
	}
	
	
	//Crea il profilo e lo carica nel database
	public Profilo creaProfilo(String idProfilo, String nickname, String descrizione, int numFollower, int numSeguiti, int numPost,
			EnumProfilo tipo, String messaggioDiGruppo, String messaggioPrivato, Utente utente, String post) throws ChangeDefaultPassword {
		if(utente.isPswDaCambiare() == true)
			throw new ChangeDefaultPassword(this.getC());
		else if(utente.isAccountEsistente() == false) {
		    Profilo p = new Profilo(idProfilo, nickname, descrizione, numFollower, numSeguiti, numPost, tipo, messaggioDiGruppo, messaggioPrivato, utente, post);
		    p.getUtente().setAccountEsistente(true);
            this.caricaProfilo(p);
            System.out.println("Profilo creato con successo");
            return p;
		}
		return null;
	}
	
	
	//Se ho già creato un profilo con quelle caratteristiche verrà restituito true
	public boolean accountEsistente(Profilo p) {
		boolean b = p.getUtente().isAccountEsistente();
		return b;
	}
	
	public boolean login(Profilo p, String email, String psw) throws ChangeDefaultPassword, AccountDoesNotExist, PswOmailErrati {
		if(this.isPswDaCambiare() == true)
			throw new ChangeDefaultPassword(this.getC());
		else if (this.accountEsistente(p) == false)
			throw new AccountDoesNotExist(p);
		else if(this.getC().getEMail().equals(email) && this.getC().getPwd().equals(psw)) {
			this.setLoggato(true);
			System.out.println("Hai effettuato con successo il login");
			return true;
		}
		throw new PswOmailErrati(email,psw);
		
	}
	
	public boolean rimuoviAccount(Profilo p) {
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility u = new ProfiloUtility();
		return pdao.rimuoviProfilo(u.convertiAProfiloDB(p));
	}
	
}