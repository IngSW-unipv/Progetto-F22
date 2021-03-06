package panelspackage.panels;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.SpecificContainer;
import post.multimedia.foto.Foto;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.border.LineBorder;

import packageframe.Frame;
	
public class Home extends JPanel {
	
	int i;

	SpecificContainer containerNorth, containerSouth, containerEast, containerWest, containerCenter, containerPost, containerStory;
	private int indiceBufferStories, indiceBufferPosts;
	private Font fontTitle, fontText, fontButton;
	private Pulsanti postPrincipale, creaUnaChatDiGruppo, buttonPrevPost,buttonNextPost,aggiungiLike,aggiungiDislike,aggiungiCommento,buttonPrevStory,buttonNextStory,
					 buttonImpostazioni,buttonProfilo,buttonChat,pPost,pSondaggioDoppiaScelta,pSondaggioSceltaMultipla,pIdea, searchButton, primaStoria,
					 secondaStoria,
					 terzaStoria,
					  quartaStoria, quintaStoria ;
	
	private Etichette numeroLike, numeroDislike,  numeroCommenti, etichettaRicerca;
	private InserimentoTesto testoRicerca;
	public static final  Color NERO = new Color(0,0,0);	
	private int contatorePost = 0;
	private String percorsoPost, percorsoPrimaStoria, percorsoSecondaStoria, percorsoTerzaStoria, percorsoQuartaStoria, percorsoQuintaStoria;
	private ArrayList<Pulsanti> listaPost = new ArrayList<Pulsanti>();
	private ArrayList<Pulsanti> listaPulsantiStorie = new ArrayList<Pulsanti>();
	private int indiceStorie = 0;
	
