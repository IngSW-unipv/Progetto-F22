package db.messaggioDiGruppo;

import java.util.ArrayList;


import Messaggio.MessaggioDiGruppo;
import convertitore.messaggioUtility.*;

public class MessaggioDiGruppoTester {

	public static void main(String[] args) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		ArrayList<MessaggioDiGruppoDB> selectAll = mdao.selectAll();
		MessaggioDiGruppo m = new MessaggioDiGruppo("001", null, null, null, null, null);
	//	MessaggioDiGruppo m1 = new MessaggioDiGruppo("004", null, null, null, null, null);
		
		System.out.println(selectAll.toString());
		
		mdao.ottieniTesto(MessaggioUtility.convertiAMessGrupDB(m));
		
		 ArrayList<MessaggioDiGruppoDB> cercaMessaggio = mdao.cercaMessaggioDiGruppo(m.getIdMessaggio());
	     for(MessaggioDiGruppoDB msg : cercaMessaggio)
				System.out.println(msg.toString());
	          
	   System.out.println("Inserimento avvenuto? " + mdao.scriviMessaggioDiGruppo(MessaggioUtility.convertiAMessGrupDB(m)));
	     System.out.println("La rimozione � avvenuta? " + mdao.rimuoviMessaggioDiGruppo(MessaggioUtility.convertiAMessGrupDB(m)));
	      
}
}
