package post.multimedia.foto;

import java.util.ArrayList;

import post.Post;

public class FotoTester {

	public static void main(String[] args) {
		Foto f = new Foto("F00", null, null, null, 0, 0, false, false, null, 0, null, false, false);
        
		ArrayList<Post> res = f.selectAll();
		
		for(Post p : res)
			System.out.println(p.toString());
		
        //System.out.println(f.caricaPost(f));
        //System.out.println(f.rimuoviPost(f));
	}

}
