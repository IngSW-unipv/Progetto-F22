package panelspackage.panels;
import packageframe.Frame;
import javax.swing.*;

import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;

import java.awt.*;
public class SchermataConferma extends JPanel {
	
	Pulsanti conferma, negazione;

	//la stringa richiesta ricordera a quella richiesta va data conferma
	
	public SchermataConferma(String richiesta) {
		
		avvio();
		initComponents(richiesta);
	}
	
	public void avvio() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLOREPRIMARIOTEMATICO);
	}
	
	public void initComponents(String richiesta) {
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		
		Etichette motivoCreazionePannello = new Etichette(richiesta, Frame.COLOREPRIMARIOTEMATICO);
	
		motivoCreazionePannello.setForeground(Frame.COLOREPRIMARIOTEMATICO);
		containerNorth.add(motivoCreazionePannello, BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		this.add(containerCenter, BorderLayout.CENTER);
		containerCenter.setLayout(new GridLayout(1,2));

		containerCenter.add(conferma = new Pulsanti("Si!", Frame.COLOREPRIMARIOTEMATICO));
		containerCenter.add(negazione = new Pulsanti("No!", Frame.COLOREPRIMARIOTEMATICO));

	}
}