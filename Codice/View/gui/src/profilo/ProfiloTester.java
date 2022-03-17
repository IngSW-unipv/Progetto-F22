package profilo;

import java.util.ArrayList;
import java.util.HashMap;
import db.profilo.ProfiloDB;


public class ProfiloTester {
	
    public static void main(String [] args) {
    	
    	Profilo p = new Profilo("001", "mami", null, EnumProfilo.PUBBLICO);
    	p.invitaUtenteAdIscriversi();
	
    /*ProfiloUtility u = new ProfiloUtility();
    Credenziali c = new Credenziali("Davide", "Mascheroni", null, null, null, "davide.mascheroni1234@gmail.com", null);
    Utente ut = new Utente(c, false, false, false, "AB10");
	Profilo p1 = new Profilo("P01", "MyAccount", "ds", 0, 0, 0, EnumProfilo.PRIVATO, null, null, ut, null);
	Profilo p2 = new Profilo("001", "MyAccount", null, 0, 0, 0, EnumProfilo.PRIVATO, null, null, ut, null);
	
	Profilo p3 =new Profilo("P02", "Davide99", "Mi piace programmare", 0, 0, 0, EnumProfilo.PUBBLICO, "001", "004", ut, null);
	ut.login(p3, "davide.mascheroni1234@gmail.com", "ciao");
	
	ArrayList<ProfiloDB> res = Profilo.cercaProfilo(p2);
	
	for(ProfiloDB pd: res)
		System.out.println(pd.toString());*/
    }   
}
