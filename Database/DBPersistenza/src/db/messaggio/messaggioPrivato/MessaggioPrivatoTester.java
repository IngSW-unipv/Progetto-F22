package db.messaggio.messaggioPrivato;
import java.util.ArrayList;


import db.messaggio.MessaggioDB;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDao;


public class MessaggioPrivatoTester {
public static void main(String[] args) {
	MessaggioPrivatoDB m = new MessaggioPrivatoDB("M02", null, null, "Buongiorno", null, "001");
	MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
	MessaggioDiGruppoDao mdgdao = new MessaggioDiGruppoDao();
	MessaggioDiGruppoDB mdg = new MessaggioDiGruppoDB("001", null, null, null, null, null);
	
	
	ArrayList<String> res2 = mdao.ottieniTestoListaMessaggi("Davide99", "DV999");
	for(String mess : res2)
		System.out.println(mess.toString());

	
	ArrayList <MessaggioDB> res1 = mdao.selezionaMessaggi("002","DV999");
	for(MessaggioDB ms : res1)
		System.out.println(ms.toString());
	
	MessaggioPrivatoDB m1 =(MessaggioPrivatoDB) mdao.cercaMessaggio(m); 
	System.out.println(m1.toString());
	
	MessaggioDiGruppoDB m2 = (MessaggioDiGruppoDB) mdgdao.cercaMessaggio(mdg);
	System.out.println(m2.toString());
}
}
