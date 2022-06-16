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
                           gestoreHomeChat, gestoreHomePannelloNotifiche, gestoreCreazionePostFoto, gestoreHomeCreazionePost,
                           gestoreLogOut,gestorePubblicaPost, gestoreModificaProfilo, gestoreVisibilitaPost, gestoreEliminaAccount,
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
                           gestoreRimuoviUtente, gestoreAggiungiUtente, gestoreModificaDescrizioneChat, gestoreInviaMessaggioGruppo, gestoreCambiaDescrizione, gestoreHomeGruppo,
                           gestorePrimaStoria, gestoreSecondaStoria, gestoreTerzaStoria, gestoreQuartaStoria, gestoreQuintaStoria, gestoreNextMsgGruppo, gestorePrevMsgGruppo;
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
    
	public Controller(Sistema s, Frame f) {
        view = f;
        model = s;  
        initComponents();
    }
    
    public void initComponents() {
        
        actionListenersLogin();
        actionListenersSignUp();
        actionListenersHome();
        actionListenersImpostazioni();
        actionListenersProfilo();
        actionListenersCreazionePost();
        actionListenersRicerca();
        actionListenersChat();
        actionListenersNotifiche();
        actionListenersPostVisualizzato();
        actionListenersAreaChatFrame();
        actionListenerCreaChatDiGruppo();
        actionListenerChatDiGruppoFrame();
    }

    
    public void actionListenersNotifiche() {
        
        gestoreHomePannelloNotifiche = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomePannelloNotificheButton().addActionListener(gestoreHomePannelloNotifiche);
    }
    
    public void actionListenersLogin() {
        gestoreLogin = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (login()) 
                	postSchermataHome = model.getProfiloAttivo().caricaPostProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
                	storySchermataHome = model.getProfiloAttivo().caricaStorieProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
                	if(storySchermataHome.size() == 0) {
                  		System.out.println("non ci sono storie");
                	} else {
                		view.setPercorsiStorieLogin(storySchermataHome);
                	}
                	if(postSchermataHome.size() == 0) {
                		mostraSchermata("Home");
                	} else {
                		view.setPercorsoPost(ottieniPost(0));
                		view.aggiornaPostHome();
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
    }
    
    public void actionListenersSignUp() {
        gestoreRegistrati = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (signUp()) {
                    mostraSchermata("Home");
                }
            }
        };
        view.getRegistratiButton().addActionListener(gestoreRegistrati);
        
        gestoreIndietroSignup = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	mostraSchermata("Login");
            }
        };
         view.getIndietroButton().addActionListener(gestoreIndietroSignup);
    }
    
    
    public void actionListenersHome() {

    	gestorePulsanteFotoHome = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	try {
            		model.getProfiloAttivo().setFotoPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(postSchermataHome.get(0 + view.getContatorePost()))));
				} catch (PostNonPresente| PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	visualizzaPostFoto(model.getProfiloAttivo().getFotoPerController());
            	mostraSchermata("Postvisualizzato");
            	refresh();
            
            }
        };
        view.getPostPrincipale().addActionListener(gestorePulsanteFotoHome);
        
        
        
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
        
        gestorePrimaStoria = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	try {
            		model.getProfiloAttivo().setStoriaPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(storySchermataHome.get(0 + view.getIndiceStorie()))));
				} catch (PostNonPresente| PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	visualizzaPostFoto(model.getProfiloAttivo().getStoriaPerController());
            	mostraSchermata("Postvisualizzato");
            	refresh();
            
        	}
        };
        view.getPrimaStoriaButton().addActionListener(gestorePrimaStoria);
        
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
            	refresh();
            
        	}
        };
        view.getSecondaStoriaButton().addActionListener(gestoreSecondaStoria);
        
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
            	refresh();
            
        	}
        };
        view.getTerzaStoriaButton().addActionListener(gestoreTerzaStoria);
        
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
            	refresh();
            
        	}
        };
        view.getQuartaStoriaButton().addActionListener(gestoreQuartaStoria);
        
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
            	refresh();
            
        	}
        };
        view.getQuintaStoriaButton().addActionListener(gestoreQuintaStoria);
        
        gestoreImpostazioni = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		mostraSchermata("Impostazioni");
        	}
        };
        view.getImpostazioniButton().addActionListener(gestoreImpostazioni);
                
        gestoreCreaUnaChatDiGruppoHome = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("CreazioneChatDiGruppo");
            }
        };
        view.getCreaUnaChatDiGruppo().addActionListener(gestoreCreaUnaChatDiGruppoHome);
                
        gestoreProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	profiloVisualizzato = model.getProfiloAttivo().getIdProfilo();
            	aggiornaSchermataProfiloAttivo();
                refresh();
                view.getPulsanteSegui().setVisible(false);
                view.getApriChat().setVisible(false);
                mostraSchermata("Profilo");
            }
        };
        view.getProfiloButton().addActionListener(gestoreProfilo);
                
                
        gestoreChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	listaGruppi = model.getProfiloAttivo().caricaGruppiProfilo(model.getProfiloAttivo().getIdProfilo());
                view.settaSchermataChat(listaGruppi);
            	mostraSchermata("Chat");
            }
        };
        view.getChatButton().addActionListener(gestoreChat);
                
                
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
    
    
    public void actionListenersImpostazioni() {
    	gestoreLogOut = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            try {
	                model.logout(model.getProfiloAttivo().getIdProfilo());
	            }catch (AccountDoesNotExist e1) {
	            	e1.printStackTrace();
	            }
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
	    
	    gestoreEliminaAccount = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            view.getContainerCenterFrame().setVisible(false);
	        }
	    };
	    view.getEliminaAccountButton().addActionListener(gestoreEliminaAccount);
        
	    gestoreSalvaLeModifiche = new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		aggiungiDescrizione();
	    	}
	    };
	    view.getSalvaModificheButton().addActionListener(gestoreSalvaLeModifiche);
	    
	    gestoreRimuoviAccount = new ActionListener() {
	    	@Override
	    	public void actionPerformed(ActionEvent e) {
	    		rimuoviProfilo();
	    		mostraSchermata("Login");
	    	}
	    };
	    view.getEliminaAccountButton().addActionListener(gestoreRimuoviAccount);
    }
    
    public void actionListenersProfilo() {
        gestoreHomeProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resetContatori();
                mostraSchermata("Home");
                refresh();
            }
        };
        view.getHomeProfiloButton().addActionListener(gestoreHomeProfilo);
        
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
		            refresh();         
		        }
	        }
        };
        view.getPulsanteFotoProfilo().addActionListener(gestoreFotoProfilo);
        
        gestorePulsantePrimoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
              /*  try {
                	model.getProfiloAttivo().setPostTestoPerController((Testo) model.getProfiloAttivo().cercaPost(new Testo(percorsiPostTesto.get(0 + view.getContatoreTesto()))));
					
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
            	tipoPostAttuale = TipoPost.TESTO;
            	view.getImpostaImmagineProfiloButton().setVisible(false);
            	view.setPostVisualizzato(model.getProfiloAttivo().getPostTestoPerController().getIdPost(),
            							 null, 
            							 model.getProfiloAttivo().getPostTestoPerController().getDescrizione(), 
            							 model.getProfiloAttivo().getPostTestoPerController().getNumLike(), 
            							 model.getProfiloAttivo().getPostTestoPerController().getNumDislike(), 
            							 commentiConProfiliIinvianti.size(), 
            							 commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();*/
            	visualizzaPostTesto(0 + view.getContatoreTesto());
            }
        };
        view.getPulsantePrimoTesto().addActionListener(gestorePulsantePrimoTesto);
        
        gestorePulsanteSecondoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	/*settaPostVisualizzato(false);
                try {
                	model.getProfiloAttivo().setPostTestoPerController((Testo) model.getProfiloAttivo().cercaPost(new Testo(percorsiPostTesto.get(2+ view.getContatoreTesto()))));
					
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				} catch (PostNonPresente e1) {
				} 
            	try {

					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(model.getProfiloAttivo().getPostTestoPerController().getIdPost(), tipoPostAttuale);
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	tipoPostAttuale = TipoPost.TESTO;
            	view.getImpostaImmagineProfiloButton().setVisible(false);
                view.setPostVisualizzato(model.getProfiloAttivo().getPostTestoPerController().getIdPost(), 
                						 null, 
                						 model.getProfiloAttivo().getPostTestoPerController().getDescrizione(), 
                						 model.getProfiloAttivo().getPostTestoPerController().getNumLike(), 
                						 model.getProfiloAttivo().getPostTestoPerController().getNumDislike(), 
                						 commentiConProfiliIinvianti.size(), 
                						 commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();*/
            	visualizzaPostTesto(2+ view.getContatoreTesto());
            }
        };
        view.getPulsanteSecondoTesto().addActionListener(gestorePulsanteSecondoTesto);
        
        gestorePulsanteTerzoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	/*settaPostVisualizzato(false);
                try {
                	model.getProfiloAttivo().setPostTestoPerController((Testo) model.getProfiloAttivo().cercaPost(new Testo(percorsiPostTesto.get(4 + view.getContatoreTesto()))));
					
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				} catch (PostNonPresente e1) {
					e1.printStackTrace();
				}
            	try {
                	tipoPostAttuale = TipoPost.TESTO;
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
                refresh();*/
            	visualizzaPostTesto(4 + view.getContatoreTesto());
            }
        };
        view.getPulsanteTerzoTesto().addActionListener(gestorePulsanteTerzoTesto);
        
        
        
        
        gestorePost1 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                /*settaPostVisualizzato(false);
                try {
					try {
						model.getProfiloAttivo().setPostFotoPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(0 + view.getContatoreFoto()))));
					} catch (PostNonPresente e1) {
						e1.printStackTrace();
					}
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	tipoPostAttuale = TipoPost.FOTO;

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
                refresh();*/
        		visualizzaPostFoto(0 + view.getContatoreFoto());
        	}
        };
        view.getPost1().addActionListener(gestorePost1);
        
        gestorePost2 = new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
                    /*settaPostVisualizzato(false);                    
                    try {
    					try {
    						model.getProfiloAttivo().setPostFotoPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(2 + view.getContatoreFoto()))));
						} catch (PostNonPresente e1) {
							e1.printStackTrace();
						}
    				} catch (PostNonVisibile e1) {
    					e1.printStackTrace();
    				}
                	tipoPostAttuale = TipoPost.FOTO;

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
                    refresh();*/
        		visualizzaPostFoto(2 + view.getContatoreFoto());
        	}
        };
        view.getPost2().addActionListener(gestorePost2);
        
        
        gestorePost3 = new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
                    /*settaPostVisualizzato(false);
                    try {
    					try {
    						model.getProfiloAttivo().setPostFotoPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(4 + view.getContatoreFoto()))));
						} catch (PostNonPresente e1) {
							e1.printStackTrace();
						}
    				} catch (PostNonVisibile e1) {
    					e1.printStackTrace();
    				}
                	tipoPostAttuale = TipoPost.FOTO;

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
                    refresh();*/
        		visualizzaPostFoto(4 + view.getContatoreFoto());
        	}
        };
        view.getPost3().addActionListener(gestorePost3);
        
        
        gestoreSondaggio1 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		/*try {
        			model.getProfiloAttivo().setPostSondaggioSceltaMultiplaPerController((SondaggioSceltaMultipla) model.getProfiloAttivo().cercaPost(new SondaggioSceltaMultipla(percorsiPostSondaggioSceltaMultipla.get(0), null, false, null, null, null, null, null)));
        		} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;

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
                refresh();
                view.setTipoSondaggio("SONDAGGIOSCELTAMULTIPLA");
        		mostraSchermata("Postvisualizzato");*/
        		visualizzaPostSondaggioSceltaMultipla(0);
        	}
        };
        view.getPulsantePrimoSondaggio().addActionListener(gestoreSondaggio1);
        
        gestoreSondaggio2 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		/*try {
        			model.getProfiloAttivo().setPostSondaggioSceltaMultiplaPerController((SondaggioSceltaMultipla) model.getProfiloAttivo().cercaPost(new SondaggioSceltaMultipla(percorsiPostSondaggioSceltaMultipla.get(2), null, false, null, null, null, null, null)));
        		} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;

        		try {
					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getIdPost(), tipoPostAttuale);
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
        		int [] conteggi = model.getProfiloAttivo().ottieniConteggiSondaggio(percorsiPostSondaggioDoppiaScelta.get(0), tipoPostAttuale);
            	view.getImpostaImmagineProfiloButton().setVisible(false);
                view.setTipoSondaggio("SONDAGGIOSCELTAMULTIPLA");
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
                refresh();
        		mostraSchermata("Postvisualizzato");*/
        		visualizzaPostSondaggioSceltaMultipla(2);
        	}
        };
        view.getPulsanteSecondoSondaggio().addActionListener(gestoreSondaggio2);
        
        gestoreSondaggio3 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		/*try {
					model.getProfiloAttivo().setPostSondaggioSceltaMultiplaPerController((SondaggioSceltaMultipla) model.getProfiloAttivo().cercaPost(new SondaggioSceltaMultipla(percorsiPostSondaggioSceltaMultipla.get(4), null, false, null, null, null, null, null)));
        		} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;

        		try {

					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(model.getProfiloAttivo().getPostSondaggioSceltaMultiplaPerController().getIdPost(), tipoPostAttuale);
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
        		int [] conteggi = model.getProfiloAttivo().ottieniConteggiSondaggio(percorsiPostSondaggioDoppiaScelta.get(0), tipoPostAttuale);
            	view.getImpostaImmagineProfiloButton().setVisible(false);
                view.setTipoSondaggio("SONDAGGIOSCELTAMULTIPLA");
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
                refresh();
        		mostraSchermata("Postvisualizzato");*/
        		visualizzaPostSondaggioSceltaMultipla(4);
        	}
        };
        view.getPulsanteTerzoSondaggio().addActionListener(gestoreSondaggio3);
        
        gestoreSondaggioDoppiaScelta1 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		/*try {
        			model.getProfiloAttivo().setPostSondaggioDoppiaScelta((SondaggioDoppiaVotazione) model.getProfiloAttivo().cercaPost(new SondaggioDoppiaVotazione(percorsiPostSondaggioDoppiaScelta.get(0), null, false, null, null, null)));
        		} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;
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
                refresh();
        		mostraSchermata("Postvisualizzato");*/
        		visualizzaPostSondaggioDoppiaScelta(0);
        	}
        };
        view.getPulsantePrimoSondaggioDoppia().addActionListener(gestoreSondaggioDoppiaScelta1);
        
        gestoreSondaggioDoppiaScelta2 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		/*try {
        			model.getProfiloAttivo().setPostSondaggioDoppiaScelta((SondaggioDoppiaVotazione) model.getProfiloAttivo().cercaPost(new SondaggioDoppiaVotazione(percorsiPostSondaggioDoppiaScelta.get(2), null, false, null, null, null)));
        		} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;

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
                refresh();
        		mostraSchermata("Postvisualizzato");*/
        		visualizzaPostSondaggioDoppiaScelta(2);
        	}
        };
        view.getPulsanteSecondoSondaggioDoppia().addActionListener(gestoreSondaggioDoppiaScelta2);
        
        gestoreSondaggioDoppiaScelta3 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		/*try {
        			model.getProfiloAttivo().setPostSondaggioDoppiaScelta((SondaggioDoppiaVotazione) model.getProfiloAttivo().cercaPost(new SondaggioDoppiaVotazione(percorsiPostSondaggioDoppiaScelta.get(4), null, false, null, null, null)));
        		} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;

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
                refresh();
        		mostraSchermata("Postvisualizzato");*/
        		visualizzaPostSondaggioDoppiaScelta(4);
        	}
        };
        view.getPulsanteTerzoSondaggioDoppia().addActionListener(gestoreSondaggioDoppiaScelta3);
        

        

        gestoreNextFoto = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreFoto(view.getContatoreFoto() + 2);
        		view.setPostProfilo(postDelProfilo);
        	}
        };
        view.getNextFoto().addActionListener(gestoreNextFoto);
        
        gestorePrevFoto = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreFoto(view.getContatoreFoto() - 2);
        		view.setPostProfilo(postDelProfilo);
        	}
        };
        view.getPrevFoto().addActionListener(gestorePrevFoto);
        
        gestoreNextTesto = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreTesto(view.getContatoreTesto() + 2);
        		view.setPostTestoProfilo(percorsiPostTesto);
        	}
        };
        view.getNextTesto().addActionListener(gestoreNextTesto);
        
        gestorePrevTesto = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreTesto(view.getContatoreTesto() - 2);
        		view.setPostTestoProfilo(percorsiPostTesto);
        	}
        };
        view.getPrevTesto().addActionListener(gestorePrevTesto);
        
        gestoreNextSondaggio = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreSondaggio(view.getContatoreSondaggio() + 2);
        		view.setPostSondaggioProfilo(percorsiPostSondaggioSceltaMultipla);
        	}
        };
        view.getNextSondaggio().addActionListener(gestoreNextSondaggio);
        
        gestorePrevSondaggio = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreSondaggio(view.getContatoreSondaggio() - 2);
        		view.setPostSondaggioProfilo(percorsiPostSondaggioSceltaMultipla);
        	}
        };
        view.getPrevSondaggio().addActionListener(gestorePrevSondaggio);
    }
    
    public void actionListenersCreazionePost() {
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
        };
        view.getPubblicaPostButton().addActionListener(gestorePubblicaPost);
        
        gestorePubblicaStory = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
            	pubblicaStory();
            }
        };
        view.getPubblicaStoryButton().addActionListener(gestorePubblicaStory);
        
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

    
    public void actionListenersRicerca(){
        gestoreHomeCerca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeRicercaButton().addActionListener(gestoreHomeCerca);
        
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
    
    
    public void actionListenersChat() {
        gestoreHomeChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeChatButton().addActionListener(gestoreHomeChat);
             
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
    
    public void actionListenersPostVisualizzato() {
        gestoreHomePostVisualizzato = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	view.ripristinaIndiceCommento();
            	resetContatori();
                mostraSchermata("Home");
            }
        };
        view.getHomePostVisualizzatoButton().addActionListener(gestoreHomePostVisualizzato);
    
        gestoreImpostaFotoProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	String iDNuovaFotoProfilo = ((PostVisualizzato)view.mappaSchermate.get("Postvisualizzato")).getIdPost();
                model.getProfiloAttivo().cambiaImmagineProfilo(iDNuovaFotoProfilo);
                model.getProfiloAttivo().setFotoProfilo(iDNuovaFotoProfilo);
            }
        };
        view.getImpostaImmagineProfiloButton().addActionListener(gestoreImpostaFotoProfilo);

        gestoreAggiungiCommento = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                aggiungiCommento();
            }
        };
       view.getAggiungiCommentoButtonFrame().addActionListener(gestoreAggiungiCommento);
       
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
       
       gestoreNextCommento = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) { 
    		   view.incrementaIndiceCommento();
    		   view.settaCommenti(commentiConProfiliIinvianti);
    		   refresh();
    	   }
       };
       view.getNextCommento().addActionListener(gestoreNextCommento);
       
       gestorePrevCommento = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   view.decrementaIndiceCommento();
    		   view.settaCommenti(commentiConProfiliIinvianti);    		
    	   }
       };
       view.getPrevCommento().addActionListener(gestorePrevCommento);    
       
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
    
    public void actionListenersAreaChatFrame() {
    	
    	gestoreChatFrameHome = new ActionListener() {
      	   @Override
      	   public void actionPerformed(ActionEvent e) {
      		  mostraSchermata("Home");
      	   }
      	   
         };
         view.getPulsanteHomeAreaChatFrame().addActionListener(gestoreChatFrameHome);
         
    	
    	gestoreInvioMessaggio = new ActionListener() {
     	   @Override
     	   public void actionPerformed(ActionEvent e) {
     		  scriviMessaggioPrivato();
     		  refresh();
     	   }
     	   
        };
        view.getInviaMessaggio().addActionListener(gestoreInvioMessaggio);
        
	    gestoreNextMessaggioButton = new ActionListener() {
	  	   @Override
	  	   public void actionPerformed(ActionEvent e) {
	  		   view.incrementaIndiceMessaggio();
	  		   view.aggiornaMessaggi(messaggi, model.getProfiloAttivo().getIdProfilo());
			   refresh();
	  	   }
	     };
         view.getNextMessaggioButton().addActionListener(gestoreNextMessaggioButton);   
         
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
    
    public void actionListenerCreaChatDiGruppo(){
    	
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
    	
    	gestoreHomeChatDiGruppo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeCreazioneChatDiGruppo().addActionListener(gestoreHomeChatDiGruppo);
    }
    
    public void  actionListenerChatDiGruppoFrame() {
    	gestoreHomeGruppoFrame = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeGruppo().addActionListener(gestoreHomeGruppoFrame);
    
    	gestoreInviaMessaggioGruppo = new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent e) {
    			String messaggio = view.getScriviMessaggioGruppo().getText();
    			model.getProfiloAttivo().scriviMessaggioGruppo(messaggio,  gruppoAttuale );
    		}
    	};
    	view.getInvia().addActionListener(gestoreInviaMessaggioGruppo);
	

		gestoreHomeChatDiGruppo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mostraSchermata("Home");
				}
			};
		view.getHomeCreazioneChatDiGruppo().addActionListener(gestoreHomeChatDiGruppo);
		
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
		
		gestoreAggiungiUtente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String utente = view.getUtenteDaAggiungere().getText();
				aggiungiPartecipante(gruppoAttuale, utente);
			}
		};
		view.getUtenteDaAggiungereButton().addActionListener(gestoreAggiungiUtente);
			
		gestoreRimuoviUtente = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String utente = view.getUtenteDaEliminare().getText();
				model.getProfiloAttivo().rimuoviPartecipante(gruppoAttuale, utente);
			}
		};
		view.getUtenteDaEliminareButton().addActionListener(gestoreRimuoviUtente);
		
		gestoreModificaDescrizioneChat = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nuovaDescrizione = view.getTestoDescrizioneNuova().getText();
				model.getProfiloAttivo().modificaDescrizione(gruppoAttuale, nuovaDescrizione);
			}
		};
		view.getModificaButton().addActionListener(gestoreModificaDescrizioneChat);
		
		gestorePartecipa = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				aggiungiPartecipante(gruppoAttuale, model.getProfiloAttivo().getIdProfilo());
			}
		};
		view.getPartecipazioneGruppoButton().addActionListener(gestorePartecipa);
		
		
		gestoreEsciGruppo = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rimuoviPartecipante(gruppoAttuale, model.getProfiloAttivo().getIdProfilo());
			}
		};
		view.getUscitaGruppoButton().addActionListener(gestoreEsciGruppo);
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
    
    public void pubblicaStory() {
   	 
    	String commentoPost = view.ottieniCommento();
    	String percorsoFilePost = view.ottieniPercorsoFile();
    	
    	model.getProfiloAttivo().pubblicaStoria(commentoPost, true, percorsoFilePost, false);
    }


    public boolean verificaTestoRicerca() {
        if(view.getTestoRicerca().equals("") || view.getTestoRicerca().equals("Inserire un username da cercare")) {
            return false;
        }
        return true;
    }

    public void oggettoDaCercare() {
        
    }
    
    public void aggiornaSchermataProfilo(String nickName, String descrizione, int numPost, int numFollower, int numSeguiti, String fotoProfiloPercorso, String idProfilo, ArrayList<String> postFotoProfilo, ArrayList<String> percorsiPostTesto, ArrayList<String> percorsiPostSondaggio, ArrayList<String>  percorsiPostSondaggioDoppiaScelta) throws PostNonVisibile {
    	view.setSchermataDati(numPost, numFollower, numSeguiti, nickName, descrizione);
        view.setFotoProfilo(fotoProfiloPercorso);
        view.setPostProfilo(postFotoProfilo);
        view.setPostTestoProfilo(percorsiPostTesto);
        view.setPostSondaggioProfilo(percorsiPostSondaggio);
        view.setPostSondaggioDoppiaSceltaProfilo(percorsiPostSondaggioDoppiaScelta);
        refresh();
    }
    
    public void settaPostVisualizzato(boolean condition) {
       // view.mostraBottoneSuperiore(false);
    }
    
    public void ricerca() {
        String risultatoRicerca = view.getTestoRicerca();
        view.getTestoRicercaInSchermataRicerca().setText(risultatoRicerca);
        view.impostaRisultatiRicerca(risultatoRicerca);
        model.ricerca(view.getTestoRicerca());
        refresh();
    }
    
    public void aggiungiCommento() {
    	String idProfilo = model.getProfiloAttivo().getIdProfilo();
    	String commentoDaAggiungere = view.getCommentoDaAggiungere().getText();
    	String idPost = view.getIdPostVisualizzato();
    	model.getProfiloAttivo().pubblicaCommento(idProfilo, idPost, commentoDaAggiungere, tipoPostAttuale);
    }
    
    public void mostraCommentiPost(String idPost) throws PostNonVisibile {
    	commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(idPost, tipoPostAttuale);
    	view.settaCommenti(commentiConProfiliIinvianti);
    }
    
    
    public void scriviMessaggioPrivato() {
    	String testoDaInviare = view.getScriviMessaggio().getText();
    	model.getProfiloAttivo().scriviMessaggioPrivato(testoDaInviare, model.getProfiloConCuiSiStaChattando().getIdProfilo());
    }
    public void aggiornaSchermataProfiloAttivo() {
    	String descrizione = model.getProfiloAttivo().getDescrizione();;
    	if(descrizione.equals("null")) {
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
    public void resettaGui() {
       
        commentiConProfiliIinvianti.clear();
        messaggiInviati.clear();
        postDelProfilo.clear();
        percorsiPostFoto.clear();
        percorsiPostTesto.clear();
        percorsiPostSondaggioSceltaMultipla.clear();
        listaGruppi.clear();
        
        try {
			model.setProfiloAttivo(model.getProfiloAttivo().cercaProfilo(model.getProfiloAttivo()));
		} catch (AccountDoesNotExist e) {
			e.printStackTrace();
		}
    }
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
	
	public void aggiungiDescrizione() {
    	String descrizione = view.getDescrizione().getText();
    	model.getProfiloAttivo().modificaDescrizione(descrizione);
    	model.getProfiloAttivo().setDescrizione(descrizione);
	}
	
	public void resetContatori() {
		view.setContatoreFoto(0);
		view.setContatoreSondaggio(0);
		view.setContatoreTesto(0);
	}
	
	public String ottieniPost(int indicePost) {
		String percorsoPost = "";
		
		try {
			percorsoPost = model.getProfiloAttivo().cercaPost(new Foto(postSchermataHome.get(indicePost))).getPercorso();
		} catch(PostNonVisibile | PostNonPresente e) {
			e.printStackTrace();
		}
		
		return percorsoPost;
	}
	
	public void rimuoviProfilo() {
		model.getProfiloAttivo().rimuoviQuestoProfilo();
	}
	
	public void settaSchermataGruppo(Gruppo g, ArrayList<String> commenti) {
		this.gruppoAttuale = g.getIdGruppo();
		view.setIdGruppo(g.getIdGruppo());
		view.aggiornaMessaggiGruppo(commenti);
	}

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
	public void aggiungiPartecipante(String idGruppo, String utente) {
		try {
			model.getProfiloAttivo().aggiungiPartecipante(idGruppo, utente);
		} catch (GruppoGiaPieno e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (ProfiloGiaInserito e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	public void rimuoviPartecipante(String idGruppo, String utente) {
		model.getProfiloAttivo().rimuoviPartecipante(idGruppo, utente);
	}
	
	public void visualizzaPostTesto(int indicePostTesto) {
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
    	tipoPostAttuale = TipoPost.TESTO;
    	view.getImpostaImmagineProfiloButton().setVisible(false);
    	view.setPostVisualizzato(model.getProfiloAttivo().getPostTestoPerController().getIdPost(),
    							 null, 
    							 model.getProfiloAttivo().getPostTestoPerController().getDescrizione(), 
    							 model.getProfiloAttivo().getPostTestoPerController().getNumLike(), 
    							 model.getProfiloAttivo().getPostTestoPerController().getNumDislike(), 
    							 commentiConProfiliIinvianti.size(), 
    							 commentiConProfiliIinvianti);
        mostraSchermata("Postvisualizzato");
        refresh();
	}
	
	public void visualizzaPostFoto(int indicePostFoto) {
        settaPostVisualizzato(false);
        try {
			try {
				model.getProfiloAttivo().setPostFotoPerController((Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(indicePostFoto))));
			} catch (PostNonPresente e1) {
				e1.printStackTrace();
			}
		} catch (PostNonVisibile e1) {
			e1.printStackTrace();
		}
    	tipoPostAttuale = TipoPost.FOTO;

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
        refresh(); 
	}
	
	public void visualizzaPostSondaggioSceltaMultipla(int indicePostSondaggio) {
		try {
			model.getProfiloAttivo().setPostSondaggioSceltaMultiplaPerController((SondaggioSceltaMultipla) model.getProfiloAttivo().cercaPost(new SondaggioSceltaMultipla(percorsiPostSondaggioSceltaMultipla.get(indicePostSondaggio), null, false, null, null, null, null, null)));
		} catch (PostNonVisibile | PostNonPresente e1) {
			e1.printStackTrace();
		}
		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;

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
		mostraSchermata("Postvisualizzato");
	}
	
	public void visualizzaPostSondaggioDoppiaScelta(int indicePostSondaggio) {
		try {
			model.getProfiloAttivo().setPostSondaggioDoppiaScelta((SondaggioDoppiaVotazione) model.getProfiloAttivo().cercaPost(new SondaggioDoppiaVotazione(percorsiPostSondaggioDoppiaScelta.get(indicePostSondaggio), null, false, null, null, null)));
		} catch (PostNonVisibile | PostNonPresente e1) {
			e1.printStackTrace();
		}
		tipoPostAttuale = TipoPost.SONDAGGIODOPPIAVOTAZIONE;
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
		mostraSchermata("Postvisualizzato");
		refresh();
	}



}