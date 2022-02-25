package panelspackage.panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import panelspackage.panels.elements.AddPostButton;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Box;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Ricerca extends JPanel {
	
	int i;
	Color NERO = new Color(0,0,0);
	Color ARANCIONE = new Color(255, 125, 0);

	public Ricerca(String stringCercata, ArrayList<String> risultatiRicerca) {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		AddPostButton homeButton = new AddPostButton("Home", ARANCIONE);
		containerNorth.add(homeButton, BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		
		Etichette etichetta = new Etichette("Hai cercato " + stringCercata,ARANCIONE);
		containerNorth.add(etichetta, BorderLayout.SOUTH);
		
		containerCenter.setLayout(new GridLayout(10,1));
		
		for (i = 0; i < risultatiRicerca.size() & i < 10; i++) {
			containerCenter.add(new AddPostButton(risultatiRicerca.get(i), ARANCIONE));
		}
		
		SpecificContainer containerWest = new SpecificContainer();
		this.add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(10,1));
		for (i = 0; i < risultatiRicerca.size() & i < 10; i++) {
			containerWest.add(new Etichette("risultato"+ (i+1), ARANCIONE));
		}

		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
	}
}
