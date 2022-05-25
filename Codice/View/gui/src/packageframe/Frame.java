package packageframe;
import java.awt.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;

import Sistema.Sistema;
import controller.Controller;
import panelspackage.panels.Chat;
import panelspackage.panels.CreazionePost;
import panelspackage.panels.Home;
import panelspackage.panels.Impostazioni;
import panelspackage.panels.LogIn;
import panelspackage.panels.PostVisualizzato;
import panelspackage.panels.Profilo;
import panelspackage.panels.Ricerca;
import panelspackage.panels.SignUp;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.PannelloNotifiche;
import panelspackage.panels.elements.SpecificContainer;

@SuppressWarnings("serial")
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
		 	avvio(bufferStories, bufferPosts, nomeUtente, eMail, numeroFollowers, numeroSeguiti, numeroPost,immagineProfilo, listaImmaginiPost);
	}
	

	public void avvio(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		settingParametriFrame();
		add(FrameMainContainer = new SpecificContainer(Color.BLACK) , BorderLayout.CENTER);
		avvioSchermate(bufferStories, bufferPosts, nomeUtente, eMail, numeroFollowers, numeroSeguiti, numeroPost,immagineProfilo, listaImmaginiPost);
		setVisible(true);
	}
	
	public void settingParametriFrame() {
		setTitle("Social Network");
		setSize(814,813);
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	}
	
	public void avvioSchermate(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		LogIn login = new LogIn();
		mappaSchermate.put("Login",   login);
		FrameMainContainer.add(this.getMappaSchermate().get("Login"), BorderLayout.CENTER);

		SignUp signup = new SignUp();
		mappaSchermate.put("Signup", signup);

		Home home = new Home(bufferStories, bufferPosts);
		mappaSchermate.put("Home", home);

		Impostazioni impostazioni = new Impostazioni("Stringa profilo prova");
		mappaSchermate.put("Impostazioni", impostazioni);

		Profilo profilo = new Profilo("Tony Stark", 10, 20, 30, bufferStories.get(2), listaPost);
		mappaSchermate.put("Profilo", profilo);

		Chat chat = new Chat();
		mappaSchermate.put("Chat", chat);

		PannelloNotifiche pannelloNotifiche = new PannelloNotifiche();
		mappaSchermate.put("PannelloNotifiche", pannelloNotifiche);

		CreazionePost creazionePost = new CreazionePost();
		mappaSchermate.put("CreazionePost", creazionePost);
		
		Ricerca ricerca = new Ricerca();
		mappaSchermate.put("Ricerca", ricerca);
		
		PostVisualizzato postVisualizzato = new PostVisualizzato();
		mappaSchermate.put("Postvisualizzato", postVisualizzato);
	
	}
	
	public void mostraSchermata(String Schermata) {
		this.FrameMainContainer.add(mappaSchermate.get(Schermata), BorderLayout.CENTER);
		mappaSchermate.get(Schermata).setVisible(true);
	}
	
	public void mostraBottoneSuperiore(boolean condition) {
		((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).mostraBottoneSuperiore(condition);
	}

	public String getEmailPerReigstrarsi() {
		return ((SignUp)mappaSchermate.get("Signup")).getEmailPerReigstrarsi();
	}

	public String getNickNamePerReigstrarsi() {
		return ((SignUp)mappaSchermate.get("Signup")).getNickNamePerReigstrarsi();
	}
	public String getPasswordPerReigstrarsi() {
		return ((SignUp)mappaSchermate.get("Signup")).getPasswordPerRegistrarsi();
	}
	
	public static Color getColoreprimariotematico() {
		return COLOREPRIMARIOTEMATICO;
	}

	public static Color getColoresecondariotematico() {
		return COLORESECONDARIOTEMATICO;
	}
	

	public ArrayList<String> getRisultatiRicerca() {
		return risultatiRicerca;
	}

	public PostVisualizzato getPostVisualizzato() {
		return (PostVisualizzato)getMappaSchermate().get("Postvisualizzato");	
	}
	
	
	public JButton getImpostazioniButton() {
		return ((Home)mappaSchermate.get("Home")).getButtonImpostazioni();
	}
	
	public JButton getCreazionePostButton() {
		return ((Home)mappaSchermate.get("Home")).getpPost();
	}
	
	public JButton getHomeCreazionePostButton() {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getHomeCreazionePost();
	}
	
	public String ottieniPercorsoFile(){
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).ottieniPercorsoFile();
	}
	
	public String ottieniCommento() {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).ottieniCommento();
	}
	
	public JButton getPubblicaPostButton() {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getPubblicaPost();

	}
	
	public JButton getProfiloButton() {
		return ((Home)mappaSchermate.get("Home")).getButtonProfilo();
	}
	
	public JButton getRegistratiButton() {
		return ((SignUp)mappaSchermate.get("Signup")).getRegistrati();
	}
	
	public JButton getIndietroButton() {
		return ((SignUp)mappaSchermate.get("Signup")).getIndietro();
	}
	
	public JButton getChatButton() {
		return ((Home)mappaSchermate.get("Home")).getButtonChat();
	}
	
	public JButton getNotificheButton() {
		return ((Home)mappaSchermate.get("Home")).getButtonNotifiche();
	}
	
	public JButton getCercaButton() {
		return ((Home)mappaSchermate.get("Home")).getSearchButton();
	}
	
	public JButton getLoginButton() {
		return ((LogIn)mappaSchermate.get("Login")).getAccedi();
	}
	
	public JButton getSignUpButton() {
		return ((LogIn)mappaSchermate.get("Login")).getSignUp();
	}
	
	public String emailInserita() {
		return ((LogIn)mappaSchermate.get("Login")).getInserimentoEmail().getText();
	}
	
	public String passwordInserita() {
		return ((LogIn)mappaSchermate.get("Login")).getInserimentoPwd().getText();
	}
	
	public Etichette getEtichettaDiSegnalazioneLoginFallito() {
		return ((LogIn)mappaSchermate.get("Login")).getEtichettaErroreLogin();
	}
	
	public JButton getHomeImpostazioniButton() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getHomeImpostazioni();
	}
	
	public JButton getLogOutButton() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getLogout();
	}
	
	public JButton getModificaProfiloButton() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getModificaProfilo();
	}
	
	public JButton getVisibilitaPostButton() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getVisibilitaPost();
	}
	
	public JButton getEliminaAccountButton() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getEliminaAccount();
	}
	
	public SpecificContainer getContainerCenterFrame() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getContainerCenter();
	}
	
	public JButton getHomeProfiloButton() {
		return ((Profilo)mappaSchermate.get("Profilo")).getHomeProfilo();
	}

	public void setFotoProfilo(String percorso) {
		 ((Profilo)mappaSchermate.get("Profilo")).setFotoProfilo(percorso);
	}
	
	public JButton getHomeChatButton() {
		return ((Chat)mappaSchermate.get("Chat")).getHome();
	}
	
	public JButton getHomePannelloNotificheButton() {
		return ((PannelloNotifiche)mappaSchermate.get("PannelloNotifiche")).getHomeNotifiche();
	}
	
	public JButton getHomeRicercaButton() {
		return ((Ricerca)mappaSchermate.get("Ricerca")).getHomeRicerca();
	}

	public JButton getHomePostVisualizzatoButton() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getHomePostVisualizzato();
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
	
	public String getTestoRicerca() {
		return ((Home)mappaSchermate.get("Home")).getTestoRicerca().getText();
	}
	
	public void setTestoRicerca(String testoDaImpostare) {
		((Home)mappaSchermate.get("Home")).getTestoRicerca().setText(testoDaImpostare);
	}
	
	public JTextField getAreaDiTestoLabel() {
		return ((Home)mappaSchermate.get("Home")).getTestoRicerca();
	}
	
	public void impostaRisultatiRicerca(ArrayList<String> risultatiRicerca) {
		 ((Ricerca)mappaSchermate.get("Ricerca")).impostaRisultatiRicerca(risultatiRicerca);

	}
	
	public Etichette getEtichettaNome() {
		return ((Profilo)mappaSchermate.get("Profilo")).getEtichettaNome();
	}
	
	public JButton getPulsanteFotoProfilo() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPulsanteFotoProfilo();
	}
	
	
	public void setSchermataDati(int nPost, int nFollower, int  nSeguiti) {
		((Profilo)mappaSchermate.get("Profilo")).setSchermataDati(nPost, nFollower, nSeguiti);
	}
	
	public Etichette getTestoRicercaInSchermataRicerca() {
		return ((Ricerca)mappaSchermate.get("Ricerca")).getTestoRicerca();
	}
	
	public AreaDiTesto getCommentoDaAggiungere() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getAggiungiCommento();
	}
	
	public JButton getAggiungiCommentoButtonFrame() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getAggiungiCommentoButton();
	}
	
	public JButton getAggiungiLikeButtonFrame() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getAggiungiLikeButton();
	}
	
	public JButton getAggiungiDislikeButtonFrame() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getAggiungiDislikeButton();
	}
	
	public String getIdPostVisualizzato() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getIdPost();
	}


	public void setPostProfilo(String[][] postDelProfilo) {
		((Profilo)mappaSchermate.get("Profilo")).setPostProfilo(postDelProfilo);
	}
	
	public JButton getImpostaImmagineProfiloButton() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getImpostaImmagineProfiloButton();
	}
	
	public JButton getIniziaSeguireButton() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getIniziaSeguireButton();
	}
	
}