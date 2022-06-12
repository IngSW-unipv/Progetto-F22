package convertitore.gruppoUtility;

import java.util.ArrayList;

import chat.chatDiGruppo.gruppo.Gruppo;
import db.gruppo.GruppoDB;

public class GruppoUtility {

	/**
	 * Converte una lista di GruppoDB in una lista di Grupppo
	 * @param ArrayList di GruppoDB, tipo utilizzabile solo nel databse
	 */
	public ArrayList<Gruppo> convertiLista(ArrayList<GruppoDB> res){
		ArrayList<Gruppo> g = new ArrayList<>();
		for(GruppoDB gdb : res)
			g.add(this.convertiInverso(gdb));
		return g;
	}
	
	/**
	 * Converte un Gruppo in un GruppoDB
	 * @param un oggetto di tipo Gruppo "reale"
	 */
	public GruppoDB converti(Gruppo g) {
		GruppoDB grdb = new GruppoDB(g.getIdGruppo(),g.getDescrizione(),g.getNomeGruppo(),g.getProfilo1(),g.getProfilo2(),g.getProfilo3(),g.getProfilo4(),g.getProfilo5(),g.getProfilo6(),g.getAmministratore(),g.getFotoGruppo());
		return grdb;
	}
	
	/**
	 * Converte un GruppoDB in un Gruppo
	 * @param Oggetto di tipo Gruppo utilizzabile solo per eseguire le query
	 */
	public Gruppo convertiInverso(GruppoDB g) {
		Gruppo gdb = new Gruppo(g.getIdGruppo(), g.getDescrizione(), g.getNomeGruppo(), g.getProfilo1(), g.getProfilo2(), g.getProfilo3(), g.getProfilo4(), g.getProfilo5(), g.getProfilo6(), g.getAmministratore(),g.getFotoGruppo());
		return gdb;
	}
}
