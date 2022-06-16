package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Sistema.Sistema;
import chat.chatDiGruppo.gruppo.Gruppo;
import packageframe.Frame;
import panelspackage.panels.PostVisualizzato;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
import post.sondaggio.SondaggioDoppiaVotazione;
import post.sondaggio.SondaggioSceltaMultipla;
import post.testo.Testo;
import profilo.Profilo;
import profilo.exception.*;

public class Controller {
	
    private ActionListener gestoreLogin, gestoreSignUp, gestoreImpostazioni, gestoreRegistrati, gestoreProfilo,
                           gestoreChat, gestoreHomeImpostazioni, gestoreHomeProfilo,
                           gestoreHomeChat, gestoreCreazionePostFoto, gestoreHomeCreazionePost,
                           gestoreLogOut,gestorePubblicaPost, gestoreModificaProfilo, gestoreNascondi,
                           gestoreCerca, gestoreHomeCerca, gestoreFotoProfilo, gestoreIndietroSignup,gestoreHomePostVisualizzato,
                           gestoreAggiungiCommento, gestoreImpostaFotoProfilo,  gestoreAggiungiLikePost, gestoreAggiungiDislikePost,
                           gestoreAggiornaChat, gestorePrimaChatGruppo, gestoreSecondaChatGruppo, gestoreTerzaChatGruppo, gestoreQuartaChatGruppo, 
                           gestoreQuintaChatGruppo, gestoreSestaChatGruppo, gestoreSettimaChatGruppo, gestoreOttavaChatGruppo, gestoreNonaChatGruppo, 
                           gestoreDecimaChatGruppo, gestoreNextCommento, gestorePrevCommento, gestorePubblicaSoloTesto,gestoreProfiloCercato,
                           gestorePulsanteSegui, gestoreApriChat,gestoreInvioMessaggio,gestoreNextMessaggioButton,gestorePrevMessaggioButton,gestorePubblicaSondaggioDoppiaVotazione, gestorePubblicaSondaggioSceltaMultipla,
                           gestorePost1, gestorePost2, gestorePost3, gestoreSondaggio1, gestoreSondaggio2, gestoreSondaggio3,
                           gestoreChatFrameHome, gestoreCreaUnaChatDiGruppoHome, gestoreCreaChatDiGruppo, gestoreHomeChatDiGruppo, gestorePubblicaStory,
                           gestoreSalvaLeModifiche, gestoreNextFoto, gestorePrevFoto, gestoreNextTesto, gestorePrevTesto, gestoreNextSondaggio, gestorePrevSondaggio,
                           gestorePulsantePrimaScelta, gestorePulsanteSecondaScelta, gestorePulsanteTerzaScelta, gestorePulsanteQuartaScelta, gestorePostPrecedente, gestorePostSuccessivo,
                           gestorePulsantePrimoTesto,gestorePulsanteSecondoTesto,gestorePulsanteTerzoTesto, gestorePulsanteFotoHome, gestoreHomeGruppoFrame,
                           gestoreStorySuccessiva, gestoreStoryPrecedente, gestoreSondaggioDoppiaScelta1,gestoreSondaggioDoppiaScelta2, gestoreSondaggioDoppiaScelta3, 
                           gestoreRimuoviAccount, gestoreProssimoMessaggio, gestoreMessaggioPrecedente, gestoreCercaGruppo, gestorePartecipa, gestoreEsciGruppo,
                           gestoreRimuoviUtente, gestoreAggiungiUtente, gestoreModificaDescrizioneChat, gestoreInviaMessaggioGruppo, 
                           gestorePrimaStoria, gestoreSecondaStoria, gestoreTerzaStoria, gestoreQuartaStoria, gestoreQuintaStoria, gestoreNextMsgGruppo, gestorePrevMsgGruppo,
                           gestoreNextSondaggioDoppiaScelta, gestorePrevSondaggioDoppiaScelta;
 
    Frame view;
    
    Sistema model;
    
    private String schermataAttuale = "Login";
    private String gruppoAttuale = "";
    private int postAttuale = -1,basePostAttuale = 0;
    private String profiloVisualizzato;
    private ArrayList<String> commentiConProfiliIinvianti = new ArrayList<String>();
    private ArrayList<String> messaggiInviati = new ArrayList<String>();
    private ArrayList<String> messaggiInviatiGruppoConInviante = new ArrayList<String>();

    private ArrayList<String> postSchermataHome = new ArrayList<String>();
    private ArrayList<String> storySchermataHome = new ArrayList<String>();
    
    private ArrayList<String> postDelProfilo = new ArrayList<String>();
    private ArrayList<String> percorsiPostFoto = new ArrayList<String>();
    private ArrayList<String> percorsiPostTesto = new ArrayList<String>();
    private ArrayList<String> percorsiPostSondaggioSceltaMultipla = new ArrayList<String>();
    private ArrayList<String> percorsiPostSondaggioDoppiaScelta = new ArrayList<String>();

