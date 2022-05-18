package profilo;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Timer;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import Messaggio.enumeration.TipoMessaggio;
import chat.Chat;
import chat.chatDiGruppo.ChatDiGruppo;
import chat.chatDiGruppo.gruppo.Gruppo;
import chat.chatPrivata.ChatPrivata;
import db.facade.DbFacade;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDB;
import db.messaggio.messaggioPrivato.MessaggioPrivatoDB;
import db.profilo.ProfiloDB;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.Multimedia;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.Sondaggio;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.exception.AccountDoesNotExist;
import profilo.follow.Follow;
import java.util.TimerTask;

public class Profilo implements IProfilo { 

	private static DbFacade dbfacade;
	
	private String idProfilo;
	private String nickname;
	private String descrizione;
	private int numFollower;
	private int numSeguiti;
	private int numPost;
	private EnumProfilo tipo;
	private String password;
	private boolean loggato;
	private boolean accountesistente;
	private boolean isPswCambiata;
	private HashMap<String,String> likeMap;
	private HashMap<String,String> dislikeMap;
	
	//funzione richiamata dal signUP
	public Profilo(String idProfilo, String nickname) {
		super();
		this.dbfacade = dbfacade.getIstance();
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = null;
		this.numFollower = 0;
		this.numSeguiti = 0;
		this.numPost = 0;
		this.tipo = tipo.PUBBLICO;
		likeMap = new HashMap<>();
		dislikeMap = new HashMap<>();
	}
	
	public Profilo(String idProfilo) {
		super();
		this.dbfacade = dbfacade.getIstance();
		this.idProfilo = idProfilo;
		this.nickname = null;
		this.descrizione = null;
		this.numFollower = 0;
		this.numSeguiti = 0;
		this.numPost = 0;
		this.tipo = tipo.PUBBLICO;
		likeMap = new HashMap<>();
		dislikeMap = new HashMap<>();
	}
	

