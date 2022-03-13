package Messaggio.utility;

import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import db.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggioPrivato.MessaggioPrivatoDB;

public interface IMessaggioUtility {

	public MessaggioPrivatoDB convertiMPDB(MessaggioPrivato m);
	public MessaggioDiGruppoDB convertiMDG(MessaggioDiGruppo m);
}
