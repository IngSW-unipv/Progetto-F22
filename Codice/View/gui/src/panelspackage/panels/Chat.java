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

	private Pulsanti tornaHome, primaChatGruppo, secondaChatGruppo, terzaChatGruppo, quartaChatGruppo, quintaChatGruppo,
					 primaChatPrivata, secondaChatPrivata, terzaChatPrivata, quartaChatPrivata, quintaChatPrivata;
	
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
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLOREPRIMARIOTEMATICO);	
	}
	
	public void initComponents() {
		
		containerNorth = new SpecificContainer();
		containerNorth.setLayout(new GridLayout(2, 1));
		this.add(containerNorth, BorderLayout.NORTH);
		
		discussioni = new JComboBox<>();
		discussioni.addItem("Discussioni");
		discussioni.addItem("Chat di gruppo");
		discussioni.addItem("Chat personali");
		discussioni.setFont(new Font("Arial", 1, 14));
		discussioni.setBackground(Frame.COLOREPRIMARIOTEMATICO);
		containerNorth.add(discussioni); 
	    
	    containerCenter = new SpecificContainer(Color.CYAN);
	    containerCenter.setLayout(new GridLayout(10, 2));
	    containerCenter.add(new Etichette("ChatDiGruppo1",Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(primaChatGruppo = new Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatPersonale1", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(primaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatDiGruppo2", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(secondaChatGruppo = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatPersonale2", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(secondaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatDiGruppo3", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(terzaChatGruppo = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatPersonale3", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(terzaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatDiGruppo4", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(quartaChatGruppo = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatPersonale4", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(quartaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatDiGruppo5", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(quintaChatGruppo = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    containerCenter.add(new Etichette("ChatPersonale5", Frame.COLORESECONDARIOTEMATICO), new Font("Times New Roman", Font.LAYOUT_LEFT_TO_RIGHT, 14));
	    containerCenter.add(quintaChatPrivata = new  Pulsanti("Apri", Frame.COLOREPRIMARIOTEMATICO));
	    this.add(containerCenter, BorderLayout.CENTER); 
	    
	    
	    containerSouth = new SpecificContainer();
	    this.add(containerSouth, BorderLayout.SOUTH);
	    aggiornaAltriChat = new Pulsanti("Aggiorna altri chat", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14));
		tornaHome = new Pulsanti("Torna alla home", Frame.COLOREPRIMARIOTEMATICO);
	    containerSouth.setLayout(new GridLayout(2, 1));
	    containerSouth.add(aggiornaAltriChat);
	    containerSouth.add(tornaHome);
	    
	}
	

        

		public Pulsanti getTornaHome() {
			return tornaHome;
		}

		public void setTornaHome(Pulsanti home) {
			this.tornaHome = home;
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

		public Pulsanti getPrimaChatGruppo() {
			return primaChatGruppo;
		}

		public void setPrimaChatGruppo(Pulsanti primaChatGruppo) {
			this.primaChatGruppo = primaChatGruppo;
		}

		public Pulsanti getSecondaChatGruppo() {
			return secondaChatGruppo;
		}

		public void setSecondaChatGruppo(Pulsanti secondaChatGruppo) {
			this.secondaChatGruppo = secondaChatGruppo;
		}

		public Pulsanti getTerzaChatGruppo() {
			return terzaChatGruppo;
		}

		public void setTerzaChatGruppo(Pulsanti terzaChatGruppo) {
			this.terzaChatGruppo = terzaChatGruppo;
		}

		public Pulsanti getQuartaChatGruppo() {
			return quartaChatGruppo;
		}

		public void setQuartaChatGruppo(Pulsanti quartaChatGruppo) {
			this.quartaChatGruppo = quartaChatGruppo;
		}

		public Pulsanti getQuintaChatGruppo() {
			return quintaChatGruppo;
		}

		public void setQuintaChatGruppo(Pulsanti quintaChatGruppo) {
			this.quintaChatGruppo = quintaChatGruppo;
		}

		public Pulsanti getPrimaChatPrivata() {
			return primaChatPrivata;
		}

		public void setPrimaChatPrivata(Pulsanti primaChatPrivata) {
			this.primaChatPrivata = primaChatPrivata;
		}

		public Pulsanti getSecondaChatPrivata() {
			return secondaChatPrivata;
		}

		public void setSecondaChatPrivata(Pulsanti secondaChatPrivata) {
			this.secondaChatPrivata = secondaChatPrivata;
		}

		public Pulsanti getTerzaChatPrivata() {
			return terzaChatPrivata;
		}

		public void setTerzaChatPrivata(Pulsanti terzaChatPrivata) {
			this.terzaChatPrivata = terzaChatPrivata;
		}

		public Pulsanti getQuartaChatPrivata() {
			return quartaChatPrivata;
		}

		public void setQuartaChatPrivata(Pulsanti quartaChatPrivata) {
			this.quartaChatPrivata = quartaChatPrivata;
		}

		public Pulsanti getQuintaChatPrivata() {
			return quintaChatPrivata;
		}

		public void setQuintaChatPrivata(Pulsanti quintaChatPrivata) {
			this.quintaChatPrivata = quintaChatPrivata;
		}
		
}	

