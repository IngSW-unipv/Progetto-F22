package db.commento;

import java.util.ArrayList;

import db.profilo.ProfiloDB;

public class CommentoTester {

	public static void main(String [] args) {
		CommentoDao cdao = new CommentoDao();
		ProfiloDB p = new ProfiloDB("001","", null, 0, 0, 0, null, null, null, null, false, false, false, null, null);
		
		ArrayList<String> res = cdao.ProfiloNickCommento(p);
		
			
		for(String str : res)
			System.out.println(str.toString());
	}
}
