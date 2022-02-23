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
	private JButton pChatPrivata;
	private JButton pChatGruppo;
	private JButton pNuovaChat;
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
		
		pChatPrivata = new JButton("Chat private");
		pChatPrivata.setFont(fontButton);
		
		pChatGruppo = new JButton("Chat di gruppo");
		pChatGruppo.setFont(fontButton);
		
		pNuovaChat = new JButton("Nuova chat");
		pNuovaChat.setFont(fontButton);
		
		
		containerSuperiore = new Container();
		containerSuperiore.setLayout(new GridLayout(2, 1));
		containerSceltaChat = new Container();
		containerSceltaChat.setLayout(new GridLayout(1, 2));
		containerInferiore = new Container();
		containerInferiore.setLayout(new GridLayout(1, 2));
		
		containerSuperiore.add(titoloChat);
		containerSceltaChat.add(pChatPrivata);
		containerSceltaChat.add(pChatGruppo);
		containerSuperiore.add(containerSceltaChat);
		containerInferiore.add(pNuovaChat);
		this.add(containerSuperiore, BorderLayout.NORTH);
		this.add(containerInferiore, BorderLayout.SOUTH);
		for(i=0; i < numeroChat; i++) {
			this.add(listaChat.get(i));
		}
	}
	
	public void aggiungiChatAllaLista(ArrayList listaChat) {
		JLabel chat = new JLabel();
		listaChat.add(chat);
	}
	
	
}
