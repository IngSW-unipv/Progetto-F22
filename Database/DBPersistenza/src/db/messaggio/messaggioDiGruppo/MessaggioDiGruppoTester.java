package db.messaggio.messaggioDiGruppo;


import Messaggio.MessaggioDiGruppo;
import db.facade.DbFacade;

public class MessaggioDiGruppoTester {

	public static void main(String[] args) {
		MessaggioDiGruppo m = new MessaggioDiGruppo("007", null, null, null, null, "G00");
	  
		DbFacade.getIstance().carica(m);
		/*ArrayList<String> res = mdao.ottieniTestoListaMessaggi("G00");
		for(String ms: res)
			System.out.println(ms.toString());
		
		ArrayList<MessaggioDB> res1 = mdao.selezionaMessaggi(m.getIdGruppo());
		for(MessaggioDB ms: res1)
			System.out.println(ms.toString());*/
}
}
