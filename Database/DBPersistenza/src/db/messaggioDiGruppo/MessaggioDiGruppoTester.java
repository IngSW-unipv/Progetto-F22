package db.messaggioDiGruppo;

import java.util.ArrayList;


import Messaggio.MessaggioDiGruppo;
import convertitore.ConvertitoreFacade;

public class MessaggioDiGruppoTester {

	public static void main(String[] args) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		ArrayList<MessaggioDiGruppoDB> selectAll = mdao.selectAll();
		MessaggioDiGruppo m = new MessaggioDiGruppo("001", null, null, null, null, null);
	    ConvertitoreFacade f = ConvertitoreFacade.getIstance();
		
		System.out.println(selectAll.toString());
		
		mdao.ottieniTesto(f.converti(m));
		
		 ArrayList<MessaggioDiGruppoDB> cercaMessaggio = mdao.cercaMessaggioDiGruppo(m.getIdMessaggio());
	     for(MessaggioDiGruppoDB msg : cercaMessaggio)
				System.out.println(msg.toString());
	          
	  System.out.println("Inserimento avvenuto? " + mdao.scriviMessaggioDiGruppo(f.converti(m)));
	     System.out.println("La rimozione è avvenuta? " + mdao.rimuoviMessaggioDiGruppo(f.converti(m)));
	  
}
}
