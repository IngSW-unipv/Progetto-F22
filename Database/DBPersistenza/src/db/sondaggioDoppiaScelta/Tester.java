package db.sondaggioDoppiaScelta;

import java.util.ArrayList;

import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.utility.SondaggioUtility;

public class Tester {

	public static void main(String[] args) {
		SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
		SondaggioDoppiaVotazione p = new SondaggioDoppiaVotazione("P00", null, null, null, 0, 0, false, false, null, null, null, null);
		SondaggioUtility u = new SondaggioUtility();
		
		ArrayList<SondaggioDoppiaVotazioneDB> res = sdao.selectAll();
		
		for(SondaggioDoppiaVotazioneDB pst : res)
			System.out.println(pst.toString());
		
		System.out.println(sdao.pubblicaSondaggio(u.convertiSDV(p)));
	
		System.out.println(sdao.rimuoviSondaggio(u.convertiSDV(p)));
	}
}
