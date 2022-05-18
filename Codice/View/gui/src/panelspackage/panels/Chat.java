package panelspackage.panels;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

import packageframe.Frame;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;


public class Chat extends JPanel {
	private ArrayList<JLabel> listaChat = new ArrayList<JLabel>();
	private int numeroChat; 	//Numero delle chat di un account
	private JLabel titoloChat;
	private SpecificContainer containerSuperiore,containerSceltaChat,containerInferiore;
	private Pulsanti chatPrivata,chatGruppo,nuovaChat,homeChat;
	private static final long serialVersionUID = 1L;
	private Font fontTitle = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	private Font fontButton = new Font("Arial", Font.BOLD, 15);
	
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
		
		chatPrivata = new Pulsanti("Chat private");
		chatPrivata.setFont(fontButton);
		
		chatGruppo = new Pulsanti("Chat di gruppo");
		chatGruppo.setFont(fontButton);
		
		nuovaChat = new Pulsanti("Nuova chat");
		nuovaChat.setFont(fontButton);
		
		homeChat = new Pulsanti("Torna alla home");
		nuovaChat.setFont(fontButton);
		
		containerSuperiore = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerSuperiore.setLayout(new GridLayout(2, 1));
		containerSceltaChat = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerSceltaChat.setLayout(new GridLayout(1, 2));
		containerInferiore = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
		containerInferiore.setLayout(new GridLayout(2, 1));
		
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
		
	}
	public void aggiungiChatAllaLista(ArrayList listaChat) {
		JLabel chat = new JLabel();
		listaChat.add(chat);
	}

	public JButton getChatPrivata() {
		return chatPrivata;
	}

	public void setChatPrivata(JButton chatPrivata) {
		this.chatPrivata = chatPrivata;
	}

	public JButton getChatGruppo() {
		return chatGruppo;
	}

	public void setChatGruppo(JButton chatGruppo) {
		this.chatGruppo = chatGruppo;
	}

	public JButton getNuovaChat() {
		return nuovaChat;
	}

	public void setNuovaChat(JButton nuovaChat) {
		this.nuovaChat = nuovaChat;
	}

	public JButton getHomeChat() {
		return homeChat;
	}

	public void setHomeChat(JButton homeChat) {
		this.homeChat = homeChat;
	}
	
	public static void main(String[] args) {
		
		Chat c = new Chat();
		c.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		c.setSize(400, 400);
		c.setVisible(true);
		c.setLayout(new FlowLayout(FlowLayout.LEADING));
	}
}
