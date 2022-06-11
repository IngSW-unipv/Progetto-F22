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
                           gestoreQuintaChatGruppo, gestorePrimaChatPrivata, gestoreSecondaChatPrivata, gestoreTerzaChatPrivata, gestoreQuartaChatPrivata, 
                           gestoreQuintaChatPrivata, gestoreNextCommento, gestorePrevCommento, gestorePubblicaSoloTesto,gestoreProfiloCercato,
                           gestorePulsanteSegui, gestoreApriChat,gestoreInvioMessaggio,gestoreNextMessaggioButton,gestorePrevMessaggioButton,gestorePubblicaSondaggioDoppiaVotazione, gestorePubblicaSondaggioSceltaMultipla,
                           gestorePost1, gestorePost2, gestorePost3, gestoreSondaggio1, gestoreSondaggio2, gestoreSondaggio3,
                           gestoreChatFrameHome, gestoreCreaUnaChatDiGruppoHome, gestoreCreaChatDiGruppo, gestoreHomeChatDiGruppo, gestorePubblicaStory,
                           gestoreSalvaLeModifiche, gestoreNextFoto, gestorePrevFoto, gestoreNextTesto, gestorePrevTesto, gestoreNextSondaggio, gestorePrevSondaggio,
                           gestorePulsantePrimaScelta, gestorePulsanteSecondaScelta, gestorePulsanteTerzaScelta, gestorePulsanteQuartaScelta, gestorePostPrecedente, gestorePostSuccessivo,
                           gestorePulsantePrimoTesto,gestorePulsanteSecondoTesto,gestorePulsanteTerzoTesto, gestorePulsanteFotoHome, gestoreHomeGruppoFrame, gestoreInviaMessaggioGruppo;
    Frame view;
    Sistema model;
    
    private String schermataAttuale = "Login";
    private String gruppoAttuale = "";
    private int postAttuale = -1,basePostAttuale = 0;
    private ArrayList<String> commentiConProfiliIinvianti = new ArrayList<String>();
    private ArrayList<String> messaggiInviati = new ArrayList<String>();
    private ArrayList<String> messaggiInviatiGruppoConInviante = new ArrayList<String>();

    private ArrayList<String> postSchermataHome = new ArrayList<String>();
    private ArrayList<String> postDelProfilo = new ArrayList<String>();
    private ArrayList<String> percorsiPostFoto = new ArrayList<String>();
    private ArrayList<String> percorsiPostTesto = new ArrayList<String>();
    private ArrayList<String> percorsiPostSondaggio = new ArrayList<String>();
    private ArrayList<String> listaGruppi = new ArrayList<String>();
    
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
                if (login()) {
                	postSchermataHome = model.getProfiloAttivo().caricaPostProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
                	if(postSchermataHome.size() == 0) {
                		mostraSchermata("Home");
                	} else {
                		view.setPercorsoPost(ottieniPost(0));
                		view.aggiornaPostHome();
                    	mostraSchermata("Home");
                	}
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
            }
        };
        view.getPostPrincipale().addActionListener(gestorePulsanteFotoHome);
        
        
        
    	gestorePostSuccessivo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                view.setContatorePost(view.getContatorePost() + 1);
            	postSchermataHome = model.getProfiloAttivo().caricaPostProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
            	view.rimuoviPostHome();
            	view.setPercorsoPost(ottieniPost(view.getContatorePost()));
            	view.aggiornaPostHome();
            	refresh();
            }
        };
        view.getButtonNextPost().addActionListener(gestorePostSuccessivo);
        
        gestorePostPrecedente = new ActionListener() {
            @Override
             public void actionPerformed(ActionEvent e) {
            	view.setContatorePost(view.getContatorePost() - 1);
            	postSchermataHome = model.getProfiloAttivo().caricaPostProfiliSeguiti(model.getProfiloAttivo().getIdProfilo(), TipoPost.FOTO);
               	view.rimuoviPostHome();
            	view.setPercorsoPost(ottieniPost(view.getContatorePost()));
            	view.aggiornaPostHome();
            	refresh();
            }
        };
        view.getButtonPrevPost().addActionListener(gestorePostPrecedente);      
        
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

    }
    
    public void actionListenersProfilo() {
        gestoreHomeProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	resetContatori();
                mostraSchermata("Home");
            }
        };
        view.getHomeProfiloButton().addActionListener(gestoreHomeProfilo);
        
        gestoreApriChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	model.setProfiloConCuiSiStaChattando(model.getProfiloCercato());
            	messaggi = model.getProfiloAttivo().cercaMessaggiChatPrivata(model.getProfiloAttivo().getIdProfilo(), model.getProfiloConCuiSiStaChattando().getIdProfilo());
            	view.aggiornaMessaggi(messaggi, model.getProfiloAttivo().getIdProfilo());
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
			/*	} catch (FollowYourself e1) {
					e1.printStackTrace();
				}*/
            }
        };
        view.getPulsanteSegui().addActionListener(gestorePulsanteSegui);
        
        gestoreFotoProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloAttivo().getFotoProfilo()));
				} catch (PostNonPresente| PostNonVisibile e1) {
					 f.setPercorso("immagini/images.png"); 
				}
                
                visualizzaPostFoto(f);
                mostraSchermata("Postvisualizzato");
                refresh();
            }
        };
        view.getPulsanteFotoProfilo().addActionListener(gestoreFotoProfilo);
        
        gestorePulsantePrimoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	settaPostVisualizzato(false);
                Testo t = new Testo(null);
                
                try {
					t = (Testo) model.getProfiloAttivo().cercaPost(new Testo(percorsiPostTesto.get(0 + view.getContatoreTesto())));
					
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				} catch (PostNonPresente e1) {
					e1.printStackTrace();
				}
            	try {
					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(t.getIdPost());
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}

            	view.getImpostaImmagineProfiloButton().setVisible(false);
                view.setPostVisualizzato(t.getIdPost(), null, t.getDescrizione(), t.getNumLike(), t.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
            }
        };
        view.getPulsantePrimoTesto().addActionListener(gestorePulsantePrimoTesto);
        
        gestorePulsanteSecondoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	settaPostVisualizzato(false);
                Testo t = new Testo(null);
                
                try {
					t = (Testo) model.getProfiloAttivo().cercaPost(new Testo(percorsiPostTesto.get(2+ view.getContatoreTesto())));
					
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				} catch (PostNonPresente e1) {
				} 
            	try {

					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(t.getIdPost());
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	view.getImpostaImmagineProfiloButton().setVisible(false);
                view.setPostVisualizzato(t.getIdPost(), null, t.getDescrizione(), t.getNumLike(), t.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();    
            }
        };
        view.getPulsanteSecondoTesto().addActionListener(gestorePulsanteSecondoTesto);
        
        gestorePulsanteTerzoTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	settaPostVisualizzato(false);
                Testo t = new Testo(null);
                
                try {
					t = (Testo) model.getProfiloAttivo().cercaPost(new Testo(percorsiPostTesto.get(4 + view.getContatoreTesto())));
					
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				} catch (PostNonPresente e1) {
					e1.printStackTrace();
				}
            	try {

					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(t.getIdPost());
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}

            	view.getImpostaImmagineProfiloButton().setVisible(false);
                view.setPostVisualizzato(t.getIdPost(), null, t.getDescrizione(), t.getNumLike(), t.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
            }
        };
        view.getPulsanteTerzoTesto().addActionListener(gestorePulsanteTerzoTesto);
        
        
        
        
        gestorePost1 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					try {
						f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(0 + view.getContatoreFoto())));
					} catch (PostNonPresente e1) {
						e1.printStackTrace();
					}
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	try {

					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(f.getIdPost());
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}

            	for(int i=0; i < commentiConProfiliIinvianti.size(); i++) {
            		System.out.println(commentiConProfiliIinvianti.get(i));
            	}


            	view.getImpostaImmagineProfiloButton().setVisible(true);
            	view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();    
        	}
        };
        view.getPost1().addActionListener(gestorePost1);
        
        gestorePost2 = new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
                    settaPostVisualizzato(false);
                    Foto f = new Foto(null);
                    
                    try {
    					try {
							f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(2 + view.getContatoreFoto())));
						} catch (PostNonPresente e1) {
							e1.printStackTrace();
						}
    				} catch (PostNonVisibile e1) {
    					e1.printStackTrace();
    				}
                	try {

    					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(f.getIdPost());
    				} catch (PostNonVisibile e1) {
    					e1.printStackTrace();
    				}
            		System.out.println(f.getIdPost());

                	for(int i=0; i < commentiConProfiliIinvianti.size(); i++) {
                		System.out.println(commentiConProfiliIinvianti.get(i));
                	}

                	view.getImpostaImmagineProfiloButton().setVisible(true);
                    view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                    mostraSchermata("Postvisualizzato");
                    refresh();
        	}
        };
        view.getPost2().addActionListener(gestorePost2);
        
        
        gestorePost3 = new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
                    settaPostVisualizzato(false);
                    Foto f = new Foto(null);
                    
                    try {
    					try {
							f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(4 + view.getContatoreFoto())));
						} catch (PostNonPresente e1) {
							e1.printStackTrace();
						}
    				} catch (PostNonVisibile e1) {
    					e1.printStackTrace();
    				}
                	try {

    					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(f.getIdPost());
    				} catch (PostNonVisibile e1) {
    					e1.printStackTrace();
    				}
                	view.getImpostaImmagineProfiloButton().setVisible(true);


                    view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                    mostraSchermata("Postvisualizzato");
                    refresh();
        	}
        };
        view.getPost3().addActionListener(gestorePost3);
        
        
        gestoreSondaggio1 = new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
        		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(schermataAttuale, schermataAttuale, false, schermataAttuale, schermataAttuale, schermataAttuale, schermataAttuale, schermataAttuale);
        		try {
        			s = (SondaggioSceltaMultipla) model.getProfiloAttivo().cercaPost(new SondaggioSceltaMultipla(percorsiPostSondaggio.get(0), null, false, null, null, null, null, null));
				} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		try {

					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(s.getIdPost());
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
        		
            	view.getImpostaImmagineProfiloButton().setVisible(false);
        		view.settaSondaggioVisualizzato(s.getIdPost(), s.getDescrizione(), s.getPrimaScelta(), s.getSecondaScelta(), s.getTerzaScelta(), s.getQuartaScelta(), s.getNumLike(), s.getNumDislike(), 0, commentiConProfiliIinvianti);
                refresh();
        		mostraSchermata("Postvisualizzato");
        	}
        };
        view.getPulsantePrimoSondaggio().addActionListener(gestoreSondaggio1);
        
        gestoreSondaggio2 = new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
        		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(schermataAttuale, schermataAttuale, false, schermataAttuale, schermataAttuale, schermataAttuale, schermataAttuale, schermataAttuale);
        		try {
        			s = (SondaggioSceltaMultipla) model.getProfiloAttivo().cercaPost(new SondaggioSceltaMultipla(percorsiPostSondaggio.get(2), null, false, null, null, null, null, null));
				} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		try {

					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(s.getIdPost());
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	view.getImpostaImmagineProfiloButton().setVisible(false);
        		view.settaSondaggioVisualizzato(s.getIdPost(), s.getDescrizione(), s.getPrimaScelta(), s.getSecondaScelta(), s.getTerzaScelta(), s.getQuartaScelta(), s.getNumLike(), s.getNumDislike(), 0, commentiConProfiliIinvianti);
                refresh();
        		mostraSchermata("Postvisualizzato");
        	}
        };
        view.getPulsanteSecondoSondaggio().addActionListener(gestoreSondaggio2);
        
        gestoreSondaggio3 = new ActionListener() {
        	@Override
        		public void actionPerformed(ActionEvent e) {
        		SondaggioSceltaMultipla s = new SondaggioSceltaMultipla(schermataAttuale, schermataAttuale, false, schermataAttuale, schermataAttuale, schermataAttuale, schermataAttuale, schermataAttuale);
        		try {
        			s = (SondaggioSceltaMultipla) model.getProfiloAttivo().cercaPost(new SondaggioSceltaMultipla(percorsiPostSondaggio.get(4), null, false, null, null, null, null, null));
				} catch (PostNonVisibile | PostNonPresente e1) {
					e1.printStackTrace();
				}
        		try {

					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(s.getIdPost());
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	view.getImpostaImmagineProfiloButton().setVisible(false);

        		view.settaSondaggioVisualizzato(s.getIdPost(), s.getDescrizione(), s.getPrimaScelta(), s.getSecondaScelta(), s.getTerzaScelta(), s.getQuartaScelta(), s.getNumLike(), s.getNumDislike(), 0, commentiConProfiliIinvianti);
                refresh();
        		mostraSchermata("Postvisualizzato");
        	}
        };
        view.getPulsanteTerzoSondaggio().addActionListener(gestoreSondaggio3);
        

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
        		//Decrementa contatore testo
        		view.setContatoreTesto(view.getContatoreTesto() - 2);
        		view.setPostTestoProfilo(percorsiPostTesto);
        	}
        };
        view.getPrevTesto().addActionListener(gestorePrevTesto);
        
        gestoreNextSondaggio = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreSondaggio(view.getContatoreSondaggio() + 2);
        		view.setPostSondaggioProfilo(percorsiPostSondaggio);
        	}
        };
        view.getNextSondaggio().addActionListener(gestoreNextSondaggio);
        
        gestorePrevSondaggio = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		view.setContatoreSondaggio(view.getContatoreSondaggio() - 2);
        		view.setPostSondaggioProfilo(percorsiPostSondaggio);
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
            	//model.pubblicaTesto("mi piace la fava", false, null, null, null);   
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
                String nickName = model.getProfiloCercato().getNickname();
            	int numPost = model.getProfiloCercato().getNumPost();
                int numFollower = model.getProfiloCercato().getNumFollower();
                int numSeguiti = model.getProfiloCercato().getNumSeguiti();
                String idProfilo = model.getProfiloCercato().getIdProfilo();
                String percorsoFotoProfilo = null;
                postDelProfilo = model.getProfiloCercato().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.FOTO);
                percorsiPostTesto = model.getProfiloCercato().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.TESTO);
                percorsiPostSondaggio = model.getProfiloCercato().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.SONDAGGIOSCELTAMULTIPLA);
                
            
                try {
                	percorsoFotoProfilo = (String)model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloCercato().getFotoProfilo())).getPercorso();
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				} catch (PostNonPresente e2) {
					 percorsoFotoProfilo = "immagini/images.png";
					e2.printStackTrace();
				}
                
                try {
					aggiornaSchermataProfilo(nickName, numPost, numFollower, numSeguiti, percorsoFotoProfilo, idProfilo,  postDelProfilo, percorsiPostTesto, percorsiPostSondaggio);
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
                view.getPulsanteSegui().setVisible(true);
                view.getApriChat().setVisible(true);
            	mostraSchermata("Profilo");
            }
        };
        view.getPulsanteRicercaProfilo().addActionListener(gestoreProfiloCercato);
        
    }
    
    
    public void actionListenersChat() {
        gestoreHomeChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeChatButton().addActionListener(gestoreHomeChat);
     
        
        gestoreAggiornaChat = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("AggiornaChat");
        	}
        };
        view.getAggiornaChatButton().addActionListener(gestoreAggiornaChat);
        
        gestorePrimaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		Gruppo g = model.getProfiloAttivo().cercaGruppo(new Gruppo(listaGruppi.get(0)));
        		settaSchermataGruppo(g);
        		mostraSchermata("ChatDiGruppoFrame");
        	}
        };
        view.getPrimaChatGruppoButton().addActionListener(gestorePrimaChatGruppo);
        
        gestoreSecondaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Seconda chat gruppo");
        	}
        };
        view.getSecondaChatGruppoButton().addActionListener(gestoreSecondaChatGruppo);
        
        
        gestoreTerzaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Terza chat gruppo");
        	}
        };
        view.getTerzaChatGruppoButton().addActionListener(gestoreTerzaChatGruppo);
        
        gestoreQuartaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Quarta chat gruppo");
        	}
        };
        view.getQuartaChatGruppoButton().addActionListener(gestoreQuartaChatGruppo);
        
        gestoreQuintaChatGruppo = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Quinta chat gruppo");
        	}
        };
        view.getQuintaChatGruppoButton().addActionListener(gestoreQuintaChatGruppo);
        
        gestorePrimaChatPrivata = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Prima chat privata");
        	}
        };
        view.getPrimaChatPrivataButton().addActionListener(gestorePrimaChatPrivata);
        
        gestoreSecondaChatPrivata = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Seconda chat privata");
        	}
        };
        view.getSecondaChatPrivataButton().addActionListener(gestoreSecondaChatPrivata);
        
        gestoreTerzaChatPrivata = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Terza chat privata");
        	}
        };
        view.getTerzaChatPrivataButton().addActionListener(gestoreTerzaChatPrivata);
        
        gestoreQuartaChatPrivata = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Quarta chat privata");
        	}
        };
        view.getQuartaChatPrivataButton().addActionListener(gestoreQuartaChatPrivata);
        
        gestoreQuintaChatPrivata = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		System.out.println("Quinta chat privata");
        	}
        };
        view.getQuintaChatPrivataButton().addActionListener(gestoreQuintaChatPrivata);
        
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
        
        /*  
        gestoreIniziaSeguire = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("Inizia a seguire");
            }
        };
        view.getIniziaSeguireButton().addActionListener(gestoreIniziaSeguire);
        
         */

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
    	   }
       };
       view.getAggiungiLikeButtonFrame().addActionListener(gestoreAggiungiLikePost);
       
       gestoreAggiungiDislikePost = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
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
    		   refresh();
    		
    	   }
       };
       view.getPrevCommento().addActionListener(gestorePrevCommento);    
       
       gestorePulsantePrimaScelta = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   try {
   				model.getProfiloAttivo().aggiungiVotoSondaggio(view.getPostVisualizzato().getIdPost(), 1);
   					} catch (TastoNonEsistente | PostNonVisibile | PostNonPresente e1) {
   				}
    	   }
       };
       view.getPulsantePrimaScelta().addActionListener(gestorePulsantePrimaScelta);
       
       gestorePulsanteSecondaScelta = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   try {
   				model.getProfiloAttivo().aggiungiVotoSondaggio(view.getPostVisualizzato().getIdPost(), 2);
   			} catch (TastoNonEsistente | PostNonVisibile | PostNonPresente e1) {
   			}
    	   }
       };
       view.getPulsanteSecondaScelta().addActionListener(gestorePulsanteSecondaScelta);
       
       gestorePulsanteTerzaScelta = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   try {
   				model.getProfiloAttivo().aggiungiVotoSondaggio(view.getPostVisualizzato().getIdPost(), 3);
   			} catch (TastoNonEsistente | PostNonVisibile | PostNonPresente e1) {
   			}
    	   }
       };
       view.getPulsanteTerzaScelta().addActionListener(gestorePulsanteTerzaScelta);
       
       gestorePulsanteQuartaScelta = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   try {
				model.getProfiloAttivo().aggiungiVotoSondaggio(view.getPostVisualizzato().getIdPost(), 4);
			} catch (TastoNonEsistente | PostNonVisibile | PostNonPresente e1) {
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
    			String immagineGruppo = view.getPercorsoImmagineGruppo();
    			try {
    				
    				model.getProfiloAttivo().creaGruppo( descrizioneGruppo, nomeGruppo, model.getProfiloAttivo().getIdProfilo(), null, null, null, null, null, model.getProfiloAttivo().getIdProfilo(), immagineGruppo);
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
            model.getProfiloAttivo().pubblicaFoto(commentoPost, true, false, model.getProfiloAttivo().getIdProfilo(), percorsoFilePost, false);
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
   	 
    	int idPostInt = (int)Math.round(Math.random() * 1000);
 		String idPost = "F" + Integer.toString(idPostInt);
    	String commentoPost = view.ottieniCommento();
    	String percorsoFilePost = view.ottieniPercorsoFile();
    	Foto f = new Foto(idPost, commentoPost, true, model.getProfiloAttivo().getIdProfilo(), percorsoFilePost, true);
    	
    	model.getProfiloAttivo().pubblicaStoria(24, f);
    }


    public boolean verificaTestoRicerca() {
        if(view.getTestoRicerca().equals("") || view.getTestoRicerca().equals("Inserire un username da cercare")) {
            return false;
        }
        return true;
    }

    public void oggettoDaCercare() {
        
    }
    
    public void aggiornaSchermataProfilo(String nickName, int numPost, int numFollower, int numSeguiti, String fotoProfiloPercorso, String idProfilo, ArrayList<String> postFotoProfilo, ArrayList<String> percorsiPostTesto, ArrayList<String> percorsiPostSondaggio) throws PostNonVisibile {
    	view.setSchermataDati(numPost, numFollower, numSeguiti, nickName);
        view.setFotoProfilo(fotoProfiloPercorso);
        view.setPostProfilo(postFotoProfilo);
        view.setPostTestoProfilo(percorsiPostTesto);
        view.setPostSondaggioProfilo(percorsiPostSondaggio);
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
    	model.getProfiloAttivo().pubblicaCommento(idProfilo, idPost, commentoDaAggiungere);
    }
    
    public void mostraCommentiPost(String idPost) throws PostNonVisibile {
    	commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(idPost);
    	view.settaCommenti(commentiConProfiliIinvianti);
    }
    
    public void scriviMessaggioPrivato() {
    	String testoDaInviare = view.getScriviMessaggio().getText();
    	model.scriviMessaggio(testoDaInviare, null, model.getProfiloAttivo().getIdProfilo(), model.getProfiloConCuiSiStaChattando().getIdProfilo());
    }
    public void aggiornaSchermataProfiloAttivo() {
    	String nickName = model.getProfiloAttivo().getNickname();
    	int numPost = model.getProfiloAttivo().getNumPost();
        int numFollower = model.getProfiloAttivo().getNumFollower();
        int numSeguiti = model.getProfiloAttivo().getNumSeguiti();
        String idProfilo = model.getProfiloAttivo().getIdProfilo();
        postDelProfilo = model.getProfiloAttivo().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.FOTO);
        percorsiPostTesto = model.getProfiloAttivo().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.TESTO);
        percorsiPostSondaggio = model.getProfiloAttivo().caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.SONDAGGIOSCELTAMULTIPLA);

        String fotoProfiloPercorso = null;
        
        for(int i =0; i < percorsiPostTesto.size() ; i++) {
        	System.out.println("testi :"+ percorsiPostTesto.size());
        }
        
        try {
    	   fotoProfiloPercorso = ((Foto)model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloAttivo().getFotoProfilo()))).getPercorso();
        } catch (PostNonVisibile | PostNonPresente e1) {
    	   fotoProfiloPercorso = "immagini/images.png";
        } 
        try {
			aggiornaSchermataProfilo(nickName, numPost, numFollower, numSeguiti, fotoProfiloPercorso, idProfilo, postDelProfilo,percorsiPostTesto, percorsiPostSondaggio);
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
        percorsiPostSondaggio.clear();
        listaGruppi.clear();
        
        try {
			model.setProfiloAttivo(model.getProfiloAttivo().cercaProfilo(model.getProfiloAttivo()));
		} catch (AccountDoesNotExist e) {
			e.printStackTrace();
		}
    }
    public void visualizzaPostFoto(Foto f) {
    	  
      		try {
				commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(f.getIdPost());
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
	public void settaSchermataGruppo(Gruppo g) {
		this.gruppoAttuale = g.getIdGruppo();
		view.getDescrizioneGroupe().setText(g.getDescrizione());
		messaggiInviatiGruppoConInviante = model.getProfiloAttivo().caricaMessaggiChatGruppoConProfiloInviante(gruppoAttuale);
		for(int i=0; i <messaggiInviatiGruppoConInviante.size(); i++ ) {
		}
	}
}