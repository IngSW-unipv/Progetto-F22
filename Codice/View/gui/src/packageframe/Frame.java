package packageframe;
import java.awt.*;

import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.*;
import panelspackage.Layers;
import panelspackage.panels.Chat;
import panelspackage.panels.ChatMessaggi;
import panelspackage.panels.CreazionePost;
import panelspackage.panels.Home;
import panelspackage.panels.Impostazioni;
import panelspackage.panels.LogIn;
import panelspackage.panels.PostVisualizzato;
import panelspackage.panels.PrimaPaginaAccesso;
import panelspackage.panels.Profilo;
import panelspackage.panels.Ricerca;
import panelspackage.panels.SignUp;
import panelspackage.panels.elements.PannelloNotifiche;

public class Frame extends JFrame {
	
	int i;
	
	public static final  Color COLOREPRIMARIOTEMATICO = new Color(255, 175, 0);
	public static final  Color COLORESECONDARIOTEMATICO = new Color(0,0,0);	
	
	private int varHome = 1, varLogin = 0,varProfilo = 0, varImpostazioni = 0,
				varChat = 0,varChatMessaggi = 0, varPostVisualizzato = 0, varNotifiche = 0, varCreazionePost = 0;
	
	private HashMap<String, JPanel> listaSchermateAttive = new HashMap<String, JPanel>();
	private Layers layers;
	private ArrayList<String> risultatiRicerca = new ArrayList<String>();
	
	static  String listaCommenti[] = {"benissimo", "ok", "okok"};
	static  String listaUtenti[] = {"Natasha", "Steve", "Clint"};
	static String listaRisultatiRicerca[] = {"tony1","tony2","tony3","tony4","tony5","tony6","tony7","tony8","tony9","tony10","tony11","tony12","tony13","tony14","tony15"};

	public Frame(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		 
	//all'avvio della GUI verra creata solo la schermata di login
		
		
		this.avvio();
	//	this.avviaCreazionePost();
	//	this.avvioHome(bufferStories, bufferPosts);
	//	this.avviaImpostazioni(nomeUtente);
	//	this.avviaProfilo(nomeUtente, numeroFollowers, numeroSeguiti, numeroPost, immagineProfilo, listaImmaginiPost);
	//	this.avviaSchermataSignUp();

	}
	
	public void avvio() {
		this.setTitle("Social Network");
		this.setSize(814,813);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
		
		setLayers(layers = new Layers(800, 775));
		this.add(getLayers(), BorderLayout.CENTER);
		LogIn logIn = new LogIn(800, 775);
		layers.add(logIn, new  Integer(0), 0);
		this.listaSchermateAttive.put("logIn", logIn);
		
	}
	
	public void avvioHome(ArrayList<String> bufferStories, ArrayList<String> bufferPosts) {
		Home home = new Home(bufferStories,  bufferPosts);
		getLayers().add(home, new  Integer(varHome), 0);
		home.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("Home", home);
	}
	
	public void avviaCreazionePost() {
		CreazionePost creazionePost = new CreazionePost();
		getLayers().add(creazionePost, new  Integer(varCreazionePost), 0);
		creazionePost.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("CreazionePost", creazionePost);
	}
	
	public void avviaImpostazioni(String profilo){
		Impostazioni impostazioni = new Impostazioni(profilo);
		layers.add(impostazioni, new  Integer(varImpostazioni), 0);
		impostazioni.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("Impostazioni", impostazioni);
	}
	
	public void avviaProfilo(String nomeUtente, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost) {
	Profilo profilo = new Profilo(nomeUtente, numeroFollowers, numeroSeguiti, numeroPost, immagineProfilo, listaImmaginiPost);
	layers.add(profilo, new  Integer(1), 0);
	profilo.setBounds(0,0,800,775);
	this.listaSchermateAttive.put("Profilo", profilo);
	}
	
	public void avviaChat() {
		Chat chat = new Chat();
		layers.add(chat, new Integer(varChat), 0);
		chat.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("Chat", chat);
	}
	
	public void avviaNotifiche() {
		PannelloNotifiche pannelloNotifiche = new PannelloNotifiche();
		layers.add(pannelloNotifiche, new Integer(varNotifiche), 0);
		pannelloNotifiche.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("PannelloNotifiche", pannelloNotifiche);
	}
	
	public void avviaSchermataRicerca(String profilo, ArrayList<String> risultatiRicerca) {
		
		for (i = 0; i<listaRisultatiRicerca.length; i++) {
			risultatiRicerca.add(listaRisultatiRicerca[i]);
		}
		
		Ricerca ricerca = new Ricerca(profilo, risultatiRicerca);
		layers.add(ricerca, new  Integer(0), 0);
		ricerca.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("Ricerca", ricerca);

	}
	
	public void avviaSchermataSignUp() {
		SignUp signUp = new SignUp();
		layers.add(signUp, new  Integer(0), 0);
		signUp.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("SignUp", signUp);
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

	public void setVarNotifiche(int varNotifiche) {
		this.varNotifiche = varNotifiche;
	}
	
	public int getVarCreazionePost() {
		return varCreazionePost;
	}

	public void setVarCreazionePost(int varCreazionePost) {
		this.varCreazionePost = varCreazionePost;
	}

	public int getVarNotifiche() {
		return varNotifiche;
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
	
	public int getVarPostVisualizzato() {
		return varPostVisualizzato;
	}

	public void setVarPostVisualizzato(int varPostVisualizzato) {
		this.varPostVisualizzato = varPostVisualizzato;
	}

	public Home getHome() {
		return (Home)listaSchermateAttive.get("Home");
	}
	public ChatMessaggi getChatMessaggi() {
		return (ChatMessaggi)listaSchermateAttive.get("ChatMessaggi");	}


	public Impostazioni getImpostazioni() {
		return (Impostazioni)listaSchermateAttive.get("Impostazioni");	
	}
	
	public PannelloNotifiche getPannelloNotifiche() {
		return (PannelloNotifiche)listaSchermateAttive.get("PannelloNotifiche");
	}
	
	public LogIn getLogIn() {
		return (LogIn)listaSchermateAttive.get("logIn");	
	}
	public Profilo getProfilo() {
		return (Profilo)listaSchermateAttive.get("Profilo");	
	}

	public Chat getChat() {
		return (Chat)listaSchermateAttive.get("Chat");	
	}
	
	public CreazionePost getCreazionePost() {
		return (CreazionePost)listaSchermateAttive.get("CreazionePost");
	}

	public ArrayList<String> getRisultatiRicerca() {
		return risultatiRicerca;
	}
	
	public HashMap<String, JPanel> getListaSchermateAttive() {
		return listaSchermateAttive;
	}

	public void setListaSchermateAttive(HashMap<String, JPanel> listaSchermateAttive) {
		this.listaSchermateAttive = listaSchermateAttive;
	}

	public Layers getLayers() {
		return layers;
	}

	public void setLayers(Layers layers) {
		this.layers = layers;
	}
	

	public PostVisualizzato getPostVisualizzato() {
		return (PostVisualizzato) listaSchermateAttive.get("PostVisualizzato");	
	}

	public static Color getColoreprimariotematico() {
		return COLOREPRIMARIOTEMATICO;
	}

	public static Color getColoresecondariotematico() {
		return COLORESECONDARIOTEMATICO;
	}
}