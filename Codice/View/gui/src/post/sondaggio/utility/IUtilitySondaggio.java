package post.sondaggio.utility;

import it.unipv.ings.Sondaggio.SondaggioDB;
import post.sondaggio.Sondaggio;
import post.sondaggio.SondaggioSceltaMultipla;

public interface IUtilitySondaggio {
	
	//Adatta la classe sondaggioDoppiaVotazione alla classe sondaggioDB usata per fare le query
	public SondaggioDB convertiDoppiaVotazioneToSondaggioDB(Sondaggio s);
	
	//Adatta la classe sondaggioSceltaMultipla alla classe sondaggioDB usata per fare le query
	public SondaggioDB convertiSceltaMultiplaToSondaggioDB(SondaggioSceltaMultipla s);
		
	
}
