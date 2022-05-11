package test;
import java.util.ArrayList;

import Sistema.Sistema;
import controller.Controller;
import packageframe.Frame;
import panelspackage.panels.Chat;
import panelspackage.panels.Home;

public class TestGui {
	static String listaImmaginiPost[] = {"immagini/Bruce.jpeg","immagini/Natasha.jpeg","immagini/Clint.jpeg","immagini/Steve.jpeg"};
	public static void main(String[] args) {
		
		ArrayList<String> bufferPosts = new ArrayList<String>();
		ArrayList<String> bufferStories = new ArrayList<String>();
		
		Sistema sistema = new Sistema();
		Frame frame = new Frame(bufferStories, bufferPosts, "Tony Stark", "tony.stark01@universitadipavia.it", 182, 93, 238,"immagini/Tony.jpeg", listaImmaginiPost);
		frame.setVisible(true);
		
		Controller ctrl = new Controller(sistema, frame);
	
		bufferPosts.add("immagini/post.jpg"); 
		bufferStories.add("immagini/Bruce.jpeg"); 
		bufferStories.add("immagini/Natasha.jpeg"); 
		bufferStories.add("immagini/Tony.jpeg"); 
		bufferStories.add("immagini/Clint.jpeg"); 
		bufferStories.add("immagini/Steve.jpeg");		
		
		ctrl.avvioSocial();
		ctrl.initComponents();

	}
	public String[] getListaImmaginiPost() {
		return listaImmaginiPost;
	}
	public void setListaImmaginiPost(String[] listaImmaginiPost) {
		this.listaImmaginiPost = listaImmaginiPost;
	}	
}
