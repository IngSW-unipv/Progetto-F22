package post.commento;

import java.time.LocalDateTime;

import convertitore.ConvertitoreFacade;
import db.commento.CommentoDB;
import profilo.Profilo;

public class TestDate {

	public static void main(String[] args) {
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now.getDayOfMonth());
 
		Commento c = new Commento("C00", "DV999", "F900", "L'alpaca si nutre di fruttolo");
        System.out.println(c.toString());
		
	}

}
