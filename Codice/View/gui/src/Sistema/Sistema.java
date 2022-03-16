package Sistema;

import db.facade.dbFacade;
import db.profilo.ProfiloDB;
import db.profilo.ProfiloDao;

import java.util.ArrayList;


import profilo.credenziali.Credenziali;
import profilo.exception.*;
import convertitore.ConvertitoreFacade;
import convertitore.profiloUtility.ProfiloUtility;
import post.*;
import profilo.*;

public class Sistema {
	private int n = 0;
	private Profilo profiloAttivo;
	private Profilo altroProfilo;
	private Post post;
	private dbFacade dbfacade;
	private ConvertitoreFacade convertitoreFacade;
	
	public Sistema() {
		dbfacade = new dbFacade();
		convertitoreFacade = new ConvertitoreFacade();
	}
	
	//Crea il profilo e lo carica nel database
		public Profilo creaProfilo(String idProfilo, String nickname, String descrizione,
				EnumProfilo tipo, String messaggioDiGruppo, String messaggioPrivato, String post) throws AccountGiaEsistente{	
			    Profilo p = new Profilo(idProfilo, nickname, descrizione, tipo);

			    ArrayList<ProfiloDB> r = dbfacade.cercaProfilo(idProfilo);
			    if(r.isEmpty() == true) {
			        dbfacade.carica(p);
			        p.setAccountesistente(true);
			        dbfacade.modificaEsiste(idProfilo, true);
	                System.out.println("Profilo creato con successo");
	                return p;
	            }
			  throw new AccountGiaEsistente(idProfilo);  
		}

		public boolean cambiaDefaultPassword (Profilo p, String nuovaPsw) throws ChangeDefaultPassword, AccountDoesNotExist {
	 		ProfiloDao pdao = new ProfiloDao();

	 		ArrayList<ProfiloDB> res =dbfacade.cercaProfilo(p.getIdProfilo());
	 		String s = dbfacade.vediPsw(p.getIdProfilo());
        
	 		//Se provo a cambiare psw ad un account che non esiste viene lanciata una eccezione
	 		if(res.isEmpty() == false && dbfacade.vediEsiste(p.getIdProfilo()) == true) {

	 		     if(p.isPswCambiata() == false && s.equals("Cambiami") && nuovaPsw != "Cambiami") {
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
	 		    throw new ChangeDefaultPassword(this.getC());
	 		    throw new AccountDoesNotExist(p.getIdProfilo());
	 	}


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
		
	public boolean signUp(String nickname, String eMail, String passWord) {
	    //int IdultimoProfiloCreato = Sistema. 
		setN(getN() + 1);
		String idProfilo = Integer.toString(getN() + 1);
		Profilo profiloAttivo = new Profilo(idProfilo, nickname, eMail, passWord);
		dbfacade.inserisciProfilo(convertitoreFacade.convertiProfilo(profiloAttivo));
		altroProfilo = convertitoreFacade.convertiProfilo(dbfacade.cercaProfilo(convertitoreFacade.convertiProfilo(profiloAttivo)).get(1));
		System.out.println("roba" + altroProfilo.getIdProfilo());
		//Per Francesco
		//Bisogna usare la funzione di profiloDao
		//simile a scrivi messaggio di chatPrivata
		return true;
	
	/*	boolean b;
		if(verificaEsistenzaAccount(u.getCredenziali().getEMail())) {
			b = p.inserisciProfilo(profiloCreato);
		}
		return b;*/
		//	profiloAttivo = new Profilo(nickname, pwd);
	}
	public boolean eliminaProfilo(Profilo p) {
		ProfiloDao pd = new ProfiloDao();
		return pd.rimuoviProfilo(ProfiloUtility.convertiAProfiloDB(p));
		
	} 
/*
	public boolean login(String eMail, String pwd) {
		verificaEsistenzaAccount(eMail);
		//codice per prelevare da sql un oggetto profilo
		Profilo profiloChiamato = ProfiloPrelevato();
		if (profiloChiamato.getPwd() == pwd)
		return true;
	    else
		return false;
	}
    */
	/*
	public boolean verificaEsistenzaAccount(String eMail) { //bisogna mettere le exception
		
		ProfiloDao pd = new ProfiloDao();
		Utente u = new Utente(); //servono le credenziali per l'utente
		
		for(Profilo altroProfilo : pd.selectAll()) {
			if(eMail == u.getCredenziali().getEMail()) {
				return true;
			}
		}
		
		return false;
	} */
	/*
	public boolean mettiLike(Post p) {
		p.setNumLike(p.getNumLike() + 1);
		return true;
	}
	
	public boolean togliLike(Post p) {
		p.setNumLike(p.getNumLike() - 1);
		return true;
	}
	
	public boolean mettiDislike(Post p) {
		p.setNumLike(p.getNumDislike() + 1);
		return true;
	}
	
	public boolean togliDislike(Post p) {
		p.setNumLike(p.getNumDislike() - 1);
		return true;
	}
	
	public void segui() {
		//codice da recuperare da database
		profiloAttivo.setNumFollower(altroProfilo.getNumFollower() + 1);
	}
	public void smettiDiSeguire() {
		profiloAttivo.setNumFollower(altroProfilo.getNumFollower() - 1);
	}
	
	public boolean pubblicaPost(Post p) {
		boolean b = profiloAttivo.caricaPost(p);
		return b;
	}
	
	public boolean rimuoviPost(Post p) {
		boolean b = profiloAttivo.rimuoviPost(p);
		return b;
	}
	*/
	public int getN() {
		return n;
	}
	public void setN(int n) {
		this.n = n;
	}
/*
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
	*/
	/*
    public static void main(String [] args) throws Exception {
    	
    ProfiloUtility u = new ProfiloUtility();
    Credenziali c = new Credenziali("Davide", "Mascheroni", null, null, null, "davide.mascheroni1234@gmail.com", null);
	Profilo p1 = new Profilo("P01", "MyAccount", "ds", null);
	Profilo p2 = new Profilo("001", "MyAccount", null, null);
	
	Profilo p3 =new Profilo("P02", "Davide99", "Mi piace programmare", "001");
	sistema.login(p3, "davide.mascheroni1234@gmail.com", "ciao");
	
	ArrayList<ProfiloDB> res = Profilo.cercaProfilo(p2);
	
	for(ProfiloDB pd: res)
		System.out.println(pd.toString());
    }   */
}

