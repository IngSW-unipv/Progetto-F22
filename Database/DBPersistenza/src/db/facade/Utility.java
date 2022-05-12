package db.facade;

import Messaggio.enumeration.TipoMessaggio;
import db.messaggio.MessaggioDao;
import db.messaggio.messaggioDiGruppo.MessaggioDiGruppoDao;
import db.messaggio.messaggioPrivato.MessaggioPrivatoDao;
import db.post.PostDao;
import db.post.multimedia.foto.FotoDao;
import db.post.multimedia.video.VideoDao;
import db.post.sondaggio.sondaggiodoppiavotazione.SondaggioDoppiaVotazioneDao;
import db.post.sondaggio.sondaggiosceltamultipla.SondaggioSceltaMultiplaDao;
import db.post.testo.TestoDao;
import post.enumeration.TipoPost;

public class Utility {

	public static MessaggioDao convertiTipoMessaggio(TipoMessaggio m) {
		if(m == TipoMessaggio.PRIVATO) {
			MessaggioPrivatoDao mpdao = new MessaggioPrivatoDao();
			return mpdao;
		}
		else if(m == TipoMessaggio.DIGRUPPO) {
			MessaggioDiGruppoDao mgdao = new MessaggioDiGruppoDao();
			return mgdao;
		}
		return null;
	}
	
	public static PostDao convertiTipoPost(TipoPost t) {
		if(t == TipoPost.FOTO) {
			FotoDao fdao = new FotoDao();
			return fdao;
		}
		else if(t == TipoPost.VIDEO) {
			VideoDao vdao = new VideoDao();
			return vdao;
		}
		else if(t == TipoPost.SONDAGGIODOPPIAVOTAZIONE) {
			SondaggioDoppiaVotazioneDao sdao = new SondaggioDoppiaVotazioneDao();
			return sdao;
		}
		else if(t == TipoPost.SONDAGGIOSCELTAMULTIPLA) {
			SondaggioSceltaMultiplaDao smul = new SondaggioSceltaMultiplaDao();
			return smul;
		}
		else if(t == TipoPost.TESTO) {
			TestoDao tdao = new TestoDao();
			return tdao;
		}
		return null;
	}
	
	
}
