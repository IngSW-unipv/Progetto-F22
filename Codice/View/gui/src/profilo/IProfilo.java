package profilo;


import java.util.HashMap;

import Utente.Credenziali;
import Utente.Utente;
import chat.Chat;
import post.Post;

public interface IProfilo {

	public HashMap<String, String> modificaFollow(Profilo p);
	public boolean modificaLike(Profilo p);
	public Profilo cercaProfilo(Profilo p) throws Exception;
	public boolean modificaDislike(Profilo profilo);
	public void vediStory();  // con tipo Story(da modificare)
	public String commentare(String testo);
	public String bloccaUtente(Utente u); // O profilo.
	public void mostraInformazioniProfilo(Profilo p);
	public void mostraInformazioniPost(Post p);
	public Profilo creaProfilo(Profilo p);
	public boolean modificaDatiPersonali(Credenziali c);
	public boolean visualizzaProprioPost(Post p);
	public Profilo eliminaProfilo(Profilo p);
	public Chat cercaChatAttiva(Chat chat);
	public Chat visualizzaChatAttiva(Chat chat);
	public Post segnaLibro(Post p);
	
	}
