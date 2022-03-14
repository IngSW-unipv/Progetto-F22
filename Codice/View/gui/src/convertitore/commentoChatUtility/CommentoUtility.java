package convertitore.commentoChatUtility;

import db.commento.CommentoDB;
import post.commento.Commento;

public class CommentoUtility {

	public static CommentoDB convertiACommentoDB(Commento c) {
		CommentoDB cdb = new CommentoDB(c.getIdCommento(), c.getOraCommento(), c.getDataCommento(),c.getTesto(),c.getPost());
		return cdb;
	}

	public static Commento convertiACommento(CommentoDB c) {
		Commento cdb = new Commento(c.getIdCommento(), c.getOraCommento(), c.getDataCommento(), c.getTesto(), c.getPost());
		return cdb;
	}
	
}
