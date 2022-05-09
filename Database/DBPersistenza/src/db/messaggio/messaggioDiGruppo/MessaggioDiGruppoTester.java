package db.messaggio.messaggioDiGruppo;

import java.util.ArrayList;

import db.messaggio.MessaggioDB;

public class MessaggioDiGruppoTester {

	public static void main(String[] args) {
		MessaggioDiGruppoDao mdao = new MessaggioDiGruppoDao();
		MessaggioDiGruppoDB m = new MessaggioDiGruppoDB("001", null, null, null, null, "G00");
	  
		ArrayList<String> res = mdao.ottieniTestoListaMessaggi("G00");
		for(String ms: res)
			System.out.println(ms.toString());
		
		ArrayList<MessaggioDB> res1 = mdao.selezionaMessaggi(m.getIdGruppo());
		for(MessaggioDB ms: res1)
			System.out.println(ms.toString());
}
}
