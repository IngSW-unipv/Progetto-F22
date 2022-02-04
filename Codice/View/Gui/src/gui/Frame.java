package gui;
import java.awt.*;
import javax.swing.*;
import PanelsPackage.Layers;

import java.awt.*;
public class Frame extends JFrame {
	
	Color ARANCIONE = new Color(255, 175, 0);
	Color NERO = new Color(255,255,255);
	
	
	
	public Frame() {
		this.setTitle("SocialNetwork");
		this.setSize(1000,500);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		
		Layers layers = new Layers();
		layers.setBounds(0,0, 1000, 500);
		this.add(layers, BorderLayout.CENTER);
		
	}
}
