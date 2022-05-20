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
	
	private String stringCercata = "";
	private ArrayList<String> risultatiRicerca;
	
	private JButton homeRicerca;
	private JLabel testoRicerca;
	

	public Ricerca() {
		
		this.setOpaque(true);
		this.setVisible(false);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);	
		
		homeRicerca = new JButton("Torna alla home");
		
		
		SpecificContainer containerCentrale = new SpecificContainer();
		this.add(containerCentrale, BorderLayout.CENTER);
		this.add(homeRicerca, BorderLayout.SOUTH);
		
		

		/*SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.SOUTH);
		
		homeRicerca = new JButton("Torna alla home");
		
		JLabel etichetta = new JLabel("Hai cercato " + stringCercata);
		
		etichetta.setForeground(Frame.COLOREPRIMARIOTEMATICO);
		etichetta.setVisible(true);
		
		containerNorth.add(etichetta);
		containerSouth.add(homeRicerca);*/
		
		/*SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(10,1));*/
		
		/*for (int i = 0; i < risultatiRicerca.size() & i < 10; i++) {
			containerCenter.add(new Pulsanti(risultatiRicerca.get(i), Frame.COLOREPRIMARIOTEMATICO));
		}*/
		
		/*SpecificContainer containerWest = new SpecificContainer();
		this.add(containerWest, BorderLayout.WEST);
		containerWest.setLayout(new GridLayout(10,1));*/
		/*for (int i = 0; i < risultatiRicerca.size() & i < 10; i++) {
			containerWest.add(new Etichette("risultato"+ (i+1), Frame.COLOREPRIMARIOTEMATICO));
		}*/

	}


	public String getStringCercata() {
		return stringCercata;
	}

	public void setStringCercata(String stringCercata) {
		
		this.stringCercata = stringCercata;
	}

	public ArrayList<String> getRisultatiRicerca() {
		return risultatiRicerca;
	}

	public void setRisultatiRicerca(ArrayList<String> risultatiRicerca) {
		this.risultatiRicerca = risultatiRicerca;
	}


	public JButton getHomeRicerca() {
		return homeRicerca;
	}


	public void setHomeRicerca(JButton homeRicerca) {
		this.homeRicerca = homeRicerca;
	}
	
	
	public void impostaStringaCercata() {
		testoRicerca = new JLabel("Hai cercato: " + stringCercata);
		testoRicerca.setForeground(Frame.COLOREPRIMARIOTEMATICO);
		this.add(testoRicerca, BorderLayout.NORTH);
	}

}
