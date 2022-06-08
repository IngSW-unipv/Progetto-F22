package packageframe;


import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.*;
import panelspackage.panels.AreaChatFrame;
import panelspackage.panels.Chat;
import panelspackage.panels.CreazioneChatDiGruppo;
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
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.PannelloNotifiche;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;


public class Frame extends JFrame {
	
	int i;
	public static final  Color COLOREPRIMARIOTEMATICO = new Color(255, 175, 0);
	public static final  Color COLORESECONDARIOTEMATICO = new Color(0,0,0);	
    private ArrayList<String> risultatiRicerca = new ArrayList<String>();
	private SpecificContainer FrameMainContainer;
	
	static  String listaCommenti[] = {"benissimo", "ok", "okok"};
	static  String listaUtenti[] = {"Natasha", "Steve", "Clint"};
	static String listaRisultatiRicerca[] = {"tony1","tony2","tony3","tony4","tony5","tony6","tony7","tony8","tony9","tony10",
			                                 "tony11","tony12","tony13","tony14","tony15"};
	ArrayList<String> listaPost = new ArrayList<String>();
	public HashMap<String, JPanel> mappaSchermate = new HashMap<String, JPanel>();
	
	
	public Frame(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, 
			     int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		
		 	avvio(bufferStories, bufferPosts, nomeUtente, eMail, numeroFollowers, numeroSeguiti, numeroPost,immagineProfilo, listaImmaginiPost);
	   }
	

