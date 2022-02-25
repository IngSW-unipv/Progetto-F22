package Sistema;

import Profilo.Profilo;
import it.unipv.ings.Post.*;
import Utente.Utente;
import it.unipv.ings.Profilo.*;
import post.Post;

public class Sistema {

	private Profilo profiloAttivo;
	private Profilo altroProfilo;
	private Utente u;
	private Post post;
	
	public Sistema() {
		
	}
	
	public boolean creaProfilo(String idProfilo, String nickname, String descrizione, int numFollower, int numSeguiti, int numPost,
			String tipo, String messaggioDiGruppo, String messaggioPrivato, String utente, String post) {
	     
		//Per Francesco
		//Bisogna usare la funzione di profiloDao
		//simile a scrivi messaggio di chatPrivata
		Utente u = new Utente();
		ProfiloDao p = new ProfiloDao();
		Profilo profiloCreato = new Profilo(idProfilo, nickname, descrizione, numFollower, numSeguiti, numPost, tipo, messaggioDiGruppo, messaggioPrivato, utente, post);
		boolean b;
		if(verificaEsistenzaAccount(u.getCredenziali().getEMail())) {
			b = p.inserisciProfilo(profiloCreato);
		}
		return b;
		//	profiloAttivo = new Profilo(nickname, pwd);
	}
	public boolean eliminaProfilo(Profilo p) {
		boolean b;
		ProfiloDao pd = new ProfiloDao();
		b = pd.rimuoviProfilo(p);
		return b;
	}
/*
	public boolean login(String eMail, String pwd) {
		verificaEsistenzaAccount(eMail);
		//codice per prelevare da sql un oggetto profilo
		Profilo profiloChiamato = ProfiloPrelevato();
		if (profiloChiamato.getPwd() == pwd)
		return true;
	    else
		return false;
	}
    */
	public boolean verificaEsistenzaAccount(String eMail) { //bisogna mettere le exception
		
		ProfiloDao pd = new ProfiloDao();
		Utente u = new Utente(); //servono le credenziali per l'utente
		
		for(Profilo altroProfilo : pd.selectAll()) {
			if(eMail == u.getCredenziali().getEMail()) {
				return true;
			}
		}
		
		return false;
	}
	
	public boolean mettiLike(Post p) {
		p.setNumLike(p.getNumLike() + 1);
		return true;
	}
	
	public boolean togliLike(Post p) {
		p.setNumLike(p.getNumLike() - 1);
		return true;
	}
	
	public boolean mettiDislike(Post p) {
		p.setNumLike(p.getNumDislike() + 1);
		return true;
	}
	
	public boolean togliDislike(Post p) {
		p.setNumLike(p.getNumDislike() - 1);
		return true;
	}
	
	public void segui() {
		//codice da recuperare da database
		profiloAttivo.setNumFollower(altroProfilo.getNumFollower() + 1);
	}
	public void smettiDiSeguire() {
		profiloAttivo.setNumFollower(altroProfilo.getNumFollower() - 1);
	}
	
	public boolean pubblicaPost(Post p) {
		boolean b = post.pubblicaPost(p);
		return b;
	}
	
	public boolean rimuoviPost(Post p) {
		boolean b = post.rimuoviPost(p);
		return b;
	}
}
