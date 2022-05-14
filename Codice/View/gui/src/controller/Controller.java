package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JPanel;

import Sistema.Sistema;
import packageframe.Frame;
import panelspackage.panels.LogIn;

public class Controller {
	
	//private HashMap<String, JPanel> mappaSchermateController = new HashMap<String, JPanel>();
	private ActionListener gestoreLogin, gestoreSignUp, gestoreImpostazioni, gestoreRegistrati, gestoreProfilo,
						   gestoreChat, gestorePannelloNotifiche;
	
	Frame view;
	Sistema model;
	
	public Controller(Sistema s, Frame f) {
		this.view = f;
		this.model = s;	
	}
	
	public void initComponents() {
		gestoreLogin = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Login");
				//mostraSchermata("Home");
				view.mostraSchermata("Login");
			}
		};
		view.getLoginButton().addActionListener(gestoreLogin);
		
		gestoreSignUp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Login");
				//mostraSchermata("Signup");
				view.mostraSchermata("Signup");
			}
		};
		view.getSignUpButton().addActionListener(gestoreSignUp);
		
		gestoreRegistrati = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Signup");
				//mostraSchermata("Home");
				view.mostraSchermata("Home");
			}
		};
		view.getRegistratiButton().addActionListener(gestoreRegistrati);
		
		gestoreImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				//mostraSchermata("Impostazioni");
				view.mostraSchermata("Impostazioni");
			}
		};
		view.getImpostazioniButton().addActionListener(gestoreImpostazioni);
		
		gestoreProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				//mostraSchermata("Profilo");
				view.mostraSchermata("Profilo");
			}
		};
		view.getProfiloButton().addActionListener(gestoreProfilo);
		
		gestoreChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				//mostraSchermata("Chat");
				view.mostraSchermata("Chat");
			}
		};
		view.getChatButton().addActionListener(gestoreChat);
		
		gestorePannelloNotifiche = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				//mostraSchermata("PannelloNotifiche");
				view.mostraSchermata("PannelloNotifiche");
			}
		}; 
		view.getNotificheButton().addActionListener(gestorePannelloNotifiche);
	}

	public void nascondiSchermata(String schermata) {
		view.mappaSchermate.get(schermata).setVisible(false);
	}
	/*
	public void mostraSchermata(String schermata) {
		view.mappaSchermate.get(schermata).setVisible(true);
	}*/
	public void avvioSocial() {
		view.getMappaSchermate().get("Login").setVisible(true);
	}
}
