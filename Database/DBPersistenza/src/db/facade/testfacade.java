package db.facade;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;

import java.util.*;

public class testfacade {

	public static void main(String[] args) {
		MessaggioPrivato mpv = new MessaggioPrivato("Dv03", null, null, null, null, "001", "002");
		MessaggioDiGruppo mdg = new MessaggioDiGruppo("Dv22", null, null, null, null, "G00");

        DbFacade dbf = DbFacade.getIstance();
 
        System.out.println(dbf.carica(mpv));
        System.out.println(dbf.carica(mdg));
       
        ArrayList<String> res = dbf.ottieniTestoListaMessaggi(mdg.getIdGruppo(), mdg.getTipo());
        for(String ms : res)
        	System.out.println(ms.toString());
}
}