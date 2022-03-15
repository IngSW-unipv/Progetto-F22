package panelspackage.panels.elements;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

import packageframe.Frame;

public class ScrollText extends JScrollPane  {

	AreaDiTesto areaTesto;
	
	public ScrollText(int altezza, int base, String testo, Color colore, int orizzontale, int verticale) {
	AreaDiTesto areaTesto = new AreaDiTesto(colore, testo);
	areaTesto.setPreferredSize(new Dimension(altezza, base));
	areaTesto.setEditable(false);
	areaTesto.setLineWrap(true);
	setViewportView(areaTesto);
	this.setHorizontalScrollBarPolicy(orizzontale);
	this.setVerticalScrollBarPolicy( verticale);
	}
	
	public ScrollText(String testo, Color colore, int orizzontale, int verticale) {
		
			AreaDiTesto areaTesto = new AreaDiTesto(colore, testo);
			//this.setBounds(0, 0, 20, 1);
			areaTesto.setEditable(false);
			areaTesto.setLineWrap(true);
			setViewportView(areaTesto);
			this.setHorizontalScrollBarPolicy(orizzontale);
			this.setVerticalScrollBarPolicy(verticale);
		}

	public AreaDiTesto getAreaTesto() {
		return areaTesto;
	}
}
