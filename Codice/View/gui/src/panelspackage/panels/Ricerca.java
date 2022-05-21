package panelspackage.panels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import packageframe.Frame;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Box;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.SpecificContainer;

public class Ricerca extends JPanel {
	
	private String stringCercata = "jkvk";
	private ArrayList<String> risultatiRicerca = new  ArrayList<String>();
	private SpecificContainer containerCenter = new SpecificContainer();
	private SpecificContainer containerWest = new SpecificContainer();

	private JButton homeRicerca;
	private Etichette etichetta = new Etichette("Hai cercato " + stringCercata, Frame.COLOREPRIMARIOTEMATICO);
	
	int i;

	public Ricerca() {
		
		avvio();
		initComponents();
	}
	
	public void avvio() {
		this.setOpaque(true);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
	}
	
	public void initComponents( ) {
		
		homeRicerca = new Pulsanti("Torna alla home", Frame.COLOREPRIMARIOTEMATICO);
		
		SpecificContainer containerCentrale = new SpecificContainer();
		add(containerCentrale, BorderLayout.CENTER);
		add(homeRicerca, BorderLayout.SOUTH);

		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		
		Pulsanti homeRicerca = new Pulsanti("Torna alla home", Frame.COLOREPRIMARIOTEMATICO);
		
		containerNorth.add(etichetta, BorderLayout.NORTH);
		containerSouth.add(homeRicerca,BorderLayout.SOUTH);

		add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(10,1));

		add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(10,1));
	}
	
	public void impostaRisultatiRicerca(ArrayList<String> risultatiRicerca) {

		for (int i = 0; i < risultatiRicerca.size() && i < 10; i++) {
			containerWest.add(new Pulsanti("ricerca numero: "+ (i+1), Frame.COLOREPRIMARIOTEMATICO));
		}
		
		for (int i = 0; i < risultatiRicerca.size() && i < 10; i++) {
			containerCenter.add(new Pulsanti(risultatiRicerca.get(i), Frame.COLOREPRIMARIOTEMATICO));
		}
	}

	public String getStringCercata() {
		return stringCercata;
	}

	public ArrayList<String> getRisultatiRicerca() {
		return risultatiRicerca;
	}

	public void setRisultatiRicerca(ArrayList<String> risultatiRicerca) {
		this.risultatiRicerca = risultatiRicerca;
	}

	public Pulsanti getHomeRicerca() {
		return (Pulsanti) homeRicerca;
	}

	public Etichette getTestoRicerca() {
		return etichetta;
	}

}
