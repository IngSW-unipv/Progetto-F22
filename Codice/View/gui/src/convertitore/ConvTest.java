package convertitore;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import convertitore.messaggioUtility.MessaggioUtility;
import db.messaggio.MessaggioDB;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDB;

public class ConvTest {

	public static void main(String[] args) {
		MessaggioUtility u = new MessaggioUtility();
		MessaggioDiGruppoDB m = new MessaggioDiGruppoDB("F00", null, null, "Lol", null, "G00");
		MessaggioDiGruppoDB m1 = new MessaggioDiGruppoDB("F01", null, null, "Lol", null, "G00");
		MessaggioDiGruppoDB m2 = new MessaggioDiGruppoDB("F02", null, null, "Lol", null, "G00");
		ArrayList<MessaggioDB> lista = new ArrayList<>();
		lista.add(m);
		lista.add(m1);
		lista.add(m2);
		
		System.out.println("MessaggioDB \n");
		for(MessaggioDB mess : lista)
			System.out.println(mess.toString() + "\n");
		
		System.out.println("Messaggio \n");
		ArrayList<Messaggio> list = u.convertiLista(TipoMessaggio.DIGRUPPO, lista);
		
		for(Messaggio msg : list)
			System.out.println(msg.toString());
		
		
	}

}
