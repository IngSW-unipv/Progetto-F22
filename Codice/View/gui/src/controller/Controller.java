package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComponent;
import javax.swing.JPanel;

import Sistema.Sistema;
import packageframe.Frame;

public class Controller {
	
	//private HashMap<String, JPanel> listaSchermate = new HashMap<String, JPanel>();
	private ActionListener gestoreLogin, gestoreSignUp;
	
	Frame view;
	Sistema model;
	
	public Controller(Sistema s, Frame f) {
		
		view = f;
		model = s;
		view.avvioSchermate();
		//listaSchermate = view.getMappaSchermate();
		//listaSchermate.put("Login",view.getLogIn());
		//listaSchermate.put("Home", view.getHome());
		//initComponents();
		
		view.mappaSchermate.put("Home", view.getHome());
		view.mappaSchermate.put("Login", view.getLogIn());

		
	}
	
	public void initComponents() {
		////ACTIONLISTENER PULSANTI PANNELLO LOGIN
		gestoreLogin = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Login");
				mostraSchermata("Home");
				
			}
		};
		
		view.getLoginButton().addActionListener(gestoreLogin);
		
		gestoreSignUp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Login");
				
				
			}
		};
		view.getSignUpButton().addActionListener(gestoreSignUp);
	}
	

	public void nascondiSchermata(String schermata) {
		view.mappaSchermate.get(schermata).setVisible(false);
	}
	
	public void mostraSchermata(String schermata) {
		view.mappaSchermate.get(schermata).setVisible(true);
	}
	
	public void avvioSocial() {
		view.mappaSchermate.get("Login").setVisible(true);
	}
}
