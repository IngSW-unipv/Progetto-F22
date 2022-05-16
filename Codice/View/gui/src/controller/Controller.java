package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sistema.Sistema;
import packageframe.Frame;
import profilo.exception.*;

public class Controller {
	
	private ActionListener gestoreLogin, gestoreSignUp, gestoreImpostazioni, gestoreRegistrati, gestoreProfilo,
						   gestoreChat, gestorePannelloNotifiche, gestoreHomeImpostazioni, gestoreHomeProfilo,
						   gestoreHomeChat, gestoreHomePannelloNotifiche, gestoreCreazionePost, gestoreHomeCreazionePost;
	
	Frame view;
	Sistema model;
	private String schermataAttuale = "Login";
	
	public Controller(Sistema s, Frame f) {
		view = f;
		model = s;	
		initComponents();
	}
	
	public void initComponents() {
		
		//ActionListeners schermata login
		gestoreLogin = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success;
				success = login();
				if (success == true) {
					mostraSchermata("Home");
				}
			}
		};
		view.getLoginButton().addActionListener(gestoreLogin);
			
		gestoreSignUp = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Signup");
			}
		};
		view.getSignUpButton().addActionListener(gestoreSignUp);	
		
		//ActionListeners schermata SignUp
		gestoreRegistrati = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean success = false;
	
					success = signUp();
				if (success == true) {
					mostraSchermata("Home");
				}
			}
		};
		view.getRegistratiButton().addActionListener(gestoreRegistrati);	
		
		//ActionListeners schermata Home
		gestoreImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Impostazioni");
			}
		};
		view.getImpostazioniButton().addActionListener(gestoreImpostazioni);
		
		
		gestoreProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Profilo");
			}
		};
		view.getProfiloButton().addActionListener(gestoreProfilo);
		
		
		gestoreChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Chat");
			}
		};
		view.getChatButton().addActionListener(gestoreChat);
		
		
		gestorePannelloNotifiche = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("PannelloNotifiche");
			}
		}; 
		view.getNotificheButton().addActionListener(gestorePannelloNotifiche);
	
		
		//ActionListeners schermata Impostazioni
		gestoreHomeImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Home");
			}
		};
		view.getHomeImpostazioniButton().addActionListener(gestoreHomeImpostazioni);
		
		
		//ActionListeners schermata Profilo
		gestoreHomeProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Home");
			}
		};
		view.getHomeProfiloButton().addActionListener(gestoreHomeProfilo);
		
		
		//ActionListeners schermata Chat
		gestoreHomeChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Home");
			}
		};
		view.getHomeChatButton().addActionListener(gestoreHomeChat);
		
		
		//ActionListeners schermata Notifiche
		gestoreHomePannelloNotifiche = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Home");
			}
		};
		view.getHomePannelloNotificheButton().addActionListener(gestoreHomePannelloNotifiche);
	
	
		//ActionListeners schermata CreazionePost
		gestoreCreazionePost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("CreazionePost");
			}
		};
		view.getCreazionePostButton().addActionListener(gestoreCreazionePost);
		
		gestoreHomeCreazionePost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Home");
			}
		};
		view.getHomeCreazionePostButton().addActionListener(gestoreHomeCreazionePost);
	}
	
	public boolean signUp() {
		String passEmailPerRegistrarsi = view.getEmailPerReigstrarsi();
		String nickNamePerRegistrarsi = view.getNickNamePerReigstrarsi();
		String passWordPerRegistrarsi = view.getPasswordPerReigstrarsi();
		
		try {
			model.signIn(passEmailPerRegistrarsi,nickNamePerRegistrarsi, passWordPerRegistrarsi);
		} catch (AccountGiaEsistente e1) {
			e1.printStackTrace();
			return false;
		} catch (ChangeDefaultPassword e2) {
			e2.printStackTrace();
			return false;
		} catch (AccountDoesNotExist e3) {
			e3.printStackTrace();
			return false;
		}
		return true;
	}
	
	public boolean login() {		
		try {
			model.login(view.emailInserita(), view.passwordInserita());
		} catch (ChangeDefaultPassword errore1) {
			errore1.printStackTrace();
			view.getEtichettaDiSegnalazioneLoginFallito().setText(errore1.toString());
			view.getEtichettaDiSegnalazioneLoginFallito().setVisible(true);
		} catch (AccountDoesNotExist errore2) {
			errore2.printStackTrace();
			view.getEtichettaDiSegnalazioneLoginFallito().setText(errore2.toString());
			view.getEtichettaDiSegnalazioneLoginFallito().setVisible(true);
			return false;
		} catch (PswOmailErrati errore3) {
			view.getEtichettaDiSegnalazioneLoginFallito().setText(errore3.toString());
			view.getEtichettaDiSegnalazioneLoginFallito().setVisible(true);
			errore3.printStackTrace();
			return false;
		}	
		return true;
	}
	
	public void nascondiSchermata(String schermata) {
		view.mappaSchermate.get(schermata).setVisible(false);
	}
	
	public void mostraSchermata(String schermata) {
		nascondiSchermata(getSchermataAttuale());
		view.mostraSchermata(schermata);
		setSchermataAttuale(schermata);
	}

	public String getSchermataAttuale() {
		return schermataAttuale;
	}

	public void setSchermataAttuale(String schermataAttuale) {
		this.schermataAttuale = schermataAttuale;
	}

}