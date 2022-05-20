package panelspackage.panels;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.SpecificContainer;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

import packageframe.Frame;
	
public class Home extends JPanel {
	
	int i;

	SpecificContainer containerNorth, containerSouth, containerEast, containerWest, containerCenter;
	private int indiceBufferStories, indiceBufferPosts;
	private Font fontTitle, fontText, fontButton;
	private Pulsanti buttonPrevPost,buttonNextPost,aggiungiLike,aggiungiDislike,aggiungiCommento,buttonPrevStory,buttonNextStory,buttonImpostazioni,buttonProfilo,buttonChat,buttonNotifiche,pPost,pStory,pSondaggio,pIdea, searchButton;
	private Etichette numeroLike, numeroDislike,  numeroCommenti, etichettaRicerca;
	private JTextField testoRicerca;
	public static final  Color NERO = new Color(0,0,0);	

	
	public Home(ArrayList<String> bufferStories, ArrayList<String>  bufferPosts) {
		int indiceBufferPosts = 0;
		fontText = new Font("Arial", Font.PLAIN, 20);	//Font per tutti i testi
		fontTitle = new Font("Arial", Font.BOLD, 30);	//Font per il titolo
		fontButton = new Font("Arial", Font.BOLD, 15);	//Font per i bottoni
		
		avvio();		
		this.initComponents(bufferPosts, bufferStories);
	}
	
			
	public void avvio() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);
		this.add(containerNorth = new SpecificContainer(), BorderLayout.NORTH);
		this.add(containerCenter = new SpecificContainer(), BorderLayout.CENTER);
	}

	public void menuHome() {
		SpecificContainer areaRicerca = new SpecificContainer();
		containerNorth.add(areaRicerca, BorderLayout.SOUTH);

		areaRicerca.add(etichettaRicerca = new Etichette("Cerca un profilo: ", Color.LIGHT_GRAY, Frame.COLOREPRIMARIOTEMATICO,fontText), BorderLayout.WEST);
		//areaRicerca.add(testoRicerca = new AreaDiTesto(Color.LIGHT_GRAY, Frame.COLOREPRIMARIOTEMATICO, "", fontText), BorderLayout.CENTER);
		areaRicerca.add(testoRicerca = new JTextField(""));
		areaRicerca.add(searchButton = new Pulsanti("CERCA", fontButton), BorderLayout.EAST);
		searchButton.setEnabled(true);
		
		SpecificContainer menuHome = new SpecificContainer();
		containerNorth.add(menuHome, BorderLayout.NORTH);
		
		containerNorth.add(new Etichette("Socialnetwork", Frame.COLOREPRIMARIOTEMATICO, fontTitle), BorderLayout.CENTER);	
			
		SpecificContainer menuHomeSinistro = new SpecificContainer();
		containerNorth.add(menuHomeSinistro, BorderLayout.WEST);
		SpecificContainer menuHomeDestro = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO, Frame.COLORESECONDARIOTEMATICO);
		containerNorth.add(menuHomeDestro, BorderLayout.EAST);			


		menuHomeSinistro.add(buttonProfilo = new Pulsanti("immagini/profilo.png"), BorderLayout.EAST);
		menuHomeSinistro.add(buttonImpostazioni = new Pulsanti("immagini/impostazioni.png"), BorderLayout.WEST);

		menuHomeDestro.add(buttonNotifiche = new Pulsanti("immagini/notifiche.gif"), BorderLayout.EAST);
		menuHomeDestro.add(buttonChat = new Pulsanti("immagini/testo.jpeg"), BorderLayout.WEST);

	}
	
	public void areaPost(ArrayList<String>  bufferPosts) {
		SpecificContainer containerPost = new SpecificContainer();
		containerCenter.add(containerPost, BorderLayout.CENTER);
		
		containerPost.add(new LabeledIcon(bufferPosts.get(indiceBufferPosts)), BorderLayout.CENTER);
		
		SpecificContainer containerCosePost = new SpecificContainer();
		
		AreaDiTesto areaDescrizione = new AreaDiTesto("DESCRIZIONE POST\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.",400, 130);
		JScrollPane scrollAreaDescrizione = new JScrollPane(areaDescrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		SpecificContainer containerBottoniPost = new SpecificContainer();
		containerBottoniPost.setLayout(new GridLayout(1, 2));
		containerBottoniPost.add(buttonPrevPost = new Pulsanti("Post precedente", fontButton));
		containerBottoniPost.add(buttonNextPost = new Pulsanti("Post successivo",fontButton));
		
		SpecificContainer containerLikeDislikeComm = new SpecificContainer();
		containerLikeDislikeComm.setLayout(new GridLayout(2, 6));
		containerLikeDislikeComm.add(numeroLike = new Etichette("N.like", Color.white));
		containerLikeDislikeComm.add(numeroDislike = new Etichette("N.dislike", Color.white));
		containerLikeDislikeComm.add(numeroCommenti = new Etichette("N.Commenti", Color.white));
		containerLikeDislikeComm.add(aggiungiLike = new Pulsanti("+ Like", Frame.COLORESECONDARIOTEMATICO));
		containerLikeDislikeComm.add(aggiungiDislike = new Pulsanti("+ Dislike", Frame.COLORESECONDARIOTEMATICO));
		containerLikeDislikeComm.add(aggiungiCommento = new Pulsanti("+ Commento", Frame.COLORESECONDARIOTEMATICO));
		
		containerCosePost.add(containerLikeDislikeComm, BorderLayout.NORTH);
		containerCosePost.add(scrollAreaDescrizione, BorderLayout.CENTER);
		containerCosePost.add(containerBottoniPost, BorderLayout.SOUTH);
		containerPost.add(containerCosePost, BorderLayout.SOUTH);		
	}
	
	public void areaStories(ArrayList<String>  bufferStories) {
		SpecificContainer containerWest = new SpecificContainer();
		SpecificContainer containerStory = new SpecificContainer();
		SpecificContainer containerButtonStory = new SpecificContainer();
		
		containerWest.add(containerStory = new SpecificContainer(), BorderLayout.CENTER);
		containerStory.setLayout(new GridLayout(5,0));
		containerCenter.add(containerWest, BorderLayout.WEST);
	
		containerButtonStory.setLayout(new GridLayout(1, 2));
		containerButtonStory.add(buttonNextStory = new  Pulsanti("->", Frame.COLORESECONDARIOTEMATICO));
		containerButtonStory.add(buttonPrevStory = new Pulsanti("<-", Frame.COLORESECONDARIOTEMATICO));
		containerWest.add(containerButtonStory, BorderLayout.SOUTH);
		
		for (i = 0; i < 5; i++) {
			containerStory.add(new Pulsanti(bufferStories.get(this.getIndiceBufferStories()+ i), Frame.COLORESECONDARIOTEMATICO, 4));
		}	
	}
	
		public void sezionePubblicaPost() {
			
			SpecificContainer containerSud = new SpecificContainer();
			this.add(containerSud, BorderLayout.SOUTH);
			
			containerSud.setLayout(new GridLayout(1,4));

			containerSud.add(pPost =  new Pulsanti("Pubblica un post", Frame.COLOREPRIMARIOTEMATICO, fontButton));
			containerSud.add(pStory =  new Pulsanti("Pubblica una story", Frame.COLOREPRIMARIOTEMATICO,fontButton));
			containerSud.add(pSondaggio =  new Pulsanti("Pubblica sondaggio", Frame.COLOREPRIMARIOTEMATICO, fontButton));
			containerSud.add(pIdea =  new Pulsanti("Pubblica un'idea", Frame.COLOREPRIMARIOTEMATICO,fontButton));
			
		}
		
	public void initComponents(ArrayList<String>  bufferPosts, ArrayList<String>  bufferStories) {
		menuHome();
		areaPost(bufferPosts);
		areaStories(bufferStories);
		sezionePubblicaPost();
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
	public void setSearchButton(Pulsanti searchButton) {
		this.searchButton = searchButton;
	}
	public JButton getButtonPrevPost() {
		return buttonPrevPost;
	}
	public void setButtonPrevPost(Pulsanti buttonPrevPost) {
		this.buttonPrevPost = buttonPrevPost;
	}
	public JButton getButtonNextPost() {
		return buttonNextPost;
	}
	public void setButtonNextPost(Pulsanti buttonNextPost) {
		this.buttonNextPost = buttonNextPost;
	}
	public JButton getAggiungiLike() {
		return aggiungiLike;
	}
	public void setAggiungiLike(Pulsanti aggiungiLike) {
		this.aggiungiLike = aggiungiLike;
	}
	public JButton getAggiungiDislike() {
		return aggiungiDislike;
	}
	public void setAggiungiDislike(Pulsanti aggiungiDislike) {
		this.aggiungiDislike = aggiungiDislike;
	}
	public JButton getAggiungiCommento() {
		return aggiungiCommento;
	}
	public void setAggiungiCommento(Pulsanti aggiungiCommento) {
		this.aggiungiCommento = aggiungiCommento;
	}
	public JButton getButtonPrevStory() {
		return buttonPrevStory;
	}
	public void setButtonPrevStory(Pulsanti buttonPrevStory) {
		this.buttonPrevStory = buttonPrevStory;
	}
	public JButton getButtonNextStory() {
		return buttonNextStory;
	}
	public void setButtonNextStory(Pulsanti buttonNextStory) {
		this.buttonNextStory = buttonNextStory;
	}
	public Pulsanti getpPost() {
		return pPost;
	}
	public void setpPost(Pulsanti pPost) {
		this.pPost = pPost;
	}
	public Pulsanti getpStory() {
		return pStory;
	}
	public void setpStory(Pulsanti pStory) {
		this.pStory = pStory;
	}
	public Pulsanti getpSondaggio() {
		return pSondaggio;
	}
	public void setpSondaggio(Pulsanti pSondaggio) {
		this.pSondaggio = pSondaggio;
	}
	public Pulsanti getpIdea() {
		return pIdea;
	}

	public void setpIdea(Pulsanti pIdea) {
		this.pIdea = pIdea;
	}	

	public JButton getButtonImpostazioni() {
		return buttonImpostazioni;
	}

	public void setButtonImpostazioni(Pulsanti buttonImpostazioni) {
		this.buttonImpostazioni = buttonImpostazioni;
	}

	public JButton getButtonProfilo() {
		return buttonProfilo;
	}

	public void setButtonProfilo(Pulsanti buttonProfilo) {
		this.buttonProfilo = buttonProfilo;
	}

	public JButton getButtonChat() {
		return buttonChat;
	}

	public void setButtonChat(Pulsanti buttonChat) {
		this.buttonChat = buttonChat;
	}

	public JButton getButtonNotifiche() {
		return buttonNotifiche;
	}

	public void setButtonNotifiche(Pulsanti buttonNotifiche) {
		this.buttonNotifiche = buttonNotifiche;
	}

	public JTextField getTestoRicerca() {
		return testoRicerca;
	}

	public void getTestoRicerca(JTextField testoRicerca) {
		this.testoRicerca = testoRicerca;
	}
}