package post.sondaggio.utility;

import it.unipv.ings.Sondaggio.SondaggioDB;
import post.sondaggio.Sondaggio;
import post.sondaggio.SondaggioSceltaMultipla;

public class UtilitySondaggio implements IUtilitySondaggio{

	public SondaggioDB convertiDoppiaVotazioneToSondaggioDB(Sondaggio s) {
		SondaggioDB sdb = new SondaggioDB(s.getIdSondaggio(), s.getPrimaScelta(), s.getSecondaScelta(), null, null, s.getIdPost());
		return sdb;
	}

	@Override
	public SondaggioDB convertiSceltaMultiplaToSondaggioDB(SondaggioSceltaMultipla s) {
		SondaggioDB sdb = new SondaggioDB(s.getIdSondaggio(), s.getPrimaScelta(), s.getSecondaScelta(), s.getTerzaScelta(), s.getQuartaScelta(), s.getIdPost());
		return sdb;
	}
	
	
}
