package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import packageframe.Frame;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;


@SuppressWarnings("serial")
public class AreaChatFrame extends JPanel {

	private Pulsanti profilo;
	private AreaDiTesto messaggi;
	private JTextField scriviMessaggio;
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
      SpecificContainer nord = new SpecificContainer();
      this.add(nord, BorderLayout.NORTH);
      nord.add(esci);
      nord.add(profilo);
    	
      messaggi = new AreaDiTesto(Color.pink, 70, 40, new Font("Times New Roman", 1, 12));
      SpecificContainer centro = new SpecificContainer(getBackground());
      this.add(centro, BorderLayout.CENTER);
      centro.add(messaggi);
    	
      scriviMessaggio = new JTextField(30);
	  scriviMessaggio.setFont(new java.awt.Font("Arial", 1, 12)); 
	  scriviMessaggio.setText("Scrivi messaggio");
	  scriviMessaggio.setBackground(Color.LIGHT_GRAY);
      SpecificContainer sud = new SpecificContainer(getBackground());
	  this.add(sud, BorderLayout.SOUTH);
	  sud.add(scriviMessaggio);
		
	  invia = new Pulsanti("Invia", Color.cyan, new Font("Times New Roman", 1, 14));
      sud.add(invia);
		
    }
    
    
    public AreaDiTesto getMessaggi() {
		return messaggi;
	}

	public void setMessaggi(AreaDiTesto messaggi) {
		this.messaggi = messaggi;
	}

	public JTextField getScriviMessaggio() {
		return scriviMessaggio;
	}

	public void setScriviMessaggio(JTextField scriviMessaggio) {
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
