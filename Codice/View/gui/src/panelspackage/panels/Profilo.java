
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
	private SpecificContainer containerNorth = new SpecificContainer(), containerCenter = new SpecificContainer();
	
	public Profilo(String NickName, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, ArrayList<String> immaginiPost) {
		this.avvio();
		this.initComponents( NickName,  numeroFollowers, numeroSeguiti, numeroPost, immagineProfilo, immaginiPost);
	}
	
	public void avvio() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
	}
	
	public void initComponents(String NickName, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, ArrayList<String> immaginiPost) {
		
		add(containerNorth, BorderLayout.NORTH);
		
		containerNorth.add(segui = new Pulsanti("Segui", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.EAST);
		containerNorth.add(immagineProf = new Pulsanti(immagineProfilo), BorderLayout.WEST);
		containerNorth.add(apriChat = new Pulsanti("Apri Chat"), BorderLayout.CENTER);
		containerNorth.add(etichettaNome = new Etichette(NickName, Frame.COLOREPRIMARIOTEMATICO), BorderLayout.NORTH);
		
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

	
	public void setSchermataDati(int numeroPost, int numeroFollowers, int numeroSeguiti) {
		dati.clear();
		dati.add("N.Post");
		dati.add(Integer.toString(numeroPost));
		dati.add("N.Follower");
		dati.add(Integer.toString(numeroFollowers));
		dati.add("N.Seguiti");
		dati.add(Integer.toString(numeroSeguiti));
		
		for( i = 0; i < this.dati.size(); i++) {
			Etichette etichetta = new Etichette(this.dati.get(i), Frame.COLOREPRIMARIOTEMATICO);
			ListaEtichette.add(etichetta);
			
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaEtichette,3,2, ListaEtichette.size());
		containerNorth.add(Dati, BorderLayout.SOUTH);		
		}
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
		this.immagineProf.setIcon(new ImageIcon(percorso));
	}

	public Pulsanti getPulsanteSegui() {
		return segui;
	}

	public Pulsanti getApriChat() {
		return apriChat;
	}
	
	
}