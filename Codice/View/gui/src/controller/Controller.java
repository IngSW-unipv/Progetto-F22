package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Sistema.Sistema;
import packageframe.Frame;
import profilo.exception.*;

public class Controller {
	
	private ActionListener gestoreLogin, gestoreSignUp, gestoreImpostazioni, gestoreRegistrati, gestoreProfilo,
						   gestoreChat, gestorePannelloNotifiche, gestoreHomeImpostazioni, gestoreHomeProfilo,
						   gestoreHomeChat, gestoreHomePannelloNotifiche, gestoreCreazionePost, gestoreHomeCreazionePost,
						   gestoreLogOut,gestorePubblicaPost, gestoreModificaProfilo, gestoreVisibilitaPost, gestoreEliminaAccount,
						   gestoreCerca, gestoreHomeCerca;
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
				/*boolean success;
				success = login();
				if (success == true) {
					mostraSchermata("Home");
				}*/
				mostraSchermata("Home");
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
				
				if (signUp()) {
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
		
		gestoreCerca = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(verificaTestoRicerca()) {
					oggettoDaCercare();
					mostraSchermata("Ricerca");
					
					
					
					
					
					
				} else {
					view.setTestoRicerca("Inserire un username da cercare");
				}				
			}
		};
		view.getCercaButton().addActionListener(gestoreCerca);
	
		
		//ActionListeners schermata Impostazioni
		gestoreLogOut = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//model.logout(model.getProfiloAttivo());
				view.getContainerCenterFrame().setVisible(false);
				mostraSchermata("Login");
			}
		};
		view.getLogOutButton().addActionListener(gestoreLogOut);
		
		gestoreHomeImpostazioni = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getContainerCenterFrame().setVisible(false);
				mostraSchermata("Home");
			}
		};
		view.getHomeImpostazioniButton().addActionListener(gestoreHomeImpostazioni);
		
		
		gestoreModificaProfilo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getContainerCenterFrame().setVisible(true);
				refresh();
			}
		};
		view.getModificaProfiloButton().addActionListener(gestoreModificaProfilo);
		
		gestoreVisibilitaPost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getContainerCenterFrame().setVisible(false);
			}
		};
		view.getVisibilitaPostButton().addActionListener(gestoreVisibilitaPost);
		
		gestoreEliminaAccount = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				view.getContainerCenterFrame().setVisible(false);
			}
		};
		view.getEliminaAccountButton().addActionListener(gestoreEliminaAccount);
		
		
		
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
		
		gestorePubblicaPost = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pubblicaPost();
			}
				/*boolean success = false
						if(success = true) {
				mostraSchermata("Home");
			}*/
		};
		view.getPubblicaPostButton().addActionListener(gestorePubblicaPost);
		
		//ActionListeners schermata Ricerca
		gestoreHomeCerca = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Home");
			}
		};
		view.getHomeRicercaButton().addActionListener(gestoreHomeCerca);
		
		
		
	}
	
	public void refresh() {
		view.invalidate();
		view.validate();
		view.repaint();
	}
		
	public boolean signUp() {
		String passEmailPerRegistrarsi = view.getEmailPerReigstrarsi();
		String nickNamePerRegistrarsi = view.getNickNamePerReigstrarsi();
		String passWordPerRegistrarsi = view.getPasswordPerReigstrarsi();
		
		try {
			model.signIn(passEmailPerRegistrarsi,nickNamePerRegistrarsi, passWordPerRegistrarsi);
		} catch (AccountGiaEsistente e1) {
			e1.toString();
			return false;
		} catch (ChangeDefaultPassword e2) {
			e2.toString();
			return false;
		} catch (AccountDoesNotExist e3) {
			e3.toString();
			return false;
		}
		return true;
	}
	
	public boolean login() {		
		try {
			model.login(view.emailInserita(), view.passwordInserita());
		} catch (ChangeDefaultPassword errore1) {
			//mostraFallimentoLogin(errore1.toString());
		} catch (AccountDoesNotExist errore2) {
			mostraFallimentoLogin(errore2.toString());
			return false;
		} catch (PswOmailErrati errore3) {
			mostraFallimentoLogin(errore3.toString());
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
	
	public void mostraFallimentoLogin(String codiceFallimento) {
	view.getEtichettaDiSegnalazioneLoginFallito().setText(codiceFallimento);
	view.getEtichettaDiSegnalazioneLoginFallito().setVisible(true);
	}
	
	public void pubblicaPost() {
		String percorsoFilePost = view.ottieniPercorsoFile();
		String commentoPost = view.ottieniCommento();
		System.out.println(percorsoFilePost);
		model.pubblicaPost(commentoPost, null, null, commentoPost, false, false, model.getProfiloAttivo().getIdProfilo(), percorsoFilePost, false);
	}
	
	public boolean verificaTestoRicerca() {
		if(view.getTestoRicerca().equals("") || view.getTestoRicerca().equals("Inserire un username da cercare")) {
			return false;
		}
		return true;
	}

	public void oggettoDaCercare() {
		
	}
	
}