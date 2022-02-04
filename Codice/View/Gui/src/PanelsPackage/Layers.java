package PanelsPackage;
import java.awt.*;
import javax.swing.*;
import PanelsPackage.panels.Home;

public class Layers extends JLayeredPane{
	Color ARANCIONE = new Color(255, 175, 0);
	Color NERO = new Color(255, 255, 255);
	
	public Layers() {
	this.setVisible(true);
	this.setLayout(new BorderLayout());

	Home home = new Home();
	this.add(home, BorderLayout.CENTER);
	home.setOpaque(true);
	home.setVisible(true);
	}
}
