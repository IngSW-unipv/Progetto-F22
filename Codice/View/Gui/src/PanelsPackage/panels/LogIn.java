package PanelsPackage.panels;
import javax.swing.*;
import java.awt.*;
import PanelsPackage.panels.elements.SpecificContainer;
public class LogIn extends JPanel {
	Color ARANCIONE = new Color(255, 125, 0);
	Color NERO = new Color(0, 0, 0);
	
	public LogIn(){
		SpecificContainer containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		containerNorth.setVisible(true);
		
		JLabel etichetta = new JLabel("LogIn");
		etichetta.setVisible(true);
		containerNorth.add(etichetta,BorderLayout.CENTER);
	}
}