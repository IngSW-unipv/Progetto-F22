package messaggio.messaggioDiGruppo;

import java.util.ArrayList;


import Messaggio.MessaggioDiGruppo;
import convertitore.ConvertitoreFacade;

public class MessaggioDiGruppoTester {

	public static void main(String[] args) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		MessaggioDiGruppo m = new MessaggioDiGruppo("M17", null, null, null, null, null);
	    ConvertitoreFacade f = ConvertitoreFacade.getIstance();
	  
			
		 ArrayList<MessaggioDiGruppoDB> cercaMessaggio = mdao.cercaMessaggioDiGruppo(m.getIdMessaggio());
	     for(MessaggioDiGruppoDB msg : cercaMessaggio)
				System.out.println(msg.toString());
	          
	  System.out.println("Inserimento avvenuto? " + mdao.scriviMessaggioDiGruppo((MessaggioDiGruppoDB) f.conversione(m)));
	     System.out.println("La rimozione è avvenuta? " + mdao.rimuoviMessaggioDiGruppo((MessaggioDiGruppoDB) f.conversione(m)));
	  
	    System.out.println(mdao.ottieniTesto(m.getIdMessaggio()));
	    System.out.println(mdao.scriviMessaggioDiGruppo((MessaggioDiGruppoDB) f.conversione(m)));
}
}
