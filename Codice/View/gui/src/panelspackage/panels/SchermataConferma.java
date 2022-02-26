package panelspackage.panels;
import javax.swing.*;

import panelspackage.panels.elements.AddPostButton;
import panelspackage.panels.elements.SpecificContainer;

import java.awt.*;
public class SchermataConferma extends JPanel {

	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	//la stringa richiesta ricordera a quella richiesta va data conferma
	
	public SchermataConferma(String richiesta) {
		
			this.setOpaque(true);
			this.setVisible(true);
			this.setLayout(new BorderLayout());
			this.setBackground(ARANCIONE);

			SpecificContainer containerNorth = new SpecificContainer();
			this.add(containerNorth, BorderLayout.NORTH);
			
			JLabel motivoCreazionePannello = new JLabel(richiesta);
			motivoCreazionePannello.setVisible(true);
			
			motivoCreazionePannello.setForeground(ARANCIONE);
			containerNorth.add(motivoCreazionePannello, BorderLayout.CENTER);
			
			SpecificContainer containerCenter = new SpecificContainer(ARANCIONE);
			this.add(containerCenter, BorderLayout.CENTER);
			containerCenter.setLayout(new GridLayout(1,2));
			
			AddPostButton conferma = new AddPostButton("Si!", ARANCIONE);
			AddPostButton negazione = new AddPostButton("No!", ARANCIONE);
					
			containerCenter.add(negazione);
			containerCenter.add(negazione);

	}
}