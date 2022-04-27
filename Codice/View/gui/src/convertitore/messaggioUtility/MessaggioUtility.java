package convertitore.messaggioUtility;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import db.Interfacce.IMessaggio;
import db.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggioPrivato.MessaggioPrivatoDB;
import Messaggio.enumeration.*;

public class MessaggioUtility{

	
	public MessaggioPrivato convertiAMessPriv(MessaggioPrivatoDB m) {
		MessaggioPrivato mdb = new MessaggioPrivato(m.getIdMsgPvt(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getProfiloInviante(), m.getProfiloRicevente());
		return mdb;
	}
	
	public MessaggioDiGruppo convertiAMessGrp(MessaggioDiGruppoDB m) {
		MessaggioDiGruppo mdb = new MessaggioDiGruppo(m.getIdMsgGrp(), m.getDataInvio(), m.getOraInvio(), m.getTesto(), m.getMultimedia(), m.getIdGruppo());
		return mdb;
	}
	
	public IMessaggio converti(Messaggio m) {
		if(m.getTipo() == TipoMessaggio.PRIVATO) {
			MessaggioPrivato mess = (MessaggioPrivato) m.inserisciCaratteristiche(m);
			MessaggioPrivatoDB mdb = new MessaggioPrivatoDB(mess.getIdMessaggio(), mess.getDataInvio(), mess.getOraInvio(), mess.getTesto(), mess.getMultimedia(), mess.getIdProfiloInviante(), mess.getIdProfiloRicevente());
			
			return mdb;
			}
		else if(m.getTipo() == TipoMessaggio.DIGRUPPO) {
			MessaggioDiGruppo mess = (MessaggioDiGruppo) m.inserisciCaratteristiche(m);
			MessaggioDiGruppoDB mdb = new MessaggioDiGruppoDB(mess.getIdMessaggio(),mess.getDataInvio(),mess.getOraInvio(),mess.getTesto(),mess.getMultimedia(), mess.getIdGruppo());
			return mdb;
		}
		return null;
	}
}