	public void avvio(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, int numeroFollowers, 
			          int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		
		settingParametriFrame();
		add(FrameMainContainer = new SpecificContainer(Color.BLACK) , BorderLayout.CENTER);
		avvioSchermate(bufferStories, bufferPosts, nomeUtente, eMail, numeroFollowers, numeroSeguiti, numeroPost, immagineProfilo, 
				       listaImmaginiPost);
		setVisible(true);
		                
	  }
	
	
	public void settingParametriFrame() {
		
		setTitle("Social Network");
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	    this.setSize(screenSize.width , screenSize.height );
		setLayout(new BorderLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setResizable(false);
	  
	  }
	
	public void avvioSchermate(ArrayList<String> bufferStories, ArrayList<String> bufferPosts, String nomeUtente, String eMail, 
			                   int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, String[] listaImmaginiPost ) {
		
		LogIn login = new LogIn();
		mappaSchermate.put("Login",   login);
		FrameMainContainer.add(this.getMappaSchermate().get("Login"), BorderLayout.CENTER);

		SignUp signup = new SignUp();
		mappaSchermate.put("Signup", signup);

		Home home = new Home(bufferStories, bufferPosts);
		mappaSchermate.put("Home", home);

		Impostazioni impostazioni = new Impostazioni("Stringa profilo prova");
		mappaSchermate.put("Impostazioni", impostazioni);

		Profilo profilo = new Profilo(listaPost);
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
		
		AreaChatFrame AreaChatFrame = new AreaChatFrame();
		mappaSchermate.put("AreaChatFrame", AreaChatFrame);
		
		CreazioneChatDiGruppo creazioneChatDiGruppo = new CreazioneChatDiGruppo();
		mappaSchermate.put("CreazioneChatDiGruppo", creazioneChatDiGruppo);
	
	
	}
	
	
	public void mostraSchermata(String Schermata) {
		this.FrameMainContainer.add(mappaSchermate.get(Schermata), BorderLayout.CENTER);
		mappaSchermate.get(Schermata).setVisible(true);
	}
	
	/*public void mostraBottoneSuperiore(boolean condition) {
		((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).mostraBottoneSuperiore(condition);
	}*/

	
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
	
	
	public HashMap<String, JPanel> getMappaSchermate() {
		return this.mappaSchermate;
	}

	
	public SpecificContainer getFrameMainContainer() {
		return FrameMainContainer;
	}

	
	public void setFrameMainContainer(SpecificContainer frameMainContainer) {
		FrameMainContainer = frameMainContainer;
	}

	
	public ArrayList<String> getRisultatiRicerca() {
		return risultatiRicerca;
	}

	
	public PostVisualizzato getPostVisualizzato() {
		return (PostVisualizzato)getMappaSchermate().get("Postvisualizzato");	
	}
	
	
	public JButton getPIdeaButton( ) {
		return ((Home)mappaSchermate.get("Home")).getpIdea();
	}
	
	
	public JButton getImpostazioniButton() {
		return ((Home)mappaSchermate.get("Home")).getButtonImpostazioni();
	}
	
	public JButton getCreazionePostButton() {
		return ((Home)mappaSchermate.get("Home")).getpPost();
	}
	
	public JButton getButtonNextPost() {
		return ((Home)mappaSchermate.get("Home")).getButtonNextPost();
	}
	public int getContatorePost() {
		return ((Home)mappaSchermate.get("Home")).getContatorePost();
	}
	public int getContatoreStory() {
		return ((Home)mappaSchermate.get("Home")).getContatoreStory();
	}
	
	public void setContatorePost(int valore) {
		return ((Home)mappaSchermate.get("Home")).setContatorePost(valore);
	}
	public void setContatoreStory(int valore) {
		return ((Home)mappaSchermate.get("Home")).setContatoreStory(valore);
		
	public JButton getButtonPrevPost() {
		return ((Home)mappaSchermate.get("Home")).getButtonPrevPost();
	}
	
	public JButton getHomeCreazionePostButton() {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getHomeCreazionePost();
	}
	
	
	public JButton getPubblicaPostButton() {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getPubblicaPost();

	}
	
	
	public JButton getPubblicaStoryButton() {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getStory();
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
	
	
	public JButton getCercaButton() {
		return ((Home)mappaSchermate.get("Home")).getSearchButton();
	}
	
	
	
	public JButton getLoginButton() {
		return ((LogIn)mappaSchermate.get("Login")).getAccedi();
	}
	
	
	public JButton getSignUpButton() {
		return ((LogIn)mappaSchermate.get("Login")).getSignUp();
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
	public Pulsanti getSalvaModificheButton() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getSalvaModifiche();
	}
	
	public JButton getEliminaAccountButton() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getEliminaAccount();
	}
	
	
	public String ottieniPercorsoFile(){
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).ottieniPercorsoFile();
	}
	
	
	public String ottieniCommento() {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).ottieniCommento();
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
	
	
	public SpecificContainer getContainerCenterFrame() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getContainerCenter();
	}
	
	
	public JButton getHomeProfiloButton() {
		return ((Profilo)mappaSchermate.get("Profilo")).getHomeProfilo();
	}

	
	public void setFotoProfilo(String percorso) {
		 ((Profilo)mappaSchermate.get("Profilo")).setFotoProfilo(percorso);
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
	
    public void settaSondaggioVisualizzato(String iDpost, String descrizionePost, String scelta1, String scelta2, String scelta3, String scelta4, int numeroLike, int numeroDislike, int numeroCommenti,ArrayList<String> commenti) {
        ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).settaSondaggioVisualizzato(iDpost, descrizionePost, scelta1, scelta2, scelta3, scelta4, numeroLike, numeroDislike, numeroCommenti, commenti);
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
	
	
	public void impostaRisultatiRicerca(String risultatiRicerca) {
		 ((Ricerca)mappaSchermate.get("Ricerca")).impostaRisultatiRicerca(risultatiRicerca);
         
	}
	
	
	public Etichette getEtichettaNome() {
		return ((Profilo)mappaSchermate.get("Profilo")).getEtichettaNome();
	}
	
	
	public JButton getPulsanteFotoProfilo() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPulsanteFotoProfilo();
	}
	
	
	public void setSchermataDati(int nPost, int nFollower, int  nSeguiti, String nickName) {
		((Profilo)mappaSchermate.get("Profilo")).setSchermataDati(nPost, nFollower, nSeguiti, nickName);
	}
	
	
	public JButton getPost1() {
		return ((Profilo)mappaSchermate.get("Profilo")).getListaPost().get(0);
	}
	
	
	public JButton getPost2() {
		return ((Profilo)mappaSchermate.get("Profilo")).getListaPost().get(1);
	}
	
	
	public JButton getPost3() {
		return ((Profilo)mappaSchermate.get("Profilo")).getListaPost().get(2);
	}
	
	

	
	
