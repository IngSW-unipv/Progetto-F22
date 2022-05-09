package db.post.sondaggio.sondaggiodoppiavotazione;

import java.sql.Date;
import java.sql.Time;

import db.post.sondaggio.SondaggioDB;

public class SondaggioDoppiaVotazioneDB extends SondaggioDB{

	public SondaggioDoppiaVotazioneDB(String idPost, Date dataPubblicazione, Time oraPubblicazione,
			String descrizione, int numLike, int numDislike, boolean visibile, boolean condivisibile, String profilo,
			String primaScelta, String secondaScelta) {
		super(idPost,dataPubblicazione,oraPubblicazione,descrizione,numLike,numDislike,visibile,condivisibile,profilo,primaScelta,secondaScelta);

	}

}
