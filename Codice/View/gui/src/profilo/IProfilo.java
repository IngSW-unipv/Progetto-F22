package profilo;


import java.util.ArrayList;
import java.util.HashMap;

import Utente.Utente;
import Utente.credenziali.Credenziali;
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
	public void bloccaUtente(Utente u); // o restituisce una stringa( che dice l'utente è bloccato).
	public void mostraInformazioniProfilo(Profilo p);
	
	public void mostraInformazioniPost(Post p);  // Chiama il metodo selectAll() del database.
	public Profilo creaProfilo(Profilo p);
	public boolean modificaDatiPersonali(Credenziali c);
	public boolean visualizzaProprioPost(Post p);
	
	public boolean eliminaProfilo(ProfiloDB p);
	public Chat cercaChatAttiva(Chat chat);
	public Chat visualizzaChatAttiva(Chat chat);
	public Post segnaLibro(Post p);
	
	}
