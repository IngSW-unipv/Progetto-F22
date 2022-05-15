package Sistema;

import db.facade.DbFacade;
import db.profilo.ProfiloDB;

import java.util.ArrayList;

import profilo.exception.*;
import profilo.*;

public class Sistema {

	private DbFacade dbfacade;
	
	public Sistema()   {
		dbfacade = DbFacade.getIstance();
	}
	
	//idProfilo e Mail sono la stessa ( va sistemato il database )
	public boolean signIn(String mail, String nickName) throws AccountGiaEsistente {
		Profilo p =  new Profilo(mail, nickName);
	    ArrayList<ProfiloDB> r = dbfacade.cerca(new Profilo(mail));
	    if(r.isEmpty() == true) {
	        dbfacade.carica(p);
	        dbfacade.modificaEsiste(mail, true);
            System.out.println("il Profilo di " + mail + " è stato creato con successo");
            return true;
        }
	  throw new AccountGiaEsistente(mail);  
	}
	
	public boolean cambiaDefaultPassword (String email, String nuovaPsw) throws ChangeDefaultPassword, AccountDoesNotExist {
	 	ArrayList<ProfiloDB> res =dbfacade.cercaProfilo(email);
	 	String s = dbfacade.vediPsw(email);
        
	 		//Se provo a cambiare psw ad un account che non esiste viene lanciata una eccezione
	 	if(res.isEmpty() == false && dbfacade.vediEsiste(email) == true) {
	 		if(s.equals("Cambiami") && nuovaPsw != "Cambiami") {
	 			dbfacade.modificaPsw(email, nuovaPsw);
	 			dbfacade.modificaPswCambiata(email, true);
	 			System.out.println("Password di default cambiata successo");
	 				return true;
	 		      }
	 		    throw new ChangeDefaultPassword("Cambiami");
	 		}
	 		else
	 		    throw new AccountDoesNotExist(email);
	 	}

    public boolean cambiaPassword(String email, String vecchiaPassword, String nuovaPassword) throws ChangeDefaultPassword, ChangePassword, AccountDoesNotExist {
    	ArrayList<ProfiloDB> res = dbfacade.cercaProfilo(email);
	 	String s = dbfacade.vediPsw(email);

	 	if(res.isEmpty() == false && dbfacade.vediEsiste(email) == true) {

	 		if(dbfacade.vediPswCambiata(email) == false)
	 			throw new ChangeDefaultPassword("Cambiami");
	 		    else if(s.equals(vecchiaPassword)) {
	 		    	dbfacade.modificaPsw(email, nuovaPassword);
	 		    	System.out.println("Password cambiata con successo");
	 		    		return true;
	 		}
	 		throw new ChangePassword(vecchiaPassword);
	 	}
	 		else
	 		    throw new AccountDoesNotExist(email);
	 	}

	public boolean login(String email, String psw) throws ChangeDefaultPassword, AccountDoesNotExist, PswOmailErrati {
	 		if(dbfacade.vediPswCambiata(email) == false)
	 			throw new ChangeDefaultPassword("Cambiami");
	 		else if (dbfacade.vediEsiste(email) == false)
	 			throw new AccountDoesNotExist(email);
	 		else if(dbfacade.vediPsw(email).equals(psw)) {
	 			dbfacade.modificaLoggato(email, true);
	 			System.out.println("Hai effettuato con successo il login");
	 			return true;
	 		}
	 		throw new PswOmailErrati(email,psw);
	 	}

	 public boolean rimuoviAccount(Profilo p) {
	 	return dbfacade.rimuovi(p);
	 }

	 public boolean logout(String email) throws AccountDoesNotExist {
	 	ArrayList<ProfiloDB> res = dbfacade.cercaProfilo(email);
	 	boolean b = dbfacade.vediSeLoggato(email);

	 	if(res.isEmpty() == false && dbfacade.vediEsiste(email) == true) {
	 		if(b == true) {
	 			dbfacade.modificaLoggato(email, false);
	 			System.out.println("Hai effettuato il logout con successo");
	 				return true;
	 			}
	 			else 
	 			System.out.println("Logout non riuscito");
	 				return false;
	 		}
	 	else
	 	    throw new AccountDoesNotExist(email);
	 }
	 	
	 public void stampaTuttiIprofilo() {
	 	dbfacade.stampaSelectAllProfilo();
	 }
	 
}