	public Home() {
		fontText = new Font("Arial", Font.PLAIN, 20);	
		fontTitle = new Font("Arial", Font.BOLD, 30);
		fontButton = new Font("Arial", Font.BOLD, 15);	
		avvio();		
		this.initComponents();
	}
	
			
	public void avvio() {	
		
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);
		this.add(containerNorth = new SpecificContainer(), BorderLayout.NORTH);
		this.add(containerCenter = new SpecificContainer(), BorderLayout.CENTER);
	}

	public void menuHome() {

		postPrincipale = new Pulsanti("");
		SpecificContainer areaRicerca = new SpecificContainer();
		containerNorth.add(areaRicerca, BorderLayout.SOUTH);
		
		areaRicerca.add(etichettaRicerca = new Etichette("Cerca un profilo: ", Color.LIGHT_GRAY, Frame.COLOREPRIMARIOTEMATICO,fontText), BorderLayout.WEST);
		//areaRicerca.add(testoRicerca = new AreaDiTesto(Color.LIGHT_GRAY, Frame.COLOREPRIMARIOTEMATICO, "", fontText), BorderLayout.CENTER);
		areaRicerca.add(testoRicerca = new InserimentoTesto("", Frame.COLOREPRIMARIOTEMATICO, fontText));
		areaRicerca.add(searchButton = new Pulsanti("CERCA", fontButton), BorderLayout.EAST);
		searchButton.setEnabled(true);
		
		SpecificContainer menuHome = new SpecificContainer();
		containerNorth.add(menuHome, BorderLayout.NORTH);
		
		containerNorth.add(new Etichette("MASA-Gram", Frame.COLOREPRIMARIOTEMATICO, fontTitle), BorderLayout.CENTER);	
			
		SpecificContainer menuHomeSinistro = new SpecificContainer();
		containerNorth.add(menuHomeSinistro, BorderLayout.WEST);
		SpecificContainer menuHomeDestro = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO, Frame.COLORESECONDARIOTEMATICO);
		containerNorth.add(menuHomeDestro, BorderLayout.EAST);			

		menuHomeSinistro.add(buttonProfilo = new Pulsanti("immagini/profilo.png"), BorderLayout.EAST);
		menuHomeSinistro.add(buttonImpostazioni = new Pulsanti("immagini/impostazioni.png"), BorderLayout.WEST);

		menuHomeDestro.add(buttonChat = new Pulsanti("immagini/testo.jpeg"), BorderLayout.WEST);

	}
	
	public void aggiornaPostHome() {
		postPrincipale.impostaPercorsoPost(percorsoPost);	//Aggiorna il percorso del post che deve essere visualizzato
		containerPost.add(postPrincipale);
        this.invalidate();
        this.validate();
        this.repaint();
	}
	
	public void rimuoviPostHome() {
		containerPost.remove(postPrincipale);
	}
	
	
	public void areaPost() {
		containerPost = new SpecificContainer();
		containerCenter.add(containerPost, BorderLayout.CENTER);
		
		
		SpecificContainer containerCosePost = new SpecificContainer();
		
		AreaDiTesto areaDescrizione = new AreaDiTesto("DESCRIZIONE POST\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.",400, 130);
		JScrollPane scrollAreaDescrizione = new JScrollPane(areaDescrizione, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		
		SpecificContainer containerBottoniPost = new SpecificContainer();
		containerBottoniPost.setLayout(new GridLayout(1, 2));
		containerBottoniPost.add(buttonPrevPost = new Pulsanti("Post precedente", fontButton));
		containerBottoniPost.add(buttonNextPost = new Pulsanti("Post successivo",fontButton));

		containerCosePost.add(containerBottoniPost, BorderLayout.SOUTH);
		containerPost.add(containerCosePost, BorderLayout.SOUTH);		
	}
	
	
	
	public void setPercorsiStorie(ArrayList<String> storieDaVisualizzare) {
		boolean flag = true;
		int i = 0;
		if (this.indiceStorie <= 0) {
			indiceStorie = 0;
    	}
		
    	if (indiceStorie > storieDaVisualizzare.size()-10) {
    		indiceStorie = storieDaVisualizzare.size() - 10;

    	}

		while(flag) {
			if (this.indiceStorie < 0) {
				indiceStorie = 0;
	    	}	
			int indice =(i*2) + 1 + indiceStorie;
			String percorso = storieDaVisualizzare.get(indice);
			listaPulsantiStorie.get(i).setIcon(new ImageIcon(percorso));
			i++;			
			if(i < storieDaVisualizzare.size()/2) {
			} else {
				flag = false;
			}
			if(i == 5) {
				flag  =false;
			} 
		}		
	}
		
	
	
	public void areaStories() {
		SpecificContainer containerWest = new SpecificContainer();
		containerStory = new SpecificContainer();
		SpecificContainer containerButtonStory = new SpecificContainer();
		
		containerWest.add(containerStory = new SpecificContainer(), BorderLayout.CENTER);
		containerStory.setLayout(new GridLayout(5,1));
		containerCenter.add(containerWest, BorderLayout.WEST);
	
		containerButtonStory.setLayout(new GridLayout(1, 2));
		containerButtonStory.add(buttonPrevStory = new Pulsanti("<-", Frame.COLORESECONDARIOTEMATICO));
		containerButtonStory.add(buttonNextStory = new  Pulsanti("->", Frame.COLORESECONDARIOTEMATICO));
		containerWest.add(containerButtonStory, BorderLayout.SOUTH);
		
		
		listaPulsantiStorie.add(primaStoria = new Pulsanti("", 150, 150));
		listaPulsantiStorie.add(secondaStoria = new Pulsanti("", 150, 150));
		listaPulsantiStorie.add(terzaStoria = new Pulsanti("", 150, 150));
		listaPulsantiStorie.add(quartaStoria = new Pulsanti("", 150, 150));
		listaPulsantiStorie.add(quintaStoria = new Pulsanti("", 150, 150));

		containerStory.add(primaStoria);
		containerStory.add(secondaStoria);
		containerStory.add(terzaStoria);
		containerStory.add(quartaStoria);
		containerStory.add(quintaStoria);
	}
	
		public void sezionePubblicaPost() {
			
			SpecificContainer containerSud = new SpecificContainer();
			this.add(containerSud, BorderLayout.SOUTH);
			
			containerSud.setLayout(new GridLayout(1,5));

			containerSud.add(pPost =  new Pulsanti("Pubblica un post", Frame.COLOREPRIMARIOTEMATICO, fontButton));
			containerSud.add(pSondaggioDoppiaScelta =  new Pulsanti("Sondaggio due scelte", Frame.COLOREPRIMARIOTEMATICO,fontButton));
			containerSud.add(pSondaggioSceltaMultipla =  new Pulsanti("Sondaggio piu' scelte", Frame.COLOREPRIMARIOTEMATICO, fontButton));
			containerSud.add(pIdea =  new Pulsanti("Pubblica un'idea", Frame.COLOREPRIMARIOTEMATICO,fontButton));
			containerSud.add(creaUnaChatDiGruppo =  new Pulsanti("CreaChatDiGruppo", Frame.COLOREPRIMARIOTEMATICO,fontButton));

		}
		
	public void initComponents() {
		menuHome();
		areaPost();
		areaStories();
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
	
	public Pulsanti getpSondaggioDoppiaVotazione() {
		return pSondaggioDoppiaScelta;
	}
	
	public void setpSondaggioDoppiaVotazione(Pulsanti pSondaggioDoppiaScelta) {
		this.pSondaggioDoppiaScelta = pSondaggioDoppiaScelta;
	}
	
	public Pulsanti getpSondaggioSceltaMultipla() {
		return pSondaggioSceltaMultipla;
	}
	
	public void setpSondaggioSceltaMultipla(Pulsanti pSondaggioSceltaMultipla) {
		this.pSondaggioSceltaMultipla = pSondaggioSceltaMultipla;
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

	public JTextField getTestoRicerca() {
		return testoRicerca;
	}

	public void getTestoRicerca(InserimentoTesto testoRicerca) {
		this.testoRicerca = testoRicerca;
	}


	public Pulsanti getCreaUnaChatDiGruppo() {
		return creaUnaChatDiGruppo;
	}


	public int getContatorePost() {
		return contatorePost;
	}


	public void setContatorePost(int contatorePost) {
		this.contatorePost = contatorePost;
	}


	public String getPercorsoPost() {
		return percorsoPost;
	}

	public void setPercorsoPost(String percorsoPost) {
		this.percorsoPost = percorsoPost;
	}


	public Pulsanti getPostPrincipale() {
		return postPrincipale;
	}


	public void setPostPrincipale(Pulsanti postPrincipale) {
		this.postPrincipale = postPrincipale;
	}


	public int getIndiceStorie() {
		return indiceStorie;
	}


	public void setIndiceStorie(int indiceStorie) {
		this.indiceStorie = indiceStorie;
	}


	public Pulsanti getPrimaStoria() {
		return primaStoria;
	}


	public void setPrimaStoria(Pulsanti primaStoria) {
		this.primaStoria = primaStoria;
	}


	public Pulsanti getSecondaStoria() {
		return secondaStoria;
	}


	public void setSecondaStoria(Pulsanti secondaStoria) {
		this.secondaStoria = secondaStoria;
	}


	public Pulsanti getTerzaStoria() {
		return terzaStoria;
	}


	public void setTerzaStoria(Pulsanti terzaStoria) {
		this.terzaStoria = terzaStoria;
	}


	public Pulsanti getQuartaStoria() {
		return quartaStoria;
	}


	public void setQuartaStoria(Pulsanti quartaStoria) {
		this.quartaStoria = quartaStoria;
	}


	public Pulsanti getQuintaStoria() {
		return quintaStoria;
	}


	public void setQuintaStoria(Pulsanti quintaStoria) {
		this.quintaStoria = quintaStoria;
	}
	
	
	
}