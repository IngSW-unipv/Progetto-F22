package panelspackage.panels.elements;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

public class Pulsanti extends JButton{

	public Pulsanti(String name, Color colore) {
		this.setForeground(colore);
		this.setText(name);
		this.setVisible(true);
	}
	
	public Pulsanti(String name, Font font) {
		this.setFont(font);
		this.setLabel(name);
		this.setVisible(true);
	}
	
	public Pulsanti(String name, Color colore, Font font) {
		this.setFont(font);
		this.setLabel(name);
		this.setForeground(colore);
		this.setVisible(true);
	}
	
	public Pulsanti(String icona) {
		Icon profileLabel = new ImageIcon(icona);
		this.setIcon(profileLabel);
		this.setVisible(true);
	}
	
	public Pulsanti(String icona, Color colore, int dim) {
		Icon profileLabel = new ImageIcon(icona);
		this.setIcon(profileLabel);
		this.setBorder(new LineBorder(colore,dim));
		this.setVisible(true);
	}
	
	public void impostaPercorsoPost(String percorsoPost) {
		Icon profileLabel = new ImageIcon(percorsoPost);
		this.setIcon(profileLabel);
		this.setVisible(true);
	}
	
	public Pulsanti(String icona, int dim1, int dim2) {
		Icon profileLabel = new ImageIcon(icona);
		this.setIcon(profileLabel);
		this.setVisible(true);
		this.setPreferredSize(new Dimension(dim1, dim2));
	}
		
}
