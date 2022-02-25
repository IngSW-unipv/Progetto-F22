package post.multimedia.foto;

import it.unipv.ings.Foto.FotoDB;

public class UtilityFoto implements IUtilityFoto{

	@Override
	public FotoDB convertiToFotoDB(Foto f) {
		FotoDB fdb = new FotoDB(f.getIdFoto(), f.getPercorso(), f.getIdPost(), f.isStory());
		return fdb;
	}

}
