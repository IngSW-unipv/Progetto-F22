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
						   gestoreChat;
	
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
				mostraSchermata("Home");
				view.mostraHome();
			}
		};
		view.getLoginButton().addActionListener(gestoreLogin);
		
		gestoreSignUp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Login");
				mostraSchermata("Signup");
				view.mostraSignUp();
			}
		};
		view.getSignUpButton().addActionListener(gestoreSignUp);
		
		gestoreRegistrati = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Signup");
				mostraSchermata("Home");
				view.mostraHome();
			}
		};
		view.getRegistratiButton().addActionListener(gestoreRegistrati);
		
		gestoreImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				mostraSchermata("Impostazini");
				view.mostraImpostazioni();
			}
		};
		view.getImpostazioniButton().addActionListener(gestoreImpostazioni);
		
		gestoreProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				mostraSchermata("Profilo");
				view.mostraProfilo();
			}
		};
		view.getProfiloButton().addActionListener(gestoreProfilo);
		
		gestoreChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				mostraSchermata("Chat");
				view.mostraChat();
			}
		};
		view.getChatButton().addActionListener(gestoreChat);
		
		
	}
	

	public void nascondiSchermata(String schermata) {
		view.mappaSchermate.get(schermata).setVisible(false);
	}
	
	public void mostraSchermata(String schermata) {
		view.mappaSchermate.get(schermata).setVisible(true);
	}
	
	public void avvioSocial() {
		view.getMappaSchermate().get("Login").setVisible(true);
	}
}
