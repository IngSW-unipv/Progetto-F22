package profilo;

import java.util.ArrayList;

import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.PostNonVisibile;

public class ProfiloTester {
	
    public static void main(String [] args) {
    //	Profilo p = new Profilo("001", "Girella");
    	Profilo p1 = new Profilo("DV999", "Luca26");
    	Foto f = new Foto("F06", null, false, p1.getIdProfilo(), null, false);
    	Video v = new Video("V11", null, false, p1.getIdProfilo(), null, 0);
    	Foto f1 = new Foto("F07", null, false, p1.getIdProfilo(), null, false);

    	Profilo p2 = new Profilo("001", null);
    	Profilo p3 = new Profilo("002",null);
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
    	/*try {
			System.out.println(p1.segui(p2));
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			System.out.println(p1.segui(p3));
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	try {
			p1.smettiDiSeguire(p2);
		} catch (AccountDoesNotExist e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
    	System.out.println(p1.rimuoviPost(f1));
    }
    }

    	   

