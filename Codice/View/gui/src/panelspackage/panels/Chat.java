package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import  javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class Chat extends JPanel{

	private JPanel panello;
	private JButton home;
	private JButton mioProfilo;
	private JComboBox<String> discussioni;
	private JPanel panelDiscussioni;
	private JPanel aggiornaAltriChat;
	
		public Chat() {
		//panello = new JPanel();
		//panello.setLayout(null);
		
	
		home = new JButton();
		//panello.add(home);
		home.setIcon(new ImageIcon("C:\\Users\\aissa\\OneDrive\\Immagini\\home.png"));
		home.setBackground(Color.white);
		this.add(home); 
		
		mioProfilo = new JButton("Mio Profilo");
		//panello.add(mioProfilo);
		mioProfilo.setBackground(Color.pink);
		this.add(mioProfilo); 
		
		
		discussioni = new JComboBox<>();
		//panello.add(discussioni);
		discussioni.addItem("Discussioni");
		discussioni.addItem("Chat di gruppo");
		discussioni.addItem("Chat personali");
		//discussioni.setModel(new DefaultComboBoxModel<>(new String[] {"Chat personali", "Chat di gruppo", "Discussioni"})); 
		discussioni.setFont(new Font("Arial", 1, 14));
		//discussioni.setBounds(139, 104, 169, 30);
		discussioni.setBackground(Color.CYAN);
	    this.add(discussioni); 
	    
	    //this.add(panello, BorderLayout.NORTH); 
	   
	   
	  /* panelDiscussioni = new JPanel();
	   panelDiscussioni.setBounds(158, 90, 80, 100);
	   panelDiscussioni.setBackground(Color.cyan);
	   panelDiscussioni.setLayout(new GridLayout(10, 2));
	   panelDiscussioni.add(new JLabel("Chat1")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat2")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat3")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat4")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat5")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat6")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat7")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat8")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat9")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   panelDiscussioni.add(new JLabel("Chat10")).setFont(new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	   panelDiscussioni.add(new JButton("Apri")).setBackground(Color.cyan);
	   this.add(panelDiscussioni, BorderLayout.CENTER); */
	   
	   
	   /*aggiornaAltriChat = new JButton("Aggiorna altri chat...");
	   aggiornaAltriChat.setBackground(Color.CYAN);
	   this.add(aggiornaAltriChat, BorderLayout.AFTER_LAST_LINE); */
	       
		
	/* = new JButton();
		panelDiscussioni.add(b);
		b.setLayout(new GridLayout(2,2));
		b.add(new JLabel("Chat1"));
	b.add(new JButton("Apri"));
		b.add(new JButton("Chat2"));
		b.add(new JButton("Chat3"));
		//add(new JButton("Chat4"));
		
		this.add(b);
	  */
		//id.addLayoutComponent("Chat1", b );
		//id.addLayoutComponent("Chat2",b );
			
		
		
	}
	
	
	
	/*public static void main(String[] args) {
		
		DiscussioniFrame chat = new DiscussioniFrame();
		chat.getContentPane().setLayout(null);
		chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chat.setVisible(true);
		chat.setSize(814, 813);
		//chat.setLayout(new BorderLayout());
		chat.setLayout(new FlowLayout());
		
	}*/



	public JButton getHomeChat() {
		return home;
	}

}

	

