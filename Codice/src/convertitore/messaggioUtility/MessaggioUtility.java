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

	/**
	 * Converte un Messaggio in un MessaggioDB corrispondente al rispettivo tipo
	 * @param un oggetto di tipo Messaggio "reale"
	 */
	public MessaggioDB converti(Messaggio mess) {
		if(mess.getTipo() == TipoMessaggio.PRIVATO) {
			MessaggioPrivato msg = (MessaggioPrivato) mess.inserisciCaratteristiche(mess);
			MessaggioPrivatoDB mdb = new MessaggioPrivatoDB(msg.getIdMessaggio(), msg.getDataInvio(), msg.getOraInvio(), msg.getTesto(), msg.getProfiloInviante(), msg.getIdProfiloRicevente());
			return mdb;
		}
		else if(mess.getTipo() == TipoMessaggio.DIGRUPPO) {
			MessaggioDiGruppo msg = (MessaggioDiGruppo) mess.inserisciCaratteristiche(mess);
			MessaggioDiGruppoDB mdb = new MessaggioDiGruppoDB(msg.getIdMessaggio(),msg.getDataInvio(),msg.getOraInvio(),msg.getTesto(),msg.getProfiloInviante(), msg.getIdGruppo());
			return mdb;
		}
		return null;
	}

	/**
	 * Converte un MessaggioDB in un Messaggio in base al tipo
	 * @param Oggetto di tipo Messaggio utilizzabile solo per eseguire le query
	 */
	public Messaggio convertiInverso(MessaggioDB mess, TipoMessaggio tipo) {

		if(tipo == TipoMessaggio.PRIVATO) {
			MessaggioPrivatoDB mdb = (MessaggioPrivatoDB) mess.inserisciCaratteristiche(mess);
			MessaggioPrivato m = new MessaggioPrivato(mdb.getIdMessaggio(), mdb.getDataInvio(), mdb.getOraInvio(), mdb.getTesto(), mdb.getProfiloInviante(), mdb.getProfiloRicevente());
			return m;
		}
		
		else if(tipo == TipoMessaggio.DIGRUPPO){
			MessaggioDiGruppoDB mdb = (MessaggioDiGruppoDB) mess.inserisciCaratteristiche(mess);
			MessaggioDiGruppo m = new MessaggioDiGruppo(mdb.getIdMessaggio(), mdb.getDataInvio(), mdb.getOraInvio(), mdb.getTesto(),mdb.getProfiloInviante(), mdb.getIdGruppo());
			return m;
		}
		
		return null;
	}
	
	
	/**
	 * Metodo che ottiene le informazioni riguardo le chiavi esterne ad un oggetto di tipo messaggio
	 * @return Vettore di stringhe con all'interno le informazioni relative alle chiavi esterne
	 */
	public String [] ritornaCaratteristiche(Messaggio m) {
		String [] s = new String [2];
		if(m.getTipo() == TipoMessaggio.PRIVATO){
			MessaggioPrivato msg = (MessaggioPrivato) m.inserisciCaratteristiche(m);
			MessaggioPrivatoDB mdb = new MessaggioPrivatoDB(msg.getIdMessaggio(), msg.getDataInvio(), msg.getOraInvio(), msg.getTesto(), msg.getProfiloInviante(), msg.getIdProfiloRicevente());
			s[0] = mdb.getProfiloInviante();
			s[1] = mdb.getProfiloRicevente();
			return s;
		}
		else if(m.getTipo() == TipoMessaggio.DIGRUPPO) {
			MessaggioDiGruppo msg = (MessaggioDiGruppo) m.inserisciCaratteristiche(m);
			MessaggioDiGruppoDB mdb = new MessaggioDiGruppoDB(msg.getIdMessaggio(),msg.getDataInvio(),msg.getOraInvio(),msg.getTesto(),msg.getProfiloInviante(), msg.getIdGruppo());
			s[0] = mdb.getIdGruppo();
			s[1] = mdb.getProfiloInviante();
			return s;
			
		}
		return null;   
	}


	/**
	 * Converte una lista di MessaggioDB in una lista di Messaggio
	 * @param ArrayList di MessaggioDB, tipo utilizzabile solo nel database
	 */
public ArrayList<Messaggio> convertiLista(TipoMessaggio t, ArrayList<MessaggioDB> m){
	ArrayList<Messaggio> ms = new ArrayList<>();;
	   for(MessaggioDB msg : m)
		   ms.add(this.convertiInverso(msg, t));
	   return ms;
}

}

















