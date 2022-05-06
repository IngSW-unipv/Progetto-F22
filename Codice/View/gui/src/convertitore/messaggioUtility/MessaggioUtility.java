package convertitore.messaggioUtility;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import Messaggio.enumeration.*;
import db.messaggio.MessaggioDB;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggio.messaggioPrivato.MessaggioPrivatoDB;

public class MessaggioUtility{

	public MessaggioDB converti(Messaggio mess) {
		if(mess.getTipo() == TipoMessaggio.PRIVATO) {
			MessaggioPrivato msg = (MessaggioPrivato) mess.inserisciCaratteristiche(mess);
			MessaggioPrivatoDB mdb = new MessaggioPrivatoDB(msg.getIdMessaggio(), msg.getDataInvio(), msg.getOraInvio(), msg.getTesto(), msg.getMultimedia(), msg.getIdProfiloInviante(), msg.getIdProfiloRicevente());
			return mdb;
		}
		else if(mess.getTipo() == TipoMessaggio.DIGRUPPO) {
			MessaggioDiGruppo msg = (MessaggioDiGruppo) mess.inserisciCaratteristiche(mess);
			MessaggioDiGruppoDB mdb = new MessaggioDiGruppoDB(msg.getIdMessaggio(),msg.getDataInvio(),msg.getOraInvio(),msg.getTesto(),msg.getMultimedia(), msg.getIdGruppo());
			return mdb;
		}
		return null;
	}

	public String [] ritornaCaratteristiche(Messaggio m) {
		String [] s = new String [2];
		if(m.getTipo() == TipoMessaggio.PRIVATO){
			MessaggioPrivato msg = (MessaggioPrivato) m.inserisciCaratteristiche(m);
			MessaggioPrivatoDB mdb = new MessaggioPrivatoDB(msg.getIdMessaggio(), msg.getDataInvio(), msg.getOraInvio(), msg.getTesto(), msg.getMultimedia(), msg.getIdProfiloInviante(), msg.getIdProfiloRicevente());
			s[0] = mdb.getProfiloInviante();
			s[1] = mdb.getProfiloRicevente();
			return s;
		}
		else if(m.getTipo() == TipoMessaggio.DIGRUPPO) {
			MessaggioDiGruppo msg = (MessaggioDiGruppo) m.inserisciCaratteristiche(m);
			MessaggioDiGruppoDB mdb = new MessaggioDiGruppoDB(msg.getIdMessaggio(),msg.getDataInvio(),msg.getOraInvio(),msg.getTesto(),msg.getMultimedia(), msg.getIdGruppo());
			s[0] = mdb.getIdGruppo();
			s[1] = null;
			return s;
			
		}
		return null;   
	}


public ArrayList<MessaggioDB> convertiLista(TipoMessaggio t, ArrayList<Messaggio> m){
	ArrayList<MessaggioDB> res;
	if(t == TipoMessaggio.PRIVATO) {
	   for(int i = 0;i<7; i++)
		   m[i] = new MessaggioPrivato(null, null, null, null, null, null, null);
		
	}
	return null;
}
}





















