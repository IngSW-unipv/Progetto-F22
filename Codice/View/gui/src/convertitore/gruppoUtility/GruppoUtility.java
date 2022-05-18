package convertitore.gruppoUtility;

import java.util.ArrayList;

import chat.chatDiGruppo.gruppo.Gruppo;
import db.gruppo.GruppoDB;

public class GruppoUtility {

	public ArrayList<Gruppo> convertiLista(ArrayList<GruppoDB> res){
		ArrayList<Gruppo> g = new ArrayList<>();
		for(GruppoDB gdb : res)
			g.add(this.convertiInverso(gdb));
		return g;
	}
	
	public GruppoDB converti(Gruppo g) {
		GruppoDB grdb = new GruppoDB(g.getIdGruppo(),g.getDescrizione(),g.getNomeGruppo(),g.getProfilo1(),g.getProfilo2(),g.getProfilo3(),g.getProfilo4(),g.getProfilo5(),g.getProfilo6(),g.getAmministratore());
		return grdb;
	}
	
	public Gruppo convertiInverso(GruppoDB g) {
		Gruppo gdb = new Gruppo(g.getIdGruppo(), g.getDescrizione(), g.getNomeGruppo(), g.getProfilo1(), g.getProfilo2(), g.getProfilo3(), g.getProfilo4(), g.getProfilo5(), g.getProfilo6(), g.getAmministratore());
		return gdb;
	}
}
