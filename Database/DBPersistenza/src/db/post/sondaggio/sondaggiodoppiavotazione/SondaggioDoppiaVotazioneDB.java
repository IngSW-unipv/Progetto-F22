package db.post.sondaggio.sondaggiodoppiavotazione;

import java.sql.Date;
import java.sql.Time;

import db.post.PostDB;
import db.post.sondaggio.SondaggioDB;

public class SondaggioDoppiaVotazioneDB extends SondaggioDB{

	public SondaggioDoppiaVotazioneDB(String idPost, Date dataPubblicazione, Time oraPubblicazione,
			String descrizione,int numLike,int numDislike, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,condivisibile,profilo,primaScelta,secondaScelta);

	}

	@Override
	public PostDB inserisciCaratteristiche(PostDB p) {
		SondaggioDoppiaVotazioneDB sdb = new SondaggioDoppiaVotazioneDB(p.getIdPost(), p.getDataPubblicazione(), p.getOraPubblicazione(), p.getDescrizione(),p.getNumLike(),p.getNumDislike(), p.isVisibile(), p.getProfilo(), this.getPrimaScelta(), this.getSecondaScelta());
		return sdb;
	}

}
