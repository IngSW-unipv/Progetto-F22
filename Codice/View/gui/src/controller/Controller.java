package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sistema.Sistema;
import packageframe.Frame;
import profilo.exception.*;

public class Controller {
	
	//private HashMap<String, JPanel> mappaSchermateController = new HashMap<String, JPanel>();
	private ActionListener gestoreLogin, gestoreSignUp, gestoreImpostazioni, gestoreRegistrati, gestoreProfilo,
						   gestoreChat, gestorePannelloNotifiche, gestoreHomeImpostazioni, gestoreHomeProfilo,
						   gestoreHomeChat, gestoreHomePannelloNotifiche, gestoreCreazionePost, gestoreHomeCreazionePost;
	
	Frame view;
	Sistema model;
	
	public Controller(Sistema s, Frame f) {
		this.view = f;
		this.model = s;	
	}
	
	public void initComponents() {
		
		//ActionListeners schermata login
		gestoreLogin = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Login");
				mostraSchermata("Home");
				
				try {
					model.login(view.emailInserita(), view.passwordInserita());
				} catch (ChangeDefaultPassword errore1) {
					errore1.printStackTrace();
				} catch (AccountDoesNotExist errore2) {
					errore2.printStackTrace();
				} catch (PswOmailErrati errore3) {
					errore3.printStackTrace();
				}
			}
		};
		view.getLoginButton().addActionListener(gestoreLogin);
			
		gestoreSignUp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Login");
				mostraSchermata("Signup");
			}
		};
		view.getSignUpButton().addActionListener(gestoreSignUp);	
		
		//ActionListeners schermata SignUp
		gestoreRegistrati = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String passEmailPerRegistrarsi = view.getEmailPerReigstrarsi();
				String passWordPerRegistrarsi = view.getPasswordPerReigstrarsi();
				
				try {
					System.out.println("credenziali inserite " + passEmailPerRegistrarsi + " " +  passWordPerRegistrarsi);
					model.signIn(passEmailPerRegistrarsi, passWordPerRegistrarsi);
				} catch (AccountGiaEsistente e1) {
					e1.printStackTrace();
				}
				nascondiSchermata("Signup");
				mostraSchermata("Home");
			}
		};
		view.getRegistratiButton().addActionListener(gestoreRegistrati);	
		
		//ActionListeners schermata Home
		gestoreImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				mostraSchermata("Impostazioni");
			}
		};
		view.getImpostazioniButton().addActionListener(gestoreImpostazioni);
		
		
		gestoreProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				mostraSchermata("Profilo");
			}
		};
		view.getProfiloButton().addActionListener(gestoreProfilo);
		
		
		gestoreChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				mostraSchermata("Chat");
			}
		};
		view.getChatButton().addActionListener(gestoreChat);
		
		
		gestorePannelloNotifiche = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				mostraSchermata("PannelloNotifiche");
			}
		}; 
		view.getNotificheButton().addActionListener(gestorePannelloNotifiche);
	
		
		//ActionListeners schermata Impostazioni
		gestoreHomeImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Impostazioni");
				mostraSchermata("Home");
			}
		};
		view.getHomeImpostazioniButton().addActionListener(gestoreHomeImpostazioni);
		
		
		//ActionListeners schermata Profilo
		gestoreHomeProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Profilo");
				mostraSchermata("Home");
			}
		};
		view.getHomeProfiloButton().addActionListener(gestoreHomeProfilo);
		
		
		//ActionListeners schermata Chat
		gestoreHomeChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Chat");
				mostraSchermata("Home");
			}
		};
		view.getHomeChatButton().addActionListener(gestoreHomeChat);
		
		
		//ActionListeners schermata Notifiche
		gestoreHomePannelloNotifiche = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("PannelloNotifiche");
				mostraSchermata("Home");
			}
		};
		view.getHomePannelloNotificheButton().addActionListener(gestoreHomePannelloNotifiche);
	
	
		//ActionListeners schermata CreazionePost
		gestoreCreazionePost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("Home");
				mostraSchermata("CreazionePost");
			}
		};
		view.getCreazionePostButton().addActionListener(gestoreCreazionePost);
		
		gestoreHomeCreazionePost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				nascondiSchermata("CreazionePost");
				mostraSchermata("Home");
			}
		};
		view.getHomeCreazionePostButton().addActionListener(gestoreHomeCreazionePost);
	}

	public void nascondiSchermata(String schermata) {
		view.mappaSchermate.get(schermata).setVisible(false);
	}
	
	public void mostraSchermata(String schermata) {
		view.mostraSchermata(schermata);
	}
	
	public void avvioSocial() {
		view.getMappaSchermate().get("Login").setVisible(true);
	}
}
