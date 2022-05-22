package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import packageframe.Frame;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;

@SuppressWarnings("serial")
public class Chat extends JPanel {

	private Pulsanti home;
	private Pulsanti mioProfilo;
	private JComboBox<String> discussioni;
	private SpecificContainer containerCenter;
	private SpecificContainer containerNorth ;
	private Pulsanti aggiornaAltriChat;
	private SpecificContainer containerSouth;

	

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
		
		home = new Pulsanti("C:\\Users\\aissa\\OneDrive\\Immagini\\home.png");
		mioProfilo = new Pulsanti("Mio Profilo", Color.pink);
		containerNorth = new SpecificContainer();
		this.add(containerNorth, BorderLayout.NORTH);
		containerNorth.add(home);
		containerNorth.add(mioProfilo);
		
		discussioni = new JComboBox<>();
		discussioni.addItem("Discussioni");
		discussioni.addItem("Chat di gruppo");
		discussioni.addItem("Chat personali");
		discussioni.setFont(new Font("Arial", 1, 14));
		discussioni.setBackground(Color.CYAN);
		containerNorth.add(discussioni); 
	    
	    containerCenter = new SpecificContainer(Color.CYAN);
	    containerCenter.setLayout(new GridLayout(10, 2));
	    containerCenter.add(new Etichette("ChatDiGruppo1", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatPersonale1", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatDiGruppo2", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatPersonale2", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatDiGruppo3", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatPersonale3", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatDiGruppo4", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatPersonale4", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatDiGruppo5", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    containerCenter.add(new Etichette("ChatPersonale5", Color.black), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(new  Pulsanti("Apri", Color.cyan));
	    this.add(containerCenter, BorderLayout.CENTER); 
	    
	    
	    containerSouth = new SpecificContainer();
	    this.add(containerSouth);
	    aggiornaAltriChat = new Pulsanti("Aggiorna altri chat", Color.blue, new Font("Arial", 1, 14));
	    containerSouth.add(aggiornaAltriChat);
	    
	}
	

        

		public Pulsanti getHome() {
			return home;
		}

		public void setHome(Pulsanti home) {
			this.home = home;
		}

		public Pulsanti getMioProfilo() {
			return mioProfilo;
		}

		public void setMioProfilo(Pulsanti mioProfilo) {
			this.mioProfilo = mioProfilo;
		}

		public JComboBox<String> getDiscussioni() {
			return discussioni;
		}

		public void setDiscussioni(JComboBox<String> discussioni) {
			this.discussioni = discussioni;
		}

		public SpecificContainer getContainerCenter() {
			return containerCenter;
		}

		public void setContainerCenter(SpecificContainer containerCenter) {
			this.containerCenter= containerCenter;
		}

		public SpecificContainer getContainerNorth() {
			return containerNorth;
		}

		public void setContainerNorth(SpecificContainer containerNorth) {
			this.containerNorth = containerNorth;
		}

		public Pulsanti getAggiornaAltriChat() {
			return aggiornaAltriChat;
		}

		public void setAggiornaAltriChat(Pulsanti aggiornaAltriChat) {
			this.aggiornaAltriChat = aggiornaAltriChat;
		}

		public SpecificContainer getContainerSouth() {
			return containerSouth;
		}

		public void setContainerSouth(SpecificContainer containerSouth) {
			this.containerSouth = containerSouth;
		}
	   
	    
		
}	

