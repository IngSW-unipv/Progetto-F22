package Sistema;

import db.facade.DbFacade;
import post.commento.Commento;
import post.multimedia.Multimedia;
import post.multimedia.foto.Foto;
import post.testo.Testo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

import profilo.exception.*;
import profilo.*;

public class Sistema {
	
	private DbFacade dbfacade;
	private Profilo profiloAttivo = null;
	public Sistema()   {
		dbfacade = DbFacade.getIstance();
	}
	
	//idProfilo e Mail sono la stessa 
	public boolean signIn(String mail, String nickName, String password) throws AccountGiaEsistente, ChangeDefaultPassword, AccountDoesNotExist {
		Profilo p =  new Profilo(mail, nickName);
		
	    if(dbfacade.cerca(p) == null) {
	    	System.out.println(p.getIdProfilo() + 1);
	        dbfacade.carica(p);
	        dbfacade.modificaEsiste(mail, true);
            this.cambiaDefaultPassword(mail, password);
 			this.setProfiloAttivo(p);
	    	System.out.println(this.getProfiloAttivo().getIdProfilo() + " dopo il cambiapassword");
            return true;
        }
	  throw new AccountGiaEsistente(mail);  
	}
	

		public boolean cambiaDefaultPassword (String email, String nuovaPsw) throws ChangeDefaultPassword, AccountDoesNotExist {
			Profilo p = new Profilo(email, null);
	 		String s = dbfacade.vediPsw(email);

        
	 		//Se provo a cambiare psw ad un account che non esiste viene lanciata una eccezione
	 	if(dbfacade.cerca(p) != null && dbfacade.vediEsiste(email) == true) {
	 		if(s.equals("Cambiami") && nuovaPsw != "Cambiami") {
	 			dbfacade.modificaPsw(email, nuovaPsw);
	 			dbfacade.modificaPswCambiata(email, true);
	 				return true;
	 		      }
	 		    throw new ChangeDefaultPassword("Cambiami");
	 		}
	 		else
	 		    throw new AccountDoesNotExist(email);
	 	}

    public boolean cambiaPassword(String email, String vecchiaPassword, String nuovaPassword) throws ChangeDefaultPassword, AccountDoesNotExist {
    	
    	    Profilo p = new Profilo(email,null);
	 		String s = dbfacade.vediPsw(email);

	 		if(dbfacade.cerca(p) != null && dbfacade.vediEsiste(email) == true) {

	 		    if(dbfacade.vediPswCambiata(email) == false)
	 			   throw new ChangeDefaultPassword("Cambiami");

	 		    else if(s.equals(vecchiaPassword)) {
	 		    	dbfacade.modificaPsw(email, nuovaPassword);
	 		    		return true;
	 		}
	 	}
	 		else
	 		    throw new AccountDoesNotExist(email);
		return false;
	 	}

    
	public boolean login(String email, String psw) throws ChangeDefaultPassword, AccountDoesNotExist, PswOmailErrati {
			if(dbfacade.vediPswCambiata(email) == false)
	 			throw new ChangeDefaultPassword("Cambiami");
	 		else if (dbfacade.vediEsiste(email) == false)
	 			throw new AccountDoesNotExist(email);
	 		else if(dbfacade.vediPsw(email).equals(psw)) {
	 			dbfacade.modificaLoggato(email, true);
	 			Profilo p = dbfacade.cerca(new Profilo(email,null));
	 			this.setProfiloAttivo(p);
	 			System.out.println("fssefes" + this.getProfiloAttivo().getIdProfilo());
	 			
	 			return true;
	 		}
	 		throw new PswOmailErrati(email,psw);
	 	}

	
	
