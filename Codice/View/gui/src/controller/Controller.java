package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.sql.Time;
import java.time.LocalDateTime;
import java.util.ArrayList;

import Sistema.Sistema;
import convertitore.chatUtility.UtilityChat;
import packageframe.Frame;
import post.multimedia.foto.Foto;
import profilo.exception.*;

public class Controller {
    
    private ActionListener gestoreLogin, gestoreSignUp, gestoreImpostazioni, gestoreRegistrati, gestoreProfilo,
                           gestoreChat, gestorePannelloNotifiche, gestoreHomeImpostazioni, gestoreHomeProfilo,
                           gestoreHomeChat, gestoreHomePannelloNotifiche, gestoreCreazionePost, gestoreHomeCreazionePost,
                           gestoreLogOut,gestorePubblicaPost, gestoreModificaProfilo, gestoreVisibilitaPost, gestoreEliminaAccount,
                           gestoreCerca, gestoreHomeCerca, gestoreFotoProfilo, gestoreIndietroSignup,gestoreHomePostVisualizzato;
    Frame view;
    Sistema model;
    private String schermataAttuale = "Login";
    private String postAttuale = "";
    
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
                        aggiornaSchermataProfilo();
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
                            ricerca();
                            mostraSchermata("Ricerca");
                            
                        } else 
                            view.setTestoRicerca("Inserire un username da cercare");        
                    }
                };
                view.getCercaButton().addActionListener(gestoreCerca);
    }
    
    public void actionListenersImpostazioni() {gestoreLogOut = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                model.logout(model.getProfiloAttivo().getIdProfilo());
            } catch (AccountDoesNotExist e1) {
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
        
        gestoreFotoProfilo = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                settaPostVisualizzato();
                mostraSchermata("Postvisualizzato");
            }
        };
        view.getPulsanteFotoProfilo().addActionListener(gestoreFotoProfilo);
        
    }
    
    public void actionListenersCreazionePost() {
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
    
    }
    
    public void actionListenersRicerca(){
        gestoreHomeCerca = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeRicercaButton().addActionListener(gestoreHomeCerca);
    }
    
    
    public void actionListenersChat() {
        gestoreHomeChat = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomeChatButton().addActionListener(gestoreHomeChat);
        
    }
    
    public void actionListenersPostVisualizzato() {
        gestoreHomePostVisualizzato = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mostraSchermata("Home");
            }
        };
        view.getHomePostVisualizzatoButton().addActionListener(gestoreHomePostVisualizzato);
        
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
        Date d = new Date(LocalDateTime.now().getYear(), LocalDateTime.now().getMonthValue(), LocalDateTime.now().getDayOfMonth());
        Time t = new Time(LocalDateTime.now().getHour(), LocalDateTime.now().getMinute(), LocalDateTime.now().getSecond());
        model.pubblicaPost(UtilityChat.convertiInSqlData(d), t, commentoPost, true, false, model.getProfiloAttivo().getIdProfilo(), percorsoFilePost, false);
    }
   
    
    public boolean verificaTestoRicerca() {
        if(view.getTestoRicerca().equals("") || view.getTestoRicerca().equals("Inserire un username da cercare")) {
            return false;
        }
        return true;
    }

    public void oggettoDaCercare() {
        
    }
    
    public void aggiornaSchermataProfilo() {

        view.getEtichettaNome().setText(model.getProfiloAttivo().getNickname());
        view.setSchermataDati(model.getProfiloAttivo().getNumPost(), model.getProfiloAttivo().getNumFollower(), model.getProfiloAttivo().getNumSeguiti());
        //String NickName, int numeroFollowers, int numeroSeguiti, int numeroPost, String immagineProfilo, ArrayList<String> immaginiPost
    }
    
    public void settaPostVisualizzato() {
        
    }
    public void ricerca() {
        ArrayList<String> risultatiRicerca = new  ArrayList<String>();
        risultatiRicerca.add(view.getTestoRicerca());
        risultatiRicerca.add(view.getTestoRicerca());
        view.getTestoRicercaInSchermataRicerca().setText(view.getTestoRicerca());
        view.impostaRisultatiRicerca(risultatiRicerca);
    }
}