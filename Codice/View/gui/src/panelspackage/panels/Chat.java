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

import packageframe.Frame;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;

<<<<<<< HEAD
@SuppressWarnings("serial")
public class Chat extends JPanel{

	private JPanel panello;
	private JButton home;
	private JButton mioProfilo;
	private JComboBox<String> discussioni;
	private JPanel panelDiscussioni;
	private JPanel aggiornaAltriChat;
=======

public class Chat extends JPanel {
	private ArrayList<JLabel> listaChat = new ArrayList<JLabel>();
	private int numeroChat; 	//Numero delle chat di un account
	private JLabel titoloChat;
	private SpecificContainer containerSuperiore,containerSceltaChat,containerInferiore;
	private Pulsanti chatPrivata,chatGruppo,nuovaChat,homeChat;
	private static final long serialVersionUID = 1L;
	private Font fontTitle = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	private Font fontButton = new Font("Arial", Font.BOLD, 15);
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
	
<<<<<<< HEAD
		public Chat() {
		//panello = new JPanel();
		//panello.setLayout(null);
		
	
		home = new JButton();
		//panello.add(home);
		home.setIcon(new ImageIcon("C:\\Users\\aissa\\OneDrive\\Immagini\\home.png"));
		home.setBackground(Color.white);
		this.add(home); 
=======
	public Chat() {
		avvio();
		initComponents();
	}
	
	public void avvio() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLOREPRIMARIOTEMATICO);	
	}
	
	public void initComponents() {
		titoloChat = new JLabel("CHAT", SwingConstants.LEFT);
		titoloChat.setFont(fontTitle);
		titoloChat.setForeground(Color.WHITE);
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
		
<<<<<<< HEAD
		mioProfilo = new JButton("Mio Profilo");
		//panello.add(mioProfilo);
		mioProfilo.setBackground(Color.pink);
		this.add(mioProfilo); 
=======
		chatPrivata = new Pulsanti("Chat private");
		chatPrivata.setFont(fontButton);
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
		
<<<<<<< HEAD
=======
		chatGruppo = new Pulsanti("Chat di gruppo");
		chatGruppo.setFont(fontButton);
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
		
<<<<<<< HEAD
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
	       
=======
		nuovaChat = new Pulsanti("Nuova chat");
		nuovaChat.setFont(fontButton);
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
		
<<<<<<< HEAD
	/* = new JButton();
		panelDiscussioni.add(b);
		b.setLayout(new GridLayout(2,2));
		b.add(new JLabel("Chat1"));
	b.add(new JButton("Apri"));
		b.add(new JButton("Chat2"));
		b.add(new JButton("Chat3"));
		//add(new JButton("Chat4"));
=======
		homeChat = new Pulsanti("Torna alla home");
		nuovaChat.setFont(fontButton);
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
		
<<<<<<< HEAD
		this.add(b);
	  */
		//id.addLayoutComponent("Chat1", b );
		//id.addLayoutComponent("Chat2",b );
			
=======
		containerSuperiore = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerSuperiore.setLayout(new GridLayout(2, 1));
		containerSceltaChat = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerSceltaChat.setLayout(new GridLayout(1, 2));
		containerInferiore = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerInferiore.setLayout(new GridLayout(2, 1));
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
		
<<<<<<< HEAD
=======
		containerSuperiore.add(titoloChat);
		containerSceltaChat.add(chatPrivata);
		containerSceltaChat.add(chatGruppo);
		containerSuperiore.add(containerSceltaChat);
		containerInferiore.add(nuovaChat);
		containerInferiore.add(homeChat);
		this.add(containerSuperiore, BorderLayout.NORTH);
		this.add(containerInferiore, BorderLayout.SOUTH);
		/*for(i=0; i < numeroChat; i++) {
			this.add(listaChat.get(i));
		}*/
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git
		
	}
<<<<<<< HEAD
	
	
	
	/*public static void main(String[] args) {
		
		DiscussioniFrame chat = new DiscussioniFrame();
		chat.getContentPane().setLayout(null);
		chat.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		chat.setVisible(true);
		chat.setSize(814, 813);
		//chat.setLayout(new BorderLayout());
		chat.setLayout(new FlowLayout());
		
	}*/
=======
	public void aggiungiChatAllaLista(ArrayList listaChat) {
		JLabel chat = new JLabel();
		listaChat.add(chat);
	}
>>>>>>> branch 'main' of https://github.com/IngSW-unipv/Progetto-F22.git



	public JButton getHomeChat() {
		return home;
	}

}

	

