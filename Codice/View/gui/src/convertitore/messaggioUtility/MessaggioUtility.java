package convertitore.messaggioUtility;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import db.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggioPrivato.MessaggioPrivatoDB;

public class MessaggioUtility{

	
	public MessaggioPrivatoDB convertiAMessPrivDB(MessaggioPrivato m) {
		MessaggioPrivatoDB mdb = new MessaggioPrivatoDB(m.getIdMessaggio(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdProfiloInviante(), m.getIdProfiloRicevente());
		return mdb;
	}

	public MessaggioDiGruppoDB convertiAMessGrupDB(MessaggioDiGruppo m) {
		MessaggioDiGruppoDB mdb = new MessaggioDiGruppoDB(m.getIdMessaggio(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdGruppo());
		return mdb;
	}

	public MessaggioPrivato convertiAMessPriv(MessaggioPrivatoDB m) {
		MessaggioPrivato mdb = new MessaggioPrivato(m.getIdMsgPvt(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getProfiloInviante(), m.getProfiloRicevente());
		return mdb;
	}
	
	public MessaggioDiGruppo convertiAMessGrp(MessaggioDiGruppoDB m) {
		MessaggioDiGruppo mdb = new MessaggioDiGruppo(m.getIdMsgGrp(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdGruppo());
		return mdb;
	}
	
}
