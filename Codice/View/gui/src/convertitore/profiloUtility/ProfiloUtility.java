package convertitore.profiloUtility;


import java.util.ArrayList;

import db.profilo.ProfiloDB;
import profilo.Profilo;

public class ProfiloUtility {
	
	/**
	 * Converte un Profilo in un ProfiloDB
	 * @param Oggetto di tipo Profilo da convertire
	 */
	public ProfiloDB converti(Profilo p) {
		ProfiloDB pdb = new ProfiloDB(p.getIdProfilo(), p.getNickname(), p.getDescrizione(), p.getNumFollower(), p.getNumSeguiti(), p.getNumPost(), p.isAccountesistente(), p.isPswCambiata(), p.isLoggato(), p.getPassword(),p.getFotoProfilo());
		return pdb;
	}
	
	/**
	 * Converte un ProfiloDB in un Profilo
	 * @param Oggetto di tipo Profilo utilizzabile solo per eseguire le query
	 */
	public Profilo convertiInverso(ProfiloDB pdb) {
		Profilo p = new Profilo(pdb.getIdProfilo(), pdb.getNickname(),pdb.getDescrizione(),pdb.getNumFollower(),pdb.getNumSeguiti(),pdb.getNumPost(),pdb.isEsiste(),pdb.isPswCambiata(),pdb.isLoggato(),pdb.getPsw(),pdb.getImmagineProfilo());
		return p;
	}
	
	/**
	 * Converte una lista di ProfiloDB in una lista di Profilo
	 * @param ArrayList di ProfiloDB, tipo utilizzabile solo nel databse
	 */
	public ArrayList<Profilo> convertiLista(ArrayList <ProfiloDB> res){
		ArrayList<Profilo> pr = new ArrayList<>();
		for(ProfiloDB pdb: res)
			pr.add(this.convertiInverso(pdb));
		return pr;
	}


	
}
