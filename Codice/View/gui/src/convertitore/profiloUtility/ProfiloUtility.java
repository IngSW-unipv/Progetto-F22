package convertitore.profiloUtility;


import db.profilo.ProfiloDB;
import profilo.EnumProfilo;
import profilo.Profilo;

public class ProfiloUtility {
	
	//Le chiavi esterne sono inizialmente null. Usare il metodo inserisciChiavi per modificarne il valore
	public static ProfiloDB convertiAProfiloDB(Profilo p) {
		ProfiloDB pdb = new ProfiloDB(p.getIdProfilo(), p.getNickname(), p.getDescrizione(), p.getNumFollower(), p.getNumSeguiti(), p.getNumPost(), ProfiloUtility.trasformaEnumInString(p.getTipo()), null, null, null, p.isAccountesistente(), p.isPswCambiata(), p.isLoggato(), p.getPassword());
		return pdb;
	}
	
	public static Profilo convertiAProfilo(ProfiloDB pdb) {
		Profilo p = new Profilo(pdb.getIdProfilo(), pdb.getNickname(), pdb.getDescrizione(), ProfiloUtility.trasformaStringinEnum(pdb.getTipo()));
		return p;
	}
	
	
	static public String trasformaEnumInString(EnumProfilo e) {
		String s;
		switch(e) {
		case PRIVATO: 
			s = "PRIVATO";
			break;
		case PUBBLICO:
			s = "PUBBLICO";
			break;
		default:
			System.out.println("Tipo di profilo non esistente");
			return null;
		}
		return s;
	}

	static public EnumProfilo trasformaStringinEnum(String s) {
		if(s.equals("PRIVATO")) {
			return EnumProfilo.PRIVATO;
		}
		else if(s.equals("PUBBLICO")) {
			return EnumProfilo.PUBBLICO;
		}
		System.out.println("La stringa inserita non corrisponde ad un tipo di profilo esistente");
		return null;
	}

}
