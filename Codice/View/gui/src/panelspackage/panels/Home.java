package panelspackage.panels;
import panelspackage.panels.elements.AddPostButton;
import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.SpecificContainer;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;
	
public class Home extends JPanel {
	
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	public int indiceBufferStories;
	public int indiceBufferPosts;
	private Font fontTitle;
	private Font fontText;
	private Font fontButton;
	private JButton searchButton;	//Ricerca
	private JButton buttonPrevPost;	//Post precedente
	private JButton buttonNextPost;	//Post successivo
	private JButton aggiungiLike;	//Aggiungi dislike
	private JButton aggiungiDislike;	//Aggiungi like
	private JButton aggiungiCommento;	//Aggiungi commento
	private JButton buttonPrevStory;	//Storia successiva
	private JButton buttonNextStory;	//Storia precedente
	private JButton buttonImpostazioni;
	private JButton buttonProfilo;
	private JButton buttonChat;
	private JButton buttonNotifiche;
	private AddPostButton pPost;
	private AddPostButton pStory;
	private AddPostButton pSondaggio;
	private AddPostButton pIdea;
	
	
	public Home(ArrayList<String> bufferStories, ArrayList<String>  bufferPosts) {
		//int indiceBufferStories = 0;
		int indiceBufferPosts = 0;
		//FONT
		fontText = new Font("Arial", Font.PLAIN, 20);	//Font per tutti i testi
		fontTitle = new Font("Arial", Font.BOLD, 30);	//Font per il titolo
		fontButton = new Font("Arial", Font.BOLD, 15);	//Font per i bottoni
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
				
		Container containerNorth = new Container();
		containerNorth.setVisible(true);
		this.add(containerNorth, BorderLayout.NORTH);
		containerNorth.setLayout(new BorderLayout());
		//AREA RICERCA ACCOUNT
		Container areaRicerca = new Container();
		areaRicerca.setVisible(true);
		containerNorth.add(areaRicerca, BorderLayout.SOUTH);
		JLabel etichettaRicerca = new JLabel("Cerca un profilo: ");
		JTextArea testoRicerca = new JTextArea();
		searchButton = new JButton("CERCA");
		
		testoRicerca.setForeground(ARANCIONE);
		testoRicerca.setBackground(Color.LIGHT_GRAY);
		testoRicerca.setVisible(true);
		testoRicerca.setFont(fontText);
		
		etichettaRicerca.setForeground(ARANCIONE);
		etichettaRicerca.setBackground(Color.LIGHT_GRAY);
		etichettaRicerca.setVisible(true);
		etichettaRicerca.setFont(fontText);
		
		searchButton.setFont(fontButton);
		
		areaRicerca.setLayout(new BorderLayout());
		areaRicerca.add(etichettaRicerca, BorderLayout.WEST);
		areaRicerca.add(testoRicerca, BorderLayout.CENTER);
		areaRicerca.add(searchButton, BorderLayout.EAST);
		
		
			
		Container menuHome = new Container();
		containerNorth.add(menuHome, BorderLayout.NORTH);
		menuHome.setLayout(new BorderLayout());
		
		//TITOLO
		JLabel title = new JLabel("Socialnetwork", SwingConstants.CENTER);
		title.setFont(fontTitle);
		title.setForeground(ARANCIONE);
		containerNorth.add(title, BorderLayout.CENTER);	
			
		Container menuHomeSinistro = new Container();
		containerNorth.add(menuHomeSinistro, BorderLayout.WEST);
		menuHomeSinistro.setLayout(new BorderLayout());

		Icon profileLabel = new ImageIcon("immagini/profilo.png");
		buttonProfilo = new JButton(profileLabel);
		menuHomeSinistro.add(buttonProfilo, BorderLayout.EAST);

		Icon settingLabel = new ImageIcon("immagini/impostazioni.png");
		buttonImpostazioni = new JButton(settingLabel);
		menuHomeSinistro.add(buttonImpostazioni, BorderLayout.WEST);

		Container menuHomeDestro = new Container();
		menuHomeDestro.setLayout(new BorderLayout());
		menuHomeDestro.setBackground(ARANCIONE);
		menuHomeDestro.setForeground(NERO);
		containerNorth.add(menuHomeDestro, BorderLayout.EAST);			

		Icon notificationLabel = new ImageIcon("immagini/notifiche.gif");
		buttonNotifiche = new JButton(notificationLabel);
		menuHomeDestro.add(buttonNotifiche, BorderLayout.EAST);

		LabeledIcon textLabel = new LabeledIcon("immagini/testo.jpeg");
		menuHomeDestro.add(textLabel, BorderLayout.WEST);
		Icon chatLabel = new ImageIcon("immagini/testo.jpeg");
		buttonChat = new JButton(chatLabel);
		menuHomeDestro.add(buttonChat, BorderLayout.WEST);


		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
			
		SpecificContainer containerCommenti = new SpecificContainer();
		containerCenter.add(containerCommenti, BorderLayout.WEST);
		
		SpecificContainer containerPost = new SpecificContainer();
		containerCenter.add(containerPost, BorderLayout.CENTER);
		
		LabeledIcon post = new LabeledIcon(bufferPosts.get(indiceBufferPosts));
		containerPost.add(post, BorderLayout.CENTER);
		SpecificContainer containerCosePost = new SpecificContainer();
		JTextArea areaDescrizione = new JTextArea("DESCRIZIONE POST\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.");
		areaDescrizione.setPreferredSize(new Dimension(400, 130));
		areaDescrizione.setEditable(false);
		areaDescrizione.setLineWrap(true);
		JScrollPane scrollAreaDescrizione = new JScrollPane(areaDescrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		JLabel numeroLike = new JLabel("N.like");
		numeroLike.setForeground(Color.white);
		JLabel numeroDislike = new JLabel("N.dislike");
		numeroDislike.setForeground(Color.white);
		JLabel numeroCommenti = new JLabel("N.Commenti");
		numeroCommenti.setForeground(Color.white);
		buttonPrevPost = new JButton("Post precedente");
		buttonPrevPost.setFont(fontButton);
		buttonNextPost = new JButton("Post successivo");
		buttonNextPost.setFont(fontButton);
		aggiungiLike = new JButton("+ Like");
		aggiungiDislike = new JButton("+ Dislike");
		aggiungiCommento = new JButton("+ Commento");
		SpecificContainer containerBottoniPost = new SpecificContainer();
		containerBottoniPost.setLayout(new GridLayout(1, 2));
		containerBottoniPost.add(buttonPrevPost);
		containerBottoniPost.add(buttonNextPost);
		SpecificContainer containerLikeDislikeComm = new SpecificContainer();
		containerLikeDislikeComm.setLayout(new GridLayout(2, 6));
		containerLikeDislikeComm.add(numeroLike);
		containerLikeDislikeComm.add(numeroDislike);
		containerLikeDislikeComm.add(numeroCommenti);
		containerLikeDislikeComm.add(aggiungiLike);
		containerLikeDislikeComm.add(aggiungiDislike);
		containerLikeDislikeComm.add(aggiungiCommento);
		containerCosePost.add(containerLikeDislikeComm, BorderLayout.NORTH);
		containerCosePost.add(scrollAreaDescrizione, BorderLayout.CENTER);
		containerCosePost.add(containerBottoniPost, BorderLayout.SOUTH);
		containerPost.add(containerCosePost, BorderLayout.SOUTH);		
		
		//SEZIONE STORIES
		SpecificContainer containerStory = new SpecificContainer();
		SpecificContainer containerWest = new SpecificContainer();
		SpecificContainer containerButtonStory = new SpecificContainer();
		
		containerWest.add(containerStory, BorderLayout.CENTER);
		containerStory.setLayout(new GridLayout(5,0));
		containerCenter.add(containerWest, BorderLayout.WEST);
		buttonNextStory = new JButton("->");
		buttonPrevStory = new JButton("<-");
		containerButtonStory.setLayout(new GridLayout(1, 2));
		containerButtonStory.add(buttonPrevStory);
		containerButtonStory.add(buttonNextStory);
		containerWest.add(containerButtonStory, BorderLayout.SOUTH);
			
		LabeledIcon primaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()));
		primaStory.setBorder(new LineBorder(NERO,4));
		LabeledIcon secondaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()+1));
		secondaStory.setBorder(new LineBorder(NERO,4));
		LabeledIcon terzaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()+2));
		terzaStory.setBorder(new LineBorder(NERO,4));
		LabeledIcon quartaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()+3));
		quartaStory.setBorder(new LineBorder(NERO,4));
		LabeledIcon quintaStory = new LabeledIcon(bufferStories.get(this.getIndiceBufferStories()+4));
		quintaStory.setBorder(new LineBorder(NERO,4));
		containerStory.add(primaStory);
		containerStory.add(secondaStory);
		containerStory.add(terzaStory);
		containerStory.add(quartaStory);
		containerStory.add(quintaStory);
		
		//Bottoni pubblicazione post
		SpecificContainer containerSud = new SpecificContainer();
		this.add(containerSud, BorderLayout.SOUTH);
		containerSud.setLayout(new GridLayout(1,4));
		pPost =  new AddPostButton("Pubblica un post", ARANCIONE);
		pPost.setFont(fontButton);
		containerSud.add(pPost);
		pStory =  new AddPostButton("Pubblica una story", ARANCIONE);
		pStory.setFont(fontButton);
		containerSud.add(pStory);
		pSondaggio =  new AddPostButton("Pubblica sondaggio", ARANCIONE);
		pSondaggio.setFont(fontButton);
		containerSud.add(pSondaggio);
		pIdea =  new AddPostButton("Pubblica un'idea", ARANCIONE);
		pIdea.setFont(fontButton);
		containerSud.add(pIdea);
		
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
	
	
	//GETTER E SETTER PULSANTI
	public JButton getSearchButton() {
		return searchButton;
	}
	public void setSearchButton(JButton searchButton) {
		this.searchButton = searchButton;
	}
	public JButton getButtonPrevPost() {
		return buttonPrevPost;
	}
	public void setButtonPrevPost(JButton buttonPrevPost) {
		this.buttonPrevPost = buttonPrevPost;
	}
	public JButton getButtonNextPost() {
		return buttonNextPost;
	}
	public void setButtonNextPost(JButton buttonNextPost) {
		this.buttonNextPost = buttonNextPost;
	}
	public JButton getAggiungiLike() {
		return aggiungiLike;
	}
	public void setAggiungiLike(JButton aggiungiLike) {
		this.aggiungiLike = aggiungiLike;
	}
	public JButton getAggiungiDislike() {
		return aggiungiDislike;
	}
	public void setAggiungiDislike(JButton aggiungiDislike) {
		this.aggiungiDislike = aggiungiDislike;
	}
	public JButton getAggiungiCommento() {
		return aggiungiCommento;
	}
	public void setAggiungiCommento(JButton aggiungiCommento) {
		this.aggiungiCommento = aggiungiCommento;
	}
	public JButton getButtonPrevStory() {
		return buttonPrevStory;
	}
	public void setButtonPrevStory(JButton buttonPrevStory) {
		this.buttonPrevStory = buttonPrevStory;
	}
	public JButton getButtonNextStory() {
		return buttonNextStory;
	}
	public void setButtonNextStory(JButton buttonNextStory) {
		this.buttonNextStory = buttonNextStory;
	}
	public AddPostButton getpPost() {
		return pPost;
	}
	public void setpPost(AddPostButton pPost) {
		this.pPost = pPost;
	}
	public AddPostButton getpStory() {
		return pStory;
	}
	public void setpStory(AddPostButton pStory) {
		this.pStory = pStory;
	}
	public AddPostButton getpSondaggio() {
		return pSondaggio;
	}
	public void setpSondaggio(AddPostButton pSondaggio) {
		this.pSondaggio = pSondaggio;
	}
	public AddPostButton getpIdea() {
		return pIdea;
	}

	public void setpIdea(AddPostButton pIdea) {
		this.pIdea = pIdea;
	}	

	public JButton getButtonImpostazioni() {
		return buttonImpostazioni;
	}

	public void setButtonImpostazioni(JButton buttonImpostazioni) {
		this.buttonImpostazioni = buttonImpostazioni;
	}

	public JButton getButtonProfilo() {
		return buttonProfilo;
	}

	public void setButtonProfilo(JButton buttonProfilo) {
		this.buttonProfilo = buttonProfilo;
	}

	public JButton getButtonChat() {
		return buttonChat;
	}

	public void setButtonChat(JButton buttonChat) {
		this.buttonChat = buttonChat;
	}

	public JButton getButtonNotifiche() {
		return buttonNotifiche;
	}

	public void setButtonNotifiche(JButton buttonNotifiche) {
		this.buttonNotifiche = buttonNotifiche;
	}

}