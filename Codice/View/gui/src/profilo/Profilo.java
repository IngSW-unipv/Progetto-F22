package profilo;


import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import Messaggio.enumeration.TipoMessaggio;
import chat.chatDiGruppo.gruppo.Gruppo;
import db.facade.DbFacade;
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
	private String fotoProfilo;
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
		this.fotoProfilo = null;
		this.password = "Cambiami";
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
		this.fotoProfilo = null;
		this.numPost = 0;
		this.password = "Cambiami";
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
		this.fotoProfilo = null;
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



//Follow

@Override
public boolean segui(Profilo profiloSeguito) throws AccountDoesNotExist {
	
	if(this.profiloNonSeguito(profiloSeguito.getIdProfilo()) == true && this.accountEsistente(profiloSeguito.getIdProfilo()) == true) {
	Follow f = new Follow(this.idProfilo, profiloSeguito.getIdProfilo());
	dbfacade.carica(f);
	System.out.println("Hai cominciato a seguire con successo l'account : " + profiloSeguito);
	return true;	
	}
	return false;

}
@Override
public boolean smettiDiSeguire(Profilo profiloSeguito) throws AccountDoesNotExist {
	if(this.accountEsistente(profiloSeguito.getIdProfilo()) == true && this.profiloNonSeguito(profiloSeguito.getIdProfilo()) == false) {
		Follow f = new Follow(this.getIdProfilo(),profiloSeguito.getIdProfilo());
		dbfacade.rimuovi(f);
		System.out.println("Hai smesso di seguire l'account : " + profiloSeguito);
		return true;
	}
	return false;
}


@Override
public ArrayList<String> vediMieiFollower(Follow f) {

		ArrayList<String> res = dbfacade.cercaProfSeguito(f.getMailProfiloSeguito());
		return res;
		
}

@Override
public Follow cercaFollow(Follow f) {
	return dbfacade.cerca(f);
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
public boolean scriviMessaggio(Messaggio m){
	
	    	return dbfacade.carica(m);	
	  
}

@Override
public boolean rimuoviMessaggio(Messaggio m){
	
	return dbfacade.rimuovi(m);
}

@Override
public Messaggio cercaMessaggio(Messaggio m){
		return dbfacade.cerca(m);
	
}


@Override
public String ottieniTestoMessaggio(Messaggio m) {
		return dbfacade.ottieniTestoMessaggio(m.getIdMessaggio(), m.getTipo());
		
}



@Override
public boolean leggiMessaggi(String s, TipoMessaggio t) {
		
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
public boolean leggiSoloTesto(String s, TipoMessaggio t){
		
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
	Foto f = new Foto(idPost, descrizione, visibile, condivisibile, profilo, percorso, isHd);
	return f;
}

@Override
public Video creaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, int durataInSecondi) {
	Video v = new Video(idPost,  descrizione, visibile, condivisibile, profilo, percorso, durataInSecondi);
	return v;
}

@Override
public Testo creaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String font, String titolo) {
	Testo t = new Testo(idPost,  descrizione, visibile, condivisibile, profilo,font,titolo);
	return t;
}

@Override
public SondaggioDoppiaVotazione creaSondaggioSD(String idPost, Date dataPubblicazione, Time oraPubblicazione,String descrizione, boolean visibile, boolean condivisibile, String profilo, String primaScelta,String secondaScelta, int[] conteggio) {
	SondaggioDoppiaVotazione s = new SondaggioDoppiaVotazione(idPost,  descrizione, visibile, condivisibile, profilo, primaScelta, secondaScelta, conteggio);
	return s;
}

@Override
public SondaggioSceltaMultipla creaSondaggioDM(String idPost, Date dataPubblicazione, Time oraPubblicazione,String descrizione, boolean visibile, boolean condivisibile, String profilo, String primaScelta,String secondaScelta, String terzaScelta, String quartaScelta, int[] conteggio) {
	SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(idPost, descrizione, visibile, condivisibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta, conteggio);
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
	return dbfacade.cerca(p);
}


