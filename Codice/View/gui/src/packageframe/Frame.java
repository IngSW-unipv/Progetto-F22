package packageframe;
import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Sistema.Sistema;
import controller.Controller;
import panelspackage.panels.Chat;
import panelspackage.panels.ChatMessaggi;
import panelspackage.panels.CreazionePost;
import panelspackage.panels.Home;
import panelspackage.panels.Impostazioni;
import panelspackage.panels.LogIn;
import panelspackage.panels.PostVisualizzato;
import panelspackage.panels.Profilo;
import panelspackage.panels.Ricerca;
import panelspackage.panels.SignUp;
import panelspackage.panels.elements.PannelloNotifiche;
import panelspackage.panels.elements.SpecificContainer;

public class Frame extends JFrame {
	
	int i;
	
	public static final  Color COLOREPRIMARIOTEMATICO = new Color(255, 175, 0);
	public static final  Color COLORESECONDARIOTEMATICO = new Color(0,0,0);	

	private ArrayList<String> risultatiRicerca = new ArrayList<String>();
	private SpecificContainer FrameMainContainer;
	
	// liste di prova
	static  String listaCommenti[] = {"benissimo", "ok", "okok"};
	static  String listaUtenti[] = {"Natasha", "Steve", "Clint"};
	static String listaRisultatiRicerca[] = {"tony1","tony2","tony3","tony4","tony5","tony6","tony7","tony8","tony9","tony10","tony11","tony12","tony13","tony14","tony15"};
	ArrayList<String> listaPost = new ArrayList<String>();
	public HashMap<String, JPanel> mappaSchermate = new HashMap<String, JPanel>();
	
	public Frame(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		 
	//all'avvio della GUI viene mostrata nel frame la schermata di Login
		this.avvio(bufferStories, bufferPosts, nomeUtente, eMail, numeroFollowers, numeroSeguiti, numeroPost,immagineProfilo, listaImmaginiPost);
	}
	

	public void avvio(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		this.settingParametriFrame();
		this.add(FrameMainContainer = new SpecificContainer(Color.BLACK) , BorderLayout.CENTER);
		this.avvioSchermate(bufferStories, bufferPosts, nomeUtente, eMail, numeroFollowers, numeroSeguiti, numeroPost,immagineProfilo, listaImmaginiPost);
	}
	
	public void settingParametriFrame() {
		this.setTitle("Social Network");
		this.setSize(814,813);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
	public void avvioSchermate(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		LogIn login = new LogIn();
		mappaSchermate.put("Login",   login);
		this.FrameMainContainer.add(this.getMappaSchermate().get("Login"), BorderLayout.CENTER);
		
		SignUp signup = new SignUp();
		mappaSchermate.put("Signup", signup);
		
		Home home = new Home(bufferStories, bufferPosts);
		mappaSchermate.put("Home", home);
		
		Impostazioni impostazioni = new Impostazioni("Stringa profilo prova");
		mappaSchermate.put("Impostazioni", impostazioni);
		
		Profilo profilo = new Profilo("Tony Stark", 10, 20, 30, "prova", listaPost);
		mappaSchermate.put("Profilo", profilo);
		
		Chat chat = new Chat();
		mappaSchermate.put("Chat", chat);
		
		PannelloNotifiche pannelloNotifiche = new PannelloNotifiche();
		mappaSchermate.put("PannelloNotifiche", pannelloNotifiche);
		
		CreazionePost creazionePost = new CreazionePost();
		mappaSchermate.put("CreazionePost", creazionePost);

	}
	
	public void mostraSchermata(String Schermata) {
		this.FrameMainContainer.add(mappaSchermate.get(Schermata), BorderLayout.CENTER);
		mappaSchermate.get(Schermata).setVisible(true);
	}

	
	public static Color getColoreprimariotematico() {
		return COLOREPRIMARIOTEMATICO;
	}

	public static Color getColoresecondariotematico() {
		return COLORESECONDARIOTEMATICO;
	}
	
	public Home getHome() {
		return (Home)mappaSchermate.get("Home");
	}
	public ChatMessaggi getChatMessaggi() {
		return (ChatMessaggi)this.getMappaSchermate().get("ChatMessaggi");	}


	public Impostazioni getImpostazioni() {
		return (Impostazioni)mappaSchermate.get("Impostazioni");	
	}
	
	public PannelloNotifiche getPannelloNotifiche() {
		return (PannelloNotifiche)this.getMappaSchermate().get("PannelloNotifiche");
	}
	
	public LogIn getLogIn() {
		return (LogIn)mappaSchermate.get("Login");	
	}
	
	public SignUp getSignUp() {
		return (SignUp)mappaSchermate.get("Signup");
	}
	
	public Profilo getProfilo() {
		return (Profilo)this.getMappaSchermate().get("Profilo");	
	}

	public Chat getChat() {
		return (Chat)this.getMappaSchermate().get("Chat");	
	}
	
	public CreazionePost getCreazionePost() {
		return (CreazionePost)this.getMappaSchermate().get("CreazionePost");
	}

	public ArrayList<String> getRisultatiRicerca() {
		return risultatiRicerca;
	}

	public PostVisualizzato getPostVisualizzato() {
		return (PostVisualizzato)this.getMappaSchermate().get("PostVisualizzato");	
	}
	
	
	public JButton getImpostazioniButton() {
		return getHome().getButtonImpostazioni();
	}
	
	public JButton getCreazionePostButton() {
		return getHome().getpPost();
	}
	
	public JButton getHomeCreazionePostButton() {
		return getCreazionePost().getHomeCreazionePost();
	}
	
	public JButton getProfiloButton() {
		return getHome().getButtonProfilo();
	}
	
	public JButton getRegistratiButton() {
		return getSignUp().getRegistrati();
	}
	
	public JButton getChatButton() {
		return getHome().getButtonChat();
	}
	
	public JButton getNotificheButton() {
		return getHome().getButtonNotifiche();
	}
	
	//Get pannello Login
	public JButton getLoginButton() {
		return getLogIn().getAccedi();
	}
	
	public JButton getSignUpButton() {
		return getLogIn().getSignUp();
	}
	
	public String emailInserita() {
		return getLogIn().getInserimentoEmail().getText();
	}
	
	public String passwordInserita() {
		return getLogIn().getInserimentoEmail().getText();
	}
	
	//Get pannello impostazioni
	public JButton getHomeImpostazioniButton() {
		return getImpostazioni().getHomeImpostazioni();
	}
	
	//Get pannello profilo
	public JButton getHomeProfiloButton() {
		return getProfilo().getHomeProfilo();
	}
	
	//Get pannello Chat
	public JButton getHomeChatButton() {
		return getChat().getHomeChat();
	}
	
	//Get pannello Notifiche
	public JButton getHomePannelloNotificheButton() {
		return getPannelloNotifiche().getHomeNotifiche();
	}

	public HashMap<String, JPanel> getMappaSchermate() {
		return this.mappaSchermate;
	}

	public SpecificContainer getFrameMainContainer() {
		return FrameMainContainer;
	}

	public void setFrameMainContainer(SpecificContainer frameMainContainer) {
		FrameMainContainer = frameMainContainer;
	}
	
	public String getEmailPerReigstrarsi() {
		SignUp signUp = (SignUp)this.getSignUp();
		return signUp.getEmailPerReigstrarsi();
	}
	
	public String getPasswordPerReigstrarsi() {
		SignUp signUp = (SignUp)this.getSignUp();
		return signUp.getPasswordPerRegistrarsi();
	}
}