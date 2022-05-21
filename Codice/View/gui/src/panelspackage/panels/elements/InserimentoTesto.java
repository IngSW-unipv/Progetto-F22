package panelspackage.panels.elements;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import packageframe.Frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class InserimentoTesto extends JTextField {
	public InserimentoTesto(String testo, Color colore, Font font) {
		this.setText(testo);
		this.setForeground(colore);
		this.setFont(font);
		this.setVisible(true);
	} 
	
	public InserimentoTesto(Color colore, Font font) {
		this.setForeground(colore);
		this.setFont(font);
		this.setVisible(true);
	} 
}
