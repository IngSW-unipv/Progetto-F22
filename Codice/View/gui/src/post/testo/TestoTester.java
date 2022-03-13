package post.testo;

import java.util.ArrayList;

import db.testo.TestoDB;

public class TestoTester {
	public static void main(String[] args) {
		
		Testo t = new Testo("T00", null, null, null, 0, 0, false, false, "001", "Arial", "T00");
       
		System.out.println(t.caricaPost(t));
		System.out.println(t.rimuoviPost(t));
		ArrayList<TestoDB> res = t.selectAllTesto();
        
        for(TestoDB pst : res)
        	System.out.println(pst.toString());
	}
}
