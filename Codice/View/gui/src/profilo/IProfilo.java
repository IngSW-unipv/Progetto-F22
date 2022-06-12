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
import post.sondaggio.Sondaggio;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.AzioneNonConsentita;
import profilo.exception.PostNonPresente;
import profilo.exception.PostNonVisibile;
import profilo.exception.TastoNonEsistente;
import profilo.follow.Follow;

public interface IProfilo {
 
	public MessaggioDiGruppo creaMessaggioDiGruppo(String id, Date dataInvio, Time oraInvio, String testo, String multimedia,String profiloInviante,String idGruppo);
	public MessaggioPrivato creaMessaggioPrivato(String id, String testo, String multimedia,String idProfiloInviante, String idProfiloRicevente);
	public boolean scriviMessaggio(Messaggio m);
	public boolean rimuoviMessaggio(Messaggio m);
	public Messaggio cercaMessaggio(Messaggio m);
	public String ottieniTestoMessaggio(Messaggio m);
    //Legge tutti i messaggi ricevuti ogni minuto da un profilo o un gruppo precisato(In base al tipo di messaggio).Dopo 5 minuti smette di farlo e si stoppa
	public boolean leggiMessaggi(String profiloInviante,String profiloRicevente, TipoMessaggio t);
    
	//Legge tutti i messaggi ricevuti ogni minuto da un profilo o un gruppo precisato(In base al tipo di messaggio).Dopo 5 minuti smette di farlo e si stoppa
	//A differenza del metodo leggiMessaggi, verranno restituite solo le informazioni riguardanti il testo del messaggio
	public boolean leggiSoloTesto(String profiloInviante,String profiloRicevente, TipoMessaggio t);
	public Foto creaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String percorso, boolean isHd);
	public Video creaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String percorso, int durataInSecondi);
	public SondaggioDoppiaVotazione creaSondaggioSD(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String primaScelta, String secondaScelta);
	public SondaggioSceltaMultipla creaSondaggioDM(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta);
	public Testo creaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, String profilo, String font, String titolo);
	public boolean pubblicaPost(Post p);
	public boolean rimuoviPost(Post p);
    public Post cercaPost(Post p)throws PostNonVisibile, PostNonPresente;
	public ArrayList<Post> selectAllPost(TipoPost t);
    public boolean pubblicaStoria(int time, Multimedia f);
    public String ottieniPercorso(Post p)throws PostNonVisibile;
    public ArrayList<Commento> selectAllCommentiSottoPost(Post p)throws PostNonVisibile;
	public ArrayList<String> testoCommentiPost(Post p)throws PostNonVisibile;
	public boolean vediVisibilita(Post p);
	public boolean modificaVisibilita(Post p, boolean b);
	public boolean aggiungiVotoSondaggio(Sondaggio s)throws TastoNonEsistente;
	public void vediRisultatiSondaggio(Sondaggio s);
    public Profilo cercaProfilo(Profilo p)throws AccountDoesNotExist;
    public boolean cambiaImmagineProfilo(Profilo p, String immagine);
    public String ottieniImmagineProfilo(Profilo p);
    public ArrayList<Messaggio> selezionaMessaggiProfilo(Profilo p, TipoMessaggio t);
	public ArrayList<String> selezionaTestoMessaggiProfilo(Profilo p, TipoMessaggio t);  
	public ArrayList<String> caricaTuttiiPostDiUnProfilo(Profilo p, TipoPost f);
	public String vediNickname(Profilo p);
	public boolean modificaNickname(Profilo p, String n);
	public String vediDescrizione(Profilo p);
	public boolean modificaDescrizione(Profilo p, String n);
    public Commento creaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String profilo, String idFoto,String idVideo,String idSDV,String idSSM, String idTesto); 
	public Commento cercaCommento(Commento c);
	public ArrayList<String> ProfiloNickCommento(Profilo p);
	public boolean profiloNonSeguito(String emailProfilo);
	public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist;
	public boolean segui(Profilo email)throws AccountDoesNotExist, AzioneNonConsentita;
	public boolean smettiDiSeguire(Profilo profiloSeguito) throws AccountDoesNotExist, AzioneNonConsentita;
	public ArrayList<String> vediMieiFollower(Follow f);
	public Follow cercaFollow(Follow f);
	public boolean creaGruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6, String amministratore, String fotoGruppo) throws AccountDoesNotExist;
	public boolean rimuoviGruppo(Gruppo g);
	public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6, String fotoGruppo);
    public Gruppo cercaGruppo(Gruppo g);
	public ArrayList<Gruppo> selectAllGruppo();
	public boolean modificaFotoGruppo(Gruppo g, String s);
	public String vediFotoGruppo(Gruppo g);
	public boolean aggiungiLike(Post p)throws AzioneNonConsentita;
	public boolean aggiungiDislike(Post p)throws AzioneNonConsentita;
	public boolean rimuoviLike(Post p)throws AzioneNonConsentita;
	public boolean rimuoviDislike(Post p)throws AzioneNonConsentita;
	boolean creaGruppo(String descrizione, String nomeGruppo, String profilo1, String profilo2, String profilo3,
			String profilo4, String profilo5, String profilo6, String amministratore, String fotoGruppo)
			throws AccountDoesNotExist;
	boolean aggiungiVotoSondaggio(String idSondaggio, int scelta)
			throws TastoNonEsistente, PostNonVisibile, PostNonPresente;
	boolean pubblicaCommento(String idProfilo, String idPost, String testoCommento);
	boolean rimuoviCommento(String idCommento);
	Commento cercaCommento(String idCommento);
	boolean cambiaImmagineProfilo(String immagine);
	boolean modificaDescrizione(String idProfilo, String n);
	boolean modificaDescrizione(String n);
	boolean aggiungiPartecipante(String idGruppo, String idProfilo);
	boolean rimuoviPartecipante(String idGruppo, String idProfilo);
}

