package panelspackage.panels.elements;
import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneLayout;
public class PannelloNotifiche extends JPanel {
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	int i;
	//public Pulsanti[] listaPulsanti;
	private ArrayList<Pulsanti> listaPulsanti  = new ArrayList<Pulsanti>();
	
	public PannelloNotifiche(ArrayList<String> contenuto, ArrayList<String> tipo ) {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);
		
		SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(contenuto.size(),1));
		
		for (i = 0; i < 5; i ++) {
			listaPulsanti.add(new Pulsanti(contenuto.get(i), ARANCIONE));
			containerCenter.add(listaPulsanti.get(i));
		}
	}

	public ArrayList<Pulsanti> getListaPulsanti() {
		return listaPulsanti;
	}

	public void setListaPulsanti(ArrayList<Pulsanti> listaPulsanti) {
		this.listaPulsanti = listaPulsanti;
	}
}
