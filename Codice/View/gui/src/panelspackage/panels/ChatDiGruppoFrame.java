package panelspackage.panels;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JComponent;
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
    
    private int messaggioCorrente = 0;
    
    private ArrayList<JComponent> ListaEtichetteMessaggi  = new ArrayList<JComponent>();
    private Pulsanti foto, nextMessaggio, prevMessaggio;
    private AreaDiTesto descrizione;
    private InserimentoTesto aggiungi;
    private Pulsanti aggiungiUtente;
    private InserimentoTesto rimuovi;
    private Pulsanti rimuoviUtente;

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
        
        foto = new Pulsanti("C:/Users/aissa/OneDrive/Immagini/We can.jpg");
        JScrollPane panel = new JScrollPane(foto);
        panel.setPreferredSize(new Dimension(500,500));
        containerNorth.add(panel, BorderLayout.PAGE_START);
        
        descrizione = new AreaDiTesto("", 60, 20);
        SpecificContainer containerNorthNorth = new SpecificContainer();
        containerNorthNorth.setLayout(new GridLayout(2, 1));
        this.add(containerNorthNorth, BorderLayout.NORTH);
        containerNorthNorth.add(descrizione);
        containerNorth.add(new Etichette("Inserire la descrizione", Frame.COLOREPRIMARIOTEMATICO) );
        
        
        aggiungi = new InserimentoTesto("", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14), 30);
        aggiungiUtente = new Pulsanti("Aggiungi utente", Frame.COLOREPRIMARIOTEMATICO);
        rimuovi = new InserimentoTesto("", Frame.COLOREPRIMARIOTEMATICO, new Font("Arial", 1, 14), 30);
        rimuoviUtente = new Pulsanti("Rimuovi utente", Frame.COLOREPRIMARIOTEMATICO);
        
        SpecificContainer containerNorthCenter = new SpecificContainer();
        containerNorthCenter.setLayout(new GridLayout(2, 2));
        this.add(containerNorthCenter, BorderLayout.CENTER);
        containerNorthCenter.add(aggiungi);
        containerNorthCenter.add(aggiungiUtente);
        containerNorthCenter.add(rimuovi);
        containerNorthCenter.add(rimuoviUtente);
        
        for(int i = getMessaggioCorrente();  i <  20; i++) {
            Etichette areaMessaggio = new Etichette("" + i, Frame.COLOREPRIMARIOTEMATICO);
            ListaEtichetteMessaggi.add(areaMessaggio);
        }
      
        ListaEtichetteMessaggi.add(nextMessaggio = new  Pulsanti("->", Frame.COLOREPRIMARIOTEMATICO));
        ListaEtichetteMessaggi.add(prevMessaggio = new Pulsanti("<-", Frame.COLOREPRIMARIOTEMATICO));
        
        //SpecificContainer containerCenter = new SpecificContainer(getBackground());
        //add(containerCenter, BorderLayout.CENTER);
        GrigliaDiElementi grigliaMessaggi =  new GrigliaDiElementi(ListaEtichetteMessaggi,20,2, ListaEtichetteMessaggi.size());
        add(grigliaMessaggi, BorderLayout.CENTER);
        
        
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
    

}