	public Pulsanti getPulsantePrimoSondaggio() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPulsantePrimoSondaggio();
	}


	public Pulsanti getPulsanteSecondoSondaggio() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPulsanteSecondoSondaggio();
	}


	public Pulsanti getPulsanteTerzoSondaggio() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPulsanteTerzoSondaggio();
	}
	
	public void setPostTestoProfilo(ArrayList<String> postTestoDelProfilo) {
		((Profilo)mappaSchermate.get("Profilo")).setPostTestoProfilo(postTestoDelProfilo);
	}
	
	
	public int getContatoreFoto() {
		return ((Profilo)mappaSchermate.get("Profilo")).getContatoreFoto();
	}
	
	public int getContatoreSondaggio() {
		return ((Profilo)mappaSchermate.get("Profilo")).getContatoreSondaggio();
	}
	
	public int getContatoreTesto() {
		return ((Profilo)mappaSchermate.get("Profilo")).getContatoreTesto();
	}
	
	
	public void setContatoreFoto(int nuovoContatore) {
		((Profilo)mappaSchermate.get("Profilo")).setContatoreFoto(nuovoContatore);
	}
	
	public void setContatoreSondaggio(int nuovoContatore) {
		((Profilo)mappaSchermate.get("Profilo")).setContatoreSondaggio(nuovoContatore);
	}
	
	public void setContatoreTesto(int nuovoContatore) {
		((Profilo)mappaSchermate.get("Profilo")).setContatoreTesto(nuovoContatore);
	}

	public JButton getNextFoto() {
		return ((Profilo)mappaSchermate.get("Profilo")).getNextFoto();
	}
	
	public JButton getPrevFoto() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPrevFoto();
	}
	
	public JButton getNextTesto() {
		return ((Profilo)mappaSchermate.get("Profilo")).getNextTesto();
	}

	public JButton getPrevTesto() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPrevTesto();
	}
	
	public JButton getNextSondaggio() {
		return ((Profilo)mappaSchermate.get("Profilo")).getNextSondaggio();
	}
	
	public JButton getPrevSondaggio() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPrevSondaggio();
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


	public void setPostProfilo(ArrayList<String> postDelProfilo) {
		((Profilo)mappaSchermate.get("Profilo")).setPostProfilo(postDelProfilo);
	}
	
	
	public JButton getImpostaImmagineProfiloButton() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getImpostaImmagineProfiloButton();
	}
	
	
	public JButton getIniziaSeguireButton() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getIniziaSeguireButton();
	}
	
	
	public JButton getHomeChatButton() {
		return ((Chat)mappaSchermate.get("Chat")).getTornaHome();
	}
	
	
	public JButton getAggiornaChatButton() {
		return ((Chat)mappaSchermate.get("Chat")).getAggiornaAltriChat();
	}
	
	public JButton getPrimaChatGruppoButton() {
		return ((Chat)mappaSchermate.get("Chat")).getPrimaChatGruppo();
	}
	
	
	public JButton getPrimaChatPrivataButton() {
		return ((Chat)mappaSchermate.get("Chat")).getPrimaChatPrivata();
	}
	
	
	public JButton getSecondaChatGruppoButton() {
		return ((Chat)mappaSchermate.get("Chat")).getSecondaChatGruppo();
	}
	
	
	public JButton getSecondaChatPrivataButton() {
		return ((Chat)mappaSchermate.get("Chat")).getSecondaChatPrivata();
	}
	
	
	public JButton getTerzaChatGruppoButton() {
		return ((Chat)mappaSchermate.get("Chat")).getSecondaChatGruppo();
	}
	
	
	public JButton getTerzaChatPrivataButton() {
		return ((Chat)mappaSchermate.get("Chat")).getSecondaChatPrivata();
	}
	
	
	public JButton getQuartaChatGruppoButton() {
		return ((Chat)mappaSchermate.get("Chat")).getSecondaChatGruppo();
	}
	
	
	public JButton getQuartaChatPrivataButton() {
		return ((Chat)mappaSchermate.get("Chat")).getSecondaChatPrivata();
	}
	
	
	public JButton getQuintaChatGruppoButton() {
		return ((Chat)mappaSchermate.get("Chat")).getSecondaChatGruppo();
	}
	
	
	public JButton getQuintaChatPrivataButton() {
		return ((Chat)mappaSchermate.get("Chat")).getSecondaChatPrivata();
	}
	
	
	public void settaCommenti(ArrayList<String> lista) {
		((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).settaCommenti(lista);
	}
	
	
	public JButton  getPrevCommento() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getPrevCommento();	
	}
	
	
	public JButton  getNextCommento() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getNextCommento();	
	}
	
	
	public int getIndiceCommento() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getIndiceCommentoCorrente();
	}
	
	
	public void incrementaIndiceCommento() {
		((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).incrementaIndiceCommento();
	}
	
	
	public void decrementaIndiceCommento() {
		((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).decrementaIndiceCommento();
	}
	
	
	public void ripristinaIndiceCommento() {
		((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).ripristinaIndiceCommento();
	}
	
	
	public int getNumeroCommentiTotali() {
		return((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getNumeroCommentiTotali();
	}
	
	
	public void setPostVisualizzato(String idPost, String path, String descrizionePost, int numeroLike, int numeroDislike, int numeroCommenti, 
			                        ArrayList<String> commentiConProfiloInviante) {
		
		((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).settaPostVisualizzato(idPost,path, descrizionePost, numeroLike, numeroDislike, 
				                                                                          numeroCommenti, commentiConProfiloInviante);
	}
		
	public JButton getPulsantePrimaScelta() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getPulsantePrimaScelta();
	}
	
	public JButton getPulsanteSecondaScelta() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getPulsanteSecondaScelta();
	}
	
	public JButton getPulsanteTerzaScelta() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getPulsanteTerzaScelta();
	}
	
	public JButton getPulsanteQuartaScelta() {
		return ((PostVisualizzato)mappaSchermate.get("Postvisualizzato")).getPulsanteQuartaScelta();
	}

	public JFileChooser getFileChooser() {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getFileChooser();
	}
	
	
	public Pulsanti getPulsanteRicercaProfilo() {
		return ((Ricerca)mappaSchermate.get("Ricerca")).getProfiloCercato();
	}
	
	
	public Pulsanti getPulsanteRicercaChat() {
		return ((Ricerca)mappaSchermate.get("Ricerca")).gruppoCercato();
	}
	
	
	public Pulsanti getPulsanteSegui() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPulsanteSegui();
	}
	
	
	public Pulsanti getApriChat() {
		return ((Profilo)mappaSchermate.get("Profilo")).getApriChat();
	}
	public void setPostSondaggioProfilo(ArrayList<String> postSondaggioDelProfilo) {
		((Profilo)mappaSchermate.get("Profilo")).setPostSondaggioProfilo(postSondaggioDelProfilo);
	}

	
	
	public InserimentoTesto getScriviMessaggio() {
		return ((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).getScriviMessaggio();
	}
	
	
	public Pulsanti getInviaMessaggio() {
		return ((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).getInvia();
	}
	
	
	public void aggiornaMessaggi(ArrayList<String> messaggi, String inviante) {
		((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).aggiornaMessaggi(messaggi, inviante);
	}
	
	
	public Pulsanti getNextMessaggioButton() {
		return ((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).getNextMessaggio();
	}
	
	
	public Pulsanti getPrevMessaggioButton() {
		return ((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).getPrevMessaggio();
	}
	
	
	public Pulsanti getPulsanteHomeAreaChatFrame() {
		return ((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).getHome();
	}
	
	
	public void incrementaIndiceMessaggio() {
		((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).incrementaIndiceMessaggioCorrente();
	}
	
	
	public void decrementaIndiceMessaggio() {
		((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).decrementaIndiceMessaggioCorrente();
	}
	
	
	public int getIndiceMessaggioCorrente() {
		return ((AreaChatFrame)mappaSchermate.get("AreaChatFrame")).getIndiceMessaggioCorrente();
	}
	
	
	public JButton getPSondaggioDoppiaVotazioneButton( ) {
		return ((Home)mappaSchermate.get("Home")).getpSondaggioDoppiaVotazione();
	}
	
	
	public JButton getPSondaggioSceltaMultiplaButton( ) {
		return ((Home)mappaSchermate.get("Home")).getpSondaggioSceltaMultipla();
	}
	
	
	public JButton getCreaUnaChatDiGruppo( ) {
		return ((Home)mappaSchermate.get("Home")).getCreaUnaChatDiGruppo();
	}

	
	public InserimentoTesto getPrimaScelta( ) {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getSceltaSondaggio1();
	}
	
	
	public InserimentoTesto getSecondaScelta( ) {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getSceltaSondaggio2();
	}
	
	
	public InserimentoTesto getTerzaScelta( ) {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getSceltaSondaggio3();
	}
	
	
	public InserimentoTesto getQuartaScelta( ) {
		return ((CreazionePost)mappaSchermate.get("CreazionePost")).getSceltaSondaggio4();
	}
	
	
	public void impostaFotoPostVisualizzato(String percorso) {
		((PostVisualizzato)mappaSchermate.get("PostVisualizzato")).cambiaFoto(percorso);
	}
	
	
	public JButton getNextTipoPost( ) {
		return ((Profilo)mappaSchermate.get("Profilo")).getNextTipoPost();
	}
	
	
	public JButton getPrevTipoPost() {
		return ((Profilo)mappaSchermate.get("Profilo")).getPrevTipoPost();
	}
	
	
	public JButton getCreaGruppo() {
		return ((CreazioneChatDiGruppo)mappaSchermate.get("CreazioneChatDiGruppo")).getCreaGruppo();
	}
	
	
	public InserimentoTesto getNomeGruppo() {
		return ((CreazioneChatDiGruppo)mappaSchermate.get("CreazioneChatDiGruppo")).getNomeGruppo();
	}
	
	
	public InserimentoTesto getDescrizioneGruppo() {
		return ((CreazioneChatDiGruppo)mappaSchermate.get("CreazioneChatDiGruppo")).getDescrizioneGruppo();
	}
	
	
	public String getPercorsoImmagineGruppo() {
		return ((CreazioneChatDiGruppo)mappaSchermate.get("CreazioneChatDiGruppo")).getPercorsoImmagineGruppo();
	}
	public AreaDiTesto getDescrizione() {
		return ((Impostazioni)mappaSchermate.get("Impostazioni")).getAreaDescrizione();
	}
	
	public Pulsanti getHomeCreazioneChatDiGruppo() {
		return ((CreazioneChatDiGruppo)mappaSchermate.get("CreazioneChatDiGruppo")).getHome();
	}
	
}