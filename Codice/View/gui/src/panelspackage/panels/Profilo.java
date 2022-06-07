
package panelspackage.panels;
import javax.swing.*;
import packageframe.Frame;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;
public class  Profilo extends JPanel {

	private String idProfilo;
	ArrayList<JComponent> ListaEtichette = new ArrayList<JComponent>();
	ArrayList<Pulsanti> ListaPost = new ArrayList<Pulsanti>();
	ArrayList<AreaDiTesto> ListaTesti = new ArrayList<AreaDiTesto>();
	ArrayList<String> dati = new ArrayList<String>();
	ArrayList<AreaDiTesto> ListaSondaggi  = new ArrayList<AreaDiTesto>();
	private Pulsanti homeProfilo, immagineProf, segui, apriChat,nextFoto,prevFoto, nextSondaggio, prevSondaggio, nextTesto,prevTesto, nextTipoPost,prevTipoPost, pulsantePrimoSondaggio, pulsanteSecondoSondaggio, pulsanteTerzoSondaggio;
	private Etichette etichettaNome;
	private SpecificContainer containerNorth = new SpecificContainer(), containerCenter = new SpecificContainer(), containerNorthNorth = new SpecificContainer();
	
	private int contatoreFoto = 0, contatoreTesto = 0, contatoreSondaggio = 0;
	
