package profilo;

import java.sql.Date;
import java.sql.Time;
import Messaggio.Messaggio;
import Messaggio.MessaggioDiGruppo;
import Messaggio.MessaggioPrivato;
import Messaggio.enumeration.TipoMessaggio;
import post.Post;
import post.commento.Commento;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.NotLoggedIn;


public interface IProfilo {



	public boolean profiloNonSeguito(String emailProfilo);//
	public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist;//
	public boolean seiLoggato(String emailProfilo) throws AccountDoesNotExist, NotLoggedIn;//

	public boolean segui(String email)throws AccountDoesNotExist, NotLoggedIn;//
	public boolean smettiDiSeguire(String profiloSeguito) throws AccountDoesNotExist, NotLoggedIn;
 
	
	//Messaggi
	
	public MessaggioDiGruppo creaMessaggioDiGruppo(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,String idGruppo);
	public MessaggioPrivato creaMessaggioPrivato(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,String idProfiloInviante, String idProfiloRicevente);
	public boolean scriviMessaggio(Messaggio m) throws AccountDoesNotExist, NotLoggedIn;
	public boolean rimuoviMessaggio(Messaggio m) throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean cercaMessaggio(String id, TipoMessaggio t)throws AccountDoesNotExist, NotLoggedIn;
	
	
    //Legge tutti i messaggi ricevuti ogni minuto da un profilo o un gruppo precisato(In base al tipo di messaggio).Dopo 5 minuti smette di farlo e si stoppa
	public boolean leggiMessaggi(Messaggio m) throws AccountDoesNotExist, NotLoggedIn;
    
	//Legge tutti i messaggi ricevuti ogni minuto da un profilo o un gruppo precisato(In base al tipo di messaggio).Dopo 5 minuti smette di farlo e si stoppa
	//A differenza del metodo leggiMessaggi, verranno restituite solo le informazioni riguardanti il testo del messaggio
	public boolean leggiSoloTesto(Messaggio m)throws AccountDoesNotExist, NotLoggedIn;
	
	
	
	//Post
	public Foto creaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, boolean isHd);
	public Video creaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String percorso, int durataInSecondi);
	public SondaggioDoppiaVotazione creaSondaggioSD(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String primaScelta, String secondaScelta, int [] conteggio);
	public SondaggioSceltaMultipla creaSondaggioDM(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta, int [] conteggio);
	public Testo creaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, boolean condivisibile, String profilo, String font, String titolo);
	
	public boolean pubblicaPost(Post p);
	
	public boolean pubblicaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile,
            boolean condivisibile, String profilo, String percorso, boolean isHd) throws AccountDoesNotExist, 
            NotLoggedIn; //

public boolean pubblicaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, 
             boolean condivisibile, String profilo, String percorso, int durataInSecondi) throws AccountDoesNotExist, 
             NotLoggedIn; //

public boolean pubblicaSondaggioSceltaMultipla(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, 
                               boolean visibile, boolean condivisibile, String profilo, String primaScelta, 
                               String secondaScelta, int [] conteggio) throws AccountDoesNotExist, NotLoggedIn; //

public boolean pubblicaSondaggioDoppiaVotazione(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
                                boolean visibile, boolean condivisibile, String profilo,String primaScelta, 
                                String secondaScelta, String terzaScelta, String quartaScelta, int [] conteggio)
                                 throws AccountDoesNotExist, NotLoggedIn;//

public boolean pubblicaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
             boolean visibile, boolean condivisibile, String profilo, String font, String titolo)
             throws AccountDoesNotExist, NotLoggedIn;//
	
public boolean rimuoviFoto(String idPost) throws AccountDoesNotExist, NotLoggedIn;//

public boolean rimuoviVideo(String idPost)throws AccountDoesNotExist, NotLoggedIn; //

public boolean rimuoviSondaggioSceltaMultipla(String idPost) throws AccountDoesNotExist, NotLoggedIn;//

public boolean rimuoviSondaggioDoppiaVotazione(String idPost)  throws AccountDoesNotExist, NotLoggedIn;//

public boolean rimuoviTesto(String idPost) throws AccountDoesNotExist, NotLoggedIn; //
	
	
	
	
	
	
	
	
	
	
    //-----------------------------------------------------------------------------------------------------------------------------
	
	//L'int time rappresenta la durata in ore nel quale la storia rimarrà pubblicata. A fine di time ore, la storia sarà rimossa automaticamente
    public boolean trasformaFotoInStoria(int time, Foto f)throws AccountDoesNotExist, NotLoggedIn;
	public boolean trasformaVideoInStoria(int time, Video v)throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean pubblicaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String post)throws AccountDoesNotExist, NotLoggedIn;// 
	
    
    public boolean creaGruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6, String amministratore)throws AccountDoesNotExist, NotLoggedIn;//
    public boolean rimuoviGruppo(String idGruppo) throws AccountDoesNotExist, NotLoggedIn;//
    public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6) throws AccountDoesNotExist, NotLoggedIn;//

    
	
	
	// Rimuovi
	public boolean rimuoviCommento(String idCommento) throws AccountDoesNotExist, NotLoggedIn;//
	

	public boolean cercaProfilo(String id)throws AccountDoesNotExist, NotLoggedIn;
	public boolean cercaCommento(String id)throws AccountDoesNotExist, NotLoggedIn;
	public boolean cercaFoto(String id)throws AccountDoesNotExist, NotLoggedIn;
	public boolean cercaGruppo(String id)throws AccountDoesNotExist, NotLoggedIn;
	public boolean cercaSondaggioDoppiaVotazione(String id)throws AccountDoesNotExist, NotLoggedIn;
	public boolean cercaSondaggioSceltaMultipla(String id)throws AccountDoesNotExist, NotLoggedIn;
	public boolean cercaTesto(String id)throws AccountDoesNotExist, NotLoggedIn;
	public boolean cercaVideo(String id)throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean selectAllCommentiSottoPost(Commento c)throws AccountDoesNotExist, NotLoggedIn;
	public boolean selectAllFoto()throws AccountDoesNotExist, NotLoggedIn;
	public boolean selectAllGruppo()throws AccountDoesNotExist, NotLoggedIn;
	public boolean selectAllSondaggioDoppiaVotazione()throws AccountDoesNotExist, NotLoggedIn;
	public boolean selectAllSondaggioSceltaMultipla()throws AccountDoesNotExist, NotLoggedIn;
	public boolean selectAllTesto()throws AccountDoesNotExist, NotLoggedIn;
	public boolean selectAllVideo()throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean vediMieiFollower(String id) throws AccountDoesNotExist, NotLoggedIn;
	public boolean vediProfiloCercato(String profiloPersonale,String profiloSeguito) throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean accettaRichiestaDinvito();
	public boolean invitaUtenteAdIscriversi(Profilo p);
	
    public boolean stampaInfoProfilo() throws AccountDoesNotExist, NotLoggedIn;
	

	public boolean aggiungiSegnaLibro();
	
	public boolean aggiungiLike(Post p)throws AccountDoesNotExist, NotLoggedIn;
	public boolean aggiungiDislike(Post p)throws AccountDoesNotExist, NotLoggedIn;
	public boolean rimuoviLike(Post p)throws AccountDoesNotExist, NotLoggedIn;
	public boolean rimuoviDislike(Post p)throws AccountDoesNotExist, NotLoggedIn;
	}
