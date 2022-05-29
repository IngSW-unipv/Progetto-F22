package post.sondaggio;

import post.Post;

public abstract class Sondaggio extends Post{

	public Sondaggio(String idPost, String descrizione, boolean visibile, String profilo, String primaScelta, 
			String secondaScelta) {
		super(idPost, descrizione, visibile,profilo);
		
		this.primaScelta = primaScelta;
		this.secondaScelta = secondaScelta;

	}
	private String primaScelta;
	private String secondaScelta;
  

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

	
	@Override
	public String toString() {
		return super.toString() + ", primaScelta = " + primaScelta + ", secondaScelta = " + secondaScelta ;
	}
	public String getPercorso() {
		return "null";
	}
	public abstract void aggiungiVoto(int n);
	public abstract void mostraRisultati();
	
	}

