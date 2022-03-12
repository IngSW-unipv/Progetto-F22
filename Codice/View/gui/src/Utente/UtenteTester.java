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

public class UtenteTester {

	public static void main(String [] args) {
		Credenziali c = new Credenziali("Davide", "Mascheroni", null, null, null, "davide.mascheroni1234@gmail.com", null);
		Utente u = new Utente(c, false, false, false, "AB10");
		
		ProfiloDao pdao = new ProfiloDao();
		ProfiloUtility ut = new ProfiloUtility();
		
		Profilo p = new Profilo("P01", "Davide99", "Mi piace programmare", 0, 0, 0, EnumProfilo.PUBBLICO, "001", "004", u, null);
		
		System.out.println(u.rimuoviAccount(p));
		System.out.println(u.caricaProfilo(p));
		
		
		
	ArrayList<ProfiloDB> res = pdao.cercaProfilo(ut.convertiAProfiloDB(p));
	if(res.isEmpty()) {
	     System.out.println("Vuoto");
	}
	else
		System.out.println("Non vuoto");
		
		try {
			u.cambiaPassword(p, "Davidee", "nuova");
		} catch (ChangeDefaultPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ChangePassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			u.creaProfilo("P01", "Davide99", "Mi piace programmare", 0, 0, 0, EnumProfilo.PUBBLICO, "001", "004", u, null);
		} catch (AccountGiaEsistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	try {
		try {
			try {
				System.out.println(u.cambiaPassword(p, "Davidee", "nave"));
			} catch (ChangePassword e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (ChangeDefaultPassword e) {
		e.printStackTrace();
	}
		
		try {
			u.login(p, u.getC().getEMail(), "nave");
		} catch (ChangeDefaultPassword | AccountDoesNotExist | PswOmailErrati e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		try {
			u.logout(p);
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			u.cambiaDefaultPassword(p, "Davidee");
		} catch (ChangeDefaultPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		try {
			u.login(p, p.getUtente().getC().getEMail(), "Cambiami");
		} catch (ChangeDefaultPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PswOmailErrati e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	

	}
}
