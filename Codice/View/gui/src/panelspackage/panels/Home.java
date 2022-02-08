package panelspackage.panels;
import panelspackage.panels.elements.AddPostButton;
import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.SpecificContainer;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import panelspackage.Layers;
	
public class Home extends JPanel {
	
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	public int indiceBufferStories;
	public int indiceBufferPosts;
	
	public Home(ArrayList<String> bufferStories, ArrayList<String>  bufferPosts) {
		int indiceBufferStories = 0;
		int indiceBufferPosts = 0;
		
		this.setOpaque(true);
		this.setVisible(true);
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
		JLabel title = new JLabel("                                                                 Socialnetwork");
		title.setForeground(ARANCIONE);
		containerNorth.add(title, BorderLayout.CENTER);	
			
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
		
		SpecificContainer containerCommenti = new SpecificContainer();
		containerCenter.add(containerCommenti, BorderLayout.SOUTH);
		
		LabeledIcon post = new LabeledIcon(bufferPosts.get(indiceBufferPosts));
		containerPost.add(post);
			
		SpecificContainer containerStory = new SpecificContainer();
		containerStory.setLayout(new GridLayout(5,0));
		containerCenter.add(containerStory, BorderLayout.WEST);
			
		LabeledIcon primaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()));
		LabeledIcon secondaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()+1));
		LabeledIcon terzaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()+2));
		LabeledIcon quartaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()+3));
		LabeledIcon quintastory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()+4));
		containerStory.add(primaStory);
		containerStory.add(secondaStory);
		containerStory.add(terzaStory);
		containerStory.add(quartaStory);
		containerStory.add(quintastory);
		
		
		SpecificContainer containerSud = new SpecificContainer();
		this.add(containerSud, BorderLayout.SOUTH);
	
		containerSud.setLayout(new GridLayout(1,4));
		containerSud.add(new AddPostButton("Pubblica un post", ARANCIONE));
		containerSud.add(new AddPostButton("Pubblica una story", ARANCIONE));
		containerSud.add(new AddPostButton("Pubblica un sondaggio", ARANCIONE));
		containerSud.add(new AddPostButton("Pubblica un'idea", ARANCIONE));
		
	}

	public int getIndiceBufferStories() {
		return indiceBufferStories;
	}

	public void setIndiceBufferStories(int indiceBufferStories) {
		this.indiceBufferStories = indiceBufferStories;
	}

	public int getIndiceBufferPosts() {
		return indiceBufferPosts;
	}

	public void setIndiceBufferPosts(int indiceBufferPosts) {
		this.indiceBufferPosts = indiceBufferPosts;
	}	
}
