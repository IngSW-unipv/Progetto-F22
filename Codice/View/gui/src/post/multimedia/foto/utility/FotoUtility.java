package post.multimedia.foto.utility;

import db.foto.FotoDB;
import post.multimedia.foto.Foto;

public class FotoUtility implements IFotoUtility{

	@Override
	public FotoDB converti(Foto f) {
		FotoDB fdb = new FotoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), f.isVisibile(), f.isCondivisibile(), f.getProfilo(), f.getTempoCancellazione(), f.getPercorso(), f.isStory(), f.isHd());
		return fdb;
	}

}
