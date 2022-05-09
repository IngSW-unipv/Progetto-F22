package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JComponent;

import Sistema.Sistema;
import packageframe.Frame;

public class Controller {
	
	private HashMap<String, JComponent> listaSchermate = new HashMap<String, JComponent>();
	private ActionListener gestoreLogin, gestoreSignUp;
	
	Frame view;
	Sistema model;
	
	public Controller(Sistema s, Frame f) {
		
		view = f;
		model = s;
		listaSchermate = view.avvioSchermate();
		listaSchermate.put("Login",view.getLogIn());
		initComponents();
		
	}
	
	public void initComponents() {
		////ACTIONLISTENER PULSANTI PANNELLO LOGIN
		gestoreLogin = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondi("Login");
				
			}
		};
		
		view.getLoginButton().addActionListener(gestoreLogin);
		
		gestoreSignUp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		};
		view.getSignUpButton().addActionListener(gestoreSignUp);
	}
	
	public void actionPerformed(ActionEvent ae) {

			}
	public void nascondi(String schermata) {
		listaSchermate.get(schermata).setVisible(false);
	}
}
