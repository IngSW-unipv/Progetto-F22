package panelspackage.panels;
    import javax.swing.*;
    import java.awt.*;
    import java.util.ArrayList;
    import panelspackage.panels.elements.GrigliaDiElementi;
    import panelspackage.panels.elements.Pulsanti;
    import panelspackage.panels.elements.AreaCommenti;
    import panelspackage.panels.elements.AreaDiTesto;
    import panelspackage.panels.elements.Etichette;
    import panelspackage.panels.elements.SpecificContainer;
    import packageframe.Frame;
    
public class PostVisualizzato extends JPanel{
    private ArrayList<JComponent> ListaAreaTesto = new ArrayList<JComponent>();
    int indiceCommentoCorrente = 0;
    int numeroCommentiTotali = 5;
    private String tipoSondaggio;
    private String messaggioBottoneSuperioreFollow = "Inizia a seguire";
    private String messaggioBottoneSuperioreProfilo = "Imposta come immagine profilo";
    private JTextArea areaDescrizione;
    private AreaCommenti areaCommenti;
    private AreaDiTesto aggiungiCommento, descrizionePost;
    private JButton homePostVisualizzato,nextCommento, prevCommento;
    private Pulsanti impostaImmagineProfiloButton, iniziaSeguireButton, nascondi, 
    				 pulsantePrimaScelta = new Pulsanti("", Frame.COLOREPRIMARIOTEMATICO),
    				 pulsanteSecondaScelta  = new Pulsanti("", Frame.COLOREPRIMARIOTEMATICO),
    				 pulsanteTerzaScelta  = new Pulsanti("", Frame.COLOREPRIMARIOTEMATICO),
    				 pulsanteQuartaScelta  = new Pulsanti("", Frame.COLOREPRIMARIOTEMATICO);
    private SpecificContainer containerNorth, containerCenter, containerSondaggio, containerPost;
    private String fotoPath, idPost;
    private ArrayList<String> postCommentiConUtenti = new ArrayList<String>();
    private Etichette fotoVisualizzata = new Etichette(""), 
    				  etichettaPrimoRisultato = new Etichette("o", Frame.COLOREPRIMARIOTEMATICO), 
    				  etichettaSecondoRisultato = new Etichette("o", Frame.COLOREPRIMARIOTEMATICO), 
    				  etichettaTerzoRisultato = new Etichette("o", Frame.COLOREPRIMARIOTEMATICO), 
    				  etichettaQuartoRisultato = new Etichette("o", Frame.COLOREPRIMARIOTEMATICO);
    int numeroMiPiace = 0, numeroNonMiPiace = 0, numeroComm = 0;
    
    public PostVisualizzato() {
        avvio();
        initComponents();
    }

    
    public void avvio() {
        this.setOpaque(true);
        this.setVisible(true);
        this.setLayout(new BorderLayout());
        this.setBackground(Frame.COLORESECONDARIOTEMATICO);
    }
    
    public void initComponents() {
    	containerCenter =  new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
    	containerSondaggio =  new SpecificContainer();
    	containerPost = new SpecificContainer();
    	
        SpecificContainer containerNorth = new SpecificContainer();
        this.add(containerNorth, BorderLayout.NORTH);
        
        impostaImmagineProfiloButton = new Pulsanti(messaggioBottoneSuperioreProfilo, Frame.COLOREPRIMARIOTEMATICO);
        containerNorth.add(impostaImmagineProfiloButton, BorderLayout.CENTER);
        
        nascondi = new Pulsanti("nascondi post", Frame.getColoreprimariotematico());
        containerNorth.add(nascondi, BorderLayout.WEST);
        
        this.add(containerCenter, BorderLayout.CENTER);

        containerCenter.add(containerPost, BorderLayout.CENTER);
        containerPost.add(fotoVisualizzata, BorderLayout.CENTER);

        areaCommenti =  new AreaCommenti();
        containerCenter.add(areaCommenti, BorderLayout.SOUTH);

        postCommentiConUtenti.add("");
        postCommentiConUtenti.add("");
        postCommentiConUtenti.add("");
        postCommentiConUtenti.add("");
        postCommentiConUtenti.add("");
        postCommentiConUtenti.add("");
        postCommentiConUtenti.add("");
        postCommentiConUtenti.add("");
        postCommentiConUtenti.add("");
        postCommentiConUtenti.add(""); 
        
        for( int i = getIndiceCommentoCorrente();  i <  this.postCommentiConUtenti.size() - 1; i = i +2) {

        Etichette areaNomeProfilo = new Etichette(postCommentiConUtenti.get(i), Frame.COLOREPRIMARIOTEMATICO);
        Etichette areaCommento = new Etichette(postCommentiConUtenti.get(i + 1),Frame.COLOREPRIMARIOTEMATICO);
        ListaAreaTesto.add(areaNomeProfilo);
        ListaAreaTesto.add(areaCommento);   
        }
        ListaAreaTesto.add(prevCommento = new JButton("Commenti precedenti"));
        ListaAreaTesto.add(nextCommento = new  JButton("Commenti successivi"));
        
        
        SpecificContainer containerEast = new SpecificContainer();
        SpecificContainer containerAggiuntivoEast = new SpecificContainer();
        SpecificContainer secondoContainerAggiuntivoEast = new SpecificContainer();
        secondoContainerAggiuntivoEast.setLayout(new GridLayout(1, 2));
        this.add(containerEast, BorderLayout.EAST);
        
        GrigliaDiElementi dati =  new GrigliaDiElementi(ListaAreaTesto,10,2, ListaAreaTesto.size());
        
        Etichette etichettaInserisciCommento = new Etichette("Inserisci un commento: ", Frame.COLOREPRIMARIOTEMATICO);
        aggiungiCommento = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, 10, 35);
        aggiungiCommento.setEditable(true);
        JScrollPane scrollCommento = new JScrollPane(aggiungiCommento);
        
