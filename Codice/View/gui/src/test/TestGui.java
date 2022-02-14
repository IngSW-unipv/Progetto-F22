package test;
import java.util.ArrayList;

import packageframe.Frame;
import panelspackage.panels.Chat;

public class TestGui {
	
	public static void main(String[] args) {
		
		ArrayList<String> bufferPosts = new ArrayList<String>();
		ArrayList<String> bufferStories = new ArrayList<String>();
	
		bufferPosts.add("immagini/post.jpg");
		bufferStories.add("immagini/Bruce.jpeg");
		bufferStories.add("immagini/Natasha.jpeg");
		bufferStories.add("immagini/Tony.jpeg");
		bufferStories.add("immagini/Clint.jpeg");
		bufferStories.add("immagini/Steve.jpeg");
		
		Frame gui = new Frame(bufferStories, bufferPosts);
		gui.setVisible(true);
		
		Chat chat = new Chat();
		chat.setVisible(true);
	}	
}
