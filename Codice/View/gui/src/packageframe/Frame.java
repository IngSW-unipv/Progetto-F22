package packageframe;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import panelspackage.Layers;
import panelspackage.panels.Home;
import panelspackage.panels.Impostazioni;
import panelspackage.panels.LogIn;
import panelspackage.panels.Profilo;
import panelspackage.panels.Ricerca;

import java.awt.*;
public class Frame extends JFrame {
	
	Color ARANCIONE = new Color(255, 175, 0);
	Color NERO = new Color(255,255,255);	
	
	public Frame(ArrayList<String> bufferStories, ArrayList<String> bufferPosts) {
		
		this.setTitle("SocialNetwork");
		this.setSize(800,800);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(true);
		
		Layers layers = new Layers();
		layers.setBounds(0,0, 800, 775);
		this.add(layers, BorderLayout.CENTER);
		
		Home home = new Home(bufferStories, bufferPosts);
		layers.add(home, new  Integer(5), 0);
		home.setBounds(0,0,800,775);

		
		LogIn logIn = new LogIn();
		layers.add(logIn, new  Integer(1), 0);
		logIn.setBounds(0,0,800,775);

		/*Ricerca ricerca = new Ricerca("Tony Stark");
		layers.add(ricerca, new  Integer(2), 0);
		ricerca.setBounds(0,0,800,775);*/
		
		Profilo profilo = new Profilo("Tony Stark");
		layers.add(profilo, new  Integer(4), 0);
		profilo.setBounds(0,0,800,775);
		
		Impostazioni impostazioni = new Impostazioni("Steve Rogers");
		layers.add(impostazioni, new  Integer(3), 0);
		impostazioni.setBounds(0,0,800,775);
		
	}
}