	//costruttore per la conversione profiloDB
	public 	Profilo(String idProfilo, String nickname, String descrizione, EnumProfilo visibilita) {
		this.dbfacade = dbfacade.getIstance();
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = descrizione;
		this.numFollower = 0;
		this.numSeguiti = 0;
		this.numPost = 0;
		this.tipo = visibilita;
		this.loggato = false;
		this.accountesistente = false;
		this.isPswCambiata = false;
		this.password = "Cambiami";
		likeMap = new HashMap<>(); 
		dislikeMap = new HashMap<>();
	}


public String getIdProfilo() {
	return idProfilo;
}
public void setIdProfilo(String idProfilo) {
	this.idProfilo = idProfilo;
}
public String getNickname() {
	return nickname;
}
public void setNickname(String nickname) {
	this.nickname = nickname;
}
public String getDescrizione() {
	return descrizione;
}
public void setDescrizione(String descrizione) {
	this.descrizione = descrizione;
}
public int getNumFollower() {
	return numFollower;
}
public void setNumFollower(int numFollower) {
	this.numFollower = numFollower;
}
public int getNumSeguiti() {
	return numSeguiti;
}
public void setNumSeguiti(int numSeguiti) {
	this.numSeguiti = numSeguiti;
}
public int getNumPost() {
	return numPost;
}
public void setNumPost(int numPost) {
	this.numPost = numPost;
}
public EnumProfilo getTipo() {
	return tipo;
}
public void setTipo(EnumProfilo tipo) {
	this.tipo = tipo;
}


public boolean isLoggato() {
	return loggato;
}

public void setLoggato(boolean loggato) {
	this.loggato = loggato;
}

public boolean isAccountesistente() {
	return accountesistente;
}

public void setAccountesistente(boolean accountesistente) {
	this.accountesistente = accountesistente;
}

public boolean isPswCambiata() {
	return isPswCambiata;
}

public void setPswCambiata(boolean isPswCambiata) {
	this.isPswCambiata = isPswCambiata;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}

public HashMap<String, String> getLikeMap() {
	return likeMap;
}

public void setLikeMap(HashMap<String, String> likeMap) {
	this.likeMap = likeMap;
}

public HashMap<String, String> getDislikeMap() {
	return dislikeMap;
}

public void setDislikeMap(HashMap<String, String> dislikeMap) {
	this.dislikeMap = dislikeMap;
}


@Override
public String toString() {
	return "Profilo [idProfilo=" + idProfilo + ", nickname=" + nickname + ", descrizione=" + descrizione
			+ ", numFollower=" + numFollower + ", numSeguiti=" + numSeguiti + ", numPost=" + numPost + ", tipo=" + tipo
			+ ", password=" + password + ", loggato=" + loggato + ", accountesistente=" + accountesistente
			+ ", isPswCambiata=" + isPswCambiata + ", likeMap=" + likeMap + ", dislikeMap=" + dislikeMap + "]";
}


@Override
//Ritorna true se l'account inserito e' "seguibile"
public boolean profiloNonSeguito(String emailProfilo) {
	Follow f = new Follow(this.getIdProfilo(),emailProfilo);
	if (dbfacade.profiloNonSeguito(f) == true) {
		return true;
	}
	return false;
}

@Override
//Ritorna true se l'account e' esistente
public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist {
	Profilo p = new Profilo(emailProfilo,null);
	if(dbfacade.accountEsistente(p) == false) {
		throw new AccountDoesNotExist(emailProfilo);
	}
	return true;
}

@Override
public boolean segui(String profiloSeguito) throws AccountDoesNotExist {
	
	if(this.profiloNonSeguito(profiloSeguito) == true && this.accountEsistente(profiloSeguito) == true) {
	Follow f = new Follow(this.idProfilo, profiloSeguito);
	dbfacade.carica(f);
	System.out.println("Hai cominciato a seguire con successo l'account : " + profiloSeguito);
	return true;	
	}
	return false;

}
@Override
public boolean smettiDiSeguire(String profiloSeguito) throws AccountDoesNotExist {
	if(this.accountEsistente(profiloSeguito) == true && this.profiloNonSeguito(profiloSeguito) == false) {
		Follow f = new Follow(this.getIdProfilo(),profiloSeguito);
		dbfacade.rimuovi(f);
		System.out.println("Hai smesso di seguire l'account : " + profiloSeguito);
		return true;
	}
	return false;
}


//Messaggi

@Override
public MessaggioDiGruppo creaMessaggioDiGruppo(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,
		String idGruppo) {
	   MessaggioDiGruppo m = new MessaggioDiGruppo(id, dataInvio, oraInvio, testo, multimedia, idGruppo);
	   return m;
}
@Override
public MessaggioPrivato creaMessaggioPrivato(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,
		String idProfiloInviante, String idProfiloRicevente) {
	 MessaggioPrivato m = new MessaggioPrivato(id,dataInvio,oraInvio,testo,multimedia,idProfiloInviante,idProfiloRicevente);
	 return m;
}
@Override
public boolean scriviMessaggio(Messaggio m) throws AccountDoesNotExist {
	
	    	return dbfacade.carica(m);	
	  
}

@Override
public boolean rimuoviMessaggio(Messaggio m) throws AccountDoesNotExist {
	
	return dbfacade.rimuovi(m);
}

@Override
public Messaggio cercaMessaggio(Messaggio m) throws AccountDoesNotExist{
		return dbfacade.cercaMessaggio(m);
	
}


@Override
public String ottieniTestoMessaggio(Messaggio m) throws AccountDoesNotExist {
		return dbfacade.ottieniTestoMessaggio(m.getIdMessaggio(), m.getTipo());
		
}



@Override
public boolean leggiMessaggi(String s, TipoMessaggio t) throws AccountDoesNotExist {
		
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				int i = 0;
			    public void run() {
			      
			    	ArrayList<Messaggio> mess = dbfacade.selezionaMessaggi(s, t);
			    	for(Messaggio lis : mess)
			    		System.out.println(lis.toString());
			    	
			    	i++;
		               if(i == 5) 
		        	      timer.cancel();
			    }
			 }, 0,  1000 * 60 * 5);	
			return true;

}


