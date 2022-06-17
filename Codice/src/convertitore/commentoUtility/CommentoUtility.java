package convertitore.commentoUtility;

import java.util.ArrayList;

import db.commento.CommentoDB;
import post.commento.Commento;

public class CommentoUtility {

	/**
	 * Converte una lista di CommentoDB in una lista di commento
	 * @param ArrayList di commentiDB, tipo utilizzabile solo nel databse
	 */
    public ArrayList<Commento> convertiLista(ArrayList<CommentoDB> res){
		ArrayList<Commento> c = new ArrayList<>();
		for(CommentoDB cdb : res)
			c.add(this.convertiInverso(cdb));
		return c;
	}
    /**
	 * Converte un Commento in un commentoDB
	 * @param un commento "reale"
	 */
	public CommentoDB converti(Commento c) {
		CommentoDB cdb = new CommentoDB(c.getIdCommento(), c.getOraCommento(), c.getDataCommento(),c.getTesto(), c.getProfilo(), c.getIdFoto(),c.getIdVideo(),c.getIdSDV(),c.getIdSSM(),c.getIdTesto());
		return cdb;
	}
	
 
	/**
	 * Converte un CommentoDB in un commento
	 * @param Commento utilizzabile solo per eseguire le query
	 */
	public Commento convertiInverso(CommentoDB c) {
		Commento cdb = new Commento(c.getIdCommento(), c.getOraCommento(), c.getDataCommento(),c.getTesto(), c.getProfilo(), c.getIdFoto(),c.getIdVideo(),c.getIdSDV(),c.getIdSSM(),c.getIdTesto());
		return cdb;
	}
	
}
