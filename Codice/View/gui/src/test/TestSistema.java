package test;

import Sistema.Sistema;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.AccountGiaEsistente;
import profilo.exception.ChangeDefaultPassword;
import profilo.exception.ChangePassword;
import profilo.exception.PswOmailErrati;

public class TestSistema {
	
	public static void main(String[] args)   {
		Sistema sistema = new Sistema();
	/*	try {
			boolean c = sistema.signIn("ciccioGamer@unipv.it", "ciccio");
			System.out.println(c);
		} catch (AccountGiaEsistente e) {
			e.printStackTrace();
		}
		
		
		try {
			sistema.cambiaDefaultPassword("ciccioGamer@unipv.it", "Gelato");
		} catch (ChangeDefaultPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		try {
			try {
				sistema.cambiaPassword("ciccioGamer@unipv.it","Mucca", "Lucertola");
			} catch (ChangePassword e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ChangeDefaultPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		/*try {
			sistema.login("ciccioGamer@unipv.it", "Mucca");
		} catch (ChangeDefaultPassword e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PswOmailErrati e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
	}

	

}
