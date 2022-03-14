package controller;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

import panelspackage.panels.Chat;
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
	
	private Home homeView;
	private Frame frameSocial;
	private Impostazioni impostazioniView;
	private Chat chatView;
	private Profilo profiloView;
	private PostVisualizzato postVisualizzatoView;
	private PannelloNotifiche pannelloNotificheView;
	private LogIn loginView;
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
	
	//ActionListener PostVisualizzato
	private ActionListener gestoreHomePostVisualizzato;
	private ActionListener gestoreHomeProfilo;
	private ActionListener gestoreHomeChat;
	private ActionListener gestoreListaChat;
	private String[] tmp = {"1", "2", "3"};
	
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
				//Inserire metodi
				System.out.println("pubblica post");
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
		
		gestoreModificaProfilo = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				impostazioniView.getContainerCenter().setVisible(true);
			}
		};
		impostazioniView.getModificaProfilo().addActionListener(gestoreModificaProfilo);
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

































