package db.facade;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;

public class testfacade {

	public static void main(String[] args) {
		MessaggioPrivato mpv = new MessaggioPrivato("Dv03", null, null, null, null, "001", "002");
		MessaggioDiGruppo mdg = new MessaggioDiGruppo("Dv22", null, null, null, null, "G00");

        DbFacade dbf = DbFacade.getIstance();
 
        System.out.println(dbf.carica(mpv));
        System.out.println(dbf.carica(mdg));
        
        System.out.println(dbf.carica(mdg));
       

}
}