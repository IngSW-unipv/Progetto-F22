package convertitore.commentoChatUtility;

import java.util.ArrayList;

import db.commento.CommentoDB;
import post.commento.Commento;

public class CommentoUtility {

    public ArrayList<Commento> convertiLista(ArrayList<CommentoDB> res){
		ArrayList<Commento> c = new ArrayList<>();
		for(CommentoDB cdb : res)
			c.add(this.convertiInverso(cdb));
		return c;
	}
	
	public CommentoDB converti(Commento c) {
		CommentoDB cdb = new CommentoDB(c.getIdCommento(), c.getOraCommento(), c.getDataCommento(),c.getTesto(), c.getProfilo(), c.getIdFoto(),c.getIdVideo(),c.getIdSDV(),c.getIdSSM(),c.getTesto());
		return cdb;
	}
 
	public Commento convertiInverso(CommentoDB c) {
		Commento cdb = new Commento(c.getIdCommento(), c.getOraCommento(), c.getDataCommento(),c.getTesto(), c.getProfilo(), c.getIdFoto(),c.getIdVideo(),c.getIdSDV(),c.getIdSSM(),c.getTesto());
		return cdb;
	}
	
}
