package profilo;

import post.multimedia.foto.Foto;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.NotLoggedIn;

public class ProfiloTester {
	
    public static void main(String [] args) {
    	Profilo p = new Profilo("001", "Girella");
    	Profilo p1 = new Profilo("P01", "Luca26");
    	Foto f = new Foto("F11", null, null, null, false, false, null, null, false);

        
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
            
           
    	}
    }

    	   

