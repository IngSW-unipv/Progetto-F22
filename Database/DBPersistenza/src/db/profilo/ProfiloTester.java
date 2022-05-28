package db.profilo;

import java.util.ArrayList;

import profilo.exception.AccountDoesNotExist;

public class ProfiloTester {

	public static void main(String[] args) {
		ProfiloDao pdao = new ProfiloDao();
		ArrayList<ProfiloDB> selectAll = pdao.selectAll();
       ProfiloDB prof = new ProfiloDB("Dv999", null, null, 0, 2, 1, false, false,false, null, null);
       ProfiloDB prof1 = new ProfiloDB("001", null, null, 0, 2, 1, false, false,false, null, null);
  
	
	
    pdao.cambiaImmagineProfilo(prof, "fwquf3roufh");
       

       for(ProfiloDB p : selectAll)
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
        System.out.println("La rimozione � avvenuta? " + pdao.rimuoviProfilo(prof));
       
       
     try {
		System.out.println(pdao.modificaPsw(prof1.getIdProfilo(), "uva"));
	} catch (AccountDoesNotExist e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
    
   
      ProfiloDB plof =  pdao.cercaProfilo(prof);
      System.out.println(plof.toString());
     }
	}}
	
	

	


