package chat.chatDiGruppo.gruppo.utility;

import chat.chatDiGruppo.gruppo.Gruppo;
import db.gruppo.GruppoDB;

public class GruppoUtility implements IGruppoUtility{

	@Override
	public GruppoDB converti(Gruppo g) {
		GruppoDB grdb = new GruppoDB(g.getIdGruppo(),g.getDescrizione(),g.getNomeGruppo(),g.getProfilo1(),g.getProfilo2(),g.getProfilo3(),g.getProfilo4(),g.getProfilo5(),g.getProfilo6(),g.getAmministratore());
		return grdb;
	}
}
