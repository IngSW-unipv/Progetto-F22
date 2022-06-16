package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.ArrayList;
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
	private ArrayList<JComponent> ListaEtichetteMessaggi = new ArrayList<JComponent>();
	private ArrayList<String> messaggiChat = new ArrayList<String>();
	private AreaDiTesto messaggi;
	private InserimentoTesto scriviMessaggio;
	private Pulsanti invia, home, nextMessaggio, prevMessaggio;
	private int indiceMessaggioCorrente = 0, numeroCommentiTotali;

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
		SpecificContainer containerNorth = new SpecificContainer();
	    this.add(containerNorth, BorderLayout.NORTH);
	      
	    scriviMessaggio = new InserimentoTesto("Scrivi messaggio", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 12), 30);
	    scriviMessaggio.setBackground(Frame.COLORESECONDARIOTEMATICO);
	
	    SpecificContainer containerSouth = new SpecificContainer(getBackground());
	    this.add(containerSouth, BorderLayout.SOUTH);
	      
	    containerSouth.add(nextMessaggio = new  Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO));
	    containerSouth.add(prevMessaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO));
	    containerSouth.add(scriviMessaggio);
	     
	    for(int i = getIndiceMessaggioCorrente();  i <  20; i++) {
	    	Etichette areaMessaggio = new Etichette("", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 20));
	    	ListaEtichetteMessaggi.add(areaMessaggio);
	    }
		
		ListaEtichetteMessaggi.add(prevMessaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO));
		ListaEtichetteMessaggi.add(nextMessaggio = new  Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO));
		
		GrigliaDiElementi grigliaMessaggi =  new GrigliaDiElementi(ListaEtichetteMessaggi,20,2, ListaEtichetteMessaggi.size());
		add(grigliaMessaggi, BorderLayout.CENTER);
		

		this.add(containerSouth, BorderLayout.SOUTH);
		containerSouth.add(scriviMessaggio,BorderLayout.CENTER );
		invia = new Pulsanti("Invia", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14));
		containerSouth.add(invia,BorderLayout.EAST);

		home = new Pulsanti("Home", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14));
		containerSouth.add(home,BorderLayout.SOUTH);
	}
    
    
	public boolean aggiornaMessaggi(ArrayList<String> messaggi, String inviante) {
		if(messaggi.size() == 0) {
			return false;
		} 
		
		int i = 0;
		boolean flag = true;
		while(flag) {
			int indiceCorrente2 = i + getIndiceMessaggioCorrente();
			
			if (messaggi.get(indiceCorrente2).equals(inviante)) {
				((Etichette)ListaEtichetteMessaggi.get(i)).setText("");
				((Etichette)ListaEtichetteMessaggi.get(i + 1)).setText(messaggi.get(indiceCorrente2 + 1));
			} else {
				((Etichette)ListaEtichetteMessaggi.get(i)).setText(messaggi.get(indiceCorrente2 + 1));
				((Etichette)ListaEtichetteMessaggi.get(i + 1)).setText("");
			}
			
			i = i+2;
			
			if (i == messaggi.size() || i == (20 - 2)) {
				flag = false;
			} 
		}
		flag = true;
		while(flag) { 
			((Etichette)ListaEtichetteMessaggi.get(i)).setText("");
			((Etichette)ListaEtichetteMessaggi.get(i + 1)).setText("");
			if (i == (20 - 2)) {
				flag = false;
			}
			
			i = i + 2;
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

}
