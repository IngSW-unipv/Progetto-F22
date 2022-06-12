package profilo;

import java.util.ArrayList;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.gruppo.Gruppo;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
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
    	Profilo p = new Profilo("001", "Girella");
    	Profilo p1 = new Profilo("DV999", "Luca26");
    	Video v = new Video("V00", null, false, null, null, 0);
    	Foto f = new Foto("F15", null, false, null, null, false);
    	SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione("S01", null, false, null, null, null);
    	SondaggioSceltaMultipla ssm = new SondaggioSceltaMultipla("S01", null, false, null, null, null, null, null);
    	Testo t = new Testo("374");
        Gruppo g = new Gruppo("G03", "Gruppo di amici", "Calcio", "001", "002", "Davide99", "DV999", "001", "002", "DV999", "F00");

        Commento c = new Commento("C01", "001", "F01", "aadhd");
    	// p.pubblicaCommento(c);
    	MessaggioDiGruppo m = new MessaggioDiGruppo("MDG00", null, null, "ciaoooo", "F00", "G00", "DV999");
    	MessaggioPrivato m1 = new MessaggioPrivato("ABC", null, null, null, null, "001", "002");
    
      
    	/*try {
			System.out.println(p1.cercaPost(f).toString());
		} catch (PostNonVisibile | FotoProfiloNonAncoraImpostata e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ArrayList<Post> res = p1.selectAllPost(TipoPost.FOTO);
    	for(Post post : res)
   		System.out.println(post.toString()); 
    	try {
			p1.aggiungiVotoSondaggio(ssm);
		} catch (TastoNonEsistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        System.out.println(p1.modificaFotoGruppo(g, f.getIdPost()));*/
    	/*ArrayList<String> res = p1.caricaTuttiiPostDiUnProfilo(p1, TipoPost.FOTO);
    	for(String str : res)
    		System.out.println(str.toString());*/
    	/*
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
    	*/
    	try {
			System.out.println(p1.segui(p));
		} catch (AccountDoesNotExist | AzioneNonConsentita e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}

    	   

