package profilo;

import java.util.ArrayList;

import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.PostNonVisibile;
import profilo.exception.TastoNonEsistente;

public class ProfiloTester {
	
    public static void main(String [] args) {
    //	Profilo p = new Profilo("001", "Girella");
    	Profilo p1 = new Profilo("DV999", "Luca26");
    	Foto f = new Foto("F01", null, false, null, null, false);
    	SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione("S01", null, false, null, null, null, null);
    	SondaggioSceltaMultipla ssm = new SondaggioSceltaMultipla("S01", null, false, null, null, null, null, null, null);
    //Commento c = new Commento("C01", "001", "F01", "aadhd");
    	//p.pubblicaCommento(c);
    //	MessaggioDiGruppo m = new MessaggioDiGruppo("006", null, null, null, null, "G00");
    //	MessaggioPrivato m1 = new MessaggioPrivato("ABC", null, null, null, null, "001", "002");
    
    	/*Post pst = p.cercaPost(f);
    			System.out.println(pst.toString());*/
    	
    	/*try {
			p.pubblicaStoria(1, f);
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
      // ArrayList<String> s = p.ritornaIdPost(f, p);
       //for(String res : s)
    	//.out.println(res.toString());
    /*	try {
			System.out.println(p1.cercaPost(f).toString());
		} catch (PostNonVisibile e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	ArrayList<Post> res = p1.selectAllPost(TipoPost.FOTO);
    	for(Post pst : res)
   		System.out.println(pst.toString()); */
    	try {
			p1.aggiungiVotoSondaggio(ssm);
		} catch (TastoNonEsistente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    }

    	   

