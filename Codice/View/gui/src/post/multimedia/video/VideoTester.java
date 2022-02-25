package post.multimedia.video;

public class VideoTester {
	public static void main(String [] args) {
		Video v = new Video("P00", null, null, null, 0, 0, false, false, null, 0, null, false, "V00");
		UtilityVideo u = new UtilityVideo();
		//System.out.println(v.pubblicaVideo(u.convertiToTestoDB(v)));
		System.out.println(v.rimuoviVideo(u.convertiToVideoDB(v)));
		v.settaDurataStoria(7, v);
	}
}
