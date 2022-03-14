package convertitore.messaggioUtility;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import db.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggioPrivato.MessaggioPrivatoDB;

public class MessaggioUtility{

	
	public static MessaggioPrivatoDB convertiAMessPrivDB(MessaggioPrivato m) {
		MessaggioPrivatoDB mdb = new MessaggioPrivatoDB(m.getIdMessaggio(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdProfiloInviante(), m.getIdProfiloRicevente());
		return mdb;
	}

	
	public static MessaggioDiGruppoDB convertiAMessGrupDB(MessaggioDiGruppo m) {
		MessaggioDiGruppoDB mdb = new MessaggioDiGruppoDB(m.getIdMessaggio(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdGruppo());
		return mdb;
	}

	public static MessaggioPrivato convertiAMessPriv(MessaggioPrivatoDB m) {
		MessaggioPrivato mdb = new MessaggioPrivato(m.getIdMsgPvt(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getProfiloInviante(), m.getProfiloRicevente());
		return mdb;
	}
	
	public MessaggioDiGruppo convertiAMessGrp(MessaggioDiGruppoDB m) {
		MessaggioDiGruppo mdb = new MessaggioDiGruppo(m.getIdMsgGrp(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdGruppo());
		return mdb;
	}
	
}
