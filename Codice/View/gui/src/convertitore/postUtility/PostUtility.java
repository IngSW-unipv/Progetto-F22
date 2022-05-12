package convertitore.postUtility;

import db.post.PostDB;
import db.post.multimedia.foto.FotoDB;
import db.post.multimedia.video.VideoDB;
import db.post.sondaggio.sondaggiodoppiavotazione.SondaggioDoppiaVotazioneDB;
import db.post.sondaggio.sondaggiosceltamultipla.SondaggioSceltaMultiplaDB;
import db.post.testo.TestoDB;
import post.Post;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;

public class PostUtility {

	public PostDB converti(Post p) {
		if(p.getTipo() == TipoPost.FOTO) {
			Foto f = (Foto) p.inserisciCaratteristiche(p);
			FotoDB fdb = new FotoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), f.isVisibile(), f.isCondivisibile(), f.getProfilo(), f.getTempoCancellazione(), f.getPercorso(), f.isStory(), f.isHd());
			return fdb;
		}
		else if(p.getTipo() == TipoPost.VIDEO) {
			Video f = (Video) p.inserisciCaratteristiche(p);
			VideoDB vdb = new VideoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), f.isVisibile(), f.isCondivisibile(), f.getProfilo(), f.getTempoCancellazione(), f.getPercorso(), f.isStory(), f.getDurataInSecondi());
			return vdb;
		}
		else if(p.getTipo() == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
			SondaggioDoppiaVotazione f = (SondaggioDoppiaVotazione) p.inserisciCaratteristiche(p);
			SondaggioDoppiaVotazioneDB sdv = new SondaggioDoppiaVotazioneDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), f.isVisibile(), f.isCondivisibile(), f.getProfilo(), f.getPrimaScelta(), f.getSecondaScelta()); 
			return sdv;
		}
		else if(p.getTipo() == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
			SondaggioSceltaMultipla f = (SondaggioSceltaMultipla) p.inserisciCaratteristiche(p);
			SondaggioSceltaMultiplaDB ssm = new SondaggioSceltaMultiplaDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), f.isVisibile(), f.isCondivisibile(), f.getProfilo(), f.getPrimaScelta(), f.getSecondaScelta(), f.getTerzaScelta(), f.getQuartaScelta());
			return ssm;
		}
		else if(p.getTipo() == TipoPost.TESTO) {
			Testo f = (Testo) p.inserisciCaratteristiche(p);
			TestoDB tdb = new TestoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), f.isVisibile(), f.isCondivisibile(), f.getProfilo(), f.getFont(), f.getTitolo());
			return tdb;
		}
		
		return null;
	}
}
