package profilo;

import java.util.ArrayList;

import post.multimedia.foto.Foto;
import profilo.exception.AccountDoesNotExist;


public class ProfiloTester {
	
    public static void main(String [] args) {
    	Profilo p = new Profilo("001", "Girella");
    //	Profilo p1 = new Profilo("P01", "Luca26");
    	Foto f = new Foto("F14", null, null, null, false, false, null, null, false);

    //	MessaggioDiGruppo m = new MessaggioDiGruppo("006", null, null, null, null, "G00");
    //	MessaggioPrivato m1 = new MessaggioPrivato("ABC", null, null, null, null, "001", "002");
    
    	/*Post pst = p.cercaPost(f);
    			System.out.println(pst.toString());*/
    	
    	/*try {
			p.pubblicaStoria(1, f);
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
       ArrayList<String> s = p.ritornaIdPost(f, p);
       for(String res : s)
    	   System.out.println(res.toString());
    	}
    }

    	   

