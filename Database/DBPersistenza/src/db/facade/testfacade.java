package db.facade;


import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import db.post.sondaggio.sondaggiosceltamultipla.SondaggioSceltaMultiplaDB;
import post.commento.Commento;
import post.multimedia.foto.Foto;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
//import profilo.Profilo;
import profilo.Profilo;

import java.util.*;

public class testfacade {

	public static void main(String[] args) {
		MessaggioPrivato mpv = new MessaggioPrivato("Dv03", null, null, null, null, "001", "002");
		MessaggioDiGruppo mdg = new MessaggioDiGruppo("Dv22", null, null, null, null, "G00", null);
		Commento c = new Commento("C00", null, null, null, null, "F01", null, null, null, null);
		Foto f = new Foto("F00", null, false, null, null, false);
       Profilo p  = new Profilo("P00", null);
        DbFacade dbf = DbFacade.getIstance();
 
       SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione("SDV01", "wdtcqfu", true, "DV999", "cane", "gatto", null);        
       /* Profilo plof = new Profilo("Dv999", "Davide99");
        
        dbf.cerca(plof);
        
       
      
        
        System.out.println(dbf.carica(mpv));
        System.out.println(dbf.carica(mdg));
       
        ArrayList<String> res = dbf.ottieniTestoListaMessaggi(mdg.getIdGruppo(), mdg.getTipo());
        for(String ms : res)
        	System.out.println(ms.toString());
        
        Messaggio m = dbf.cerca(mdg);
        System.out.println(m.toString());
        
		p.pubblicaCommento(c);
        
        
        dbf.cerca(f);*/
        
        /*boolean b = DbFacade.getIstance().presenteLikeMap("D99", "F04");
        System.out.println(b);*/
        
        
        System.out.println(dbf.carica(sdv));
}
}