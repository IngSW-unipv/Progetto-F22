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
import profilo.exception.ChangeDefaultPassword;
import profilo.exception.FollowYourself;
import profilo.exception.PostNonPresente;
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
	public boolean profiloNonSeguito(String emailProfilo) {
		Follow f = new Follow(this.getIdProfilo(),emailProfilo);
		if (dbfacade.profiloNonSeguito(f) == true) {
			return true;
		}
		return false;
	}

	@Override
	public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist {
		Profilo p = new Profilo(emailProfilo,null);
		if(dbfacade.accountEsistente(p) == false) {
			throw new AccountDoesNotExist(emailProfilo);
		}
		return true;
	}

	@Override
	public boolean segui(Profilo profiloSeguito) throws AccountDoesNotExist, AzioneNonConsentita/*, FollowYourself */{
	
		/*if(this.profiloNonSeguito(profiloSeguito.getIdProfilo()) == true && this.accountEsistente(profiloSeguito.getIdProfilo()) == true) {
		if(this.profiloNonSeguito(this.getIdProfilo())) {
			throw new FollowYourself(this.getIdProfilo());
		}*/
	Follow f = new Follow(this.idProfilo, profiloSeguito.getIdProfilo());
	dbfacade.carica(f);int seguiti = dbfacade.vediNumSeguiti(new Profilo(this.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null));
	int follower = dbfacade.vediNumFollower(new Profilo(profiloSeguito.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null));
	
	seguiti ++;
	follower ++;
	
	dbfacade.modificaNumSeguiti(new Profilo(this.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null), seguiti);
	dbfacade.modificaNumFollower(new Profilo(profiloSeguito.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null), follower);
	return true;	
	//}
	//throw new AzioneNonConsentita();
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
			    	i++;
		               if(i == 5) 
		        	      timer.cancel();
			    }
			 }, 0,  1000 * 60 * 5);	
		return true;
	}
	public ArrayList<String> cercaMessaggiChatPrivata(String inviante, String ricevente) {
		ArrayList<Messaggio> listaMessaggi = dbfacade.caricaMessaggiChatPrivata(inviante, ricevente);
		ArrayList<String> listaTestoEProfiloInviante = new ArrayList<String>();
		
		for(int i = 0; i < listaMessaggi.size(); i++) {
			listaTestoEProfiloInviante.add(listaMessaggi.get(i).getProfiloInviante());
			listaTestoEProfiloInviante.add(listaMessaggi.get(i).getTesto());
		}
		return listaTestoEProfiloInviante;
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

	public void creaPost(Foto f) {
		dbfacade.carica(f);
	}
	
	public void creaPost(Sondaggio s) {
		dbfacade.carica(s);
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
	public Post cercaPost(Post p) throws PostNonVisibile, PostNonPresente{
		if (dbfacade.cerca(p) == null) {
			throw new PostNonPresente(p.getIdPost());
		}
		return dbfacade.cerca(p);
	}

	public ArrayList<String> caricaPostProfiliSeguiti(String profilo, TipoPost tipo) {
		ArrayList<String> postDeiProfiliSeguiti = dbfacade.caricaPostProfiliSeguiti(profilo, tipo);
		return postDeiProfiliSeguiti;
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
	
		dbfacade.carica(f);
		dbfacade.modificaIsStory(f, true);
		dbfacade.modificaTempoCancellazione(f, time);
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
	public boolean aggiungiVotoSondaggio(String idSondaggio, int scelta) throws TastoNonEsistente, PostNonVisibile, PostNonPresente{
		SondaggioSceltaMultipla s = (SondaggioSceltaMultipla)cercaPost(new SondaggioSceltaMultipla(idSondaggio));
		if (s.getTipo() == TipoPost.SONDAGGIODOPPIAVOTAZIONE && dbfacade.presenteSondaggioMap(this.getIdProfilo(), s.getIdPost()) == false) {
			SondaggioDoppiaVotazione res = (SondaggioDoppiaVotazione) dbfacade.cerca(s);
			Scanner scanner = new Scanner(System.in);
			int a = scanner.nextInt(); 
			switch(scelta) {
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
		return false;
	}

	@Override
	public void vediRisultatiSondaggio(Sondaggio s) {
		if(s.getTipo() == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
		SondaggioDoppiaVotazione sdv = (SondaggioDoppiaVotazione) dbfacade.cerca(s);
		}
		else if(s.getTipo() == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
			SondaggioSceltaMultipla ssm = (SondaggioSceltaMultipla) dbfacade.cerca(s);
		}	
	}

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
	public boolean cambiaImmagineProfilo(String immagine) {
		return dbfacade.modificaImmagineProfilo(new Profilo(this.getIdProfilo()), immagine);
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



	public ArrayList<String> caricaTuttiiPostDiUnProfilo(String pr, TipoPost f) {
	
		ArrayList<String> res = dbfacade.ottieniIdPost(f, new Profilo(idProfilo));
		for(int i = 0; i < res.size(); i++) {
		res.get(i);
		}
		return res;
	/*
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
    */
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
	public boolean modificaDescrizione(String n) {
		return dbfacade.modificaDescrizione(new Profilo(this.getIdProfilo()), n);
	}

	@Override
	public Commento creaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String profilo, String idFoto,	String idVideo,String idSDV,String idSSM, String idTesto) {
 
		Commento c = new Commento(idCommento,oraCommento,dataCommento,testo,profilo,idFoto,idVideo,idSDV,idSSM,idTesto);
		return c;
	}

	@Override
	public boolean pubblicaCommento(String idProfilo, String idPost, String testoCommento) {
		Commento c;
		String idCommento = Integer.toString((int)Math.round(Math.random() * 1000));
	 		c = new Commento(idCommento, idProfilo, idPost, testoCommento);
	 		if(dbfacade.cerca(c) != null) {
	 			pubblicaCommento(idProfilo, idPost, testoCommento);
	 		}
		return dbfacade.carica(c);
	}


	@Override
	public boolean rimuoviCommento(String idCommento)  {
		return dbfacade.rimuovi(new Commento(idCommento));
	}

	@Override
	public Commento cercaCommento(String idCommento) {
		return dbfacade.cerca(new Commento(idCommento));
	}

	@Override
	public ArrayList<String> ProfiloNickCommento(Profilo p) {
		return dbfacade.ProfiloNickCommento(p);
	}

	public boolean creaGruppo(String descrizione, String nomeGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6, String amministratore, String fotoGruppo) throws AccountDoesNotExist{
		Gruppo g;
		String idGruppo  = Integer.toString((int)Math.round(Math.random() * 1000));
		
		g = new Gruppo(idGruppo);
		if(dbfacade.cerca(g) != null) {
			creaGruppo(descrizione, nomeGruppo, profilo1,profilo2,profilo3,profilo4,profilo5,profilo6, amministratore, fotoGruppo);
		}
		g = new Gruppo(idGruppo,descrizione,nomeGruppo,profilo1,profilo2,profilo3,profilo4,profilo5,profilo6,amministratore, fotoGruppo);
	
		return dbfacade.carica(g);
	}

	@Override
	public boolean rimuoviGruppo(Gruppo g)  {
		return dbfacade.rimuovi(g);
	}

	@Override
	public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6, String fotoGruppo)  {
		Gruppo g = new Gruppo(idGruppo,null,null,profilo1,profilo2,profilo3,profilo4,profilo5,profilo6,null,fotoGruppo);
		return dbfacade.gestisciPartecipanti(g);
	}

	@Override
	public Gruppo cercaGruppo(Gruppo g) {
		return dbfacade.cerca(g);
	}
	
	public ArrayList<String> caricaGruppiProfilo(String profilo) {
		return dbfacade.caricaGruppiProfilo(profilo);
	}



	@Override
	public ArrayList<Gruppo> selectAllGruppo(){
		ArrayList<Gruppo> res = dbfacade.selectAllGruppo();
		return res;
		}


	@Override
	public boolean modificaFotoGruppo(Gruppo g, String s) {
		return dbfacade.cambiaFotoGruppo(g, s);
	}

	@Override
	public String vediFotoGruppo(Gruppo g) {
		return dbfacade.vediFotoGruppo(g);
	}	

	@Override
	public boolean aggiungiLike(Post p)throws AzioneNonConsentita{	
		if(dbfacade.presenteLikeMap(this.getIdProfilo(), p.getIdPost()) == true) {
	    throw new AzioneNonConsentita();
		}else {
				
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
		}else {		
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

	@Override
	public boolean creaGruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1, String profilo2,
		String profilo3, String profilo4, String profilo5, String profilo6, String amministratore, String fotoGruppo)
		throws AccountDoesNotExist {
		return false;
	}

	public void scriviMessaggioGruppo(String testo, String idGruppo) {
		MessaggioDiGruppo m;
		int idMessaggioInt = (int)Math.round(Math.random() * 1000);
		String idMessaggio = "M" + Integer.toString(idMessaggioInt);
		m = new MessaggioDiGruppo(idMessaggio,testo, this.getIdProfilo(), idGruppo);
		
		if(dbfacade.cerca(new MessaggioDiGruppo(idMessaggio)) != null) {
			scriviMessaggioGruppo(testo, idGruppo);
		}
		dbfacade.carica(m);
	}
	
	public ArrayList<String> caricaMessaggiChatGruppoConProfiloInviante(String idGruppo) {
		return dbfacade.caricaMessaggiChatGruppoConProfiloInviante(idGruppo);
	}

	@Override
	public boolean aggiungiVotoSondaggio(Sondaggio s) throws TastoNonEsistente {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean cambiaDefaultPassword (String nuovaPsw) throws ChangeDefaultPassword, AccountDoesNotExist {
		Profilo p = new Profilo(this.getIdProfilo(), null);
	 	String s = dbfacade.vediPsw(this.getIdProfilo());

	 	if(dbfacade.cerca(p) != null && dbfacade.vediEsiste(this.getIdProfilo()) == true) {
	 		if(s.equals("Cambiami") && nuovaPsw != "Cambiami") {
	 			dbfacade.modificaPsw(this.getIdProfilo(), nuovaPsw);
	 			dbfacade.modificaPswCambiata(this.getIdProfilo(), true);
	 			return true;
	 		}
	 		throw new ChangeDefaultPassword("Cambiami");
	 	}else
	 		throw new AccountDoesNotExist(this.getIdProfilo());
		}

	public boolean cambiaPassword(String vecchiaPassword, String nuovaPassword) throws ChangeDefaultPassword, AccountDoesNotExist {
		
		Profilo p = new Profilo(this.getIdProfilo());
		String s = dbfacade.vediPsw(this.getIdProfilo());

		if(dbfacade.cerca(p) != null && dbfacade.vediEsiste(this.getIdProfilo()) == true) {

		    if(dbfacade.vediPswCambiata(this.getIdProfilo()) == false)
			   throw new ChangeDefaultPassword("Cambiami");

		    else if(s.equals(vecchiaPassword)) {
		    	dbfacade.modificaPsw(this.getIdProfilo(), nuovaPassword);
		    		return true;
		    }
		}
		else
		    throw new AccountDoesNotExist(this.getIdProfilo());
		return false;	
	}
	
	public boolean rimuoviQuestoProfilo() {
	 	return dbfacade.rimuovi(new Profilo(this.getIdProfilo()));
	 }		
	
	 public void pubblicaFoto(String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, boolean isHd) {
		 Foto p;
		 String idPost = "F" + Integer.toString(((int)Math.round(Math.random() * 1000)));
		 p = new Foto(idPost, descrizione, visibile, profilo, percorso, isHd);
		 		
		 if(dbfacade.cerca(new Foto(idPost)) != null) {
		 pubblicaFoto(descrizione, visibile, condivisibile, profilo, percorso, isHd);
		 }
		dbfacade.carica(p);
	}
	 
	public void pubblicaSondaggioDoppiaVotazione(String descrizione, boolean visibile, String profilo, String primaScelta, String secondaScelta) {
			
		SondaggioDoppiaVotazione s;
		String idPost = "S" + Integer.toString((int)Math.round(Math.random() * 1000));
		 		
		 s = new SondaggioDoppiaVotazione(idPost, descrizione, visibile, profilo, primaScelta, secondaScelta);
		 		
		 if(dbfacade.cerca(new SondaggioDoppiaVotazione(idPost)) != null) {
		 	pubblicaSondaggioDoppiaVotazione(descrizione, visibile, profilo, primaScelta, secondaScelta);
		 	}
		 	dbfacade.carica(s);
		}
	
	public void pubblicaSondaggioSceltaMultipla(String descrizione, boolean visibile, String profilo,
		String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta) {
				
		SondaggioSceltaMultipla s;
		String idPost = "S" + Integer.toString((int)Math.round(Math.random() * 1000));
		 		
		 s = new SondaggioSceltaMultipla(idPost, descrizione, visibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta);
		 		
		 if(dbfacade.cerca(new SondaggioSceltaMultipla(idPost, null, false, null, null, null, null, null)) != null) {
		 	pubblicaSondaggioSceltaMultipla(descrizione, visibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta);
		 }
		dbfacade.carica(s);
	}
	public void pubblicaTesto(String descrizione, boolean visibile, String profilo, String font, String titolo) {
		
		String idPost = "T" + Integer.toString((int)Math.round(Math.random() * 1000));
	 		
	 	Testo t = new Testo(idPost, descrizione, visibile, profilo, font, titolo);
	 		
	 	if(dbfacade.cerca(new Testo(idPost)) != null) {
	 		pubblicaTesto(descrizione, visibile, profilo, font, titolo);
	 	}
	 	dbfacade.carica(t);
	}
	
	
}

	




