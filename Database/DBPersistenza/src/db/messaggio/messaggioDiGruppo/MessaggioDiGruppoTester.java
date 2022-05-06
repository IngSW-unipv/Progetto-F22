package db.messaggio.messaggioDiGruppo;

import java.util.ArrayList;

import db.messaggio.MessaggioDB;

public class MessaggioDiGruppoTester {

	public static void main(String[] args) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		MessaggioDiGruppoDB m = new MessaggioDiGruppoDB("001", null, null, null, null, null);
	  
		ArrayList<MessaggioDB> res = mdao.cercaMessaggio(m.getIdMessaggio());
		for(MessaggioDB ms: res)
			System.out.println(ms.toString());
		
}
}
