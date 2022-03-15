package convertitore.gruppoUtility;

import chat.chatDiGruppo.gruppo.Gruppo;
import db.gruppo.GruppoDB;

public class GruppoUtility {

	public static GruppoDB convertiAGruppoDB(Gruppo g) {
		GruppoDB grdb = new GruppoDB(g.getIdGruppo(),g.getDescrizione(),g.getNomeGruppo(),g.getProfilo1(),g.getProfilo2(),g.getProfilo3(),g.getProfilo4(),g.getProfilo5(),g.getProfilo6(),g.getAmministratore());
		return grdb;
	}
	
	public static Gruppo convertiAGruppo(GruppoDB g) {
		Gruppo gdb = new Gruppo(g.getIdGruppo(), g.getDescrizione(), g.getNomeGruppo(), g.getProfilo1(), g.getProfilo2(), g.getProfilo3(), g.getProfilo4(), g.getProfilo5(), g.getProfilo6(), g.getAmministratore());
		return gdb;
	}
}
