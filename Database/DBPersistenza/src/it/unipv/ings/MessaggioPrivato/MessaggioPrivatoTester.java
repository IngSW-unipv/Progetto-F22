package it.unipv.ings.MessaggioPrivato;

//import java.util.ArrayList;

import Messaggio.MessaggioPrivato;

public class MessaggioPrivatoTester {
public static void main(String[] args) {
	MessaggioPrivatoDao mdao = new MessaggioPrivatoDao();
	//ArrayList<MessaggioPrivato> selectAll = mdao.selectAll();
	MessaggioPrivato m = new MessaggioPrivato("002", null, null, "Buongiorno", null, null, null);
	//MessaggioPrivato m1 = new MessaggioPrivato("001", null, null, null, null, null, null);
	
	//System.out.println(selectAll.toString());
	
	
	mdao.ottieniMessaggio(m);
          
   // System.out.println("Inserimento avvenuto? " +mdao.scriviMessaggioPrivato(m1));
    // System.out.println("L'inserimento delle chiavi è avvenuto?" +mdao.inserisciChiavi(m));
  //System.out.println("La rimozione è avvenuta? " + mdao.rimuoviMessaggioPrivato(m));
      
     
}
}
