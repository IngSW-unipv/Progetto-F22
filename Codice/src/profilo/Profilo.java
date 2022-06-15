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
import convertitore.postUtility.PostUtility;
import db.facade.DbFacade;
import db.facade.Utility;
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
import profilo.exception.GruppoGiaPieno;
import profilo.exception.PostNonPresente;
import profilo.exception.PostNonVisibile;
import profilo.exception.ProfiloGiaInserito;
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


	/**
	 * Controlla se un profilo sta seguendo già un altro profilo
	 * @param id del profilo da controllare
	 * @return true se il mio profilo non sta seguendo il profilo indicato, false altrimenti
	 */
	@Override
	public boolean profiloNonSeguito(String emailProfilo) {
		Follow f = new Follow(this.getIdProfilo(),emailProfilo);
		if (dbfacade.profiloNonSeguito(f) == true) {
			return true;
		}
		return false;
	}

	/**
	 * Controlla se un profilo esiste già
	 * @param id del profilo da controllare
	 * @return true se il profilo esiste
	 * @exception Eccezione se il profilo non esiste
	 */
	@Override
	public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist {
		Profilo p = new Profilo(emailProfilo,null);
		if(dbfacade.accountEsistente(p) == false) {
			throw new AccountDoesNotExist(emailProfilo);
		}
		return true;
	}

	/**
	 * Permette di cominciare a seguire una persona
	 * @param id del profilo che si vuole seguire 
	 * @return true se l'operazione avviene con successo
	 * @exception Eccezione se il profilo non è seguibile
	 */
	@Override
	public boolean segui(Profilo profiloSeguito) throws AccountDoesNotExist, AzioneNonConsentita{

    if(this.profiloNonSeguito(profiloSeguito.getIdProfilo()) == true && this.accountEsistente(profiloSeguito.getIdProfilo()) == true && (profiloSeguito.getIdProfilo().equals(this.getIdProfilo()) == false)) {
    
    Follow f = new Follow(this.idProfilo, profiloSeguito.getIdProfilo());
	dbfacade.carica(f);
	int seguiti = dbfacade.vediNumSeguiti(new Profilo(this.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null));
	int follower = dbfacade.vediNumFollower(new Profilo(profiloSeguito.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null));
	
	seguiti ++;
	follower ++;
	
	dbfacade.modificaNumSeguiti(new Profilo(this.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null), seguiti);
	dbfacade.modificaNumFollower(new Profilo(profiloSeguito.getIdProfilo(),null,null, 0, 0, 0, false, false, false, null, null), follower);
	return true;	
	}
      throw new AzioneNonConsentita();


	}


	/**
	 * Permette di smettere di seguire una persona
	 * @param id del profilo che si vuole smettere di seguire 
	 * @return true se l'operazione avviene con successo
	 * @exception Eccezione se il profilo non è possibile smettere di seguire un profilo
	 */
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


	/**
	 * Ottengo la lista di tutti i miei follower
	 */
	@Override
	public ArrayList<String> vediMieiFollower(Follow f) {
		ArrayList<String> res = dbfacade.cercaProfSeguito(f.getMailProfiloSeguito());
		return res;	
	}

	/**
	 * Controllo se il follower inserito come parametro è presente nel db
	 */
	@Override
	public Follow cercaFollow(Follow f) {
	return dbfacade.cerca(f);
	}
	
	/**
	 * Carica il messaggio passato come parametro nel database
	 */
	@Override
	public boolean scriviMessaggio(Messaggio m){
		System.out.println(m.toString());
	    return dbfacade.carica(m);	
	}

	/**
	 * Rimuove il messaggio passato come parametro dal database
	 */
	@Override
	public boolean rimuoviMessaggio(Messaggio m){
	return dbfacade.rimuovi(m);
	}
	
	/**
	 * Controllo se il messaggio inserito come parametro è presente nel db
	 */
	@Override
	public Messaggio cercaMessaggio(Messaggio m){
		return dbfacade.cerca(m);	
	}

	/**
	 * Cerco dal database il valore del testo di un messaggio inserito come parametro
	 */
	@Override
	public String ottieniTestoMessaggio(Messaggio m) {
		return dbfacade.ottieniTestoMessaggio(m.getIdMessaggio(), m.getTipo());
	}

	/**
	 * Funzione che mi permette di leggere tutti i messaggi inviati (con tutte le informazioni) da un certo utente, ogni minuto, per cinque minuti
	 * @param id del profilo che invia
	 * @param email del profilo che riceve
	 * @param Tipo del messaggio da leggere
	 */
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
	
	/**
	 * Funzione che permette di cercare nel database una chat indicata
	 * @param id del profilo che invia
	 * @param email del profilo che riceve
	 * @return lista che contiene il testo dei messaggi e email del profilo che li invia
	 */
	public ArrayList<String> cercaMessaggiChatPrivata(String inviante, String ricevente) {
		ArrayList<Messaggio> listaMessaggi = dbfacade.caricaMessaggiChatPrivata(inviante, ricevente);
		ArrayList<String> listaTestoEProfiloInviante = new ArrayList<String>();
		
		
		for(int i = 0; i < listaMessaggi.size(); i++) {
			listaTestoEProfiloInviante.add(listaMessaggi.get(i).getProfiloInviante());
			listaTestoEProfiloInviante.add(listaMessaggi.get(i).getTesto());
		}
		
		return listaTestoEProfiloInviante;
	}

	
	/**
	 * Funzione che mi permette di leggere tutti i messaggi (solamente il testo) inviati da un certo utente, ogni minuto, per cinque minuti
	 * @param id del profilo che invia
	 * @param email del profilo che riceve
	 * @param Tipo del messaggio da leggere
	 */
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
	


	/**
	 *Carica un post nel database
	 */
	@Override
	public boolean pubblicaPost(Post p) {
		boolean b = dbfacade.carica(p);
		String s = dbfacade.cerca(p).getProfilo();
		if(s != null) {
				int n = dbfacade.vediNumPost(new Profilo(s));
				n++;
				dbfacade.modificaNumPost(new Profilo(s), n);
				return b;
		}
		return false;
	}

	/**
	 *Rimuove un post dal database
	 */
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

	/**
	 *Cerca un post nel database
	 *@return post cercato
	 *@exception eccezione se il post non esiste
	 */
	@Override
	public Post cercaPost(Post p) throws PostNonVisibile, PostNonPresente{
		if (dbfacade.cerca(p) == null) {
			throw new PostNonPresente(p.getIdPost());
		}
		return dbfacade.cerca(p);
	}

	/**
	 * Ritorna la lista dei post di tutti i profili che seguo
	 * @return ArrayList di stringhe con gli id dei post che seguo
	 */
	public ArrayList<String> caricaPostProfiliSeguiti(String profilo, TipoPost tipo) {
		ArrayList<String> postDeiProfiliSeguiti = dbfacade.caricaPostProfiliSeguiti(profilo, tipo);
		return postDeiProfiliSeguiti;
	}
	
	public ArrayList<String> caricaStorieProfiliSeguiti(String profilo, TipoPost tipo) {
		ArrayList<String> storieDeiProfiliSeguiti = dbfacade.caricaStorieProfiliSeguiti(profilo, tipo);
		return storieDeiProfiliSeguiti;
	}
	
	/**
	 * Ritorna la lista dei post visibili del tipo specificato nel parametro 
	 */
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

	/**
	 * Carica un post che si elimina in automatico dopo time ore
	 * @param ore in cui voglio che il post sia nel database
	 * @param multimedia, cioè foto o video, che voglio caricare
	 */
	
	@Override
	public boolean pubblicaStoria(int time, Multimedia f){
	
		dbfacade.carica(f);
		dbfacade.modificaIsStory(f, true);
		dbfacade.modificaTempoCancellazione(f, time);
		Timer timerStoria = new Timer();
		timerStoria.schedule(new TimerTask() {
			public void run() {
				dbfacade.rimuovi(f);			}
		}, (time * 60 * 60 * 1000));
		return true;
	}
	
	

	/**
	 * Restituisce il path all' interno del pc del post specificato
	 */
	@Override
	public String ottieniPercorso(Post p) throws PostNonVisibile{
		if(dbfacade.vediVisibilita(p) == true)
			return dbfacade.ottieniPercorso(p);
	
		throw new PostNonVisibile(p.getIdPost());
	}

	
	/**
	 * Restituisce la lista di tutti i commenti(con tutte le iformazioni) sotto un post
	 */
	@Override
	public ArrayList<Commento> selectAllCommentiSottoPost(Post p) {
		return dbfacade.mostraCommentiPost(p);
	}

	
	/**
	 * Restituisce la lista di tutti i commenti(solo testo) sotto un post
	 */
	@Override
	public ArrayList<String> testoCommentiPost(Post p) throws PostNonVisibile{
		if(dbfacade.vediVisibilita(p) == true)
			return dbfacade.mostraTestoCommentiPost(p);
		throw new PostNonVisibile(p.getIdPost());
	}

	/**
	 * Mi dice se il post è visibile
	 */
	@Override
	public boolean vediVisibilita(Post p) {
		return dbfacade.vediVisibilita(p);
	}

	/**
	 * Modifica la visibilita di un post
	 */
	@Override
	public boolean modificaVisibilita(Post p, boolean b) {
		return dbfacade.modificaVisibilita(p, b);
	}

	/**
	 * Permette di aggiungere un voto ad un sondaggio
	 * @param id del sondaggio a cui si vuole votare
	 * @param opzione del sondaggio scelta
	 * @param tipo di sondaggio a cui vogliamo votare
	 * @return true se la votazione è avvenuta correttamente
	 * @exception Eccezione se inserisco una opzione che non esiste
	 * @exception Eccezione se cerco di v otare due volte allo stesso sondaggio
	 */
	@Override
	public boolean aggiungiVotoSondaggio(String idSondaggio, int scelta, TipoPost t) throws TastoNonEsistente, AzioneNonConsentita{
		
		if (t == TipoPost.SONDAGGIODOPPIAVOTAZIONE && dbfacade.presenteSondaggioMap(this.getIdProfilo(), idSondaggio) == false) {
			System.out.println("doppio");
			Sondaggio s = new SondaggioDoppiaVotazione(idSondaggio);
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
				throw new TastoNonEsistente();
			}
			dbfacade.caricaSondaggioMap(this.getIdProfilo(), s.getIdPost());
		return true;
		}
		
		else if (t == TipoPost.SONDAGGIOSCELTAMULTIPLA && dbfacade.presenteSondaggioMap1(this.getIdProfilo(), idSondaggio) == false) {
			System.out.println("sceltamultipla");
			SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(idSondaggio);
			switch(scelta) {
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
				throw new TastoNonEsistente();
			}
			dbfacade.caricaSondaggioMap1(this.getIdProfilo(), s.getIdPost());
        	return true;
		}
		throw new AzioneNonConsentita();
	}

	/**
	 * Stampa a schermo i risultati che ha ottenuto un certo sondaggio
	 */
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

	/**
	 * Cerca un profilo nel database
	 * @return ritorna il profilo cercato
	 */
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

	/**
	 * Modifica l'immagine di profilo
	 * @param path dell'immagine da inserire
	 */
	@Override
	public boolean cambiaImmagineProfilo(String immagine) {
		return dbfacade.modificaImmagineProfilo(new Profilo(this.getIdProfilo()), immagine);
	}

	/**
	 * Mostra l'immagine di profilo del profilo indicato
	 */
	@Override
	public String ottieniImmagineProfilo(Profilo p) {
		return dbfacade.ottieniImmagineProfilo(p);
	}


	/**
	 * Restituisce un arrayList con tutte le info dei messaggi relativi ad un profilo
	 * @param profilo di cui vogliamo vedere i messaggi
	 * @param Tipo di messaggi che vogliamo vedere
	 */
	@Override
	public ArrayList<Messaggio> selezionaMessaggiProfilo(Profilo p, TipoMessaggio t) {
		return dbfacade.selezionaMessaggiProfilo(p, t);
	}

	/**
	 * Restituisce un arrayList con il testo dei messaggi relativi ad un profilo
	 * @param profilo di cui vogliamo vedere i messaggi
	 * @param Tipo di messaggi che vogliamo vedere
	 */
	@Override
	public ArrayList<String> selezionaTestoMessaggiProfilo(Profilo p, TipoMessaggio t) {
		return dbfacade.selezionaTestoMessaggiProfilo(p, t);
	}



	/**
	 * Restituisce tutti i post visibili di un profilo. Restituisce anche i non visibili se cerco i post del mio profilo
	 * @param profilo di cui vogliamo vedere i post
	 * @param Tipo di Post che vogliamo vedere
	 * @return Arraylist di stringhe in cui abbiamo idPost e percorso se il post è multimediale(foto,video)
	 *  e abbiamo idPost e descrizione per gli altri tipi di post
	 */
	
	public ArrayList<String> caricaTuttiiPostDiUnProfilo(String pr, TipoPost f) {
	
	ArrayList<String> res = dbfacade.ottieniIdPost(f, new Profilo(pr,null));

	//Se i post sono miei ritona anche quelli non visibili
	if(pr.equals(this.getIdProfilo())) {
		return res;
	}
	
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
		if(dbfacade.vediIsStory(posttt) == false && dbfacade.vediVisibilita(posttt) == true) {
			risultato.add(posttt.getIdPost());
			if(f == TipoPost.FOTO || f == TipoPost.VIDEO)
		        risultato.add(posttt.getPercorso());
			else if(f == TipoPost.SONDAGGIODOPPIAVOTAZIONE || f == TipoPost.SONDAGGIOSCELTAMULTIPLA || f == TipoPost.TESTO)
				risultato.add(posttt.getDescrizione());
		}
	}
		return risultato;
    
}

	/**
	 * Mostra il nickname di un profilo indicato
	 */
	@Override
	public String vediNickname(Profilo p) {
		return dbfacade.vediNickname(p);
	}

	/**
	 * Modifica il nickname di un profilo indicato
	 */
	@Override
	public boolean modificaNickname(Profilo p, String n) {
		return dbfacade.modificaNickname(p, n);
	}

	/**
	 * Mostra la descrizione di un profilo indicato
	 */
	@Override
	public String vediDescrizione(Profilo p) {
		return dbfacade.vediDescrizione(p);
	}

	/**
	 * Modifica la descrizione di un profilo indicato
	 */
	@Override
	public boolean modificaDescrizione(String n) {
		return dbfacade.modificaDescrizione(new Profilo(this.getIdProfilo()), n);
	}

	@Override
	public Commento creaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String profilo, String idFoto,	String idVideo,String idSDV,String idSSM, String idTesto) {
 
		Commento c = new Commento(idCommento,oraCommento,dataCommento,testo,profilo,idFoto,idVideo,idSDV,idSSM,idTesto);
		return c;
	}

	/**
	 * Carica un commento nel database
	 * @param id del profilo sotto cui sarà scritto il commento
	 * @param id del post sotto cui sarà scritto il commento
	 * @param testo del commento
	 */
	@Override
	public boolean pubblicaCommento(String idProfilo, String idPost, String testoCommento, TipoPost t) {
		Commento c;
		String idCommento = Integer.toString((int)Math.round(Math.random() * 1000));
	 		c = new Commento(idCommento, idProfilo, idPost, testoCommento);
	 		if(dbfacade.cerca(c) != null) {
	 			pubblicaCommento(idProfilo, idPost, testoCommento, t);
	 		}
		return dbfacade.carica(c);
	}


	/**
	 * Rimuove un commento dal database
	 * @param id del commento da rimuovere
	 */
	@Override
	public boolean rimuoviCommento(String idCommento)  {
		return dbfacade.rimuovi(new Commento(idCommento));
	}

	/**
	 * cerca un commento nel database
	 * @return commento trovato
	 */
	@Override
	public Commento cercaCommento(String idCommento) {
		return dbfacade.cerca(new Commento(idCommento));
	}

	/**
	 * Ritorna una lista con l'id e il nickname di un profilo seguito dall'id commento
	 */
	@Override
	public ArrayList<String> ProfiloNickCommento(Profilo p) {
		return dbfacade.ProfiloNickCommento(p);
	}

	/**
	 * Crea un gruppo e lo carica nel database
	 * @param descrizione del gruppo 
	 * @param nome del gruppo
	 * @param id dei profili partecipanti
	 * @param id dell'amministratore del gruppo
	 * @param path della foto del gruppo
	 */
	public boolean creaGruppo(String descrizione, String nomeGruppo) throws AccountDoesNotExist{
		Gruppo g;
		//String idGruppo  = Integer.toString((int)Math.round(Math.random() * 1000));
		
		g = new Gruppo(nomeGruppo);
		if(dbfacade.cerca(g) != null) {
			creaGruppo(descrizione, nomeGruppo);
		}
		g = new Gruppo(nomeGruppo,descrizione, getIdProfilo(), null, null, null, null, null , getIdProfilo());
		
		return dbfacade.carica(g);
	}

	/**
	 * Rimuove un gruppo dal database
	 */
	@Override
	public boolean rimuoviGruppo(Gruppo g)  {
		return dbfacade.rimuovi(g);
	}

	/**
	 * Modifica i partecipanti ad un gruppo
	 * @param id del gruppo
	 * @param id dei partecipanti da modificare
	 */
	@Override
	public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6)  {
		Gruppo g = new Gruppo(idGruppo,null,profilo1,profilo2,profilo3,profilo4,profilo5,profilo6,null);
		return dbfacade.gestisciPartecipanti(g);
	}

	/**
	 * Cerca nel database il gruppo indicato
	 */
	@Override
	public Gruppo cercaGruppo(Gruppo g) {
		return dbfacade.cerca(g);
	}
	
	/**
	 * Carica l'id e il nome di un gruppo di cui il profilo indicato fa parte
	 */
	public ArrayList<String> caricaGruppiProfilo(String profilo) {
		return dbfacade.caricaGruppiProfilo(profilo);
	}



	/**
	 * Mostra tutte le informazioni di tutti i gruppi
	 */
	@Override
	public ArrayList<Gruppo> selectAllGruppo(){
		ArrayList<Gruppo> res = dbfacade.selectAllGruppo();
		return res;
		}	

	/**
	 * Permette di aggiungere like ad un post
	 * @exception se provo a mettere like due volte
	 */
	@Override
	public boolean aggiungiLike(String idPost, TipoPost t)throws AzioneNonConsentita{	
		if(dbfacade.presenteLikeMap(this.getIdProfilo(), idPost) == true) {
	    throw new AzioneNonConsentita();
		}else {
			
		Post p = PostUtility.restituisciTipo(idPost, t);
	    int i = dbfacade.vediNumLike(p);
        i++;
        dbfacade.modificaNumLike(p, i);
        dbfacade.caricaLikeMap(this.getIdProfilo(), p.getIdPost());
	    return true;
		}		
	}


	/**
	 * Permette di aggiungere dislike ad un post
	 * @exception se provo a mettere like due volte
	 */
	@Override
	public boolean aggiungiDislike(String idPost, TipoPost t)throws AzioneNonConsentita{
		if(dbfacade.presenteDislikeMap(this.getIdProfilo(), idPost) == true) {
			throw new AzioneNonConsentita();
		}else {		
			
			Post p = PostUtility.restituisciTipo(idPost, t);
			int i = dbfacade.vediNumDislike(p);
	        i++;
	        dbfacade.modificaNumDislike(p, i);
	        dbfacade.caricaDislikeMap(this.getIdProfilo(), p.getIdPost());
		    return true;
		}
	}

	/**
	 * Permette di rimuovere il like ad un post
	 * @exception se provo a togliere like quando non c'è
	 */
	@Override
	public boolean rimuoviLike(String idPost, TipoPost t)throws AzioneNonConsentita{

		if(dbfacade.presenteLikeMap(this.getIdProfilo(), idPost) == true) {
			
			Post p = PostUtility.restituisciTipo(idPost, t);
			int i = dbfacade.vediNumLike(p);
			i--;
			dbfacade.modificaNumLike(p, i);
			dbfacade.rimuoviLike(this.getIdProfilo(), p.getIdPost());
			return true;
		}
		throw new AzioneNonConsentita();

	}

	/**
	 * Permette di rimuovere il dislike ad un post
	 * @exception se provo a togliere dislike quando non c'è
	 */
	@Override
	public boolean rimuoviDislike(String idPost, TipoPost t)throws AzioneNonConsentita{
		if(dbfacade.presenteDislikeMap(this.getIdProfilo(), idPost) == true) {	
			Post p = PostUtility.restituisciTipo(idPost, t);
			int i = dbfacade.vediNumDislike(p);
			i--;
			dbfacade.modificaNumDislike(p, i);
			dbfacade.rimuoviDislike(this.getIdProfilo(), p.getIdPost());
			return true;
		}
		throw new AzioneNonConsentita();
	}
	
	
	public void scriviMessaggioPrivato(String testo, String ricevente) {

 		int idMessage = (int)Math.round(Math.random() * 10000);
 		String idMessaggio = Integer.toString(idMessage);

 		if(dbfacade.cerca(new MessaggioPrivato(idMessaggio)) != null) {
 			scriviMessaggioPrivato(testo, ricevente);
 		}
 		scriviMessaggio(new MessaggioPrivato(idMessaggio, testo, this.getIdProfilo(), ricevente));
	}
		

	/**
	 * Carica nel database un messaggio di gruppo (Utile per il controller)
	 * @param testo del messaggio da scrivere
	 * @param id del gruppo 
	 */
	public void scriviMessaggioGruppo(String testo, String idGruppo) {
		MessaggioDiGruppo m;
		int idMessaggioInt = (int)Math.round(Math.random() * 1000);
		String idMessaggio = "M" + Integer.toString(idMessaggioInt);
		m = new MessaggioDiGruppo(idMessaggio,testo, this.getIdProfilo(), idGruppo);
		
		if(dbfacade.cerca(new MessaggioDiGruppo(idMessaggio)) != null) {
			scriviMessaggioGruppo(testo, idGruppo);
		}
		System.out.println(m.toString());
		dbfacade.carica(m);
	}
	
	public ArrayList<String> caricaMessaggiChatGruppoConProfiloInviante(String idGruppo) {
		return dbfacade.caricaMessaggiChatGruppoConProfiloInviante(idGruppo);
	}

	/**
	 * Cambia la password "Cambiami" inserita di default nel profilo
	 * @param nuova password da inserire
	 */
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

	/**
	 * Permette di modifica l'attuale psw di un profilo
	 * @param vecchia password
	 * @param nuova password da inserire
	 */
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
	
	/**
	 * Funzione che permette di rimuovere dal database il profilo personale di un utente
	 */
	public boolean rimuoviQuestoProfilo() {
	 	return dbfacade.rimuovi(new Profilo(this.getIdProfilo()));
	 }		
	
	/**
	 * Carica nel database una foto (Utile per il controller)
	 * @param descrizione della foto
	 * @param visibilita della foto
	 * @param profilo nel quale caricare la foto
	 * @param path della foto
	 * @param mi dice se la foto è in alta definizione 
	 */
	 public void pubblicaFoto(String descrizione, boolean visibile, String percorso, boolean isHd) {
		 Foto p;
		 String idPost = "F" + Integer.toString(((int)Math.round(Math.random() * 1000)));
		 p = new Foto(idPost, descrizione, visibile, getIdProfilo(), percorso, isHd, false);
		 		
		 if(dbfacade.cerca(new Foto(idPost)) != null) {
			 pubblicaFoto(descrizione, visibile, percorso, isHd);
		 }
		this.pubblicaPost(p);
	}
	
	 public void pubblicaStoria(String descrizione, boolean visibile, String percorso, boolean isHd) {
		 Foto p;
		 String idPost = "F" + Integer.toString(((int)Math.round(Math.random() * 1000)));
		 p = new Foto(idPost, descrizione, visibile, this.getIdProfilo(), percorso, isHd, true);
		 this.pubblicaStoria(24, p);
	}
	
	 
	 /**
		 * Carica nel database un sondaggio doppia votazione (Utile per il controller)
		 * @param descrizione del sondaggio
		 * @param visibilita del sondaggio
		 * @param profilo nel quale caricare il sondaggio
		 * @param prima scelta del sondaggio
		 * @param seconda opzione del sondaggio
		 */
	public void pubblicaSondaggioDoppiaVotazione(String descrizione, boolean visibile, String profilo, String primaScelta, String secondaScelta) {
			
		SondaggioDoppiaVotazione s;
		String idPost = "SD" + Integer.toString((int)Math.round(Math.random() * 1000));
		 		
		 s = new SondaggioDoppiaVotazione(idPost, descrizione, visibile, profilo, primaScelta, secondaScelta);
		 		
		 if(dbfacade.cerca(new SondaggioDoppiaVotazione(idPost)) != null) {
		 	pubblicaSondaggioDoppiaVotazione(descrizione, visibile, profilo, primaScelta, secondaScelta);
		 	}
		 this.pubblicaPost(s);
		}
	
	/**
	 * Carica nel database un sondaggio scelta multipla (Utile per il controller)
	 * @param descrizione del sondaggio
	 * @param visibilita del sondaggio
	 * @param profilo nel quale caricare il sondaggio
	 * @param prima scelta del sondaggio
	 * @param seconda opzione del sondaggio
	 * @param terza opzione del sondaggio
	 * @param quarta opzione del sondaggio
	 */
	public void pubblicaSondaggioSceltaMultipla(String descrizione, boolean visibile, String profilo,
		String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta) {
				
		SondaggioSceltaMultipla s;
		String idPost = "SM" + Integer.toString((int)Math.round(Math.random() * 1000));
		 		
		 s = new SondaggioSceltaMultipla(idPost, descrizione, visibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta);
		 		
		 if(dbfacade.cerca(new SondaggioSceltaMultipla(idPost, null, false, null, null, null, null, null)) != null) {
		 	pubblicaSondaggioSceltaMultipla(descrizione, visibile, profilo, primaScelta, secondaScelta, terzaScelta, quartaScelta);
		 }
		 this.pubblicaPost(s);
	}
	
	/**
	 * Carica nel database un testo (Utile per il controller)
	 * @param descrizione del testo
	 * @param visibilita del testo
	 * @param profilo nel quale caricare il testo
	 * @param stringa che indica il font utilizzato
	 * @param titolo del testo
	 */
	public void pubblicaTesto(String descrizione, boolean visibile, String profilo, String font, String titolo) {
		
		String idPost = "T" + Integer.toString((int)Math.round(Math.random() * 1000));
	 		
	 	Testo t = new Testo(idPost, descrizione, visibile, profilo, font, titolo);
	 		
	 	if(dbfacade.cerca(new Testo(idPost)) != null) {
	 		pubblicaTesto(descrizione, visibile, profilo, font, titolo);
	 	}
	 	this.pubblicaPost(t);
	}

	/**
	 * Permette di aggiungere un partecipante ad un gruppo
	 * @param id del gruppo 
	 * @param id del profilo da aggiungere
	 */
