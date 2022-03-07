package panelspackage;

import javax.swing.*;


public class Layers extends JLayeredPane{

	public Layers(int base, int altezza) {
	this.setBounds(0,0, base, altezza);
	this.setVisible(true);
	
	}
}