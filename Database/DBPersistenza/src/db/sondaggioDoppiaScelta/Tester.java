package db.sondaggioDoppiaScelta;

import java.util.ArrayList;

import post.Post;
import post.sondaggio.SondaggioDoppiaVotazione;

public class Tester {

	public static void main(String[] args) {
		SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
		SondaggioDoppiaVotazione p = new SondaggioDoppiaVotazione("P00", null, null, null, 0, 0, false, false, null, null, null, null);
		
		ArrayList<Post> res = sdao.selectAll();
		
		for(Post pst : res)
			System.out.println(pst.toString());
		
		//System.out.println(sdao.pubblicaSondaggio(p));
		//System.out.println(sdao.aggiungiScelte(p, "Cane", "Gatto"));
		System.out.println(sdao.rimuoviSondaggio(p));
	}
}
