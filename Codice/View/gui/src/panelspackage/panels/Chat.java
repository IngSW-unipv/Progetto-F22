package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;

public class Chat extends JPanel {
	
	Color NERO = new Color(0,0,0);
	
	public Chat() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
	}
}