	public Profilo(ArrayList<String> immaginiPost) {
		this.avvio();
		this.initComponents(immaginiPost);
	}
	
	
	public void avvio() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
	}
	
	public void initComponents(ArrayList<String> immaginiPost) {
		
		add(containerNorth, BorderLayout.NORTH);
		containerNorth.add(containerNorthNorth, BorderLayout.NORTH);
		containerNorthNorth.add(segui = new Pulsanti("Segui", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);
		containerNorthNorth.add(apriChat = new Pulsanti("Apri Chat", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerNorthNorth.add(etichettaNome = new Etichette("Nome utente", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.NORTH);
		immagineProf = new Pulsanti("/Users/tommasomasaracchio/immaginiDatabase/kushina3.jpg");
		JScrollPane pannelloFoto = new JScrollPane(immagineProf);
		pannelloFoto.setPreferredSize(new Dimension(500,500));
		containerNorth.add(pannelloFoto, BorderLayout.PAGE_START);

		dati.add("N.Post");
		dati.add(Integer.toString(0));
		dati.add("N.Follower");
		dati.add(Integer.toString(0));
		dati.add("N.Seguiti");
		dati.add(Integer.toString(0));
		
		for(int i = 0; i < this.dati.size(); i++) {
			Etichette etichetta = new Etichette(this.dati.get(i), Frame.COLOREPRIMARIOTEMATICO);
			ListaEtichette.add(etichetta);
			
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaEtichette,3,2, ListaEtichette.size());
		containerNorth.add(Dati, BorderLayout.SOUTH);		
		}
		
		
		SpecificContainer containerCenter = new SpecificContainer();
		add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(3,1));

		ListaPost.clear();
		for(int i = 0;  i < 3 ; i++) {
			ListaPost.add(new Pulsanti("/Users/tommasomasaracchio/immaginiDatabase/images.jpeg"));
			containerCenter.add(ListaPost.get(i));
		}
		
		SpecificContainer containerWest = new SpecificContainer();
		add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(6,1));

		ListaTesti.clear();
		for(int i = 0;  i < 3 ; i++) {
			AreaDiTesto textArea = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaTesti.add(textArea);
			containerWest.add(new Pulsanti("apri", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerWest.add(new JScrollPane(ListaTesti.get(i)), BorderLayout.PAGE_START);
		}
		SpecificContainer containerEast = new SpecificContainer();
		add(containerEast, BorderLayout.EAST);
		containerEast.setLayout(new GridLayout(6,1));

		
		ListaSondaggi.clear();
			AreaDiTesto testoPrimoSondaggio = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaSondaggi.add(testoPrimoSondaggio);
			containerEast.add(pulsantePrimoSondaggio = new Pulsanti("Primo sondaggio", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(ListaSondaggi.get(0)), BorderLayout.PAGE_START);
			
			AreaDiTesto testoSecondoSondaggio = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaSondaggi.add(testoSecondoSondaggio);
			containerEast.add(pulsanteSecondoSondaggio = new Pulsanti("Secondo sondaggio", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(ListaSondaggi.get(1)), BorderLayout.PAGE_START);
			
			AreaDiTesto testoTerzoSondaggio = new AreaDiTesto(Frame.getColoreprimariotematico(), 10, 20);
			ListaSondaggi.add(testoTerzoSondaggio);
			containerEast.add(pulsanteTerzoSondaggio = new Pulsanti("Terzo sondaggio", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.PAGE_START);
			containerEast.add(new JScrollPane(ListaSondaggi.get(2)), BorderLayout.PAGE_START);

		//ListaEtichetteMessaggi.add(nextMessaggio = new  Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO));
		//ListaEtichetteMessaggi.add(prevMessaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO));
		
		SpecificContainer containerSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
		this.add(containerSouth, BorderLayout.SOUTH);

		SpecificContainer containerGrigliaSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
		containerGrigliaSouth.setLayout(new GridLayout(1,6));
		
		containerGrigliaSouth.add(prevTesto = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerGrigliaSouth.add(nextTesto = new Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);
		containerGrigliaSouth.add(prevFoto = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerGrigliaSouth.add(nextFoto = new Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);
		containerGrigliaSouth.add(prevSondaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.WEST);
		containerGrigliaSouth.add(nextSondaggio = new Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);

		containerSouth.add(containerGrigliaSouth, BorderLayout.NORTH);
		containerSouth.add(homeProfilo = new Pulsanti("Torna alla Home", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.CENTER);
	}

	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaEtichette;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaEtichette = listaAreaTesto;
	}
	
	public Pulsanti getPulsanteFotoProfilo() {
		return this.immagineProf;
	}

	public void setHomeProfilo(Pulsanti homeProfilo) {
		this.homeProfilo = homeProfilo;
	}

	public Pulsanti getImmagineProf() {
		return immagineProf;
	}

	public void setImmagineProf(Pulsanti immagineProf) {
		
		this.immagineProf = immagineProf;
	}
	
	public Etichette getEtichettaNome() {
		return etichettaNome;
	}

	
	public void setSchermataDati(int nFollower, int nSeguiti, int nPost) {
		((JLabel) ListaEtichette.get(1)).setText(String.valueOf(nFollower));
		((JLabel) ListaEtichette.get(3)).setText(String.valueOf(nSeguiti));
		((JLabel) ListaEtichette.get(5)).setText(String.valueOf(nPost));
	}

	public Pulsanti getHomeProfilo() {
		return homeProfilo;
	}

	public void setPostProfilo(ArrayList<String> postDelProfilo) {
		int i;
		for (i = 0; i < postDelProfilo.size()/2 && i < 3 ; i++) {
			//System.out.println("stiamo aggiungendo : " + postDelProfilo.get((i*2)+1));
		//Icon img=new ImageIcon(postDelProfilo.get((i*2)+1));
			int indice =(i*2)+1;

		ListaPost.get(i).setIcon(new ImageIcon(postDelProfilo.get(indice)));
		}
		if (i<3) {
			for (int j = i; j < 3; j++) {
				Icon img2=new ImageIcon("immagini/images.png");
				ListaPost.get(j).setIcon(img2);
			}
		}
	}
	
	public void setPostTestoProfilo(ArrayList<String> postTestoDelProfilo) {
		for (int i = 0; i < postTestoDelProfilo.size() && i < 3 ; i++) {
			ListaTesti.get(i).setText(postTestoDelProfilo.get((i*2) + 1));
		}
	}
	public void setPostSondaggioProfilo(ArrayList<String> postSondaggioDelProfilo) {
		if(postSondaggioDelProfilo.size() < 3)  {
			for (int i = 0; i < postSondaggioDelProfilo.size() && i < 3 ; i++) {
		
			ListaSondaggi.get(i).setText("");
			}
		} else
		for (int i = 0; i < postSondaggioDelProfilo.size() && i < 6 ; i++) {
			ListaSondaggi.get(i).setText(postSondaggioDelProfilo.get((i*2) + 1));
		}
	}
	public void setFotoProfilo(String percorso) {
		this.immagineProf.setIcon(new ImageIcon(percorso));
	}

	public Pulsanti getPulsanteSegui() {
		return segui;
	}

	public Pulsanti getApriChat() {
		return apriChat;
	}


	public ArrayList<Pulsanti> getListaPost() {
		return ListaPost;
	}


	public void setListaPost(ArrayList<Pulsanti> listaPost) {
		ListaPost = listaPost;
	}


	public Pulsanti getNextFoto() {
		return nextFoto;
	}


	public Pulsanti getNextTipoPost() {
		return nextTipoPost;
	}


	public Pulsanti getPrevTipoPost() {
		return prevTipoPost;
	}


	public Pulsanti getPulsantePrimoSondaggio() {
		return pulsantePrimoSondaggio;
	}


	public Pulsanti getPulsanteSecondoSondaggio() {
		return pulsanteSecondoSondaggio;
	}


	public Pulsanti getPulsanteTerzoSondaggio() {
		return pulsanteTerzoSondaggio;
	}


	public int getContatoreFoto() {
		return contatoreFoto;
	}

	
	public void setContatoreFoto(int contatoreFoto) {
		this.contatoreFoto = contatoreFoto;
	}

	
	public int getContatoreTesto() {
		return contatoreTesto;
	}


	public void setContatoreTesto(int contatoreTesto) {
		this.contatoreTesto = contatoreTesto;
	}


	public int getContatoreSondaggio() {
		return contatoreSondaggio;
	}


	public void setContatoreSondaggio(int contatoreSondaggio) {
		this.contatoreSondaggio = contatoreSondaggio;
	}
	
	public void setNextFoto(Pulsanti nextFoto) {
		this.nextFoto = nextFoto;
	}


	public Pulsanti getPrevFoto() {
		return prevFoto;
	}


	public void setPrevFoto(Pulsanti prevFoto) {
		this.prevFoto = prevFoto;
	}


	public Pulsanti getNextSondaggio() {
		return nextSondaggio;
	}


	public void setNextSondaggio(Pulsanti nextSondaggio) {
		this.nextSondaggio = nextSondaggio;
	}


	public Pulsanti getPrevSondaggio() {
		return prevSondaggio;
	}


	public void setPrevSondaggio(Pulsanti prevSondaggio) {
		this.prevSondaggio = prevSondaggio;
	}


	public Pulsanti getNextTesto() {
		return nextTesto;
	}


	public void setNextTesto(Pulsanti nextTesto) {
		this.nextTesto = nextTesto;
	}


	public Pulsanti getPrevTesto() {
		return prevTesto;
	}


	public void setPrevTesto(Pulsanti prevTesto) {
		this.prevTesto = prevTesto;
	}
}