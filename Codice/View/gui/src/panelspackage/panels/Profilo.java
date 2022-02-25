
package panelspackage.panels;
import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.LabeledIcon;
import panelspackage.panels.elements.AddPostButton;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;
public class  Profilo extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	ArrayList<JComponent> ListaEtichette = new ArrayList<JComponent>();
	ArrayList<String> dati = new ArrayList<String>();
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	int i;
	
	public Profilo(String cickName, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] immaginiPost) {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		LabeledIcon immagine = new LabeledIcon(immagineProfilo);
		containerNorth.add(immagine, BorderLayout.WEST);
		
		SpecificContainer containerHome = new SpecificContainer();
		containerNorth.add(containerHome, BorderLayout.NORTH);
		
		Etichette nickNameLabel = new Etichette(cickName, ARANCIONE);
		containerHome.add(nickNameLabel, BorderLayout.WEST);
		
		Etichette altraLabel = new Etichette("altro", ARANCIONE);
		containerHome.add(altraLabel, BorderLayout.EAST);
		
		AddPostButton homeButton = new AddPostButton("Home", ARANCIONE);
		containerHome.add(homeButton, BorderLayout.CENTER);
		
		
		this.dati.add("N.Post");
		this.dati.add(Integer.toString(numeroPost));
		this.dati.add("N.Follower");
		this.dati.add(Integer.toString(numeroFollowers));
		this.dati.add("N.Seguiti");
		this.dati.add(Integer.toString(numeroSeguiti));
		for( i = 0; i < this.dati.size(); i++) {
			Etichette area = new Etichette(this.dati.get(i), ARANCIONE);
			ListaEtichette.add(area);
		}
		
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaEtichette,3,2, ListaEtichette.size());
		containerNorth.add(Dati, BorderLayout.SOUTH);
		
		SpecificContainer containerCenter = new SpecificContainer(NERO, ARANCIONE);
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(3,3));

		for( i = 0; i < immaginiPost.length || i > 9 ; i++) {
			containerCenter.add(new LabeledIcon(immaginiPost[i]));
		}
		
		SpecificContainer containerSouth = new SpecificContainer(NERO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
		Etichette etichettaSud = new Etichette("Sezione Inferiore", ARANCIONE);
		containerSouth.add(etichettaSud, BorderLayout.CENTER);
	}

	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaEtichette;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaEtichette = listaAreaTesto;
	}
}