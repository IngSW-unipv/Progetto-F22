package it.unipv.ings.Profilo;

import java.util.ArrayList;

public class ProfiloTester {

	public static void main(String[] args) {
		ProfiloDao pdao = new ProfiloDao();
		ArrayList<ProfiloDB> selectAll = pdao.selectAll();
       ProfiloDB prof = new ProfiloDB("002", null, null, 0, 2, 1, null, "003", "001", null, null);
		
        
        for(ProfiloDB p : selectAll)
			System.out.println(p.toString());
        
        ArrayList<ProfiloDB> cercaProfilo = pdao.cercaProfilo(prof);
        for(ProfiloDB p : cercaProfilo)
			System.out.println(p.toString());
        
        
        
       // System.out.println("Inserimento avvenuto? " +pdao.inserisciProfilo(prof));
        //System.out.println("L'inserimento delle chiavi è avvenuto? " +pdao.inserisciChiavi(prof));
        //System.out.println("La rimozione è avvenuta? " + pdao.rimuoviProfilo(prof));
        
	}

	}


