package db.messaggio.messaggioPrivato;
import java.util.ArrayList;
import db.messaggio.MessaggioDB;

import Messaggio.MessaggioPrivato;


public class MessaggioPrivatoTester {
public static void main(String[] args) {
	MessaggioPrivato m = new MessaggioPrivato("M02", null, null, "Buongiorno", null, "001", "P01");
	MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
	
	ArrayList<String> res2 = mdao.ottieniTestoListaMessaggi("002");
	for(String mess : res2)
		System.out.println(mess.toString());
	
	ArrayList <MessaggioDB> res = mdao.cercaMessaggio(m.getIdMessaggio());
	for(MessaggioDB ms : res)
		System.out.println(ms.toString());
	
	ArrayList <MessaggioDB> res1 = mdao.selezionaMessaggi("002");
	for(MessaggioDB ms : res1)
		System.out.println(ms.toString());
}
}
