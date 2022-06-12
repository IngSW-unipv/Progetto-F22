package post.commento;

import java.time.LocalDateTime;

import convertitore.ConvertitoreFacade;
import db.commento.CommentoDB;
import profilo.Profilo;

public class TestDate {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.getDayOfMonth());
  
		Profilo p = new Profilo("DV999","CavalloPazzo");
		Commento c = new Commento("Cm00", "DV999", "F00", "belpost");
		System.out.println(c.getDataCommento());
		CommentoDB cdb = ConvertitoreFacade.getIstance().converti(c);
		System.out.println(cdb.toString());
	
	}

}
