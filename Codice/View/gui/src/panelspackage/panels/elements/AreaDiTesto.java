package panelspackage.panels.elements;


import javax.swing.JTextArea;
import javax.swing.border.Border;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

@SuppressWarnings("serial")
public class AreaDiTesto extends JTextArea {

	public AreaDiTesto(Color colore, String stringa) {
		this.setText(stringa);
		this.setBackground(colore);
		this.setVisible(true);
	}
	
	public AreaDiTesto(Color colore, String stringa, int i, int numeroRighe, int lunghezzaMassimaTesto, Font font) {
		this.setText(stringa);
		this.setBackground(colore);
		this.setVisible(true);
		this.isMaximumSizeSet();
		this.setFont(font);
		this.setBounds(0, 0, numeroRighe,lunghezzaMassimaTesto );
	}
	
	public AreaDiTesto(Color colore, String stringa, int i, int numeroRighe, int lunghezzaMassimaTesto) {
		this.setText(stringa);
		this.setBackground(colore);
		this.setVisible(true);
		this.setBounds(0, 0, numeroRighe, lunghezzaMassimaTesto);
	}
	
	public AreaDiTesto(Color colore1, Color colore2, String stringa, Font font) {
		this.setText(stringa);
		this.setBackground(colore1);
		this.setForeground(colore2);
		this.setFont(font);
		this.setVisible(true);
	}
	
	public AreaDiTesto(String stringa,int base, int altezza) {
		this.setPreferredSize(new Dimension(base, altezza));
		this.setEditable(false);
		this.setLineWrap(true);
	}

	public AreaDiTesto(Border border, Font font) {
	this.setBorder(border);
	this.setFont(font);
	}
	
	public AreaDiTesto(Color colore, int base, int altezza, Font font) {
		this.setBackground(colore);
		this.setPreferredSize(new Dimension(base, altezza));
		this.setEditable(false);
		this.setLineWrap(true);
		this.setFont(font);
	}
}
