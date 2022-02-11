package it.unipv.ings.Profilo;

import java.util.ArrayList;

public class ProfiloTester {

	public static void main(String[] args) {
		ProfiloDao pdao = new ProfiloDao();
		ArrayList<Profilo> selectAll = pdao.selectAll();
       Profilo prof = new Profilo("002", null, null, 0, 2, 1, null, "003", "001", null, null);
		
        
        for(Profilo p : selectAll)
			System.out.println(p.toString());
        
        ArrayList<Profilo> cercaProfilo = pdao.cercaProfilo(prof);
        for(Profilo p : cercaProfilo)
			System.out.println(p.toString());
        
        
        
        System.out.println("Inserimento avvenuto? " +pdao.inserisciProfilo(prof));
        System.out.println("L'inserimento delle chiavi è avvenuto? " +pdao.inserisciChiavi(prof));
        //System.out.println("La rimozione è avvenuta? " + pdao.rimuoviProfilo(prof));
        
	}

	}


