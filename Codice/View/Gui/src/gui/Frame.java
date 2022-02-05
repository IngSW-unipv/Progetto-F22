package gui;
import java.awt.*;
import javax.swing.*;
import PanelsPackage.Layers;
import PanelsPackage.panels.Home;
import PanelsPackage.panels.LogIn;

import java.awt.*;
public class Frame extends JFrame {
	
	Color ARANCIONE = new Color(255, 175, 0);
	Color NERO = new Color(255,255,255);	
	
	public Frame() {
		
		this.setTitle("SocialNetwork");
		this.setSize(800,800);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		Layers layers = new Layers();
		layers.setBounds(0,0, 800, 775);
		this.add(layers, BorderLayout.CENTER);
		
		Home home = new Home();
		layers.add(home, new  Integer(2), 0);
		home.setBounds(0,0,800,775);
		home.setOpaque(true);
		home.setVisible(true); 
		
		LogIn logIn = new LogIn();
		layers.add(logIn, new  Integer(0), 0);
		logIn.setBounds(0,0,800,775);
		logIn.setOpaque(true);
		logIn.setVisible(true); 
	}
}
