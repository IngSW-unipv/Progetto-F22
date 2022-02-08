package panelspackage.panels;
import javax.swing.*;

import java.awt.*;
import panelspackage.panels.elements.SpecificContainer;
public class LogIn extends JPanel {
	
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	
	public LogIn(){
		
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);

		JLabel etichetta = new JLabel("Schermata Login");
		etichetta.setVisible(true);
		containerNorth.add(etichetta, BorderLayout.CENTER);
		
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		
		SpecificContainer containerSouth = new SpecificContainer();
		this.add(containerSouth, BorderLayout.SOUTH);
		
	}
}
