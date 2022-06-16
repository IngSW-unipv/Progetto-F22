package post.sondaggio;

import post.Post;
import post.enumeration.TipoPost;

public class SondaggioSceltaMultipla extends Sondaggio{
	private String terzaScelta;
	private String quartaScelta;

	public SondaggioSceltaMultipla(String idPost, String descrizione, boolean visibile, String profilo, String primaScelta, String secondaScelta, 
								   String terzaScelta, String quartaScelta) {
		super(idPost, descrizione, visibile,	profilo, primaScelta, secondaScelta);
		this.terzaScelta = terzaScelta;
		this.quartaScelta = quartaScelta;

	}

	public SondaggioSceltaMultipla(String idSondaggio) {
		super(idSondaggio);
		this.terzaScelta = null;
		this.quartaScelta = null;
	}	
	
	@Override
	public String toString() {
		return super.toString() + ", terzaScelta = " + terzaScelta + ", quartaScelta = " + quartaScelta +  "]";
	}

	@Override
	public TipoPost getTipo() {
		return TipoPost.SONDAGGIOSCELTAMULTIPLA;
	}

	@Override
	public Post inserisciCaratteristiche(Post p) {
		p = new SondaggioSceltaMultipla(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.getProfilo(), this.getPrimaScelta(),
										this.getSecondaScelta(), this.getTerzaScelta(), this.getQuartaScelta());
		return p;
	}

	public String getTerzaScelta() {
		return terzaScelta;
	}
	
	public void setTerzaScelta(String terzaScelta) {
		this.terzaScelta = terzaScelta;
	}
	
	public String getQuartaScelta() {
		return quartaScelta;
	}
	
	public void setQuartaScelta(String quartaScelta) {
		this.quartaScelta = quartaScelta;
	}
}
