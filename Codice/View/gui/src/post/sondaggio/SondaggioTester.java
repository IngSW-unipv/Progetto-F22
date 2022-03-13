package post.sondaggio;

import java.util.ArrayList;

import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDB;
import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDB;

//import it.unipv.ings.Sondaggio.SondaggioDB;

//import java.util.ArrayList;

//import it.unipv.ings.Sondaggio.SondaggioDB;
//import it.unipv.ings.Sondaggio.SondaggioDao;
//import post.Post;

public class SondaggioTester {
    public static void main(String[] args) {
       
        int [] contDoppiaVot = {0, 0};
        int [] contMulti = {0, 0, 0, 0};
    	
        
      SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione("P00", null, null, "Che bello il mare", 0, 0, false, false, "001", "Cane", "Gatto", contDoppiaVot);
	    
        System.out.println(sdv.caricaPost(sdv));
        
        ArrayList<SondaggioDoppiaVotazioneDB> sall = sdv.selectAllSDV();
        for(SondaggioDoppiaVotazioneDB p : sall)
			System.out.println(p.toString());
    	
    	SondaggioSceltaMultipla smul = new SondaggioSceltaMultipla("P00", null, null, "wow", 0, 0, false, false, "001", "Cane", "Gatto", "Pecora", "Gallina", contMulti);
    	
    	System.out.println(smul.caricaPost(smul));
    	
        ArrayList<SondaggioSceltaMultiplaDB> salli = smul.selectAllSSM();
       for(SondaggioSceltaMultiplaDB p : salli)
			System.out.println(p.toString());
    	
	    smul.aggiungiVoto(6);
	    smul.mostraRisultati();
	    
	    
    	sdv.aggiungiVoto(5);
        sdv.mostraRisultati();
        
     
    }
	
}