	 public boolean rimuoviAccount(Profilo p) {
	 	return dbfacade.rimuovi(p);
	 }
	  public void carica(String idProfilo, String idPost, String commento) {
		  
			Commento c;
			boolean b;
	 		int idCommentoInt = (int)Math.round(Math.random() * 1000);
	 		String idCommento = Integer.toString(idCommentoInt);
	 		c = new Commento(idCommento, idProfilo, idPost, commento);
	 		if(dbfacade.cerca(c) != null) {
	 			carica(idProfilo, idPost, commento);
	 		}
	 		profiloAttivo.pubblicaCommento(c);

	  }
	 
	 public String[][] caricaTuttiiPostDiUnProfilo() {
		ArrayList<String> idDeiPostDiUnProfilo = this.profiloAttivo.caricaTuttiiPostDiUnProfilo(new Profilo(this.getProfiloAttivo().getIdProfilo()), new Foto("110", null, false, false, null, null, false));
		String[][] idPostConPercorsoPost = new String[idDeiPostDiUnProfilo.size()][idDeiPostDiUnProfilo.size()];
		 for(int i = 0; i < idDeiPostDiUnProfilo.size(); i++) {
			 idPostConPercorsoPost[i][0] = idDeiPostDiUnProfilo.get(i);
			 System.out.println(((Multimedia) dbfacade.cerca(new Foto("110",null, false, false, null, null, false))).getPercorso());
			 idPostConPercorsoPost[i][1] = ((Foto)(dbfacade.cerca(new Foto("110", null,true, false, this.getProfiloAttivo().getIdProfilo(), null, false)))).getPercorso();
			 
			 System.out.println(idPostConPercorsoPost[i][0] + idPostConPercorsoPost[i][1]);
		 }
		
		return idPostConPercorsoPost;
	 }
	 public boolean logout(String email) throws AccountDoesNotExist {
	 	
		 Profilo p = new Profilo(email,null);
	 		boolean b = dbfacade.vediSeLoggato(email);

	 		if(dbfacade.cerca(p) != null && dbfacade.vediEsiste(email) == true) {
	 			if(b == true) {
	 				dbfacade.modificaLoggato(email, false);
	 				System.out.println("Hai effettuato il logout con successo");
	 				setProfiloAttivo(null);
	 			return true;
	 			}
	 			else 
	 				return false;
	 		}
	 		
	 	else
	 	    throw new AccountDoesNotExist(email);
	 }
	 	

	 	public ArrayList<Profilo> stampaTuttiIprofilo() {
	 		ArrayList<Profilo> res = dbfacade.selectAllProfilo();
	 		return res;
	 	}
	 	
	 	
	 	
	 	/*public void pubblicaPost(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, boolean isHd) {

	 		profiloAttivo.creaPost(new Foto(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo, percorso, isHd));
	 	}*/
	 	
	 	public void pubblicaTesto(String idPost,String descrizione, boolean visibile, boolean condivisibile, String profilo, boolean isHd, String font, String titolo) {
	 		profiloAttivo.creaPost(new Testo(idPost,descrizione, visibile, condivisibile, profilo, font, titolo));
	 	}
	 	
	 	
		public void pubblicaPost( String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, boolean isHd) {
	 		Foto p;
	 		int idPostInt = (int)Math.round(Math.random() * 1000);
	 		String idPost = Integer.toString(idPostInt);
	 		p = new Foto(idPost, descrizione, visibile, condivisibile, profilo, percorso, isHd);
	 		
	 		if(dbfacade.cerca(new Foto(idPost, null, false, false, null, null, false)) != null) {
	 			pubblicaPost(descrizione, visibile, condivisibile, profilo, percorso, isHd);
	 		}
	 		
	 		profiloAttivo.creaPost(p);
	 	}
	 
	public void impostaFotoProfilo(String fotoPath) {
		profiloAttivo.cambiaImmagineProfilo(this.getProfiloAttivo(), fotoPath);
	}
		
		
	public Profilo getProfiloAttivo() {
		return profiloAttivo;
	}

	public void setProfiloAttivo(Profilo profiloAttivo) {
		this.profiloAttivo = profiloAttivo;
	}
	 

}

