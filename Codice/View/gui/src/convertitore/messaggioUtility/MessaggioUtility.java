package convertitore.messaggioUtility;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import db.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggioPrivato.MessaggioPrivatoDB;

public class MessaggioUtility implements IMessaggioUtility{

	@Override
	public MessaggioPrivatoDB convertiMPDB(MessaggioPrivato m) {
		MessaggioPrivatoDB mdb = new MessaggioPrivatoDB(m.getIdMessaggio(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdProfiloInviante(), m.getIdProfiloRicevente());
		return mdb;
	}

	@Override
	public MessaggioDiGruppoDB convertiMDG(MessaggioDiGruppo m) {
		MessaggioDiGruppoDB mdb = new MessaggioDiGruppoDB(m.getIdMessaggio(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdGruppo());
		return mdb;
	}

}
