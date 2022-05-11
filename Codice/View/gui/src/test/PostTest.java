package test;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull; 
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals; 
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;

import profilo.Profilo;
import post.Post; 
import post.multimedia.foto.Foto;
import post.multimedia.video.Video;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;

class PostTest {
	
	int i;
	ArrayList<Post> ListaPost;
	Post p1, p2, p3, p4;
	
	@Before  
	void initTest() {
		
		ListaPost = new ArrayList<Post>();
		
		int[] sceltaMultipla1 = {0, 0};
		int[] sceltaMultipla2 = {0, 0, 0, 0};
		
		p1 = new Foto("Post1", null, null, "xxx", true, true, "profilo", "perc1", true);
		p2 = new Video("Post2", null, null, "xxx", true, true, "profilo", "perc2", 1000);
		p3 = new SondaggioDoppiaVotazione("Post3", null, null, "xxx", true, true, "profilo", "primascelta", "secondascelta", sceltaMultipla1);
		p4 = new SondaggioSceltaMultipla("Post4", null, null, "xxx", true, true, "profilo", "primascelta", "secondascelta", "terzascelta", "quartascelta", sceltaMultipla2);
		
		ListaPost.add(p1);
		ListaPost.add(p2);
		ListaPost.add(p3);
		ListaPost.add(p4);   
	} 
          
	@Test
	void testCaricaPost() { 
		Profilo p = new Profilo(null, null);
				for(i = 0; i<4; i++)
		System.out.println(AssertTrue(p.car(ListaPost.get(i))));

	}
	
	@Test
	void testRimuoviPost() { 
		//Profilo p = new Profilo()		
		//AssertTrue(p.rimuoviPost(ListaPost.get(0)));
		//AssertTrue(p.rimuoviPost(ListaPost.get(1)));
		//AssertTrue(p.rimuoviPost(ListaPost.get(2)));
		//AssertTrue(p.rimuoviPost(ListaPost.get(3)));
	}
}
 
