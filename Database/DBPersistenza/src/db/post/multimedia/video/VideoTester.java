package db.post.multimedia.video;

import java.util.ArrayList;

public class VideoTester {

	public static void main(String[] args) {
		VideoDao vdao = new VideoDao();
        ArrayList<String> res = vdao.ritornaPostDiUnProfilo("DV999");
		for(String s: res)
			System.out.println(s.toString());
	}

}
