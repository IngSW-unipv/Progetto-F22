package db.messaggioPrivato;

import java.util.ArrayList;

import Messaggio.MessaggioPrivato;
import convertitore.ConvertitoreFacade;

public class MessaggioPrivatoTester {
public static void main(String[] args) {
	MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
	MessaggioPrivato m = new MessaggioPrivato("M05", null, null, "Buongiorno", null, "001", "002");
	ConvertitoreFacade f = ConvertitoreFacade.getIstance();
	
	
	System.out.println(mdao.ottieniMessaggio(m.getIdMessaggio()));
          
   System.out.println("La rimozione è avvenuta? " + mdao.rimuoviMessaggioPrivato((MessaggioPrivatoDB) f.conversione(m)));
   System.out.println("Inserimento avvenuto? " + mdao.scriviMessaggioPrivato((MessaggioPrivatoDB) f.conversione(m)));
	
	ArrayList<MessaggioPrivatoDB> res = mdao.selectAllNomeProfilo((MessaggioPrivatoDB) f.conversione(m));
	for(MessaggioPrivatoDB mdb : res)
		System.out.println(mdb.toString());
     
}
}
