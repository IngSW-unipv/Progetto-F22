package convertitore.commentoChatUtility;

import db.commento.CommentoDB;
import post.commento.Commento;

public class CommentoUtility implements ICommentoUtility{

	@Override
	public CommentoDB converti(Commento c) {
		CommentoDB cdb = new CommentoDB(c.getIdCommento(), c.getOraCommento(), c.getDataCommento(),c.getTesto(),c.getPost());
		return cdb;
	}

	
}
