package post.multimedia.video;

import java.util.ArrayList;

import post.Post;

public class VideoTester {
	public static void main(String [] args) {
		Video v = new Video("V01", null, null, null, 0, 0, false, false, null, 0, null, false, 0);

		ArrayList<Post> res = v.selectAll();
		
		for(Post p : res)
			System.out.println(p.toString());
		
		v.settaDurataStoria(7, v);
		
		//System.out.println(v.caricaPost(v));
		//System.out.println(v.rimuoviPost(v));
		
	}
}
