package PanelsPackage.panels;
import PanelsPackage.panels.elements.LabeledIcon;

import java.awt.*;
import javax.swing.*;

import PanelsPackage.Layers;
	
public class Home extends JPanel {
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);

	public Home() {
		this.setLayout(new BorderLayout());
		this.setBackground(ARANCIONE);
		Container containerNorth = new Container();
		containerNorth.setVisible(true);
		this.add( containerNorth, BorderLayout.NORTH);
		containerNorth.setLayout(new BorderLayout());
		
		
		//Container areaRicerca = creazioneContainer(areaRicerca, containerNorth, "CENTER" );
			Container areaRicerca = new Container();
			areaRicerca.setVisible(true);
			containerNorth.add(areaRicerca, BorderLayout.SOUTH);
			JTextArea testoRicerca = new JTextArea("Area Ricerca");
			testoRicerca.setVisible(true);
			areaRicerca.setLayout(new BorderLayout());
			areaRicerca.setForeground(Color.ORANGE);
			areaRicerca.add(testoRicerca, BorderLayout.CENTER);
			
		
			Container menuHome = new Container();
			containerNorth.add(menuHome, BorderLayout.NORTH);
			menuHome.setLayout(new BorderLayout());
			JLabel title = new JLabel("SocialNetwork");
			menuHome.add(title, BorderLayout.CENTER);
			
			
			Container menuHomeSinistro = new Container();
			containerNorth.add(menuHomeSinistro, BorderLayout.WEST);
			menuHomeSinistro.setLayout(new BorderLayout());
			//aggiungere le due gif alla sinistra
			
			LabeledIcon profileLabel = new LabeledIcon("immagini/iu.png");
   			menuHomeSinistro.add(profileLabel, BorderLayout.EAST);
			
   			LabeledIcon settingLabel = new LabeledIcon("immagini/iu-1.png");
			menuHomeSinistro.add(settingLabel, BorderLayout.WEST);
			
			
			Container menuHomeDestro = new Container();
			menuHomeDestro.setLayout(new BorderLayout());
			menuHomeDestro.setBackground(ARANCIONE);
			menuHomeDestro.setForeground(NERO);
			containerNorth.add(menuHomeDestro, BorderLayout.EAST);

			
			LabeledIcon notificationLabel = new LabeledIcon("immagini/iu.gif");
			menuHomeDestro.add(notificationLabel, BorderLayout.EAST);
			
			LabeledIcon textLabel = new LabeledIcon("immagini/iu-3.jpeg");
			menuHomeDestro.add(textLabel, BorderLayout.WEST);
			//aggiungere le due gif alla destra		
			
			/*  griglia  dei tasti per aggiungere post
			Container aggiungiPost = new Container();
			JPanel pannello = new JPanel();
			pannello.setVisible(true);
			aggiungiPost.add(pannello);
			pannello.setLayout(new GridLayout(0,4));
			pannello.add(new JButton("Button 1"));
			pannello.add(new JButton("Button 2"));
			pannello.add(new JButton("Button 3"));
			pannello.add(new JButton("Long-Named Button 4"));
			pannello.add(new JButton("5"));
			*/
	}
			/*static public Container creazioneContainer(String name, Container oggetto, String zona) {
				Container contenitore = new Container();
				contenitore.setVisible(true);
				contenitore.setName(name);
				oggetto.add(contenitore,  zona);
				contenitore.setLayout(new BorderLayout());
				return contenitore;
			}*/
}
