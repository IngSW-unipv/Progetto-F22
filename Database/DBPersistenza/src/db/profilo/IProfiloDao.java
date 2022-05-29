package db.profilo;

import java.util.ArrayList;

import profilo.exception.AccountDoesNotExist;

public interface IProfiloDao {
	public ArrayList<ProfiloDB> selectAll();
	public boolean inserisciProfilo(ProfiloDB p);
	public boolean rimuoviProfilo(ProfiloDB p);
	public ProfiloDB cercaProfilo(ProfiloDB p);
	
	//prende il valore del campo "esiste" di un profilo specificato
	public boolean vediSeEsiste(String idProfilo) throws AccountDoesNotExist ;
	
	//Modifica il valore del campo "esiste" di un profilo specificato
 	public boolean modificaEsiste(String idProfilo, boolean s);
	
 	
 	//prende il valore del campo "pswCambiata" di un profilo specificato
 	public boolean vediSePswCambiata(String idProfilo) throws AccountDoesNotExist ;
 		
 	//Modifica il valore del campo "pswCambiata" di un profilo specificato
 	 public boolean modificaPswCambiata(String idProfilo, boolean s);
 	 
 	//prende il valore del campo "isLoggato" di un profilo specificato
  	public boolean vediSeIsLoggato(String idProfilo) throws AccountDoesNotExist ;
  		
  	//Modifica il valore del campo "isLoggato" di un profilo specificato
  	 public boolean modificaIsLoggato(String idProfilo, boolean s);
  	 
  	 public boolean modificaPsw(String idProfilo, String s) throws AccountDoesNotExist;
  	 
  	 public String ottieniPsw(String idProfilo)throws AccountDoesNotExist;
  	 
  	 public boolean cambiaImmagineProfilo(ProfiloDB p, String s);
  	 public String ottieniImmagine(ProfiloDB p);
  	 
  	 public int vediSeguiti(ProfiloDB p);
  	 public int vediFollower(ProfiloDB p);
  	 public boolean modificaSeguiti(ProfiloDB p, int n);
  	 public boolean modificaFollower(ProfiloDB p, int n);
  	 
  	 public int vediNumPost(ProfiloDB p);
  	 public boolean modificaNumPost(ProfiloDB p, int n);
}
