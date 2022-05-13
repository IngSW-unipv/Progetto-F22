
package panelspackage.panels;
import javax.swing.*;
import packageframe.Frame;


import java.awt.*;
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
	ArrayList<JComponent> ListaPost = new ArrayList<JComponent>();
	ArrayList<String> dati = new ArrayList<String>();

	private Pulsanti homeProfilo, immagineProf;
	private Etichette etichettaNome;

	
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
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		containerNorth.add(immagineProf = new Pulsanti(immagineProfilo), BorderLayout.WEST);
		containerNorth.add(etichettaNome = new Etichette(NickName, Frame.COLOREPRIMARIOTEMATICO), BorderLayout.NORTH);
		System.out.print(true);
		
		this.dati.add("N.Post");
		this.dati.add(Integer.toString(numeroPost));
		this.dati.add("N.Follower");
		this.dati.add(Integer.toString(numeroFollowers));
		this.dati.add("N.Seguiti");
		this.dati.add(Integer.toString(numeroSeguiti));
		
		ListaEtichette.clear();
		for( i = 0; i < this.dati.size(); i++) {
			Etichette etichetta = new Etichette(this.dati.get(i), Frame.COLOREPRIMARIOTEMATICO);
			ListaEtichette.add(etichetta);
		}
		
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaEtichette,3,2, ListaEtichette.size());
		containerNorth.add(Dati, BorderLayout.SOUTH);
		
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(3,3));

		ListaPost.clear();
		for( i = 0; i < immaginiPost.size() && i < 9 ; i++) {
			ListaPost.add(new LabeledIcon(immaginiPost.get(i)));
			containerCenter.add(ListaPost.get(i));
		}
		
		SpecificContainer containerSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
		containerSouth.add(homeProfilo= new Pulsanti("Torna alla Home", Frame.COLOREPRIMARIOTEMATICO), BorderLayout.CENTER);
	}
	

	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaEtichette;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaEtichette = listaAreaTesto;
	}
	
	
	//GETTER E SETTER PULSANTI
	public Pulsanti getHomeProfilo() {
		return homeProfilo;
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
	
}