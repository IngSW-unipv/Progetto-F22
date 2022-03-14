package convertitore.sondaggioUtility;


import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDB;
import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDB;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;

public class SondaggioUtility implements ISondaggioUtility{

	@Override
	public SondaggioDoppiaVotazioneDB convertiSDV(SondaggioDoppiaVotazione s) {
		SondaggioDoppiaVotazioneDB fdb = new SondaggioDoppiaVotazioneDB(s.getIdPost(), s.getDataPubblicazione(), s.getOraPubblicazione(), s.getDescrizione(), s.getNumLike(), s.getNumDislike(), s.isVisibile(), s.isCondivisibile(), s.getProfilo(), s.getPrimaScelta(),s.getSecondaScelta());
		return fdb;
	}

	@Override
	public SondaggioSceltaMultiplaDB convertiSSM(SondaggioSceltaMultipla s) {
		SondaggioSceltaMultiplaDB fdb = new SondaggioSceltaMultiplaDB(s.getIdPost(), s.getDataPubblicazione(), s.getOraPubblicazione(), s.getDescrizione(), s.getNumLike(), s.getNumDislike(), s.isVisibile(), s.isCondivisibile(), s.getProfilo(), s.getPrimaScelta(),s.getSecondaScelta(),s.getTerzaScelta(),s.getQuartaScelta());
		return fdb;
	}

}
