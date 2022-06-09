package convertitore.profiloUtility;


import db.profilo.ProfiloDB;
import post.multimedia.foto.Foto;
import profilo.Profilo;
import profilo.exception.PostNonPresente;
import profilo.exception.PostNonVisibile;

public class Test {
public static void main(String[] args) {
	ProfiloUtility u = new ProfiloUtility();
	ProfiloDB pdb = new ProfiloDB("P01", "Giovanni", null, 0, 0, 0, false, false, false, null, null);
	Profilo p1 = new Profilo("P01", "Giovanni");
	Foto f = new Foto("F00", null, false, null, null, false);

	
	Profilo p = u.convertiInverso(pdb);
	System.out.println(p.toString());
	ProfiloDB pfin = u.converti(p1);
	System.out.println(pfin.toString());

	try {
		try {
			p1.cercaPost(f);
		} catch (PostNonPresente e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	} catch (PostNonVisibile e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
}
}
