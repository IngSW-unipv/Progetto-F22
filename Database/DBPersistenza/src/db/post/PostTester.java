package db.post;

import db.facade.DbFacade;
import db.post.multimedia.foto.FotoDB;
import db.post.multimedia.foto.FotoDao;
import post.multimedia.video.Video;

public class PostTester {

	public static void main(String[] args) {
		FotoDB f = new FotoDB("F01", null, null, null, false, false, null, "Nel percorso", true);
        Video v = new Video("V00", null, null, null, false, false, null, "http://cane.com", 200);
		FotoDao pdao = new FotoDao();
     
		
  
   
        System.out.println(pdao.caricaPost(f));
      
		System.out.println(DbFacade.getIstance().carica(v));
	}

}
