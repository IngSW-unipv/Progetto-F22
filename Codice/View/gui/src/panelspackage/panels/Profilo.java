
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

	private int i;
	ArrayList<JComponent> ListaEtichette = new ArrayList<JComponent>();
	ArrayList<Pulsanti> ListaPost = new ArrayList<Pulsanti>();
	ArrayList<String> dati = new ArrayList<String>();

	private Pulsanti homeProfilo, immagineProf, segui, apriChat;
	private Etichette etichettaNome;
	private SpecificContainer containerNorth = new SpecificContainer(), containerCenter = new SpecificContainer(), containerNorthNorth = new SpecificContainer();
	
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
		
		containerNorth.add(immagineProf = new Pulsanti("/Users/tommasomasaracchio/immaginiDatabase/kushina3.jpg"), BorderLayout.CENTER);

		dati.add("N.Post");
		dati.add(Integer.toString(0));
		dati.add("N.Follower");
		dati.add(Integer.toString(0));
		dati.add("N.Seguiti");
		dati.add(Integer.toString(0));
		
		for( i = 0; i < this.dati.size(); i++) {
			Etichette etichetta = new Etichette(this.dati.get(i), Frame.COLOREPRIMARIOTEMATICO);
			ListaEtichette.add(etichetta);
			
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaEtichette,3,2, ListaEtichette.size());
		containerNorth.add(Dati, BorderLayout.SOUTH);		
		}
		
		
		SpecificContainer containerCenter = new SpecificContainer();
		add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(3,3));

		ListaPost.clear();
		for( i = 0;  i < 9 ; i++) {
			ListaPost.add(new Pulsanti("/Users/tommasomasaracchio/immaginiDatabase/images.jpeg"));
			containerCenter.add(ListaPost.get(i));
		}
		
		SpecificContainer containerSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
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
		for (int i = 0; i < postDelProfilo.size()/2 && i < 9 ; i++) {	
		Icon img=new ImageIcon(postDelProfilo.get((i*2)+1));
		ListaPost.get(i).setIcon(img);
		}
	}
	
	public void setFotoProfilo(String percorso) {
		Pulsanti nuovaImmagine = new Pulsanti(percorso);
		this.setImmagineProf(nuovaImmagine);
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
	
	
	
	
}