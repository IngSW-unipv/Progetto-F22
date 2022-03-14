package convertitore.videoUtility;

import db.video.VideoDB;
import post.multimedia.video.Video;

public class VideoUtility implements IVideoUtility{

	@Override
	public VideoDB coverti(Video v) {
		VideoDB vdb = new VideoDB(v.getIdPost(), v.getDataPubblicazione(), v.getOraPubblicazione(), v.getDescrizione(), v.getNumLike(), v.getNumDislike(), v.isVisibile(), v.isCondivisibile(), v.getProfilo(), v.getTempoCancellazione(), v.getPercorso(), v.isStory(), v.getDurataInSecondi());
		return vdb;
	}

}
