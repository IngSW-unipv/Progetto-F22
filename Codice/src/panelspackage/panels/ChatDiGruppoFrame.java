package panelspackage.panels;


import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import packageframe.Frame;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;


public class ChatDiGruppoFrame extends JPanel {
	
	ArrayList<JComponent> ListaEtichetteMessaggi = new ArrayList<JComponent>();
	private ArrayList<String> messaggiChat = new ArrayList<String>();
	private AreaDiTesto messaggi, testoDescrizione,testoDescrizioneNuova;
	private InserimentoTesto scriviMessaggio, utenteDaEliminare,utenteDaAggiungere;
	private SpecificContainer containerAmministratore;
	private Pulsanti invia, profilo, home, nextMessaggio, prevMessaggio, utenteDaEliminareButton, utenteDaAggiungereButton;
	private int indiceMessaggioCorrente = 0, numeroCommentiTotali;
	private String idGruppo;

	
	public ChatDiGruppoFrame() {
		avvio();
		initComponents();
	}
	
	public void avvio() {
		this.setVisible(true);
		this.setLayout(new BorderLayout());
		this.setBackground(Frame.COLORESECONDARIOTEMATICO);
	}
	
    public void initComponents() {
    	
      SpecificContainer containerNorth = new SpecificContainer();
      this.add(containerNorth, BorderLayout.NORTH);
      
      containerAmministratore  = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
      Container grigliaGestioneMembri = new Container();
      grigliaGestioneMembri.setBackground(Frame.COLOREPRIMARIOTEMATICO);
      
		testoDescrizioneNuova = new AreaDiTesto(Frame.COLOREPRIMARIOTEMATICO, "testo di fissa dimensione", 10,10);
		testoDescrizioneNuova.setEditable(true);
		JScrollPane pannelloDescrizione = new JScrollPane(testoDescrizioneNuova);
		pannelloDescrizione.setPreferredSize(new Dimension(10,10));
		
		
      grigliaGestioneMembri.setLayout(new GridLayout(3,2));
      grigliaGestioneMembri.add( utenteDaAggiungere = new InserimentoTesto(Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 12)));
      grigliaGestioneMembri.add( utenteDaAggiungereButton = new Pulsanti("aggiungi",Frame.COLOREPRIMARIOTEMATICO));
      grigliaGestioneMembri.add( utenteDaEliminare = new InserimentoTesto(Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 12)));
      grigliaGestioneMembri.add( utenteDaEliminareButton = new Pulsanti("elimina",Frame.COLOREPRIMARIOTEMATICO));
      grigliaGestioneMembri.add(pannelloDescrizione);
      grigliaGestioneMembri.add( utenteDaEliminareButton = new Pulsanti("modifica",Frame.COLOREPRIMARIOTEMATICO));
      containerAmministratore.add(grigliaGestioneMembri, BorderLayout.NORTH);
      containerNorth.add(containerAmministratore, BorderLayout.CENTER);
      containerNorth.add(new JFileChooser(), BorderLayout.SOUTH);
         
		for(int i = getIndiceMessaggioCorrente();  i <  10; i++) {
			Etichette areaMessaggio = new Etichette("", Frame.COLOREPRIMARIOTEMATICO);
			ListaEtichetteMessaggi.add(areaMessaggio);
		}
      
		ListaEtichetteMessaggi.add(nextMessaggio = new  Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO));
		ListaEtichetteMessaggi.add(prevMessaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO));
		
	   GrigliaDiElementi grigliaMessaggi =  new GrigliaDiElementi(ListaEtichetteMessaggi,6,2, ListaEtichetteMessaggi.size());

	   
	   SpecificContainer containerSouth = new SpecificContainer();
	   this.add(containerSouth, BorderLayout.SOUTH);
      
      scriviMessaggio = new InserimentoTesto("Scrivi messaggio", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 12));
	  scriviMessaggio.setBackground(Frame.COLORESECONDARIOTEMATICO);
	  containerSouth.add(scriviMessaggio,BorderLayout.CENTER );
		

	  invia = new Pulsanti("Invia", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14));
	  containerSouth.add(invia,BorderLayout.EAST);

	  home = new Pulsanti("Home", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14));
	  containerSouth.add(home,BorderLayout.SOUTH);
	  containerSouth.add(grigliaMessaggi, BorderLayout.NORTH);	
    }
    
    
	public boolean aggiornaMessaggiGruppo(ArrayList<String> messaggi) {
		if(messaggi.size() == 0) {
			return false;
		} 

		/*for(int i = 0 ; i < 10 || i < messaggi.size(); i++) {
			int indiceCorrente2 = i + getIndiceMessaggioCorrente();
			((Etichette)ListaEtichetteMessaggi.get(i)).setText(messaggi.get(indiceCorrente2));
		}
		return true;*/		
		int i = 0;
		boolean flag = true;
		while(flag) {
			int indiceCorrente2 = i + getIndiceMessaggioCorrente();
			
				((Etichette)ListaEtichetteMessaggi.get(i)).setText(messaggi.get(indiceCorrente2));

			i++;
			
			if (i == messaggi.size() || i == (10 - 2)) {
				flag = false;
			} 
		}
		
		flag = true;
		while(flag) { 
			((Etichette)ListaEtichetteMessaggi.get(i)).setText("");
			if (i == (10 - 2)) {
				flag = false;
			}
			
			i++;
		}	
		return true;
	}
	
    public void settaCommenti(ArrayList<String> commenti) {
		this.setNumeroCommentiTotali(commenti.size()/2);
    }
    
    public AreaDiTesto getMessaggi() {
		return messaggi;
	}

	public void setMessaggi(AreaDiTesto messaggi) {
		this.messaggi = messaggi;
	}

	public InserimentoTesto getScriviMessaggio() {
		return scriviMessaggio;
	}

	public void setScriviMessaggio(InserimentoTesto scriviMessaggio) {
		this.scriviMessaggio = scriviMessaggio;
	}

	public Pulsanti getInvia() {
		return invia;
	}

	public void setInvia(Pulsanti invia) {
		this.invia = invia;
	}

	public Pulsanti getProfilo() {
		return profilo;
	}

	public void setProfilo(Pulsanti profilo) {
		this.profilo = profilo;
	}

	public Pulsanti getHome() {
		return home;
	}

	public ArrayList<String> getMessaggiChat() {
		return messaggiChat;
	}

	public void setMessaggiChat(ArrayList<String> messaggiChat) {
		this.messaggiChat = messaggiChat;
	}

	public int getIndiceMessaggioCorrente() {
		return indiceMessaggioCorrente;
	}

	public void decrementaIndiceMessaggioCorrente() {
		this.indiceMessaggioCorrente = this.indiceMessaggioCorrente - 2;
	}
	
	public void incrementaIndiceMessaggioCorrente() {
		this.indiceMessaggioCorrente = this.indiceMessaggioCorrente + 2;

	}

	public int getNumeroCommentiTotali() {
		return numeroCommentiTotali;
	}

	public void setNumeroCommentiTotali(int numeroCommentiTotali) {
		this.numeroCommentiTotali = numeroCommentiTotali;
	}

	public Pulsanti getNextMessaggio() {
		return nextMessaggio;
	}

	public Pulsanti getPrevMessaggio() {
		return prevMessaggio;
	}

	public ArrayList<JComponent> getListaEtichetteMessaggi() {
		return ListaEtichetteMessaggi;
	}

	public void setListaEtichetteMessaggi(ArrayList<JComponent> listaEtichetteMessaggi) {
		ListaEtichetteMessaggi = listaEtichetteMessaggi;
	}

	public AreaDiTesto getTestoDescrizione() {
		return testoDescrizione;
	}

	public void setTestoDescrizione(AreaDiTesto testoDescrizione) {
		this.testoDescrizione = testoDescrizione;
	}

	public AreaDiTesto getTestoDescrizioneNuova() {
		return testoDescrizioneNuova;
	}

	public void setTestoDescrizioneNuova(AreaDiTesto testoDescrizioneNuova) {
		this.testoDescrizioneNuova = testoDescrizioneNuova;
	}

	public InserimentoTesto getUtenteDaEliminare() {
		return utenteDaEliminare;
	}

	public void setUtenteDaEliminare(InserimentoTesto utenteDaEliminare) {
		this.utenteDaEliminare = utenteDaEliminare;
	}

	public InserimentoTesto getUtenteDaAggiungere() {
		return utenteDaAggiungere;
	}

	public void setUtenteDaAggiungere(InserimentoTesto utenteDaAggiungere) {
		this.utenteDaAggiungere = utenteDaAggiungere;
	}

	public SpecificContainer getContainerAmministratore() {
		return containerAmministratore;
	}

	public void setContainerAmministratore(SpecificContainer containerAmministratore) {
		this.containerAmministratore = containerAmministratore;
	}

	public Pulsanti getUtenteDaEliminareButton() {
		return utenteDaEliminareButton;
	}

	public void setUtenteDaEliminareButton(Pulsanti utenteDaEliminareButton) {
		this.utenteDaEliminareButton = utenteDaEliminareButton;
	}

	public Pulsanti getUtenteDaAggiungereButton() {
		return utenteDaAggiungereButton;
	}

	public void setUtenteDaAggiungereButton(Pulsanti utenteDaAggiungereButton) {
		this.utenteDaAggiungereButton = utenteDaAggiungereButton;
	}

	public void setHome(Pulsanti home) {
		this.home = home;
	}

	public void setNextMessaggio(Pulsanti nextMessaggio) {
		this.nextMessaggio = nextMessaggio;
	}

	public void setPrevMessaggio(Pulsanti prevMessaggio) {
		this.prevMessaggio = prevMessaggio;
	}

	public void setIndiceMessaggioCorrente(int indiceMessaggioCorrente) {
		this.indiceMessaggioCorrente = indiceMessaggioCorrente;
	}

	public String getIdGruppo() {
		return idGruppo;
	}

	public void setIdGruppo(String idGruppo) {
		this.idGruppo = idGruppo;
	}
}