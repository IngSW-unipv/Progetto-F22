
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
	private int i;
	private JButton homeProfilo;
	
	public Profilo(String NickName, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] immaginiPost) {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		LabeledIcon immagine = new LabeledIcon(immagineProfilo);
		containerNorth.add(immagine, BorderLayout.WEST);
		
		Etichette etichetta = new Etichette(NickName, ARANCIONE);
		containerNorth.add(etichetta, BorderLayout.NORTH);
		
		
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
		
		homeProfilo = new AddPostButton("Torna alla Home", NERO);
		containerSouth.add(homeProfilo, BorderLayout.CENTER);
	}

	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaEtichette;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaEtichette = listaAreaTesto;
	}
	
	
	//GETTER E SETTER PULSANTI
	public JButton getHomeProfilo() {
		return homeProfilo;
	}

	public void setHomeProfilo(JButton homeProfilo) {
		this.homeProfilo = homeProfilo;
	}
	
	
}