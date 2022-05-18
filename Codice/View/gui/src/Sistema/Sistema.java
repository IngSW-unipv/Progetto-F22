package Sistema;

import db.facade.DbFacade;
import java.util.ArrayList;

import profilo.exception.*;
import profilo.*;

public class Sistema {
	
	private DbFacade dbfacade;
	private Profilo profiloAttivo = null;
	public Sistema()   {
		dbfacade = DbFacade.getIstance();
	}
	
	//idProfilo e Mail sono la stessa ( va sistemato il database )
	public boolean signIn(String mail, String nickName, String password) throws AccountGiaEsistente, ChangeDefaultPassword, AccountDoesNotExist {
		Profilo p =  new Profilo(mail, nickName);
	    ArrayList<Profilo> r = new ArrayList<>();
	    r.add(dbfacade.cercaProfilo(p));

	    if(r.isEmpty() == true) {
	        dbfacade.carica(p);
	        dbfacade.modificaEsiste(mail, true);
            this.cambiaDefaultPassword(mail, password);
            return true;
        }
	  throw new AccountGiaEsistente(mail);  
	}
	

		public boolean cambiaDefaultPassword (String email, String nuovaPsw) throws ChangeDefaultPassword, AccountDoesNotExist {
			
	 		ArrayList<Profilo> res = new ArrayList<>();
	 		res.add(dbfacade.cercaProfilo(new Profilo(email, null)));
	 		String s = dbfacade.vediPsw(email);

        
	 		//Se provo a cambiare psw ad un account che non esiste viene lanciata una eccezione
	 	if(res.isEmpty() == false && dbfacade.vediEsiste(email) == true) {
	 		if(s.equals("Cambiami") && nuovaPsw != "Cambiami") {
	 			dbfacade.modificaPsw(email, nuovaPsw);
	 			dbfacade.modificaPswCambiata(email, true);
	 				return true;
	 		      }
	 		    throw new ChangeDefaultPassword("Cambiami");
	 		}
	 		else
	 		    throw new AccountDoesNotExist(email);
	 	}

    public boolean cambiaPassword(String email, String vecchiaPassword, String nuovaPassword) throws ChangeDefaultPassword, AccountDoesNotExist {
    	
	 ArrayList<Profilo> res = new ArrayList<>();
	 	    res.add(dbfacade.cercaProfilo(new Profilo(email, null)));
	 		String s = dbfacade.vediPsw(email);

	 		if(res.isEmpty() == false && dbfacade.vediEsiste(email) == true) {

	 		    if(dbfacade.vediPswCambiata(email) == false)
	 			   throw new ChangeDefaultPassword("Cambiami");

	 		    else if(s.equals(vecchiaPassword)) {
	 		    	dbfacade.modificaPsw(email, nuovaPassword);
	 		    		return true;
	 		}
	 	}
	 		else
	 		    throw new AccountDoesNotExist(email);
		return false;
	 	}

    
	public boolean login(String email, String psw) throws ChangeDefaultPassword, AccountDoesNotExist, PswOmailErrati {
	 		if(dbfacade.vediPswCambiata(email) == false)
	 			throw new ChangeDefaultPassword("Cambiami");
	 		else if (dbfacade.vediEsiste(email) == false)
	 			throw new AccountDoesNotExist(email);
	 		else if(dbfacade.vediPsw(email).equals(psw)) {
	 			dbfacade.modificaLoggato(email, true);
	 			setProfiloAttivo(dbfacade.cercaProfilo(new Profilo(email,null)));
	 			return true;
	 		}
	 		throw new PswOmailErrati(email,psw);
	 	}

	
	
	 public boolean rimuoviAccount(Profilo p) {
	 	return dbfacade.rimuovi(p);
	 }

	 
	 
	 public boolean logout(String email) throws AccountDoesNotExist {
	 	
        	ArrayList<Profilo> res = new ArrayList<>();
	 			res.add	(dbfacade.cercaProfilo(new Profilo(email,null)));
	 		boolean b = dbfacade.vediSeLoggato(email);

	 		if(res.isEmpty() == false && dbfacade.vediEsiste(email) == true) {
	 			if(b == true) {
	 				dbfacade.modificaLoggato(email, false);
	 				System.out.println("Hai effettuato il logout con successo");
	 				setProfiloAttivo(null);
	 			return true;
	 			}
	 			else 
	 				return false;
	 		}
	 		
	 	else
	 	    throw new AccountDoesNotExist(email);
	 }
	 	

	 	public void stampaTuttiIprofilo() {
	 		ArrayList<Profilo> res = dbfacade.selectAllProfilo();
	 		for(Profilo prof : res)
	 			System.out.println(prof.toString());
	 	}
	 	
	 

	public Profilo getProfiloAttivo() {
		return profiloAttivo;
	}

	public void setProfiloAttivo(Profilo profiloAttivo) {
		this.profiloAttivo = profiloAttivo;
	}
	 

}

