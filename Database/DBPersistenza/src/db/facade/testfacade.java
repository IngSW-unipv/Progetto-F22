package db.facade;


import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.gruppo.Gruppo;
import post.enumeration.TipoPost;
//import post.commento.Commento;
import post.multimedia.foto.Foto;
import post.sondaggio.SondaggioDoppiaVotazione;
import profilo.Profilo;

import java.util.*;

public class testfacade {

	public static void main(String[] args) {
		MessaggioPrivato mpv = new MessaggioPrivato("Dv03", null, null, null, null, "001");
		MessaggioDiGruppo mdg = new MessaggioDiGruppo("Dv22", null, null, null, null, "G00");
	//	Commento c = new Commento("C00", null, null, null, null, "F01", null, null, null, null);
		Foto f = new Foto("F00", null, false, null, null, false, false);
     //  Profilo p  = new Profilo("P00", null);
        DbFacade dbf = DbFacade.getIstance();
        Gruppo g = new Gruppo("G03", "Gruppo di amici", "Calcio", "001", "002", "Davide99", "DV999", "001", "002");
       SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione("SDV01", "wdtcqfu", true, "DV999", "cane", "gatto");        
        Profilo plof = new Profilo("DV999", "Davide99");
        
       dbf.cerca(plof);
        
       
      
        
      /*  System.out.println(dbf.carica(mpv));
        System.out.println(dbf.carica(mdg));
       
        ArrayList<String> res = dbf.ottieniTestoListaMessaggi(mdg.getIdGruppo(),null, mdg.getTipo());
        for(String ms : res)
        	System.out.println(ms.toString());
        
        Messaggio m = dbf.cerca(mdg);
        System.out.println(m.toString());
               
        
        dbf.cerca(f);
        
        boolean b = DbFacade.getIstance().presenteLikeMap("D99", "F04");
        System.out.println(b);
        
        
        System.out.println(dbf.carica(sdv));
        
        System.out.println(DbFacade.getIstance().carica(g));*/
       ArrayList<String> res = DbFacade.getIstance().ottieniIdPost(TipoPost.TESTO,new Profilo("DV999", null));
       for(String s : res)
    	   System.out.println(s.toString());
}
}