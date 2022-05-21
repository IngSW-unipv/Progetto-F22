package controller;

import java.util.ArrayList;


import Sistema.Sistema;
import packageframe.Frame;
import panelspackage.panels.AreaChatFrame;

public class MVCPatternMain {
	static String listaImmaginiPost[] = {"immagini/Bruce.jpeg","immagini/Natasha.jpeg","immagini/Clint.jpeg","immagini/Steve.jpeg"};

	public static void main(String[] args) {
		ArrayList<String> bufferPosts = new ArrayList<String>();
		ArrayList<String> bufferStories = new ArrayList<String>();
		bufferPosts.add("immagini/post.jpg"); bufferStories.add("immagini/Bruce.jpeg"); bufferStories.add("immagini/Natasha.jpeg"); bufferStories.add("immagini/Tony.jpeg"); bufferStories.add("immagini/Clint.jpeg"); bufferStories.add("immagini/Steve.jpeg");
		
		Frame view = new Frame(bufferStories, bufferPosts, "Tony Stark", "tony.stark01@universitadipavia.it", 182, 93, 238,"immagini/Tony.jpeg", listaImmaginiPost);
		Sistema model = new Sistema();
		
		Controller ctrl = new Controller(model, view);
	
	}
}
