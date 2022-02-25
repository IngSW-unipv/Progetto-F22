package post.multimedia.video;

import it.unipv.ings.Video.VideoDB;

public class UtilityVideo implements IUtilityVideo{

	public VideoDB convertiToTestoDB(Video v) {
		VideoDB tdb = new VideoDB(v.getIdVideo(), v.getDurata(), v.getPercorso(), v.getIdPost(), v.isStory());
		return tdb;
	}

}
