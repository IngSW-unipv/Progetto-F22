package profilo;

import profilo.exception.AccountDoesNotExist;
import profilo.exception.NotLoggedIn;

public class ProfiloTester {
	
    public static void main(String [] args) {
    	Profilo p = new Profilo("001", null);
    	
            try {
				System.out.println(p.seiLoggato(p.getIdProfilo()));
			} catch (AccountDoesNotExist | NotLoggedIn e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
    	
    	}
    }

    	   

