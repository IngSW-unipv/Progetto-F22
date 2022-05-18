package panelspackage.panels;

import java.awt.Color;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class AreaChatFrame extends JFrame {

	private JButton profilo;
	private JPanel areaChat;
	private JTextArea messaggi;
	private JTextField scriviMessaggio;
	private JButton invia;
	private JButton esci;
	
	
	public AreaChatFrame() {
		esci = new JButton();
		esci.setFont(new Font("Arial", 1, 12));
		esci.setBackground(Color.red);
		esci.setIcon(new ImageIcon("C:\\Users\\aissa\\OneDrive\\Immagini\\torna.png"));
		this.add(esci);
		
		profilo = new JButton("Profilo");
		profilo.setFont(new Font("Arial", 1, 12));
		profilo.setBackground(new Color(204, 255, 255));
		profilo.setIcon(new ImageIcon("C:\\Users\\aissa\\OneDrive\\Immagini\\profiler.png"));
		this.add(profilo);
		
		
		areaChat = new JPanel();
		areaChat.setLayout(null);
		this.add(areaChat);
		
		
		messaggi = new JTextArea(20, 40);
		areaChat.add(messaggi);
		messaggi.setBackground(Color.pink);
		//messaggi.setLayout(new FlowLayout( FlowLayout.RIGHT));
		this.add(messaggi);
		
		scriviMessaggio = new JTextField(30);
		scriviMessaggio.setFont(new java.awt.Font("Arial", 1, 12)); 
		scriviMessaggio.setText("Scrivi messaggio");
		scriviMessaggio.setBackground(Color.LIGHT_GRAY);
		this.add(scriviMessaggio);
		
		 //scriviMessaggio.setHorizontalAlignment(scriviMessaggio.LEADING);
	    //scriviMessaggio.setAlignmentX((float) 0.5);
		//scriviMessaggio.setAlignmentY((float) 0.5);
		//areaChat.add(scriviMessaggio);
		
		invia = new JButton("Invia");
		invia.setFont(new Font("Times New Roman", 1, 14));
		invia.setBackground(Color.cyan);
		invia.setBorderPainted(isBackgroundSet());
	    this.add(invia);
	    
	    
	    //areaChat.add(invia);
	    
	   // scroll = new JScrollPane();
	    
	    //GridBagConstraints grid = new GridBagConstraints();
	    //grid.gridwidth = GridBagConstraints.REMAINDER;
	    //grid.fill = GridBagConstraints.HORIZONTAL;
	    //add(scriviMessaggio);
	    //grid.fill = GridBagConstraints.BOTH;
		//grid.weightx = 1.0;
		//grid.weighty = 1.0;
		//add(scroll,grid);
	}
	
	public static void main(String[] args) {
		AreaChatFrame chat = new AreaChatFrame();
		chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chat.setVisible(true);
		chat.setSize(814, 813);
		chat.setLayout(new FlowLayout( FlowLayout.LEADING));
		//chat.pack();
	}

	public JPanel getAreaChat() {
		return areaChat;
	}

	public void setAreaChat(JPanel areaChat) {
		this.areaChat = areaChat;
	}

	public JTextArea getMessaggi() {
		return messaggi;
	}

	public void setMessaggi(JTextArea messaggi) {
		this.messaggi = messaggi;
	}

	public JTextField getScriviMessaggio() {
		return scriviMessaggio;
	}

	public void setScriviMessaggio(JTextField scriviMessaggio) {
		this.scriviMessaggio = scriviMessaggio;
	}

	public JButton getInvia() {
		return invia;
	}

	public void setInvia(JButton invia) {
		this.invia = invia;
	}

	
}
