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
	public HashMap<String, JPanel> mappaSchermate = new HashMap<String, JPanel>();
	
	public Frame(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		 
	//all'avvio della GUI verra creata solo la schermata di login
		this.avvio();
		LogIn login = new LogIn();
		mappaSchermate.put("Login",   login);
		this.FrameMainContainer.add(this.getMappaSchermate().get("Login"), BorderLayout.CENTER);
		
		Home home = new Home(bufferStories, bufferPosts);
		mappaSchermate.put("Home", home);

	}
	
	public void mostraHome() {
		this.FrameMainContainer.add(this.getMappaSchermate().get("Home"), BorderLayout.CENTER);
	}
	
	public void avvio() {
		this.settingParametriFrame();
		this.add(FrameMainContainer = new SpecificContainer(Color.BLACK) , BorderLayout.CENTER);
		this.avvioSchermate();
		
	}
	
	public void settingParametriFrame() {
		this.setTitle("Social Network");
		this.setSize(814,813);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}

	/*
	public void avvioLogin() {
		LogIn logIn = new LogIn();
		FrameMainContainer.add(logIn, BorderLayout.CENTER);
		this.listaSchermateAttive.put("logIn", logIn);
		
	}
	
	public void avvioHome(ArrayList<String> bufferStories, ArrayList<String> bufferPosts) {
		Home home = new Home(bufferStories,  bufferPosts);
		FrameMainContainer.add(home);
		this.listaSchermateAttive.put("Home", home);
	}
	
	public void avviaCreazionePost() {
		CreazionePost creazionePost = new CreazionePost();
		FrameMainContainer.add(creazionePost);
		this.listaSchermateAttive.put("CreazionePost", creazionePost);
	}
	
	public void avviaImpostazioni(String profilo){
		Impostazioni impostazioni = new Impostazioni(profilo);
		FrameMainContainer.add(impostazioni);
		impostazioni.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("Impostazioni", impostazioni);
	}
	
	public void avviaProfilo(String nomeUtente, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, ArrayList<String> listaImmaginiPost) {
	Profilo profilo = new Profilo(nomeUtente, numeroFollowers, numeroSeguiti, numeroPost, immagineProfilo, listaImmaginiPost);
	FrameMainContainer.add(profilo);
	profilo.setBounds(0,0,800,775);
	this.listaSchermateAttive.put("Profilo", profilo);
	}
	
	public void avviaChat() {
		Chat chat = new Chat();
		FrameMainContainer.add(chat);

		this.listaSchermateAttive.put("Chat", chat);
	}
	
	public void avviaNotifiche() {
		PannelloNotifiche pannelloNotifiche = new PannelloNotifiche();
		FrameMainContainer.add(pannelloNotifiche);
		pannelloNotifiche.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("PannelloNotifiche", pannelloNotifiche);
	}
	
	public void avvioPostVisualizzato() {
		PostVisualizzato postVisualizzato = new PostVisualizzato("immagini/Tony.jpeg");
		FrameMainContainer.add(postVisualizzato);
		postVisualizzato.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("PannelloNotifiche", postVisualizzato);
	}
	
	public void avviaSchermataRicerca(String profilo, ArrayList<String> risultatiRicerca) {
		
		for (i = 0; i<listaRisultatiRicerca.length; i++) {
			risultatiRicerca.add(listaRisultatiRicerca[i]);
		}
		
		Ricerca ricerca = new Ricerca(profilo, risultatiRicerca);
		FrameMainContainer.add(ricerca);
		this.listaSchermateAttive.put("Ricerca", ricerca);

	}
	
	public void avviaSchermataSignUp() {
		SignUp signUp = new SignUp();
		FrameMainContainer.add(signUp);
		this.listaSchermateAttive.put("SignUp", signUp);
	}*/

	
	public void avvioSchermate() {
		
		//ArrayList bufferStories = new ArrayList();
		
		//bufferStories.add("immagini/Bruce.jpeg"); bufferStories.add("immagini/Natasha.jpeg"); bufferStories.add("immagini/Tony.jpeg"); bufferStories.add("immagini/Clint.jpeg"); bufferStories.add("immagini/Steve.jpeg");
		//Home schermataHome = new Home(bufferStories, bufferStories);
		//mappaSchermate.put("Home", (JPanel)schermataHome);
		//System.out.println("home" + mappaSchermate.get(schermataHome));
		
		/*
		mappaSchermate = new HashMap<String, JPanel>(); ;
		LogIn schermataLogin = new LogIn();
		mappaSchermate.put("Login", schermataLogin);
		System.out.println("login" + mappaSchermate.get(schermataLogin));
		*/
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
		return (Impostazioni)this.getMappaSchermate().get("Impostazioni");	
	}
	
	public PannelloNotifiche getPannelloNotifiche() {
		return (PannelloNotifiche)this.getMappaSchermate().get("PannelloNotifiche");
	}
	
	public LogIn getLogIn() {
		return (LogIn)mappaSchermate.get("Login");	
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
	
	public JButton getLoginButton() {
		return getLogIn().getAccedi();
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
	
	
	
}