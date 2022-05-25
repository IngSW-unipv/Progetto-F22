package convertitore.profiloUtility;


import java.util.ArrayList;

import db.profilo.ProfiloDB;
import profilo.EnumProfilo;
import profilo.Profilo;

public class ProfiloUtility {
	
	//Le chiavi esterne sono inizialmente null. Usare il metodo inserisciChiavi per modificarne il valore
	public ProfiloDB converti(Profilo p) {
		ProfiloDB pdb = new ProfiloDB(p.getIdProfilo(), p.getNickname(), p.getDescrizione(), p.getNumFollower(), p.getNumSeguiti(), p.getNumPost(), this.trasformaEnumInString(p.getTipo()), p.isAccountesistente(), p.isPswCambiata(), p.isLoggato(), "Cambiami",null);
		return pdb;
	}
	
	public Profilo convertiInverso(ProfiloDB pdb) {
		Profilo p = new Profilo(pdb.getIdProfilo(), pdb.getNickname());
		return p;
	}
	
	public ArrayList<Profilo> convertiLista(ArrayList <ProfiloDB> res){
		ArrayList<Profilo> pr = new ArrayList<>();
		for(ProfiloDB pdb: res)
			pr.add(this.convertiInverso(pdb));
		return pr;
	}
	
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

	 public EnumProfilo trasformaStringinEnum(String s) {
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
