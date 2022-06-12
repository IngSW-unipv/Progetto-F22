package panelspackage.panels;


import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import packageframe.Frame;
import panelspackage.panels.elements.AreaDiTesto;
import panelspackage.panels.elements.Etichette;
import panelspackage.panels.elements.GrigliaDiElementi;
import panelspackage.panels.elements.InserimentoTesto;
import panelspackage.panels.elements.Pulsanti;
import panelspackage.panels.elements.SpecificContainer;


@SuppressWarnings("serial")
public class AreaChatFrame extends JPanel {
	
	ArrayList<JComponent> ListaEtichetteMessaggi = new ArrayList<JComponent>();
	private ArrayList<String> messaggiChat = new ArrayList<String>();
	private AreaDiTesto messaggi;
	private InserimentoTesto scriviMessaggio;
	private Pulsanti invia, profilo, home, nextMessaggio, prevMessaggio;
	private int indiceMessaggioCorrente = 0, numeroCommentiTotali;
	private Pulsanti refresh;
	private Pulsanti eliminaChat;
	private Pulsanti aggiungiUtente;
	private JFileChooser modifica;
	private Pulsanti modificaFoto;
	private Pulsanti eliminaGruppo;
	
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
    	
      profilo = new Pulsanti("profiloricevente", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 12));
      SpecificContainer containerNorth = new SpecificContainer();
      this.add(containerNorth, BorderLayout.NORTH);
      containerNorth.add(profilo);
      
      scriviMessaggio = new InserimentoTesto("Scrivi messaggio", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 12), 30);
	  scriviMessaggio.setBackground(Frame.COLORESECONDARIOTEMATICO);
	  
      SpecificContainer containerSouth1 = new SpecificContainer(getBackground());
      containerSouth1.setLayout(new GridLayout(3, 1));
      this.add(containerSouth1, BorderLayout.SOUTH);
	 
     
		for(int i = getIndiceMessaggioCorrente();  i <  20; i++) {
			Etichette areaMessaggio = new Etichette("", Frame.COLOREPRIMARIOTEMATICO);
			ListaEtichetteMessaggi.add(areaMessaggio);
		}
      
		ListaEtichetteMessaggi.add(nextMessaggio = new  Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO));
		ListaEtichetteMessaggi.add(prevMessaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO));
		
		SpecificContainer containerCenter = new SpecificContainer();
		this.add(containerCenter, BorderLayout.CENTER);
		
		eliminaChat = (new Pulsanti("Elmina chat", Frame.COLOREPRIMARIOTEMATICO));
		aggiungiUtente = (new Pulsanti("Aggiungi un utente", Frame.COLOREPRIMARIOTEMATICO));
		modifica = new JFileChooser();
		modificaFoto = new Pulsanti("Modifica la foto", Frame.COLOREPRIMARIOTEMATICO);
		eliminaGruppo = new Pulsanti("Elimina il gruppo", Frame.COLOREPRIMARIOTEMATICO);
		
		containerCenter.add(eliminaChat);
		containerCenter.add(aggiungiUtente);
		containerCenter.add(modifica);
		containerCenter.add(modificaFoto);
		containerCenter.add(eliminaGruppo);
		
		
		//SpecificContainer containerCenter = new SpecificContainer(getBackground());
	    //add(containerCenter, BorderLayout.CENTER);
	    GrigliaDiElementi grigliaMessaggi =  new GrigliaDiElementi(ListaEtichetteMessaggi,20,2, ListaEtichetteMessaggi.size());
		add(grigliaMessaggi, BorderLayout.CENTER);
		
      
	  
	  
	  refresh = new Pulsanti("Refresh", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14));
	  containerSouth1.add(refresh);
	  containerSouth1.add(scriviMessaggio);
	  
	  invia = new Pulsanti("Invia", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14));
	  containerSouth1.add(invia,BorderLayout.EAST);
      
	  SpecificContainer containerSouth2 = new SpecificContainer();
	  this.add(containerSouth2, BorderLayout.SOUTH);
	  home = new Pulsanti("Home", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14));
	  containerSouth2.add(home,BorderLayout.SOUTH);
    }
    
	public boolean aggiornaMessaggi(ArrayList<String> messaggi, String inviante) {
		if(messaggi.size() == 0) {
			return false;
		} 
		System.out.println("la funzione viene chiamata");

		for(int i = 0 ; i < 20 && i < messaggi.size() - this.getIndiceMessaggioCorrente()/2; i = i + 2) {
			System.out.println("ciclo numero" + i);

			int indiceCorrente2 = i + getIndiceMessaggioCorrente();
			System.out.println("indice : " + getIndiceMessaggioCorrente());
			if (messaggi.get(indiceCorrente2).equals(inviante)) {
			((Etichette)ListaEtichetteMessaggi.get(i)).setText("");
			((Etichette)ListaEtichetteMessaggi.get(i + 1)).setText(messaggi.get(indiceCorrente2 + 1));
				}
			else {
				((Etichette)ListaEtichetteMessaggi.get(i)).setText(messaggi.get(indiceCorrente2 + 1));
				((Etichette)ListaEtichetteMessaggi.get(i + 1)).setText("");
				}
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

	public Pulsanti getEliminaChat() {
		return eliminaChat;
	}

	public void setEliminaChat(Pulsanti eliminaChat) {
		this.eliminaChat = eliminaChat;
	}

	public JFileChooser getModifica() {
		return modifica;
	}

	public void setModifica(JFileChooser modifica) {
		this.modifica = modifica;
	}

	public Pulsanti getAggiungiUtente() {
		return aggiungiUtente;
	}

	public void setAggiungiUtente(Pulsanti aggiungiUtente) {
		this.aggiungiUtente = aggiungiUtente;
	}

	public Pulsanti getEliminaGruppo() {
		return eliminaGruppo;
	}

	public void setEliminaGruppo(Pulsanti eliminaGruppo) {
		this.eliminaGruppo = eliminaGruppo;
	}

	public Pulsanti getModificaFoto() {
		return modificaFoto;
	}

	public void setModificaFoto(Pulsanti modificaFoto) {
		this.modificaFoto = modificaFoto;
	}
	
}
