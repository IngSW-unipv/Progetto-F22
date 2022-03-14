package convertitore.profiloUtility;


import db.profilo.ProfiloDB;
import profilo.EnumProfilo;
import profilo.Profilo;

public class ProfiloUtility {

	/*public static  ProfiloDB convertiAProfiloDB(Profilo p) {
		ProfiloDB pdb = new ProfiloDB(p.getIdProfilo(), p.getNickname(), p.getDescrizione(), p.getNumFollower(), p.getNumSeguiti(), p.getNumPost(),ProfiloUtility.trasformaEnumInString(p.getTipo()), p.getMessaggioDiGruppo(),p.getMessaggioPrivato(), null, p.getPost(),p.isAccountesistente(), p.isPswCambiata(),p.isLoggato(), p.getPassword());
		return pdb;
	}*/
	
	public static ProfiloDB convertiAProfiloDB(Profilo p) {
		ProfiloDB pdb = new ProfiloDB(p.getIdProfilo(), p.getNickname(), p.getDescrizione(), p.getNumFollower(), p.getNumSeguiti(), p.getNumPost(),ProfiloUtility.trasformaEnumInString(p.getTipo()), p.getMessaggioDiGruppo(),p.getMessaggioPrivato(), null ,p.getPost(),p.isAccountesistente(), p.isPswCambiata(),p.isLoggato(), p.getPwd());
		return pdb;
	}
	
	public static  Profilo convertiAProfilo(ProfiloDB pdb) {
		Profilo p = new Profilo(pdb.getIdProfilo(), pdb.getNickname(), pdb.getDescrizione(), pdb.getNumFollower(), pdb.getNumSeguiti(), pdb.getNumPost(),ProfiloUtility.trasformaStringinEnum(pdb.getTipo()), pdb.getMessaggioDiGruppo(),pdb.getMessaggioPrivato(),pdb.getIdProfilo(),pdb.isEsiste(), pdb.isPswCambiata(),pdb.isLoggato(), pdb.getPsw());
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
		EnumProfilo enumP = null;
		if(s.compareTo("PRIVATO") == 0) {
			enumP = EnumProfilo.PRIVATO;
		}
		if(s.compareTo("PUBBLICO") == 0) {
			enumP = EnumProfilo.PUBBLICO;
		}
		return enumP;
	}

}
