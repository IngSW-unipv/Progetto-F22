package post.sondaggio;

import java.sql.Date;
import java.sql.Time;

import it.unipv.ings.Sondaggio.SondaggioDB;
import it.unipv.ings.Sondaggio.SondaggioDao;
import post.Post;

public abstract class Sondaggio extends Post{

	public Sondaggio(String idPost, Date dataPubblicazione, Time oraPubblicazione, String descrizione, int numLike,
			int numDislike, boolean visibile, boolean isStory, boolean condivisibile, String profilo, String primaScelta, 
			String secondaScelta, String idSondaggio) {
		super(idPost, dataPubblicazione, oraPubblicazione, descrizione, numLike, numDislike, visibile, isStory, condivisibile,profilo);
		
		this.primaScelta = primaScelta;
		this.secondaScelta = secondaScelta;
		this.idSondaggio = idSondaggio;

	}
	private String primaScelta;
	private String secondaScelta;
    private String idSondaggio;   
 

	public String getPrimaScelta() {
		return primaScelta;
	}
	public void setPrimaScelta(String primaScelta) {
		this.primaScelta = primaScelta;
	}
	public String getSecondaScelta() {
		return secondaScelta;
	}
	public void setSecondaScelta(String secondaScelta) {
		this.secondaScelta = secondaScelta;
	}
	public String getIdSondaggio() {
		return idSondaggio;
	}
	public void setIdSondaggio(String idSondaggio) {
		this.idSondaggio = idSondaggio;
	}
	
	public abstract void aggiungiVoto(int n);
	public abstract void mostraRisultati();
	
	public boolean pubblicaSondaggio(SondaggioDB s) {
		SondaggioDao sdao = new SondaggioDao();
		boolean b;
		b = sdao.pubblicaSondaggio(s);
		return b;
	}

	public boolean rimuoviSondaggio(SondaggioDB s) {
		SondaggioDao sdao = new SondaggioDao();
		boolean b;
		b = sdao.rimuoviSondaggio(s);
		return b;
	}
}
