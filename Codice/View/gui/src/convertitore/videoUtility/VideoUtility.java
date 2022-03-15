package convertitore.videoUtility;

import db.video.VideoDB;
import post.multimedia.video.Video;

public class VideoUtility{

	public static VideoDB covertiAVideoDB(Video v) {
		VideoDB vdb = new VideoDB(v.getIdPost(), v.getDataPubblicazione(), v.getOraPubblicazione(), v.getDescrizione(), v.getNumLike(), v.getNumDislike(), v.isVisibile(), v.isCondivisibile(), v.getProfilo(), v.getTempoCancellazione(), v.getPercorso(), v.isStory(), v.getDurataInSecondi());
		return vdb;
	}

	public static Video convertiAVideo(VideoDB v) {
		Video vdb = new Video(v.getIdVideo(), v.getDataPubblicazione(), v.getOraPubblicazione(), v.getDescrizione(), v.isVisibile(), v.isCondivisibile(), v.getProfilo(), v.getPercorso(), v.getDurataInSecondi());
		return vdb;
	}
}
