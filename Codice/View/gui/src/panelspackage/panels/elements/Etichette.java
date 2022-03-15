package panelspackage.panels.elements;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import packageframe.Frame;

public class Etichette extends JLabel {
	
	public Etichette(String testo, Color colore) {
		
		this.setText(testo);
		this.setForeground(colore);
		this.setVisible(true);
		
	}
	
	public Etichette(String testo, Color colore, Font font) {
		
		this.setText(testo);
		this.setForeground(colore);
		this.setVisible(true);
		this.setForeground(colore);
		this.setFont(font);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		
	}

	public Etichette(String testo, int swingContant, Color colore, Font font) {
		this.setText(testo);
		this.setForeground(colore);
		this.setVisible(true);
		this.setFont(font);
		this.setHorizontalAlignment(swingContant);
	}
	public Etichette(String testo, Color colore1, Color colore2, Font font) {
		
		this.setText(testo);
		this.setVisible(true);
		this.setBackground(colore1);
		this.setForeground(colore2);
		this.setFont(font);

	}
}
