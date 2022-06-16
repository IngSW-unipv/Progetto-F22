package panelspackage.panels.elements;

import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class InserimentoTesto extends JTextField {
	public InserimentoTesto(String testo, Color colore, Font font) {
		this.setText(testo);
		this.setForeground(colore);
		this.setFont(font);
		this.setVisible(true);
	} 
	
	public InserimentoTesto(String testo, Color colore) {
		this.setText(testo);
		this.setForeground(colore);
		this.setVisible(true);
	} 
	
	public InserimentoTesto(Color colore, Font font) {
		this.setForeground(colore);
		this.setFont(font);
		this.setVisible(true);
	} 
	
	public InserimentoTesto(String text, Color colore, Font font, int dim) {
		this.setText(text);
		this.setForeground(colore);
		this.setFont(font);
		this.setSize(dim,0);
		this.setVisible(true);
	}
}