@Override
public boolean leggiSoloTesto(String s, TipoMessaggio t) throws AccountDoesNotExist {
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			int i = 0;
		    public void run() {
		      
		       ArrayList<String> res = dbfacade.ottieniTestoListaMessaggi(s, t);
		    	for(String msg : res)
		    		System.out.println(msg.toString());
		       
		    	i++;
	               if(i == 5) 
	        	      timer.cancel();
		    }
		 }, 0,  1000 * 60 * 5);	
		return true;
}



//------------------------------------------------------------------------------------------------------------------------------------


//Post
	public void creaPost(Foto f) {
		System.out.println(3);

		dbfacade.carica(f);
	}
	
	public void creaPost(Sondaggio s) {
		dbfacade.carica(s);
	}
	
	public void creaPost(Testo t) {
		dbfacade.carica(t);
	}
	


@Override
public Foto creaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, boolean isHd) {
	Foto f = new Foto(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo, percorso, isHd);
	return f;
}

@Override
public Video creaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, int durataInSecondi) {
	Video v = new Video(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo, percorso, durataInSecondi);
	return v;
}

@Override
public Testo creaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String font, String titolo) {
	Testo t = new Testo(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo,font,titolo);
	return t;
}

@Override
public SondaggioDoppiaVotazione creaSondaggioSD(String idPost, Date dataPubblicazione, Time oraPubblicazione,String descrizione, boolean visibile, boolean condivisibile, String profilo, String primaScelta,String secondaScelta, int[] conteggio) {
	SondaggioDoppiaVotazione s = new SondaggioDoppiaVotazione(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo, primaScelta, secondaScelta, conteggio);
	return s;
}

@Override
public SondaggioSceltaMultipla creaSondaggioDM(String idPost, Date dataPubblicazione, Time oraPubblicazione,String descrizione, boolean visibile, boolean condivisibile, String profilo, String primaScelta,String secondaScelta, String terzaScelta, String quartaScelta, int[] conteggio) {
	SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(idPost, dataPubblicazione, oraPubblicazione, descrizione, visibile, condivisibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta, conteggio);
	return s;
}

@Override
public boolean pubblicaPost(Post p) {
	return dbfacade.carica(p);
}

@Override
public boolean rimuoviPost(Post p) {
	return dbfacade.rimuovi(p);
}

@Override
public Post cercaPost(Post p) {
	return dbfacade.cercaPost(p);
}


@Override
public void selectAllPost(TipoPost t) {
	ArrayList<Post> p = dbfacade.selectAllPost(t);
	for(Post ps : p)
		System.out.println(ps.toString());
}

@Override
public boolean pubblicaStoria(int time, Multimedia f) throws AccountDoesNotExist{
	
	    f.setStory(true);
		f.setTempoCancellazione(time);
		dbfacade.carica(f);
		try {
		    Thread.sleep(time * 60 * 60 * 1000);
		} catch (InterruptedException ie) {
		    Thread.currentThread().interrupt();
		}	
		dbfacade.rimuovi(f);	
		return true;
}


//------------------------------------------------------------------------------------------------------------------

//Profilo

@Override
public boolean stampaInfoProfilo(Profilo p) throws AccountDoesNotExist {

	ArrayList<Profilo> res = new ArrayList<>();
	Profilo prf = dbfacade.cercaProfilo(p);
	res.add(prf);
	if(res.isEmpty() == false) {
		System.out.println(prf.toString());
		}
		throw new AccountDoesNotExist(p.getIdProfilo());
}

@Override
public Profilo cercaProfilo(Profilo p) throws AccountDoesNotExist {
	ArrayList<Profilo> res = new ArrayList<>();
	Profilo prf = dbfacade.cercaProfilo(p);
	res.add(prf);
	if(res.isEmpty() == false) {
		return prf;
		}
		throw new AccountDoesNotExist(p.getIdProfilo());
}


//--------------------------------------------------------------------------------------------------------------------
@Override
public boolean creaGruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1, String profilo2,
		String profilo3, String profilo4, String profilo5, String profilo6, String amministratore)
		throws AccountDoesNotExist {
	Gruppo g = new Gruppo(idGruppo,descrizione,nomeGruppo,profilo1,profilo2,profilo3,profilo4,profilo5,profilo6,amministratore);
		return dbfacade.carica(g);

}

