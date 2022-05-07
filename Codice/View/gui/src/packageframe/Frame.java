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
import panelspackage.panels.elements.SpecificContainer;

public class Frame extends JFrame {
	
	int i;
	
	public static final  Color COLOREPRIMARIOTEMATICO = new Color(255, 175, 0);
	public static final  Color COLORESECONDARIOTEMATICO = new Color(0,0,0);	

	private HashMap<String, JPanel> listaSchermateAttive = new HashMap<String, JPanel>();
	private ArrayList<String> risultatiRicerca = new ArrayList<String>();
	private SpecificContainer FrameMainContainer;
	
	// liste di prova
	static  String listaCommenti[] = {"benissimo", "ok", "okok"};
	static  String listaUtenti[] = {"Natasha", "Steve", "Clint"};
	static String listaRisultatiRicerca[] = {"tony1","tony2","tony3","tony4","tony5","tony6","tony7","tony8","tony9","tony10","tony11","tony12","tony13","tony14","tony15"};

	
	public Frame(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		 
	//all'avvio della GUI verra creata solo la schermata di login
		this.avvio();
	}
	
	public void avvio() {
		this.settingParametriFrame();
		this.add(FrameMainContainer = new SpecificContainer(Color.BLACK) , BorderLayout.CENTER);
		this.avvioLogin();
	}
	
	public void settingParametriFrame() {
		this.setTitle("Social Network");
		this.setSize(814,813);
		this.setLayout(new BorderLayout());
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.setResizable(false);
	}
	
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
		layers.add(ricerca, new  Integer(0), 0);
		ricerca.setBounds(0,0,800,775);
		this.listaSchermateAttive.put("Ricerca", ricerca);

	}
	
	public void avviaSchermataSignUp() {
		SignUp signUp = new SignUp();
		FrameMainContainer.add(signUp);
		this.listaSchermateAttive.put("SignUp", signUp);
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

	public PostVisualizzato getPostVisualizzato() {
		return (PostVisualizzato) listaSchermateAttive.get("PostVisualizzato");	
	}
	
	public JButton getLoginButton() {
		return this.getLogIn().getAccedi();
	}
	
	public JButton getSignUpButton() {
		return this.getLogIn().getSignUp();
	}
	
	public HashMap avvioSchermate() {
		HashMap<String, JComponent> mappaSchermate = new HashMap<String, JComponent>();
		//LogIn schermataLogin = new LogIn();
		ArrayList bufferStories = new ArrayList();
		bufferStories.add("immagini/Bruce.jpeg"); bufferStories.add("immagini/Natasha.jpeg"); bufferStories.add("immagini/Tony.jpeg"); bufferStories.add("immagini/Clint.jpeg"); bufferStories.add("immagini/Steve.jpeg");
		Home schermataHome = new Home(bufferStories, bufferStories);
		//mappaSchermate.put("Login", schermataLogin);
		mappaSchermate.put("Home", schermataHome);
		return mappaSchermate;
	}

	public static Color getColoreprimariotematico() {
		return COLOREPRIMARIOTEMATICO;
	}

	public static Color getColoresecondariotematico() {
		return COLORESECONDARIOTEMATICO;
	}
}