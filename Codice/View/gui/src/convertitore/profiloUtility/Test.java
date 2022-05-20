package convertitore.profiloUtility;

import convertitore.ConvertitoreFacade;
import db.profilo.ProfiloDB;
import profilo.Profilo;

public class Test {
public static void main(String[] args) {
	ProfiloUtility u = new ProfiloUtility();
	ConvertitoreFacade f = ConvertitoreFacade.getIstance();
	ProfiloDB pdb = new ProfiloDB("P01", "Giovanni", null, 0, 0, 0, null, null, null, null, false, false, false, null);
	Profilo p1 = new Profilo("P01", "Giovanni");
	Profilo p = u.convertiInverso(pdb);
	System.out.println(p.toString());
	ProfiloDB pfin = u.converti(p1);
	System.out.println(pfin.toString());

	
	
}
}
