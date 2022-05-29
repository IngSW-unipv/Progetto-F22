package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JPanel;
import packageframe.Frame;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;


public class AreaChatFrame extends JPanel {
	
	ArrayList<JComponent> ListaEtichetteMessaggi = new ArrayList<JComponent>();
	private ArrayList<String> messaggiChat = new ArrayList<String>();
	private AreaDiTesto messaggi;
	private InserimentoTesto scriviMessaggio;
	private Pulsanti invia, profilo, home, nextMessaggio, prevMessaggio;
	private int indiceMessaggioCorrente = 0;
	public AreaChatFrame() {
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
    	
      profilo = new Pulsanti("profiloricevente", new Color(204, 255, 255), new Font("Arial", 1, 12));
      SpecificContainer containerNorth = new SpecificContainer();
      this.add(containerNorth, BorderLayout.NORTH);
      containerNorth.add(profilo);
      
      scriviMessaggio = new InserimentoTesto("Scrivi messaggio", Color.LIGHT_GRAY, new Font("Arial", 1, 12), 30);
	  scriviMessaggio.setFont(new java.awt.Font("Arial", 1, 12)); 
	  scriviMessaggio.setText("Scrivi messaggio");
	  scriviMessaggio.setBackground(Color.LIGHT_GRAY);
      SpecificContainer containerSouth = new SpecificContainer(getBackground());
	 
     
		for(int i = getIndiceMessaggioCorrente();  i <  20; i++) {
			messaggiChat.add("messaggio" + i);
			Etichette areaMessaggio = new Etichette("messaggio" + i, Frame.COLOREPRIMARIOTEMATICO);
			ListaEtichetteMessaggi.add(areaMessaggio);
		}
      
		ListaEtichetteMessaggi.add(nextMessaggio = new  Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO));
		ListaEtichetteMessaggi.add(prevMessaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO));
		
		//SpecificContainer containerCenter = new SpecificContainer(getBackground());
	    //add(containerCenter, BorderLayout.CENTER);
	    GrigliaDiElementi grigliaMessaggi =  new GrigliaDiElementi(ListaEtichetteMessaggi,20,2, ListaEtichetteMessaggi.size());
		add(grigliaMessaggi, BorderLayout.CENTER);
		
      this.add(containerSouth, BorderLayout.SOUTH);
	  containerSouth.add(scriviMessaggio,BorderLayout.CENTER );
		
	  invia = new Pulsanti("Invia", Color.cyan, new Font("Times New Roman", 1, 14));
	  containerSouth.add(invia,BorderLayout.EAST);

	  home = new Pulsanti("Home", Color.cyan, new Font("Times New Roman", 1, 14));
	  containerSouth.add(home,BorderLayout.SOUTH);
    }
    public void aggiornaMessaggi() {
    	
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
		this.indiceMessaggioCorrente++;
	}
	
	public void incrementaIndiceMessaggioCorrente() {
		this.indiceMessaggioCorrente--;
	}
	
}
