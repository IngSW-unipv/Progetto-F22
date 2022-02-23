package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.*;
import javax.swing.*;


public class Chat extends JPanel {
	private JLabel tChat;
	private Container containerSuperiore;
	private static final long serialVersionUID = 1L;
	Color NERO = new Color(0,0,0);
	
	public Chat() {
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		containerSuperiore = new Container();
		containerSuperiore.setLayout(new BorderLayout());
		tChat = new JLabel("PROVA", SwingConstants.CENTER);
		containerSuperiore.add(tChat, BorderLayout.NORTH);
		containerSuperiore.setVisible(true);
		this.add(containerSuperiore, BorderLayout.NORTH);
		
	}
}