@Override
public boolean aggiungiPartecipante(String idGruppo, String idProfilo) throws GruppoGiaPieno, ProfiloGiaInserito {
		
		Gruppo g = dbfacade.cerca(new Gruppo(idGruppo));
		
		if(g != null) {
			if(g.getProfilo1() == null) {
				dbfacade.gestisciPartecipante1(idProfilo, g);
				g.setProfilo1(idProfilo);
				return true;
			}
			else if(g.getProfilo2() == null) {
				dbfacade.gestisciPartecipante2(idProfilo, g);
				g.setProfilo2(idProfilo);
				if(g.getProfilo2().equals(g.getProfilo1())) {
					dbfacade.gestisciPartecipante2(null, g);
					throw new ProfiloGiaInserito(idProfilo);
				}
				return true;
			}
			else if(g.getProfilo3() == null) {
				dbfacade.gestisciPartecipante3(idProfilo, g);
				g.setProfilo3(idProfilo);
				if(g.getProfilo3().equals(g.getProfilo1()) || g.getProfilo3().equals(g.getProfilo2())) {
					dbfacade.gestisciPartecipante3(null, g);
					throw new ProfiloGiaInserito(idProfilo);
				}
				return true;
			}
			else if(g.getProfilo4() == null) {
				dbfacade.gestisciPartecipante4(idProfilo, g);
				g.setProfilo4(idProfilo);
				if(g.getProfilo4().equals(g.getProfilo1()) || g.getProfilo4().equals(g.getProfilo2()) || g.getProfilo4().equals(g.getProfilo3())) {
					dbfacade.gestisciPartecipante4(null, g);
					throw new ProfiloGiaInserito(idProfilo);
				}
				return true;
			}
			else if(g.getProfilo5() == null) {
				dbfacade.gestisciPartecipante5(idProfilo, g);
				g.setProfilo5(idProfilo);
				if(g.getProfilo5().equals(g.getProfilo1()) || g.getProfilo5().equals(g.getProfilo2()) || g.getProfilo5().equals(g.getProfilo3()) || g.getProfilo5().equals(g.getProfilo4())) {
					dbfacade.gestisciPartecipante5(null, g);
					throw new ProfiloGiaInserito(idProfilo);
				}
				return true;
			}
			else if(g.getProfilo6() == null) {
				dbfacade.gestisciPartecipante6(idProfilo, g);
				g.setProfilo6(idProfilo);
				if(g.getProfilo6().equals(g.getProfilo1()) || g.getProfilo6().equals(g.getProfilo2()) || g.getProfilo6().equals(g.getProfilo3()) || g.getProfilo6().equals(g.getProfilo4()) || g.getProfilo6().equals(g.getProfilo5())) {
					dbfacade.gestisciPartecipante6(null, g);
					throw new ProfiloGiaInserito(idProfilo);
				}
				return true;
			}
		}
		throw new GruppoGiaPieno(idGruppo);
		
	}
