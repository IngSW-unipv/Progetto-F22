package profilo;

import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggio.messaggioPrivato.MessaggioPrivatoDB;

public class testfacade {

	public static void main(String[] args) {
		MessaggioPrivatoDB mpv = new MessaggioPrivatoDB("Dv00", null, null, null, null, null, null);
		MessaggioDiGruppoDB mdg = new MessaggioDiGruppoDB("Dv00", null, null, null, null, null);
 
		System.out.println("Ciao");
	}

}