        containerAggiuntivoEast.add(etichettaInserisciCommento, BorderLayout.NORTH);
        containerAggiuntivoEast.add(scrollCommento, BorderLayout.CENTER);
        
        Etichette etichettaCommento = new Etichette("Commento: ", Frame.COLOREPRIMARIOTEMATICO);
        Etichette etichettaProfilo = new Etichette("Profilo: ", Frame.COLOREPRIMARIOTEMATICO);
        
        secondoContainerAggiuntivoEast.add(etichettaProfilo);
        secondoContainerAggiuntivoEast.add(etichettaCommento);
        
        containerEast.add(secondoContainerAggiuntivoEast, BorderLayout.NORTH);
        containerEast.add(dati, BorderLayout.CENTER);
        containerEast.add(containerAggiuntivoEast,  BorderLayout.SOUTH);
        
            
        SpecificContainer containerSouth = new SpecificContainer(Frame.COLORESECONDARIOTEMATICO);
        this.add(containerSouth, BorderLayout.SOUTH);
        
        homePostVisualizzato = new Pulsanti("Home", Frame.COLOREPRIMARIOTEMATICO);
        containerSouth.add(homePostVisualizzato, BorderLayout.CENTER);
        
        
        descrizionePost = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "", 10, 20);
        descrizionePost.setEditable(false);
        JScrollPane scrollDescrizionePost = new JScrollPane(descrizionePost);
        containerSondaggio = new SpecificContainer();
        containerSondaggio.add(scrollDescrizionePost, BorderLayout.CENTER);
        
        SpecificContainer containerScelte = new SpecificContainer();
        containerScelte.setLayout(new GridLayout(4, 2));
        
        containerScelte.add(pulsantePrimaScelta);
        containerScelte.add(etichettaPrimoRisultato);
        containerScelte.add(pulsanteSecondaScelta);
        containerScelte.add(etichettaSecondoRisultato);
        containerScelte.add(pulsanteTerzaScelta);
        containerScelte.add(etichettaTerzoRisultato);
        containerScelte.add(pulsanteQuartaScelta);
        containerScelte.add(etichettaQuartoRisultato);
        containerSondaggio.add(containerScelte, BorderLayout.EAST);

    }
    
    public boolean settaCommenti(ArrayList<String> commenti) {
    	
    	if (this.indiceCommentoCorrente < 0) {
    		int zero = 0;
    		indiceCommentoCorrente = zero;
    	}
    	
    	if (this.indiceCommentoCorrente > commenti.size() - 10) {
    		int valoreMassimo =  commenti.size() - 10;
    		indiceCommentoCorrente = valoreMassimo;
    	}
    	
        if(commenti.size() == 0) {
        	for(int i = 0 ; i < 10; i = i+2) {
        		((Etichette)ListaAreaTesto.get(i)).setText("");
        		((Etichette)ListaAreaTesto.get(i + 1)).setText("");
        	}
        	return true;
    	}
               
        for(int i = 0 ; i < 10 && i < commenti.size() - this.getIndiceCommentoCorrente()/2 ; i = i + 2) {
        	if(indiceCommentoCorrente < 0) {
        		indiceCommentoCorrente = 0;
        	}
        	
            int indiceCorrente2 = i + indiceCommentoCorrente;
            ((Etichette)ListaAreaTesto.get(i)).setText(commenti.get(indiceCorrente2));
            ((Etichette)ListaAreaTesto.get(i + 1)).setText(commenti.get(indiceCorrente2 + 1));
        }
        return true;
    }
    
    public void settaPostVisualizzato(String iDpost, String path, String descrizionePost, int numeroLike, int numeroDislike, int numeroCommenti,ArrayList<String> commenti) {
        settaCommenti(commenti);
        idPost = iDpost;
        this.cambiaFoto(path);
        fotoPath = path;
        numeroMiPiace = numeroLike;
        numeroNonMiPiace = numeroDislike;
        numeroComm = numeroCommenti;
        containerSondaggio.setVisible(false);
        containerPost.setVisible(true);
        this.getAreaCommentiTesto().setText(descrizionePost);
        this.getNumeroLike().setText("N.Like: " + numeroLike);
        this.getNumeroDislike().setText("N.Dislike: " + numeroDislike);
        this.getNumeroCommenti().setText("N.Commenti: " + numeroCommenti/2);
        
        impostaImmagineProfiloButton.setVisible(true);
    }
    public void settaSondaggioVisualizzato(String iDpost, String descrizioneSondaggio, String scelta1, String scelta2, String scelta3, String scelta4, int numeroLike, int numeroDislike, int numeroCommenti, int [] conteggi,ArrayList<String> commenti) {
        numeroMiPiace = numeroLike;
        numeroNonMiPiace = numeroDislike;
        numeroComm = numeroCommenti;
        settaCommenti(commenti);
        idPost = iDpost;
          
        etichettaPrimoRisultato.setText(String.valueOf(conteggi[0]));
        etichettaSecondoRisultato.setText(String.valueOf(conteggi[1]));
        etichettaTerzoRisultato.setText(String.valueOf(conteggi[2]));
        etichettaQuartoRisultato.setText(String.valueOf(conteggi[3]));
        
        pulsantePrimaScelta.setText(scelta1);
        pulsanteSecondaScelta.setText(scelta2);
        pulsanteTerzaScelta.setText(scelta3);
        pulsanteQuartaScelta.setText(scelta4);
        descrizionePost.setText(descrizioneSondaggio);
        this.getAreaCommentiTesto().setText("");

        containerPost.setVisible(false);
        containerCenter.add(containerSondaggio, BorderLayout.CENTER);
        containerSondaggio.setVisible(true);
        impostaImmagineProfiloButton.setVisible(false);
    }
    
    public void settaSondaggioVisualizzato(String iDpost, String descrizioneSondaggio, String scelta1, String scelta2,  int numeroLike, int numeroDislike, int numeroCommenti,int [] conteggi, ArrayList<String> commenti) {
    	numeroMiPiace = numeroLike;
        numeroNonMiPiace = numeroDislike;
        numeroComm = numeroCommenti;
        settaCommenti(commenti);
        idPost = iDpost;
          
        pulsantePrimaScelta.setText(scelta1);
        pulsanteSecondaScelta.setText(scelta2);
        pulsanteTerzaScelta.setText("");
        pulsanteQuartaScelta.setText("");
        
        etichettaPrimoRisultato.setText(String.valueOf(conteggi[0]));
        etichettaSecondoRisultato.setText(String.valueOf(conteggi[1]));
        etichettaTerzoRisultato.setText("");
        etichettaQuartoRisultato.setText("");
        descrizionePost.setText(descrizioneSondaggio);
        this.getAreaCommentiTesto().setText("");

        containerPost.setVisible(false);
        containerCenter.add(containerSondaggio, BorderLayout.CENTER);
        containerSondaggio.setVisible(true);
        impostaImmagineProfiloButton.setVisible(false);
    }
    
    public JLabel getNumeroLike() {
    	return areaCommenti.getNumeroLike();
    }
    
    public JLabel getNumeroDislike() {
    	return areaCommenti.getNumeroDislike();
    }
    
    public JLabel getNumeroCommenti() {
    	return areaCommenti.getNumeroCommenti();
    }
    
    public ArrayList<JComponent> getListaAreaTesto() {
        return ListaAreaTesto;
    }

    public void setListaAreaTesto(ArrayList<JComponent> listaAreaTesto) {
        ListaAreaTesto = listaAreaTesto;
    }
    
    public JButton getHomePostVisualizzato() {
        return homePostVisualizzato;
    }

    public void setHomePostVisualizzato(JButton homePostVisualizzato) {
        this.homePostVisualizzato = homePostVisualizzato;
    }

    public JTextArea getAreaDescrizione() {
        return areaDescrizione;
    }

    public void setAreaDescrizione(JTextArea areaDescrizione) {
        this.areaDescrizione = areaDescrizione;
    }

    public SpecificContainer getContainerNorth() {
        return containerNorth;
    }

    public AreaDiTesto getAggiungiCommento() {
        return aggiungiCommento;
    }

    public void setAggiungiCommento(AreaDiTesto aggiungiCommento) {
        this.aggiungiCommento = aggiungiCommento;
    }
    
    public JButton getAggiungiCommentoButton() {
        return areaCommenti.getAggiungiCommento();
    }
    
    public JButton getAggiungiLikeButton() {
        return areaCommenti.getAggiungiLike();
    }

    public JButton getAggiungiDislikeButton() {
        return areaCommenti.getAggiungiDislike();
    }
    
    public JTextArea getAreaCommentiTesto() {
        return (JTextArea) areaCommenti.getAreaDescrizione();
    }

    public String getIdPost() {
        return idPost;
    }

    public void setIdPost(String idPost) {
        this.idPost = idPost;
    }

    public JButton getImpostaImmagineProfiloButton() {
        return impostaImmagineProfiloButton;
    }
    
    public void setImpostaImmagineProfiloButton(Pulsanti impostaImmagineProfiloButton) {
        this.impostaImmagineProfiloButton = impostaImmagineProfiloButton;
    }
    
    public Pulsanti getIniziaSeguireButton() {
        return iniziaSeguireButton;
    }

    public void setIniziaSeguireButton(Pulsanti iniziaSeguireButton) {
        this.iniziaSeguireButton = iniziaSeguireButton;
    }

    public String getFotoPath() {
        return fotoPath;
    }
    
    public void cambiaFoto(String fotoPath) {
        this.fotoVisualizzata.setIcon(new ImageIcon(fotoPath));
    }

    public String getMessaggioBottoneSuperioreFollow() {
        return messaggioBottoneSuperioreFollow;
    }

    public void setMessaggioBottoneSuperioreFollow(String messaggioBottoneSuperioreFollow) {
        this.messaggioBottoneSuperioreFollow = messaggioBottoneSuperioreFollow;
    }

    public String getMessaggioBottoneSuperioreProfilo() {
        return messaggioBottoneSuperioreProfilo;
    }

    public void setMessaggioBottoneSuperioreProfilo(String messaggioBottoneSuperioreProfilo) {
        this.messaggioBottoneSuperioreProfilo = messaggioBottoneSuperioreProfilo;
    }
    
    public JButton getNextCommento() {
        return nextCommento;
    }

    public JButton getPrevCommento() {
        return prevCommento;
    }

    public int getIndiceCommentoCorrente() {
        return indiceCommentoCorrente;
    }
    
    public void setIndiceCommentoCorrente(int indice) {
         indiceCommentoCorrente = indiceCommentoCorrente + indice;
    }

    public void incrementaIndiceCommento() {
        this.indiceCommentoCorrente = indiceCommentoCorrente + 2;

    }
    public void decrementaIndiceCommento() {
        this.indiceCommentoCorrente = indiceCommentoCorrente -2;
    }
    
    public void ripristinaIndiceCommento() {
        this.indiceCommentoCorrente = 0;
    }

    public int getNumeroCommentiTotali() {
        return numeroCommentiTotali;
    }

    public void setNumeroCommentiTotali(int numeroCommentiTotali) {
        this.numeroCommentiTotali = numeroCommentiTotali;
    }

	public Pulsanti getPulsantePrimaScelta() {
		return pulsantePrimaScelta;
	}

	public void setPulsantePrimaScelta(Pulsanti pulsantePrimaScelta) {
		this.pulsantePrimaScelta = pulsantePrimaScelta;
	}

	public Pulsanti getPulsanteSecondaScelta() {
		return pulsanteSecondaScelta;
	}

	public void setPulsanteSecondaScelta(Pulsanti pulsanteSecondaScelta) {
		this.pulsanteSecondaScelta = pulsanteSecondaScelta;
	}

	public Pulsanti getPulsanteTerzaScelta() {
		return pulsanteTerzaScelta;
	}

	public void setPulsanteTerzaScelta(Pulsanti pulsanteTerzaScelta) {
		this.pulsanteTerzaScelta = pulsanteTerzaScelta;
	}

	public Pulsanti getPulsanteQuartaScelta() {
		return pulsanteQuartaScelta;
	}

	public void setPulsanteQuartaScelta(Pulsanti pulsanteQuartaScelta) {
		this.pulsanteQuartaScelta = pulsanteQuartaScelta;
	}

	public String getTipoSondaggio() {
		return tipoSondaggio;
	}

	public void setTipoSondaggio(String tipoSondaggio) {
		this.tipoSondaggio = tipoSondaggio;
	}

	public Pulsanti getNascondi() {
		return nascondi;
	}
        
}