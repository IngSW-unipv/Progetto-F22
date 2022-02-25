package controller;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;

import panelspackage.panels.Home;
import packageframe.Frame;

public class ControllerSocial{
	
	private Home homeView;
	private Frame frameSocial;
	//Inserire modello con metodi per la home 
	
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
	
	public ControllerSocial(Frame frameSocial) {
		this.frameSocial = frameSocial;
		this.homeView = frameSocial.getHome();
		//inserire modello con metodi per la home .
	}
	
	public void assegnaGestori() {
		
		gestoreImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(0);
				frameSocial.getHome().setVisible(false);
				frameSocial.setVarLogin(0);
				frameSocial.getLogIn().setVisible(false);
				frameSocial.setVarProfilo(0);
				frameSocial.getProfilo().setVisible(false);
				frameSocial.setVarImpostazioni(1);
				frameSocial.getImpostazioni().setVisible(true);
				frameSocial.setVarChat(0);
				frameSocial.getChat().setVisible(false);
				frameSocial.setVarChatMessaggi(0);
				frameSocial.getChatMessaggi().setVisible(false);
			}
		};
		homeView.getButtonImpostazioni().addActionListener(gestoreImpostazioni);
		
		
		gestoreProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(0);
				frameSocial.getHome().setVisible(false);
				frameSocial.setVarLogin(0);
				frameSocial.getLogIn().setVisible(false);
				frameSocial.setVarProfilo(1);
				frameSocial.getProfilo().setVisible(true);
				frameSocial.setVarImpostazioni(0);
				frameSocial.getImpostazioni().setVisible(false);
				frameSocial.setVarChat(0);
				frameSocial.getChat().setVisible(false);
				frameSocial.setVarChatMessaggi(0);
				frameSocial.getChatMessaggi().setVisible(false);
			}
		};
		homeView.getButtonProfilo().addActionListener(gestoreProfilo);
		
		
		gestoreChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				frameSocial.setVarHome(0);
				frameSocial.getHome().setVisible(false);
				frameSocial.setVarLogin(0);
				frameSocial.getLogIn().setVisible(false);
				frameSocial.setVarProfilo(0);
				frameSocial.getProfilo().setVisible(false);
				frameSocial.setVarImpostazioni(0);
				frameSocial.getImpostazioni().setVisible(false);
				frameSocial.setVarChat(1);
				frameSocial.getChat().setVisible(true);
				frameSocial.setVarChatMessaggi(0);
				frameSocial.getChatMessaggi().setVisible(false);
			}
		};
		homeView.getButtonChat().addActionListener(gestoreChat);
		
		
		gestoreNotifiche = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Inserire metodi
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
}



























