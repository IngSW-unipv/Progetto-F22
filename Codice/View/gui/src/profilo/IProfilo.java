package profilo;


import java.util.HashMap;

import Utente.Utente;
import post.Post;

public interface IProfilo {

	public HashMap<String, String> modificaFollow(Profilo p);
	public boolean modificaLike(Profilo p);
	public Profilo cercaProfilo(Profilo p);
	public boolean modificaDislike(Profilo profilo);
	public void vediStory();  // con tipo Story(da modificare)
	public void commentare(String testo);
	public String bloccaUtente(Utente u); // O profilo.
	public void mostraInformazioniProfiloPubblico(Profilo p);
	public void mostraInformazioniProfiloPrivato(Profilo p);
	public void mostraInformazioniPost(Post p);
	
	}
