package controller;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import panelspackage.panels.Chat;
import panelspackage.panels.CreazionePost;
import panelspackage.panels.Home;
import panelspackage.panels.Impostazioni;
import panelspackage.panels.LogIn;
import panelspackage.panels.PostVisualizzato;
import panelspackage.panels.Profilo;
import panelspackage.panels.elements.PannelloNotifiche;
import packageframe.Frame;

public class ControllerSocial{
	
	private ArrayList<String>bufferStories;
	private ArrayList<String> bufferPosts;
	private String percorsoFile;
	
	private Home homeView;
	private Frame frameSocial;
	private Impostazioni impostazioniView;
	private Chat chatView;
	private Profilo profiloView;
	private PostVisualizzato postVisualizzatoView;
	private PannelloNotifiche pannelloNotificheView;
	private LogIn loginView;
	private CreazionePost creazionePostView;
	//Inserire modello con metodi per la home 
	
	//ActionListener login
	private ActionListener gestoreLogin;
	private ActionListener gestoreSignup;
	
	//ActionListener Home
	private ActionListener gestoreImpostazioni;
	private ActionListener gestoreProfilo;
	private ActionListener gestoreChat;
	private ActionListener gestoreNotifiche;
	private ActionListener gestoreRicerca;
	private ActionListener gestoreAggiungiLike;
	private ActionListener gestoreAggiungiDislike;
	private ActionListener gestoreAggiungiCommento;
	private ActionListener gestorePostSuccessivo;
	private ActionListener gestorePostPrecedente;
	private ActionListener gestoreStoriaSuccessiva;
	private ActionListener gestoreStoriaPrecedente;
	private ActionListener gestorePubblicaPost;
	private ActionListener gestorePubblicaStoria;
	private ActionListener gestorePubblicaSondaggio;
	private ActionListener gestorePubblicaIdea;
	
	//ActionListener Impostazioni
	private ActionListener gestoreHomeImpostazioni;
	private ActionListener gestoreModificaProfilo;
	private ActionListener gestoreSalvaModifiche;
	private ActionListener gestoreLogout;
	private ActionListener gestoreVisibilitaPost;
	private ActionListener gestoreEliminaAccount;
	private ActionListener gestoreCambiaProfilo;
	private ActionListener gestoreVisibilitaProfilo;
	private ActionListener gestoreCambiaColore;
	
	//ActionListener PostVisualizzato
	private ActionListener gestoreHomePostVisualizzato;
	private ActionListener gestoreHomeProfilo;
	private ActionListener gestoreHomeChat;
	private ActionListener gestoreListaChat;
	private String[] tmp = {"1", "2", "3"};
	
	//ActionListener pubblicazione post
	private ActionListener gestoreCaricamentoPost;
	private ActionListener gestoreHomeCreazionePost;
	private ActionListener gestorePubblicazionePost;
	
	public ControllerSocial(Frame frameSocial, ArrayList<String>bufferStories, ArrayList<String>bufferPosts) {
		this.bufferStories = bufferStories;
		this.bufferPosts = bufferPosts;
		
		this.frameSocial = frameSocial;
		this.loginView = frameSocial.getLogIn();

/*		this.homeView = frameSocial.getHome();
		this.impostazioniView = frameSocial.getImpostazioni();
		this.chatView = frameSocial.getChat();
		this.profiloView = frameSocial.getProfilo();
		this.postVisualizzatoView = frameSocial.getPostVisualizzato();
		this.pannelloNotificheView = frameSocial.getPannelloNotifiche();*/
		
	}
	
