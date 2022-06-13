package panelspackage.panels;


import java.awt.BorderLayout;
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


@SuppressWarnings("serial")
public class ChatDiGruppoFrame extends JPanel {
    
    private int messaggioCorrente = 0;
    private ArrayList<JComponent> ListaEtichetteMessaggi  = new ArrayList<JComponent>();
    private Pulsanti foto, nextMessaggio, prevMessaggio;
    private AreaDiTesto descrizione, modificaDesc; 
    private InserimentoTesto aggiungi, rimuovi, scriviMessaggio;
    private Pulsanti rimuoviUtente, aggiungiUtente, invia, home, eliminaGruppo, refresh, modificaDescrizione;
    private JFileChooser modificaFoto;
   
    
    
    public ChatDiGruppoFrame() {
        
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
        
        containerNorth.setLayout(new GridLayout( 4, 1));
        containerNorth.add(new Etichette("Modifica la foto di profilo del gruppo", Frame.COLOREPRIMARIOTEMATICO));
        
        modificaFoto = new JFileChooser();
        containerNorth.add(modificaFoto);
        
        foto = new Pulsanti("/Users/aissa/OneDrive/Immagini/Saved Pictures/roses.jpg");
        JScrollPane panel = new JScrollPane(foto);
        panel.setPreferredSize(new Dimension(60,60));
        containerNorth.add(panel);
        
        descrizione = new AreaDiTesto("", 60, 20);
        SpecificContainer containerNorthNorth = new SpecificContainer();
        containerNorthNorth.setLayout(new GridLayout(2, 1));
        
        containerNorth.add(containerNorthNorth);
        containerNorthNorth.add(new Etichette("Inserire la descrizione", Frame.COLOREPRIMARIOTEMATICO));
        containerNorthNorth.add(descrizione);
        
        for(int i = getMessaggioCorrente();  i <  20; i++) {
            Etichette areaMessaggio = new Etichette("" + i, Frame.COLOREPRIMARIOTEMATICO);
            ListaEtichetteMessaggi.add(areaMessaggio);
        }
        
        
        ListaEtichetteMessaggi.add(nextMessaggio = new  Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO));
        ListaEtichetteMessaggi.add(prevMessaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO));
        
        GrigliaDiElementi grigliaMessaggi =  new GrigliaDiElementi(ListaEtichetteMessaggi,20,2, ListaEtichetteMessaggi.size());
        this.add(grigliaMessaggi, BorderLayout.CENTER);
        
        aggiungi = new InserimentoTesto("", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14), 30);
        aggiungiUtente = new Pulsanti("Aggiungi utente", Frame.COLOREPRIMARIOTEMATICO);
        rimuovi = new InserimentoTesto("", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14), 30);
        rimuoviUtente = new Pulsanti("Rimuovi utente", Frame.COLOREPRIMARIOTEMATICO);
        eliminaGruppo = new Pulsanti("Elimina il gruppo", Frame.COLOREPRIMARIOTEMATICO);
        modificaDesc = new AreaDiTesto("", 60, 20);
        modificaDescrizione = new Pulsanti("Modifica la descrizione del gruppo", Frame.COLOREPRIMARIOTEMATICO);
        
        
        SpecificContainer containerNorthCenter = new SpecificContainer();
        containerNorthCenter.setLayout(new GridLayout(4, 4));
        this.add(containerNorthCenter, BorderLayout.CENTER);
        
        containerNorthCenter.add(aggiungi);
        containerNorthCenter.add(aggiungiUtente);
        containerNorthCenter.add(rimuovi);
        containerNorthCenter.add(rimuoviUtente);
        containerNorthCenter.add(modificaDesc);
        containerNorthCenter.add(modificaDescrizione);
        containerNorthCenter.add(eliminaGruppo);
        
        SpecificContainer containerSouth = new SpecificContainer(Frame.COLOREPRIMARIOTEMATICO);
        this.add(containerSouth, BorderLayout.SOUTH);
        containerSouth.setLayout(new GridLayout(1, 3));
        containerSouth.setVisible(true);
        
        refresh = new Pulsanti("Refresh", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14));
        invia = new Pulsanti("Invia", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14));
        scriviMessaggio = new InserimentoTesto("Scrivi messaggio", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 12), 30);
        
        containerSouth.add(refresh);
  	    containerSouth.add(scriviMessaggio);
        containerSouth.add(invia);
        
        SpecificContainer containerSouthSouth = new SpecificContainer();
        containerSouthSouth.setLayout(new GridLayout(1, 1));
        this.add(containerSouthSouth, BorderLayout.SOUTH);
        
  	  	home = new Pulsanti("Home", Frame.COLOREPRIMARIOTEMATICO, new Font("Times New Roman", 1, 14));
  	  	containerSouthSouth.add(home, BorderLayout.SOUTH);
    }

    
    public boolean aggiornaMessaggi(ArrayList<String> messaggi, String inviante) {
        if(messaggi.size() == 0) {
            return false;
        } 

        for(int i = 0 ; i < 20 && i < messaggi.size() - this.getMessaggioCorrente()/2; i = i + 2) {

            int indiceCorrente2 = i + getMessaggioCorrente();
            ((Etichette)ListaEtichetteMessaggi.get(i)).setText(messaggi.get(indiceCorrente2));
            ((Etichette)ListaEtichetteMessaggi.get(i + 1)).setText(messaggi.get(indiceCorrente2 + 1));
            
            }
        return true;
    }
    
    
    public Pulsanti getFoto() {
        return foto;
    }

    public void setFoto(Pulsanti foto) {
        this.foto = foto;
    }

    public AreaDiTesto getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(AreaDiTesto descrizione) {
        this.descrizione = descrizione;
    }

    public InserimentoTesto getAggiungi() {
        return aggiungi;
    }

    public void setAggiungi(InserimentoTesto aggiungi) {
        this.aggiungi = aggiungi;
    }

    public Pulsanti getAggiungiUtente() {
        return aggiungiUtente;
    }

    public void setAggiungiUtente(Pulsanti aggiungiUtente) {
        this.aggiungiUtente = aggiungiUtente;
    }

    public InserimentoTesto getRimuovi() {
        return rimuovi;
    }

    public void setRimuovi(InserimentoTesto rimuovi) {
        this.rimuovi = rimuovi;
    }

    public Pulsanti getRimuoviUtente() {
        return rimuoviUtente;
    }

    public void setRimuoviUtente(Pulsanti rimuoviUtente) {
        this.rimuoviUtente = rimuoviUtente;
    }

    public Pulsanti getNextMessaggio() {
        return nextMessaggio;
    }

    public void setNextMessaggio(Pulsanti nextMessaggio) {
        this.nextMessaggio = nextMessaggio;
    }

    public Pulsanti getPrevMessaggio() {
        return prevMessaggio;
    }

    public void setPrevMessaggio(Pulsanti prevMessaggio) {
        this.prevMessaggio = prevMessaggio;
    }

    public int getMessaggioCorrente() {
        return messaggioCorrente;
    }

    public void setMessaggioCorrente(int messaggioCorrente) {
        this.messaggioCorrente = messaggioCorrente;
    }

	public InserimentoTesto getScriviMessaggio() {
		return scriviMessaggio;
	}

	public Pulsanti getInvia() {
		return invia;
	}

	public Pulsanti getHome() {
		return home;
	}
    

}