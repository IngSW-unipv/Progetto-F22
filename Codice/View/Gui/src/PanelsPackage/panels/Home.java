package PanelsPackage.panels;
import PanelsPackage.panels.elements.AddPostButton;
import PanelsPackage.panels.elements.LabeledIcon;
import PanelsPackage.panels.elements.SpecificContainer;

import java.awt.*;
import javax.swing.*;

import PanelsPackage.Layers;
	
public class Home extends JPanel {
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	
	public Home() {
		
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		
		Container containerNorth = new Container();
		containerNorth.setVisible(true);
		this.add(containerNorth, BorderLayout.NORTH);
		containerNorth.setLayout(new BorderLayout());

		Container areaRicerca = new Container();
		areaRicerca.setVisible(true);
		containerNorth.add(areaRicerca, BorderLayout.SOUTH);
		JTextArea testoRicerca = new JTextArea("Area Ricerca");
		testoRicerca.setForeground(ARANCIONE);
		testoRicerca.setBackground(NERO);
		testoRicerca.setVisible(true);
		areaRicerca.setLayout(new BorderLayout());
		areaRicerca.setForeground(Color.ORANGE);
		areaRicerca.add(testoRicerca, BorderLayout.CENTER);		
			
		Container menuHome = new Container();
		containerNorth.add(menuHome, BorderLayout.NORTH);
		menuHome.setLayout(new BorderLayout());
		JLabel title = new JLabel("SocialNetwork");
		title.setForeground(ARANCIONE);
		menuHome.add(title, BorderLayout.CENTER);	
			
		Container menuHomeSinistro = new Container();
		containerNorth.add(menuHomeSinistro, BorderLayout.WEST);
		menuHomeSinistro.setLayout(new BorderLayout());
			
		LabeledIcon profileLabel = new LabeledIcon("immagini/profilo.png");
		menuHomeSinistro.add(profileLabel, BorderLayout.EAST);
			
		LabeledIcon settingLabel = new LabeledIcon("immagini/impostazioni.png");
		menuHomeSinistro.add(settingLabel, BorderLayout.WEST);
				
		Container menuHomeDestro = new Container();
		menuHomeDestro.setLayout(new BorderLayout());
		menuHomeDestro.setBackground(ARANCIONE);
		menuHomeDestro.setForeground(NERO);
		containerNorth.add(menuHomeDestro, BorderLayout.EAST);			
			
		LabeledIcon notificationLabel = new LabeledIcon("immagini/notifiche.gif");
		menuHomeDestro.add(notificationLabel, BorderLayout.EAST);
			
		LabeledIcon textLabel = new LabeledIcon("immagini/testo.jpeg");
		menuHomeDestro.add(textLabel, BorderLayout.WEST);
			
			
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
			
		SpecificContainer containerPost = new SpecificContainer();
		containerCenter.add(containerPost, BorderLayout.CENTER);
		LabeledIcon post = new LabeledIcon("immagini/post.png");
		containerPost.add(post);
			
		SpecificContainer containerStory = new SpecificContainer();
		containerStory.setLayout(new GridLayout(5,0));
		containerCenter.add(containerStory, BorderLayout.WEST);
		
		LabeledIcon story1 = new LabeledIcon("immagini/storyicon.jpeg");
		LabeledIcon story2 = new LabeledIcon("immagini/storyicon.jpeg");
		LabeledIcon story3 = new LabeledIcon("immagini/storyicon.jpeg");
		LabeledIcon story4 = new LabeledIcon("immagini/storyicon.jpeg");
		LabeledIcon story5 = new LabeledIcon("immagini/storyicon.jpeg");
		containerStory.add(story1);
		containerStory.add(story2);
		containerStory.add(story3);
		containerStory.add(story4);
		containerStory.add(story5);
		
		
		SpecificContainer containerSud = new SpecificContainer();
		this.add(containerSud, BorderLayout.SOUTH);
	
		containerSud.setLayout(new GridLayout(1,4));
		containerSud.add(new AddPostButton("Pubblica un post", ARANCIONE));
		containerSud.add(new AddPostButton("Pubblica una story", ARANCIONE));
		containerSud.add(new AddPostButton("Pubblica un sondaggio", ARANCIONE));
		containerSud.add(new AddPostButton("Pubblica un'idea", ARANCIONE));
	}	
}
