package profilo;


import java.util.ArrayList;
import java.util.HashMap;
import Utente.Credenziali;
import Utente.Utente;
import chat.Chat;
import db.profilo.ProfiloDB;

import post.Post;
import post.commento.Commento;

public interface IProfilo {

	public ArrayList<ProfiloDB> selectAll();
	
	public HashMap<String, String> modificaFollow(Profilo p);
	public boolean modificaLike(Profilo p);
	public ArrayList<ProfiloDB> cercaProfilo(ProfiloDB p) throws Exception;
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

	Profilo creaProfilo(String idProfilo, String nickname, String descrizione, int numFollower, int numSeguiti,
			int numPost, EnumProfilo tipo, String messaggioDiGruppo, String messaggioPrivato, String utente,
			String post);
	
	}
