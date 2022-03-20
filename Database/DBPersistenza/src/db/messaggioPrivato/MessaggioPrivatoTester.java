package db.messaggioPrivato;

import java.util.ArrayList;

import Messaggio.MessaggioPrivato;
import convertitore.ConvertitoreFacade;

public class MessaggioPrivatoTester {
public static void main(String[] args) {
	MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
	ArrayList<MessaggioPrivatoDB> selectAll = mdao.selectAll();
	MessaggioPrivato m = new MessaggioPrivato("002", null, null, "Buongiorno", null, "001", "002");
	ConvertitoreFacade f = ConvertitoreFacade.getIstance();
	
	System.out.println(selectAll.toString());
	
	mdao.ottieniMessaggio(f.converti(m));
          
   System.out.println("Inserimento avvenuto? " +mdao.scriviMessaggioPrivato(f.converti(m)));
   System.out.println("La rimozione è avvenuta? " + mdao.rimuoviMessaggioPrivato(f.converti(m)));
      
     
}
}
