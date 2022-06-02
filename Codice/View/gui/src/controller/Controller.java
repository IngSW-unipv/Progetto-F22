package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import Sistema.Sistema;
import packageframe.Frame;
import panelspackage.panels.PostVisualizzato;
import post.enumeration.TipoPost;
import post.multimedia.foto.Foto;
import profilo.exception.*;

public class Controller {
    private ActionListener gestoreLogin, gestoreSignUp, gestoreImpostazioni, gestoreRegistrati, gestoreProfilo,
                           gestoreChat, gestoreHomeImpostazioni, gestoreHomeProfilo,
                           gestoreHomeChat, gestoreHomePannelloNotifiche, gestoreCreazionePostFoto, gestoreHomeCreazionePost,
                           gestoreLogOut,gestorePubblicaPost, gestoreModificaProfilo, gestoreVisibilitaPost, gestoreEliminaAccount,
                           gestoreCerca, gestoreHomeCerca, gestoreFotoProfilo, gestoreIndietroSignup,gestoreHomePostVisualizzato,
                           gestoreAggiungiCommento, gestoreImpostaFotoProfilo, gestoreIniziaSeguire, gestoreAggiungiLikePost, gestoreAggiungiDislikePost,
                           gestoreAggiornaChat, gestorePrimaChatGruppo, gestoreSecondaChatGruppo, gestoreTerzaChatGruppo, gestoreQuartaChatGruppo, 
                           gestoreQuintaChatGruppo, gestorePrimaChatPrivata, gestoreSecondaChatPrivata, gestoreTerzaChatPrivata, gestoreQuartaChatPrivata, 
                           gestoreQuintaChatPrivata, gestoreNextCommento, gestorePrevCommento, gestorePubblicaSoloTesto,gestoreProfiloCercato,
                           gestorePulsanteSegui, gestoreApriChat,gestoreInvioMessaggio,gestoreNextMessaggioButton,gestorePrevMessaggioButton,gestorePubblicaSondaggioDoppiaVotazione, gestorePubblicaSondaggioSceltaMultipla,
                           gestorePost1, gestorePost2, gestorePost3, gestorePost4, gestorePost5, gestorePost6, gestorePost7, gestorePost8, gestorePost9,
                           gestoreChatFrameHome;
    Frame view;
    Sistema model;
    
    private String schermataAttuale = "Login";
    private int postAttuale = -1,basePostAttuale = 0;
    private String tipoPostDaPubblicare = null;
    private ArrayList<String> commentiConProfiliIinvianti = new ArrayList<String>();
    private ArrayList<String> messaggiInviati = new ArrayList<String>();
    private ArrayList<String> postDelProfilo = new ArrayList<String>();
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

                        String nickName = model.getProfiloAttivo().getNickname();
                    	int numPost = model.getProfiloAttivo().getNumPost();
                        int numFollower = model.getProfiloAttivo().getNumFollower();
                        int numSeguiti = model.getProfiloAttivo().getNumSeguiti();
                        String idProfilo = model.getProfiloAttivo().getIdProfilo();

