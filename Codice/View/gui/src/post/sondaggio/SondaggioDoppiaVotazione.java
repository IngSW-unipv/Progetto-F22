package post.sondaggio;

import java.util.Arrays;
import post.Post;
import post.enumeration.TipoPost;


public class SondaggioDoppiaVotazione extends Sondaggio{

 
	private int[] conteggio = new int[2];
	public SondaggioDoppiaVotazione(String idPost, String descrizione, 
			boolean visibile, String profilo, String primaScelta, String secondaScelta, int [] conteggio) {
		super(idPost,descrizione, visibile, profilo, primaScelta, secondaScelta);
		this.conteggio = conteggio;
	}

	public void azzeraConteggio(int [] c) {
		for(int i = 0; i < 2; i++)
			c[i] = 0;
	}
	
	

@Override
public String toString() {
	return super.toString() + ", conteggio = " + Arrays.toString(conteggio) + "]";
}


public int[] getConteggio() {
	return conteggio;
}

public void setConteggio(int[] conteggio) {
	this.conteggio = conteggio;
}

@Override
public TipoPost getTipo() {
	return TipoPost.SONDAGGIODOPPIAVOTAZIONE;
}

@Override
public Post inserisciCaratteristiche(Post p) {
	p = new SondaggioDoppiaVotazione(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.getProfilo(), this.getPrimaScelta(), this.getSecondaScelta(), this.getConteggio());
	return p;
}

}
