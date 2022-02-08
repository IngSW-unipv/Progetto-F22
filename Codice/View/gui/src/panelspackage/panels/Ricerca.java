package panelspackage.panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import panelspackage.panels.elements.SpecificContainer;

public class Ricerca extends JPanel {
	
	Color NERO = new Color(0,0,0);
	Color ARANCIONE = new Color(255, 125, 0);

	public Ricerca(String stringCercata/*, ArrayList<String> RisultatiRicerca*/) {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		JLabel etichetta = new JLabel("Hai cercato " + stringCercata);
		etichetta.setForeground(ARANCIONE);
		etichetta.setVisible(true);
		containerNorth.add(etichetta, BorderLayout.CENTER);
		
		//spazio per i risultati della ricerca
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);	
	
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.CENTER);
	}
}
