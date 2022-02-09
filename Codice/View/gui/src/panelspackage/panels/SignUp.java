package panelspackage.panels;
import javax.swing.*;


import java.awt.*;
import java.util.ArrayList;

import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;
public class SignUp extends JPanel {
	
	ArrayList<JComponent> ListaAreaTesto = new ArrayList<JComponent>();
	ArrayList<String> dati = new ArrayList<String>();
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	int i;
	
	public SignUp() {
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		Etichette etichetta = new Etichette("Schermata Sign Up", ARANCIONE);
		containerNorth.add(etichetta, BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
		this.add(containerCenter, BorderLayout.CENTER);
		
		this.dati.add("Email");
		this.dati.add("Password");
		this.dati.add("RipetiPassword");
		this.dati.add("NickName");
		for( i = 0; i < this.dati.size(); i++) {
			AreaDiTesto area = new AreaDiTesto(ARANCIONE, this.dati.get(i), 1);
			ListaAreaTesto.add(area);
		}
		
		GrigliaDiElementi Dati =  new GrigliaDiElementi(ListaAreaTesto,5,1, ListaAreaTesto.size());
		containerCenter.add(Dati, BorderLayout.NORTH);
		
		SpecificContainer containerSouth = new SpecificContainer(NERO);
		this.add(containerSouth, BorderLayout.SOUTH);
		
		Etichette etichettaSud = new Etichette("Sezione Inferiore", ARANCIONE);
		containerSouth.add(etichettaSud, BorderLayout.CENTER);
	}

	public ArrayList<JComponent> getListaAreaTesto() {
		return ListaAreaTesto;
	}

	public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
		ListaAreaTesto = listaAreaTesto;
	}
}