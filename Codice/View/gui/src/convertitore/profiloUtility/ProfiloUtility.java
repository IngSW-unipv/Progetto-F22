package convertitore.profiloUtility;


import java.util.ArrayList;

import db.profilo.ProfiloDB;
import profilo.Profilo;

public class ProfiloUtility {
	
	//Le chiavi esterne sono inizialmente null. Usare il metodo inserisciChiavi per modificarne il valore
	public ProfiloDB converti(Profilo p) {
		ProfiloDB pdb = new ProfiloDB(p.getIdProfilo(), p.getNickname(), p.getDescrizione(), p.getNumFollower(), p.getNumSeguiti(), p.getNumPost(), p.isAccountesistente(), p.isPswCambiata(), p.isLoggato(), p.getPassword(),p.getFotoProfilo());
		return pdb;
	}
	
	public Profilo convertiInverso(ProfiloDB pdb) {
		Profilo p = new Profilo(pdb.getIdProfilo(), pdb.getNickname(),pdb.getDescrizione(),pdb.getNumFollower(),pdb.getNumSeguiti(),pdb.getNumPost(),pdb.isEsiste(),pdb.isPswCambiata(),pdb.isLoggato(),pdb.getPsw(),pdb.getImmagineProfilo());
		return p;
	}
	
	public ArrayList<Profilo> convertiLista(ArrayList <ProfiloDB> res){
		ArrayList<Profilo> pr = new ArrayList<>();
		for(ProfiloDB pdb: res)
			pr.add(this.convertiInverso(pdb));
		return pr;
	}


	
}
