package profilo;

import java.util.ArrayList;
import java.util.HashMap;

import chat.Chat;
import chat.chatDiGruppo.gruppo.Gruppo;
import chat.chatPrivata.ChatPrivata;
import post.Post;
import post.commento.Commento;
import profilo.exception.AccountDoesNotExist;
import profilo.credenziali.Credenziali;
import profilo.exception.NotLoggedIn;


public interface IProfilo {


	public boolean segui(String email)throws AccountDoesNotExist, NotLoggedIn;
	public boolean personalizzaSfondo();
	public void visualizzaChat(Chat c);
	public boolean modificaDatiChat(Chat c);
	public boolean cancellaMessaggio();
	public boolean scriviMessaggio();
	public boolean entraInGruppo(Gruppo g);
	public boolean accettaRichiestaDinvito();
	public void apriChatPrivata(ChatPrivata c);
	public boolean invitaUtenteAdIscriversi(Profilo p);
	
	public boolean posta(Post p);
	public boolean eliminaUnPost(Post p);
	public boolean modificaPost(Post p);
	public boolean commentaPost(Post p);
	public void visualizzaPost(Post p);
	public boolean aggiungiSegnaLibro();
	public int modificaLike(Post p);
	
	public void mostraInformazioniProfilo();
	public boolean signIn() throws Exception;
	public void bloccaProfilo(Profilo p);
	public Credenziali modificaDatiPersonali(Credenziali c);
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
