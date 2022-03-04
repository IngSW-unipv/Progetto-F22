package panelspackage.panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;

import packageframe.Frame;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Box;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Ricerca extends JPanel {
	
	int i;

	public Ricerca(String stringCercata, ArrayList<String> risultatiRicerca) {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		JLabel etichetta = new JLabel("Hai cercato " + stringCercata);
		etichetta.setForeground(Frame.COLOREPRIMARIOTEMATICO);
		etichetta.setVisible(true);
		containerNorth.add(etichetta, BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(10,1));
		
		for (i = 0; i < risultatiRicerca.size() & i < 10; i++) {
			containerCenter.add(new Pulsanti(risultatiRicerca.get(i), Frame.COLOREPRIMARIOTEMATICO));
		}
		
		SpecificContainer containerWest = new SpecificContainer();
		this.add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(10,1));
		for (i = 0; i < risultatiRicerca.size() & i < 10; i++) {
			containerWest.add(new Etichette("risultato"+ (i+1), Frame.COLOREPRIMARIOTEMATICO));
		}

		/*containerCenter.add(new Etichette("primorisultato", COLOREPRIMARIOTEMATICO));
		containerCenter.add(new Etichette("secondorisultato", COLOREPRIMARIOTEMATICO));
		containerCenter.add(new Etichette("terzorisultato", COLOREPRIMARIOTEMATICO));
		containerCenter.add(new Etichette("quartorisultato", COLOREPRIMARIOTEMATICO));
		containerCenter.add(new Etichette("terzorisultato", COLOREPRIMARIOTEMATICO));
		containerCenter.add(new Etichette("risultato", COLOREPRIMARIOTEMATICO));
		*/
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
	}
}
