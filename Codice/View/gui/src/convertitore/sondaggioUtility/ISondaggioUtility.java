package convertitore.sondaggioUtility;

import db.sondaggioDoppiaScelta.SondaggioDoppiaVotazioneDB;
import db.sondaggioSceltaMultipla.SondaggioSceltaMultiplaDB;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;

public interface ISondaggioUtility {

	public SondaggioDoppiaVotazioneDB convertiSDV(SondaggioDoppiaVotazione s);
	public SondaggioSceltaMultiplaDB convertiSSM(SondaggioSceltaMultipla s);
}
