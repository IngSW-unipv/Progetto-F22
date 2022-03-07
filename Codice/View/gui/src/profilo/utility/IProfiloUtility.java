package profilo.utility;

import db.profilo.ProfiloDB;
import profilo.EnumProfilo;
import profilo.Profilo;

public interface IProfiloUtility {

	//Metodo che converte un oggetto Profilo in un oggetto profiloDB utilizzato per fare le query sul db
	public ProfiloDB convertiAProfiloDB(Profilo p);
	
	//Metodo che permette di ottenere il valore della enum sotto forma di stringa
	public String trasformaEnumInString(EnumProfilo e);
}
