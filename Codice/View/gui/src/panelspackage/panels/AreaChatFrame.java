package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import packageframe.Frame;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;


@SuppressWarnings("serial")
public class AreaChatFrame extends JPanel {

	private Pulsanti profilo;
	private AreaDiTesto messaggi;
	private InserimentoTesto scriviMessaggio;
	private Pulsanti invia;
	private Pulsanti esci;
	
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
    	
      esci = new Pulsanti("C:\\Users\\aissa\\OneDrive\\Immagini\\torna.png", Color.red, new Font("Arial", 1, 12));
      profilo = new Pulsanti("C:\\\\Users\\\\aissa\\\\OneDrive\\\\Immagini\\\\profiler.png", new Color(204, 255, 255), new Font("Arial", 1, 12));
      SpecificContainer containerNorth = new SpecificContainer();
      this.add(containerNorth, BorderLayout.NORTH);
      containerNorth.add(esci);
      containerNorth.add(profilo);
    	
      messaggi = new AreaDiTesto(Color.pink, 70, 40, new Font("Times New Roman", 1, 12));
      SpecificContainer containerCenter = new SpecificContainer(getBackground());
      this.add(containerCenter, BorderLayout.CENTER);
      containerCenter.add(messaggi);
    	
      
      scriviMessaggio = new InserimentoTesto("Scrivi messaggio", Color.LIGHT_GRAY, new Font("Arial", 1, 12), 30);
	  scriviMessaggio.setFont(new java.awt.Font("Arial", 1, 12)); 
	  scriviMessaggio.setText("Scrivi messaggio");
	  scriviMessaggio.setBackground(Color.LIGHT_GRAY);
      SpecificContainer containerSouth = new SpecificContainer(getBackground());
	  this.add(containerSouth, BorderLayout.SOUTH);
	  containerSouth.add(scriviMessaggio);
		
	  invia = new Pulsanti("Invia", Color.cyan, new Font("Times New Roman", 1, 14));
	  containerSouth.add(invia);
		
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

	public Pulsanti getEsci() {
		return esci;
	}

	public void setEsci(Pulsanti esci) {
		this.esci = esci;
	}
}
