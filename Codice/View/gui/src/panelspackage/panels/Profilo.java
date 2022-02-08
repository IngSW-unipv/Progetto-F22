package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

import panelspackage.panels.elements.AddPostButton;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Profilo extends JPanel {
	
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	
	public Profilo(String profilo) {
	
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		//this.setBackground(NERO);	
		
		//da aggiungere la foto del profilo. il nome ed una foto di copertina 
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		JLabel nomeProfilo = new JLabel(profilo);
		nomeProfilo.setVisible(true);
		nomeProfilo.setForeground(ARANCIONE);
		containerNorth.add(nomeProfilo, BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		
		this.add(containerCenter, BorderLayout.WEST);
		containerCenter.setLayout(new GridLayout(1,3));
		
		containerCenter.add(new Etichette("N.Post", ARANCIONE));
		containerCenter.add(new Etichette("N.Follower", ARANCIONE));
		containerCenter.add(new Etichette("N.Seguiti", ARANCIONE));
		
		/*
		SpecificContainer informazioniProfiloEst = new SpecificContainer();
		containerCenter.add(informazioniProfiloEst, BorderLayout.EAST);
		containerCenter.setBackground(ARANCIONE);
		containerCenter.setVisible(true);
		
		SpecificContainer informazioniProfiloOvest = new SpecificContainer();
		containerCenter.add(informazioniProfiloEst, BorderLayout.WEST);
		informazioniProfiloOvest.setLayout(new GridLayout(1,3));
		
		informazioniProfiloOvest.add(new Etichette("N.Post", ARANCIONE));
		informazioniProfiloOvest.add(new Etichette("N.Follower", ARANCIONE));
		informazioniProfiloOvest.add(new Etichette("N.Seguiti", ARANCIONE));
		*/
		
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
	}
}
