package Sistema;

import db.facade.DbFacade;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;

import java.util.ArrayList;


import Messaggio.Messaggio;
import Messaggio.MessaggioPrivato;
import chat.chatDiGruppo.ChatDiGruppo;
import profilo.exception.*;
import profilo.*;

public class Sistema {
	
	private DbFacade dbfacade;
	private Profilo profiloAttivo = null;
	private Profilo profiloCercato,  profiloConCuiSiStaChattando;
	private ChatDiGruppo chatCercata;
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
	 		int idCommentoInt = (int)Math.round(Math.random() * 1000);
	 		String idCommento = Integer.toString(idCommentoInt);
	 		c = new Commento(idCommento, idProfilo, idPost, commento);
	 		if(dbfacade.cerca(c) != null) {
	 			carica(idProfilo, idPost, commento);
	 		}
	 		profiloAttivo.pubblicaCommento(c);

	  }
	  
	  public void ricerca(String idDaCercare) {
		  setProfiloCercato(dbfacade.cerca(new Profilo(idDaCercare)));
		  //chatCercata = dbfacade.cerca(new chatDiGruppo);
	  }
	 
	 public ArrayList<String> caricaTuttiiPostDiUnProfilo(String idProfilo, TipoPost tipoPost) {
		 
		
		ArrayList<String> idDeiPostDiUnProfilo = profiloAttivo.caricaTuttiiPostDiUnProfilo(new Profilo(idProfilo), tipoPost);
		for(int i = 0; i < idDeiPostDiUnProfilo.size(); i++) {
		}
		
		return idDeiPostDiUnProfilo;
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
	 	
	 	public void pubblicaTesto(String idPost,String descrizione, boolean visibile, String profilo, boolean isHd, String font, String titolo) {
	 		profiloAttivo.creaPost(new Testo(idPost,descrizione, visibile, profilo, font, titolo));
	 	}
	 	
	 	
	 	public void pubblicaFoto(String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, boolean isHd) {
	 		Foto p;
	 		int idPostInt = (int)Math.round(Math.random() * 1000);
	 		String idPost = Integer.toString(idPostInt);
	 		p = new Foto(idPost, descrizione, visibile, profilo, percorso, isHd);
	 		
	 		if(dbfacade.cerca(new Foto(idPost, null, false, null, null, false)) != null) {
	 			pubblicaFoto(descrizione, visibile, condivisibile, profilo, percorso, isHd);
	 		}
	 		profiloAttivo.creaPost(p);
	 	}

		public void pubblicaSondaggioSceltaMultipla(String descrizione, boolean visibile, String profilo,
				String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta) {
			
			SondaggioSceltaMultipla s;
	 		int idPostInt = (int)Math.round(Math.random() * 1000);
	 		String idPost = Integer.toString(idPostInt);
	 		
	 		s = new SondaggioSceltaMultipla(idPost, descrizione, visibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta);
	 		
	 		if(dbfacade.cerca(new SondaggioSceltaMultipla(idPost, null, false, null, null, null, null, null)) != null) {
	        	System.out.println(primaScelta + secondaScelta + terzaScelta + quartaScelta);
	 			pubblicaSondaggioSceltaMultipla(descrizione, visibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta);
	 		}
        	System.out.println(s.getPrimaScelta() + s.getSecondaScelta() + s.getTerzaScelta() + s.getQuartaScelta());

	 		profiloAttivo.creaPost(s);
		}
		
		public void pubblicaSondaggioDoppiaVotazione(String descrizione, boolean visibile, String profilo, String primaScelta, String secondaScelta) {
			
			SondaggioDoppiaVotazione s;
	 		int idPostInt = (int)Math.round(Math.random() * 1000);
	 		String idPost = Integer.toString(idPostInt);
	 		
	 		s = new SondaggioDoppiaVotazione(idPost, descrizione, visibile, profilo, primaScelta, secondaScelta);
	 		
	 		if(dbfacade.cerca(new SondaggioDoppiaVotazione(idPost, null, false, null, null, null)) != null) {
	 			pubblicaSondaggioDoppiaVotazione(descrizione, visibile, profilo, primaScelta, secondaScelta);
	 		}
	 		
	 		profiloAttivo.creaPost(s);
		}
		
		public void pubblicaTesto(String descrizione, boolean visibile, String profilo, String font, String titolo) {
			
			Testo t;
			int idPostInt = (int)Math.round(Math.random() * 1000);
	 		String idPost = Integer.toString(idPostInt);
	 		
	 		t = new Testo(idPost, descrizione, visibile, profilo, font, titolo);
	 		
	 		if(dbfacade.cerca(new Testo(idPost, null, false, null, null, null)) != null) {
	 			pubblicaTesto(descrizione, visibile, profilo, font, titolo);
	 		}
	 		
	 		profiloAttivo.creaPost(t);
		}

		public ArrayList<String> selectAllCommentiSottoPost(String idPost) throws PostNonVisibile {
			ArrayList<Commento> listaCommenti = new ArrayList<Commento>();
			ArrayList<String> listaTestiCommentiConInviante = new ArrayList<String>();
			
			listaCommenti =  profiloAttivo.selectAllCommentiSottoPost(new Foto(idPost));
			
		
			for(int i=0; i<listaCommenti.size(); i++) {
				listaTestiCommentiConInviante.add(listaCommenti.get(i).getProfilo());
				listaTestiCommentiConInviante.add(listaCommenti.get(i).getTesto());
			}
	
			return listaTestiCommentiConInviante;
		}
		
	public void scriviMessaggio( String testo, String multimediale, String inviante,String ricevente) {

 		int idMessage = (int)Math.round(Math.random() * 10000);
 		String idMessaggio = Integer.toString(idMessage);

 		if(dbfacade.cerca(new MessaggioPrivato(idMessaggio)) != null) {
 			scriviMessaggio(testo, multimediale, inviante, ricevente);
 			System.out.println(testo);
 		}
 		profiloAttivo.scriviMessaggio(new MessaggioPrivato(idMessaggio, testo, multimediale, inviante, ricevente));
	}
	
	public ArrayList<String> cercaMessaggiChatPrivata(String inviante, String ricevente) {
		ArrayList<Messaggio> listaMessaggi = profiloAttivo.cercaMessaggiChatPrivata(inviante, ricevente);
		ArrayList<String> listaTestoEProfiloInviante = new ArrayList<String>();
		
		for(int i = 0; i < listaMessaggi.size(); i++) {
			listaTestoEProfiloInviante.add(listaMessaggi.get(i).getProfiloInviante());
			listaTestoEProfiloInviante.add(listaMessaggi.get(i).getTesto());
		}
		return listaTestoEProfiloInviante;
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

	public Profilo getProfiloCercato() {
		return profiloCercato;
	}

	public void setProfiloCercato(Profilo profiloCercato) {
		this.profiloCercato = profiloCercato;
	}

	public ChatDiGruppo getChatCercata() {
		return chatCercata;
	}

	public void setChatCercata(ChatDiGruppo chatCercata) {
		this.chatCercata = chatCercata;
	}

	public Profilo getProfiloConCuiSiStaChattando() {
		return profiloConCuiSiStaChattando;
	}

	public void setProfiloConCuiSiStaChattando(Profilo profiloConCuiSiStaChattando) {
		this.profiloConCuiSiStaChattando = profiloConCuiSiStaChattando;
	}
	
	

}