/**
 * Permette di rimuovere un partecipante da un gruppo
 * @param id del gruppo 
 * @param id del profilo da aggiungere
 */
@Override
public boolean rimuoviPartecipante(String idGruppo, String idProfilo){
	
	Gruppo g = dbfacade.cerca(new Gruppo(idGruppo));
	
	if(g != null) {
		if(g.getProfilo1() == null || g.getProfilo1().equals(idProfilo)) {
			dbfacade.gestisciPartecipante1(null, g);
			
		}
		if(g.getProfilo2() == null || g.getProfilo2().equals(idProfilo)) {
			dbfacade.gestisciPartecipante2(null, g);
			
		}
		if(g.getProfilo3() == null || g.getProfilo3().equals(idProfilo)) {
			dbfacade.gestisciPartecipante3(null, g);
			
		}
		if(g.getProfilo4() == null || g.getProfilo4().equals(idProfilo)) {
			dbfacade.gestisciPartecipante4(null, g);
			
		}
		else if(g.getProfilo5() == null || g.getProfilo5().equals(idProfilo)) {
			dbfacade.gestisciPartecipante5(null, g);
			
		}
		if(g.getProfilo6() == null || g.getProfilo6().equals(idProfilo)) {
			dbfacade.gestisciPartecipante6(null, g);
		}
	}
	
	return true;
}
/**
 * permette di modificare la descrizione di un gruppo
 * @param id del gruppo
 * @param descrizione del gruppo
 */
