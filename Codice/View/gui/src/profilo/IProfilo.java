package profilo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import chat.Chat;
import chat.chatDiGruppo.gruppo.Gruppo;
import chat.chatPrivata.ChatPrivata;
import db.profilo.ProfiloDB;
import post.Post;
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

	public void visualizzaChat(Chat c);
	public boolean modificaDatiChat(Chat c);
	public boolean cancellaMessaggio();
	public boolean scriviMessaggio();
	public boolean entraInGruppo(Gruppo g);
	public boolean accettaRichiestaDinvito();
	public void apriChatPrivata(ChatPrivata c);
	public boolean invitaUtenteAdIscriversi(Profilo p);
	
	public ArrayList<ProfiloDB> ottieniListaProfilo() throws AccountDoesNotExist, NotLoggedIn;
	
	public void visualizzaPost(Post p);
	public boolean aggiungiSegnaLibro();
	public int modificaLike(Post p);

	//Pubblicazioni
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
