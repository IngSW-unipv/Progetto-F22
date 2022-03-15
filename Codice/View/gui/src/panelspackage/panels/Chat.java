package panelspackage.panels;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


public class Chat extends JPanel {
	private ArrayList<JLabel> listaChat = new ArrayList<JLabel>();
	private int numeroChat; 	//Numero delle chat di un account
	private JLabel titoloChat;
	private Container containerSuperiore;
	private Container containerSceltaChat;
	private Container containerInferiore;
	private JButton chatPrivata;
	private JButton chatGruppo;
	private JButton nuovaChat;
	private JButton homeChat;
	private static final long serialVersionUID = 1L;
	private Color NERO = new Color(0,0,0);
	private Font fontTitle = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	private Font fontButton = new Font("Arial", Font.BOLD, 15);
	
	public Chat() {
		int i;
		this.setOpaque(true);
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(NERO);	
		
		titoloChat = new JLabel("CHAT", SwingConstants.LEFT);
		titoloChat.setFont(fontTitle);
		titoloChat.setForeground(Color.WHITE);
		
		chatPrivata = new JButton("Chat private");
		chatPrivata.setFont(fontButton);
		
		chatGruppo = new JButton("Chat di gruppo");
		chatGruppo.setFont(fontButton);
		
		nuovaChat = new JButton("Nuova chat");
		nuovaChat.setFont(fontButton);
		
		homeChat = new JButton("Torna alla home");
		nuovaChat.setFont(fontButton);
		
		containerSuperiore = new Container();
		containerSuperiore.setLayout(new GridLayout(2, 1));
		containerSceltaChat = new Container();
		containerSceltaChat.setLayout(new GridLayout(1, 2));
		containerInferiore = new Container();
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
}