@Override
public boolean modificaDescrizione(String idGruppo, String descrizione) {
	
	return dbfacade.modificaDescrizione(descrizione, new Gruppo(idGruppo));
}

/**
 * Ritorna il conteggio di un determinato sondaggio
 * @param id del sondaggio 
 * @param tipo di sondaggio
 * @return vettore di interi con i punteggi effettuati da ciascuna opzione
 */
@Override
public int[] ottieniConteggiSondaggio(String idSondaggio, TipoPost p) {
	if(p == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
		int [] i = new int [2];
		i[0] = dbfacade.vediCount1SDV(new SondaggioDoppiaVotazione(idSondaggio));
		i[1] = dbfacade.vediCount2SDV(new SondaggioDoppiaVotazione(idSondaggio));
		return i;
	}
	else if(p == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
		int [] i = new int [4];
		i[0] = dbfacade.vediCount1SSM(new SondaggioSceltaMultipla(idSondaggio));
		i[1] = dbfacade.vediCount2SSM(new SondaggioSceltaMultipla(idSondaggio));
		i[2] = dbfacade.vediCount3SSM(new SondaggioSceltaMultipla(idSondaggio));
		i[3] = dbfacade.vediCount4SSM(new SondaggioSceltaMultipla(idSondaggio));
		return i;
		}
	return null;
	}
}

	




