package profilo;

import java.util.ArrayList;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.gruppo.Gruppo;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.FotoProfiloNonAncoraImpostata;
import profilo.exception.PostNonVisibile;
import profilo.exception.TastoNonEsistente;

public class ProfiloTester {
	
    public static void main(String [] args) throws AccountDoesNotExist {
    	Profilo p = new Profilo("001", "Girella");
    	Profilo p1 = new Profilo("DV999", "Luca26");
    	Foto f = new Foto("F15", null, false, null, null, false);
    	SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione("S01", null, false, null, null, null);
    	SondaggioSceltaMultipla ssm = new SondaggioSceltaMultipla("S01", null, false, null, null, null, null, null);
        Gruppo g = new Gruppo("G03", "Gruppo di amici", "Calcio", "001", "002", "Davide99", "DV999", "001", "002", "DV999", "F00");

        Commento c = new Commento("C01", "001", "F01", "aadhd");
    	// p.pubblicaCommento(c);
    	MessaggioDiGruppo m = new MessaggioDiGruppo("006", null, null, null, null, "G00", null);
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
    	ArrayList<String> res = p1.caricaTuttiiPostDiUnProfilo(p1, TipoPost.FOTO);
    	for(String str : res)
    		System.out.println(str.toString());
    	
    }
    }

    	   

