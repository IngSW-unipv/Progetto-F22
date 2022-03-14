package convertitore.sondaggioUtility;


import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDB;
import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDB;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;

public class SondaggioUtility {

	public static SondaggioDoppiaVotazioneDB convertiASondDopDB(SondaggioDoppiaVotazione s) {
		SondaggioDoppiaVotazioneDB fdb = new SondaggioDoppiaVotazioneDB(s.getIdPost(), s.getDataPubblicazione(), s.getOraPubblicazione(), s.getDescrizione(), s.getNumLike(), s.getNumDislike(), s.isVisibile(), s.isCondivisibile(), s.getProfilo(), s.getPrimaScelta(),s.getSecondaScelta());
		return fdb;
	}

	public static SondaggioSceltaMultiplaDB convertiASondMulDB(SondaggioSceltaMultipla s) {
		SondaggioSceltaMultiplaDB fdb = new SondaggioSceltaMultiplaDB(s.getIdPost(), s.getDataPubblicazione(), s.getOraPubblicazione(), s.getDescrizione(), s.getNumLike(), s.getNumDislike(), s.isVisibile(), s.isCondivisibile(), s.getProfilo(), s.getPrimaScelta(),s.getSecondaScelta(),s.getTerzaScelta(),s.getQuartaScelta());
		return fdb;
	}

	public static SondaggioDoppiaVotazione convertiASondDop(SondaggioDoppiaVotazioneDB s) {
		SondaggioDoppiaVotazione sdb = new SondaggioDoppiaVotazione(s.getIdSondaggio(), s.getDataPubblicazione(), s.getOraPubblicazione(), s.getDescrizione(), s.isVisibile(), s.isCondivisibile(), s.getProfilo(), s.getPrimaScelta(), s.getSecondaScelta(), new int[2]);
		return sdb;
	}
	
	public static SondaggioSceltaMultipla convertiASondMul(SondaggioSceltaMultiplaDB s) {
		SondaggioSceltaMultipla sdb = new SondaggioSceltaMultipla(s.getIdSondaggio(), s.getDataPubblicazione(), s.getOraPubblicazione(), s.getDescrizione(), s.isVisibile(), s.isCondivisibile(), s.getProfilo(), s.getPrimaScelta(), s.getSecondaScelta(), s.getTerzaScelta(), s.getQuartaScelta(), new int[4]);
		return sdb;
	}
}
