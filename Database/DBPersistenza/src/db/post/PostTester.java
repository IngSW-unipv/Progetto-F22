package db.post;

import java.util.ArrayList;

import db.commento.CommentoDB;
import db.post.multimedia.foto.FotoDB;
import db.post.multimedia.foto.FotoDao;



public class PostTester {

	public static void main(String[] args) {
		FotoDB f = new FotoDB("F00", null, null, null, 0, 0, false, null, 0, "Nel percorso", true, false);
      /*  VideoDB v = new VideoDB("V11", null, null, null, 0, 0, false, false, null, 0, "http://cane.com", false, 200);
       SondaggioDoppiaVotazioneDB sdv = new SondaggioDoppiaVotazioneDB("S00", null, null, null, 0, 0, false, null, null, null);
        SondaggioSceltaMultiplaDB ssm = new SondaggioSceltaMultiplaDB("P00", null, null, null, 0, 0, false, null, null, null, null, null);
        TestoDB t = new TestoDB("T00", null, null, null, 0, 0, false, null, null, null);
       CommentoDB c1 = new CommentoDB("001", null, null, null, null, "F00", "V11", "S00", "P00", "T00");
		CommentoDB c2 = new CommentoDB("002", null, null, null, null, "F00", "V11", "S00", "P00", "T00");*/
        
        
		FotoDao pdao = new FotoDao();
		ArrayList<String> prova = pdao.caricaPostProfiliSeguiti("frank");
		for (String p : prova) {
			System.out.println(p);
		}
      // VideoDao vdao = new VideoDao();
      //  SondaggioDoppiaVotazioneDao sdvdao = new SondaggioDoppiaVotazioneDao();
		//SondaggioSceltaMultiplaDao smdao = new SondaggioSceltaMultiplaDao();
        FotoDao tdao = new FotoDao();
   /*
        ArrayList<CommentoDB> res = tdao.mostraCommentiSottoPost(f);
        for(CommentoDB c: res)
        	System.out.println(c.toString());
        System.out.println(pdao.caricaPost(f));
      
*/
		
		
	}

}
