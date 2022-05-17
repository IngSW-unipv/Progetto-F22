package profilo;

import java.sql.Date;
import java.sql.Time;

import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import Messaggio.enumeration.TipoMessaggio;
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

public interface IProfilo {



	public boolean profiloNonSeguito(String emailProfilo);
	public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist;
	public boolean segui(String email)throws AccountDoesNotExist;
	public boolean smettiDiSeguire(String profiloSeguito) throws AccountDoesNotExist;
 
	
	//Messaggi
	
	public MessaggioDiGruppo creaMessaggioDiGruppo(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,String idGruppo);
	public MessaggioPrivato creaMessaggioPrivato(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,String idProfiloInviante, String idProfiloRicevente);
	public boolean scriviMessaggio(Messaggio m) throws AccountDoesNotExist;
	public boolean rimuoviMessaggio(Messaggio m) throws AccountDoesNotExist;
	
	public Messaggio cercaMessaggio(Messaggio m)throws AccountDoesNotExist;
	
	public String ottieniTestoMessaggio(Messaggio m)throws AccountDoesNotExist;
	
    //Legge tutti i messaggi ricevuti ogni minuto da un profilo o un gruppo precisato(In base al tipo di messaggio).Dopo 5 minuti smette di farlo e si stoppa
	public boolean leggiMessaggi(String s, TipoMessaggio t) throws AccountDoesNotExist;
    
	//Legge tutti i messaggi ricevuti ogni minuto da un profilo o un gruppo precisato(In base al tipo di messaggio).Dopo 5 minuti smette di farlo e si stoppa
	//A differenza del metodo leggiMessaggi, verranno restituite solo le informazioni riguardanti il testo del messaggio
	public boolean leggiSoloTesto(String s, TipoMessaggio t)throws AccountDoesNotExist;
	
	
	//Post
	
	public Foto creaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, boolean isHd);
	public Video creaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, int durataInSecondi);
	public SondaggioDoppiaVotazione creaSondaggioSD(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String primaScelta, String secondaScelta, int [] conteggio);
	public SondaggioSceltaMultipla creaSondaggioDM(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta, int [] conteggio);
	public Testo creaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String font, String titolo);
	
	public boolean pubblicaPost(Post p);
	public boolean rimuoviPost(Post p);
	public Post cercaPost(Post p);
	
	//Stampa le informazioni di tutti i post nel db
	public void selectAllPost(TipoPost t);
	
	//L'int time rappresenta la durata in ore nel quale la storia rimarrà pubblicata. A fine di time ore, la storia sarà rimossa automaticamente
    public boolean pubblicaStoria(int time, Multimedia f)throws AccountDoesNotExist;
	
    
    //Profilo
    
    public Profilo cercaProfilo(Profilo p)throws AccountDoesNotExist;
    public boolean stampaInfoProfilo(Profilo p) throws AccountDoesNotExist;
    
    
    //-----------------------------------------------------------------------------------------------------------------------------
	
	
	public boolean pubblicaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String post)throws AccountDoesNotExist; 
	
    
    public boolean creaGruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6, String amministratore)throws AccountDoesNotExist;
    public boolean rimuoviGruppo(String idGruppo) throws AccountDoesNotExist;
    public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6) throws AccountDoesNotExist;

    
	
	
	// Rimuovi
	public boolean rimuoviCommento(String idCommento) throws AccountDoesNotExist;
	
	public boolean cercaCommento(String id)throws AccountDoesNotExist;
	public boolean cercaGruppo(String id)throws AccountDoesNotExist;
	
	public boolean selectAllCommentiSottoPost(Commento c)throws AccountDoesNotExist;
	public boolean selectAllGruppo()throws AccountDoesNotExist;
	
	
	public boolean vediMieiFollower(String id) throws AccountDoesNotExist;
	public boolean vediProfiloCercato(String profiloPersonale,String profiloSeguito) throws AccountDoesNotExist;
	
	public boolean accettaRichiestaDinvito();
	public boolean invitaUtenteAdIscriversi(Profilo p);
	
	
	
	public boolean aggiungiLike(Post p)throws AccountDoesNotExist;
	public boolean aggiungiDislike(Post p)throws AccountDoesNotExist;
	public boolean rimuoviLike(Post p)throws AccountDoesNotExist;
	public boolean rimuoviDislike(Post p)throws AccountDoesNotExist;
	}
