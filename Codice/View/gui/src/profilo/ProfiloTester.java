package profilo;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import db.facade.DbFacade;
import post.multimedia.foto.Foto;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.NotLoggedIn;

public class ProfiloTester {
	
    public static void main(String [] args) {
    	Profilo p = new Profilo("001", "Girella");
    	Profilo p1 = new Profilo("P01", "Luca26");
    	Foto f = new Foto("F11", null, null, null, false, false, null, null, false);

    	MessaggioDiGruppo m = new MessaggioDiGruppo("006", null, null, null, null, "G00");
    	MessaggioPrivato m1 = new MessaggioPrivato("ABC", null, null, null, null, "001", "002");
    
    	
    	
    	try {
			p.leggiSoloTesto(m.getIdGruppo(), m.getTipo());
		} catch (AccountDoesNotExist | NotLoggedIn e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	/*try {
			System.out.println(p.leggiMessaggi(m.getIdGruppo(), m.getTipo()));
		} catch (AccountDoesNotExist | NotLoggedIn e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
    	try {
			ArrayList<Messaggio> lis = p.cercaMessaggio("M03", m.getTipo());
			for(Messaggio mess : lis){
				System.out.println(mess.toString());
			}
		} catch (AccountDoesNotExist | NotLoggedIn e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	
			try {
				System.out.println(p.aggiungiLike(f));
			} catch (AccountDoesNotExist | NotLoggedIn e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

            try {
				System.out.println(p.rimuoviLike(f));
			} catch (AccountDoesNotExist | NotLoggedIn e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
            try {
				System.out.println(p1.rimuoviLike(f));
			} catch (AccountDoesNotExist | NotLoggedIn e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
    	
           try {
				p.seiLoggato(p.getIdProfilo());
			} catch (AccountDoesNotExist e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NotLoggedIn e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            */
        
    	}
    }

    	   

