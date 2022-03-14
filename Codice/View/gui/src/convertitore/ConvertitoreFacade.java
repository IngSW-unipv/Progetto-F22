package convertitore;

import convertitore.*;
import convertitore.profiloUtility.ProfiloUtility;
import db.profilo.ProfiloDB;
import profilo.Profilo;

public class ConvertitoreFacade {
	
	static public ProfiloDB convertiProfilo(Profilo p) {
		return ProfiloUtility.convertiAProfiloDB(p);
	}
	static public Profilo convertiProfilo(ProfiloDB pdb) {
		return ProfiloUtility.convertiAProfilo(pdb);
	}
	
}