                        String fotoProfiloPercorso = null;
                        System.out.println("id:" + model.getProfiloAttivo().getFotoProfilo());
                       try {
                            fotoProfiloPercorso = ((Foto)model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloAttivo().getFotoProfilo()))).getPercorso();
                       } catch (PostNonVisibile errore1) {
                       
                       } 
                        try {
							aggiornaSchermataProfilo(nickName, numPost, numFollower, numSeguiti, fotoProfiloPercorso, idProfilo);
						} catch (PostNonVisibile e1) {
							e1.printStackTrace();
						}
                        refresh();
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
        
    }
    
    public void actionListenersProfilo() {
        gestoreHomeProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeProfiloButton().addActionListener(gestoreHomeProfilo);
        
        gestoreApriChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	model.setProfiloConCuiSiStaChattando(model.getProfiloCercato());
            	 messaggi = model.cercaMessaggiChatPrivata(model.getProfiloAttivo().getIdProfilo(), model.getProfiloConCuiSiStaChattando().getIdProfilo());
            	view.aggiornaMessaggi(messaggi, model.getProfiloAttivo().getIdProfilo());
            	refresh();
            	mostraSchermata("AreaChatFrame");
            }
        };
        view.getApriChat().addActionListener(gestoreApriChat);
        
        
        
        gestorePulsanteSegui = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	System.out.println("hai seguito");
            	try {
					model.getProfiloAttivo().segui(model.getProfiloCercato());
				} catch (AccountDoesNotExist e1) {
					e1.printStackTrace();
				} catch (AzioneNonConsentita e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
        };
        view.getPulsanteSegui().addActionListener(gestorePulsanteSegui);
        
        
        gestoreFotoProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(model.getProfiloAttivo().getFotoProfilo()));
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
            	try {
					commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(f.getIdPost());
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}


                view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
            }
        };
        view.getPulsanteFotoProfilo().addActionListener(gestoreFotoProfilo);
        
        gestorePost1 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(0 + getBasePostAttuale())));
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
    					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(2 + getBasePostAttuale())));
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
    					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(4 + getBasePostAttuale())));
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


                    view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                    mostraSchermata("Postvisualizzato");
                    refresh();
        	}
        };
        view.getPost3().addActionListener(gestorePost3);
        
        gestorePost4 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(6 + getBasePostAttuale())));
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


                view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
        	}
        };
        view.getPost4().addActionListener(gestorePost4);
        
        gestorePost5 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(8 + getBasePostAttuale())));
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


                view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
        	}
        };
        view.getPost5().addActionListener(gestorePost5);
        
        gestorePost6 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(10 + getBasePostAttuale())));
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


                view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
        	}
        };
        view.getPost6().addActionListener(gestorePost6);
        
        gestorePost7 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(12 + getBasePostAttuale())));
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


                view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
        	}
        };
        view.getPost7().addActionListener(gestorePost7);
        
        gestorePost8= new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(14 + getBasePostAttuale())));
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


                view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
        	}
        };
        view.getPost8().addActionListener(gestorePost8);
        
        gestorePost9 = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato(false);
                Foto f = new Foto(null);
                
                try {
					f = (Foto) model.getProfiloAttivo().cercaPost(new Foto(postDelProfilo.get(16 + getBasePostAttuale())));
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


                view.setPostVisualizzato(f.getIdPost(), f.getPercorso(), f.getDescrizione(), f.getNumLike(), f.getNumDislike(), commentiConProfiliIinvianti.size(), commentiConProfiliIinvianti);
                mostraSchermata("Postvisualizzato");
                refresh();
        	}
        };
        view.getPost9().addActionListener(gestorePost9);
        
    }
    
    public void actionListenersCreazionePost() {
    	//ActionListeners schermata CreazionePost
        gestoreCreazionePostFoto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	setPostAttuale(0);
            	System.out.println("hai cliccato Post Foto");
            	view.getFileChooser().setVisible(true);
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
        
        gestorePubblicaSoloTesto = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	//model.pubblicaTesto("mi piace la fava", false, null, null, null);   
            	setPostAttuale(1);
            	view.getFileChooser().setVisible(false);
            	mostraSchermata("CreazionePost");
            }
        };
        view.getPIdeaButton().addActionListener(gestorePubblicaSoloTesto);
        
        gestorePubblicaSondaggioDoppiaVotazione = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setPostAttuale(2);
            	view.getFileChooser().setVisible(false);
            	mostraSchermata("CreazionePost");
        	}
        };
        view.getPSondaggioDoppiaVotazioneButton().addActionListener(gestorePubblicaSondaggioDoppiaVotazione);
        
        gestorePubblicaSondaggioSceltaMultipla = new ActionListener() {
        	@Override
        	public void actionPerformed(ActionEvent e) {
        		setPostAttuale(3);
            	view.getFileChooser().setVisible(false);
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
                String fotoProfilo = model.getProfiloCercato().getFotoProfilo();
                String idProfilo = model.getProfiloCercato().getIdProfilo();
                try {
					aggiornaSchermataProfilo(nickName, numPost, numFollower, numSeguiti, fotoProfilo, idProfilo);
				} catch (PostNonVisibile e1) {
					e1.printStackTrace();
				}
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
        		System.out.println("Prima chat gruppo");
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
                mostraSchermata("Home");
                aggiungiCommento();
            }
        };
        view.getHomePostVisualizzatoButton().addActionListener(gestoreHomePostVisualizzato);
    
        gestoreImpostaFotoProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.impostaFotoProfilo(((PostVisualizzato)view.mappaSchermate.get("Postvisualizzato")).getIdPost());
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
    		   System.out.println("Aggiunto like");
    	   }
       };
       view.getAggiungiLikeButtonFrame().addActionListener(gestoreAggiungiLikePost);
       
       gestoreAggiungiDislikePost = new ActionListener() {
    	   @Override
    	   public void actionPerformed(ActionEvent e) {
    		   System.out.println("Aggiunto dislike");
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
      		   
      		   for (int i = 0; i < messaggi.size(); i++) {
          		   System.out.println(messaggi.get(i));
      		   }
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

            model.pubblicaFoto(commentoPost, true, false, model.getProfiloAttivo().getIdProfilo(), percorsoFilePost, false);
        }
        else if(getPostAttuale() == 1) {
    
        	model.pubblicaTesto(commentoPost, false, model.getProfiloAttivo().getIdProfilo(), null, null);
        }
        else if(getPostAttuale() == 2) {
        	String scelta1 = view.getPrimaScelta().getText();
        	String scelta2 = view.getSecondaScelta().getText();
        	model.pubblicaSondaggioDoppiaVotazione(commentoPost, true, model.getProfiloAttivo().getIdProfilo(), scelta1, scelta2, null);
        }
        
        else if (getPostAttuale() == 3) {
        	String scelta1 = view.getPrimaScelta().getText();
        	String scelta2 = view.getSecondaScelta().getText();
        	String scelta3 = view.getTerzaScelta().getText();
        	String scelta4 = view.getQuartaScelta().getText();
        	model.pubblicaSondaggioSceltaMultipla(commentoPost, true, model.getProfiloAttivo().getIdProfilo(), scelta1, scelta2, scelta3, scelta4);
        }
    }

    public boolean verificaTestoRicerca() {
        if(view.getTestoRicerca().equals("") || view.getTestoRicerca().equals("Inserire un username da cercare")) {
            return false;
        }
        return true;
    }

    public void oggettoDaCercare() {
        
    }
    
    public void aggiornaSchermataProfilo(String nickName, int numPost, int numFollower, int numSeguiti, String fotoProfiloPercorso, String idProfilo) throws PostNonVisibile {
    	view.getEtichettaNome().setText(nickName);
        view.setSchermataDati(numPost, numFollower, numSeguiti);
        view.setFotoProfilo(fotoProfiloPercorso);
        postDelProfilo = model.caricaTuttiiPostDiUnProfilo(idProfilo, TipoPost.FOTO);
        view.setPostProfilo(postDelProfilo);
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
    	model.carica(idProfilo, idPost, commentoDaAggiungere);
    }
    
    public void mostraCommentiPost(String idPost) throws PostNonVisibile {
    	commentiConProfiliIinvianti = model.selectAllCommentiSottoPost(idPost);
    	view.settaCommenti(commentiConProfiliIinvianti);
    }
    
    public void scriviMessaggioPrivato() {
    	String testoDaInviare = view.getScriviMessaggio().getText();
    	model.scriviMessaggio(testoDaInviare, null, model.getProfiloAttivo().getIdProfilo(), model.getProfiloConCuiSiStaChattando().getIdProfilo());
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
	
}