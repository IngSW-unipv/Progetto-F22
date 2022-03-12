package db.profilo;

import java.util.ArrayList;

import Utente.exception.AccountDoesNotExist;

public class ProfiloTester {

	public static void main(String[] args) {
		ProfiloDao pdao = new ProfiloDao();
		ArrayList<ProfiloDB> selectAll = pdao.selectAll();
       ProfiloDB prof = new ProfiloDB("002", null, null, 0, 2, 1, null, "003", "001", null, null, false, false,false, null);
       ProfiloDB prof1 = new ProfiloDB("001", null, null, 0, 2, 1, null, "003", "001", null, null, false, false,false, null);
        
       ArrayList<ProfiloDB> c;
	
		/*c = pdao.cercaProfilo(prof);
		for(ProfiloDB pr : c)
	    	   System.out.println(pr.toString());
	
       
   
       
       
       for(ProfiloDB p : selectAll)
			System.out.println(p.toString());
        
        ArrayList<ProfiloDB> cercaProfilo = pdao.cercaProfilo(prof);
        for(ProfiloDB p : cercaProfilo)
			System.out.println(p.toString());
        
    
       
    System.out.println(pdao.modificaIsLoggato(prof1.getIdProfilo(), true));
       
       try {
   		 System.out.println(pdao.vediSeIsLoggato(prof.getIdProfilo()));
   		
   	} catch (AccountDoesNotExist e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	} 
     
  
   	try {
   		 System.out.println(pdao.vediSeIsLoggato(prof1.getIdProfilo()));
   		 
   	} catch (AccountDoesNotExist e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
       
       
       
      System.out.println(pdao.modificaPswCambiata(prof1.getIdProfilo(), true));
       
       try {
   		 System.out.println(pdao.vediSePswCambiata(prof.getIdProfilo()));
   		
   	} catch (AccountDoesNotExist e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	} 
     
  
   	try {
   		 System.out.println(pdao.vediSeEsiste(prof1.getIdProfilo()));
   		 
   	} catch (AccountDoesNotExist e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
      
       
       System.out.println(pdao.modificaEsiste(prof.getIdProfilo(), false));   
       
   
	try {
		
		System.out.println(pdao.vediSeEsiste(prof.getIdProfilo()));
	} catch (AccountDoesNotExist e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} 
  
	
      
	try {
		 System.out.println(pdao.vediSeEsiste(prof1.getIdProfilo()));
	} catch (AccountDoesNotExist e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
   
      
        System.out.println("Inserimento avvenuto? " +pdao.inserisciProfilo(prof));
        System.out.println("L'inserimento delle chiavi è avvenuto? " +pdao.inserisciChiavi(prof));
        System.out.println("La rimozione è avvenuta? " + pdao.rimuoviProfilo(prof));
       */
       
     /*  try {
		System.out.println(pdao.modificaPsw(prof1.getIdProfilo(), "uva"));
	} catch (AccountDoesNotExist e) {
		// TODO Auto-generated catch block
		e.printStackTrace();*/
       
       try {
		String s = pdao.ottieniPsw(prof1.getIdProfilo());
		System.out.println(s);
	} catch (AccountDoesNotExist e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	}

	


