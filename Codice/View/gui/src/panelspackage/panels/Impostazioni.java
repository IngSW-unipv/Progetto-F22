package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

import panelspackage.panels.elements.AddPostButton;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Box;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Impostazioni extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	static String visibilita[]  = {"Pubblico", "Privato"};
	static String colori[] = {"arancione", "verde"};
	static String sesso[] = {"maschio", "femmina","altro"};
	public Impostazioni(String profilo) {
	
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		AddPostButton homeButton = new AddPostButton("Home", ARANCIONE);
		containerNorth.add(homeButton, BorderLayout.CENTER);
		
		Etichette nomeProfilo = new Etichette(profilo, ARANCIONE);
		containerNorth.add(nomeProfilo, BorderLayout.WEST);
		
		SpecificContainer containerWest = new SpecificContainer(ARANCIONE);
		this.add(containerWest, BorderLayout.WEST);
		

		containerWest.setLayout(new GridLayout(8,1));
		
		containerWest.add(new AddPostButton("Modifica profilo", NERO));
		containerWest.add(new AddPostButton("Cambia profilo", ARANCIONE));
		containerWest.add(new Box(getVisibilita(), ARANCIONE));
		containerWest.add(new AddPostButton("Visibilità post", ARANCIONE));
		containerWest.add(new Box(getColori(), ARANCIONE));
		containerWest.add(new AddPostButton("Logout", ARANCIONE));
		containerWest.add(new AddPostButton("Elimina Account", ARANCIONE));

		
		SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
		this.add(containerCenter, BorderLayout.CENTER);
		

		containerCenter.setLayout(new GridLayout(4,1));
		
		containerCenter.add(new AreaDiTesto(ARANCIONE, "inserisci la tua nuova descrizione profilo"));
		containerCenter.add(new Box(getSesso(), ARANCIONE));
		containerCenter.setVisible(false);

		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		
		
		Etichette etichettaSud = new Etichette("Sezione Inferiore", ARANCIONE);
		containerSouth.add(etichettaSud, BorderLayout.CENTER);
	}
	public String[] getVisibilita() {
		return visibilita;
	}

	public String[] getColori() {
		return colori;
	}

	public String[] getSesso() {
		return sesso;
	}

}
	
