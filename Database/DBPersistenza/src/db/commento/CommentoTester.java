package db.commento;

import java.util.ArrayList;

import db.profilo.ProfiloDB;

public class CommentoTester {

	public static void main(String [] args) {
		CommentoDao cdao = new CommentoDao();
		
		CommentoDB c1 = new CommentoDB("001", null, null, null, null, "F00", "V11", "S00", "P00", "T00");
		CommentoDB c2 = new CommentoDB("002", null, null, null, null, "F00", "V11", "S00", "P00", "T00");
		
		cdao.scriviCommento(c1);
		cdao.scriviCommento(c2);
		
		ProfiloDB p = new ProfiloDB("001","", null, 0, 0, 0, null, null, null, null, false, false, false, null, null);
		
		ArrayList<String> res = cdao.ProfiloNickCommento(p);
		
			
		for(String str : res)
			System.out.println(str.toString());
	}
}