    private ArrayList<String> listaGruppi = new ArrayList<String>();
    private TipoPost tipoPostAttuale;
    ArrayList<String> messaggi = new ArrayList<String>();
    /**
     * dichiaro il costruttore del controller passandogli Frame e modello
     * @param s
     * @param f
     */
	public Controller(Sistema s, Frame f) {
        view = f;
        model = s;  
    }
    /**
     * metodo per l'inizializzazione dei componenti
     */
    public void initComponents() {
        
        actionListenersLogin();
        actionListenersSignUp();
        actionListenersHome();
        actionListenersImpostazioni();
        actionListenersProfilo();
        actionListenersCreazionePost();
        actionListenersRicerca();
        actionListenersChat();
        actionListenersPostVisualizzato();
        actionListenersAreaChatFrame();
        actionListenerCreaChatDiGruppo();
        actionListenerChatDiGruppoFrame();
    }
    /**
     * metodo che implementa gli ActionListener alla schermata Login
     */
    public void actionListenersLogin() {
    	/**
    	 * ActionListener che permette di effettuare il login tramite pulsante login
    	 */
        gestoreLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	tipoPostAttuale = TipoPost.FOTO;
                if (login()) 
    	            resetContatori();
    	            resettaGui();
                	postSchermataHome = model.getProfiloAttivo().caricaPostProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
                	if(storySchermataHome.size() == 0) {
                  		System.out.println("non ci sono storie");
                	} else {
                    	storySchermataHome = model.getProfiloAttivo().caricaStorieProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
                		view.setPercorsiStorieLogin(storySchermataHome);
                	}
                	if(postSchermataHome.size() == 0) {
                		view.setPercorsoPost("");
                		view.aggiornaPostHome();

                		mostraSchermata("Home");
                	} else {
                		view.setPercorsoPost(ottieniPost(0));
                		view.aggiornaPostHome();
                    	mostraSchermata("Home");
                }
            }
        };
        view.getLoginButton().addActionListener(gestoreLogin);
        /**
         * actionListener che permette di andare dall schermata del login alla schermata del signup 
         */
        gestoreSignUp = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Signup");
            }
        };
        view.getSignUpButton().addActionListener(gestoreSignUp);
    }
    /**
     * metodo che permette di eseguire gli ActionListener alla schermata SingUp
     */
    public void actionListenersSignUp() {
    	/**
    	 * ActionListener che permette di tornare alla schermata Home dalla schermata Singup
    	 */
        gestoreRegistrati = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (signUp()) {
                    mostraSchermata("Home");
                }
            }
        };
        view.getRegistratiButton().addActionListener(gestoreRegistrati);
        /**
         * ActionListener che permette di tornare alla schermata Login dalla schermata Singup
         */
        gestoreIndietroSignup = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mostraSchermata("Login");
            }
        };
         view.getIndietroButton().addActionListener(gestoreIndietroSignup);
    }
    
    /**
     * metodo che implementa gli ActionListener nella schermata Home
     */
    public void actionListenersHome() {
    	/**
    	 * ActionListener che permette di poter visualizzare una foto in centro nella schermata della Home
    	 */
    	gestorePulsanteFotoHome = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {if (postSchermataHome.size() > 0) {     		
            		model.getProfiloAttivo().setFotoPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(postSchermataHome.get(0 + view.getContatorePost()))));
            		visualizzaPostFoto(model.getProfiloAttivo().getFotoPerController());
                	mostraSchermata("Postvisualizzato");
                	refresh();
            	}
            	else { model.getProfiloAttivo().setFotoPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(postSchermataHome.get(0 + view.getContatorePost()))));
            	mostraSchermata("Postvisualizzato");
            	}
            	} catch (PostNonPresente| PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	visualizzaPostFoto(model.getProfiloAttivo().getFotoPerController());
            	view.getNascondi().setVisible(false);
            	mostraSchermata("Postvisualizzato");
            	refresh();
            
            }
        };
        view.getPostPrincipale().addActionListener(gestorePulsanteFotoHome);
        
        /**
         * ActionListener che permette di scorrere in avanti tra i vari post nella Home
         */
    	gestorePostSuccessivo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(view.getContatorePost() <= postSchermataHome.size() - 2) {
	                view.setContatorePost(view.getContatorePost() + 1);
	            	postSchermataHome = model.getProfiloAttivo().caricaPostProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
	            	view.rimuoviPostHome();
	            	view.setPercorsoPost(ottieniPost(view.getContatorePost()));
	            	view.aggiornaPostHome();
	            	refresh();
            	}
            }
        };
        view.getButtonNextPost().addActionListener(gestorePostSuccessivo);
        
        /**
         * ActionListener che permette di scorrere indietro tra i vari post nella Home
         */
        gestorePostPrecedente = new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
            	if(view.getContatorePost() >= 1) {
	            	view.setContatorePost(view.getContatorePost() - 1);
	            	postSchermataHome = model.getProfiloAttivo().caricaPostProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
	               	view.rimuoviPostHome();
	            	view.setPercorsoPost(ottieniPost(view.getContatorePost()));
	            	view.aggiornaPostHome();
	            	refresh();
            	}
            }
        };
        view.getButtonPrevPost().addActionListener(gestorePostPrecedente); 
        
    	/**
    	 * ActionListener che permette di poter scorrere in avanti tra le varie stories
    	 */
        gestoreStorySuccessiva = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(view.getIndiceStorie() < storySchermataHome.size()/2 ) {
        			view.setIndiceStorie(view.getIndiceStorie() + 2);
        		}
        	 	storySchermataHome = model.getProfiloAttivo().caricaStorieProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
        	 	if(storySchermataHome.size() != 0) {
        	 		view.setPercorsiStorieLogin(storySchermataHome);
        	 	}
        	}
        	
        };
        view.getButtonNextStory().addActionListener(gestoreStorySuccessiva);
        
        /**
    	 * ActionListener che permette di poter scorrere indietro tra le varie stories
    	 */
        gestoreStoryPrecedente = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(view.getIndiceStorie() > 0) {
        			view.setIndiceStorie(view.getIndiceStorie() - 2);
        		}
        	 	storySchermataHome = model.getProfiloAttivo().caricaStorieProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
        	 	if(storySchermataHome.size() != 0) {
        	 		view.setPercorsiStorieLogin(storySchermataHome);
        	 	}
        	}
        };
        view.getButtonPrevStory().addActionListener(gestoreStoryPrecedente);
        
        /**
         * ActionListener che permette di poter visualizzare la prima storia nella Home
         */
        gestorePrimaStoria = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	try {
            		if(storySchermataHome.size() >0) {
            		model.getProfiloAttivo().setStoriaPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(storySchermataHome.get(0 + view.getIndiceStorie()))));
            		}
				} catch (PostNonPresente| PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	visualizzaPostFoto(model.getProfiloAttivo().getStoriaPerController());
            	mostraSchermata("Postvisualizzato");
            	view.getNascondi().setVisible(false);
            	refresh();
            
        	}
        };
        view.getPrimaStoriaButton().addActionListener(gestorePrimaStoria);
        
        /**
         * ActionListener che permette di poter visualizzare la seconda storia nella Home
         */
        gestoreSecondaStoria = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	try {
            		model.getProfiloAttivo().setStoriaPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(storySchermataHome.get(2 + view.getIndiceStorie()))));
				} catch (PostNonPresente| PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	visualizzaPostFoto(model.getProfiloAttivo().getStoriaPerController());
            	mostraSchermata("Postvisualizzato");
            	view.getNascondi().setVisible(false);
            	refresh();
            
        	}
        };
        view.getSecondaStoriaButton().addActionListener(gestoreSecondaStoria);
        
        /**
         * ActionListener che permette di poter visualizzare la terza storia nella Home
         */
        gestoreTerzaStoria = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	//Foto f = new Foto(null);
            	try {
            		//f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(storySchermataHome.get(4 + view.getIndiceStorie())));
            		model.getProfiloAttivo().setStoriaPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(storySchermataHome.get(4 + view.getIndiceStorie()))));
				} catch (PostNonPresente| PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	visualizzaPostFoto(model.getProfiloAttivo().getStoriaPerController());
            	mostraSchermata("Postvisualizzato");
            	view.getNascondi().setVisible(false);
            	refresh();
            
        	}
        };
        view.getTerzaStoriaButton().addActionListener(gestoreTerzaStoria);
        
        /**
         * ActionListener che permette di poter visualizzare la quarta storia nella Home
         */
        gestoreQuartaStoria = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	try {
            		model.getProfiloAttivo().setStoriaPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(storySchermataHome.get(6 + view.getIndiceStorie()))));
				} catch (PostNonPresente| PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	visualizzaPostFoto(model.getProfiloAttivo().getStoriaPerController());
            	mostraSchermata("Postvisualizzato");
            	view.getNascondi().setVisible(false);
            	refresh();
            
        	}
        };
        view.getQuartaStoriaButton().addActionListener(gestoreQuartaStoria);
        
        /**
         * ActionListener che permette di poter visualizzare la quinta storia nella Home
         */
        gestoreQuintaStoria = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	try {
            		model.getProfiloAttivo().setStoriaPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(storySchermataHome.get(8 + view.getIndiceStorie()))));
				} catch (PostNonPresente| PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	visualizzaPostFoto(model.getProfiloAttivo().getStoriaPerController());
            	mostraSchermata("Postvisualizzato");
            	view.getNascondi().setVisible(false);
            	refresh();
            
        	}
        };
        view.getQuintaStoriaButton().addActionListener(gestoreQuintaStoria);
        
        /**
         * ActionListener che permette di poter andare nella schermata delle impostazioni
         */
        gestoreImpostazioni = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		mostraSchermata("Impostazioni");
        	}
        };
        view.getImpostazioniButton().addActionListener(gestoreImpostazioni);
            
        /**
         * ActionListener che permette di creare una chat di gruppo dalla home
         */
        gestoreCreaUnaChatDiGruppoHome = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("CreazioneChatDiGruppo");
            }
        };
        view.getCreaUnaChatDiGruppo().addActionListener(gestoreCreaUnaChatDiGruppoHome);
        /**
         * ActionListener che permette di visualizzare la propria pagina profilo        
         */
        gestoreProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	profiloVisualizzato = model.getProfiloAttivo().getIdProfilo();
            	aggiornaSchermataProfiloAttivo();
                refresh();
                view.getPulsanteSegui().setVisible(false);
                view.getApriChat().setVisible(false);
                model.setProfiloCercato(model.getProfiloAttivo());
                mostraSchermata("Profilo");
            }
        };
        view.getProfiloButton().addActionListener(gestoreProfilo);
                
        /**
         * ActionListener che permette di visualizzare la schermata delle chat del profilo      
         */        
        gestoreChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	listaGruppi = model.getProfiloAttivo().caricaGruppiProfilo(model.getProfiloAttivo().getIdProfilo());
                view.settaSchermataChat(listaGruppi);
            	mostraSchermata("Chat");
            }
        };
        view.getChatButton().addActionListener(gestoreChat);
                
        /**
         * ActionListener che permette di poter cercare un profilo tramite barra di ricerca
         */
        gestoreCerca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(verificaTestoRicerca()) {
                    ricerca();
                    mostraSchermata("Ricerca");
                    
                } else 
                    view.setTestoRicerca("Inserire un username da cercare");        
            }
        };
        view.getCercaButton().addActionListener(gestoreCerca);
    }
    
    /**
     * metodo che implementa i vari ActionListener della schermata impostazioni
     */
    public void actionListenersImpostazioni() {
    	/**
    	 * ActionListener che permette di eseguire il logout e tornare alla schermata del login
    	 */
    	gestoreLogOut = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            try {
	                model.logout(model.getProfiloAttivo().getIdProfilo());
	            }catch (AccountDoesNotExist e1) {
	            	e1.printStackTrace();
	            }
	            view.getContainerCenterFrame().setVisible(false);
		        view.getInserimentoMail().setText("");
		        view.getInserimentoPassword().setText("");

	            mostraSchermata("Login");
	        }
    	};
	    view.getLogOutButton().addActionListener(gestoreLogOut);
	    
	    /**
	     * ActionListener che permette di tornare alla schermata Home
	     */
	    gestoreHomeImpostazioni = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            view.getContainerCenterFrame().setVisible(false);
	            mostraSchermata("Home");
	        }
	    };
	    view.getHomeImpostazioniButton().addActionListener(gestoreHomeImpostazioni);
	    
	    /**
	     * ActionListener che permette di poter modificare la descrizione del profilo
	     */
	    gestoreModificaProfilo = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            view.getContainerCenterFrame().setVisible(true);
	            refresh();
	        }
	    };
	    view.getModificaProfiloButton().addActionListener(gestoreModificaProfilo);
	    
        /**
         * ActionListener che permette di poter salvare le modifiche alla descrizione del profilo se eseguita
         */
	    gestoreSalvaLeModifiche = new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		aggiungiDescrizione();
	    	}
	    };
	    view.getSalvaModificheButton().addActionListener(gestoreSalvaLeModifiche);
	    
	    /**
	     * ActionListener che permette di eliminare il proprio profilo
	     */
	    gestoreRimuoviAccount = new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		rimuoviProfilo();
	    		mostraSchermata("Login");
	    	}
	    };
	    view.getEliminaAccountButton().addActionListener(gestoreRimuoviAccount);
    }
    
    /**
     * metodo che implementa gli ActionListener del profilo
     */
    public void actionListenersProfilo() {
    	/**
    	 * ActionListener che permette di tornare alla Home
    	 */
        gestoreHomeProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resetContatori();
                mostraSchermata("Home");
                refresh();
            }
        };
        view.getHomeProfiloButton().addActionListener(gestoreHomeProfilo);
        
        /**
         * ActionListener che permette di aprire una chat privata con il profilo cercato
         */
        gestoreApriChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	model.setProfiloConCuiSiStaChattando(model.getProfiloCercato());
            	messaggi = model.getProfiloAttivo().cercaMessaggiChatPrivata(model.getProfiloAttivo().getIdProfilo(), model.getProfiloConCuiSiStaChattando().getIdProfilo());
            	view.aggiornaMessaggi(messaggi, model.getProfiloAttivo().getNickname());
            	refresh();
            	mostraSchermata("AreaChatFrame");
            }
        };
        view.getApriChat().addActionListener(gestoreApriChat);

        /**
         * ActionListener che permette di seguire il profilo cercato
         */
        gestorePulsanteSegui = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
					model.getProfiloAttivo().segui(model.getProfiloCercato());
				} catch (AccountDoesNotExist e1) {
					e1.printStackTrace();
				} catch (AzioneNonConsentita e1) {
					e1.printStackTrace();
				}
            }
        };
        view.getPulsanteSegui().addActionListener(gestorePulsanteSegui);
        
        /**
         * ActionListener che permette di visualizzare la foto del profilo
         */
        gestoreFotoProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
	            if(model.getProfiloAttivo().getIdProfilo().equals(profiloVisualizzato)) {
	                try {
	                	model.getProfiloAttivo().setFotoProfiloPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloAttivo().getFotoProfilo())));
					} catch (PostNonPresente| PostNonVisibile e1) {
						model.getProfiloAttivo().getFotoProfiloPerController().setPercorso("immagini/images.png");
					}
	                
	                visualizzaPostFoto(model.getProfiloAttivo().getFotoProfiloPerController());
	                mostraSchermata("Postvisualizzato");
	                refresh();           
	            } else {
	            	try {
	            		model.getProfiloAttivo().setFotoProfiloPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloCercato().getFotoProfilo())));
	            	} catch (PostNonPresente| PostNonVisibile e1) { 
						model.getProfiloAttivo().getFotoProfiloPerController().setPercorso("immagini/images.png");
	            	}
		            visualizzaPostFoto(model.getProfiloAttivo().getFotoProfiloPerController());
		            mostraSchermata("Postvisualizzato");
	            	view.getNascondi().setVisible(model.getProfiloCercato().getIdProfilo().equals(model.getProfiloAttivo().getIdProfilo()));
		            
		            refresh();         
		        }
	        }
        };
        view.getPulsanteFotoProfilo().addActionListener(gestoreFotoProfilo);
        
        /**
         * ActionListener che permette di visualizzare il primo testo visibile del profilo
         */
        gestorePulsantePrimoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	visualizzaPostTesto(0 + view.getContatoreTesto());
            }
        };
        view.getPulsantePrimoTesto().addActionListener(gestorePulsantePrimoTesto);
        
        /**
         * ActionListener che permette di visualizzare il secondo testo visibile del profilo
         */
        gestorePulsanteSecondoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	visualizzaPostTesto(2+ view.getContatoreTesto());
            }
        };
        view.getPulsanteSecondoTesto().addActionListener(gestorePulsanteSecondoTesto);
        
        /**
         * ActionListener che permette di visualizzare il terzo testo visibile del profilo
         */
        gestorePulsanteTerzoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	visualizzaPostTesto(4 + view.getContatoreTesto());
            }
        };
        view.getPulsanteTerzoTesto().addActionListener(gestorePulsanteTerzoTesto);     
        /**
         * ActionListener che permette di visualizzare la prima foto visibile del profilo
         */
        gestorePost1 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                visualizzaPostFoto(0 + view.getContatoreFoto());
        	}
        };
        view.getPost1().addActionListener(gestorePost1);
        
        /**
         * ActionListener che permette di visualizzare la seconda foto visibile del profilo
         */
        gestorePost2 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
               	visualizzaPostFoto(2 + view.getContatoreFoto());
        	}
        };
        view.getPost2().addActionListener(gestorePost2);
        
        /**
         * ActionListener che permette di visualizzare la terza foto visibile del profilo
         */
        gestorePost3 = new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
                    visualizzaPostFoto(4 + view.getContatoreFoto());
        	}
        };
        view.getPost3().addActionListener(gestorePost3);
        
        /**
         * ActionListener che permette di visualizzare il primo sondaggio a scelta multipla visibile del profilo
         */
        gestoreSondaggio1 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		visualizzaPostSondaggioSceltaMultipla(0);
        	}
        };
        view.getPulsantePrimoSondaggio().addActionListener(gestoreSondaggio1);
        
        /**
         * ActionListener che permette di visualizzare il secondo sondaggio a scelta multipla visibile del profilo
         */
        gestoreSondaggio2 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		visualizzaPostSondaggioSceltaMultipla(2);
        	}
        };
        view.getPulsanteSecondoSondaggio().addActionListener(gestoreSondaggio2);
        
        /**
         * ActionListener che permette di visualizzare il terzo sondaggio a scelta multipla visibile del profilo
         */
        gestoreSondaggio3 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		visualizzaPostSondaggioSceltaMultipla(4);
        	}
        };
        view.getPulsanteTerzoSondaggio().addActionListener(gestoreSondaggio3);
        
        /**
         * ActionListener che permette di visualizzare il primo sondaggio a doppia scelta visibile del profilo
         */
        gestoreSondaggioDoppiaScelta1 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		visualizzaPostSondaggioDoppiaScelta(0);
        	}
        };
        view.getPulsantePrimoSondaggioDoppia().addActionListener(gestoreSondaggioDoppiaScelta1);
        
        /**
         * ActionListener che permette di visualizzare il secondo sondaggio a doppia scelta visibile del profilo
         */
        gestoreSondaggioDoppiaScelta2 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		visualizzaPostSondaggioDoppiaScelta(2);
        	}
        };
        view.getPulsanteSecondoSondaggioDoppia().addActionListener(gestoreSondaggioDoppiaScelta2);
        
        /**
         * ActionListener che permette di visualizzare il terzo sondaggio a doppia scelta visibile del profilo
         */
        gestoreSondaggioDoppiaScelta3 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		visualizzaPostSondaggioDoppiaScelta(4);
        	}
        };
        view.getPulsanteTerzoSondaggioDoppia().addActionListener(gestoreSondaggioDoppiaScelta3);      
        
        /**
         * ActionListener che permette di scorrere in avanti tra le foto del profilo
         */
        gestoreNextFoto = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreFoto(view.getContatoreFoto() + 2);
        		view.setPostProfilo(postDelProfilo);
        	}
        };
        view.getNextFoto().addActionListener(gestoreNextFoto);
        
        /**
         * ActionListener che permette di scorrere indietro tra le foto del profilo
         */
        gestorePrevFoto = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreFoto(view.getContatoreFoto() - 2);
        		view.setPostProfilo(postDelProfilo);
        	}
        };
        view.getPrevFoto().addActionListener(gestorePrevFoto);
        
        /**
         * ActionListener che permette di scorrere in avanti tra i testi del profilo
         */
        gestoreNextTesto = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreTesto(view.getContatoreTesto() + 2);
        		view.setPostTestoProfilo(percorsiPostTesto);
        	}
        };
        view.getNextTesto().addActionListener(gestoreNextTesto);
        
        /**
         * ActionListener che permette di scorrere indietro tra i testi del profilo
         */
        gestorePrevTesto = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreTesto(view.getContatoreTesto() - 2);
        		view.setPostTestoProfilo(percorsiPostTesto);
        	}
        };
        view.getPrevTesto().addActionListener(gestorePrevTesto);
        
        /**
         * ActionListener che permette di scorrere in avanti tra i sondaggi a scelta multipla del profilo
         */
        gestoreNextSondaggio = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreSondaggio(view.getContatoreSondaggio() + 2);
        		view.setPostSondaggioProfilo(percorsiPostSondaggioSceltaMultipla);
        		view.setPostSondaggioDoppiaSceltaProfilo(percorsiPostSondaggioDoppiaScelta);
        	}
        };
        view.getNextSondaggio().addActionListener(gestoreNextSondaggio);
        
        /**
         * ActionListener che permette di scorrere indietro tra i sondaggi a scelta multipla del profilo
         */
        gestorePrevSondaggio = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreSondaggio(view.getContatoreSondaggio() - 2);
        		view.setPostSondaggioProfilo(percorsiPostSondaggioSceltaMultipla);
        		view.setPostSondaggioDoppiaSceltaProfilo(percorsiPostSondaggioDoppiaScelta);
        	}
        };
        view.getPrevSondaggio().addActionListener(gestorePrevSondaggio);
        
        /**
         * ActionListener che permette di scorrere in avanti tra i sondaggi a doppia scelta del profilo
         */
        gestoreNextSondaggioDoppiaScelta = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		
        		view.setContatoreSondaggioDoppiaScelta(view.getContatoreSondaggioDoppiaScelta() + 2);
        		System.out.println("contorller " + view.getContatoreSondaggioDoppiaScelta());
        		view.setPostSondaggioDoppiaSceltaProfilo(percorsiPostSondaggioDoppiaScelta);

        	}
        };
        view.getNextSondaggioDoppiaScelta().addActionListener(gestoreNextSondaggioDoppiaScelta);
        
        /**
         * ActionListener che permette di scorrere indietro tra i sondaggi a doppia scelta del profilo
         */
        gestorePrevSondaggioDoppiaScelta = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if (view.getContatoreSondaggioDoppiaScelta() > 0) {
        		view.setContatoreSondaggioDoppiaScelta(view.getContatoreSondaggioDoppiaScelta() - 2);
        		}
        		view.setPostSondaggioDoppiaSceltaProfilo(percorsiPostSondaggioDoppiaScelta);

        	}
        };
        view.getPrevSondaggioDoppiaScelta().addActionListener(gestorePrevSondaggioDoppiaScelta);
    }

    /**
     * metodo che implementa gli ActionListener per la schermata di creazione dei post
     */
    public void actionListenersCreazionePost() {
    	/**
    	 * ActionListener che permette di poter creare una foto
    	 */
        gestoreCreazionePostFoto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setPostAttuale(0);
            	view.getFileChooser().setVisible(true);   
            	view.getPrimaScelta().setVisible(false);
            	view.getSecondaScelta().setVisible(false);
            	view.getTerzaScelta().setVisible(false);
            	view.getQuartaScelta().setVisible(false);
            	view.getPubblicaStoryButton().setVisible(true);
                mostraSchermata("CreazionePost");
            }
        };
        view.getCreazionePostButton().addActionListener(gestoreCreazionePostFoto);
        /**
         * ActionListener che permette di tornare alla Home dalla schermata CreazionePost
         */
        gestoreHomeCreazionePost = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeCreazionePostButton().addActionListener(gestoreHomeCreazionePost);
        /**
         * ActionListener che permette di pubblicare un post
         */
        gestorePubblicaPost = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	pubblicaPost();
            }
        };
        view.getPubblicaPostButton().addActionListener(gestorePubblicaPost);
        
        /**
         * ActionListener che permette di pubblicare una story
         */
        gestorePubblicaStory = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	pubblicaStory();
            }
        };
        view.getPubblicaStoryButton().addActionListener(gestorePubblicaStory);
        
        /**
         * ActionListener che permette di creare un testo
         */
        gestorePubblicaSoloTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {   
            	setPostAttuale(1);
            	view.getFileChooser().setVisible(false);
            	view.getPrimaScelta().setVisible(false);
            	view.getSecondaScelta().setVisible(false);
            	view.getTerzaScelta().setVisible(false);
            	view.getQuartaScelta().setVisible(false);
            	view.getPubblicaStoryButton().setVisible(false);
            	mostraSchermata("CreazionePost");
            }
        };
        view.getPIdeaButton().addActionListener(gestorePubblicaSoloTesto);
        
        /**
         * ActionListener che permette di creare un sondaggio a doppia votazione
         */
        gestorePubblicaSondaggioDoppiaVotazione = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setPostAttuale(2);
            	view.getFileChooser().setVisible(false);
            	view.getTerzaScelta().setVisible(false);
            	view.getQuartaScelta().setVisible(false);
            	view.getPrimaScelta().setVisible(true);
            	view.getSecondaScelta().setVisible(true);
            	view.getPubblicaStoryButton().setVisible(false);
            	mostraSchermata("CreazionePost");
        	}
        };
        view.getPSondaggioDoppiaVotazioneButton().addActionListener(gestorePubblicaSondaggioDoppiaVotazione);
        
        /**
         * ActionListener che permette di creare un sondaggio a scelta multipla
         */
        gestorePubblicaSondaggioSceltaMultipla = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setPostAttuale(3);
            	view.getFileChooser().setVisible(false);
            	view.getTerzaScelta().setVisible(true);
            	view.getQuartaScelta().setVisible(true);
            	view.getPrimaScelta().setVisible(true);
            	view.getSecondaScelta().setVisible(true);
            	view.getPubblicaStoryButton().setVisible(false);
            	mostraSchermata("CreazionePost");
        	}
        };
        view.getPSondaggioSceltaMultiplaButton().addActionListener(gestorePubblicaSondaggioSceltaMultipla);

    }

    /**
     * metodo che implementa gli ActionListener per la ricerca
     */
    public void actionListenersRicerca(){
    	/**
    	 * ActionListener che permette di tornare alla Home dalla schermata di ricerca
    	 */
        gestoreHomeCerca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeRicercaButton().addActionListener(gestoreHomeCerca);
        
        /**
         * ActionListener che permette di poter cercare un profilo dalla barra di ricerca e di entrare nella sua pagina del profilo selezionato
         */
        gestoreProfiloCercato = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String descrizione = model.getProfiloCercato().getDescrizione();
                String nickName = model.getProfiloCercato().getNickname();
            	int numPost = model.getProfiloCercato().getNumPost();
                int numFollower = model.getProfiloCercato().getNumFollower();
                int numSeguiti = model.getProfiloCercato().getNumSeguiti();
                String idProfilo = model.getProfiloCercato().getIdProfilo();
                String percorsoFotoProfilo = null;
                postDelProfilo = model.getProfiloCercato().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.FOTO);
                percorsiPostTesto = model.getProfiloCercato().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.TESTO);
                percorsiPostSondaggioSceltaMultipla = model.getProfiloCercato().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.SONDAGGIOSCELTAMULTIPLA);
                percorsiPostSondaggioDoppiaScelta = model.getProfiloCercato().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.SONDAGGIODOPPIAVOTAZIONE);
            	profiloVisualizzato = model.getProfiloCercato().getIdProfilo();

                try {
                	percorsoFotoProfilo = (String)model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloCercato().getFotoProfilo())).getPercorso();
				} catch (PostNonVisibile e1) {
					percorsoFotoProfilo = "immagini/images.png";
				} catch (PostNonPresente e2) {
					 percorsoFotoProfilo = "immagini/images.png";
				}
                
                try {
					aggiornaSchermataProfilo(nickName, descrizione, numPost, numFollower, numSeguiti, percorsoFotoProfilo, idProfilo,  postDelProfilo, percorsiPostTesto, percorsiPostSondaggioSceltaMultipla, percorsiPostSondaggioDoppiaScelta);
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
                view.getPulsanteSegui().setVisible(true);
                view.getApriChat().setVisible(true);
            	mostraSchermata("Profilo");
            }
        };
        view.getPulsanteRicercaProfilo().addActionListener(gestoreProfiloCercato);
        
        /**
         * ActionListener che permette di poter cercare un gruppo dalla barra di ricerca e di entrare chat del suddetto gruppo
         */
        gestoreCercaGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		String nomeGruppo = view.getPulsanteRicercaGruppo().getText();
        		Gruppo g = model.getProfiloAttivo().cercaGruppo(new Gruppo(nomeGruppo));
        		settaSchermataGruppo(g, commentiConProfiliIinvianti);
        		setGruppo(g);
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getPulsanteRicercaGruppo().addActionListener(gestoreCercaGruppo);

    }
    
    /**
     * metodo che implementa gli ActionListener della schermata delle varie Chat del profilo
     */
    public void actionListenersChat() {
    	
    	/**
    	 * ActionListener che permette di tornare nella Home dalla schermata della chat
    	 */
        gestoreHomeChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeChatButton().addActionListener(gestoreHomeChat);
        
        /**
         * ActionListener che permette di scorrere in avanti tra i vari messaggi delle chat
         */
        gestoreProssimoMessaggio = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(view.getIndiceMessaggioCorrenteChat() < listaGruppi.size()-20) {
        			view.incrementaIndiceMessaggioChat();
        			listaGruppi = model.getProfiloAttivo().caricaGruppiProfilo(model.getProfiloAttivo().getIdProfilo());
        			view.settaSchermataChat(listaGruppi);
        		}
        	}
        };
        view.getProssimoMessaggioButton().addActionListener(gestoreProssimoMessaggio);
        
        /**
         * ActionListener che permette di scorrere indietro tra i vari messaggi delle chat
         */
        gestoreMessaggioPrecedente = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		if(view.getIndiceMessaggioCorrenteChat() > 0) {
        			view.decrementaIndiceMessaggioChat();
        			listaGruppi = model.getProfiloAttivo().caricaGruppiProfilo(model.getProfiloAttivo().getIdProfilo());
        			view.settaSchermataChat(listaGruppi);
        		}
        	}
        };
        view.getMessaggioPrecedenteButton().addActionListener(gestoreMessaggioPrecedente);

        /**
         * ActionListener che apre la prima chat di gruppo del profilo
         */
        gestorePrimaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(0))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getPrimaChatGruppoButton().addActionListener(gestorePrimaChatGruppo);
        
        /**
         * ActionListener che apre la seconda chat di gruppo del profilo
         */
        gestoreSecondaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(2))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getSecondaChatGruppoButton().addActionListener(gestoreSecondaChatGruppo);
        
        /**
         * ActionListener che apre la terza chat di gruppo del profilo
         */
        gestoreTerzaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(4))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getTerzaChatGruppoButton().addActionListener(gestoreTerzaChatGruppo);
        
        /**
         * ActionListener che apre la quarta chat di gruppo del profilo
         */
        gestoreQuartaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(6))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getQuartaChatGruppoButton().addActionListener(gestoreQuartaChatGruppo);
        
        /**
         * ActionListener che apre la quinta chat di gruppo del profilo
         */
        gestoreQuintaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(8))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getQuintaChatGruppoButton().addActionListener(gestoreQuintaChatGruppo);
        
        /**
         * ActionListener che apre la sesta chat di gruppo del profilo
         */
        gestoreSestaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(10))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getSestaChatDiGruppoButton().addActionListener(gestoreSestaChatGruppo);
        
        /**
         * ActionListener che apre la settima chat di gruppo del profilo
         */
        gestoreSettimaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(12))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getSettimaChatGruppoButton().addActionListener(gestoreSettimaChatGruppo);
        
        /**
         * ActionListener che apre la ottava chat di gruppo del profilo
         */
        gestoreOttavaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(14))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getOttavaChatGruppoButton().addActionListener(gestoreOttavaChatGruppo);
        
        /**
         * ActionListener che apre la nona chat di gruppo del profilo
         */
        gestoreNonaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(16))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getNonaChatGruppoButton().addActionListener(gestoreNonaChatGruppo);
        
        /**
         * ActionListener che apre la decima chat di gruppo del profilo
         */
        gestoreDecimaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		model.getProfiloAttivo().setGruppoPerController(model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(18))));
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		settaSchermataGruppo(model.getProfiloAttivo().getGruppoPerController(), messaggi);
        		setGruppo(model.getProfiloAttivo().getGruppoPerController());
        		gruppoAttuale = model.getProfiloAttivo().getGruppoPerController().getIdGruppo();
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getDecimaChatGruppoButton().addActionListener(gestoreDecimaChatGruppo);
    }
    
    /**
     * metodo che implementa gli ActionListener della schermata di visualizzazione dei post
     */
    public void actionListenersPostVisualizzato() {
    	/**
    	 * ActionListener che permette rendere un post non piu visualizzabile da altri utenti
    	 */
    	gestoreNascondi = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	model.getProfiloAttivo().modificaVisibilita(view.getIdPostVisualizzato(), tipoPostAttuale ,false);
            }
        };
        view.getNascondi().addActionListener(gestoreNascondi);

    	/**
    	 * ActionListener che permette di tornare alla home della schermata di visualizzazione dei post
    	 */
        gestoreHomePostVisualizzato = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.ripristinaIndiceCommento();
            	resetContatori();
                mostraSchermata("Home");
            }
        };
        view.getHomePostVisualizzatoButton().addActionListener(gestoreHomePostVisualizzato);
    
        /**
         * ActionListener che permette di cambiare la foto del profilo
         */
        gestoreImpostaFotoProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String iDNuovaFotoProfilo = ((PostVisualizzato)view.mappaSchermate.get("Postvisualizzato")).getIdPost();
                model.getProfiloAttivo().cambiaImmagineProfilo(iDNuovaFotoProfilo);
                model.getProfiloAttivo().setFotoProfilo(iDNuovaFotoProfilo);
            }
        };
        view.getImpostaImmagineProfiloButton().addActionListener(gestoreImpostaFotoProfilo);

        /**
         * ActionListener che permette di aggiungere un commento a un post
         */
        gestoreAggiungiCommento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggiungiCommento();
            }
        };
       view.getAggiungiCommentoButtonFrame().addActionListener(gestoreAggiungiCommento);
       
       /**
        * ActionListener che permette di aggiungere un like a un post
        */
       gestoreAggiungiLikePost = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   try {
    			   model.getProfiloAttivo().aggiungiLike(view.getIdPostVisualizzato(), tipoPostAttuale);
    		   } catch(AzioneNonConsentita e1) {
    			   e1.printStackTrace();
    		   }
    	   }
       };
       view.getAggiungiLikeButtonFrame().addActionListener(gestoreAggiungiLikePost);
       
       /**
        * ActionListener che permette di aggiungere un dislike a un post
        */
       gestoreAggiungiDislikePost = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   try {
    			   model.getProfiloAttivo().aggiungiDislike(view.getIdPostVisualizzato(), tipoPostAttuale);
    		   } catch(AzioneNonConsentita e1) {
    			   e1.printStackTrace();
    		   }
    	   }
       };
       view.getAggiungiDislikeButtonFrame().addActionListener(gestoreAggiungiDislikePost);
       
       /**
        * ActionListener che permette di scorrere in avanti tra i commenti di un post
        */
       gestoreNextCommento = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) { 
    		   view.incrementaIndiceCommento();
    		   view.settaCommenti(commentiConProfiliIinvianti);
    		   refresh();
    	   }
       };
       view.getNextCommento().addActionListener(gestoreNextCommento);
       
       /**
        * ActionListener che permette di scorrere indietro tra i commenti di un post
        */
       gestorePrevCommento = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   view.decrementaIndiceCommento();
    		   view.settaCommenti(commentiConProfiliIinvianti);    		
    	   }
       };
       view.getPrevCommento().addActionListener(gestorePrevCommento);    
       
       /**
        * ActionListener che permette di selezionare la prima scelta di un sondaggio
        */
       gestorePulsantePrimaScelta = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   try {
   				model.getProfiloAttivo().aggiungiVotoSondaggio(view.getPostVisualizzato().getIdPost(), 1, tipoPostAttuale);
   				} catch (TastoNonEsistente | AzioneNonConsentita e1) {
						e1.printStackTrace();
				}
   				
    	   }
    	   
       };
       view.getPulsantePrimaScelta().addActionListener(gestorePulsantePrimaScelta);
       
       /**
        * ActionListener che permette di selezionare la seconda scelta di un sondaggio
        */
       gestorePulsanteSecondaScelta = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {		     	   
    		   	try {
   					model.getProfiloAttivo().aggiungiVotoSondaggio(view.getPostVisualizzato().getIdPost(), 2, tipoPostAttuale);
   					} catch (TastoNonEsistente | AzioneNonConsentita e1) {
						e1.printStackTrace();
   					}
    	   }
       };
       view.getPulsanteSecondaScelta().addActionListener(gestorePulsanteSecondaScelta);
       
       /**
        * ActionListener che permette di selezionare la terza scelta di un sondaggio
        */
       gestorePulsanteTerzaScelta = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   
    		   try {
  					model.getProfiloAttivo().aggiungiVotoSondaggio(view.getPostVisualizzato().getIdPost(), 3, tipoPostAttuale);
  					} catch (TastoNonEsistente | AzioneNonConsentita e1) {
						e1.printStackTrace();
  					}
    	   }
      };
       view.getPulsanteTerzaScelta().addActionListener(gestorePulsanteTerzaScelta);
       
       /**
        * ActionListener che permette di selezionare la quarta scelta di un sondaggio
        */
       gestorePulsanteQuartaScelta = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   
    		   try {
				model.getProfiloAttivo().aggiungiVotoSondaggio(view.getPostVisualizzato().getIdPost(), 4,  tipoPostAttuale);
    		   	} catch (TastoNonEsistente | AzioneNonConsentita e1) {
					e1.printStackTrace();
				}
    	   	}
       };
       view.getPulsanteQuartaScelta().addActionListener(gestorePulsanteQuartaScelta);  
    }
    
    /**
     * metodo che implementa gli ActionListener della schermata della chat privata
     */
    public void actionListenersAreaChatFrame() {
    	
    	/**
    	 * ActionListener che permette di tornare alla home dalla schermata della chat
    	 */
    	gestoreChatFrameHome = new ActionListener() {
      	   @Override
      	   public void actionPerformed(ActionEvent e) {
      		  mostraSchermata("Home");
      	   }
      	   
         };
         view.getPulsanteHomeAreaChatFrame().addActionListener(gestoreChatFrameHome);
         
        /**
         * ActionListener che permette di scrivere un messaggio
         */
    	gestoreInvioMessaggio = new ActionListener() {
     	   @Override
     	   public void actionPerformed(ActionEvent e) {
     		  scriviMessaggioPrivato();
	  		  messaggi = model.getProfiloAttivo().cercaMessaggiChatPrivata(model.getProfiloAttivo().getIdProfilo(), model.getProfiloConCuiSiStaChattando().getIdProfilo());
	  		  view.aggiornaMessaggi(messaggi, model.getProfiloAttivo().getNickname());
			  refresh();
     	   }
     	   
        };
        view.getInviaMessaggio().addActionListener(gestoreInvioMessaggio);
        
        /**
         * ActionListener che permette di scorrere in avanti tra i messaggi della chat
         */
	    gestoreNextMessaggioButton = new ActionListener() {
	  	   @Override
	  	   public void actionPerformed(ActionEvent e) {
	  		   view.incrementaIndiceMessaggio();
	  		   view.aggiornaMessaggi(messaggi, model.getProfiloAttivo().getIdProfilo());
			   refresh();
	  	   }
	     };
         view.getNextMessaggioButton().addActionListener(gestoreNextMessaggioButton);   
         
         /**
          * ActionListener che permette di scorrere indietro tra i messaggi della chat
          */
         gestorePrevMessaggioButton = new ActionListener() {
       	   @Override
       	   public void actionPerformed(ActionEvent e) {
            		 view.decrementaIndiceMessaggio();
            		 view.aggiornaMessaggi(messaggi, model.getProfiloAttivo().getIdProfilo());
            		 refresh();
       		   		
       		   	}
          	};
          view.getPrevMessaggioButton().addActionListener(gestorePrevMessaggioButton);   
     }
    
    /**
     * metodo che implementa gli ActionListener per la schermata di creazione di un gruppo
     */
    public void actionListenerCreaChatDiGruppo(){
    	/**
    	 * ActionListener che permette di creare un gruppo
    	 */
    	gestoreCreaChatDiGruppo = new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			String nomeGruppo = view.getNomeGruppo().getText();
    			String descrizioneGruppo = view.getDescrizioneGruppo().getText();
    			try {
    				
    				model.getProfiloAttivo().creaGruppo( descrizioneGruppo, nomeGruppo);
    			} catch (AccountDoesNotExist e1) {
    				e1.printStackTrace();
    			}
    		}
    	};
    	
    	view.getCreaGruppo().addActionListener(gestoreCreaChatDiGruppo);
    	
    	/**
    	 * ActionListener che permette di tornare nella Home dalla schermata di creazione di un gruppo
    	 */
    	gestoreHomeChatDiGruppo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeCreazioneChatDiGruppo().addActionListener(gestoreHomeChatDiGruppo);
    }
    
    /**
     * metodo che implementa gli ActionListener per la schermata di chat di gruppo
     */
    public void  actionListenerChatDiGruppoFrame() {
    	
    	/**
    	 * ActionListener che permette di tornare nella Home dalla schermata di chat di gruppo
    	 */
    	gestoreHomeGruppoFrame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeGruppo().addActionListener(gestoreHomeGruppoFrame);
    
        /**
         * ActionListener che permette di scrivere un messaggio di gruppo

         */
    	gestoreInviaMessaggioGruppo = new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			String messaggio = view.getScriviMessaggioGruppo().getText();
    			model.getProfiloAttivo().scriviMessaggioGruppo(messaggio,  gruppoAttuale );
        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(model.getProfiloAttivo().getGruppoPerController().getIdGruppo());
        		view.aggiornaMessaggiGruppo(messaggi);
    		}
    	};
    	view.getInvia().addActionListener(gestoreInviaMessaggioGruppo);
	
    	/**
         * ActionListener che permette di scorrere in avanti tra i messaggi della chat di gruppo
         */
		gestoreNextMsgGruppo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (messaggi.size() >= view.getIndiceMessaggioCorrenteGruppo()-2) {
				view.incrementaIndiceMessaggioCorrenteGruppo();
				}
				if (view.getIndiceMessaggioCorrenteGruppo() < messaggi.size()) 	
	        		messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(gruppoAttuale);
	        		view.aggiornaMessaggiGruppo(messaggi);        		
	        		refresh();
	        		
			}
		};
		view.getNextMessaggiGruppo().addActionListener(gestoreNextMsgGruppo);
		
		/**
         * ActionListener che permette di scorrere indietro tra i messaggi della chat di gruppo
         */
		gestorePrevMsgGruppo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(view.getIndiceMessaggioCorrenteGruppo() > 0) {
					view.decrementaIndiceMessaggioCorrenteGruppo();
					messaggi = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(gruppoAttuale);
					view.aggiornaMessaggiGruppo(messaggi);        		
					refresh();
				}
			}
		};
		view.getPrevMessaggioGruppo().addActionListener(gestorePrevMsgGruppo);
		
		/**
		 * ActionListener che permette di aggiungere un partecipante al gruppo
		 */
		gestoreAggiungiUtente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String utente = view.getUtenteDaAggiungere().getText();
				aggiungiPartecipante(gruppoAttuale, utente);
			}
		};
		view.getUtenteDaAggiungereButton().addActionListener(gestoreAggiungiUtente);
		
		/**
		 * ActionListener che permette di rimuovere un partecipante dal gruppo
		 */
		gestoreRimuoviUtente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String utente = view.getUtenteDaEliminare().getText();
				model.getProfiloAttivo().rimuoviPartecipante(gruppoAttuale, utente);
			}
		};
		view.getUtenteDaEliminareButton().addActionListener(gestoreRimuoviUtente);
		
		/**
		 * ActionListener che permette di modificare la descrizione del gruppo
		 */
		gestoreModificaDescrizioneChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nuovaDescrizione = view.getTestoDescrizioneNuova().getText();
				model.getProfiloAttivo().modificaDescrizione(gruppoAttuale, nuovaDescrizione);
			}
		};
		view.getModificaButton().addActionListener(gestoreModificaDescrizioneChat);
		
		/**
		 * ActionListener che permette di entrare in un gruppo
		 */
		gestorePartecipa = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aggiungiPartecipante(gruppoAttuale, model.getProfiloAttivo().getIdProfilo());
			}
		};
		view.getPartecipazioneGruppoButton().addActionListener(gestorePartecipa);
		
		/**
		 * ActionListener che permette di uscire da un gruppo
		 */
		gestoreEsciGruppo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rimuoviPartecipante(gruppoAttuale, model.getProfiloAttivo().getIdProfilo());
			}
		};
		view.getUscitaGruppoButton().addActionListener(gestoreEsciGruppo);
    }
    
    /**
     * metodo che permette di ricaricare la pagina
     */
    public void refresh() {
        view.invalidate();
        view.validate();
        view.repaint();
    }
        
    /**
     * metodo che permette di fare il signUp
     * @throws AccountGiaEsistente
     * @throws ChangeDefaultPassword
     * @throws AccountDoesNotExist
     * @return true se il signUp � riuscito
     */
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
    
    /**
     * metodo che permette di fare il login
     * @throws PswOmailErrati
     * @throws ChangeDefaultPassword
     * @throws AccountDoesNotExist
     * @return true se il login � riuscito
     */
    public boolean login() {        
		try {
		model.login(view.emailInserita(), view.passwordInserita());
		} catch (ChangeDefaultPassword errore1) {
		} catch (AccountDoesNotExist errore2) {
		mostraFallimentoLogin("Questo account non esiste");
		return false;
		} catch (PswOmailErrati errore3) {
		mostraFallimentoLogin("hai inserito le credenziali sbagliate");
		return false;
		}   
		return true;
		}
    
    /**
     * metodo che nasconde la schermata attuale
     * @param schermata
     */
    public void nascondiSchermata(String schermata) {
        view.mappaSchermate.get(schermata).setVisible(false);
    }
    /**
     * metodo che permette di cambiare schermata
     * @param schermata
     */
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
    /**
     * metodo che segnala il fallimento del login
     * @param codiceFallimento
     */
    public void mostraFallimentoLogin(String codiceFallimento) {
        view.getEtichettaDiSegnalazioneLoginFallito().setText(codiceFallimento);
        view.getEtichettaDiSegnalazioneLoginFallito().setVisible(true);
    }
    /**
     * metodo che permette di pubblicare un post a seconda del valore passato
     */
    public void pubblicaPost() {
        String commentoPost = view.ottieniCommento();
    	System.out.println("post attuale =" + getPostAttuale());
    	
        if(getPostAttuale() == 0) {
            String percorsoFilePost = view.ottieniPercorsoFile();
            if (percorsoFilePost != null) {
            model.getProfiloAttivo().pubblicaFoto(commentoPost, true, percorsoFilePost, false);
            }
        }
        else if(getPostAttuale() == 1) {
        	model.getProfiloAttivo().pubblicaTesto(commentoPost, false, model.getProfiloAttivo().getIdProfilo(), null, null);
        }
        else if(getPostAttuale() == 2) {
        	String scelta1 = view.getPrimaScelta().getText();
        	String scelta2 = view.getSecondaScelta().getText();
        	model.getProfiloAttivo().pubblicaSondaggioDoppiaVotazione(commentoPost, true, model.getProfiloAttivo().getIdProfilo(), scelta1, scelta2);
        }
        
        else if (getPostAttuale() == 3) {
        	String scelta1 = view.getPrimaScelta().getText();
        	String scelta2 = view.getSecondaScelta().getText();
        	String scelta3 = view.getTerzaScelta().getText();
        	String scelta4 = view.getQuartaScelta().getText();
        	model.getProfiloAttivo().pubblicaSondaggioSceltaMultipla(commentoPost, true, model.getProfiloAttivo().getIdProfilo(), scelta1, scelta2, scelta3, scelta4);
        }
    }
    
    /**
     * metodo che permette di pubblicare una story
     */
    public void pubblicaStory() {
   	 
    	String commentoPost = view.ottieniCommento();
    	String percorsoFilePost = view.ottieniPercorsoFile();
    	
    	model.getProfiloAttivo().pubblicaStoria(commentoPost, true, percorsoFilePost, false);
    }

    /**
     * metodo che permette di verificare se se il testo coincide con la ricerca
     * @return true se il testo coincide con la ricerca
     */
    public boolean verificaTestoRicerca() {
        if(view.getTestoRicerca().equals("") || view.getTestoRicerca().equals("Inserire un username da cercare")) {
            return false;
        }
        return true;
    }

    /**
     * metodo che aggiorna una schermata di un profilo a seconda del profilo cercato
     * @param nickName
     * @param descrizione
     * @param numPost
     * @param numFollower
     * @param numSeguiti
     * @param fotoProfiloPercorso
     * @param idProfilo
     * @param postFotoProfilo
     * @param percorsiPostTesto
     * @param percorsiPostSondaggio
     * @param percorsiPostSondaggioDoppiaScelta
     * @throws PostNonVisibile
     */
    public void aggiornaSchermataProfilo(String nickName, String descrizione, int numPost, int numFollower, int numSeguiti, String fotoProfiloPercorso, String idProfilo, ArrayList<String> postFotoProfilo, ArrayList<String> percorsiPostTesto, ArrayList<String> percorsiPostSondaggio, ArrayList<String>  percorsiPostSondaggioDoppiaScelta) throws PostNonVisibile {
    	view.setSchermataDati(numPost, numFollower, numSeguiti, nickName, descrizione);
        view.setFotoProfilo(fotoProfiloPercorso);
        view.setPostProfilo(postFotoProfilo);
        view.setPostTestoProfilo(percorsiPostTesto);
        view.setPostSondaggioProfilo(percorsiPostSondaggio);
        view.setPostSondaggioDoppiaSceltaProfilo(percorsiPostSondaggioDoppiaScelta);
        refresh();
    }
    /**
     * metodo che permette la ricerca di un profilo tramite barra di ricerca
     */
    public void ricerca() {
        String risultatoRicerca = view.getTestoRicerca();
        view.getTestoRicercaInSchermataRicerca().setText(risultatoRicerca);
        view.impostaRisultatiRicerca(risultatoRicerca);
        model.ricerca(view.getTestoRicerca());
        refresh();
    }
    /**
     * metodo che permette di poter aggiungere i commenti al post di un profilo
     */
    public void aggiungiCommento() {
    	String idProfilo = model.getProfiloAttivo().getIdProfilo();
    	String commentoDaAggiungere = view.getCommentoDaAggiungere().getText();
    	String idPost = view.getIdPostVisualizzato();
    	model.getProfiloAttivo().pubblicaCommento(idProfilo, idPost, commentoDaAggiungere, tipoPostAttuale);
		try {
			commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(view.getIdPostVisualizzato(), tipoPostAttuale);
		} catch (PostNonVisibile e) {
			e.printStackTrace();
		}
    	view.settaCommenti(commentiConProfiliIinvianti);
    }
    /**
     * metodo che permette di visualizzare i commenti di un post
     * @param idPost
     * @throws PostNonVisibile
     */
    public void mostraCommentiPost(String idPost) throws PostNonVisibile {
    	commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(idPost, tipoPostAttuale);
    	view.settaCommenti(commentiConProfiliIinvianti);
    }
    /**
     * metodo che permette di scrivere un messaggio privato a un altro profilo    
     */
    public void scriviMessaggioPrivato() {
    	String testoDaInviare = view.getScriviMessaggio().getText();
    	model.getProfiloAttivo().scriviMessaggioPrivato(testoDaInviare, model.getProfiloConCuiSiStaChattando().getIdProfilo());
    }
    
    /**
     * metodo che permette di aggiornare la schermata del profilo attivo con i parametri passati
     */
    public void aggiornaSchermataProfiloAttivo() {
    	String descrizione = model.getProfiloAttivo().getDescrizione();;
    	if(descrizione == null) {
    		descrizione = "-- Puoi cambiare la descrizione nelle impostazioni --";
    	}
    	String nickName = model.getProfiloAttivo().getNickname();
    	int numPost = model.getProfiloAttivo().getNumPost();
        int numFollower = model.getProfiloAttivo().getNumFollower();
        int numSeguiti = model.getProfiloAttivo().getNumSeguiti();
        String idProfilo = model.getProfiloAttivo().getIdProfilo();
        postDelProfilo = model.getProfiloAttivo().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.FOTO);
        percorsiPostTesto = model.getProfiloAttivo().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.TESTO);
        percorsiPostSondaggioSceltaMultipla = model.getProfiloAttivo().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.SONDAGGIOSCELTAMULTIPLA);
        percorsiPostSondaggioDoppiaScelta= model.getProfiloAttivo().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.SONDAGGIODOPPIAVOTAZIONE);

        String fotoProfiloPercorso = null;
 
        try {
    	   fotoProfiloPercorso = ((Foto)model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloAttivo().getFotoProfilo()))).getPercorso();
        } catch (PostNonVisibile | PostNonPresente e1) {
    	   fotoProfiloPercorso = "immagini/images.png";
        } 
        try {
			aggiornaSchermataProfilo(nickName, descrizione, numPost, numFollower, numSeguiti, fotoProfiloPercorso, idProfilo, postDelProfilo,percorsiPostTesto, percorsiPostSondaggioSceltaMultipla, percorsiPostSondaggioDoppiaScelta);
		} catch (PostNonVisibile e1) {
			e1.printStackTrace();
		}
        refresh();
    }
    
    /**
     * permette di riaggiornare da zero le pagine
     * @throws AccountDoesNotExist
     */
    public void resettaGui() {
       
        commentiConProfiliIinvianti.clear();
        messaggiInviati.clear();
        postDelProfilo.clear();
        percorsiPostFoto.clear();
        percorsiPostTesto.clear();
        percorsiPostSondaggioSceltaMultipla.clear();
        listaGruppi.clear();
        postSchermataHome.clear();
        storySchermataHome.clear();
        
        try {
			model.setProfiloAttivo(model.getProfiloAttivo().cercaProfilo(model.getProfiloAttivo()));
		} catch (AccountDoesNotExist e) {
			e.printStackTrace();
		}
    }
    
    /**
     * permette di poter visualizzare un post con tutte le sue descrizioni
     * @param f
     */
    public void visualizzaPostFoto(Foto f) {
    	  
      		try {
				commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(f.getIdPost(), tipoPostAttuale);
			} catch (PostNonVisibile e1) {
				e1.printStackTrace();
			}
          view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
    }
    
    public int getPostAttuale() {
		return postAttuale;
	}

	public void setPostAttuale(int postAttuale) {
		this.postAttuale = postAttuale;
	}

	public int getBasePostAttuale() {
		return basePostAttuale;
	}

	public void setBasePostAttuale(int basePostAttuale) {
		this.basePostAttuale = basePostAttuale;
	}
	
	/**
	 * permette di modificare la descrizione del profilo
	 */
	public void aggiungiDescrizione() {
    	String descrizione = view.getDescrizione().getText();
    	model.getProfiloAttivo().modificaDescrizione(descrizione);
    	model.getProfiloAttivo().setDescrizione(descrizione);
	}
	
	/**
	 * resetta i contatori per i post
	 */
	public void resetContatori() {
		view.setContatoreFoto(0);
		view.setContatoreSondaggio(0);
		view.setContatoreTesto(0);
		view.setIndiceStorie(0);
		view.setContatorePost(0);
	}
	
	/**
	 * permette di ottenere il percorso di un post
	 * @param indicePost
	 * @return
	 */
	public String ottieniPost(int indicePost) {
		String percorsoPost = "";
		
		try {
			percorsoPost = model.getProfiloAttivo().cercaPost(new Foto(postSchermataHome.get(indicePost))).getPercorso();
		} catch(PostNonVisibile | PostNonPresente e) {
			e.printStackTrace();
		}
		
		return percorsoPost;
	}
	/**
	 * permette di rimuovere il profilo attuale
	 */
	public void rimuoviProfilo() {
		model.getProfiloAttivo().rimuoviQuestoProfilo();
	}
	
	/**
	 * permette di settare la schermata della chat di gruppo
	 * @param g
	 * @param commenti
	 */
	public void settaSchermataGruppo(Gruppo g, ArrayList<String> commenti) {
		this.gruppoAttuale = g.getIdGruppo();
		view.setIdGruppo(g.getIdGruppo());
		view.aggiornaMessaggiGruppo(commenti);
	}

	/**
	 * permette di settare la chat di gruppo a seconda che il profilo sia amministratore o meno
	 * @param g
	 */
	public void setGruppo(Gruppo g) {
		if(model.getProfiloAttivo().getIdProfilo().equals(g.getAmministratore())) {
			view.getUtenteDaAggiungereButton().setVisible(true);
			view.getUtenteDaEliminareButton().setVisible(true);
			view.getModificaButton().setVisible(true);
			view.getUtenteDaAggiungere().setVisible(true);
			view.getUtenteDaEliminare().setVisible(true);
			view.getTestoDescrizioneNuova().setVisible(true);
			view.getPartecipazioneGruppoButton().setVisible(false);
			view.getUscitaGruppoButton ().setVisible(false);

		}
		else {
			view.getUtenteDaAggiungereButton().setVisible(false);
			view.getUtenteDaEliminareButton().setVisible(false);
			view.getModificaButton().setVisible(false);
			view.getUtenteDaAggiungere().setVisible(false);
			view.getUtenteDaEliminare().setVisible(false);
			view.getTestoDescrizioneNuova().setVisible(false);
			view.getPartecipazioneGruppoButton().setVisible(true);
			view. getUscitaGruppoButton ().setVisible(true);

		}
	}
	/**
	 * permette di aggiungere un partecipante a un gruppo
	 * @param idGruppo
	 * @param utente
	 */
	public void aggiungiPartecipante(String idGruppo, String utente) {
		try {
			model.getProfiloAttivo().aggiungiPartecipante(idGruppo, utente);
		} catch (GruppoGiaPieno e1) {
			e1.printStackTrace();
		} catch (ProfiloGiaInserito e1) {
			e1.printStackTrace();
		}
	}
	/**
	 * permette di rimuovere un partecipante a un gruppo
	 * @param idGruppo
	 * @param utente
	 */
	public void rimuoviPartecipante(String idGruppo, String utente) {
		model.getProfiloAttivo().rimuoviPartecipante(idGruppo, utente);
	}
	
	/**
	 * permette di poter visualizzare un testo e i commenti sotto di esso
	 * @param indicePostTesto
	 * @throws printStackTrace
	 * @throws PostNonPresente
	 */
	public void visualizzaPostTesto(int indicePostTesto) {
		tipoPostAttuale = TipoPost.TESTO;
        try {
        	model.getProfiloAttivo().setPostTestoPerController((Testo) model.getProfiloAttivo().cercaPost(new Testo(percorsiPostTesto.get(indicePostTesto))));
			
		} catch (PostNonVisibile e1) {
			e1.printStackTrace();
		} catch (PostNonPresente e1) {
			e1.printStackTrace();
		}
    	try {
			commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(model.getProfiloAttivo().getPostTestoPerController().getIdPost(), tipoPostAttuale);
		} catch (PostNonVisibile e1) {
			e1.printStackTrace();
		}
    	view.getImpostaImmagineProfiloButton().setVisible(false);
    	view.setPostVisualizzato(model.getProfiloAttivo().getPostTestoPerController().getIdPost(),
    							 null, 
    							 model.getProfiloAttivo().getPostTestoPerController().getDescrizione(), 
    							 model.getProfiloAttivo().getPostTestoPerController().getNumLike(), 
    							 model.getProfiloAttivo().getPostTestoPerController().getNumDislike(), 
    							 commentiConProfiliIinvianti.size(), 
    							 commentiConProfiliIinvianti);
        mostraSchermata("Postvisualizzato");
        view.getNascondi().setVisible(false);
        refresh();
	}
	
	/**
	 * permette di poter visualizzare una foto e i commenti sotto di esso
	 * @param indicePostTesto
	 * @throws printStackTrace
	 * @throws PostNonPresente
	 */
	public void visualizzaPostFoto(int indicePostFoto) {
        tipoPostAttuale = TipoPost.FOTO;
        try {
			try {
				model.getProfiloAttivo().setPostFotoPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(indicePostFoto))));
			} catch (PostNonPresente e1) {
				e1.printStackTrace();
			}
		} catch (PostNonVisibile e1) {
			e1.printStackTrace();
		}

    	try {

			commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(model.getProfiloAttivo().getPostFotoPerController().getIdPost(), tipoPostAttuale);
		} catch (PostNonVisibile e1) {
			e1.printStackTrace();
		}
    	view.getImpostaImmagineProfiloButton().setVisible(true);
    	view.setPostVisualizzato(model.getProfiloAttivo().getPostFotoPerController().getIdPost(), 
    							 model.getProfiloAttivo().getPostFotoPerController().getPercorso(), 
    							 model.getProfiloAttivo().getPostFotoPerController().getDescrizione(), 
    							 model.getProfiloAttivo().getPostFotoPerController().getNumLike(), 
    							 model.getProfiloAttivo().getPostFotoPerController().getNumDislike(), 
    							 commentiConProfiliIinvianti.size(), 
    							 commentiConProfiliIinvianti);
        mostraSchermata("Postvisualizzato");
    	view.getNascondi().setVisible(model.getProfiloCercato().getIdProfilo().equals(model.getProfiloAttivo().getIdProfilo()));
        refresh(); 
	}
	
	/**
	 * permette di poter visualizzare un sondaggio a scelta multipla e i commenti sotto di esso
	 * @param indicePostTesto
	 * @throws printStackTrace
	 * @throws PostNonPresente
	 */
	public void visualizzaPostSondaggioSceltaMultipla(int indicePostSondaggio) {
		tipoPostAttuale = TipoPost.SONDAGGIOSCELTAMULTIPLA;
		try {
			model.getProfiloAttivo().setPostSondaggioSceltaMultiplaPerController((SondaggioSceltaMultipla) model.getProfiloAttivo().cercaPost(new SondaggioSceltaMultipla(percorsiPostSondaggioSceltaMultipla.get(indicePostSondaggio), null, false, null, null, null, null, null)));
		} catch (PostNonVisibile | PostNonPresente e1) {
			e1.printStackTrace();
		}

		try {
			commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getIdPost(), tipoPostAttuale);
		} catch (PostNonVisibile e1) {
			e1.printStackTrace();
		}
		int [] conteggi = model.getProfiloAttivo().ottieniConteggiSondaggio(percorsiPostSondaggioDoppiaScelta.get(0), tipoPostAttuale);
    	view.getImpostaImmagineProfiloButton().setVisible(false);
		view.settaSondaggioVisualizzato(model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getIdPost(), 
										model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getDescrizione(), 
										model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getPrimaScelta(),
										model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getSecondaScelta(), 
										model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getTerzaScelta(), 
									    model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getQuartaScelta(), 
									    model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getNumLike(), 
									    model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getNumDislike(), 
									    0, 
									    conteggi, 
									    commentiConProfiliIinvianti);
        
        view.setTipoSondaggio("SONDAGGIOSCELTAMULTIPLA");
        refresh();
        view.getNascondi().setVisible(false);
		mostraSchermata("Postvisualizzato");
	}
	
	/**
	 * permette di poter visualizzare un sondaggio a doppia scelta e i commenti sotto di esso
	 * @param indicePostTesto
	 * @throws printStackTrace
	 * @throws PostNonPresente
	 */
	public void visualizzaPostSondaggioDoppiaScelta(int indicePostSondaggio) {
		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;
		try {
			model.getProfiloAttivo().setPostSondaggioDoppiaScelta((SondaggioDoppiaVotazione) model.getProfiloAttivo().cercaPost(new SondaggioDoppiaVotazione(percorsiPostSondaggioDoppiaScelta.get(indicePostSondaggio), null, false, null, null, null)));
		} catch (PostNonVisibile | PostNonPresente e1) {
			e1.printStackTrace();
		}
		try {
			commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(model.getProfiloAttivo().getPostSondaggioDoppiaScelta().getIdPost(), tipoPostAttuale);
		} catch (PostNonVisibile e1) {
			e1.printStackTrace();
		}
		int [] conteggi = model.getProfiloAttivo().ottieniConteggiSondaggio(percorsiPostSondaggioDoppiaScelta.get(0), tipoPostAttuale);
		view.getImpostaImmagineProfiloButton().setVisible(false);
        view.setTipoSondaggio("SONDAGGIODOPPIAVOTAZIONE");
		view.settaSondaggioVisualizzatoSceltaDoppia(model.getProfiloAttivo().getPostSondaggioDoppiaScelta().getIdPost(), 
													model.getProfiloAttivo().getPostSondaggioDoppiaScelta().getDescrizione(),
													model.getProfiloAttivo().getPostSondaggioDoppiaScelta().getPrimaScelta(),
													model.getProfiloAttivo().getPostSondaggioDoppiaScelta().getSecondaScelta(), 
													model.getProfiloAttivo().getPostSondaggioDoppiaScelta().getNumLike(),
													model.getProfiloAttivo().getPostSondaggioDoppiaScelta().getNumDislike(),
													0, 
													conteggi,
													commentiConProfiliIinvianti);
        view.getNascondi().setVisible(false);
		mostraSchermata("Postvisualizzato");
		refresh();
	}
}
