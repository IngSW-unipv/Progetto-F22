package panelspackage.panels;

import javax.swing.*;
import java.awt.*;

public class ChatMessaggi extends JPanel{
	private Container containerInferiore;
	private JLabel nomeAccountRicevente;
	private JTextArea areaMessaggi;
	private JTextField inserimentoMessaggio;
	private JButton pInvia;
	private String nomeAccount;
	private Font fontTitle = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
	private Font fontButton = new Font("Arial", Font.BOLD, 15);
	
	public ChatMessaggi(String nomeAccount) {
		this.nomeAccount = nomeAccount;
		this.setBackground(Color.BLACK);
		this.setLayout(new BorderLayout());
		nomeAccountRicevente = new JLabel(nomeAccount, SwingConstants.CENTER); 	//Inserire come argomento una stringa contenente il nome dell'account
		nomeAccountRicevente.setFont(fontTitle);
		nomeAccountRicevente.setForeground(Color.WHITE);
		
		areaMessaggi = new JTextArea("Qui verranno visualizzati i messaggi");	//Qui verranno visualizzati tutti i messaggi
		areaMessaggi.setEditable(false);
		
		inserimentoMessaggio = new JTextField(70);	//Area dove si scrive il messaggio da inviare
		
		pInvia = new JButton("INVIA");
		pInvia.setFont(fontButton);
		
		containerInferiore = new Container();
		containerInferiore.setLayout(new FlowLayout());
		containerInferiore.add(inserimentoMessaggio);
		containerInferiore.add(pInvia);
		
		this.add(nomeAccountRicevente, BorderLayout.NORTH);
		this.add(areaMessaggi, BorderLayout.CENTER);
		this.add(containerInferiore, BorderLayout.SOUTH);
		
		
	}

}