@Override
public boolean rimuoviGruppo(String idGruppo) throws AccountDoesNotExist {
	Gruppo g = new Gruppo(idGruppo,null,null,null,null,null,null,null,null,null);
	
		return dbfacade.rimuovi(g);
}

@Override
public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6) throws AccountDoesNotExist {
	Gruppo g = new Gruppo(idGruppo,null,null,profilo1,profilo2,profilo3,profilo4,profilo5,profilo6,null);
	
		return dbfacade.gestisciPartecipanti(g);
	
}

@Override
public boolean aggiungiLike(Post p) throws AccountDoesNotExist{
	
	if(likeMap.containsValue(p.getIdPost()) == true && likeMap.containsKey(this.getIdProfilo()) == true)
		return false;
	else {
				
	    int i = p.getNumLike();
        i++;
        p.setNumLike(i);
        likeMap.put(this.getIdProfilo(), p.getIdPost());
	    return true;
	}
	
}

@Override
public boolean aggiungiDislike(Post p) throws AccountDoesNotExist{
	if(dislikeMap.containsValue(p.getIdPost()) == true && dislikeMap.containsKey(this.getIdProfilo()) == true)
		return false;
	else {
				
	    int i = p.getNumLike();
        i++;
        p.setNumLike(i);
        dislikeMap.put(this.getIdProfilo(), p.getIdPost());
	    return true;
	}
}


@Override
public boolean rimuoviLike(Post p)  throws AccountDoesNotExist{

	if(likeMap.containsValue(p.getIdPost()) == true && likeMap.containsKey(this.getIdProfilo()) == true) {
		int i = p.getNumLike();
		i--;
		p.setNumLike(i);
		likeMap.remove(this.getIdProfilo(), p.getIdPost());
		return true;
	}
	return false;

}

@Override
public boolean rimuoviDislike(Post p)  throws AccountDoesNotExist{
	
	if(dislikeMap.containsValue(p.getIdPost()) == true && dislikeMap.containsKey(this.getIdProfilo()) == true) {
		int i = p.getNumDislike();
		i--;
		p.setNumDislike(i);
		dislikeMap.remove(this.getIdProfilo(), p.getIdPost());
		return true;
	}
	return false;
	
}

@Override
public boolean pubblicaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String post) throws AccountDoesNotExist {
	Commento c = new Commento(idCommento,oraCommento,dataCommento,testo,post);
	
		return dbfacade.carica(c);

}



@Override
public boolean rimuoviCommento(String idCommento) throws AccountDoesNotExist {
	
	Commento c = new Commento(idCommento, null, null, null, null);
		 dbfacade.rimuovi(c);
		 return true;
		
}



@Override
public boolean cercaCommento(String id) throws AccountDoesNotExist {
		dbfacade.stampaCommentoCercato(id);
		return true;
}



@Override
public boolean cercaGruppo(String id) throws AccountDoesNotExist {

		dbfacade.stampaGruppoCercato(id);
		return true;
}


@Override
public boolean selectAllCommentiSottoPost(Commento c) throws AccountDoesNotExist {

		dbfacade.stampaCommentiSottoPost(c);
		return true;
}


@Override
public boolean selectAllGruppo() throws AccountDoesNotExist  {
		dbfacade.stampaSelectAllGruppo();
		return true;
}




@Override
public boolean vediMieiFollower(String id) throws AccountDoesNotExist {

		//dbfacade.stampaProfiloCercato(id);
		return true;
}

@Override
public boolean vediProfiloCercato(String profiloPersonale, String profiloSeguito) throws AccountDoesNotExist {
		dbfacade.stampaFollowCercati(profiloPersonale, profiloSeguito);
		return false;
}

@Override
public boolean invitaUtenteAdIscriversi(Profilo p) {

	Scanner scan = new Scanner(System.in);
	System.out.println("Digita il nome dell'utente da invitare");
	
	String nomeUtente = scan.nextLine();
	// non ho finito
	return false;
}





@Override
public boolean accettaRichiestaDinvito() {
	return false;
}



}


	




