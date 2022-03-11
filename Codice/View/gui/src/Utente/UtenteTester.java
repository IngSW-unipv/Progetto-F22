package Utente;

import Utente.credenziali.Credenziali;
import Utente.exception.AccountDoesNotExist;
import Utente.exception.ChangeDefaultPassword;
import Utente.exception.ChangePassword;
import Utente.exception.PswOmailErrati;
import profilo.EnumProfilo;
import profilo.Profilo;

public class UtenteTester {

	public static void main(String [] args) {
		Credenziali c = new Credenziali("Davide", "Mascheroni", null, null, null, "davide.mascheroni1234@gmail.com", null);
		Utente u = new Utente(c, false, false, false, "AB10");
		
		Profilo p = new Profilo("P01", "Davide99", "Mi piace programmare", 0, 0, 0, EnumProfilo.PUBBLICO, "001", "004", u, null);
		
		System.out.println(u.rimuoviAccount(p));
		System.out.println(u.caricaProfilo(p));
		
		
		try {
			System.out.println(u.cambiaDefaultPassword("Cambi"));
		} catch (ChangeDefaultPassword e) {
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(u.cambiaPassword("Cambi", "davide99"));
		} catch (ChangeDefaultPassword e) {
			e.printStackTrace();
		} catch (ChangePassword e) {
			e.printStackTrace();
		}
		
		
		try {
			u.creaProfilo("P01", "Davide99", "Mi piace programmare", 0, 0, 0, EnumProfilo.PUBBLICO, "001", "004", u, null);
		} catch (ChangeDefaultPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			u.login(p, c.getEMail(), "Cambi");
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
