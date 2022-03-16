package convertitore.fotoUtility;

import db.foto.FotoDB;
import post.multimedia.foto.Foto;

public class FotoUtility{

	
	public FotoDB convertiAFotoDB(Foto f) {
		FotoDB fdb = new FotoDB(f.getIdPost(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), f.isVisibile(), f.isCondivisibile(), f.getProfilo(), f.getTempoCancellazione(), f.getPercorso(), f.isStory(), f.isHd());
		return fdb;
	}

	public Foto convertiAFoto(FotoDB f) {
		Foto fdb = new Foto(f.getIdFoto(), f.getDataPubblicazione(), f.getOraPubblicazione(), f.getDescrizione(), f.isVisibile(), f.isCondivisibile(), f.getProfilo(), f.getPercorso(), f.isHd());
		return fdb;
	}
}
