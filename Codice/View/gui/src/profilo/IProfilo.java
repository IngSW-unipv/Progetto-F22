package profilo;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;

import chat.Chat;
import chat.chatDiGruppo.gruppo.Gruppo;
import chat.chatPrivata.ChatPrivata;
import db.profilo.ProfiloDB;
import post.Post;
import post.commento.Commento;
import profilo.exception.AccountDoesNotExist;
import profilo.credenziali.Credenziali;
import profilo.exception.NotLoggedIn;


public interface IProfilo {

	public boolean segui(String email)throws AccountDoesNotExist, NotLoggedIn;
	/*
	public int personalizzaSfondo();
	public int visualizzaChat();
	public int modificaDatiChat();
	public int cancellaMessaggio();
	public int scriviMessaggio();
	public int entraInGruppo();
	public int accettaRichiestaDinvito();
	public int apriChatPrivata();
	public int invitaUtenteAdIscriversi();
	public int posta();
	public int eliminaUnPost();
	public int modificaPost();
	public int commentaPost();
	public int visualizzaPost();
	public int aggiungiSegnaLibro();
	public int mettiDislike();*/

	public boolean personalizzaSfondo();
	public void visualizzaChat(Chat c);
	public boolean modificaDatiChat(Chat c);
	public boolean cancellaMessaggio();
	public boolean scriviMessaggio();
	public boolean entraInGruppo(Gruppo g);
	public boolean accettaRichiestaDinvito();
	public void apriChatPrivata(ChatPrivata c);
	public boolean invitaUtenteAdIscriversi(Profilo p);
	
	public ArrayList<ProfiloDB> ottieniListaProfilo() throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean posta(Post p);
	public boolean eliminaUnPost(Post p);
	public boolean modificaPost(Post p);
	
	
	public void visualizzaPost(Post p);
	public boolean aggiungiSegnaLibro();
	public int modificaLike(Post p);

	
	public void mostraInformazioniProfilo();
	public boolean signIn() throws Exception;
	public void bloccaProfilo(Profilo p);
	public Credenziali modificaDatiPersonali(Credenziali c);
	
	//Pubblicazioni
	public boolean pubblicaFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile,
			                     boolean condivisibile, String profilo, String percorso, boolean isHd) throws AccountDoesNotExist, 
	                             NotLoggedIn; 
	
	public boolean pubblicaVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, 
			                      boolean condivisibile, String profilo, String percorso, int durataInSecondi) throws AccountDoesNotExist, 
                                  NotLoggedIn;
	
	public boolean pubblicaSondaggioSceltaMultipla(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, 
			                                        boolean visibile, boolean condivisibile, String profilo, String primaScelta, 
			                                        String secondaScelta, int [] conteggio) throws AccountDoesNotExist, NotLoggedIn; 
	
	public boolean pubblicaSondaggioDoppiaVotazione(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
			                                         boolean visibile, boolean condivisibile, String profilo,String primaScelta, 
			                                         String secondaScelta, String terzaScelta, String quartaScelta, int [] conteggio)
	                                                  throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean pubblicaTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
			                      boolean visibile, boolean condivisibile, String profilo, String font, String titolo)
			                      throws AccountDoesNotExist, NotLoggedIn;
	
	// Rimuovi
	public boolean rimuoviCommento(String idCommento, Time oraCommento, Date dataCommento, String testo, String post) throws AccountDoesNotExist,
	                                NotLoggedIn;
	
	public boolean rimuoviFoto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, 
			                   boolean condivisibile, String profilo, String percorso, boolean isHd) throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean rimuoviVideo(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, boolean visibile, 
			                     boolean condivisibile, String profilo, String percorso, int durataInSecondi)throws AccountDoesNotExist, 
	                             NotLoggedIn;
	
	public boolean rimuoviSondaggioSceltaMultipla(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, 
                                                   boolean visibile, boolean condivisibile, String profilo, String primaScelta, 
                                                    String secondaScelta, int [] conteggio) throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean rimuoviSondaggioDoppiaVotazione(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
                                                    boolean visibile, boolean condivisibile, String profilo,String primaScelta, 
                                                    String secondaScelta, String terzaScelta, String quartaScelta, int [] conteggio)
                                                    throws AccountDoesNotExist, NotLoggedIn;
	
	public boolean rimuoviTesto(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione,
                                 boolean visibile, boolean condivisibile, String profilo, String font, String titolo)
                                 throws AccountDoesNotExist, NotLoggedIn;
	
	
	
	
	/*public ArrayList<ProfiloDB> selectAll();
	public HashMap<String, String> modificaFollow(Profilo p);
	
	public boolean modificaLike(Profilo p);
	public boolean modificaDislike(Profilo profilo);
	
	public void vediStory();  // con tipo Story(da modificare)
	public boolean commentare(Commento c);
	public void bloccaUtente(Utente u); // o restituisce una stringa( che dice l'utente � bloccato).
	public void mostraInformazioniProfilo(Profilo p);
	
	public void mostraInformazioniPost(Post p);  // Chiama il metodo selectAll() del database.
	public boolean modificaDatiPersonali(Credenziali c);
	public boolean visualizzaProprioPost(Post p);
	
	public boolean eliminaProfilo(ProfiloDB p);
	public Chat cercaChatAttiva(Chat chat);
	public Chat visualizzaChatAttiva(Chat chat);
	public Post segnaLibro(Post p);
	
	
	*/

	

	

	}
