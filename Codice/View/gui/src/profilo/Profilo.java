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
import chat.chatDiGruppo.gruppo.Gruppo;
import convertitore.ConvertitoreFacade;
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
import profilo.exception.AzioneNonConsentita;
import profilo.exception.FotoProfiloNonAncoraImpostata;
import profilo.exception.PostNonVisibile;
import profilo.exception.TastoNonEsistente;
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
	private String password;
	private String fotoProfilo;
	private boolean loggato;
	private boolean accountesistente;
	private boolean isPswCambiata;
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
		this.password = "Cambiami";
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
		this.password = "Cambiami";
	}
	

	//costruttore per la conversione profiloDB
	public Profilo(String idProfilo, String nickname, String descrizione,int numFollower,int numSeguiti, int numPost, 
			boolean esiste, boolean pswCambiata, boolean loggato,String psw,String fotoProfilo) {
		this.dbfacade = dbfacade.getIstance();
		this.idProfilo = idProfilo;
		this.nickname = nickname;
		this.descrizione = descrizione;
		this.numFollower = numFollower;
		this.numSeguiti = numSeguiti;
		this.numPost = numPost;
		this.accountesistente = esiste;
		this.isPswCambiata = pswCambiata;
		this.loggato = loggato;
		this.password = psw;
		this.fotoProfilo = fotoProfilo;
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


public String getFotoProfilo() {
	return fotoProfilo;
}

public void setFotoProfilo(String fotoProfilo) {
	this.fotoProfilo = fotoProfilo;
}


@Override
public String toString() {
	return "Profilo [idProfilo=" + idProfilo + ", nickname=" + nickname + ", descrizione=" + descrizione
			+ ", numFollower=" + numFollower + ", numSeguiti=" + numSeguiti + ", numPost=" + numPost + ", password=" + password + ", fotoProfilo=" + fotoProfilo + ", loggato=" + loggato + ", accountesistente="
			+ accountesistente + ", isPswCambiata=" + isPswCambiata + "]";
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
public boolean segui(Profilo profiloSeguito) throws AccountDoesNotExist, AzioneNonConsentita {
	
	if(this.profiloNonSeguito(profiloSeguito.getIdProfilo()) == true && this.accountEsistente(profiloSeguito.getIdProfilo()) == true) {
	Follow f = new Follow(this.idProfilo, profiloSeguito.getIdProfilo());
	dbfacade.carica(f);int seguiti = dbfacade.vediNumSeguiti(new Profilo(this.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null));
	int follower = dbfacade.vediNumFollower(new Profilo(profiloSeguito.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null));
	seguiti ++;
	follower ++;
	dbfacade.modificaNumSeguiti(new Profilo(this.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null), seguiti);
	dbfacade.modificaNumFollower(new Profilo(profiloSeguito.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null), follower);
	System.out.println("Hai cominciato a seguire con successo l'account : " + profiloSeguito);
	return true;	
	}
	throw new AzioneNonConsentita();

}
@Override
public boolean smettiDiSeguire(Profilo profiloSeguito) throws AccountDoesNotExist, AzioneNonConsentita {
	if(this.accountEsistente(profiloSeguito.getIdProfilo()) == true && this.profiloNonSeguito(profiloSeguito.getIdProfilo()) == false) {
		Follow f = new Follow(this.getIdProfilo(),profiloSeguito.getIdProfilo());
		dbfacade.rimuovi(f);
		int seguiti = dbfacade.vediNumSeguiti(new Profilo(this.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null));
		int follower = dbfacade.vediNumFollower(new Profilo(profiloSeguito.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null));
		seguiti --;
		follower --;
		dbfacade.modificaNumSeguiti(new Profilo(this.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null), seguiti);
		dbfacade.modificaNumFollower(new Profilo(profiloSeguito.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null), follower);
		System.out.println("Hai smesso di seguire l'account : " + profiloSeguito.getIdProfilo());
		System.out.println("Hai smesso di seguire l'account : " + profiloSeguito);
		return true;
	}
	throw new AzioneNonConsentita();
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
public MessaggioDiGruppo creaMessaggioDiGruppo(String id, Date dataInvio, Time oraInvio, String testo, String multimedia, String profiloInviante,
		String idGruppo) {
	   MessaggioDiGruppo m = new MessaggioDiGruppo(id, dataInvio, oraInvio, testo, multimedia, profiloInviante,idGruppo);
	   return m;
}
@Override
public MessaggioPrivato creaMessaggioPrivato(String id, String testo, String multimedia,
		String idProfiloInviante, String idProfiloRicevente) {
	 MessaggioPrivato m = new MessaggioPrivato(id,testo,multimedia,idProfiloInviante,idProfiloRicevente);
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
public boolean leggiMessaggi(String profiloInviante,String profiloRicevente, TipoMessaggio t) {
		
			Timer timer = new Timer();
			timer.schedule(new TimerTask() {
				int i = 0;
			    public void run() {
			      
			    	ArrayList<Messaggio> mess = dbfacade.selezionaMessaggi(profiloInviante,profiloRicevente, t);
			    	for(Messaggio lis : mess)
			    		System.out.println(lis.toString());
			    	
			    	i++;
		               if(i == 5) 
		        	      timer.cancel();
			    }
			 }, 0,  1000 * 60 * 5);	
			return true;

}
public ArrayList<Messaggio> cercaMessaggiChatPrivata(String inviante, String ricevente) {
	 ArrayList<Messaggio> messaggi = dbfacade.caricaMessaggiChatPrivata(inviante, ricevente);
	 return messaggi;
}


@Override
public boolean leggiSoloTesto(String profiloInviante,String profiloRicevente, TipoMessaggio t){
		
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			int i = 0;
		    public void run() {
		      
		       ArrayList<String> res = dbfacade.ottieniTestoListaMessaggi(profiloInviante,profiloRicevente, t);
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
public Foto creaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String percorso, boolean isHd) {
	Foto f = new Foto(idPost, descrizione, visibile, profilo, percorso, isHd);
	return f;
}

@Override
public Video creaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String percorso, int durataInSecondi) {
	Video v = new Video(idPost,  descrizione, visibile, profilo, percorso, durataInSecondi);
	return v;
}

@Override
public Testo creaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String font, String titolo) {
	Testo t = new Testo(idPost,  descrizione, visibile, profilo,font,titolo);
	return t;
}

@Override
public SondaggioDoppiaVotazione creaSondaggioSD(String idPost, Date dataPubblicazione, Time oraPubblicazione,String descrizione, boolean visibile, String profilo, String primaScelta,String secondaScelta) {
	SondaggioDoppiaVotazione s = new SondaggioDoppiaVotazione(idPost,  descrizione, visibile, profilo, primaScelta, secondaScelta);
	return s;
}

@Override
public SondaggioSceltaMultipla creaSondaggioDM(String idPost, Date dataPubblicazione, Time oraPubblicazione,String descrizione, boolean visibile, String profilo, String primaScelta,String secondaScelta, String terzaScelta, String quartaScelta) {
	SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(idPost, descrizione, visibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta);
	return s;
}

@Override
public boolean pubblicaPost(Post p) {
	boolean b = dbfacade.carica(p);
	String s = dbfacade.cerca(p).getProfilo();
	if(s != null) {
	int n = dbfacade.vediNumPost(new Profilo(s,null,null, 0, 0, 0, false, false, false, null, null));
	n++;
	dbfacade.modificaNumPost(new Profilo(s,null,null, 0, 0, 0, false, false, false, null, null), n);
	return b;}
	return false;
}

@Override
public boolean rimuoviPost(Post p) {
	String s = dbfacade.cerca(p).getProfilo();
	if(s!= null) {
	int n = dbfacade.vediNumPost(new Profilo(s,null,null, 0, 0, 0, false, false, false, null, null));
	n--;
	dbfacade.modificaNumPost(new Profilo(s,null,null, 0, 0, 0, false, false, false, null, null), n);
	return dbfacade.rimuovi(p);}
	return false;
}

@Override
public Post cercaPost(Post p) throws PostNonVisibile, FotoProfiloNonAncoraImpostata{
		if (dbfacade.cerca(p) == null) {
			throw new FotoProfiloNonAncoraImpostata();
		}
	return dbfacade.cerca(p);
}

@Override
public ArrayList<Post> selectAllPost(TipoPost t) {
	ArrayList<Post> p = dbfacade.selectAllPost(t);
	ArrayList<Post> p1 = new ArrayList<>();
	for(Post res : p) {
		if(res.isVisibile() == true)
			p1.add(res);
	}
		
	return p1;
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
public String ottieniPercorso(Post p) throws PostNonVisibile{
if(dbfacade.vediVisibilita(p) == true)
	return dbfacade.ottieniPercorso(p);
	
	throw new PostNonVisibile(p.getIdPost());
}

@Override
public ArrayList<Commento> selectAllCommentiSottoPost(Post p) {
		return dbfacade.mostraCommentiPost(p);
}

@Override
public ArrayList<String> testoCommentiPost(Post p) throws PostNonVisibile{
	if(dbfacade.vediVisibilita(p) == true)
		return dbfacade.mostraTestoCommentiPost(p);
	throw new PostNonVisibile(p.getIdPost());
}

@Override
public boolean vediVisibilita(Post p) {
	return dbfacade.vediVisibilita(p);
}

@Override
public boolean modificaVisibilita(Post p, boolean b) {
	return dbfacade.modificaVisibilita(p, b);
}

@Override
public boolean aggiungiVotoSondaggio(Sondaggio s) throws TastoNonEsistente{
	if (s.getTipo() == TipoPost.SONDAGGIODOPPIAVOTAZIONE && dbfacade.presenteSondaggioMap(this.getIdProfilo(), s.getIdPost()) == false) {
		SondaggioDoppiaVotazione res = (SondaggioDoppiaVotazione) dbfacade.cerca(s);
		System.out.println("Inserisci il numero corrispondente alla tua scelta : \n" + "1 = " + res.getPrimaScelta() + "\n" + "2 = " + res.getSecondaScelta());
	    Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); 
        switch(a) {
        case 1 : int i1 = dbfacade.vediCount1SDV(s);
                 i1 = i1 + 1;
                 dbfacade.modificaCount1SDV(s, i1);
        	     break;
        case 2 : 
        	int i2 = dbfacade.vediCount2SDV(s);
            i2 = i2 + 1;
            dbfacade.modificaCount2SDV(s, i2);
                 break;
        default:
        	scanner.close();
        	throw new TastoNonEsistente();
        }
        dbfacade.caricaSondaggioMap(this.getIdProfilo(), s.getIdPost());
        scanner.close();
        return true;
	}
	else if (s.getTipo() == TipoPost.SONDAGGIOSCELTAMULTIPLA && dbfacade.presenteSondaggioMap1(this.getIdProfilo(), s.getIdPost()) == false) {
		SondaggioSceltaMultipla res = (SondaggioSceltaMultipla) dbfacade.cerca(s);
		System.out.println("Inserisci il numero corrispondente alla tua scelta : \n" + "1 = " + res.getPrimaScelta() + "\n" + "2 = " + res.getSecondaScelta() + "\n" + "3 = " + res.getTerzaScelta() + "\n" + "4 = " + res.getQuartaScelta());
	    Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(); 
        switch(a) {
        case 1 : int i1 = dbfacade.vediCount1SSM(s);
                 i1 = i1 + 1;
                 dbfacade.modificaCount1SSM(s, i1);
        	     break;
        case 2 : 
        	int i2 = dbfacade.vediCount2SSM(s);
            i2 = i2 + 1;
            dbfacade.modificaCount2SSM(s, i2);
                 break;
        case 3:
        	int i3 = dbfacade.vediCount3SSM(s);
            i3 = i3 + 1;
            dbfacade.modificaCount3SSM(s, i3);
             break;
        case 4:
        	int i4 = dbfacade.vediCount4SSM(s);
            i4 = i4 + 1;
            dbfacade.modificaCount4SSM(s, i4);
             break;
        default:
        	scanner.close();
        	throw new TastoNonEsistente();
        }
        dbfacade.caricaSondaggioMap1(this.getIdProfilo(), s.getIdPost());
        scanner.close();
        return true;
	}
	System.out.println("Hai gia' votato a questo sondaggio");
	return false;
}

@Override
public void vediRisultatiSondaggio(Sondaggio s) {
	if(s.getTipo() == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
		SondaggioDoppiaVotazione sdv = (SondaggioDoppiaVotazione) dbfacade.cerca(s);
		System.out.println("L'opzione " + sdv.getPrimaScelta() + " ha totalizzato " + dbfacade.vediCount1SDV(s) + " voti\n"
				+ "L'opzione " + sdv.getSecondaScelta() + " ha totalizzato " + dbfacade.vediCount2SDV(s) + " voti\n");
	}
	else if(s.getTipo() == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
		SondaggioSceltaMultipla ssm = (SondaggioSceltaMultipla) dbfacade.cerca(s);
		System.out.println("L'opzione " + ssm.getPrimaScelta() + " ha totalizzato " + dbfacade.vediCount1SSM(s) + " voti\n"
				+ "L'opzione " + ssm.getSecondaScelta() + " ha totalizzato " + dbfacade.vediCount2SDV(s) + " voti\n"
				+ "L'opzione " + ssm.getTerzaScelta() + " ha totalizzato " + dbfacade.vediCount3SSM(s) + " voti\n"
				+ "L'opzione " + ssm.getQuartaScelta() + " ha totalizzato " + dbfacade.vediCount4SSM(s) + " voti\n");
	}
	
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
	return dbfacade.modificaImmagineProfilo(p, immagine);
}

@Override
public String ottieniImmagineProfilo(Profilo p) {
	return dbfacade.ottieniImmagineProfilo(p);
}


@Override
public ArrayList<Messaggio> selezionaMessaggiProfilo(Profilo p, TipoMessaggio t) {
	return dbfacade.selezionaMessaggiProfilo(p, t);
}

@Override
public ArrayList<String> selezionaTestoMessaggiProfilo(Profilo p, TipoMessaggio t) {
	return dbfacade.selezionaTestoMessaggiProfilo(p, t);
}



public ArrayList<String> caricaTuttiiPostDiUnProfilo(Profilo p, TipoPost f) {
	ArrayList<String> res = dbfacade.ottieniIdPost(f, p);
	ArrayList<String> resId = new ArrayList<>();
	ArrayList<Post> pst = new ArrayList<>();
	ArrayList<Post> search = new ArrayList<>();
	ArrayList<String> risultato = new ArrayList<>();

	//Ottengo una lista con solo idPost
	for(int i=0; i<res.size(); i=i+2) {
		resId.add(res.get(i));
	}	

	//Costruisco una lista di tipo Post con gli idPost
	for(String string:resId)
		pst.add(ConvertitoreFacade.getIstance().restituisciTipo(string, f));

	//La lista search conterra' tutte le informazioni dei post specificati con gli id in precedenza
	for(Post post : pst)
		search.add(dbfacade.cerca(post));

	//La lista finale conterra' il percorso e l'id dei soli post visibili
	for(Post posttt: search) {
		if(dbfacade.vediVisibilita(posttt) == true) {
			risultato.add(posttt.getIdPost());
		    risultato.add(posttt.getPercorso());
		}
	}
		return risultato;
    
}

@Override
public String vediNickname(Profilo p) {
	return dbfacade.vediNickname(p);
}

@Override
public boolean modificaNickname(Profilo p, String n) {
	return dbfacade.modificaNickname(p, n);
}

@Override
public String vediDescrizione(Profilo p) {
	return dbfacade.vediDescrizione(p);
}

@Override
public boolean modificaDescrizione(Profilo p, String n) {
	return dbfacade.modificaDescrizione(p, n);
}

//--------------------------------------------------------------------------------------------------------------------

//Commento

@Override
public Commento creaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String profilo, String idFoto,	String idVideo,String idSDV,String idSSM, String idTesto) {
 
	Commento c = new Commento(idCommento,oraCommento,dataCommento,testo,profilo,idFoto,idVideo,idSDV,idSSM,idTesto);
	return c;

}

@Override
public boolean pubblicaCommento(Commento c) {
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
public ArrayList<String> ProfiloNickCommento(Profilo p) {
	return dbfacade.ProfiloNickCommento(p);
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

// Like / Dislike
@Override
public boolean aggiungiLike(Post p)throws AzioneNonConsentita{
	
	if(dbfacade.presenteLikeMap(this.getIdProfilo(), p.getIdPost()) == true) {
	    throw new AzioneNonConsentita();
	}
	else {
				
	    int i = dbfacade.vediNumLike(p);
        i++;
        dbfacade.modificaNumLike(p, i);
        dbfacade.caricaLikeMap(this.getIdProfilo(), p.getIdPost());
	    return true;
	}
	
}


@Override
public boolean aggiungiDislike(Post p)throws AzioneNonConsentita{
	if(dbfacade.presenteDislikeMap(this.getIdProfilo(), p.getIdPost()) == true) {
	    throw new AzioneNonConsentita();
	}
	else {
			
		 int i = dbfacade.vediNumDislike(p);
	        i++;
	        dbfacade.modificaNumDislike(p, i);
	        dbfacade.caricaDislikeMap(this.getIdProfilo(), p.getIdPost());
		    return true;
	}
}

@Override
public boolean rimuoviLike(Post p)throws AzioneNonConsentita{

	if(dbfacade.presenteLikeMap(this.getIdProfilo(), p.getIdPost()) == true) {
		
		int i = dbfacade.vediNumLike(p);
        i--;
        dbfacade.modificaNumLike(p, i);
        dbfacade.rimuoviLike(this.getIdProfilo(), p.getIdPost());
	    return true;
	}
	throw new AzioneNonConsentita();

}

@Override
public boolean rimuoviDislike(Post p)throws AzioneNonConsentita{
	
	if(dbfacade.presenteDislikeMap(this.getIdProfilo(), p.getIdPost()) == true) {
		
		int i = dbfacade.vediNumDislike(p);
        i--;
        dbfacade.modificaNumDislike(p, i);
        dbfacade.rimuoviDislike(this.getIdProfilo(), p.getIdPost());
	    return true;
	}
	throw new AzioneNonConsentita();
	
}


}


	




