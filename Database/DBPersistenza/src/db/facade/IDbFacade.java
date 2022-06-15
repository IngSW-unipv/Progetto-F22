package db.facade;

import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.enumeration.TipoMessaggio;
import chat.chatDiGruppo.gruppo.Gruppo;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import profilo.Profilo;
import profilo.exception.AccountDoesNotExist;
import profilo.follow.Follow;

public interface IDbFacade {

	
	//Commenti
	
	public boolean carica(Commento c);
	public boolean rimuovi(Commento c);
    public Commento cerca(Commento c);
	public ArrayList<String> ProfiloNickCommento(Profilo p);
	
	
    //Gruppi
	
	public boolean carica(Gruppo g);
	public boolean rimuovi(Gruppo g);
	public boolean gestisciPartecipanti(Gruppo g);
    public Gruppo cerca(Gruppo g);
	public ArrayList<Gruppo> selectAllGruppo();
	boolean modificaDescrizione(String descrizione, Gruppo g);
	boolean gestisciPartecipante1(String idProfilo, Gruppo g);
	boolean gestisciPartecipante2(String idProfilo, Gruppo g);
	boolean gestisciPartecipante3(String idProfilo, Gruppo g);
	boolean gestisciPartecipante4(String idProfilo, Gruppo g);
	boolean gestisciPartecipante5(String idProfilo, Gruppo g);
	boolean gestisciPartecipante6(String idProfilo, Gruppo g);
	
	//Messaggi
	
	
	public boolean carica(Messaggio md);
	public boolean rimuovi(Messaggio m);
	public Messaggio cerca(Messaggio m);
	public String ottieniTestoMessaggio(String m, TipoMessaggio t);
	public ArrayList<Messaggio> selezionaMessaggi(String s1, String s2, TipoMessaggio t);
	public ArrayList<Messaggio> selezionaMessaggiProfilo(Profilo p, TipoMessaggio t);
	public ArrayList<String> selezionaTestoMessaggiProfilo(Profilo p, TipoMessaggio t);
	public ArrayList<Messaggio> caricaMessaggiChatPrivata(String inviante, String ricevente);
	public ArrayList<String> ottieniTestoListaMessaggi(String m1, String m2, TipoMessaggio t);
     
     
	//Post
	
     public boolean carica(Post p);
     public boolean rimuovi(Post p);
     public Post cerca(Post p);
     public ArrayList<Post> selectAllPost(TipoPost t);
     public String ottieniPercorso(Post m);
     
    //Ottiene gli id e il percorso dei post di un profilo 
	public ArrayList<String> ottieniIdPost(TipoPost p, Profilo pr);
    public ArrayList<Commento> mostraCommentiPost(Post p);
	public ArrayList<String> mostraTestoCommentiPost(Post p);
    public boolean vediVisibilita(Post p);
    public boolean modificaVisibilita(Post p, boolean b);
    public int vediNumLike(Post p);
    public boolean modificaNumLike(Post p, int n);
    public int vediNumDislike(Post p);
    public boolean modificaNumDislike(Post p, int n);
    public boolean modificaTempoCancellazione(Post m,int tempo);
    public boolean modificaIsStory(Post m,boolean b);
    
    //Solo sondaggi
    
    public int vediCount1SDV(Post p);
    public int vediCount2SDV(Post p);
    public boolean modificaCount1SDV(Post p, int n);
    public boolean modificaCount2SDV(Post p, int n);
    public int vediCount1SSM(Post p);
    public int vediCount2SSM(Post p);
    public int vediCount3SSM(Post p); 
    public int vediCount4SSM(Post p);
    public boolean modificaCount1SSM(Post p, int n);
    public boolean modificaCount2SSM(Post p, int n);
    public boolean modificaCount3SSM(Post p, int n);
    public boolean modificaCount4SSM(Post p, int n);
    
    
	//Profilo
	
	public ArrayList<Profilo> selectAllProfilo();
	public boolean carica(Profilo p);
    public boolean rimuovi(Profilo p);
	public Profilo cerca(Profilo p);
	public boolean vediEsiste(String idProfilo) throws AccountDoesNotExist;
	public boolean modificaEsiste(String p, Boolean b);
	public boolean vediPswCambiata(String idProfilo) throws AccountDoesNotExist;
	public boolean modificaPswCambiata(String p, Boolean b);
	public boolean vediSeLoggato(String idProfilo) throws AccountDoesNotExist;
	public boolean modificaLoggato(String p, Boolean b);
	public String vediPsw(String idProfilo) throws AccountDoesNotExist;
    public boolean modificaPsw(String p, String b) throws AccountDoesNotExist;
	public boolean modificaImmagineProfilo(Profilo p, String immagine);
	public String ottieniImmagineProfilo(Profilo p);
    public int vediNumSeguiti(Profilo p);
	public boolean modificaNumSeguiti(Profilo p, int n);
	public int vediNumFollower(Profilo p);
	public boolean modificaNumFollower(Profilo p, int n) ;
	public int vediNumPost(Profilo p);
	public boolean modificaNumPost(Profilo p, int n);
	public String vediNickname(Profilo p);
	public boolean modificaNickname(Profilo p, String n);
	public String vediDescrizione(Profilo p);
	public boolean modificaDescrizione(Profilo p, String n);
	
	
	//Follow
	
	public boolean carica(Follow f);
	public boolean rimuovi(Follow f);
	public ArrayList<Follow> selectAllFollow();
	public Follow cerca(Follow f);
    public ArrayList<String> cercaProfSeguito(String s);
	
	//Like e Dislike
	
	public boolean caricaLikeMap(String profilo, String post);
	public boolean rimuoviLike(String profilo,String post);
	public ArrayList<String> cercaLikeMap(String s1, String s2);
	public boolean caricaDislikeMap(String profilo, String post);
	public boolean rimuoviDislike(String profilo,String post);
	public ArrayList<String> cercaDislikeMap(String s1, String s2);
	
	//SondaggioMap
	
	public boolean caricaSondaggioMap(String profilo, String sondaggio);
	public ArrayList<String> cercaSondaggioMap(String profilo, String sondaggio);
	public boolean caricaSondaggioMap1(String profilo, String sondaggio);
	public ArrayList<String> cercaSondaggioMap1(String profilo, String sondaggio);
	
	//Alcuni metodi utility
	
	public boolean presenteLikeMap(String s1,String s2);
	public boolean presenteDislikeMap(String s1,String s2);
	public boolean presenteSondaggioMap(String s1, String s2);
	public boolean presenteSondaggioMap1(String s1, String s2);
	
	
	//Ritorna true se l'account inserito e' "seguibile"
	public boolean profiloNonSeguito(Follow f);

	//Ritorna true se l'account e' esistente
	public boolean accountEsistente(Profilo p) throws AccountDoesNotExist ;
	
	


}
