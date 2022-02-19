package posti;

public class Video extends Multimedia{
	
	private int durataMax;
	private String videoID;

	public int getDurataMax() {
		return durataMax;
	}

	public void setDurataMax(int durataMax) {
		this.durataMax = durataMax;
	}
	
	public String  getVideoID() {
		return videoID;
	}
	
	public void setVideoID(String videoID) {
		this.videoID = videoID;
	}
}
