package profilo;


import java.util.ArrayList;

import java.util.HashMap;

import Messaggio.Messaggio;
import chat.Chat;
import chat.chatPrivata.ChatPrivata;
import post.Post;
import post.commento.Commento;
import profilo.exception.NotLoggedIn;


public interface IProfilo {

	// public void personalizzaSfondo();
	public void visualizzaChat(Chat chat);
	public boolean modificaDatiChat(Chat chat);
	public boolean cancellaMessaggio(Messaggio m);
	public boolean scriviMessaggio(Messaggio m);
	
	public  void entraInGruppo();
	public boolean accettaRichiestaDinvito();
	public void apriChatPrivata(ChatPrivata chat);
	public void invitaUtenteAdIscriversi();
	
	public Post posta(Post p);
	public boolean eliminaUnPost();
	public boolean modificaPost();
	public String commentaPost();
	
	public void visualizzaPost(Post p);
	public boolean aggiungiSegnaLibro();
	public boolean mettiDislike();
	public boolean signUp();
	
	
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
	
	public boolean caricaPost(Post p);
	public boolean rimuoviPost(Post p);
	*/

	}
