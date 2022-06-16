package db.post;

import java.util.ArrayList;

import db.commento.CommentoDB;
import db.post.multimedia.foto.FotoDB;
import db.post.multimedia.foto.FotoDao;

public class PostTester {

	public static void main(String[] args) {
		FotoDB f = new FotoDB("F00", null, null, null, 0, 0, false, null, 0, "Nel percorso", true, false);
        
        
		FotoDao pdao = new FotoDao();
		ArrayList<String> prova = pdao.caricaPostProfiliSeguiti("frank");
		for (String p : prova) {
			System.out.println(p);
		}

        FotoDao tdao = new FotoDao();
   
        ArrayList<CommentoDB> res = tdao.mostraCommentiSottoPost(f);
        for(CommentoDB c: res)
        	System.out.println(c.toString());
        System.out.println(pdao.caricaPost(f));
      

		
		
	}

}
