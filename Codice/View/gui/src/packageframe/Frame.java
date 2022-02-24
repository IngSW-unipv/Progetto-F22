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
import panelspackage.panels.Profilo;

public class Frame extends JFrame {
	
	private int varHome = 1;
	private int varLogin = 0;
	private int varProfilo = 0;
	private int varImpostazioni = 0;
	private int varChat = 0;
	private int varChatMessaggi = 0;
	
	private Home home;
	private LogIn logIn;
	private Profilo profilo;
	private Impostazioni impostazioni;
	private Chat chat;
	private ChatMessaggi chatMessaggi;
	
	private static final long serialVersionUID = 1L;
	Color ARANCIONE = new Color(255, 175, 0);
	Color NERO = new Color(255,255,255);	
	
	
	@SuppressWarnings({ "deprecation", "removal" })
	public Frame(ArrayList<String> bufferStories, ArrayList<String> bufferPosts) {
		 
		this.setTitle("Social Network");
		this.setSize(814,813);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		Layers layers = new Layers();
		layers.setBounds(0,0, 800, 775);
		this.add(layers, BorderLayout.CENTER);
		
		home = new Home(bufferStories, bufferPosts);
		layers.add(home, new  Integer(varHome), 0);
		home.setBounds(0,0,800,775);

		logIn = new LogIn();
		layers.add(logIn, new  Integer(varLogin), 0);
		logIn.setBounds(0,0,800,775);

		/*Ricerca ricerca = new Ricerca("Tony Stark");
		layers.add(ricerca, new  Integer(2), 0);
		ricerca.setBounds(0,0,800,775);*/
		
		profilo = new Profilo("Tony Stark");
		layers.add(profilo, new  Integer(varProfilo), 0);
		profilo.setBounds(0,0,800,775);
		
		impostazioni = new Impostazioni("Steve Rogers");
		layers.add(impostazioni, new  Integer(varImpostazioni), 0);
		impostazioni.setBounds(0,0,800,775);
		
		chat = new Chat();
		layers.add(chat, new  Integer(varChat), 0);
		chat.setBounds(0,0,800,775);
		
		chatMessaggi = new ChatMessaggi("Nome_account_con_cui_sto_messaggiando");
		layers.add(chatMessaggi, new  Integer(varChatMessaggi), 0);
		chatMessaggi.setBounds(0,0,800,775);
	}

	public int getVarHome() {
		return varHome;
	}

	public void setVarHome(int varHome) {
		this.varHome = varHome;
	}

	public int getVarLogin() {
		return varLogin;
	}

	public void setVarLogin(int varLogin) {
		this.varLogin = varLogin;
	}

	public int getVarProfilo() {
		return varProfilo;
	}

	public void setVarProfilo(int varProfilo) {
		this.varProfilo = varProfilo;
	}

	public int getVarImpostazioni() {
		return varImpostazioni;
	}

	public void setVarImpostazioni(int varImpostazioni) {
		this.varImpostazioni = varImpostazioni;
	}

	public int getVarChat() {
		return varChat;
	}

	public void setVarChat(int varChat) {
		this.varChat = varChat;
	}

	public int getVarChatMessaggi() {
		return varChatMessaggi;
	}

	public void setVarChatMessaggi(int varChatMessaggi) {
		this.varChatMessaggi = varChatMessaggi;
	}

	public Home getHome() {
		return home;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public ChatMessaggi getChatMessaggi() {
		return chatMessaggi;
	}

	public void setChatMessaggi(ChatMessaggi chatMessaggi) {
		this.chatMessaggi = chatMessaggi;
	}

	public Impostazioni getImpostazioni() {
		return impostazioni;
	}

	public void setImpostazioni(Impostazioni impostazioni) {
		this.impostazioni = impostazioni;
	}

	public LogIn getLogIn() {
		return logIn;
	}

	public void setLogIn(LogIn logIn) {
		this.logIn = logIn;
	}

	public Profilo getProfilo() {
		return profilo;
	}

	public void setProfilo(Profilo profilo) {
		this.profilo = profilo;
	}

	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	
	
}
