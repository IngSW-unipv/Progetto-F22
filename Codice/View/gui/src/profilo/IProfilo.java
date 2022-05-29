package profilo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import Messaggio.enumeration.TipoMessaggio;
import chat.chatDiGruppo.gruppo.Gruppo;
import post.Post;
import post.commento.Commento;
import post.enumeration.TipoPost;
import post.multimedia.Multimedia;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.PostNonVisibile;
import profilo.follow.Follow;

public interface IProfilo {
 
	
	//Messaggi
	
	public MessaggioDiGruppo creaMessaggioDiGruppo(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,String profiloInviante,String idGruppo);
	public MessaggioPrivato creaMessaggioPrivato(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,String idProfiloInviante, String idProfiloRicevente);
	public boolean scriviMessaggio(Messaggio m);
	public boolean rimuoviMessaggio(Messaggio m);
	
	public Messaggio cercaMessaggio(Messaggio m);
	
	public String ottieniTestoMessaggio(Messaggio m);
	
    //Legge tutti i messaggi ricevuti ogni minuto da un profilo o un gruppo precisato(In base al tipo di messaggio).Dopo 5 minuti smette di farlo e si stoppa
	public boolean leggiMessaggi(String s, TipoMessaggio t);
    
	//Legge tutti i messaggi ricevuti ogni minuto da un profilo o un gruppo precisato(In base al tipo di messaggio).Dopo 5 minuti smette di farlo e si stoppa
	//A differenza del metodo leggiMessaggi, verranno restituite solo le informazioni riguardanti il testo del messaggio
	public boolean leggiSoloTesto(String s, TipoMessaggio t);
	
	
	//Post
	
	public Foto creaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String percorso, boolean isHd);
	public Video creaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String percorso, int durataInSecondi);
	public SondaggioDoppiaVotazione creaSondaggioSD(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String primaScelta, String secondaScelta, int [] conteggio);
	public SondaggioSceltaMultipla creaSondaggioDM(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta, int [] conteggio);
	public Testo creaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String font, String titolo);
	
	public boolean pubblicaPost(Post p);
	public boolean rimuoviPost(Post p);
	
	
    public Post cercaPost(Post p)throws PostNonVisibile;
	

	/*-------------------*/public ArrayList<Post> selectAllPost(TipoPost t);
	
	//L'int time rappresenta la durata in ore nel quale la storia rimarra' pubblicata. A fine di time ore, la storia sar� rimossa automaticamente
    public boolean pubblicaStoria(int time, Multimedia f);
	
    public String ottieniPercorso(Post p)throws PostNonVisibile;
    
	public ArrayList<Commento> selectAllCommentiSottoPost(Post p)throws PostNonVisibile;
	public ArrayList<String> testoCommentiPost(Post p)throws PostNonVisibile;
	
	public boolean vediVisibilita(Post p);
	public boolean modificaVisibilita(Post p, boolean b);
	
    //Profilo
    
    public Profilo cercaProfilo(Profilo p)throws AccountDoesNotExist;
    public boolean cambiaImmagineProfilo(Profilo p, String immagine);
    public String ottieniImmagineProfilo(Profilo p);
    
    //Ritorna tutti i messaggi di un profilo specificato
    public ArrayList<Messaggio> selezionaMessaggiProfilo(Profilo p, TipoMessaggio t);
	
	public ArrayList<String> selezionaTestoMessaggiProfilo(Profilo p, TipoMessaggio t);
	    
	public ArrayList<String> caricaTuttiiPostDiUnProfilo(Profilo p, Post f);
    
    //Commenti
    public Commento creaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String profilo, String idFoto,String idVideo,String idSDV,String idSSM, String idTesto); 
    public boolean pubblicaCommento(Commento c);
    public boolean rimuoviCommento(Commento c);
	public Commento cercaCommento(Commento c);
	public ArrayList<String> ProfiloNickCommento(Profilo p);
	
	//Follow
	public boolean profiloNonSeguito(String emailProfilo);
	public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist;
	public boolean segui(Profilo email)throws AccountDoesNotExist;
	public boolean smettiDiSeguire(Profilo profiloSeguito) throws AccountDoesNotExist;
	
	//Mostra la lista di tutti i follower del profilo personale indicato
	public ArrayList<String> vediMieiFollower(Follow f);
	
	public Follow cercaFollow(Follow f);
	
	//Gruppo
	
	    public boolean creaGruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6, String amministratore)throws AccountDoesNotExist;
	    public boolean rimuoviGruppo(Gruppo g);
	    public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6);
        public Gruppo cercaGruppo(Gruppo g);
		public ArrayList<Gruppo> selectAllGruppo();
	    
	
    //Like Dislike
	
	
	public boolean aggiungiLike(Post p);
	public boolean aggiungiDislike(Post p);
	public boolean rimuoviLike(Post p);
	public boolean rimuoviDislike(Post p);
	}
