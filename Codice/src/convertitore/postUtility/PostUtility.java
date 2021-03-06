package convertitore.postUtility;



import java.util.ArrayList;

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

	
	/**
	 * Converte un Post in un PostDB corrispondente al rispettivo tipo
	 * @param un oggetto di tipo Post "reale"
	 */
	public PostDB converti(Post p) {
		if(p.getTipo() == TipoPost.FOTO) {
			Foto f = (Foto) p.inserisciCaratteristiche(p);
			FotoDB fdb = new FotoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(),f.getTempoCancellazione(),f.getPercorso(),f.isStory(), f.isHd());
			return fdb;
		}
		else if(p.getTipo() == TipoPost.VIDEO) {
			Video f = (Video) p.inserisciCaratteristiche(p);
			VideoDB vdb = new VideoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(),f.getTempoCancellazione(), f.getPercorso(), f.isStory(),f.getDurataInSecondi());
			return vdb;
		}
		else if(p.getTipo() == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
			SondaggioDoppiaVotazione f = (SondaggioDoppiaVotazione) p.inserisciCaratteristiche(p);
			SondaggioDoppiaVotazioneDB sdv = new SondaggioDoppiaVotazioneDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(), f.getPrimaScelta(), f.getSecondaScelta(),0,0); 
			return sdv;
		}
		else if(p.getTipo() == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
			SondaggioSceltaMultipla f = (SondaggioSceltaMultipla) p.inserisciCaratteristiche(p);
			SondaggioSceltaMultiplaDB ssm = new SondaggioSceltaMultiplaDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(), f.getPrimaScelta(), f.getSecondaScelta(), f.getTerzaScelta(), f.getQuartaScelta(),0,0,0,0);
			return ssm;
		}
		else if(p.getTipo() == TipoPost.TESTO) {
			Testo f = (Testo) p.inserisciCaratteristiche(p);
			TestoDB tdb = new TestoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(), f.getFont(), f.getTitolo());
			return tdb;
		}
		
		return null;
	}
	
	
	/**
	 * Converte un PostDB in un Post in base al tipo
	 * @param Oggetto di tipo Post utilizzabile solo per eseguire le query
	 */
	public Post convertiInverso(PostDB p, TipoPost t) {
		
		if(t == TipoPost.FOTO) {
			FotoDB f = (FotoDB) p.inserisciCaratteristiche(p);
			Foto fdb = new Foto(f.getIdPost(), f.getDescrizione(), f.isVisibile(), f.getProfilo(), f.getPercorso(), f.isHd(), f.isStory());
			return fdb;
		}
		else if(t == TipoPost.VIDEO) {
			VideoDB f = (VideoDB) p.inserisciCaratteristiche(p);
			Video fdb = new Video(f.getIdPost(), f.getDescrizione(), f.isVisibile(), f.getProfilo(), f.getPercorso(), f.getDurataInSecondi(),f.isStory);
			return fdb;
		}
		else if(t == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
			SondaggioDoppiaVotazioneDB f = (SondaggioDoppiaVotazioneDB) p.inserisciCaratteristiche(p);
			SondaggioDoppiaVotazione sdv = new SondaggioDoppiaVotazione(f.getIdPost(), f.getDescrizione(), f.isVisibile(), f.getProfilo(), f.getPrimaScelta(), f.getSecondaScelta()); 
			return sdv;
		}
		else if(t == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
			SondaggioSceltaMultiplaDB f = (SondaggioSceltaMultiplaDB) p.inserisciCaratteristiche(p);
			SondaggioSceltaMultipla ssm = new SondaggioSceltaMultipla(f.getIdPost(), f.getDescrizione(), f.isVisibile(), f.getProfilo(), f.getPrimaScelta(), f.getSecondaScelta(), f.getTerzaScelta(), f.getQuartaScelta());
			return ssm;
		}
		else if(t == TipoPost.TESTO) {
			TestoDB f = (TestoDB) p.inserisciCaratteristiche(p);
			Testo tdb = new Testo(f.getIdPost(),f.getDescrizione(), f.isVisibile(), f.getProfilo(), f.getFont(), f.getTitolo());
			return tdb;
		}
		
		return null;
	}
	
	
	/**
	 * Metodo che ottiene le informazioni riguardo le chiavi esterne di tipo string ad un oggetto di tipo Post
	 * @return Vettore di stringhe con all'interno le informazioni relative alle chiavi esterne
	 */
	public String[] ritornaChiaviString(Post p) {
		String s[] = new String[4];
		
		for(int i = 0; i<4 ; i++)
			s[i] = null;
		
		if(p.getTipo() == TipoPost.FOTO) {
			Foto f = (Foto) p.inserisciCaratteristiche(p);
			FotoDB fdb = new FotoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(),f.getTempoCancellazione(),f.getPercorso(),f.isStory(), f.isHd());
			s[0] = fdb.getPercorso();
			return s;
		}
		if(p.getTipo() == TipoPost.VIDEO) {
			Video f = (Video) p.inserisciCaratteristiche(p);
			VideoDB vdb = new VideoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(),f.getTempoCancellazione(), f.getPercorso(), f.isStory(),f.getDurataInSecondi());
			s[0] = vdb.getPercorso();
			return s;
		}
		if(p.getTipo() == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
			SondaggioDoppiaVotazione f = (SondaggioDoppiaVotazione) p.inserisciCaratteristiche(p);
			SondaggioDoppiaVotazioneDB sdv = new SondaggioDoppiaVotazioneDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(), f.getPrimaScelta(), f.getSecondaScelta(),0,0); 
			s[0] = sdv.getPrimaScelta();
			s[1] = sdv.getSecondaScelta();
			return s;
		}
		if(p.getTipo() == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
			SondaggioSceltaMultipla f = (SondaggioSceltaMultipla) p.inserisciCaratteristiche(p);
			SondaggioSceltaMultiplaDB ssm = new SondaggioSceltaMultiplaDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(), f.getPrimaScelta(), f.getSecondaScelta(), f.getTerzaScelta(), f.getQuartaScelta(),0,0,0,0);
			s[0] = ssm.getPrimaScelta();
			s[1] = ssm.getSecondaScelta();
			s[2] = ssm.getTerzaScelta();
			s[3] = ssm.getQuartaScelta();
			return s;
		}
		if(p.getTipo() == TipoPost.TESTO) {
			Testo f = (Testo) p.inserisciCaratteristiche(p);
			TestoDB tdb = new TestoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(), f.getFont(), f.getTitolo());
			s[0] = tdb.getFont();
			s[1] = tdb.getTitolo();
			return s;
		}
		
		return null;
	}
	
	/**
	 * Metodo che ottiene le informazioni riguardo le chiavi esterne di tipo int ad un oggetto di tipo Post
	 * @return intero con all'interno le informazioni relative alla chiave esterna
	 */
	public int ritornaChiaviInt(Post p) {
		int s = 0;
		if(p.getTipo() == TipoPost.VIDEO) {
			Video f = (Video) p.inserisciCaratteristiche(p);
			VideoDB vdb = new VideoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(),f.getTempoCancellazione(), f.getPercorso(), f.isStory(),f.getDurataInSecondi());
			s = vdb.getDurataInSecondi();
			return s;
		}
		
		return -1;
	}
	
	/**
	 * Metodo che ottiene le informazioni riguardo le chiavi esterne di tipo boolean ad un oggetto di tipo Post
	 * @return boolean con all'interno le informazioni relative alla chiave esterna
	 */
	public boolean ritornaChiaviBoolean(Post p) {
		boolean s = false;
			
		if(p.getTipo() == TipoPost.FOTO) {
			Foto f = (Foto) p.inserisciCaratteristiche(p);
			FotoDB fdb = new FotoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(),f.getNumLike(),f.getNumDislike(), f.isVisibile(), f.getProfilo(),f.getTempoCancellazione(),f.getPercorso(),f.isStory(), f.isHd());
			s = fdb.isHd();
			return s;
		}

		return false;
	}
	

	/**
	 * Converte una lista di PostDB in una lista di Post
	 * @param ArrayList di PostDB, tipo utilizzabile solo nel database
	 */
	public ArrayList<Post> convertiLista(TipoPost t, ArrayList<PostDB> p){
		ArrayList<Post> res = new ArrayList<>();
		for(PostDB ps : p)
			res.add(this.convertiInverso(ps, t));
		return res;
	}
	
	
	/**
	 * Metodo che restituisce una istanza del tipo di post inserito 
	 * @param id dell'oggetto da costruire
	 * @param Tipo dell'oggetto da costruire
	 * @return istanza dell'oggetto costruito
	 */
    public static Post restituisciTipo(String id, TipoPost t) {
    	Post pst;
    	if(t == TipoPost.FOTO) {
    		pst = new Foto(id,null,false, null, null, false, true);
    		return pst;
    	}
    	else if(t == TipoPost.VIDEO) {
    		pst = new Video(id,null,false, null, null, 0, false);
    		return pst;
    		}
    	else if(t == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
    		pst = new SondaggioDoppiaVotazione(id,null,false, null, null, null);
    	    return pst;
    	}
    	else if (t == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
    		pst = new SondaggioSceltaMultipla(id,null,false, null, null, null, null, null);
    		return pst;
    	}
    	else if(t == TipoPost.TESTO) {
    		pst = new Testo(id,null,false, null, null, null);
    		return pst;
    	}
    	return null;
    }
	
	
	
	
	
	
	
	
	
	
	
}
