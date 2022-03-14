package profilo;


import java.util.ArrayList;
import java.util.HashMap;

import chat.Chat;
import post.Post;
import post.commento.Commento;
import profilo.exception.NotLoggedIn;


public interface IProfilo {

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
	public int mettiDislike();
	
	public int signUp();
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