@Override
public ArrayList<Post> selectAllPost(TipoPost t) {
	ArrayList<Post> p = dbfacade.selectAllPost(t);
	return p;
}

@Override
public boolean pubblicaStoria(int time, Multimedia f){
	
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


@Override
public String ottieniPercorso(Post p) {
	return dbfacade.ottieniPercorso(p);
}




//------------------------------------------------------------------------------------------------------------------

//Profilo


@Override
public Profilo cercaProfilo(Profilo p) throws AccountDoesNotExist {
	ArrayList<Profilo> res = new ArrayList<>();
	Profilo prf = dbfacade.cerca(p);
	res.add(prf);
	if(res.isEmpty() == false) {
		return prf;
		}
		throw new AccountDoesNotExist(p.getIdProfilo());
}

@Override
public boolean cambiaImmagineProfilo(Profilo p, String immagine) {
	System.out.println("siamo in profilo e la path è "+ immagine);
	return dbfacade.modificaImmagineProfilo(p, immagine);
}

@Override
public String ottieniImmagineProfilo(Profilo p) {
	return dbfacade.ottieniImmagineProfilo(p);
}

@Override
public ArrayList<String> ritornaIdPost(Post p, Profilo pr) {
	return dbfacade.ottieniIdPost(p, pr);
}


//--------------------------------------------------------------------------------------------------------------------

//Commento

@Override
public Commento creaCommento(String idCommento, String post,String profilo,String testo) {
	
	   Commento c = new Commento(idCommento,testo,post,profilo);
	
		return c;

}

@Override
public boolean pubblicaCommento(Commento c) {
		System.out.println(c.getPost() + "siamo in Profilo");
		return dbfacade.carica(c);

}


@Override
public boolean rimuoviCommento(Commento c)  {

		return dbfacade.rimuovi(c);
}



@Override
public Commento cercaCommento(Commento c) {

		return dbfacade.cerca(c);
}

@Override
public ArrayList<Commento> selectAllCommentiSottoPost(Commento c) {
	
	ArrayList<Commento> res = dbfacade.selectAllCommenti(c);
	return res;
}

//Gruppo


@Override
public boolean creaGruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1, String profilo2,
		String profilo3, String profilo4, String profilo5, String profilo6, String amministratore)
		throws AccountDoesNotExist {
	Gruppo g = new Gruppo(idGruppo,descrizione,nomeGruppo,profilo1,profilo2,profilo3,profilo4,profilo5,profilo6,amministratore);
		return dbfacade.carica(g);

}

@Override
public boolean rimuoviGruppo(Gruppo g)  {
		return dbfacade.rimuovi(g);
}

@Override
public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6)  {
	Gruppo g = new Gruppo(idGruppo,null,null,profilo1,profilo2,profilo3,profilo4,profilo5,profilo6,null);
	
		return dbfacade.gestisciPartecipanti(g);
	
}

@Override
public Gruppo cercaGruppo(Gruppo g) {

		return dbfacade.cerca(g);

}



@Override
public ArrayList<Gruppo> selectAllGruppo(){
	ArrayList<Gruppo> res = dbfacade.selectAllGruppo();
		return res;
		
}
//-------------------------------------------------------------------------------------------------------------------


public ArrayList<String> caricaTuttiiPostDiUnProfilo(Profilo p, Foto f) {
	return dbfacade.ottieniIdPost(f, p);
}
@Override
public boolean aggiungiLike(Post p){
	
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
public boolean aggiungiDislike(Post p){
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
public boolean rimuoviLike(Post p){

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
public boolean rimuoviDislike(Post p){
	
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
public Commento creaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String post,
		String profilo) {
	// TODO Auto-generated method stub
	return null;
}

public String getFotoProfilo() {
	return fotoProfilo;
}

public void setFotoProfilo(String fotoProfilo) {
	this.fotoProfilo = fotoProfilo;
}


}


	




