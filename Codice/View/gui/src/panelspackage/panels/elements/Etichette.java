package panelspackage.panels.elements;

import java.awt.Color;
import javax.swing.JLabel;

public class Etichette extends JLabel {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Etichette(String testo, Color colore) {
		
		this.setText(testo);
		this.setForeground(colore);
		this.setVisible(true);
		
	}
}
