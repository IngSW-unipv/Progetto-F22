package post.sondaggio;

//import it.unipv.ings.Sondaggio.SondaggioDB;

//import java.util.ArrayList;

//import it.unipv.ings.Sondaggio.SondaggioDB;
//import it.unipv.ings.Sondaggio.SondaggioDao;
//import post.Post;
import post.sondaggio.utility.UtilitySondaggio;

public class SondaggioTester {
    public static void main(String[] args) {
        UtilitySondaggio u = new UtilitySondaggio();
        //int [] contDoppiaVot = {0, 0};
        int [] contMulti = {0, 0, 0, 0};
    	//Sondaggio sdv = new SondaggioDoppiaVotazione("P00", null, null, "Che bello il mare", 0, 0, false, false, false, "001", "Cane", "Gatto", "SD01", contDoppiaVot);
	    SondaggioSceltaMultipla smul = new SondaggioSceltaMultipla("P00", null, null, "wow", 0, 0, false, false, false, "001", "Cane", "Gatto", "SD02", "Gallina", "Ippopotamo", contMulti);
    	
	   // smul.aggiungiVoto(6);
	    //smul.mostraRisultati();
	    
	  System.out.println(smul.pubblicaSondaggio(u.convertiSceltaMultiplaToSondaggioDB(smul)));
	    //System.out.println(smul.rimuoviSondaggio(u.convertiSceltaMultiplaToSondaggioDB(smul)));
	    
    	//sdv.aggiungiVoto(5);
        //sdv.mostraRisultati();
        
        //SondaggioDao sdao = new SondaggioDao();
        //ArrayList<SondaggioDB> res = sdao.selectAll();
	 //     for(SondaggioDB sdb : res)
	 // 	   System.out.println(sdb.toString());
	
	//System.out.println(sdv.pubblicaSondaggio(u.convertiDoppiaVotazioneToSondaggioDB(sdv)));
	//System.out.println(sdv.rimuoviSondaggio(u.convertiDoppiaVotazioneToSondaggioDB(sdv)));
    }
	
}
