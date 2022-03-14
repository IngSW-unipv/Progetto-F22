package db.messaggioPrivato;

import java.util.ArrayList;

import Messaggio.MessaggioPrivato;
import convertitore.messaggioUtility.*;

public class MessaggioPrivatoTester {
public static void main(String[] args) {
	MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
	ArrayList<MessaggioPrivatoDB> selectAll = mdao.selectAll();
	MessaggioPrivato m = new MessaggioPrivato("002", null, null, "Buongiorno", null, "001", "002");
	MessaggioPrivato m1 = new MessaggioPrivato("001", null, null, null, null, null, null);
	MessaggioUtility u = new MessaggioUtility();
	System.out.println(selectAll.toString());
	
	mdao.ottieniMessaggio(u.convertiMPDB(m));
          
   System.out.println("Inserimento avvenuto? " +mdao.scriviMessaggioPrivato(u.convertiMPDB(m1)));
   System.out.println("La rimozione � avvenuta? " + mdao.rimuoviMessaggioPrivato(u.convertiMPDB(m)));
      
     
}
}
