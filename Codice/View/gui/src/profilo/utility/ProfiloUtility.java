package profilo.utility;


import db.profilo.ProfiloDB;
import profilo.EnumProfilo;
import profilo.Profilo;

public class ProfiloUtility implements IProfiloUtility{

	@Override
	public ProfiloDB convertiAProfiloDB(Profilo p) {
		ProfiloDB pdb = new ProfiloDB(p.getIdProfilo(), p.getNickname(), p.getDescrizione(), p.getNumFollower(), p.getNumSeguiti(), p.getNumPost(),this.trasformaEnumInString(p.getTipo()), p.getMessaggioDiGruppo(),p.getMessaggioPrivato(),p.getUtente().getIdUtente(),p.getPost());
		return pdb;
	}

	@Override
	public String trasformaEnumInString(EnumProfilo e) {
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


}
