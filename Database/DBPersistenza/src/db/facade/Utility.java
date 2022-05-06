package db.facade;

import Messaggio.enumeration.TipoMessaggio;
import db.messaggio.MessaggioDao;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDao;
import db.messaggio.messaggioPrivato.MessaggioPrivatoDao;

public class Utility {

	public static MessaggioDao convertiTipoMessaggio(TipoMessaggio m) {
		if(m.equals(TipoMessaggio.PRIVATO)) {
			MessaggioPrivatoDao mpdao = new MessaggioPrivatoDao();
			return mpdao;
		}
		else if(m.equals(TipoMessaggio.DIGRUPPO)) {
			MessaggioDiGruppoDao mgdao = new MessaggioDiGruppoDao();
			return mgdao;
		}
		return null;
	}
}
