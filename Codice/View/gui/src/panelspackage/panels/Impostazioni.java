package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Impostazioni extends JPanel {
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	
	public Impostazioni(String profilo) {
	
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		JLabel nomeProfilo = new JLabel(profilo);
		nomeProfilo.setVisible(true);
		nomeProfilo.setForeground(ARANCIONE);
		containerNorth.add(nomeProfilo, BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		

		containerCenter.setLayout(new GridLayout(4,2));
		
		containerCenter.add(new Etichette("Modifica profilo", ARANCIONE));
		containerCenter.add(new Etichette("Cambia profilo", ARANCIONE));
		containerCenter.add(new Etichette("Visibilità profilo", ARANCIONE));
		containerCenter.add(new Etichette("Visibilità post", ARANCIONE));
		containerCenter.add(new Etichette("Tema", ARANCIONE));
		containerCenter.add(new Etichette("Logout", ARANCIONE));
		containerCenter.add(new Etichette("Elimina Account", ARANCIONE));

		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		
	}
}
	
