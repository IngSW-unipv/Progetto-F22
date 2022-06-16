package profilo;

import java.util.ArrayList;

import post.enumeration.TipoPost;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.AzioneNonConsentita;
import profilo.exception.PostNonPresente;
import profilo.exception.PostNonVisibile;
import profilo.exception.TastoNonEsistente;

public class ProfiloTester {
	
    public static void main(String [] args) throws AccountDoesNotExist {
    	Profilo p = new Profilo("frank");
    	Profilo p1 = new Profilo("DV999", "Luca26");
    	Video v = new Video("V00", null, false, null, null, 0, false);
 
    	SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione("SD343", null, false, null, null, null);
    	SondaggioSceltaMultipla ssm = new SondaggioSceltaMultipla("S01", null, false, null, null, null, null, null);
    	Testo t = new Testo("374");
     
    
     
    	
    	try {
			Video v1 = (Video) p1.cercaPost(v);
			System.out.println(v1.toString());
		} catch (PostNonVisibile | PostNonPresente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	try {
			SondaggioDoppiaVotazione s2 = (SondaggioDoppiaVotazione) p1.cercaPost(sdv);
			System.out.println(s2.toString());
		} catch (PostNonVisibile | PostNonPresente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			SondaggioSceltaMultipla s2 = (SondaggioSceltaMultipla) p1.cercaPost(ssm);
			System.out.println(s2.toString());
		} catch (PostNonVisibile | PostNonPresente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
		    Testo t1 = (Testo) p1.cercaPost(t);
		    System.out.println(t1.toString());
		} catch (PostNonVisibile | PostNonPresente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
 

    	try {
			p1.aggiungiVotoSondaggio("S05", 3, TipoPost.SONDAGGIOSCELTAMULTIPLA);
		} catch (TastoNonEsistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
   
    	 p1.pubblicaStoria("wgfre", false, null, false);
    	
     System.out.println(p.pubblicaCommento("DV999", "SD01", "sono un canguro", TipoPost.SONDAGGIODOPPIAVOTAZIONE));
    	
    	ArrayList<String> ress = p1.caricaTuttiiPostDiUnProfilo("DV999", TipoPost.FOTO);
        for(String s : ress)
        	System.out.println(s.toString());
    }
}

    	   

