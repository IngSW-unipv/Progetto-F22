package Sistema;

import profilo.Profilo;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.AccountGiaEsistente;
import profilo.exception.ChangeDefaultPassword;
import profilo.exception.PswOmailErrati;

public class TestSistema {

	public static void main(String [] args) {
		Sistema s = new Sistema();


		/*try {
			System.out.println(s.signIn("DV999", "Davide99", "Marmellata"));
		} catch (AccountGiaEsistente | ChangeDefaultPassword | AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		try {
			s.login("Dv999", "Marmellata");
		} catch (ChangeDefaultPassword | AccountDoesNotExist | PswOmailErrati e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Profilo p = new Profilo("Dv999", "Marmellata");
		
		/*try {
			s.login("DV999", "Marmellata");
		} catch (ChangeDefaultPassword | AccountDoesNotExist | PswOmailErrati e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
	/*	try {
			Profilo p2 = p.cercaProfilo(p);
			System.out.println(p2.getFotoProfilo());
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	*/
		s.carica("001", "F01", "IlMare");
	
	}
}
