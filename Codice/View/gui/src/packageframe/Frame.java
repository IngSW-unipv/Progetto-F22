package packageframe;
import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;
import panelspackage.Layers;
import panelspackage.panels.Chat;
import panelspackage.panels.ChatMessaggi;
import panelspackage.panels.Home;
import panelspackage.panels.Impostazioni;
import panelspackage.panels.LogIn;
import panelspackage.panels.PostVisualizzato;
import panelspackage.panels.Profilo;
import panelspackage.panels.Ricerca;

public class Frame extends JFrame {
	
	/**
	 * 
	 */
	int i;
	Color ARANCIONE = new Color(255, 175, 0);
	Color NERO = new Color(255,255,255);	
	//array di prova
	static  String listaCommenti[] = {"benissimo", "ok", "okok"};
	static  String listaUtenti[] = {"Natasha", "Steve", "Clint"};
	ArrayList<String> risultatiRicerca = new ArrayList<String>();
	static String listaRisultatiRicerca[] = {"tony1","tony2","tony3","tony4","tony5","tony6","tony7","tony8","tony9","tony10","tony11","tony12","tony13","tony14","tony15"};
	@SuppressWarnings("deprecation")
	public Frame(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		
		//ciao 
		this.setTitle("Social Network");
		this.setSize(814,813);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		Layers layers = new Layers();
		layers.setBounds(0,0, 800, 775);
		this.add(layers, BorderLayout.CENTER);
		
		Home home = new Home(bufferStories, bufferPosts);
		layers.add(home, new  Integer(1), 0);
		home.setBounds(0,0,800,775);

		
		LogIn logIn = new LogIn();
		layers.add(logIn, new  Integer(0), 0);
		logIn.setBounds(0,0,800,775);
		
		for (i = 0; i<listaRisultatiRicerca.length; i++) {
			risultatiRicerca.add(listaRisultatiRicerca[i]);
		}
		Ricerca ricerca = new Ricerca("Tony", getRisultatiRicerca());
		layers.add(ricerca, new  Integer(0), 0);
		ricerca.setBounds(0,0,800,775);
		
		Profilo profilo = new Profilo(nomeUtente, numeroFollowers, numeroSeguiti, numeroPost, immagineProfilo, listaImmaginiPost);
		layers.add(profilo, new  Integer(0), 0);
		profilo.setBounds(0,0,800,775);
		
		Impostazioni impostazioni = new Impostazioni(nomeUtente);
		layers.add(impostazioni, new  Integer(0), 0);
		impostazioni.setBounds(0,0,800,775);
		
		Chat chat = new Chat();
		layers.add(chat, new  Integer(0), 0);
		chat.setBounds(0,0,800,775);
		
		ChatMessaggi chatMessaggi = new ChatMessaggi("Nome_account_con_cui_sto_messaggiando");
		layers.add(chatMessaggi, new  Integer(0), 0);
		chatMessaggi.setBounds(0,0,800,775);
		
		PostVisualizzato postVisualizzato = new PostVisualizzato("immagini/post.jpg",listaCommenti, listaUtenti, 25,69);
		layers.add(postVisualizzato, new  Integer(0), 0);
		postVisualizzato.setBounds(0,0,800,775);
	}

	public Color getARANCIONE() {
		return ARANCIONE;
	}
	public Color getNERO() {
		return NERO;
	}
	public static String[] getListaCommenti() {
		return listaCommenti;
	}
	public static String[] getListaUtenti() {
		return listaUtenti;
	}

	public ArrayList<String> getRisultatiRicerca() {
		return risultatiRicerca;
	}

}
