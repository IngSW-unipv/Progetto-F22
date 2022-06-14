package post.sondaggio;

import post.Post;
import post.enumeration.TipoPost;


public class SondaggioDoppiaVotazione extends Sondaggio{

 
	public SondaggioDoppiaVotazione(String idPost, String descrizione, 
			boolean visibile, String profilo, String primaScelta, String secondaScelta) {
		super(idPost,descrizione, visibile, profilo, primaScelta, secondaScelta);
	}
	public SondaggioDoppiaVotazione(String idPost) {
		super(idPost);
	}


	



	@Override
	public TipoPost getTipo() {
		return TipoPost.SONDAGGIODOPPIAVOTAZIONE;
	}

	@Override
	public Post inserisciCaratteristiche(Post p) {
		p = new SondaggioDoppiaVotazione(p.getIdPost(), p.getDescrizione(), p.isVisibile(), p.getProfilo(), this.getPrimaScelta(), this.getSecondaScelta());
		return p;
	}
}
