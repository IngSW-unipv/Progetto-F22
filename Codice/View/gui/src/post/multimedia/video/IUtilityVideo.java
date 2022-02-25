package post.multimedia.video;

import it.unipv.ings.Video.VideoDB;

public interface IUtilityVideo {

	//Adatta la classe Video alla classe VideoDB usata per fare le query
	public VideoDB convertiToTestoDB(Video v);
}
