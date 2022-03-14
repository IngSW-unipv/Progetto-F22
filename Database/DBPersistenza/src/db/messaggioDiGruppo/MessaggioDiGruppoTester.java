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
		MessaggioUtility u = new MessaggioUtility();
		
		System.out.println(selectAll.toString());
		
		mdao.ottieniTesto(u.convertiMDG(m));
		
		 ArrayList<MessaggioDiGruppoDB> cercaMessaggio = mdao.cercaMessaggioDiGruppo(u.convertiMDG(m));
	     for(MessaggioDiGruppoDB msg : cercaMessaggio)
				System.out.println(msg.toString());
	          
	   System.out.println("Inserimento avvenuto? " + mdao.scriviMessaggioDiGruppo(u.convertiMDG(m)));
	     System.out.println("La rimozione � avvenuta? " + mdao.rimuoviMessaggioDiGruppo(u.convertiMDG(m)));
	      
}
}