	public void assegnaGestoriLogin() {
		//ACTIONLISTENER PULSANTI PANNELLO LOGIN
		gestoreLogin = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(loginTest()) {
					frameSocial.setVarLogin(0);
					frameSocial.getLogIn().setVisible(false);
					frameSocial.setVarHome(1);
					frameSocial.avvioHome(bufferStories, bufferPosts);
					frameSocial.avviaChat();
					
					homeView = frameSocial.getHome();
					chatView = frameSocial.getChat();
					profiloView = frameSocial.getProfilo();
					creazionePostView = frameSocial.getCreazionePost();
					assegnaGestoriHome();
				}
			}
		};
		loginView.getAccedi().addActionListener(gestoreLogin);
		
		gestoreSignup = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Aggiungere metodi signup
			}
		};
		loginView.getSignUp().addActionListener(gestoreSignup);
	}
	
	
	//Vari actionlistener
	public void assegnaGestoriHome() {
		//ACTIONLISTENER PULSANTI PANNELLO HOME
		gestoreImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(0);
				frameSocial.getHome().setVisible(false);
				frameSocial.setVarImpostazioni(1);
				frameSocial.avviaImpostazioni("Marco");
				impostazioniView = frameSocial.getImpostazioni();
				assegnaGestoriImpostazioni();
			}
		};
		homeView.getButtonImpostazioni().addActionListener(gestoreImpostazioni);
		
		
		gestoreProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(0);
				frameSocial.getHome().setVisible(false);
				frameSocial.setVarProfilo(1);
				frameSocial.avviaProfilo("Marco", 10, 19, 20, "ImmagineProfilo", tmp);
				
				profiloView = frameSocial.getProfilo();
				assegnaGestoriProfilo();
			}
		};
		homeView.getButtonProfilo().addActionListener(gestoreProfilo);
		
		
		gestoreChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(0);
				frameSocial.getHome().setVisible(false);
				frameSocial.setVarChat(1);
				chatView = frameSocial.getChat();
				
				assegnaGestoriChat();

			}
		};
		homeView.getButtonChat().addActionListener(gestoreChat);
		
		
		gestoreNotifiche = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(0);
				frameSocial.getHome().setVisible(false);
				frameSocial.setVarNotifiche(1);
				frameSocial.avviaNotifiche();
				pannelloNotificheView = frameSocial.getPannelloNotifiche();
				
				assegnaGestoriNotifiche();
			}
		};
		homeView.getButtonNotifiche().addActionListener(gestoreNotifiche);
		
		gestoreRicerca = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("Ricerca");
			}
		};
		homeView.getSearchButton().addActionListener(gestoreRicerca);
		
		
		gestoreAggiungiLike = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("aggiungi like");
			}
		};
		homeView.getAggiungiLike().addActionListener(gestoreAggiungiLike);
		
		
		gestoreAggiungiDislike = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("aggiungi dilike");
			}
		};
		homeView.getAggiungiDislike().addActionListener(gestoreAggiungiDislike);
		
		
		gestoreAggiungiCommento = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("aggiungi commento");
			}
		};
		homeView.getAggiungiCommento().addActionListener(gestoreAggiungiCommento);
		
		
		gestorePostSuccessivo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("post successivo");
			}
		};
		homeView.getButtonNextPost().addActionListener(gestorePostSuccessivo);
		
		
		gestorePostPrecedente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("post precedente");
			}
		};
		homeView.getButtonPrevPost().addActionListener(gestorePostPrecedente);
		
		
		gestoreStoriaSuccessiva = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("storia successiva");
			}
		};
		homeView.getButtonNextStory().addActionListener(gestoreStoriaSuccessiva);
		
		
		gestoreStoriaPrecedente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("storia precedente");
			}
		};
		homeView.getButtonPrevStory().addActionListener(gestoreStoriaPrecedente);
		
		
		gestorePubblicaPost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(0);
				frameSocial.getHome().setVisible(false);
				frameSocial.setVarCreazionePost(1);
				frameSocial.avviaCreazionePost();
				creazionePostView = frameSocial.getCreazionePost();
				assegnaGestoriPubblicazionePost();
			}
		};
		homeView.getpPost().addActionListener(gestorePubblicaPost);
		
		
		gestorePubblicaStoria = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("pubblica storia");
			}
		};
		homeView.getpStory().addActionListener(gestorePubblicaStoria);
		
		
		gestorePubblicaSondaggio = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("pubblica sondaggio");
			}
		};
		homeView.getpSondaggio().addActionListener(gestorePubblicaSondaggio);
		
		
		gestorePubblicaIdea = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
				System.out.println("pubblica idea");
			}
		};
		homeView.getpIdea().addActionListener(gestorePubblicaIdea);
	}

	public void assegnaGestoriPubblicazionePost() {
		//ACTIONLISTENER PULSANTI CREAZIONE POST
		
		gestoreCaricamentoPost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				percorsoFile = creazionePostView.getFileChooser().getSelectedFile().getAbsolutePath();
				System.out.println(percorsoFile);
			}
		};
		creazionePostView.getFileChooser().addActionListener(gestoreCaricamentoPost);
		
		
		gestorePubblicazionePost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodi pubblicazione post
			}
		};
		creazionePostView.getPubblicaPost().addActionListener(gestorePubblicazionePost);
		
		gestoreHomeCreazionePost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarCreazionePost(0);
				frameSocial.getCreazionePost().setVisible(false);
				frameSocial.setVarHome(1);
				frameSocial.getHome().setVisible(true);
				assegnaGestoriHome();
			}
		};
		creazionePostView.getHomeCreazionePost().addActionListener(gestoreHomeCreazionePost);
		
	}
	
	public void assegnaGestoriProfilo() {
		gestoreHomeProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarProfilo(0);
				frameSocial.getProfilo().setVisible(false);
				frameSocial.setVarHome(1);
				frameSocial.getHome().setVisible(true);
				assegnaGestoriHome();
			}
		};
		profiloView.getHomeProfilo().addActionListener(gestoreHomeProfilo);
	}
		
	public void assegnaGestoriImpostazioni() {
		//ACTIONLISTENER PULSANTI PANNELLO IMPOSTAZIONI		
		gestoreModificaProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				impostazioniView.getContainerCenter().setVisible(true);
				//validate() e repaint() servono per aggiornare il JPanel per mostrare gli elementi
				impostazioniView.validate();
				impostazioniView.repaint();
				//Metodi modifica profilo modello
			}
		};
		impostazioniView.getModificaProfilo().addActionListener(gestoreModificaProfilo);
	
		gestoreLogout = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//impostazioniView.getContainerCenter().setVisible(false);
				//Metodi logout modello
				nascodiPannelloModificaProfilo();
			}
		};
		impostazioniView.getLogout().addActionListener(gestoreLogout);
		
		gestoreVisibilitaPost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodi modello visibilita post
				//impostazioniView.getContainerCenter().setVisible(false);
				nascodiPannelloModificaProfilo();
			}
		};
		impostazioniView.getVisibilitaPost().addActionListener(gestoreVisibilitaPost);
		
		gestoreEliminaAccount = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodi modello elimina account
				//impostazioniView.getContainerCenter().setVisible(false);
				nascodiPannelloModificaProfilo();
			}
		};
		impostazioniView.getEliminaAccount().addActionListener(gestoreEliminaAccount);
		
		
		gestoreCambiaProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodi modello cambia profilo
				//impostazioniView.getContainerCenter().setVisible(false);
				//impostazioniView.validate();
				//impostazioniView.repaint();
				nascodiPannelloModificaProfilo();
			}
		};
		impostazioniView.getCambiaProfilo().addActionListener(gestoreCambiaProfilo);
		
		gestoreVisibilitaProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodi visibilita profilo
				//impostazioniView.getContainerCenter().setVisible(false);
				//impostazioniView.validate();
				//impostazioniView.repaint();
				nascodiPannelloModificaProfilo();
			}
		};
		impostazioniView.getVisibilitaProfilo().addActionListener(gestoreVisibilitaProfilo);
		
		gestoreCambiaColore = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodi cambia colore
				//impostazioniView.getContainerCenter().setVisible(false);
				//impostazioniView.validate();
				//impostazioniView.repaint();
				nascodiPannelloModificaProfilo();
			}
		};
		impostazioniView.getCambiaColore().addActionListener(gestoreCambiaColore);
		
		gestoreHomeImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarImpostazioni(0);
				frameSocial.getImpostazioni().setVisible(false);
				frameSocial.setVarHome(1);
				frameSocial.getHome().setVisible(true);
				assegnaGestoriHome();
			}
		};
		impostazioniView.getHomeImpostazioni().addActionListener(gestoreHomeImpostazioni);
		
		gestoreSalvaModifiche = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Metodi per il salvataggio delle modifiche nel modello
			}
		};
		impostazioniView.getSalvaModifiche().addActionListener(gestoreSalvaModifiche);
	
	}
	
	public void assegnaGestoriChat() {
		//ACTIONLISTENER PULSANTI PANNELLO CHAT
		gestoreHomeChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarChat(0);
				frameSocial.getChat().setVisible(false);
				frameSocial.setVarHome(1);
				frameSocial.getHome().setVisible(true);
				frameSocial.avviaChat();
				assegnaGestoriHome();
			}
		};
		chatView.getHomeChat().addActionListener(gestoreHomeChat);
	}
	
	public void assegnaGestoriNotifiche() {
		//ACTIONLISTENER PULSANTI  PANNELLO PROFILO
		gestoreHomeProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarNotifiche(0);
				frameSocial.getPannelloNotifiche().setVisible(false);
				frameSocial.setVarHome(1);
				frameSocial.getHome().setVisible(true);
				assegnaGestoriHome();

			}
		};
		pannelloNotificheView.getHomeNotifiche().addActionListener(gestoreHomeProfilo);
	}
		/*
		//ACTIONLISTENER PULSANTI POST VISUALIZZATO
		gestoreHomePostVisualizzato = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(1);
				frameSocial.getHome().setVisible(true);
				frameSocial.setVarLogin(0);
				frameSocial.getLogIn().setVisible(false);
				frameSocial.setVarProfilo(0);
				frameSocial.getProfilo().setVisible(false);
				frameSocial.setVarImpostazioni(0);
				frameSocial.getImpostazioni().setVisible(false);
				frameSocial.setVarChat(0);
				frameSocial.getChat().setVisible(false);
				frameSocial.setVarChatMessaggi(0);
				frameSocial.getChatMessaggi().setVisible(false);
				frameSocial.setVarPostVisualizzato(0);
				frameSocial.getPostVisualizzato().setVisible(false);
			}
		};
		postVisualizzatoView.getHomePostVisualizzato().addActionListener(gestoreHomeImpostazioni);*/

	public void nascodiPannelloModificaProfilo() {
		impostazioniView.getContainerCenter().setVisible(false);
		impostazioniView.validate();
		impostazioniView.repaint();
	}
	
	
	public boolean loginTest() {
		String email = "email";
		String password = "password";
		if(loginView.getInserimentoEmail().getText().equals(email)) {
			if(loginView.getInserimentoPassword().getText().equals(password)) {
				return true;
			}
			return false;
		} else {
			return false;
		}
	}
}

































