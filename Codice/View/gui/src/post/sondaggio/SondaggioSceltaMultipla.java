package post.sondaggio;

import java.util.Arrays;
import post.Post;
import post.enumeration.TipoPost;

public class SondaggioSceltaMultipla extends Sondaggio{

	public SondaggioSceltaMultipla(String idPost, String descrizione,
			boolean visibile, String profilo,
			String primaScelta, String secondaScelta, String terzaScelta, String quartaScelta, int [] conteggio) {
		super(idPost, descrizione, visibile,	profilo, primaScelta, secondaScelta);
		this.terzaScelta = terzaScelta;
		this.quartaScelta = quartaScelta;
		this.conteggio = conteggio;
	}

	private String terzaScelta;
	private String quartaScelta;
	private int [] conteggio = new int [4];
	
	public void azzeraConteggio(int [] conteggio) {
		for(int i = 0; i < 3; i++)
			conteggio[i] = 0;
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

	public int[] getConteggio() {
		return conteggio;
	}

	public void setConteggio(int[] conteggio) {
		this.conteggio = conteggio;
	}


	@Override
	public String toString() {
		return super.toString() + ", terzaScelta = " + terzaScelta + ", quartaScelta = " + quartaScelta + ", conteggio = "
				+ Arrays.toString(conteggio) + "]";
	}

	@Override
	public TipoPost getTipo() {
		return TipoPost.SONDAGGIOSCELTAMULTIPLA;
	}

	@Override
	public Post inserisciCaratteristiche(Post p) {
		
		p = new SondaggioSceltaMultipla(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.getProfilo(), this.getPrimaScelta(), this.getSecondaScelta(), this.getTerzaScelta(), this.getQuartaScelta(), this.getConteggio());


		return p;
	}
}
