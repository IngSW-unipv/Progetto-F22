package db.facade;


import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
//import profilo.Profilo;
import profilo.Profilo;

import java.util.*;

public class testfacade {

	public static void main(String[] args) {
		MessaggioPrivato mpv = new MessaggioPrivato("Dv03", null, null, null, null, "001", "002");
		MessaggioDiGruppo mdg = new MessaggioDiGruppo("Dv22", null, null, null, null, "G00", null);
        //Profilo p  = new Profilo("P00", null);
        DbFacade dbf = DbFacade.getIstance();
 
        Profilo plof = new Profilo("Dv999", "Davide99");
        
        dbf.cerca(plof);
        
       
      
        
        System.out.println(dbf.carica(mpv));
        System.out.println(dbf.carica(mdg));
       
        ArrayList<String> res = dbf.ottieniTestoListaMessaggi(mdg.getIdGruppo(), mdg.getTipo());
        for(String ms : res)
        	System.out.println(ms.toString());
        
        Messaggio m = dbf.cerca(mdg);
        System.out.println(m.toString());
}
}