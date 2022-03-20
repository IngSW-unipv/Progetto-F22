package profilo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import chat.Chat;
import chat.chatPrivata.ChatPrivata;
import db.profilo.ProfiloDB;
import post.Post;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import profilo.exception.AccountDoesNotExist;
import profilo.exception.NotLoggedIn;


public interface IProfilo {



	public boolean profiloNonSeguito(String emailProfilo);//
	public boolean accountEsistente(String emailProfilo) throws AccountDoesNotExist;//
	public boolean seiLoggato(String emailProfilo) throws AccountDoesNotExist, NotLoggedIn;//

	public boolean segui(String email)throws AccountDoesNotExist, NotLoggedIn;//

	public ArrayList<ProfiloDB> mostraInformazioniProfilo() throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean pubblicaCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String post)throws AccountDoesNotExist, NotLoggedIn;// 
	
	public boolean smettiDiSeguire(String profiloSeguito) throws AccountDoesNotExist, NotLoggedIn;//
	
	//L'int time rappresenta la durata in ore nel quale la storia rimarrà pubblicata. A fine di time ore, la storia sarà rimossa automaticamente
    public boolean trasformaFotoInStoria(int time, Foto f);//
	public boolean trasformaVideoInStoria(int time, Video v);//
	
	public void visualizzaChat(Chat c);
	public boolean accettaRichiestaDinvito();
	public void apriChatPrivata(ChatPrivata c);
	public boolean invitaUtenteAdIscriversi(Profilo p);
	
	public ArrayList<ProfiloDB> ottieniListaProfilo() throws AccountDoesNotExist, NotLoggedIn;
	
	public void visualizzaPost(Post p);
	public boolean aggiungiSegnaLibro();
	public int modificaLike(Post p);

 
	public boolean aggiungiLike(Post p);
	public boolean aggiungiDislike(Post p);
	public boolean rimuoviLike(Post p);
	public boolean rimuoviDislike(Post p);
	
    public boolean scriviMessaggioPrivato(String id, Date dataInvio, Time oraInvio, String testo, String multimedia, String idProfiloInviante, String idProfiloRicevente)throws AccountDoesNotExist, NotLoggedIn;//
    public boolean scriviMessaggioDiGruppo(String id, Date dataInvio, Time oraInvio, String testo, String multimedia, String idGruppo)throws AccountDoesNotExist, NotLoggedIn;//
    public boolean rimuoviMessaggioPrivato(String idMessaggio) throws AccountDoesNotExist, NotLoggedIn;//
    public boolean rimuoviMessaggioDiGruppo(String idMessaggio) throws AccountDoesNotExist, NotLoggedIn;//
    public boolean creaGruppo(String idGruppo, String descrizione, String nomeGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6, String amministratore)throws AccountDoesNotExist, NotLoggedIn;//
    public boolean rimuoviGruppo(String idGruppo) throws AccountDoesNotExist, NotLoggedIn;//
    public boolean modificaPartecipantiGruppo(String idGruppo, String profilo1,String profilo2,String profilo3,String profilo4,String profilo5,String profilo6) throws AccountDoesNotExist, NotLoggedIn;//
    
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
	
	// Rimuovi
	public boolean rimuoviCommento(String idCommento) throws AccountDoesNotExist, NotLoggedIn;//
	
	public boolean rimuoviFoto(String idPost) throws AccountDoesNotExist, NotLoggedIn;//
	
	public boolean rimuoviVideo(String idPost)throws AccountDoesNotExist, NotLoggedIn; //
	
	public boolean rimuoviSondaggioSceltaMultipla(String idPost) throws AccountDoesNotExist, NotLoggedIn;//
	
	public boolean rimuoviSondaggioDoppiaVotazione(String idPost)  throws AccountDoesNotExist, NotLoggedIn;//
	
	public boolean rimuoviTesto(String idPost) throws AccountDoesNotExist, NotLoggedIn; //

	}
